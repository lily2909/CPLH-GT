package com.cplh.gt.bean;

import java.io.Serializable;

/**
 * Author: liuhongli.
 * Date: 2018/11/29
 */


public class Test implements Serializable {
	private  String name;
	private  String id;

	@Override
	public String toString() {
		return "Test{" +
				"name='" + name + '\'' +
				", id='" + id + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
