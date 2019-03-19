package com.cplh.gt.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author: liuhongli.
 * Date: 2019/1/21
 */

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	//定制请求的授权规则
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().
				antMatchers("/swagger-ui.html").permitAll().
				antMatchers("/level1/**").hasRole("V1").
				antMatchers("/level2/**").hasRole("V2").
				antMatchers("/level3/**").hasRole("V3");
		http.csrf().disable();
		//开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
		http.formLogin().usernameParameter("user").passwordParameter("pwd")
		.loginPage("/userlogin");
		//1、/login来到登陆页
		//2、重定向到/login?error表示登陆失败
		//3、更多详细规定
		//4、默认post形式的 /login代表处理登陆
		//5、一但定制loginPage；那么 loginPage的post请求就是登陆


		//开启自动配置的注销功能。
		http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
		//1、访问 /logout 表示用户注销，清空session
		//2、注销成功会返回 /login?logout 页面；

		//开启记住我功能
		http.rememberMe().rememberMeParameter("remeber");

		//登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
		//点击注销会删除cookie

	}

	@Override
	//定义认证规则
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//配置在内存中储存的用户信息
		//auth.jdbcAuthentication() 配置查询出的用户信息
		auth.inMemoryAuthentication()
				.withUser("zhangsan").password("123456").roles("V1", "VIP2")
				.and()
				.withUser("lisi").password("123456").roles("VIP2", "VIP3")
				.and()
				.withUser("wangwu").password("123456").roles("VIP1", "VIP3");
	}
}

