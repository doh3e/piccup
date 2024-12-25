package com.ssafy.piccup.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.user.UserDao;
import com.ssafy.piccup.model.dto.user.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 전체 사용자 목록 조회
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}
	
	// 특정 사용자 정보 조회
	@Override
	public User getUserInfo(int userId) {
		return userDao.selectOneById(userId);
	}
	
	// 회원가입
	@Transactional
	@Override
	public boolean signup(User user) {
		int result = userDao.insertUser(user);
		return result == 1;
	}

	// 로그인
	@Override
	public User login(String email, String password) {
		return userDao.selectOne(email, password);
//		Map<String, String> info = new HashMap<>();
//		info.put("userId", userId);
//		info.put("password", password);
//		User tmp = userDao.selectOne(info);
//		return tmp;
	}

	@Transactional
	@Override
	public void saveRefreshToken(int userId, String refreshToken) {
		userDao.updateToken(userId, refreshToken);
		return;
	}
}
