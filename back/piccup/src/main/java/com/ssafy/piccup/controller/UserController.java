package com.ssafy.piccup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.user.User;
import com.ssafy.piccup.model.service.user.UserService;
import com.ssafy.piccup.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	private final UserService userService;
	private final JwtUtil jwtUtil;
	
	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	// 사용자 목록 가져오기
	@GetMapping()
	public ResponseEntity<?> userList() {
		List<User> list = userService.getUserList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>( HttpStatus.OK);
	}
	
	// 사용자 정보 보회
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") int userId,
			@RequestHeader("Authorization") String header){
//		log.debug("userId : {}, header: {}", userId, header);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtUtil.checkToken(header)) {
//			log.info("사용 가능한 토큰");
			try {
				// 사용자 정보
				User userById = userService.getUserInfo(userId);
				resultMap.put("userInfo", userById);
				status = HttpStatus.OK;
			} catch (Exception e) {
//				log.error("정보조회 실패: {} ", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
//			log.error("사용 불가능한 토큰");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 사용자 회원가입 (토큰 미부여)
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		if (userService.signup(user)) {
			return ResponseEntity.status(HttpStatus.CREATED).body("회원가입에 성공하였습니다.");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패하였습니다.");
	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;

		try {
			User loginUser = userService.login(user.getEmail(), user.getPassword());
			if(loginUser != null) {
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId(), loginUser.getEmail());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId(), loginUser.getEmail());
//				log.debug("access token: {}", accessToken);
//				log.debug("refresh token: {}", refreshToken);
				
				// 발급받은 refresh token을 DB에 저장
				userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				
				// JSON으로 token전달
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				
				status = HttpStatus.CREATED;
				
			} else {
				resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
				status = HttpStatus.UNAUTHORIZED;
			}
		} catch (Exception e) {
//			log.debug("로그인 에러 발생 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
}
