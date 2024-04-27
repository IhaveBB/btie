package com.nicebao.springblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
				.excludePathPatterns("/**/*.html")
				.excludePathPatterns("/pic/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/blog-editormd/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/user/login");
	}
}
