package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/12
 */


/**
 * 焊口 工艺规程
 */
public class PwWeld {
	private String weld_code;
	private String pr_no;

	@Override
	public String toString() {
		return "PwWeld{" +
				"weld_code='" + weld_code + '\'' +
				", pr_no='" + pr_no + '\'' +
				'}';
	}

	public String getWeld_code() {
		return weld_code;
	}

	public void setWeld_code(String weld_code) {
		this.weld_code = weld_code;
	}

	public String getPr_no() {
		return pr_no;
	}

	public void setPr_no(String pr_no) {
		this.pr_no = pr_no;
	}
}
