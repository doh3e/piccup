package com.ssafy.piccup.controller.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.PersonalInfo;
import com.ssafy.piccup.model.service.resume.PersonalInfoService;

// 인적사항 테이블 관련
@RestController
@RequestMapping("/personal")
public class PersonalInfoController {
	
	// 의존성 주입
	private final PersonalInfoService personalInfoService;
	
	public PersonalInfoController(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}
	
	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<PersonalInfo>> listPersonal(Model model) {
		// 인적사항
		List<PersonalInfo> personalInfos = personalInfoService.readPersonalList();
		return new ResponseEntity<>(personalInfos, HttpStatus.OK);
	}
	
	// 특정 조회
	@GetMapping("/{infoId}")
	public ResponseEntity<?> detailPersonal(@PathVariable("infoId") int infoId) {
		PersonalInfo personalinfo = personalInfoService.readPersonal(infoId);
		if (personalinfo != null) {
			return new ResponseEntity<PersonalInfo>(personalinfo, HttpStatus.OK);
		}
		// infoId에 해당하는 데이터가 없는 경우
		return new ResponseEntity<String>("infoId에 해당하는 인적사항이 없습니다.", HttpStatus.NOT_FOUND);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writePersonal(
			@ModelAttribute PersonalInfo personalInfo,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		
		// 파일 존재하면, 업로드
		if (file != null) {
			boolean isFileUploaded = personalInfoService.uploadFile(personalInfo, file);
			if (!isFileUploaded) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드를 실패하였습니다.");
			}			
		}
		
		// DB저장
		boolean isCreated = personalInfoService.createPersonal(personalInfo, file);
		if (isCreated) {
			return new ResponseEntity<PersonalInfo>(personalInfo, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인적사항 등록을 실패하였습니다.");
	}
	
	// 수정
	@PutMapping("/{infoId}")
	public ResponseEntity<String> modifyPersonal(
			@PathVariable("infoId") int infoId,
			@ModelAttribute PersonalInfo personalInfo,
			@RequestParam(value = "file", required = false) MultipartFile file) { 
		personalInfo.setInfoId(infoId);
        
		// 파일 수정
		boolean isFileUpdated = personalInfoService.uploadFile(personalInfo, file);
		if(!isFileUpdated) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("파일 수정을 실패하였습니다. 취업사진을 포함하여야합니다.");
		}
		
		// DB 수정
	    boolean isUpdated = personalInfoService.updatePersonal(personalInfo, file);
	    if (isUpdated) {
	    	return new ResponseEntity<>("인적사항 수정을 성공하였습니다.", HttpStatus.OK);	    	
	    }
	    return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("인적사항 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
    }
	
	// 삭제
	@DeleteMapping("/{infoId}")
	public ResponseEntity<String> removePersonal(@PathVariable("infoId") int infoId){
		boolean isDeleted = personalInfoService.deletePersonal(infoId);
	    if (isDeleted) {
	        return new ResponseEntity<>("인적사항 삭제를 성공하였습니다.", HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인적사항 삭제를 실패하였습니다.");
	}
}
