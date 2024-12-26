package com.ssafy.piccup.model.dao;

import java.util.List;

import com.ssafy.piccup.model.dto.User;


public interface UserDao {
	// 전체 유저 조회
	public List<User> selectAllUser();
	
	// 개별 유저 조회
	public User selectOneUser(int userId);	
	
	// 유저 등록
	public void registUser(User user);
	
	// 유저 삭제
	public void deleteUser(int userId);
	
	// 유저 수정
	public void updateUser(User user);
}
