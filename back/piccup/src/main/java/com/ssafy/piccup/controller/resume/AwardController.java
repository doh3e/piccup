package com.ssafy.piccup.controller.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.resume.Award;
import com.ssafy.piccup.service.resume.AwardService;

// 수상내역 테이블 관련
@RestController
@RequestMapping("/award")
public class AwardController {

	// 의존성 주입
	private final AwardService awardService;

	public AwardController(AwardService awardService) {
		this.awardService = awardService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Award>> listAward(Model model) {
		List<Award> awards = awardService.readAwardList();
		return new ResponseEntity<>(awards, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeAward(@RequestBody Award award) {
		// DB저장
		boolean isCreated = awardService.createAward(award);
		if (isCreated) {
			return new ResponseEntity<Award>(award, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수상내역 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{awardId}")
	public ResponseEntity<String> modifyAward(@PathVariable("awardId") int awardId, @RequestBody Award award) {
		award.setAwardId(awardId);
		// DB 수정
		boolean isUpdated = awardService.updateAward(award);
		if (isUpdated) {
			return new ResponseEntity<>("수상내역 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("수상내역 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{awardId}")
	public ResponseEntity<String> removeAward(@PathVariable("awardId") int awardId) {
		boolean isDeleted = awardService.deleteAward(awardId);
		if (isDeleted) {
			return new ResponseEntity<>("수상내역 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수상내역 삭제를 실패하였습니다.");
	}
}
