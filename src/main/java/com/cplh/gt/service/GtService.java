package com.cplh.gt.service;

/**
 * Author: liuhongli.
 * Date: 2018/11/16
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.cplh.gt.bean.*;
import com.cplh.gt.bean.Process;
import com.cplh.gt.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 工况逻辑处理
 */
@Service
public class GtService {


	@Autowired
	HjInfoDao hjInfoDao;
	@Autowired
	TestDao testDao;

	@Autowired
	ConEquipReDao conEquipReDao;

	@Autowired
	PrWeldReationDao prWeldReationDao;

	@Autowired
	PrWeldLimitDao prWeldLimitDao;

	@Autowired
	HjZpDao hjZpDao;
	@Autowired
	StringRedisTemplate ss;

	static Map<String, ConEquipRelation> relationMap;


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
	double s_up = 0;       //送丝速度上限
	double c_up = 0;       //电流上限
	double v_up = 0;       //电压上限
	double s_low = 0;
	double c_low = 0;
	double v_low = 0;


	/**
	 * 查询当前所有工序
	 *
	 * @return
	 */
	public QueryPro queryPro() {
		QueryPro out = new QueryPro();
		HashMap<String, Process> data = new HashMap<>();
		//创建查询对象 设置当前查询表名
		ConHjInfo queryParam = new ConHjInfo();
		queryParam.setTableName("con_hj_info");
		List<ConHjInfo> result = hjInfoDao.queryPro(queryParam);
		//检测返回数据
		if (result == null || result.size() == 0) {
			out.setSuccess(true);
			out.set_MSG_("查询成功 0条数据");
			logger.info(out.toString());
			return out;
		}

		//处理返回数据
		Iterator<ConHjInfo> iterator = result.iterator();
		while (iterator.hasNext()) {
			ConHjInfo next = iterator.next();
			//查找是否出现过该工序数据
			if (relationMap == null)
				getRelation();
			ConEquipRelation conEquipRelation = relationMap.get(next.getEquipCode());
			if (conEquipRelation == null) {
				out.setSuccess(false);
				out.set_MSG_("未在关系表中发现此焊机数据");
				return out;
			}
			String equipType = conEquipRelation.getEquipType();
			if (!equipType.equals("GH"))
				equipType = equipType.substring(0, equipType.length() - 2);

			Process process = data.get(equipType);
			if (process == null) {
				process = new Process();
				process.setIsWorking(1);
				process.setProcessName(next.getWeldLayer());
				process.setWeldNum(next.getWeldCode());
				ArrayList<String> equipCodes = new ArrayList<>();
				equipCodes.add(next.getEquipCode());
				process.setEquipCodes(equipCodes);
				data.put(equipType, process);

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

		//if (!layer.equals("GH"))
		//	layer = layer.substring(0, layer.length() - 2);

		data.put("pro1", pro1);
		data.put("pro2", pro2);
		//如果是根焊 初始化三四焊枪备用
		if (layer != null && layer.equals("GH")) {
			hq3 = new ArrayList<>();
			hq4 = new ArrayList<>();
			pro3 = new ProcessInfo();
			pro4 = new ProcessInfo();
			data.put("pro3", pro3);
			data.put("pro4", pro4);
		}

		//查询该焊口的所有数据
		System.out.println(weldCode);
		List<ConHjInfo> conHjInfos = hjInfoDao.queryAllByWeld("con_hj_info", weldCode, hj_code);
		if (conHjInfos != null) {
			Iterator<ConHjInfo> iterator = conHjInfos.iterator();
			//遍历 分解所有数据
			while (iterator.hasNext()) {
				ConHjInfo next = iterator.next();
				if (next.getHqNum().equals("HQ01") || next.getHqNum().equals("hq05"))
					hq1.add(next);
				else if (next.getHqNum().equals("HQ02") || next.getHqNum().equals("hq06"))
					hq2.add(next);
				else if (next.getHqNum().equals("HQ03") || next.getHqNum().equals("hq07"))
					hq3.add(next);
				else if (next.getHqNum().equals("HQ04") || next.getHqNum().equals("hq08"))
					hq4.add(next);
			}
			//根据焊口获取规范值
			PrWeldLimit prWeldLimit = hjInfoDao.queryLimitByWeld(weldCode, layer);
			//调用验收方法 为返回对象封装数据
			ysDate(pro1, hq1, prWeldLimit);
			ysDate(pro2, hq2, prWeldLimit);
			if (pro3 != null) {
				ysDate(pro3, hq3, prWeldLimit);
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
	 * 验收实时数据方法
	 *
	 * @param weld_code
	 * @return
	 */
	public YsInfo info(String weld_code) {
		//返回一级对象
		YsInfo out = new YsInfo();
		//中频集合
		ArrayList<YsDate> zpList = new ArrayList<>();
		//焊接焊机集合
		HashMap<String, Map<String, List<ConHjInfo>>> map = new HashMap<>();

		//获取中频加热数据
		List<ConHjZp> allByWeld = hjZpDao.getAllByWeld(weld_code);
		//验收中频数据
		YsDate upZp = ys(allByWeld, "temp00", "ZP", null, ConHjZp.class);
		upZp.setIndex(1);
		YsDate lowZp = ys(allByWeld, "temp06", "ZP", null, ConHjZp.class);
		lowZp.setIndex(2);
		zpList.add(upZp);
		zpList.add(lowZp);
		out.setHeatList(zpList);


		//获取焊接数据
		List<ConHjInfo> infoList = hjInfoDao.getAllByWeld(weld_code);
		if (infoList != null) {
			//按焊机分组
			Iterator<ConHjInfo> iterator = infoList.iterator();
			while (iterator.hasNext()) {
				ConHjInfo next = iterator.next();
				Map<String, List<ConHjInfo>> hjMap = map.get(next.getEquipCode());   //根据焊机编号 将相关数据分类封装
				if (hjMap != null) {
					List<ConHjInfo> hqList = hjMap.get(next.getHqNum());            //根据焊枪数据 将数据分类封装
					if (hqList != null)
						hqList.add(next);
					else {
						hqList = new ArrayList<>();
						hjMap.put(next.getHqNum(), hqList);
					}
				} else {
					hjMap = new HashMap<>();
					List<ConHjInfo> hqList = new ArrayList<>();
					hjMap.put(next.getHqNum(), hqList);
					map.put(next.getEquipCode(), hjMap);
				}
			}
			ArrayList<YsHj> ysList = new ArrayList<>();
			//验收焊接数据
			int hj_inddex = 1;
			int hq_index = 1;
			Set<Map.Entry<String, Map<String, List<ConHjInfo>>>> entries = map.entrySet(); //所有的焊接机组集合 键 为焊机
			for (Map.Entry<String, Map<String, List<ConHjInfo>>> entry : entries) {
				String key = entry.getKey();
				Map<String, List<ConHjInfo>> value = entry.getValue();
				Set<Map.Entry<String, List<ConHjInfo>>> entries1 = value.entrySet();
				//根据焊机编号 获取当前工序 与规范值
				if (relationMap == null)
					getRelation();
				ConEquipRelation rel = relationMap.get(key);
				//ConEquipRelation rel = conEquipReDao.queryByEquip(key);
				PrWeldLimit prWeldLimit = null;
				String gx = "";
				if (rel != null) {
					gx = rel.getEquipType();
					if (!gx.equals("GH"))
						gx = gx.substring(0, gx.length() - 2);
					//获取规范值
					prWeldLimit = prWeldLimitDao.queryByweldCodePro(weld_code, gx);
				}
				//创建返回 焊机对象
				YsHj ysHj = new YsHj();
				ysHj.setSKILL_NAME(gx); //工序
				ysHj.setM_NAME(key);    //焊机
				ysHj.setM_index(hj_inddex); //排序
				hj_inddex++;
				ArrayList<YsHq> hqList = new ArrayList<>();
				for (Map.Entry<String, List<ConHjInfo>> stringListEntry : entries1) {
					String key1 = stringListEntry.getKey();
					List<ConHjInfo> value1 = stringListEntry.getValue();
					//创建焊枪对象
					YsHq ysHq = new YsHq();
					ysHq.setWeld_index(hq_index);
					ysHq.setName(key1);
					ArrayList<YsDate> ysDates = new ArrayList<>();
					YsDate hjSpeed = ys(value1, "speed", gx, prWeldLimit, ConHjInfo.class);
					hjSpeed.setIndex(1);
					YsDate current = ys(value1, "current", gx, prWeldLimit, ConHjInfo.class);
					current.setIndex(2);
					YsDate voltage = ys(value1, "voltage", gx, prWeldLimit, ConHjInfo.class);
					voltage.setIndex(3);
					//封装数据
					ysDates.add(hjSpeed);
					ysDates.add(current);
					ysDates.add(voltage);
					ysHq.setDataList(ysDates);
					hqList.add(ysHq);
					hq_index++;
				}
				ysHj.setGunList(hqList);
				ysList.add(ysHj);
			}
			out.setWeldList(ysList);
		}
		out.set_time_(new Date());
		out.set_msg_("同步成功");
		return out;
	}

	/**
	 * 验收方法
	 *
	 * @param paramList
	 * @param name      验收字段名
	 * @param limitName 验收工序名 如果 工序不为ZP且limit为空 则规范值为0 0
	 * @param limit     规范值实体
	 * @param <T>       具体验收类型
	 * @return
	 */
	private <T extends ConHj> YsDate ys(List<T> paramList, String name, String limitName, PrWeldLimit limit, Class T) {
		YsDate ysDate = new YsDate();
		if (paramList != null) {
			//将结合转换成对应泛型
			List<T> paramList1 = (List<T>) paramList;
			//初始化对象
			//最大 做小值
			Double max = 0d;
			Double min = 0d;
			//规范值
			double lim_up = 150;
			double lim_low = 0;
			long CXstart = 0L;  // 超限开始时间
			long CXend = 0L;    // 超限结束时间
			long CXsum = 0L;    // 超限总时间
			long sum = 0L;      // 工序总时间
			//如果不是中频
			if (!"ZP".equals(limitName)) {
				if (limit != null && "speed".equals(name)) {
					lim_up = limit.getSpeedUpperLimit();
					lim_low = limit.getSpeedLowerLimit();

				} else if (limit != null && "current".equals(name)) {
					lim_up = limit.getCurrentUpperLimit();
					lim_low = limit.getCurrentLowerLimit();

				} else if (limit != null && "voltage".equals(name)) {
					lim_up = limit.getVoltageUpperLimit();
					lim_low = limit.getVoltageUpperLimit();

				} else {
					lim_up = 0;
					lim_low = 0;
				}
			}
			//验收数据
			for (T t : paramList1) {
				double value = 0;
				if("current".equals(name))
					value = t.getCurrent();
				else if("temo00".equals(name))
					value = t.getTemp00();
				else if("temo06".equals(name))
					value = t.getTemp06();
				else if("speed".equals(name))
					value = t.getSpeed();
				else if("voltage".equals(name))
					value = t.getVoltage();


				long time = t.getTs().getTime();
				//更新最大最小值
				if (max < value) max = value;
				if (min > value) min = value;
				//更新 主表超限数据字段 记录超限开始时间
				if (value > lim_up) {
					if (CXstart == 0) {
						CXstart = time;
					}
				} else if (value < lim_low) {
					if (CXstart == 0) {
						CXstart = time;
					}
				} else {
					//合格数据 设为超限结束时间 累加总时间
					CXend = time;
					if (CXstart != 0) {
						CXsum += CXend - CXstart;
						CXstart = 0;
					}
				}
			}

			//保留小数点后两位
			double cXsum = CXsum;
			double v = ((int) (cXsum / sum * 10000)) / 100.0;
			v = 100 - v;
			ysDate.setRate(v);
			CXstart = 0;
			CXend = 0;
			CXsum = 0;
			ysDate.setMax(max);
			ysDate.setMax_r(lim_up);
			ysDate.setMin(min);
			ysDate.setMin_r(lim_low);
			ysDate.setName(name);
		}
		return ysDate;
	}

	/**
	 * 折线图封装数据方法
	 *
	 * @param pro
	 * @return
	 */
	synchronized void ysDate(ProcessInfo pro, List<ConHjInfo> conHjInfos, PrWeldLimit prWeldLimit) {
		if (conHjInfos != null) {
			//初始化规范值
			if (prWeldLimit != null) {
				s_up = prWeldLimit.getSpeedUpperLimit();
				c_up = prWeldLimit.getSpeedLowerLimit();
				v_up = prWeldLimit.getVoltageUpperLimit();
				s_low = prWeldLimit.getVoltageLowerLimit();
				c_low = prWeldLimit.getCurrentUpperLimit();
				v_low = prWeldLimit.getCurrentLowerLimit();
				pro.setSpeedMax(s_up);
				pro.setSpeedMin(s_low);
				pro.setVoltageMax(v_up);
				pro.setVoltageMin(v_low);
				pro.setCurrentMax(c_up);
				pro.setCurrentMin(c_low);
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
	}

	/**
	 * 同步焊口 工艺规程编号到现场
	 *
	 * @param weld_code
	 * @param pr_no
	 * @return
	 */
	public QueryPro sysWeldPro(String weld_code, String pr_no) {
		QueryPro out = new QueryPro();
		HashMap<String, Object> objectObjectHashMap = new HashMap<>();
		Integer flag = prWeldReationDao.checkByWeld(weld_code);
		if (flag > 0) {
			out.setSuccess(false);
			out.setData(objectObjectHashMap);
			out.set_MSG_("该数据已存在");
			return out;
		}
		Integer insert = prWeldReationDao.insert(weld_code, pr_no);
		out.setSuccess(true);
		objectObjectHashMap.put("count", insert);
		out.setData(objectObjectHashMap);
		out.set_MSG_("同步成功");
		return out;
	}

	private void getRelation() {
		List<ConEquipRelation> relationList = conEquipReDao.getAll();
		relationMap = new HashMap<>();
		for (ConEquipRelation conEquipRelation : relationList) {
			relationMap.put(conEquipRelation.getEquipCodeZxj(), conEquipRelation);
		}
	}

	/**
	 * 测试缓存
	 * @param id
	 * @return
	 */
	//@Cacheable("test")
	@CachePut("test")
	public Test getTest(Integer id) {
		System.out.println("这个方法被调用了");
		Test testById = testDao.getTestById(id);
		return testById;
	}
}
