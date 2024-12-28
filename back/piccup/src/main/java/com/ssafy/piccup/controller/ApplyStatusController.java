package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.ApplySchedule;
import com.ssafy.piccup.model.dto.ApplyStatus;
import com.ssafy.piccup.model.service.ApplyStatusService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("applys/status")
public class ApplyStatusController {
	private final ApplyStatusService applyStatusService;
	
	public ApplyStatusController(ApplyStatusService applyStatusService) {
		this.applyStatusService = applyStatusService;
	}
	
	@GetMapping
	public ResponseEntity<List<ApplyStatus>> read() {
		List<ApplyStatus> list = applyStatusService.getApplyStatusList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{status_id}")
	public ResponseEntity<ApplyStatus> detail(@PathVariable("status_id")int statusId) {
		ApplyStatus status = applyStatusService.viewApplyStatus(statusId);
		if (status == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody ApplyStatus applyStatus) {
		applyStatusService.addApplyStatus(applyStatus);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{status_id}")
	public ResponseEntity<?> update(@PathVariable("status_id")int statusId, @RequestBody ApplyStatus applyStatus) {
		ApplyStatus originalStatus = applyStatusService.viewApplyStatus(statusId);
		applyStatus.setStatusId(statusId);
		if (applyStatus.getApplyId() == 0) applyStatus.setApplyId(originalStatus.getApplyId());
		boolean isUpdated = applyStatusService.modifyApplyStatus(applyStatus);
		if (isUpdated) {
			ApplyStatus updatedStatus = applyStatusService.viewApplyStatus(statusId);
			return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/{status_id}")
	public ResponseEntity<?> delete(@PathVariable("status_id")int statusId) {
		applyStatusService.removeApplyStatus(statusId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
