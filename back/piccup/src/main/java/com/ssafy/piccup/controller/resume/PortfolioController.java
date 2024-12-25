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

import com.ssafy.piccup.model.dto.resume.Portfolio;
import com.ssafy.piccup.service.resume.PortfolioService;

// 포트폴리오 테이블 관련
@RestController
@RequestMapping("/port")
public class PortfolioController {
	
	// 의존성 주입
	private final PortfolioService portfolioService;
	
	public PortfolioController(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}
	
	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Portfolio>> listPort(Model model) {
		// 포트폴리오
		List<Portfolio> portfolios = portfolioService.readPortList();
		return new ResponseEntity<>(portfolios, HttpStatus.OK);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writePort(
			@ModelAttribute Portfolio portfolio,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		
		// 파일 존재하면, 업로드
		if (file != null) {
			boolean isFileUploaded = portfolioService.uploadFile(portfolio, file);
			if (!isFileUploaded) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드를 실패하였습니다.");
			}			
		}
		
		// DB저장
		boolean isCreated = portfolioService.createPort(portfolio, file);
		if (isCreated) {
			return new ResponseEntity<Portfolio>(portfolio, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("포트폴리오 등록을 실패하였습니다.");
	}
	
	// 수정
	@PutMapping("/{portId}")
	public ResponseEntity<String> modifyPort(
			@PathVariable("portId") int portId,
			@ModelAttribute Portfolio portfolio,
			@RequestParam(value = "file", required = false) MultipartFile file) { 
		portfolio.setPortId(portId);
        
		// 파일 수정
		boolean isFileUpdated = portfolioService.uploadFile(portfolio, file);
		if(!isFileUpdated) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("파일 수정을 실패하였습니다. 취업사진을 포함하여야합니다.");
		}
		
		// DB 수정
	    boolean isUpdated = portfolioService.updatePort(portfolio, file);
	    if (isUpdated) {
	    	return new ResponseEntity<>("포트폴리오 수정을 성공하였습니다.", HttpStatus.OK);	    	
	    }
	    return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("포트폴리오 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
    }
	
	// 삭제
	@DeleteMapping("/{portId}")
	public ResponseEntity<String> removePort(@PathVariable("portId") int portId){
		boolean isDeleted = portfolioService.deletePort(portId);
	    if (isDeleted) {
	        return new ResponseEntity<>("포트폴리오 삭제를 성공하였습니다.", HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("포트폴리오 삭제를 실패하였습니다.");
	}
}
