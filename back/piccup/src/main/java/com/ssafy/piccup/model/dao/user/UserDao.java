package com.ssafy.piccup.model.dao.user;

import java.util.List;

import com.ssafy.piccup.model.dto.user.User;

public interface UserDao {

	// 사용자목록 전체조회
	public List<User> selectAll();
	
	// 사용자 조회
	public User selectOne();
	
}
