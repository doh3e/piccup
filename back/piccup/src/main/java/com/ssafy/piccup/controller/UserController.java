package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.piccup.model.dto.User;
import com.ssafy.piccup.model.service.PiccupUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private PiccupUserService userService;
	
	public UserController(PiccupUserService userService) {
		this.userService = userService;
	}
	
	///////////////////////////////////////////////////////////////
	// 회원 
	
	@GetMapping("/mainuser")
	public String mainuser() {
		return "/user/mainuser";
	}
	
	//// 회원가입
	
	// 회원가입 폼으로 이동
	@GetMapping("/join")
	public String joinform() {
		return "/user/joinform";
	}
	
	// 회원가입 - 유저 등록
//	@PostMapping("/join")
//	public String join(@ModelAttribute User user) {
//		try {
//			userService.joinUser(user);			
//			return "redirect:mainuser";
//		} catch (Exception e) {		
//			System.out.println("이미 등록된 유저");
//			return "redirect:joinform";
//		}
//	}
	@PostMapping("/join")
	public String join(@RequestBody User user) {
		userService.joinUser(user);
		return "redirect:loginform";
	}
	
	
	//// 로그인
	
	// 로그인 폼으로 이동
	@GetMapping("/login")
	public String loginform() {
		return "/user/loginform";
	}
	
	// 로그인 요청
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
		if (userService.infoUser(user.getUserId()) != null) {
			session.setAttribute("loginUser", user.getEmail());
			return "redirect:mainuser";
		} else {			
			System.out.println("잘못된 이메일, 비밀번호");
			return "redirect:loginform";
		}
	}
	
	//// 로그아웃
	
	// 로그아웃
	@PostMapping("/logout")
	public String logout() {
		return "redirect:list";
	}
	
	// 회원 탈퇴 확인 폼으로 이동
	@GetMapping("/deleteUser")
	public String deleteUer() {
		return "/user/deleteCheck";
	}
	
	// 회원 탈퇴 진행
	@PostMapping("/deleteUser")
	public String delete() {
		return "redirect:list";
	}
	
	////////////////////////////////////////////////////////////////

}
