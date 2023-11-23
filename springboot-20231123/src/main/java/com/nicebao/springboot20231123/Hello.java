package com.nicebao.springboot20231123;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
/**
 * HelloSpringBoot
 *
 * @name: Hello
 * @author: IhaveBB
 * @date: 2023-11-23 23:08
 **/
	@RequestMapping("/hello")
	public String Hello(){
		return "你好SpringBoot";
	}
}
