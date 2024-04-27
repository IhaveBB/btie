package com.nicebao.springbook.model;

import lombok.Data;

@Data
public class Result<T> {
	private Integer code;
	private String errMsg;
	private T data;

	public static <T> Result<T> success(T data){
		Result<T> result = new Result<>();
		result.setData(data);
		result.setCode(200);
		return result;
	}
	public static <T> Result<T> fail(T data,String errMsg){
		Result<T> result = new Result<>();
		result.setData(data);
		result.setCode(-1);
		result.setErrMsg(errMsg);
		return result;
	}
	public static <T> Result<T> fail(String errMsg){
		Result<T> result = new Result<>();
		result.setCode(-1);
		result.setErrMsg(errMsg);
		return result;
	}
	public static <T> Result<T> unLogin(){
		Result<T> result = new Result<>();
		result.setCode(-2);
		result.setErrMsg("用户未登录");
		return result;
	}
}
