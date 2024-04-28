package com.nicebao.anglecalculator.controller;

import com.nicebao.anglecalculator.constants.Constant;
import com.nicebao.anglecalculator.service.DegreeService;
import com.nicebao.anglecalculator.model.Degree;
import com.nicebao.anglecalculator.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/calculate")
public class DegreeController {

	@Autowired
	private DegreeService degreeService;

	@RequestMapping("/add")
	public Result<Degree> add(@RequestParam String degreeStr1, @RequestParam String degreeStr2) {
		Degree d1 = new Degree(degreeStr1);
		Degree d2 = new Degree(degreeStr2);
		return Result.success(degreeService.add(d1, d2));
	}

	@RequestMapping("/subtract")
	public Result<Degree> subtract(@RequestParam String degreeStr1, @RequestParam String degreeStr2) {
		Degree d1 = new Degree(degreeStr1);
		Degree d2 = new Degree(degreeStr2);
		return Result.success(degreeService.subtract(d1, d2));
	}
	@RequestMapping("/multiply")
	public Result<Degree> multiply(@RequestParam String degreeStr, @RequestParam double num) {
		Degree d1 = new Degree(degreeStr);
		return Result.success(degreeService.multiply(d1, num));
	}
	@RequestMapping("/divide")
	public Result<Degree> divide(@RequestParam String degreeStr, @RequestParam double num) {
		if(num == 0){
			return Result.fail("分母不可为零", Constant.ZERO_ERROR_CODE);
		}
		Degree d1 = new Degree(degreeStr);
		return Result.success(degreeService.divide(d1,num));
	}
}