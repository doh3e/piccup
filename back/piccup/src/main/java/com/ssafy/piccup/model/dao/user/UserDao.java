package com.ssafy.piccup.model.dao.user;

import java.util.List;

import com.ssafy.piccup.model.dto.user.User;

public interface UserDao {

	// 사용자목록 전체조회
	public List<User> selectAll();
	
	// id기반 사용자 정보조회
	public User selectOneById(int userId);
	
	// 로그인
	public User selectOne(String email, String password);
	
	// 회원가입
	public int insertUser(User user);
	
	// 토큰 저장
	public void updateToken(int userId, String token);
}
