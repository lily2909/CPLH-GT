package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */

/**
 * 验收热焊实体
 */
public class YsDate {

	//规范最大值
	private Integer max;
	//规范最小值
	private Integer min;
	//实际最大值
	private Integer max_r;
	//实际最小值
	private Integer min_r;
	//合格数据占比
	private Float rate;
	//点位名 0点 6点  送丝速度 电流 电压
	private String  name;
	//序号
	private Integer index;

	@Override
	public String toString() {
		return "YsDate{" +
				"max=" + max +
				", min=" + min +
				", max_r=" + max_r +
				", min_r=" + min_r +
				", rate=" + rate +
				", name='" + name + '\'' +
				", index=" + index +
				'}';
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax_r() {
		return max_r;
	}

	public void setMax_r(Integer max_r) {
		this.max_r = max_r;
	}

	public Integer getMin_r() {
		return min_r;
	}

	public void setMin_r(Integer min_r) {
		this.min_r = min_r;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
