package com.cplh.gt.bean;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


public class ConHjZp extends ConHj {
	private String weldCode;
	private String equipCode;
	private String equipCodeCdp;
	private String personCode;
	private String temp00;
	private String temp03;
	private String temp06;
	private String temp09;
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

	public String getTemp00() {
		return temp00;
	}

	public void setTemp00(String temp00) {
		this.temp00 = temp00;
	}

	public String getTemp03() {
		return temp03;
	}

	public void setTemp03(String temp03) {
		this.temp03 = temp03;
	}

	public String getTemp06() {
		return temp06;
	}

	public void setTemp06(String temp06) {
		this.temp06 = temp06;
	}
	public String getTemp09() {
		return temp09;
	}

	public void setTemp09(String temp09) {
		this.temp09 = temp09;
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
		ConHjZp conHjZp = (ConHjZp) o;
		return Objects.equals(weldCode, conHjZp.weldCode) &&
				Objects.equals(equipCode, conHjZp.equipCode) &&
				Objects.equals(equipCodeCdp, conHjZp.equipCodeCdp) &&
				Objects.equals(personCode, conHjZp.personCode) &&
				Objects.equals(temp00, conHjZp.temp00) &&
				Objects.equals(temp03, conHjZp.temp03) &&
				Objects.equals(temp06, conHjZp.temp06) &&
				Objects.equals(temp09, conHjZp.temp09) &&
				Objects.equals(status, conHjZp.status) &&
				Objects.equals(ts, conHjZp.ts) &&
				Objects.equals(extend1, conHjZp.extend1) &&
				Objects.equals(extend2, conHjZp.extend2) &&
				Objects.equals(extend3, conHjZp.extend3) &&
				Objects.equals(extend4, conHjZp.extend4) &&
				Objects.equals(extend5, conHjZp.extend5) &&
				Objects.equals(extend6, conHjZp.extend6) &&
				Objects.equals(extend7, conHjZp.extend7) &&
				Objects.equals(extend8, conHjZp.extend8) &&
				Objects.equals(extend9, conHjZp.extend9) &&
				Objects.equals(extend10, conHjZp.extend10);
	}

	@Override
	public int hashCode() {

		return Objects.hash(weldCode, equipCode, equipCodeCdp, personCode, temp00, temp03, temp06, temp09, status, ts, extend1, extend2, extend3, extend4, extend5, extend6, extend7, extend8, extend9, extend10);
	}
}
