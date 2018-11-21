package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/12
 */


/**
 * 工序详细信息
 */
public class ProcessInfo {
	//焊口
	private String weldNum;
	//焊枪编号
	private String hqNum;
	//送丝速度
	private Long speed;
	private Double speedScale;
	//电压
	private Long voltage;
	private Double voltageScale;
	//电流
	private Long current;
	private Double currentScale;

	@Override
	public String toString() {
		return "ProcessInfo{" +
				"weldNum='" + weldNum + '\'' +
				", hqNum=" + hqNum +
				", speed=" + speed +
				", speedScale=" + speedScale +
				", voltage=" + voltage +
				", voltageScale=" + voltageScale +
				", current=" + current +
				", currentScale=" + currentScale +
				'}';
	}

	public String getWeldNum() {
		return weldNum;
	}

	public void setWeldNum(String weldNum) {
		this.weldNum = weldNum;
	}

	public String getHqNum() {
		return hqNum;
	}

	public void setHqNum(String hqNum) {
		this.hqNum = hqNum;
	}

	public Long getSpeed() {
		return speed;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public Double getSpeedScale() {
		return speedScale;
	}

	public void setSpeedScale(Double speedScale) {
		this.speedScale = speedScale;
	}

	public Long getVoltage() {
		return voltage;
	}

	public void setVoltage(Long voltage) {
		this.voltage = voltage;
	}

	public Double getVoltageScale() {
		return voltageScale;
	}

	public void setVoltageScale(Double voltageScale) {
		this.voltageScale = voltageScale;
	}

	public Long getCurrent() {
		return current;
	}

	public void setCurrent(Long current) {
		this.current = current;
	}

	public Double getCurrentScale() {
		return currentScale;
	}

	public void setCurrentScale(Double currentScale) {
		this.currentScale = currentScale;
	}
}
