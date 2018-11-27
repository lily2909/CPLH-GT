package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */

import java.util.List;

/**
 * 验收 焊枪实体
 */
public class YsHq {

	//焊枪名
	private String name;
	//排序
	private Integer weld_index;
	//详情集合
	private List<YsDate> dataList;

	@Override
	public String toString() {
		return "YsHq{" +
				"name='" + name + '\'' +
				", weld_index=" + weld_index +
				", dataList=" + dataList +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeld_index() {
		return weld_index;
	}

	public void setWeld_index(Integer weld_index) {
		this.weld_index = weld_index;
	}

	public List<YsDate> getDataList() {
		return dataList;
	}

	public void setDataList(List<YsDate> dataList) {
		this.dataList = dataList;
	}
}
