package com.cplh.gt.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * Author: liuhongli.
 * Date: 2018/12/23
 */


public class RedisCacheManager implements CacheManager {
	@Override
	public Cache getCache(String name) {
		return null;
	}

	@Override
	public Collection<String> getCacheNames() {
		return null;
	} //
}
