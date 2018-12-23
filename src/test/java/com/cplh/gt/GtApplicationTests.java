package com.cplh.gt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtApplicationTests {
	@Autowired
	StringRedisTemplate redisTemplate;

	@Test
	public void testString (){
		ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
		for (int i = 0; i < 10; i++) {
			stringStringValueOperations.set(String.valueOf(Math.random()),String.valueOf(Math.random()));
		}

	}

}
