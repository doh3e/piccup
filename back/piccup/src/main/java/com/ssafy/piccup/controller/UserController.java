package com.ssafy.piccup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.user.User;
import com.ssafy.piccup.model.service.user.UserService;
import com.ssafy.piccup.util.JwtUtil;


@RestController
@RequestMapping("/user")
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
	
	// 사용자 정보 조회
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
	
	// 사용자 회원가입
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.signup(user);
			String accessToken = jwtUtil.createAccessToken(user.getUserId(), user.getEmail());
			String refreshToken = jwtUtil.createRefreshToken(user.getUserId(), user.getEmail());
			
			// 발급받은 refresh token을 DB에 저장
			userService.saveRefreshToken(user.getUserId(), refreshToken);
			
			// JSON으로 token전달
			resultMap.put("access-token", accessToken);
			resultMap.put("refresh-token", refreshToken);
			status = HttpStatus.CREATED;

		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.ok("이미 존재하는 계정");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred during signup");
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;

		try {
			System.out.println("로그인 요청 : "+ user.getEmail() + user.getPassword());
			User loginUser = userService.login(user.getEmail(), user.getPassword());
			System.out.println("반환된 유저"+loginUser);
			if(loginUser != null) {
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId(), loginUser.getEmail());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId(), loginUser.getEmail());
				
				// 발급받은 refresh token을 DB에 저장
				userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				
				// JSON으로 token전달
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				
				status = HttpStatus.OK;
				
			} else {
				resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
				status = HttpStatus.UNAUTHORIZED;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public ResponseEntity<Map<String, Object>> logout(@RequestHeader("Authorization") String token) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;

		try {
			// 인증 정보
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;

			if (authentication == null || !authentication.isAuthenticated()) {
				resultMap.put("message", "인증되지 않은 사용자입니다.");
				status = HttpStatus.UNAUTHORIZED;
				return new ResponseEntity<>(resultMap, status);
			}

			String userEmail = jwtAuth.getName();
			// token = token.replace("Bearer", "");
			// String userEmail = jwtUtil.getUserEmail(token);
			// System.out.println(userEmail);

			// 토큰 삭제
			boolean logoutinfo = userService.logout(userEmail);
			if (logoutinfo == false) {
				resultMap.put("message", "사용자 토큰이 삭제되지 않았습니다.");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				return new ResponseEntity<>(resultMap, status);
			}

			// 인증 정보 제거
			SecurityContextHolder.clearContext();

			resultMap.put("message", "로그아웃 되었습니다.");

		} catch (Exception e) {
			resultMap.put("message", "로그아웃 중 오류가 발생했습니다.");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}
	
	// 회원 탈퇴
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody User user) {
		if (userService.login(user.getEmail(), user.getPassword()) != null) {
			userService.deleteUser(user.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body("탈퇴 완료");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("탈퇴 실패");
	}
}
