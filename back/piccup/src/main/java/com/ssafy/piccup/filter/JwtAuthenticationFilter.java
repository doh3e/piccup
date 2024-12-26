package com.ssafy.piccup.filter;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.util.JwtUtil;

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
		
        String token = getJwtFromRequest(request);
        System.out.println("토큰확인 결과 : "+jwtUtil.checkToken(token));
        if (StringUtils.hasText(token) && jwtUtil.checkToken(token)) {
            int userId = jwtUtil.getUserId(token);
            String email = jwtUtil.getUserEmail(token);

            JwtAuthenticationToken authentication = new JwtAuthenticationToken(userId, email, null);
            System.out.println("authentication: "+authentication);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }

        System.out.println("진입");
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
        	System.out.println("입력: "+bearerToken.substring(7));
            return bearerToken.substring(7);
        }
        return null;
    }
}
