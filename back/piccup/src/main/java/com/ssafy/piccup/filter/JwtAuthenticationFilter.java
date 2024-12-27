package com.ssafy.piccup.filter;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// Authorization 헤더에서 토큰 추출
			String token = getJwtFromRequest(request);

			if (StringUtils.hasText(token) && jwtUtil.checkToken(token)) {
				// 토큰이 유효하면 사용자 정보 추출
				int userId = jwtUtil.getUserId(token);
				String email = jwtUtil.getUserEmail(token);
				
				// Spring Security 인증 객체 생성
				JwtAuthenticationToken authentication = new JwtAuthenticationToken(userId, email, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// SecurityContextHolder에 인증 객체 설정
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (ExpiredJwtException e) {
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        response.setContentType("application/json");
		        response.getWriter().write("{\"message\": \"토큰이 만료되었습니다.\"}");		        
		        return;
		} catch (Exception e) {
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.setContentType("application/json");
	        response.getWriter().write("{\"message\": \"인증 로직 예외가 발생하였습니다.\"}"+e.getMessage());
            return;
   		}

		// 다음 필터 체인으로 요청 전달
        filterChain.doFilter(request, response);
    }

	/**
     * Authorization 헤더에서 JWT 토큰을 추출하는 메서드
     * @param request HttpServletRequest 객체
     * @return JWT 토큰 문자열 (없으면 null 반환)
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
