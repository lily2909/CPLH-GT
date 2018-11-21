package com.cplh.gt.config;

import com.cplh.gt.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Author: liuhongli.
 * Date: 2018/11/5
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

	@Bean
	public MyLocaleResolver localeResolver(){

		return new MyLocaleResolver();
	}
}
