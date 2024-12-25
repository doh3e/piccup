package com.ssafy.piccup.controller.resume;


import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.resume.Resume;
import com.ssafy.piccup.service.resume.ResumeService;
import com.ssafy.piccup.service.user.UserService;
import com.ssafy.piccup.util.JwtUtil;

// 공통 이력서 관련
@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 의존성 주입
	private final ResumeService resumeService;
	private final JwtUtil jwtUtil;
	
	public ResumeController(ResumeService resumeService, JwtUtil jwtUtil) {
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
				// 사용자 정보
				int userId = resumeService.getUserId(token);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		int userId = userPrincipal.getUserId(); // 인증된 사용자 ID 추출
		Resume resume = resumeService.findByUserId(userId);
		if (resume != null) {
			return ResponseEntity<Resume>(resume, HttpStatus.OK);
		}
		// user의 resum가 없는 경우
		return new ResponseEntity<String>("user가 작성한 이력서가 없습니다.", HttpStatus.NOT_FOUND);
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
