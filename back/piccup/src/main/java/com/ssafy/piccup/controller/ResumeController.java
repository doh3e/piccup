package com.ssafy.piccup.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.service.ResumeService;

// 공통 이력서 관련
@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 의존성 주입
	private final ResumeService resumeService;
	
	public ResumeController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	// 이력서 조회
//	@GetMapping("")
//	public ResponseEntity<?> getResume(@AuthenticationPrincipal UserPrincipal userPrincipal ){
//		int userId = userPrincipal.getUserId(); // 인증된 사용자 ID 추출
//		Resume resume = resumeService.findByUserId(userId);
//		if (resume != null) {
//			return ResponseEntity<Resume>(resume, HttpStatus.OK);
//		}
//		// user의 resum가 없는 경우
//		return new ResponseEntity<String>("user가 작성한 이력서가 없습니다.", HttpStatus.NOT_FOUND);
//	}
		
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
