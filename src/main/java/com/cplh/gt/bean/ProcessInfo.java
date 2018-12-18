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
	private Double speedMax;
	private Double speedMin;
	//电压
	private Long voltage;
	private Double voltageScale;
	private Double voltageMax;
	private Double voltageMin;
	//电流
	private Long current;
	private Double currentScale;
	private Double currentMax;
	private Double currentMin;




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

	public Double getSpeedMax() {
		return speedMax;
	}

	public void setSpeedMax(Double speedMax) {
		this.speedMax = speedMax;
	}

	public Double getSpeedMin() {
		return speedMin;
	}

	public void setSpeedMin(Double speedMin) {
		this.speedMin = speedMin;
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

	public Double getVoltageMax() {
		return voltageMax;
	}

	public void setVoltageMax(Double voltageMax) {
		this.voltageMax = voltageMax;
	}

	public Double getVoltageMin() {
		return voltageMin;
	}

	public void setVoltageMin(Double voltageMin) {
		this.voltageMin = voltageMin;
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

	public Double getCurrentMax() {
		return currentMax;
	}

	public void setCurrentMax(Double currentMax) {
		this.currentMax = currentMax;
	}

	public Double getCurrentMin() {
		return currentMin;
	}

	public void setCurrentMin(Double currentMin) {
		this.currentMin = currentMin;
	}
}
