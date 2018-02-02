package com.qf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.service.RedisService;

@Controller
public class RedisController {
	@Resource(name = "redisService")
	private RedisService service;

	@RequestMapping("edit.action")
	public void edit() {
		service.edit();
	}
}
