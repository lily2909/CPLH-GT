package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */

import java.util.List;

/**
 * 验收数据 焊机实体
 */
public class YsHj {
	//焊机名
	private String M_NAME;
	//工序
	private String SKILL_NAME;
	//排序
	private Integer m_index;
	//焊枪集合
	private List<YsHq> gunList;

	@Override
	public String toString() {
		return "YsHj{" +
				"M_NAME='" + M_NAME + '\'' +
				", SKILL_NAME='" + SKILL_NAME + '\'' +
				", m_index=" + m_index +
				", gunList=" + gunList +
				'}';
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}

	public String getSKILL_NAME() {
		return SKILL_NAME;
	}

	public void setSKILL_NAME(String SKILL_NAME) {
		this.SKILL_NAME = SKILL_NAME;
	}

	public Integer getM_index() {
		return m_index;
	}

	public void setM_index(Integer m_index) {
		this.m_index = m_index;
	}

	public List<YsHq> getGunList() {
		return gunList;
	}

	public void setGunList(List<YsHq> gunList) {
		this.gunList = gunList;
	}
}
