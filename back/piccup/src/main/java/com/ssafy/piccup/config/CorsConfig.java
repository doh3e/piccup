package com.ssafy.piccup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOriginPattern("*"); // 모든 도메인 허용 (개발 환경에서만 사용)
    config.addAllowedMethod("*");        // 모든 HTTP 메서드 허용
    config.addAllowedHeader("*");        // 모든 헤더 허용
    config.setAllowCredentials(true);    // 인증 정보 허용 (예: 쿠키, Authorization 헤더)
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
