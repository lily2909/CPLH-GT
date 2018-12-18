package com.cplh.gt.bean;

import java.sql.Timestamp;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


public class ConHjZp extends ConHj {
	private String weldCode;
	private String equipCode;
	private String equipCodeCdp;
	private String personCode;
	private Double temp00;
	private Double temp03;
	private Double temp06;
	private Double temp09;
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

	@Override
	public String toString() {
		return "ConHjZp{" +
				"weldCode='" + weldCode + '\'' +
				", equipCode='" + equipCode + '\'' +
				", equipCodeCdp='" + equipCodeCdp + '\'' +
				", personCode='" + personCode + '\'' +
				", temp00=" + temp00 +
				", temp03=" + temp03 +
				", temp06=" + temp06 +
				", temp09=" + temp09 +
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

	public String getWeldCode() {
		return weldCode;
	}

	public void setWeldCode(String weldCode) {
		this.weldCode = weldCode;
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

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Override
	public Double getTemp00() {
		return temp00;
	}

	@Override
	public void setTemp00(Double temp00) {
		this.temp00 = temp00;
	}

	public Double getTemp03() {
		return temp03;
	}

	public void setTemp03(Double temp03) {
		this.temp03 = temp03;
	}

	@Override
	public Double getTemp06() {
		return temp06;
	}

	@Override
	public void setTemp06(Double temp06) {
		this.temp06 = temp06;
	}

	public Double getTemp09() {
		return temp09;
	}

	public void setTemp09(Double temp09) {
		this.temp09 = temp09;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Timestamp getTs() {
		return ts;
	}

	@Override
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
}
