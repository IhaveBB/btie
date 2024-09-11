package com.nicebao.common;

import com.nicebao.enums.ApiResponseCodeEnum;
import com.nicebao.exception.BaseErrorInfoInterface;
import lombok.Data;

import java.io.Serializable;

/**
 * @name: ApiResponse
 * @author: IhaveBB
 * @date: 2024-09-09 19:13
 **/
@Data
public class ApiResponse<T> implements Serializable {
	private Integer code;
	private long timestamp;
	private String msg;
	private T data;

	public ApiResponse(T data) {
		this.data = data;
		this.code = ApiResponseCodeEnum.SUCCESS.getCode();
		this.msg = ApiResponseCodeEnum.SUCCESS.getMessage();
		this.timestamp = System.currentTimeMillis();
	}

	public ApiResponse(String msg, Integer code) {
		this.msg = msg;
		this.code = code;
		this.data = null;
		this.timestamp = System.currentTimeMillis();
	}

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(data);
	}

	public static <T> ApiResponse<T> fail(Integer code, String msg) {
		return new ApiResponse<T>(msg,code);
	}

	public static <T> ApiResponse<T> fail(BaseErrorInfoInterface baseErrorInfoInterface) {
		return new ApiResponse<T>(baseErrorInfoInterface.getMessage(),baseErrorInfoInterface.getCode());
	}


}
