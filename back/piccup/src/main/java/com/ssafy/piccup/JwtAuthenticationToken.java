package com.ssafy.piccup;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

	private final int userId;
	private final String email;
	
	public JwtAuthenticationToken(int userId, String email, Object credentials) {
		super(null);
		this.userId = userId;
		this.email = email;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return email;
	}
	
	public int getUserId() {
		return userId;
	}
}
