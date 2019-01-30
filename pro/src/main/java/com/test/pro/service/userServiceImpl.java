package com.test.pro.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Author: liuhongli.
 * Date: 2019/1/29
 */


@Component
@Service
public class userServiceImpl implements UserService {
	@Override
	public String getUser() {
		return "小明是一位新同学  他是新来的 大家一起欺负她";
	}
}
