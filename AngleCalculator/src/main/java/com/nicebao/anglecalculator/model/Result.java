package com.nicebao.anglecalculator.model;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class Result<T> {
	private int code;
	private String message;
	private T data;


	public static Result success(Object data){
		Result result = new Result();
		result.setCode(HttpStatus.OK.value());
		result.setData(data);
		result.setMessage("success");
		return result;
	}

	public static Result fail(String errMsg,Integer code){
		Result result = new Result();
		result.setCode(code);
		result.setData(null);
		result.setMessage(errMsg);

		return result;
	}

}