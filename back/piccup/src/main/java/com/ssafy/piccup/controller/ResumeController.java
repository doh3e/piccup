package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.PersonalInfo;
import com.ssafy.piccup.service.PersonalInfoService;



@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 서비스 의존성 주입
	private final PersonalInfoService personalInfoService;
	
	public ResumeController(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}
	
	// 이력서 전체 조회
	@GetMapping("/")
	public ResponseEntity<List<PersonalInfo>> list(Model model) {
		// 인적사항
		List<PersonalInfo> personalInfos = personalInfoService.readPersonalList();
		return new ResponseEntity<>(personalInfos, HttpStatus.OK);
	}
	
	// 특정 인적사항 조회
	@GetMapping("/{infoId}")
	public ResponseEntity<?> detail(@PathVariable("infoId") int infoId) {
		PersonalInfo personalinfo = personalInfoService.readPersonal(infoId);
		if (personalinfo != null) {
			return new ResponseEntity<PersonalInfo>(personalinfo, HttpStatus.OK);
		}
		// infoId에 해당하는 데이터가 없는 경우
		return new ResponseEntity<String>("infoId에 해당하는 인적사항이 없습니다.", HttpStatus.NOT_FOUND);
	}
	
	// 인적사항 생성
	@PostMapping("/")
	public ResponseEntity<?> write(@RequestBody PersonalInfo personalInfo) {
		boolean isCreated = personalInfoService.createPersonal(personalInfo);
		if (isCreated) {
			return new ResponseEntity<PersonalInfo>(personalInfo, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인적사항 등록을 실패하였습니다.");
	}

	// 인적사항 삭제
	@DeleteMapping("/{infoId}")
	public ResponseEntity<String> remove(@PathVariable("infoId") int infoId){
		boolean isDeleted = personalInfoService.deletePersonal(infoId);
	    if (isDeleted) {
	        return new ResponseEntity<>("인적사항 삭제를 성공하였습니다.", HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인적사항 삭제를 실패하였습니다.");
	}
	
	// 인적사항 수정
	@PutMapping("/{infoId}")
	public ResponseEntity<String> updatePersonal(@PathVariable("infoId") int infoId, @RequestBody PersonalInfo personalInfo) {
	      personalInfo.setInfoId(infoId);
	      personalInfoService.updatePersonal(personalInfo);
	      return new ResponseEntity<>("인적사항 수정을 성공하였습니다.", HttpStatus.OK);
    }
}
