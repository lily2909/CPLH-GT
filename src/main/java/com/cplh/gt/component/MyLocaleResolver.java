package com.cplh.gt.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */


public class MyLocaleResolver implements LocaleResolver {
	Logger logger = LoggerFactory.getLogger(MyLocaleResolver.class);

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		logger.info("国际化资源文件监控");
		//默认 取得是不带国家地区的资源文件
		Locale locale = Locale.getDefault();
		String l = request.getParameter("l");
		if (!StringUtils.isEmpty(l)) {
			String[] split = l.split("_");
			locale = new Locale(split[0], split[1]);
		}
		return locale;

	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

	}
}
