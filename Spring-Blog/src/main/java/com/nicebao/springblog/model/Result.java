package com.nicebao.springblog.model;

import com.nicebao.springblog.constants.Constant;
import lombok.Data;

@Data
public class Result {
/**
 *	code:200 成功
 *		 -1   失败
 *		 -2	  未登录
 *
 * @name: Result
 * @author: IhaveBB
 * @date: 2024-04-11 19:32
 **/
	private int code;
	private String errMsg;
	private Object data;

	public static Result success(Object data){
		Result result = new Result();
		result.setCode(Constant.SUCCESS_CODE);
		result.setErrMsg("");
		result.setData(data);
		return result;
	}

	public static Result fail(String errMsg){
		Result result = new Result();
		result.setCode(Constant.FAIL_CODE);
		result.setErrMsg(errMsg);
		result.setData(null);
		return result;
	}
	public static Result fail(String errMsg,Object data){
		Result result = new Result();
		result.setCode(Constant.FAIL_CODE);
		result.setErrMsg(errMsg);
		result.setData(data);
		return result;
	}
	public static Result unLogin(){
		Result result = new Result();
		result.setCode(Constant.UNLOGIN_CODE);
		result.setErrMsg("用户未登录");
		result.setData(null);
		return result;
	}
	public static Result unLogin(Object data){
		Result result = new Result();
		result.setCode(Constant.UNLOGIN_CODE);
		result.setErrMsg("用户未登录");
		result.setData(data);
		return result;
	}
}
