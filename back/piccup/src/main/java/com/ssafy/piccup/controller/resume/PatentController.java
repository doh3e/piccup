package com.ssafy.piccup.controller.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.ssafy.piccup.model.dto.resume.Patent;
import com.ssafy.piccup.service.resume.PatentService;

// 특허 테이블 관련
@RestController
@RequestMapping("/patent")
public class PatentController {

	// 의존성 주입
	private final PatentService patentService;

	public PatentController(PatentService patentService) {
		this.patentService = patentService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Patent>> listPatent(Model model) {
		List<Patent> patents = patentService.readPatentList();
		return new ResponseEntity<>(patents, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writePatent(@RequestBody Patent patent) {
		// DB저장
		boolean isCreated = patentService.createPatent(patent);
		if (isCreated) {
			return new ResponseEntity<Patent>(patent, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("특허 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{patentId}")
	public ResponseEntity<String> modifyPatent(@PathVariable("patentId") int patentId, @RequestBody Patent patent) {
		patent.setPatentId(patentId);
		// DB 수정
		boolean isUpdated = patentService.updatePatent(patent);
		if (isUpdated) {
			return new ResponseEntity<>("특허 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("특허 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{patentId}")
	public ResponseEntity<String> removePatent(@PathVariable("patentId") int patentId) {
		boolean isDeleted = patentService.deletePatent(patentId);
		if (isDeleted) {
			return new ResponseEntity<>("특허 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("특허 삭제를 실패하였습니다.");
	}
}
