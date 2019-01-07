package com.cplh.gt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 * Author: liuhongli.
 * Date: 2018/12/12
 */


@Configuration
@EnableSwagger2
public class Swagger2 {

	/**
	 * 设置网页头信息
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cplh.gt.controller"))  //需要生成文档的包
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("工况智能采集-现场端接口测试") //标题
				.description("made in CPLH-LHL")    //描述
				.termsOfServiceUrl("")                 //相关连接
				.version("1.0")                     //版本号
				.build();
	}
}