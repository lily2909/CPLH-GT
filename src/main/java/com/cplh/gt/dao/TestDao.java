package com.cplh.gt.dao;

import com.cplh.gt.bean.Test;
import org.apache.ibatis.annotations.Select;

/**
 * Author: liuhongli.
 * Date: 2018/12/23
 */


public interface TestDao {
	@Select("select * from test where id = #{id}")
	Test getTestById(Integer id);
}
