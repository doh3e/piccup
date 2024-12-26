package com.ssafy.piccup.controller.resume;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.resume.Resume;
import com.ssafy.piccup.model.service.resume.ResumeService;
import com.ssafy.piccup.util.JwtUtil;

// 공통 이력서 관련
@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 의존성 주입
	private final ResumeService resumeService;
	private final JwtUtil jwtUtil;
	
	public ResumeController(
			ResumeService resumeService,
			JwtUtil jwtUtil) {
		this.resumeService = resumeService;
		this.jwtUtil = jwtUtil;
	}
	
	// 이력서 조회
	@GetMapping("")
	public ResponseEntity<?> getResume(){
		// 현재 인증 정보 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
        // 반환데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
	            
        // 이력서 정보 - userId와 연결된 이력서
		try {
			List<Resume> resumes = resumeService.findByUserId(userId);
			if (resumes.size() <= 0) {
				resultMap.put("message", "작성된 이력서가 없습니다.");
				status = HttpStatus.NO_CONTENT;
			}else {
				resultMap.put("resumes", resumes);
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeResume (@RequestHeader("Authorization") String header) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
	
		if (jwtUtil.checkToken(header)) {
			// 사용가능한 토큰
			try {
				// 사용자 정보 - JWT 토큰에서 userId 추출
	            String token = header.startsWith("Bearer ") ? header.substring(7) : header;
	            int userId = jwtUtil.getUserId(token);
	            System.out.println("결과: "+jwtUtil.getUserId(token));
	            
	            // 이력서 생성
	            Resume resume = new Resume();
	            resume.setUserId(userId);
	            boolean isCreated = resumeService.createResume(resume);
	            
	            if (isCreated) {
	            	resultMap.put("message", "이력서가 등록되었습니다.");
	            	status = HttpStatus.CREATED;
	            }
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}else {
			resultMap.put("message", "인증정보가 유효하지 않습니다.");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
// 검색 예 - DTO, Service 등 추가 작성 필요
//	@GetMapping("/search")
//	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
//		List<PersonalInfo> list = personalInfoService.search(condition);
//		
//		if(list == null || list.size() == 0) {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<PersonalInfo>>(list, HttpStatus.OK);
//	}
	
}
