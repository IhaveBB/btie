package com.nicebao.springboot20231123;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class Calculator {

	@RequestMapping("/sum")
	public String sum(Integer num1,Integer num2){
		Integer sum = num1 + num2;
		return "计算结果为:"+sum;
	}

}
