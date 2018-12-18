package com.cplh.gt.dao;

import com.cplh.gt.bean.ConHjInfo;
import com.cplh.gt.bean.PrWeldLimit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: liuhongli.
 * Date: 2018/11/13
 */


public interface HjInfoDao {

	/**
	 * 获取所有数据
	 * @return
	 */
	@Select("select * FROM  CON_HJ_INFO  ")
	public List<ConHjInfo> getAll();

	/**
	 * 查询当前在工作工序
	 * @param conHjInfo
	 * @return
	 */
	//@Select("select * from ${tableName} where ts > to_timestamp(TO_CHAR(current_timestamp -interval '1 minute' , 'yyyy-MM-dd HH12:MI:SS'),'yyyy-MM-dd HH12:MI:SS') order by ts")
	public List<ConHjInfo> queryPro(ConHjInfo conHjInfo);


	/**
	 * 点击工序 返回最新数据 具体到焊枪
	 * @param conHjInfo
	 * @return
	 */
	public ConHjInfo clickPro(ConHjInfo conHjInfo);

	/**
	 *根据焊口获取所有数据
	 * @param tableName
	 * @param weldCode
	 * @param hjCode
	 * @return
	 */
	@Select("select * from ${tableName} where weld_code = #{weldCode} and equip_Code = #{hjCode}")
	//@Select("select * from con_hj_info where weld_code = #{weldCode} and equip_Code = #{hjCode}")
	public List<ConHjInfo> queryAllByWeld(@Param("tableName") String tableName,@Param("weldCode")  String weldCode,@Param("hjCode")  String hjCode);

	/**
	 * 根据焊口 获取规范值
	 */
	@Select("select * from PR_WELD_LIMIT where pr_no = (select pr_no from pr_weld_relation where weld_code = #{weldCode}) and spec_type = #{pro}")
	public PrWeldLimit queryLimitByWeld(@Param("weldCode") String weldCode,@Param("pro") String pro);

	/**
	 * 获取所有数据
	 * @return
	 */
	@Select("select * FROM  CON_HJ_INFO where weld_code = #{weld_code} ")
	List<ConHjInfo> getAllByWeld(String weld_code);
}
