package com.cplh.gt.dao;

/**
 * Author: liuhongli.
 * Date: 2018/11/26
 */

import com.cplh.gt.bean.ConEquipRelation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 机具 关系表
 */
public interface ConEquipReDao {

	@Select("select * from con_equip_relation where equip_code_zxj = #{equip}")
	public ConEquipRelation queryByEquip(String equip);

	@Select("select * from Con_Equip_Relation")
	List<ConEquipRelation> getAll();
}
