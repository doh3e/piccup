package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.Apply;
import com.ssafy.piccup.model.service.ApplyService;

@RestController
public class ApplyController {
	private final ApplyService applyService;
	
	public ApplyController(ApplyService applyService) {
		this.applyService = applyService;
	}
	@GetMapping("/applys")
	public ResponseEntity<List<Apply>> read() {
		List<Apply> list = applyService.getApplyList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/applys/{apply_id}")
	public ResponseEntity<Apply> detail(@PathVariable("apply_id")int apply_id) {
		Apply apply = applyService.viewApply(apply_id);
		if (apply == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(apply, HttpStatus.OK);
	}
	@PostMapping("/applys")
	public ResponseEntity<?> create(@RequestBody Apply apply) {
		applyService.addApply(apply);
		Apply createdApply = applyService.viewApply(apply.getApplyId());
		return new ResponseEntity<>(createdApply, HttpStatus.CREATED); 
	}
	@PutMapping("/applys/{apply_id}")
	public ResponseEntity<?> update(@PathVariable("apply_id")int applyId, @RequestBody Apply apply) {
		apply.setApplyId(applyId);
		boolean isUpdated = applyService.updateApply(apply);
		if (isUpdated) {
			Apply updatedApply = applyService.viewApply(applyId);
			return new ResponseEntity<>(updatedApply, HttpStatus.OK);
		}
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/applys/{apply_id}")
	public ResponseEntity<?> delete(@PathVariable("apply_id")int apply_id) {
		applyService.removeApply(apply_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
