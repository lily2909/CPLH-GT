package com.cplh.gt.config;

import com.cplh.gt.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public MyLocaleResolver localeResolver(){

		return new MyLocaleResolver();
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}


}
