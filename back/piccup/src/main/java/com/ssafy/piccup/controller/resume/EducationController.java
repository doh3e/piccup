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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.resume.Education;
import com.ssafy.piccup.model.dto.resume.PersonalInfo;
import com.ssafy.piccup.model.service.resume.EducationService;

// 학력 테이블 관련
@RestController
@RequestMapping("/education")
public class EducationController {

	// 의존성 주입
	private final EducationService educationService;

	public EducationController(EducationService educationService) {
		this.educationService = educationService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Education>> listEducation(Model model) {
		List<Education> educations = educationService.readEducationList();
		return new ResponseEntity<>(educations, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeEducation(
			@ModelAttribute Education education,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		// 파일 존재하면, 업로드
		if (file != null) {
			boolean isFileUploaded = educationService.uploadFile(education, file);
			if (!isFileUploaded) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드를 실패하였습니다.");
			}			
		}
		// DB저장
		boolean isCreated = educationService.createEducation(education, file);
		if (isCreated) {
			return new ResponseEntity<Education>(education, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("학력 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{eduId}")
	public ResponseEntity<String> modifyEducation(
			@PathVariable("eduId") int eduId,
			@ModelAttribute Education education,
			@RequestParam(value = "file", required = false) MultipartFile file) { 
        
		// 파일 수정
		boolean isFileUpdated = educationService.uploadFile(education, file);
		if(!isFileUpdated) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("파일 수정을 실패하였습니다. 취업사진을 포함하여야합니다.");
		}

		// DB 수정
		boolean isUpdated = educationService.updateEducation(education, file);
		if (isUpdated) {
			return new ResponseEntity<>("학력 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("학력 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{eduId}")
	public ResponseEntity<String> removeEducation(@PathVariable("eduId") int eduId) {
		boolean isDeleted = educationService.deleteEducation(eduId);
		if (isDeleted) {
			return new ResponseEntity<>("학력 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("학력 삭제를 실패하였습니다.");
	}
}
