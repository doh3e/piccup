package com.ssafy.piccup.controller.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.user.User;
import com.ssafy.piccup.service.user.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 사용자 목록 가져오기
	@GetMapping()
	public ResponseEntity<List<User>> userList() {
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}
	
	// 특정 사용자 정보 보회
	
	// 사용자 회원가입
//	@PostMapping("/signup")
//	public ResponseEntity<?> signup(@RequestBody User user, HttpSession session) {
//		return new ResponseEntity<String>("success", HttpStatus.OK);
//	}
	
	
	// 로그인
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
//		User loginUser = userService.login(user.getEmail(), user.getPassword());
//		
//		// 로그인 성공
//		if (loginUser != null) {
//			session.setAttribute("loginUser", loginUser);
//			return ResponseEntity<String>("로그인 성공",HttpStatus.OK);
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 정보가 유효하지 않습니다.");
//	}
//	
	//------------------------------
	
	// 로그아웃
	@PostMapping("/logout")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
}
