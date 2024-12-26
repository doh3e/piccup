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

import com.ssafy.piccup.model.dto.resume.Oversea;
import com.ssafy.piccup.model.service.resume.OverseaService;

// 해외경험 테이블 관련
@RestController
@RequestMapping("/oversea")
public class OverseaController {

	// 의존성 주입
	private final OverseaService overseaService;

	public OverseaController(OverseaService overseaService) {
		this.overseaService = overseaService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Oversea>> listOversea(Model model) {
		List<Oversea> overseas = overseaService.readOverseaList();
		return new ResponseEntity<>(overseas, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeOversea(@RequestBody Oversea oversea) {
		// DB저장
		boolean isCreated = overseaService.createOversea(oversea);
		if (isCreated) {
			return new ResponseEntity<Oversea>(oversea, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해외경험 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{overseaId}")
	public ResponseEntity<String> modifyOversea(@PathVariable("overseaId") int overseaId, @RequestBody Oversea oversea) {
		oversea.setOverseaId(overseaId);
		// DB 수정
		boolean isUpdated = overseaService.updateOversea(oversea);
		if (isUpdated) {
			return new ResponseEntity<>("해외경험 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("해외경험 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{overseaId}")
	public ResponseEntity<String> removeOversea(@PathVariable("overseaId") int overseaId) {
		boolean isDeleted = overseaService.deleteOversea(overseaId);
		if (isDeleted) {
			return new ResponseEntity<>("해외경험 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("해외경험 삭제를 실패하였습니다.");
	}
}
