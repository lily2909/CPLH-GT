package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


public class PrWeldLimit {
	private String prNo;
	private String specType;
	private Integer currentUpperLimit;
	private Integer currentLowerLimit;
	private Integer voltageUpperLimit;
	private Integer voltageLowerLimit;
	private Integer speedUpperLimit;
	private Integer speedLowerLimit;
	private Integer speedUnit;
	private Integer gasFlowUpperLimit;
	private Integer gasFlowLowerLimit;
	private Integer gasFlowUnit;
	private Integer weldSpeedUpperLimit;
	private Integer weldSpeedLowerLimit;
	private String weldSpeedUnit;
	private String fillMaterialType;
	private String fillMaterialSpec;
	private String weldDirection;

	@Override
	public String toString() {
		return "PrWeldLimit{" +
				"prNo='" + prNo + '\'' +
				", specType='" + specType + '\'' +
				", currentUpperLimit=" + currentUpperLimit +
				", currentLowerLimit=" + currentLowerLimit +
				", voltageUpperLimit=" + voltageUpperLimit +
				", voltageLowerLimit=" + voltageLowerLimit +
				", speedUpperLimit=" + speedUpperLimit +
				", speedLowerLimit=" + speedLowerLimit +
				", speedUnit=" + speedUnit +
				", gasFlowUpperLimit=" + gasFlowUpperLimit +
				", gasFlowLowerLimit=" + gasFlowLowerLimit +
				", gasFlowUnit=" + gasFlowUnit +
				", weldSpeedUpperLimit=" + weldSpeedUpperLimit +
				", weldSpeedLowerLimit=" + weldSpeedLowerLimit +
				", weldSpeedUnit='" + weldSpeedUnit + '\'' +
				", fillMaterialType='" + fillMaterialType + '\'' +
				", fillMaterialSpec='" + fillMaterialSpec + '\'' +
				", weldDirection='" + weldDirection + '\'' +
				'}';
	}

	public String getPrNo() {
		return prNo;
	}

	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}

	public String getSpecType() {
		return specType;
	}

	public void setSpecType(String specType) {
		this.specType = specType;
	}

	public Integer getCurrentUpperLimit() {
		return currentUpperLimit;
	}

	public void setCurrentUpperLimit(Integer currentUpperLimit) {
		this.currentUpperLimit = currentUpperLimit;
	}

	public Integer getCurrentLowerLimit() {
		return currentLowerLimit;
	}

	public void setCurrentLowerLimit(Integer currentLowerLimit) {
		this.currentLowerLimit = currentLowerLimit;
	}

	public Integer getVoltageUpperLimit() {
		return voltageUpperLimit;
	}

	public void setVoltageUpperLimit(Integer voltageUpperLimit) {
		this.voltageUpperLimit = voltageUpperLimit;
	}

	public Integer getVoltageLowerLimit() {
		return voltageLowerLimit;
	}

	public void setVoltageLowerLimit(Integer voltageLowerLimit) {
		this.voltageLowerLimit = voltageLowerLimit;
	}

	public Integer getSpeedUpperLimit() {
		return speedUpperLimit;
	}

	public void setSpeedUpperLimit(Integer speedUpperLimit) {
		this.speedUpperLimit = speedUpperLimit;
	}

	public Integer getSpeedLowerLimit() {
		return speedLowerLimit;
	}

	public void setSpeedLowerLimit(Integer speedLowerLimit) {
		this.speedLowerLimit = speedLowerLimit;
	}

	public Integer getSpeedUnit() {
		return speedUnit;
	}

	public void setSpeedUnit(Integer speedUnit) {
		this.speedUnit = speedUnit;
	}

	public Integer getGasFlowUpperLimit() {
		return gasFlowUpperLimit;
	}

	public void setGasFlowUpperLimit(Integer gasFlowUpperLimit) {
		this.gasFlowUpperLimit = gasFlowUpperLimit;
	}

	public Integer getGasFlowLowerLimit() {
		return gasFlowLowerLimit;
	}

	public void setGasFlowLowerLimit(Integer gasFlowLowerLimit) {
		this.gasFlowLowerLimit = gasFlowLowerLimit;
	}

	public Integer getGasFlowUnit() {
		return gasFlowUnit;
	}

	public void setGasFlowUnit(Integer gasFlowUnit) {
		this.gasFlowUnit = gasFlowUnit;
	}

	public Integer getWeldSpeedUpperLimit() {
		return weldSpeedUpperLimit;
	}

	public void setWeldSpeedUpperLimit(Integer weldSpeedUpperLimit) {
		this.weldSpeedUpperLimit = weldSpeedUpperLimit;
	}

	public Integer getWeldSpeedLowerLimit() {
		return weldSpeedLowerLimit;
	}

	public void setWeldSpeedLowerLimit(Integer weldSpeedLowerLimit) {
		this.weldSpeedLowerLimit = weldSpeedLowerLimit;
	}

	public String getWeldSpeedUnit() {
		return weldSpeedUnit;
	}

	public void setWeldSpeedUnit(String weldSpeedUnit) {
		this.weldSpeedUnit = weldSpeedUnit;
	}

	public String getFillMaterialType() {
		return fillMaterialType;
	}

	public void setFillMaterialType(String fillMaterialType) {
		this.fillMaterialType = fillMaterialType;
	}

	public String getFillMaterialSpec() {
		return fillMaterialSpec;
	}

	public void setFillMaterialSpec(String fillMaterialSpec) {
		this.fillMaterialSpec = fillMaterialSpec;
	}

	public String getWeldDirection() {
		return weldDirection;
	}

	public void setWeldDirection(String weldDirection) {
		this.weldDirection = weldDirection;
	}
}
