package com.nicebao.springblog.config;

import com.nicebao.springblog.constants.Constant;
import com.nicebao.springblog.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String userToken = request.getHeader(Constant.USER_TOKEN_HEADER);
		boolean result = JWTUtils.checkToken(userToken);
		log.info("拦截器成功从head获得token, token:"+userToken);
		if(result){
			return true;
		}
		response.setStatus(401);
		return false;
	}
}
