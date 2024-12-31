package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.coverletter.Apply;
import com.ssafy.piccup.model.service.coverletter.ApplyService;
import com.ssafy.piccup.util.JwtUtil;

@RestController
@RequestMapping("/applys")
public class ApplyController {
	private final ApplyService applyService;
	private final JwtUtil jwtUtil;
	
	public ApplyController(ApplyService applyService, JwtUtil jwtUtil) {
		this.applyService = applyService;
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Apply>> read() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
		List<Apply> list = applyService.getApplyListByUserId(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/{apply_id}")
	public ResponseEntity<?> detail(@PathVariable("apply_id")int apply_id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
		Apply apply = applyService.viewApply(apply_id);
		if (apply == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (apply.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 지원서가 아닙니다.");
		return new ResponseEntity<>(apply, HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Apply apply) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        apply.setUserId(userId);
		applyService.addApply(apply);
		Apply createdApply = applyService.viewApply(apply.getApplyId());
		return new ResponseEntity<>(createdApply, HttpStatus.CREATED); 
	}
	@PutMapping("/{apply_id}")
	public ResponseEntity<?> update(@PathVariable("apply_id")int applyId, @RequestBody Apply apply) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        // 로그인 유저가 다른 유저의 지원서를 수정하려는 경우
		Apply tempApply = applyService.viewApply(applyId);
		if (tempApply == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (userId != tempApply.getUserId()) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 지원서가 이닙니다.");
		
		apply.setApplyId(applyId);
		boolean isUpdated = applyService.updateApply(apply);
		if (isUpdated) {
			Apply updatedApply = applyService.viewApply(applyId);
			return new ResponseEntity<>(updatedApply, HttpStatus.OK);
		}
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/{apply_id}")
	public ResponseEntity<?> delete(@PathVariable("apply_id")int applyId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        // 로그인 유저가 다른 유저의 지원서를 삭제하려는 경우
		Apply tempApply = applyService.viewApply(applyId);
		if (tempApply == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (userId != tempApply.getUserId()) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 지원서가 이닙니다.");
		
		applyService.removeApply(applyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
