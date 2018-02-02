package com.qf.service;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisService {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> template;

	public void edit() {
		System.out.println("=================");
		template.opsForValue().set("namekey", "111");
		String string = template.opsForValue().get("namekey");
		System.out.println(string + "==========");
	}
}
