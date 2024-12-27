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

import com.ssafy.piccup.model.dto.resume.Certification;
import com.ssafy.piccup.model.service.resume.CertificationService;

// 자격증 테이블 관련
@RestController
@RequestMapping("/cert")
public class CertificationController {

	// 의존성 주입
	private final CertificationService certificationService;

	public CertificationController(CertificationService certificationService) {
		this.certificationService = certificationService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Certification>> listCert(Model model) {
		List<Certification> certs = certificationService.readCertificationList();
		return new ResponseEntity<>(certs, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeCert(@RequestBody Certification cert) {
		// DB저장
		boolean isCreated = certificationService.createCertification(cert);
		if (isCreated) {
			return new ResponseEntity<Certification>(cert, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("자격증 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{certId}")
	public ResponseEntity<String> modifyCert(@PathVariable("certId") int certId, @RequestBody Certification cert) {
		cert.setCertId(certId);
		// DB 수정
		boolean isUpdated = certificationService.updateCertification(cert);
		if (isUpdated) {
			return new ResponseEntity<>("자격증 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("자격증 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{certId}")
	public ResponseEntity<String> removeCert(@PathVariable("certId") int certId) {
		boolean isDeleted = certificationService.deleteCertification(certId);
		if (isDeleted) {
			return new ResponseEntity<>("자격증 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("자격증 삭제를 실패하였습니다.");
	}
}
