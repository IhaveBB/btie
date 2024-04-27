package com.nicebao.springblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
/**
 *
 *
 * @name: HelloController
 * @author: IhaveBB
 * @date: 2024-04-10 21:19
 **/
	@RequestMapping("/test")
	public String g1(){
		return "Hello";
	}
}
