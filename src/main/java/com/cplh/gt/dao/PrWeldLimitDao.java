package com.cplh.gt.dao;

/**
 * Author: liuhongli.
 * Date: 2018/11/26
 */

import com.cplh.gt.bean.PrWeldLimit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 查询规范值
 */
public interface PrWeldLimitDao {

	@Select("select * from pr_weld_limit where pr_no = (select pr_no from pr_weld_relation where weld_code = #{weld}) and spec_type = #{pro}")
	public PrWeldLimit queryByweldCodePro(@Param("weld") String weld,@Param("pro")String pro);
}
