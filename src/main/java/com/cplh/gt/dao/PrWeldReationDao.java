package com.cplh.gt.dao;

/**
 * Author: liuhongli.
 * Date: 2018/11/20
 */


import org.apache.ibatis.annotations.Insert;

/**
 * 焊口 工艺规程dao
 */
public interface PrWeldReationDao {


	@Insert("insert into PR_WELD_RELATION values (#{weldCode},#{spec})")
	public void insert(String weldCode,String spec);
}
