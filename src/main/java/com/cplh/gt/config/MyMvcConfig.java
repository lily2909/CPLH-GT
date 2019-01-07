package com.cplh.gt.config;

import com.cplh.gt.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义mvc配置
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 将自定义资源文件管理类添加进容器
	 * @return
	 */
	@Bean
	public MyLocaleResolver localeResolver(){

		return new MyLocaleResolver();
	}

	/**
	 * 关闭后缀匹配 否则最后一个参数如果是小数将截取小数点前的数字获取
	 * @param configurer
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}


}
