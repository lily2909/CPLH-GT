package com.cplh.gt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Author: liuhongli.
 * Date: 2019/3/25
 * http相关对象获取工具类
 */
public class RequestContextHolderUtil {
	Logger logger = LoggerFactory.getLogger(RequestContextHolderUtil.class);

	/**
	 * 获取request对象
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return getRequestAttributes().getRequest();
	}


	/**
	 * 获取Response对象
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return getRequestAttributes().getResponse();
	}

	/**
	 * 获取session对象
	 * @return
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获取RequestAttributes对象
	 * @return
	 */
	public static ServletRequestAttributes getRequestAttributes() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
	}

	/**
	 * 获取ServletContext对象
	 * @return
	 */
	public static ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}


}
