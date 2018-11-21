package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/12
 */

import java.util.List;

/**
 * 工序 实体类
 */
public class Process {
	//工序
	private String processName;
	//工作状态
	private Integer isWorking;
	//焊口编号
	private String weldNum;
	//焊机编号集合
	private List<String> equipCodes;

	@Override
	public String toString() {
		return "Process{" +
				"processName='" + processName + '\'' +
				", isWorking=" + isWorking +
				", weldNum='" + weldNum + '\'' +
				", equipCodes=" + equipCodes +
				'}';
	}

	public List<String> getEquipCodes() {
		return equipCodes;
	}

	public void setEquipCodes(List<String> equipCodes) {
		this.equipCodes = equipCodes;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Integer isWorking) {
		this.isWorking = isWorking;
	}

	public String getWeldNum() {
		return weldNum;
	}

	public void setWeldNum(String weldNum) {
		this.weldNum = weldNum;
	}

}
