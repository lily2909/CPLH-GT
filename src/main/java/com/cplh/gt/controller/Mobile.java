package com.cplh.gt.controller;

import com.alibaba.druid.util.StringUtils;
import com.cplh.gt.bean.QueryPro;
import com.cplh.gt.service.GtService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@Controller
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
	@GetMapping("/queryPro")
	@ResponseBody
	public QueryPro queryPro() {
		logger.info("查询所有工序");
		//if (!StringUtils.isEmpty(jz)) {
		//	//如果传递了机组
		//}
		QueryPro queryPro = gtService.queryPro();
		return queryPro;
	}

	/**
	 * 查询具体数据的接口
	 *
	 * @param jz
	 * @param code
	 */
	@GetMapping("/clickPro/{layer}/{hj_code}/{weldCode}")
	@ResponseBody
	public QueryPro clickPro(@PathVariable String layer, @PathVariable String hj_code, @PathVariable String weldCode) {
		logger.info("查询工序详细数据接口,当前查询为" + layer + " 工序的 " + hj_code + "焊机");
		QueryPro queryPro = gtService.clickPro(layer, hj_code, weldCode);
		if (!StringUtils.isEmpty(layer)) {
			//如果传递了机组
		}
		return queryPro;
	}

	/**
	 * 返回验收所有数据的接口
	 *
	 * @param weld_code
	 */
	@GetMapping("/info/{weld_code}")
	@ResponseBody
	public void info(@PathVariable String weld_code) {
		logger.info("查询验收详细数据接口,当前查询焊口为" + weld_code);
		if (!StringUtils.isEmpty(weld_code)) {
			//如果传递了机组
		}
	}

	/**
	 * 同步焊口 工艺规程关系到机组
	 *
	 * @param weld_code
	 * @param pr_no
	 */
	@GetMapping("/sys/{weld_code}/{pr_no}")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "Fail")
	public QueryPro sysWeldPro(@PathVariable String weld_code, @PathVariable String pr_no) {
		logger.info("同步焊口 工艺规程接口 焊口：" + weld_code + " 工艺规程：" + pr_no);
		QueryPro queryPro = gtService.sysWeldPro(weld_code,pr_no);
		//throw new RuntimeException();

		return queryPro;
	}

	@ResponseBody
	public QueryPro Fail(@PathVariable String weld_code, @PathVariable String pr_no) {
		logger.info("同步焊口 工艺规程接口 焊口：" + weld_code + " 工艺规程：" + pr_no);
		QueryPro queryPro = new QueryPro();
		queryPro.set_MSG_("这是熔断器");


		return queryPro;
	}

}
