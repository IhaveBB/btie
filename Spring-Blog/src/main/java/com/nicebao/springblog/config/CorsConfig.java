package com.nicebao.springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // 允许发送Cookie
		config.addAllowedOriginPattern("*"); // 允许所有源，实际生产中应具体指定
		config.addAllowedHeader("*"); // 允许所有Header
		config.addAllowedMethod("*"); // 允许所有方法
		source.registerCorsConfiguration("/**", config); // 对所有路径生效
		return new CorsFilter(source);
	}
}