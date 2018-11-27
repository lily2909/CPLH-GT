package com.cplh.gt.bean;

import java.util.Objects;

/**
 * Author: liuhongli.
 * Date: 2018/11/26
 */


public class ConEquipRelation {
	private String teamCodeCdp;
	private String equipType;
	private String equipCodeCdp;
	private String equipCodeZxj;

	@Override
	public String toString() {
		return "ConEquipRelation{" +
				"teamCodeCdp='" + teamCodeCdp + '\'' +
				", equipType='" + equipType + '\'' +
				", equipCodeCdp='" + equipCodeCdp + '\'' +
				", equipCodeZxj='" + equipCodeZxj + '\'' +
				'}';
	}

	public String getTeamCodeCdp() {
		return teamCodeCdp;
	}

	public void setTeamCodeCdp(String teamCodeCdp) {
		this.teamCodeCdp = teamCodeCdp;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getEquipCodeCdp() {
		return equipCodeCdp;
	}

	public void setEquipCodeCdp(String equipCodeCdp) {
		this.equipCodeCdp = equipCodeCdp;
	}

	public String getEquipCodeZxj() {
		return equipCodeZxj;
	}

	public void setEquipCodeZxj(String equipCodeZxj) {
		this.equipCodeZxj = equipCodeZxj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConEquipRelation that = (ConEquipRelation) o;
		return Objects.equals(teamCodeCdp, that.teamCodeCdp) &&
				Objects.equals(equipType, that.equipType) &&
				Objects.equals(equipCodeCdp, that.equipCodeCdp) &&
				Objects.equals(equipCodeZxj, that.equipCodeZxj);
	}

	@Override
	public int hashCode() {

		return Objects.hash(teamCodeCdp, equipType, equipCodeCdp, equipCodeZxj);
	}



}
