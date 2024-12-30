package com.ssafy.piccup.controller;
import java.awt.datatransfer.Clipboard;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.CoverLetter;
import com.ssafy.piccup.model.service.CoverLetterService;
import com.ssafy.piccup.util.JwtUtil;

@RestController
@RequestMapping("/coverletters")
public class CoverLetterController {
	private CoverLetterService coverLetterService;
	private final JwtUtil jwtUtil;
	public CoverLetterController(CoverLetterService coverLetterService, JwtUtil jwtUtil) {
		this.coverLetterService = coverLetterService;
		this.jwtUtil = jwtUtil;
	}
	
	@GetMapping("")
	public ResponseEntity<List<CoverLetter>> read() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
		List<CoverLetter> letters = coverLetterService.getCoverLetterListByUserId(userId);
		return new ResponseEntity<>(letters, HttpStatus.OK);		
	}
	
	@GetMapping("/{cover_id}")
	public ResponseEntity<?> detail(@PathVariable("cover_id")int coverId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        // 로그인 유저와 작성자가 같은 경우에만 반환 
		CoverLetter letter = coverLetterService.viewCoverLetter(coverId);
		
		if (letter == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (letter.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 자소서가 아닙니다.");
		return new ResponseEntity<>(letter, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<CoverLetter> create(@RequestBody CoverLetter letter) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
		letter.setUserId(userId);
		coverLetterService.addCoverLetter(letter);
		CoverLetter createdCoverLetter = coverLetterService.viewCoverLetter(letter.getCoverId());
		if (createdCoverLetter != null) {
			return new ResponseEntity<>(createdCoverLetter, HttpStatus.CREATED);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@PutMapping("/{cover_id}")
	public ResponseEntity<?> update(@PathVariable("cover_id")int coverId, @RequestBody CoverLetter letter) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        
        // 로그인 유저와 작성자가 같은 경우에만 수정.
		CoverLetter temp = coverLetterService.viewCoverLetter(coverId);
		if (temp == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		if (temp.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 자소서가 아닙니다.");
		letter.setUserId(userId);
		letter.setCoverId(coverId);
		if (letter.getApplyId() == 0) letter.setApplyId(temp.getApplyId());
		
		boolean isUpdated = coverLetterService.modifyCoverLetter(letter);
		
		if (isUpdated) {
			CoverLetter updatedCoverLetter = coverLetterService.viewCoverLetter(coverId);
			return new ResponseEntity<>(updatedCoverLetter, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	
	@DeleteMapping("/{cover_id}")
	public ResponseEntity<String> delete(@PathVariable("cover_id")int coverId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 미인증 유저
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("인증되지 않은 사용자입니다");
        }
        
        // JwtAuthenticationToken에서 userId 가져오기
        JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
        int userId = jwtAuth.getUserId();
        // 로그인 유저와 작성자가 같은 경우에만 삭제
     	CoverLetter temp = coverLetterService.viewCoverLetter(coverId);
     	if (temp == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     	if (temp.getUserId() != userId) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("나의 자소서가 아닙니다.");
        
		coverLetterService.removeCoverLetter(coverId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	

}
