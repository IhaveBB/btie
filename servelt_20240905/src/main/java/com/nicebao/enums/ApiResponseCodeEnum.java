package com.nicebao.enums;

/**
 * @name: enums
 * @author: IhaveBB
 * @date: 2024-09-03 11:21
 **/
public enum ApiResponseCodeEnum implements BaseErrorInfoInterface {
	Success(200,"success"),

	/*1001-1999参数错误*/
	PARAM_IS_ERROR(1001,"参数错误"),
	PARAM_IS_INVALID(1002, "参数无效"),
	PARAM_IS_BLANK(1003, "参数为空"),
	PARAM_TYPE_BIND_ERROR(1004, "参数类型错误"),
	PARAM_NOT_COMPLETE(1005, "参数缺失"),
	PARAM_IS_MATCHING(1006,"传入参数异常"),
	PARAM_SESSION_NOT_MATCHING(1007, "Session 不匹配"),
	/* 用户错误 2001-2999*/
	USER_NOTLOGGED_IN(2001, "用户未登录"),
	USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),
	USER_REGISTER_EXISTS(2003,"用户名已存在"),
	USER_LACK_ERROR(2004,"用户不存在"),
	USER_ALREADY_LOGGED_IN(2005, "用户已登录"),
	/*系统错误*/
	SYSTEM_ERROR(10000, "系统异常，请稍后重试"),
	REGISTER_ERROR(10001,"注册异常，请稍后重试"),
	FRIEND_ALREADY_EXISTS(10002,"好友关系已存在")
	;

	private int code;
	private String message;

	ApiResponseCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getCode() {
		return code;
	}
}
