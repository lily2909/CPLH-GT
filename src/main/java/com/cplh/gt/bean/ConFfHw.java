package com.cplh.gt.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


@Entity
@Table(name = "CON_FF_HW", schema = "public", catalog = "postgres")
public class ConFfHw {
	private String weldCode;
	private String equipCode;
	private String equipCodeCdp;
	private String personCode;
	private long temp0101;
	private long temp0102;
	private long temp0103;
	private long temp0301;
	private long temp0302;
	private long temp0303;
	private long temp0601;
	private long temp0602;
	private long temp0603;
	private long temp0901;
	private long temp0902;
	private long temp0903;
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

	@Basic
	@Column(name = "weld_code")
	public String getWeldCode() {
		return weldCode;
	}

	public void setWeldCode(String weldCode) {
		this.weldCode = weldCode;
	}

	@Basic
	@Column(name = "equip_code")
	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	@Basic
	@Column(name = "equip_code_cdp")
	public String getEquipCodeCdp() {
		return equipCodeCdp;
	}

	public void setEquipCodeCdp(String equipCodeCdp) {
		this.equipCodeCdp = equipCodeCdp;
	}

	@Basic
	@Column(name = "person_code")
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Basic
	@Column(name = "temp_01_01")
	public long getTemp0101() {
		return temp0101;
	}

	public void setTemp0101(long temp0101) {
		this.temp0101 = temp0101;
	}

	@Basic
	@Column(name = "temp_01_02")
	public long getTemp0102() {
		return temp0102;
	}

	public void setTemp0102(long temp0102) {
		this.temp0102 = temp0102;
	}

	@Basic
	@Column(name = "temp_01_03")
	public long getTemp0103() {
		return temp0103;
	}

	public void setTemp0103(long temp0103) {
		this.temp0103 = temp0103;
	}

	@Basic
	@Column(name = "temp_03_01")
	public long getTemp0301() {
		return temp0301;
	}

	public void setTemp0301(long temp0301) {
		this.temp0301 = temp0301;
	}

	@Basic
	@Column(name = "temp_03_02")
	public long getTemp0302() {
		return temp0302;
	}

	public void setTemp0302(long temp0302) {
		this.temp0302 = temp0302;
	}

	@Basic
	@Column(name = "temp_03_03")
	public long getTemp0303() {
		return temp0303;
	}

	public void setTemp0303(long temp0303) {
		this.temp0303 = temp0303;
	}

	@Basic
	@Column(name = "temp_06_01")
	public long getTemp0601() {
		return temp0601;
	}

	public void setTemp0601(long temp0601) {
		this.temp0601 = temp0601;
	}

	@Basic
	@Column(name = "temp_06_02")
	public long getTemp0602() {
		return temp0602;
	}

	public void setTemp0602(long temp0602) {
		this.temp0602 = temp0602;
	}

	@Basic
	@Column(name = "temp_06_03")
	public long getTemp0603() {
		return temp0603;
	}

	public void setTemp0603(long temp0603) {
		this.temp0603 = temp0603;
	}

	@Basic
	@Column(name = "temp_09_01")
	public long getTemp0901() {
		return temp0901;
	}

	public void setTemp0901(long temp0901) {
		this.temp0901 = temp0901;
	}

	@Basic
	@Column(name = "temp_09_02")
	public long getTemp0902() {
		return temp0902;
	}

	public void setTemp0902(long temp0902) {
		this.temp0902 = temp0902;
	}

	@Basic
	@Column(name = "temp_09_03")
	public long getTemp0903() {
		return temp0903;
	}

	public void setTemp0903(long temp0903) {
		this.temp0903 = temp0903;
	}

	@Basic
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "ts")
	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	@Basic
	@Column(name = "extend1")
	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Basic
	@Column(name = "extend2")
	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	@Basic
	@Column(name = "extend3")
	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	@Basic
	@Column(name = "extend4")
	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	@Basic
	@Column(name = "extend5")
	public String getExtend5() {
		return extend5;
	}

	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}

	@Basic
	@Column(name = "extend6")
	public String getExtend6() {
		return extend6;
	}

	public void setExtend6(String extend6) {
		this.extend6 = extend6;
	}

	@Basic
	@Column(name = "extend7")
	public String getExtend7() {
		return extend7;
	}

	public void setExtend7(String extend7) {
		this.extend7 = extend7;
	}

	@Basic
	@Column(name = "extend8")
	public String getExtend8() {
		return extend8;
	}

	public void setExtend8(String extend8) {
		this.extend8 = extend8;
	}

	@Basic
	@Column(name = "extend9")
	public String getExtend9() {
		return extend9;
	}

	public void setExtend9(String extend9) {
		this.extend9 = extend9;
	}

	@Basic
	@Column(name = "extend10")
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
		ConFfHw conFfHw = (ConFfHw) o;
		return temp0101 == conFfHw.temp0101 &&
				temp0102 == conFfHw.temp0102 &&
				temp0103 == conFfHw.temp0103 &&
				temp0301 == conFfHw.temp0301 &&
				temp0302 == conFfHw.temp0302 &&
				temp0303 == conFfHw.temp0303 &&
				temp0601 == conFfHw.temp0601 &&
				temp0602 == conFfHw.temp0602 &&
				temp0603 == conFfHw.temp0603 &&
				temp0901 == conFfHw.temp0901 &&
				temp0902 == conFfHw.temp0902 &&
				temp0903 == conFfHw.temp0903 &&
				Objects.equals(weldCode, conFfHw.weldCode) &&
				Objects.equals(equipCode, conFfHw.equipCode) &&
				Objects.equals(equipCodeCdp, conFfHw.equipCodeCdp) &&
				Objects.equals(personCode, conFfHw.personCode) &&
				Objects.equals(status, conFfHw.status) &&
				Objects.equals(ts, conFfHw.ts) &&
				Objects.equals(extend1, conFfHw.extend1) &&
				Objects.equals(extend2, conFfHw.extend2) &&
				Objects.equals(extend3, conFfHw.extend3) &&
				Objects.equals(extend4, conFfHw.extend4) &&
				Objects.equals(extend5, conFfHw.extend5) &&
				Objects.equals(extend6, conFfHw.extend6) &&
				Objects.equals(extend7, conFfHw.extend7) &&
				Objects.equals(extend8, conFfHw.extend8) &&
				Objects.equals(extend9, conFfHw.extend9) &&
				Objects.equals(extend10, conFfHw.extend10);
	}

	@Override
	public int hashCode() {

		return Objects.hash(weldCode, equipCode, equipCodeCdp, personCode, temp0101, temp0102, temp0103, temp0301, temp0302, temp0303, temp0601, temp0602, temp0603, temp0901, temp0902, temp0903, status, ts, extend1, extend2, extend3, extend4, extend5, extend6, extend7, extend8, extend9, extend10);
	}
}
