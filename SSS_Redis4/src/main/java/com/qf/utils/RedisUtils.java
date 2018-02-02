package com.qf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtils {
	@Autowired
	private static RedisTemplate<String, String> template;

	public static void set(String key, String value) {
		template.opsForValue().set(key, value);

	}
}
