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

import com.ssafy.piccup.model.dto.resume.WorkExp;
import com.ssafy.piccup.model.service.resume.WorkExpService;

// 경력 테이블 관련
@RestController
@RequestMapping("/exp")
public class WorkExpController {
	// 의존성 주입
	private final WorkExpService workExpService;
	
	public WorkExpController(WorkExpService workExpService) {
		this.workExpService = workExpService;
	}
	
	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<WorkExp>> listWorkExp(Model model) {
		List<WorkExp> workExps = workExpService.readWorkExpList();
		return new ResponseEntity<>(workExps, HttpStatus.OK);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeWorkExp(
			@ModelAttribute WorkExp workExp,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		
		// 파일 존재하면, 업로드
		if (file != null) {
			boolean isFileUploaded = workExpService.uploadFile(workExp, file);
			if (!isFileUploaded) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드를 실패하였습니다.");
			}			
		}
		
		// DB저장
		boolean isCreated = workExpService.createWorkExp(workExp, file);
		if (isCreated) {
			return new ResponseEntity<WorkExp>(workExp, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("경력 등록을 실패하였습니다.");
	}
	
	// 수정
	@PutMapping("/{expId}")
	public ResponseEntity<String> modifyWorkExp(
			@PathVariable("expId") int expId,
			@ModelAttribute WorkExp workExp,
			@RequestParam(value = "file", required = false) MultipartFile file) { 
		workExp.setExpId(expId);
        
		// 파일 수정
		boolean isFileUpdated = workExpService.uploadFile(workExp, file);
		if(!isFileUpdated) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("경력 수정을 실패하였습니다. 취업사진을 포함하여야합니다.");
		}
		
		// DB 수정
	    boolean isUpdated = workExpService.updateWorkExp(workExp, file);
	    if (isUpdated) {
	    	return new ResponseEntity<>("경력 수정을 성공하였습니다.", HttpStatus.OK);	    	
	    }
	    return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("경력 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
    }
	
	// 삭제
	@DeleteMapping("/{expId}")
	public ResponseEntity<String> removeWorkExp(@PathVariable("expId") int expId){
		boolean isDeleted = workExpService.deleteWorkExp(expId);
	    if (isDeleted) {
	        return new ResponseEntity<>("경력 삭제를 성공하였습니다.", HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("경력 삭제를 실패하였습니다.");
	}
}
