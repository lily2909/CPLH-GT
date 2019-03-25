package com.cplh.gt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuhongli.
 * Date: 2019/3/22
 */


/**
 * 配置全局错误处理 接收全局报错信息 封装报错信息 调用原始错误处理controller进行 页面 json自动适配
 */
@ControllerAdvice
//@Component
public class MyErrorConfig extends DefaultErrorAttributes {
	Logger logger = LoggerFactory.getLogger(MyErrorConfig.class);

	@ExceptionHandler(FileNotFoundException.class)
	public String handleException(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		//传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
		/**
		 * Integer statusCode = (Integer) request
		 .getAttribute("javax.servlet.error.status_code");
		 */
		request.setAttribute("javax.servlet.error.status_code", 400);
		map.put("code", "user.notexist");
		map.put("message", e.getMessage());
		System.out.println(2333);
		//转发到/error
		return "forward:/error";
	}

	@ExceptionHandler()
	public String handleException1(Exception e, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		//传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
		/**
		 * Integer statusCode = (Integer) request
		 .getAttribute("javax.servlet.error.status_code");
		 */
		request.setAttribute("javax.servlet.error.status_code", 400);
		map.put("code", "user.notexist");
		map.put("message", e.getMessage());
		request.setAttribute("javax.servlet.error.message",map);
		System.out.println(2222);
		//转发到/error
		return "forward:/error";
	}

	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace)  {
		Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
		map.put("company", "atguigu");
		map.put("123", "123");
		map.put("312", "312");
		map.put("com1231pany", "312");
		map.put("compa3123ny", "312");

		return map;
	}

}
