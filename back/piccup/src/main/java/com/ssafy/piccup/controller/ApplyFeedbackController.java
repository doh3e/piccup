package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.coverletter.Apply;
import com.ssafy.piccup.model.dto.coverletter.ApplyFeedback;
import com.ssafy.piccup.model.service.coverletter.ApplyFeedbackService;
import com.ssafy.piccup.model.service.coverletter.ApplyService;
import com.ssafy.piccup.util.JwtUtil;


@RestController
@RequestMapping("applys/feedback")
public class ApplyFeedbackController {
	private final ApplyService applyService;
	private final ApplyFeedbackService applyFeedbackService;
	private final JwtUtil jwtUtil;
	
	public ApplyFeedbackController(ApplyService applyService, ApplyFeedbackService applyFeedbackService, JwtUtil jwtUtil) {
		this.applyService = applyService;
		this.applyFeedbackService = applyFeedbackService;
		this.jwtUtil = jwtUtil;
	}


	@GetMapping("")
	public ResponseEntity<List<ApplyFeedback>> read() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
		List<ApplyFeedback> list = applyFeedbackService.getApplyFeedbackList(userId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/{feedback_id}")
	public ResponseEntity<?> detail(@PathVariable("feedback_id")int feedbackId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
     
		ApplyFeedback feedback = applyFeedbackService.viewApplyFeedback(feedbackId);
		if (feedback == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (feedback.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 피드백이 아닙니다.");
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody ApplyFeedback applyFeedback) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
        Apply apply = applyService.viewApply(applyFeedback.getApplyId());
        if (apply == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("지원서 정보가 없습니다.");
        if (apply.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 지원서가 아닙니다.");
        applyFeedback.setUserId(userId);
        
		applyFeedbackService.addApplyFeedback(applyFeedback);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{feedback_id}")
	public ResponseEntity<?> update(@PathVariable("feedback_id")int feedbackId, @RequestBody ApplyFeedback applyFeedback) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        ApplyFeedback temp = applyFeedbackService.viewApplyFeedback(feedbackId);
        if (temp.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 피드백이 아닙니다.");
        
		applyFeedback.setFeedbackId(feedbackId);
		applyFeedback.setUserId(userId);
		boolean isUpdated = applyFeedbackService.modifyApplyFeedback(applyFeedback);
		if (isUpdated) {
			ApplyFeedback updatedFeedback = applyFeedbackService.viewApplyFeedback(feedbackId);
			return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/{feedback_id}")
	public ResponseEntity<?> delete(@PathVariable("feedback_id")int feedbackId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        ApplyFeedback temp = applyFeedbackService.viewApplyFeedback(feedbackId);
        if (temp == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (temp.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 피드백이 아닙니다.");
        
		applyFeedbackService.removeApplyFeedback(feedbackId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
