package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/27
 */

import java.sql.Timestamp;

/**
 * 焊接对象通用实体
 */
public class ConHj {
	private String temp00;
	private String temp06;
	private Timestamp ts;
	private Long current;
	private Long voltage;
	private Long speed;

	@Override
	public String toString() {
		return "ConHj{" +
				"temp00='" + temp00 + '\'' +
				", temp06='" + temp06 + '\'' +
				", ts=" + ts +
				", current=" + current +
				", voltage=" + voltage +
				", speed=" + speed +
				'}';
	}

	public String getTemp00() {
		return temp00;
	}

	public void setTemp00(String temp00) {
		this.temp00 = temp00;
	}

	public String getTemp06() {
		return temp06;
	}

	public void setTemp06(String temp06) {
		this.temp06 = temp06;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Long getCurrent() {
		return current;
	}

	public void setCurrent(Long current) {
		this.current = current;
	}

	public Long getVoltage() {
		return voltage;
	}

	public void setVoltage(Long voltage) {
		this.voltage = voltage;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}
}
