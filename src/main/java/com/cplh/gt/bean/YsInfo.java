package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */

import java.util.Date;
import java.util.List;

/**
 * 验收详情数据实体类
 */
public class YsInfo {

	//标段号
	private String bid;
	//焊口号
	private String id;
	//机组
	private String group;
	//时间
	private Date _time_;
	//信息
	private String _msg_;
	//热焊
	private List<YsDate>    heatList;
	//焊接集合
	private List<YsHj>   weldList;

	@Override
	public String toString() {
		return "YsInfo{" +
				"bid='" + bid + '\'' +
				", id='" + id + '\'' +
				", group='" + group + '\'' +
				", _time_=" + _time_ +
				", _msg_='" + _msg_ + '\'' +
				", heatList=" + heatList +
				", weldList=" + weldList +
				'}';
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date get_time_() {
		return _time_;
	}

	public void set_time_(Date _time_) {
		this._time_ = _time_;
	}

	public String get_msg_() {
		return _msg_;
	}

	public void set_msg_(String _msg_) {
		this._msg_ = _msg_;
	}

	public List<YsDate> getHeatList() {
		return heatList;
	}

	public void setHeatList(List<YsDate> heatList) {
		this.heatList = heatList;
	}

	public List<YsHj> getWeldList() {
		return weldList;
	}

	public void setWeldList(List<YsHj> weldList) {
		this.weldList = weldList;
	}
}
