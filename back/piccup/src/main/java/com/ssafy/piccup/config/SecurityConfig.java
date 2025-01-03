package com.ssafy.piccup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ssafy.piccup.filter.JwtAuthenticationFilter;
import com.ssafy.piccup.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
	private final JwtUtil jwtUtil;
	
	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	      .cors(cors -> cors.configure(http)) // CORS 설정 활성화
	      .csrf(csrf -> csrf.disable())       // CSRF 비활성화
	      .authorizeHttpRequests(authorize -> authorize
	    		  .requestMatchers("/user/signup", "/user/login", "/resume/profile_images/**").permitAll()
	    		  .anyRequest().authenticated()
		  )
	      
          // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 이전에 추가
	      .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

		  // 로그아웃 설정
//		  .logout((logout) -> logout
//	    		  .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//	    		  .logoutSuccessHandler((requeust, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK))
//	    		  .invalidateHttpSession(true));
	    return http.build();
	}
	

	  
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
