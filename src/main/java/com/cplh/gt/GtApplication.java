package com.cplh.gt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.cplh.gt.dao")  //设置扫描mapper文件的路径
public class GtApplication {
	public static void main(String[] args) {
		SpringApplication.run(GtApplication.class, args);
	}

}
