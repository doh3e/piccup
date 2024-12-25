package com.ssafy.piccup.controller.resume;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.resume.Resume;
import com.ssafy.piccup.service.resume.ResumeService;
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
	public ResponseEntity<?> getResume(
			@RequestHeader("Authorization") String header){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		
		if(jwtUtil.checkToken(header)) {
			// 사용 가능한 토큰
			try {
				// 사용자 정보 - JWT 토큰에서 userId 추출
	            String token = header.startsWith("Bearer ") ? header.substring(7) : header;
	            int userId = jwtUtil.getUserId(token);
	            System.out.println("결과: "+jwtUtil.getUserId(token));
	            
	            // 이력서 정보 - userId와 연결된 이력서
	            List<Resume> resumes = resumeService.findByUserId(userId);
	            resultMap.put("resumes", resumes);
	            status = HttpStatus.OK;
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			resultMap.put("message", "사용 가능한 토큰이 아닙니다.");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 이력서 생성
	
	
	
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
