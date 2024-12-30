package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.piccup.model.dto.coverletter.ApplyFeedback;
import com.ssafy.piccup.model.service.coverletter.ApplyFeedbackService;


@RestController
@RequestMapping("applys/feedback")
public class ApplyFeedbackController {
	private final ApplyFeedbackService applyFeedbackService;
	
	
	public ApplyFeedbackController(ApplyFeedbackService applyFeedbackService) {
		this.applyFeedbackService = applyFeedbackService;
	}


	@GetMapping("")
	public ResponseEntity<List<ApplyFeedback>> read() {
		List<ApplyFeedback> list = applyFeedbackService.getApplyFeedbackList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/{feedback_id}")
	public ResponseEntity<ApplyFeedback> detail(@PathVariable("feedback_id")int feedbackId) {
		ApplyFeedback feedback = applyFeedbackService.viewApplyFeedback(feedbackId);
		if (feedback == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody ApplyFeedback applyFeedback) {
		applyFeedbackService.addApplyFeedback(applyFeedback);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{feedback_id}")
	public ResponseEntity<?> update(@PathVariable("feedback_id")int feedbackId, @RequestBody ApplyFeedback applyFeedback) {
		applyFeedback.setFeedbackId(feedbackId);
		boolean isUpdated = applyFeedbackService.modifyApplyFeedback(applyFeedback);
		if (isUpdated) {
			ApplyFeedback updatedFeedback = applyFeedbackService.viewApplyFeedback(feedbackId);
			return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/{feedback_id}")
	public ResponseEntity<?> delete(@PathVariable("feedback_id")int feedbackId) {
		applyFeedbackService.removeApplyFeedback(feedbackId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
