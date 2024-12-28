package com.ssafy.piccup.controller;
import java.awt.datatransfer.Clipboard;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

import com.ssafy.piccup.model.dto.CoverLetter;
import com.ssafy.piccup.model.service.CoverLetterService;

@RestController
@RequestMapping("/coverletters")
public class CoverLetterController {
	private CoverLetterService coverLetterService;
	
	public CoverLetterController(CoverLetterService coverLetterService) {
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<CoverLetter>> read() {
		
		List<CoverLetter> letters = coverLetterService.getCoverLetterList();
		return new ResponseEntity<>(letters, HttpStatus.OK);		
	}
	
	@GetMapping("/{cover_id}")
	public ResponseEntity<CoverLetter> detail(@PathVariable("cover_id")int cover_id) {
		
		CoverLetter letter = coverLetterService.viewCoverLetter(cover_id);
		if (letter != null) {
			return new ResponseEntity<>(letter, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("")
	public ResponseEntity<CoverLetter> create(@RequestBody CoverLetter letter) {
		coverLetterService.addCoverLetter(letter);
		if (letter != null) {
			return new ResponseEntity<>(letter, HttpStatus.CREATED);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@PutMapping("/{cover_id}")
	public ResponseEntity<?> update(@PathVariable("cover_id")int coverId, @RequestBody CoverLetter letter) {
		CoverLetter temp = coverLetterService.viewCoverLetter(coverId);
		letter.setCoverId(coverId);
		
		boolean isUpdated = coverLetterService.modifyCoverLetter(letter);
		
		if (isUpdated) {
			CoverLetter updatedCoverLetter = coverLetterService.viewCoverLetter(coverId);
			return new ResponseEntity<>(updatedCoverLetter, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	
	@DeleteMapping("/{cover_id}")
	public ResponseEntity<String> delete(@PathVariable("cover_id")int cover_id) {
		coverLetterService.removeCoverLetter(cover_id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	

}
