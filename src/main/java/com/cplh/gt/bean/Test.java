package com.cplh.gt.bean;

import java.io.Serializable;

/**
 * Author: liuhongli.
 * Date: 2018/11/29
 */


public class Test implements Serializable {
	private  String Name;
	private  String ID;


	@Override
	public String toString() {
		return "Test{" +
				"Name='" + Name + '\'' +
				", ID='" + ID + '\'' +
				'}';
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}
