package com.cplh.gt.dao;

/**
 * Author: liuhongli.
 * Date: 2018/11/20
 */


import com.cplh.gt.bean.PrWeldRelation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 焊口 工艺规程dao
 */
public interface PrWeldReationDao {


	@Insert("insert into PR_WELD_RELATION values (#{weldCode},#{spec})")
	public int insert(@Param("weldCode") String weldCode,@Param("spec") String spec);

	@Select("select * from PR_WELD_RELATION")
	public List<PrWeldRelation> getAll();
}
