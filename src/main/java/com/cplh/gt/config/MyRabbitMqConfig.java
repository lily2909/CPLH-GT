package com.cplh.gt.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: liuhongli.
 * Date: 2018/12/25
 */

@Configuration
public class MyRabbitMqConfig {
	@Bean
	public MessageConverter getRabbit(){

		return new Jackson2JsonMessageConverter();
	}
}
