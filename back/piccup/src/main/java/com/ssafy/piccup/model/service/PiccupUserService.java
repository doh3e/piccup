package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.User;

public interface PiccupUserService {
	// 회원가입 (회원 등록)
	public void joinUser(User user);
	
	// 회원 정보 조회
	public User infoUser(int userId);
	
	// 모든 회원 정보 조회 (확인용)
	public List<User> getUserList();
	
	// 회원 정보 수정
	public User updateUser(User user);
	
	// 회원 탈퇴
	public User deleteUser(int userId);
}
