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

import com.ssafy.piccup.model.dto.resume.Language;
import com.ssafy.piccup.model.service.resume.LanguageService;

// 어학 테이블 관련
@RestController
@RequestMapping("/language")
public class LanguageController {

	// 의존성 주입
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Language>> listLanguage(Model model) {
		List<Language> languages = languageService.readLanguageList();
		return new ResponseEntity<>(languages, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeLanguage(@RequestBody Language language) {
		// DB저장
		boolean isCreated = languageService.createLanguage(language);
		if (isCreated) {
			return new ResponseEntity<Language>(language, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("어학 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{languageId}")
	public ResponseEntity<String> modifyLanguage(@PathVariable("languageId") int languageId, @RequestBody Language language) {
		language.setLanguageId(languageId);
		// DB 수정
		boolean isUpdated = languageService.updateLanguage(language);
		if (isUpdated) {
			return new ResponseEntity<>("어학 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("어학 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{languageId}")
	public ResponseEntity<String> removeLanguage(@PathVariable("languageId") int languageId) {
		boolean isDeleted = languageService.deleteLanguage(languageId);
		if (isDeleted) {
			return new ResponseEntity<>("어학 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("어학 삭제를 실패하였습니다.");
	}
}
