package com.ssafy.piccup.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.user.UserDao;
import com.ssafy.piccup.model.dto.user.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	
	@Override
	public void signup(User user) {
	}

	@Override
	public User login(String userId, String password) {
		return userDao.selectOne();
//		Map<String, String> info = new HashMap<>();
//		info.put("userId", userId);
//		info.put("password", password);
//		User tmp = userDao.selectOne(info);
//		return tmp;
	}

}
