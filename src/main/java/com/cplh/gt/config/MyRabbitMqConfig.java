package com.cplh.gt.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit配置类
 * Author: liuhongli.
 * Date: 2018/12/25
 */

@Configuration
public class MyRabbitMqConfig {

	/**
	 * 将rabbit的序列化替换为jackson的系列化规则
	 * @return
	 */
	@Bean
	public MessageConverter getRabbit(){

		return new Jackson2JsonMessageConverter();
	}
}
