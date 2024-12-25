package com.ssafy.piccup.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.piccup.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// (resume기능위한 임시 작성)
@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	private final String HEADER_AUTH = "Authorization";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// OPTIONS Method를 먼저 보냄 / 사전요청 (클라이언트 -> 서버) 보내서 현재 서버가 요청을 수락할 수 있는 상태인지 확인
		if (request.getMethod().equals("OPTIONS"))
			return true;
		
		// Authorization 헤더에서 토큰 가져오기
		String token = request.getHeader(HEADER_AUTH);
		if (token != null) {
			System.out.println(token);
			if(jwtUtil.checkToken(token)) {
				return true; // 유효한 토큰
			}
		}
//		throw new Exception("유효하지 않은 접근입니다.");
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 반환
	    return false;
	}
}
