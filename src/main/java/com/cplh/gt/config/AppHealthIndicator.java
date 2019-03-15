package com.cplh.gt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: liuhongli.
 * Date: 2019/3/11
 */

@Component
public class AppHealthIndicator implements HealthIndicator {
	Logger logger = LoggerFactory.getLogger(AppHealthIndicator.class);

	@Bean
	@Override
	public Health health() {


		return Health.up().build();
	}
}
