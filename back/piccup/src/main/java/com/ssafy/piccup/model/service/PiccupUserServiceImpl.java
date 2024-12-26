package com.ssafy.piccup.model.service;

import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.UserDao;
import com.ssafy.piccup.model.dto.User;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class PiccupUserServiceImpl implements PiccupUserService{
	
	private final UserDao userDao;
//	private PasswordEncoder passwordEncoder;
	
	public PiccupUserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// 회원가입
	@Override
	public void joinUser(User user) {
		// user.setEmail(user.getEmail());
		// user.setNickname(user.getNickname());
		
		// user.getprofileImg == "" 이면 NULL 저장하도록 변경해야함
		user.setProfileImg(user.getProfileImg());
		
		//user.getmobilePhone == "" 이면 NULL 저장하도록 변경해야함
		user.setMobilePhone(user.getMobilePhone());
		
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userDao.registUser(user);
		
		System.out.println("회원가입 완료");
	}
	
	// 유저 정보 가져오기 (확인용)
	@Override
	public User infoUser(int userId) {
		User user = userDao.selectOneUser(userId);
		System.out.println(user);
		return null;
	}
	
	// 전체 유저 정보 가져오기 (확인용)
	@Override
	public List<User> getUserList() {
		List<User> users = userDao.selectAllUser();
		for(User user : users) {
			System.out.println(user);
		}
		return null;
	}

	// 회원 정보 변경
	@Override
	public User updateUser(User user) {
		return null;
	}

	// 회원 탈퇴
	@Override
	public User deleteUser(int userId) {
		userDao.deleteUser(userId);
		return null;
	}

}
