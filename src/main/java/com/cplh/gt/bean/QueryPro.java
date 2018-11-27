package com.cplh.gt.bean;

/**
 * Author: liuhongli.
 * Date: 2018/11/12
 */


import java.util.Map;

/**
 * 查询工序返回实体类
 */
public class QueryPro {

	//成功状态
	private boolean Success;
	//具体数据
	private Map<String, ?extends Object> Data;
	private String _MSG_;

	@Override
	public String toString() {
		return "QueryPro{" +
				"Success=" + Success +
				", Data=" + Data +
				", _MSG_='" + _MSG_ + '\'' +
				'}';
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public Map<String, ? extends Object> getData() {
		return Data;
	}

	public void setData(Map<String, ? extends Object> data) {
		Data = data;
	}

	public String get_MSG_() {
		return _MSG_;
	}

	public void set_MSG_(String _MSG_) {
		this._MSG_ = _MSG_;
	}
}
