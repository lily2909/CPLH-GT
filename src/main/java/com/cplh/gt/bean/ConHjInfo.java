package com.cplh.gt.bean;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


public class ConHjInfo extends ConHj {
	private String tableName;
	private String weldCode;
	private String weldLayer;
	private String equipCode;
	private String equipCodeCdp;
	private String hqNum;
	private String personCode;
	private Long hjSpeed;
	private Long angle;
	private Long direction;
	private Long current;
	private Long voltage;
	private Long speed;
	private String status;
	private Timestamp ts;
	private String extend1;
	private String extend2;
	private String extend3;
	private String extend4;
	private String extend5;
	private String extend6;
	private String extend7;
	private String extend8;
	private String extend9;
	private String extend10;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getWeldCode() {
		return weldCode;
	}

	public void setWeldCode(String weldCode) {
		this.weldCode = weldCode;
	}

	public String getWeldLayer() {
		return weldLayer;
	}

	public void setWeldLayer(String weldLayer) {
		this.weldLayer = weldLayer;
	}

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public String getEquipCodeCdp() {
		return equipCodeCdp;
	}

	public void setEquipCodeCdp(String equipCodeCdp) {
		this.equipCodeCdp = equipCodeCdp;
	}

	public String getHqNum() {
		return hqNum;
	}

	public void setHqNum(String hqNum) {
		this.hqNum = hqNum;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Long getHjSpeed() {
		return hjSpeed;
	}

	public void setHjSpeed(Long hjSpeed) {
		this.hjSpeed = hjSpeed;
	}

	public Long getAngle() {
		return angle;
	}

	public void setAngle(Long angle) {
		this.angle = angle;
	}

	public Long getDirection() {
		return direction;
	}

	public void setDirection(Long direction) {
		this.direction = direction;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	public String getExtend5() {
		return extend5;
	}

	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}

	public String getExtend6() {
		return extend6;
	}

	public void setExtend6(String extend6) {
		this.extend6 = extend6;
	}

	public String getExtend7() {
		return extend7;
	}

	public void setExtend7(String extend7) {
		this.extend7 = extend7;
	}

	public String getExtend8() {
		return extend8;
	}

	public void setExtend8(String extend8) {
		this.extend8 = extend8;
	}

	public String getExtend9() {
		return extend9;
	}

	public void setExtend9(String extend9) {
		this.extend9 = extend9;
	}

	public String getExtend10() {
		return extend10;
	}

	public void setExtend10(String extend10) {
		this.extend10 = extend10;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConHjInfo conHjInfo = (ConHjInfo) o;
		return Objects.equals(weldCode, conHjInfo.weldCode) &&
				Objects.equals(weldLayer, conHjInfo.weldLayer) &&
				Objects.equals(equipCode, conHjInfo.equipCode) &&
				Objects.equals(equipCodeCdp, conHjInfo.equipCodeCdp) &&
				Objects.equals(hqNum, conHjInfo.hqNum) &&
				Objects.equals(personCode, conHjInfo.personCode) &&
				Objects.equals(hjSpeed, conHjInfo.hjSpeed) &&
				Objects.equals(angle, conHjInfo.angle) &&
				Objects.equals(direction, conHjInfo.direction) &&
				Objects.equals(current, conHjInfo.current) &&
				Objects.equals(voltage, conHjInfo.voltage) &&
				Objects.equals(speed, conHjInfo.speed) &&
				Objects.equals(status, conHjInfo.status) &&
				Objects.equals(ts, conHjInfo.ts) &&
				Objects.equals(extend1, conHjInfo.extend1) &&
				Objects.equals(extend2, conHjInfo.extend2) &&
				Objects.equals(extend3, conHjInfo.extend3) &&
				Objects.equals(extend4, conHjInfo.extend4) &&
				Objects.equals(extend5, conHjInfo.extend5) &&
				Objects.equals(extend6, conHjInfo.extend6) &&
				Objects.equals(extend7, conHjInfo.extend7) &&
				Objects.equals(extend8, conHjInfo.extend8) &&
				Objects.equals(extend9, conHjInfo.extend9) &&
				Objects.equals(extend10, conHjInfo.extend10);
	}

	@Override
	public String toString() {
		return "ConHjInfo{" +
				"tableName='" + tableName + '\'' +
				", weldCode='" + weldCode + '\'' +
				", weldLayer='" + weldLayer + '\'' +
				", equipCode='" + equipCode + '\'' +
				", equipCodeCdp='" + equipCodeCdp + '\'' +
				", hqNum='" + hqNum + '\'' +
				", personCode='" + personCode + '\'' +
				", hjSpeed=" + hjSpeed +
				", angle=" + angle +
				", direction=" + direction +
				", current=" + current +
				", voltage=" + voltage +
				", speed=" + speed +
				", status='" + status + '\'' +
				", ts=" + ts +
				", extend1='" + extend1 + '\'' +
				", extend2='" + extend2 + '\'' +
				", extend3='" + extend3 + '\'' +
				", extend4='" + extend4 + '\'' +
				", extend5='" + extend5 + '\'' +
				", extend6='" + extend6 + '\'' +
				", extend7='" + extend7 + '\'' +
				", extend8='" + extend8 + '\'' +
				", extend9='" + extend9 + '\'' +
				", extend10='" + extend10 + '\'' +
				'}';
	}

	@Override
	public int hashCode() {

		return Objects.hash(weldCode, weldLayer, equipCode, equipCodeCdp, hqNum, personCode, hjSpeed, angle, direction, current, voltage, speed, status, ts, extend1, extend2, extend3, extend4, extend5, extend6, extend7, extend8, extend9, extend10);
	}
}
