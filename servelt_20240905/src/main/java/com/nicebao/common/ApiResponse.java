package com.nicebao.common;

import com.nicebao.enums.ApiResponseCodeEnum;
import com.nicebao.enums.BaseErrorInfoInterface;

/**
 * @name: ApiResponse
 * @author: IhaveBB
 * @date: 2024-09-03 11:12
 **/

public class ApiResponse<T> {
	private Integer code;
	private long timestamp;
	private String msg;
	private T data;

	public ApiResponse(T data) {
		this.data = data;
		this.timestamp = System.currentTimeMillis();
		this.code = ApiResponseCodeEnum.Success.getCode();
		this.msg = ApiResponseCodeEnum.Success.getMessage();
	}

	public ApiResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(data);
	}

	public static <T> ApiResponse<T> fail(Integer code, String msg) {
		return new ApiResponse<T>(code,msg);
	}

	public static <T> ApiResponse<T> fail(BaseErrorInfoInterface baseErrorInfoInterface) {
		return new ApiResponse<T>(baseErrorInfoInterface.getCode(),baseErrorInfoInterface.getMessage());
	}

}
