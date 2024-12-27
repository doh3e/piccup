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

import com.ssafy.piccup.model.dto.resume.Paper;
import com.ssafy.piccup.model.service.resume.PaperService;

// 논문 테이블 관련
@RestController
@RequestMapping("/paper")
public class PaperController {

	// 의존성 주입
	private final PaperService paperService;

	public PaperController(PaperService paperService) {
		this.paperService = paperService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Paper>> listPaper(Model model) {
		List<Paper> papers = paperService.readPaperList();
		return new ResponseEntity<>(papers, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writePaper(@RequestBody Paper paper) {
		// DB저장
		boolean isCreated = paperService.createPaper(paper);
		if (isCreated) {
			return new ResponseEntity<Paper>(paper, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("논문 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{paperId}")
	public ResponseEntity<String> modifyPaper(@PathVariable("paperId") int paperId, @RequestBody Paper paper) {
		paper.setPaperId(paperId);
		// DB 수정
		boolean isUpdated = paperService.updatePaper(paper);
		if (isUpdated) {
			return new ResponseEntity<>("논문 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("논문 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{paperId}")
	public ResponseEntity<String> removePaper(@PathVariable("paperId") int paperId) {
		boolean isDeleted = paperService.deletePaper(paperId);
		if (isDeleted) {
			return new ResponseEntity<>("논문 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("논문 삭제를 실패하였습니다.");
	}
}
