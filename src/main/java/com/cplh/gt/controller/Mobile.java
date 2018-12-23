package com.cplh.gt.controller;

import com.cplh.gt.bean.QueryPro;
import com.cplh.gt.bean.Test;
import com.cplh.gt.bean.YsInfo;
import com.cplh.gt.service.GtService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@Api(value = "现场验收 展示调用controller",description = "现场验收 展示调用controller",hidden = true)
@RestController
public class Mobile {
	Logger logger = LoggerFactory.getLogger(Mobile.class);
	@Autowired
	GtService gtService;


	@ApiOperation(value = "默认调用接口", notes = "测试发布状态")
	@ApiResponses({
			@ApiResponse(code = 200,message = "成功",response = String.class),
			@ApiResponse(code = 201,message = "成功",response = String.class),
			@ApiResponse(code = 202,message = "成功",response = String.class)
	})
	@PostMapping({"/index.html", "/", "/index"})
	@ResponseBody
	public String index() {
		return "连接成功";
	}

	@ApiOperation(value = "测试缓存接口", notes = "缓存查询数据")
	@GetMapping(value = {"/main"})
	@ResponseBody
	public String indexAaa(Integer id) {
		String a = gtService.getTest(id);
		System.out.println();
		return a;

	}


	/**
	 * 查询所有工作中工序的接口
	 * 取当前时间前一分钟的数据为准
	 * restful传递机组
	 *
	 * @param jz
	 */
	@ApiOperation(value = "查询所有工序接口", notes = "查询所有工序接口")
	//@HystrixCommand(fallbackMethod = "Fail1", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@PostMapping("/queryPro")
	@ResponseBody
	public QueryPro queryPro() {
		long l = System.currentTimeMillis();

		logger.info("查询所有工序");
		QueryPro queryPro = gtService.queryPro();
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_MSG_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 查询具体数据的接口
	 *
	 * @param jz
	 * @param code
	 */
	//@HystrixCommand(fallbackMethod = "Fail2", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@ApiOperation(value = "查询具体数据的接口", notes = "查询具体数据的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "hjCode", value = "焊机编号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "layer", value = "焊接工序", required = true, dataType = "String", paramType = "path")
	})

	@PostMapping("/clickPro/{weldCode}/{hjCode}/{layer}")
	@ResponseBody
	public QueryPro clickPro(@PathVariable("layer") String layer, @PathVariable("hjCode") String hjCode, @PathVariable("weldCode") String weldCode) {
		long l = System.currentTimeMillis();

		logger.info("查询工序详细数据接口,当前查询为" + layer + " 工序的 " + hjCode + "焊机" + weldCode + "焊口");
		QueryPro queryPro = gtService.clickPro(layer, hjCode, weldCode);
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_MSG_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 返回验收所有数据的接口
	 *
	 * @param weld_code
	 */
	//@HystrixCommand(fallbackMethod = "Fail3", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@ApiOperation(value = "返回验收所有数据的接口", notes = "返回验收所有数据的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path",example = "123")
	})
	@PostMapping("/info/{weldCode}")
	@ResponseBody
	public YsInfo info(@PathVariable("weldCode") String weldCode) {
		long l = System.currentTimeMillis();
		logger.info("查询验收详细数据接口,当前查询焊口为" + weldCode);
		YsInfo queryPro = gtService.info(weldCode);
		long l2= System.currentTimeMillis();
		long l1 = l2 - l;
		queryPro.set_msg_(String.valueOf(l1));
		return queryPro;
	}

	/**
	 * 同步焊口 工艺规程关系到机组
	 *
	 * @param weld_code
	 * @param pr_no
	 */
	@ApiOperation(value = "同步焊口 工艺规程关系到机组", notes = "同步焊口 工艺规程关系到机组")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "weldCode", value = "焊口标号", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "prNo", value = "工艺规程编号", required = true, dataType = "String", paramType = "path")
	})
	@PostMapping("/sys/{weldCode}/{prNo}")
	@ResponseBody
	//@HystrixCommand(fallbackMethod = "Fail4", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	public QueryPro sysWeldPro(@PathVariable String weldCode, @PathVariable String prNo) throws InterruptedException {
		logger.info("同步焊口 工艺规程接口 焊口：" + weldCode + " 工艺规程：" + prNo);
		QueryPro queryPro = gtService.sysWeldPro(weldCode, prNo);
		return queryPro;
	}


	/**
	 * 错误调用方法
	 *
	 * @return
	 */
	@ApiIgnore
	public QueryPro Fail1() {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail2(@PathVariable String layer, @PathVariable String hj_code, @PathVariable String weldCode) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail3(@PathVariable String weld_code, @PathVariable String flag) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	@ApiIgnore
	public QueryPro Fail4(@PathVariable String weld_code, @PathVariable String pr_no) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

}
