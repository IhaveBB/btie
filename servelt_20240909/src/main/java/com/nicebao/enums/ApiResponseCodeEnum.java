package com.nicebao.enums;

import com.nicebao.exception.BaseErrorInfoInterface;

/**
 * @name: ApiResponseCodeEnum
 * @author: IhaveBB
 * @date: 2024-09-09 19:16
 **/
public enum ApiResponseCodeEnum implements BaseErrorInfoInterface {
	SUCCESS(200,"success"),
	/*1001-1999参数错误*/
	PARAM_IS_ERROR(1001,"参数错误"),
	PARAM_IS_INVALID(1002, "参数无效"),
	PARAM_DATE_IS_ERROR(1003,"离校日期晚于回校日期"),
	PARAM_FILE_FOMAT_ERROR(1004,"上传文件类型错误" ),
	PARAM_FILE_SIZE_ERROR(1005,"上传文件过大" ),

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
