package com.cplh.gt.dao;

/**
 * Author: liuhongli.
 * Date: 2018/11/23
 */

import com.cplh.gt.bean.ConHjZp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 焊接中频mpper接口
 */
public interface HjZpDao {
	@Select("select * from con_hj_zp where weld_code = #{weldCode}")
	public List<ConHjZp> getAllByWeld(String weldCode);
}
