package com.ssafy.piccup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.piccup.interceptor.JwtInterceptor;

// interceptor 등록 (resume기능위한 임시 작성)
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**") // 모든 요청은 로그인 한 사람만 사용 가능
		.excludePathPatterns("/user/signup", "/user/login"); // 해당 요청은 인증 제외
	}
}
