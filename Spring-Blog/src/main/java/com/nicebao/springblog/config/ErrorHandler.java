package com.nicebao.springblog.config;

import com.nicebao.springblog.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class ErrorHandler {
/**
 *	统一异常处理
 *
 * @name: ErrorHandler
 * @author: IhaveBB
 * @date: 2024-04-12 09:58
 **/
	@ExceptionHandler
	public Result handler(Exception e){
		return Result.fail(e.getMessage());
	}
}
