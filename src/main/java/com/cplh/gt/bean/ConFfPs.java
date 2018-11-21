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
@Table(name = "CON_FF_PS", schema = "public", catalog = "postgres")
public class ConFfPs {
	private String weldCode;
	private String equipCode;
	private String equipCodeCdp;
	private String personCode;
	private Long stress;
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
	@Column(name = "stress")
	public Long getStress() {
		return stress;
	}

	public void setStress(Long stress) {
		this.stress = stress;
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
		ConFfPs conFfPs = (ConFfPs) o;
		return Objects.equals(weldCode, conFfPs.weldCode) &&
				Objects.equals(equipCode, conFfPs.equipCode) &&
				Objects.equals(equipCodeCdp, conFfPs.equipCodeCdp) &&
				Objects.equals(personCode, conFfPs.personCode) &&
				Objects.equals(stress, conFfPs.stress) &&
				Objects.equals(status, conFfPs.status) &&
				Objects.equals(ts, conFfPs.ts) &&
				Objects.equals(extend1, conFfPs.extend1) &&
				Objects.equals(extend2, conFfPs.extend2) &&
				Objects.equals(extend3, conFfPs.extend3) &&
				Objects.equals(extend4, conFfPs.extend4) &&
				Objects.equals(extend5, conFfPs.extend5) &&
				Objects.equals(extend6, conFfPs.extend6) &&
				Objects.equals(extend7, conFfPs.extend7) &&
				Objects.equals(extend8, conFfPs.extend8) &&
				Objects.equals(extend9, conFfPs.extend9) &&
				Objects.equals(extend10, conFfPs.extend10);
	}

	@Override
	public int hashCode() {

		return Objects.hash(weldCode, equipCode, equipCodeCdp, personCode, stress, status, ts, extend1, extend2, extend3, extend4, extend5, extend6, extend7, extend8, extend9, extend10);
	}
}
