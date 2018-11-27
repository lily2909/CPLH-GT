package com.cplh.gt.controller;

import com.alibaba.druid.util.StringUtils;
import com.cplh.gt.bean.QueryPro;
import com.cplh.gt.bean.YsInfo;
import com.cplh.gt.service.GtService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@RestController
public class Mobile {
	Logger logger = LoggerFactory.getLogger(Mobile.class);
	@Autowired
	GtService gtService;

	@RequestMapping({"/index.html", "/", "/index"})
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/main";
	}

	@RequestMapping({"/main"})
	public String indexAaa() {
		System.out.println("main function");
		return "login";

	}


	/**
	 * 查询所有工作中工序的接口
	 * 取当前时间前一分钟的数据为准
	 * restful传递机组
	 *
	 * @param jz
	 */
	//@HystrixCommand(fallbackMethod = "Fail1", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	//})
	@GetMapping("/queryPro")
	@ResponseBody
	public QueryPro queryPro() {
		logger.info("查询所有工序");
		QueryPro queryPro = gtService.queryPro();
		return queryPro;
	}

	/**
	 * 查询具体数据的接口
	 *
	 * @param jz
	 * @param code
	 */
	@HystrixCommand(fallbackMethod = "Fail2", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	@GetMapping("/clickPro/{layer}/{hj_code}/{weldCode}")
	@ResponseBody
	public QueryPro clickPro(@PathVariable String layer, @PathVariable String hj_code, @PathVariable String weldCode) {
		logger.info("查询工序详细数据接口,当前查询为" + layer + " 工序的 " + hj_code + "焊机");
		QueryPro queryPro = gtService.clickPro(layer, hj_code, weldCode);
		return queryPro;
	}

	/**
	 * 返回验收所有数据的接口
	 *
	 * @param weld_code
	 */
	@HystrixCommand(fallbackMethod = "Fail3", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	@GetMapping("/info/{weld_code}")
	@ResponseBody
	public YsInfo info(@PathVariable String weld_code) {

		logger.info("查询验收详细数据接口,当前查询焊口为" + weld_code);
		YsInfo queryPro = gtService.info(weld_code);
		return queryPro;
	}

	/**
	 * 同步焊口 工艺规程关系到机组
	 *
	 * @param weld_code
	 * @param pr_no
	 */
	@RequestMapping("/sys/{weld_code}/{pr_no}")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "Fail4", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
	})
	public QueryPro sysWeldPro(@PathVariable String weld_code, @PathVariable String pr_no) throws InterruptedException {
		logger.info("同步焊口 工艺规程接口 焊口：" + weld_code + " 工艺规程：" + pr_no);
		QueryPro queryPro = gtService.sysWeldPro(weld_code, pr_no);
		return queryPro;
	}


	/**
	 * 错误调用方法
	 * @return
	 */

	public QueryPro Fail1() {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	public QueryPro Fail2(@PathVariable String layer, @PathVariable String hj_code, @PathVariable String weldCode) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

	public QueryPro Fail3(@PathVariable String weld_code) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}


	public QueryPro Fail4(@PathVariable String weld_code, @PathVariable String pr_no) {
		QueryPro out = new QueryPro();
		out.setSuccess(false);
		out.set_MSG_("服务器连接不稳定 请重新操作");
		return out;
	}

}
