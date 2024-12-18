//package com.ssafy.piccup.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//      .cors(cors -> cors.configure(http)) // CORS 설정 활성화
//      .csrf(csrf -> csrf.disable())       // CSRF 비활성화
//      .authorizeHttpRequests(auth -> auth
//        .requestMatchers("/api/v1/**").permitAll()
//        .anyRequest().authenticated()
//      );
//
//    return http.build();
//  }
//}
