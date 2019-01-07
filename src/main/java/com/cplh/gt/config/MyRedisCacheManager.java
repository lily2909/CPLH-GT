package com.cplh.gt.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis 配置类
 * Author: liuhongli.
 * Date: 2018/12/23
 */


@Configuration
public class MyRedisCacheManager {

	/**
	 * 设置redis保存对象时的序列化gun则为jackson提供的序列化规则
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

		redisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);  //设置值序列化器
		redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);    //设置键序列化器
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

}