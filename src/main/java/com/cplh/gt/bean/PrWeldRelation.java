package com.cplh.gt.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


@Entity
@Table(name = "PR_WELD_RELATION", schema = "public", catalog = "postgres")
public class PrWeldRelation {
	private String weldCode;
	private String prNo;

	@Basic
	@Column(name = "weld_code")
	public String getWeldCode() {
		return weldCode;
	}

	public void setWeldCode(String weldCode) {
		this.weldCode = weldCode;
	}

	@Basic
	@Column(name = "pr_no")
	public String getPrNo() {
		return prNo;
	}

	public void setPrNo(String prNo) {
		this.prNo = prNo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PrWeldRelation that = (PrWeldRelation) o;
		return Objects.equals(weldCode, that.weldCode) &&
				Objects.equals(prNo, that.prNo);
	}

	@Override
	public int hashCode() {

		return Objects.hash(weldCode, prNo);
	}
}
