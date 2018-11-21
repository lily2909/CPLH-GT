package com.cplh.gt.service;

/**
 * Author: liuhongli.
 * Date: 2018/11/16
 */

import com.cplh.gt.bean.*;
import com.cplh.gt.bean.Process;
import com.cplh.gt.dao.HjInfoDao;
import com.cplh.gt.dao.PrWeldReationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 工况逻辑处理
 */
@Service
public class GtService {
	@Autowired
	HjInfoDao hjInfoDao;

	@Autowired
	PrWeldReationDao prWeldReationDao;

	Logger logger = LoggerFactory.getLogger(GtService.class);

	long s_CXstart = 0L;  // 送丝速度超限开始时间
	long s_CXend = 0L;    // 送丝速度超限结束时间
	long s_CXsum = 0L;    // 送丝速度超限总时间
	long c_CXstart = 0L;  // 电流超限开始时间
	long c_CXend = 0L;    // 电流超限结束时间
	long c_CXsum = 0L;    // 电流超限总时间
	long v_CXstart = 0L;  // 电压超限开始时间
	long v_CXend = 0L;    // 电压超限结束时间
	long v_CXsum = 0L;    // 电压超限总时间
	int s_up = 0;       //送丝速度上限
	int c_up = 0;       //电流上限
	int v_up = 0;       //电压上限
	int s_low = 0;
	int c_low = 0;
	int v_low = 0;


	/**
	 * 查询当前所有工序
	 *
	 * @return
	 */
	public QueryPro queryPro() {
		QueryPro out = new QueryPro();
		HashMap<String, Object> data = new HashMap<>();
		//创建查询对象 设置当前查询表名
		ConHjInfo queryParam = new ConHjInfo();
		queryParam.setTableName("con_hj_info");
		List<ConHjInfo> result = hjInfoDao.queryPro(queryParam);
		//检测返回数据
		if (result == null || result.size() == 0) {
			out.setSuccess(true);
			out.set_MSG_("查询失败");
			logger.info(out.toString());
			return out;
		}

		//处理返回数据
		Iterator<ConHjInfo> iterator = result.iterator();
		while (iterator.hasNext()) {
			ConHjInfo next = iterator.next();
			//查找是否出现过该工序数据
			Process process = (Process) data.get(next.getWeldLayer());
			if (process == null) {
				process = new Process();
				process.setProcessName(next.getWeldLayer());
				process.setWeldNum(next.getWeldCode());
				ArrayList<String> equipCodes = new ArrayList<>();
				equipCodes.add(next.getEquipCode());
				process.setEquipCodes(equipCodes);
				data.put(next.getWeldLayer(), process);

			} else {
				//更新已有工序数据的焊机列表
				List<String> equipCodes = process.getEquipCodes();
				equipCodes.add(next.getEquipCode());
				process.setEquipCodes(equipCodes);
			}
		}
		out.setSuccess(true);
		out.setData(data);
		logger.info(out.toString());
		out.set_MSG_("查询成功 返回了好多数据");
		return out;
	}

	/**
	 * 点击工序接口 返回当前工序 当前焊机的最近一条数据
	 *
	 * @param layer
	 * @param hj_code
	 * @return
	 */
	public QueryPro clickPro(String layer, String hj_code, String weldCode) {

		//创建返回一级对象
		QueryPro out = new QueryPro();
		//保存返回数据
		HashMap<String, Object> data = new HashMap<>();
		//以焊枪为维度 保存详细信息
		ArrayList<ConHjInfo> hq1 = new ArrayList<>();
		ArrayList<ConHjInfo> hq2 = new ArrayList<>();
		ArrayList<ConHjInfo> hq3 = null;
		ArrayList<ConHjInfo> hq4 = null;
		//创建返回 二级对象
		ProcessInfo pro1 = new ProcessInfo();
		ProcessInfo pro2 = new ProcessInfo();
		ProcessInfo pro3 = null;
		ProcessInfo pro4 = null;
		data.put("pro1", pro1);
		data.put("pro2", pro2);
		//如果是根焊 初始化三四焊枪备用
		if (layer != null && layer.equals("NH")) {
			hq3 = new ArrayList<>();
			hq4 = new ArrayList<>();
			pro3 = new ProcessInfo();
			pro4 = new ProcessInfo();
			data.put("pro3", pro3);
			data.put("pro4", pro4);
		}

		//查询该焊口的所有数据
		List<ConHjInfo> conHjInfos = hjInfoDao.queryAllByWeld("con_hj_info", "weldcode", hj_code);
		if (conHjInfos != null) {
			Iterator<ConHjInfo> iterator = conHjInfos.iterator();
			//遍历 分解所有数据
			while (iterator.hasNext()) {
				ConHjInfo next = iterator.next();
				if (next.getHqNum().equals("hq01") || next.getHqNum().equals("hq05"))
					hq1.add(next);
				else if (next.getHqNum().equals("hq02") || next.getHqNum().equals("hq06"))
					hq2.add(next);
				else if (next.getHqNum().equals("hq03") || next.getHqNum().equals("hq07"))
					hq3.add(next);
				else if (next.getHqNum().equals("hq04") || next.getHqNum().equals("hq08"))
					hq4.add(next);
			}
			//根据焊口获取规范值
			PrWeldLimit prWeldLimit = hjInfoDao.queryLimitByWeld(weldCode, layer);
			//调用验收方法 为返回对象封装数据
			ysDate(pro1, hq1, prWeldLimit);
			ysDate(pro2, hq2, prWeldLimit);
			if (pro3 != null) {
				ysDate(pro4, hq3, prWeldLimit);
				ysDate(pro4, hq4, prWeldLimit);
			}


		}
		out.setSuccess(true);
		out.setData(data);
		logger.info(out.toString());
		out.set_MSG_("查询成功 返回了好多数据");
		return out;
	}


	/**
	 * 抽取验收方法
	 *
	 * @param pro
	 * @return
	 */
	synchronized void ysDate(ProcessInfo pro, List<ConHjInfo> conHjInfos, PrWeldLimit prWeldLimit) {
		//初始化规范值
		if (prWeldLimit != null) {
			s_up = prWeldLimit.getSpeedUpperLimit();
			c_up = prWeldLimit.getSpeedLowerLimit();
			v_up = prWeldLimit.getVoltageUpperLimit();
			s_low = prWeldLimit.getVoltageLowerLimit();
			c_low = prWeldLimit.getCurrentUpperLimit();
			v_low = prWeldLimit.getCurrentLowerLimit();
		}
		ConHjInfo newPro = conHjInfos.get(conHjInfos.size() - 1);
		//设置最新数据
		pro.setCurrent(newPro.getCurrent());
		pro.setVoltage(newPro.getVoltage());
		pro.setSpeed(newPro.getSpeed());
		pro.setWeldNum(newPro.getWeldCode());
		pro.setHqNum(newPro.getHqNum());
		// 工序总时间
		long sum = newPro.getTs().getTime() - conHjInfos.get(0).getTs().getTime();
		for (ConHjInfo conHjInfo : conHjInfos) {
			//获取对应验收数据
			double value_c = conHjInfo.getCurrent() * 1.0;
			double value_s = conHjInfo.getSpeed() * 1.0;
			double value_v = conHjInfo.getVoltage() * 1.0;
			long time = conHjInfo.getTs().getTime();

			//判断电流
			if (value_c > c_up) {
				if (c_CXstart == 0) {
					c_CXstart = time;
				}
			} else if (value_c < c_low) {
				if (c_CXstart == 0) {
					c_CXstart = time;
				}
			} else {
				//合格数据 设为超限结束时间 累加总时间
				c_CXend = time;
				if (c_CXstart != 0) {
					c_CXsum += c_CXend - c_CXstart;
					c_CXstart = 0;
				}
			}
			//判断电压
			if (value_v > v_up) {
				if (v_CXstart == 0) {
					v_CXstart = time;
				}
			} else if (value_v < v_low) {
				if (v_CXstart == 0) {
					v_CXstart = time;
				}
			} else {
				//合格数据 设为超限结束时间 累加总时间
				v_CXend = time;
				if (v_CXstart != 0) {
					v_CXsum += v_CXend - v_CXstart;
					v_CXstart = 0;
				}
			}
			//判断送丝速度
			if (value_s > c_up) {
				if (s_CXstart == 0) {
					s_CXstart = time;
				}
			} else if (value_s < c_low) {
				if (s_CXstart == 0) {
					s_CXstart = time;
				}
			} else {
				//合格数据 设为超限结束时间 累加总时间
				s_CXend = time;
				if (s_CXstart != 0) {
					s_CXsum += s_CXend - s_CXstart;
					s_CXstart = 0;
				}
			}


		}
		//保留小数点后两位
		double c_cXsum = c_CXsum;
		double c_v = ((int) (c_cXsum / sum * 10000)) / 100.0;
		c_v = 100 - c_v;
		//保留小数点后两位
		double v_cXsum = v_CXsum;
		double v_v = ((int) (v_cXsum / sum * 10000)) / 100.0;
		v_v = 100 - v_v;
		//保留小数点后两位
		double s_cXsum = s_CXsum;
		double s_v = ((int) (s_cXsum / sum * 10000)) / 100.0;
		s_v = 100 - s_v;

		pro.setVoltageScale(v_v);
		pro.setSpeedScale(s_v);
		pro.setCurrentScale(c_v);
		s_CXstart = 0L;
		s_CXend = 0L;
		s_CXsum = 0L;
		c_CXstart = 0L;
		c_CXend = 0L;
		c_CXsum = 0L;
		v_CXstart = 0L;
		v_CXend = 0L;
		v_CXsum = 0L;
		s_up = 0;
		c_up = 0;
		v_up = 0;
		s_low = 0;
		c_low = 0;
		v_low = 0;
	}

	/**
	 * 同步焊口 工艺规程编号到现场
	 *
	 * @param weld_code
	 * @param pr_no
	 * @return
	 */
	public QueryPro sysWeldPro(String weld_code, String pr_no) {
		Integer insert = prWeldReationDao.insert(weld_code, pr_no);
		QueryPro out = new QueryPro();
		out.setSuccess(true);
		HashMap<String, Object> objectObjectHashMap = new HashMap<>();
		objectObjectHashMap.put("count",insert);
		out.setData(objectObjectHashMap);
		out.set_MSG_("同步成功");
		return out;
	}
}
