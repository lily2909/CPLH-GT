package com.cplh.gt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
//@EnableHystrixDashboard
@SpringBootApplication
@MapperScan("com.cplh.gt.dao")  //设置扫描mapper文件的路径
@EnableCaching
@EnableRabbit
public class GtApplication {
	public static void main(String[] args) {
		SpringApplication.run(GtApplication.class, args);
	}

}
