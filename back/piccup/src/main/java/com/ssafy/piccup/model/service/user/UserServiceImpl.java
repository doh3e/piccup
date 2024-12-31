package com.ssafy.piccup.model.service.user;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.user.UserDao;
import com.ssafy.piccup.model.dto.user.User;

@Service
public class UserServiceImpl implements UserService {
	
	// private final UserDao userDao;

	// public UserServiceImpl(UserDao userDao) {
	// 	this.userDao = userDao;
	// }
	private final UserDao userDao;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		int result = userDao.insertUser(user);
		return result == 1;
	}

	// 회원 탈퇴
	@Override
	public void deleteUser(String email) {
		
		userDao.deleteUser(email);
	}

	// 로그인
	@Override
	public User login(String email, String password) {
		// return userDao.selectOne(email, password);
		User user = userDao.selectOneByEmail(email);
		// System.out.println(password);
		// System.out.println(user.getPassword());
		if (passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		return null;
	}

	// 로그아웃
	@Override
	public boolean logout(String email) {
		int result = userDao.deleteToken(email);
		return result == 1;
	}

	// 토큰 저장
	@Transactional
	@Override
	public void saveRefreshToken(int userId, String refreshToken) {
		userDao.updateToken(userId, refreshToken);
		return;
	}
}
