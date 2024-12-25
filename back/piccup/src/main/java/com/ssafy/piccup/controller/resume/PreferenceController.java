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

import com.ssafy.piccup.model.dto.resume.Preference;
import com.ssafy.piccup.service.resume.PreferenceService;

// 취업우대 테이블 관련
@RestController
@RequestMapping("/preference")
public class PreferenceController {

	// 의존성 주입
	private final PreferenceService preferenceService;

	public PreferenceController(PreferenceService preferenceService) {
		this.preferenceService = preferenceService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Preference>> listPreference(Model model) {
		List<Preference> preferences = preferenceService.readPreferenceList();
		return new ResponseEntity<>(preferences, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writePreference(@RequestBody Preference preference) {
		// DB저장
		boolean isCreated = preferenceService.createPreference(preference);
		if (isCreated) {
			return new ResponseEntity<Preference>(preference, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("취업우대 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{preId}")
	public ResponseEntity<String> modifyPreference(@PathVariable("preId") int preId, @RequestBody Preference preference) {
		preference.setPreId(preId);
		// DB 수정
		boolean isUpdated = preferenceService.updatePreference(preference);
		if (isUpdated) {
			return new ResponseEntity<>("취업우대 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("취업우대 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{preId}")
	public ResponseEntity<String> removePreference(@PathVariable("preId") int preId) {
		boolean isDeleted = preferenceService.deletePreference(preId);
		if (isDeleted) {
			return new ResponseEntity<>("취업우대 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("취업우대 삭제를 실패하였습니다.");
	}
}
