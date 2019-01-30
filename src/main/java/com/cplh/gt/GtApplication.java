package com.cplh.gt;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDubbo
@EnableCircuitBreaker           //开启熔断器
//@EnableHystrixDashboard       //开启熔断器
@SpringBootApplication          //标明这是springboot启动类
@MapperScan("com.cplh.gt.dao")  //设置扫描mapper文件的路径
@EnableCaching                  //开启缓存注解
@EnableRabbit                   //开启rabbitmq注解
@EnableScheduling               //开启定时器
public class GtApplication {
	public static void main(String[] args) {
		SpringApplication.run(GtApplication.class, args);
	}

}
