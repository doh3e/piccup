package com.ssafy.piccup.service.user;

import java.util.List;

import com.ssafy.piccup.model.dto.user.User;

public interface UserService {
	// 전체 사용자 목록 가져오기
	public List<User> getUserList();
	
	// 회원가입
	public void signup(User user);
	
	// 로그인
	public User login(String userId, String password);
}
