package com.nicebao.springbook.config;

import com.nicebao.springbook.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
				.excludePathPatterns("/user/login")
				.excludePathPatterns("/**/**.html")
				.excludePathPatterns("/css/**.")
				.excludePathPatterns("/js/")
				.excludePathPatterns("/pic/**");

	}
}
