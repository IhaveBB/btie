package com.nicebao.springboot20231123;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	@RequestMapping("/sayHi")
	public String Hello(){
		return "Hi";
	}
	
	@RequestMapping("/r1")
	public  String r1(Student student){
		return student.toString();
	}
}
