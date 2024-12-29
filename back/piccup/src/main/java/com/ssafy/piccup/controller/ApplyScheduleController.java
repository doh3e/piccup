package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.piccup.model.dto.ApplySchedule;
import com.ssafy.piccup.model.service.ApplyScheduleService;


@RestController
@RequestMapping("applys/schedule")
public class ApplyScheduleController {
	private final ApplyScheduleService applyScheduleService;
	
	
	public ApplyScheduleController(ApplyScheduleService applyScheduleService) {
		this.applyScheduleService = applyScheduleService;
	}


	@GetMapping("")
	public ResponseEntity<List<ApplySchedule>> read() {
		List<ApplySchedule> list = applyScheduleService.getApplySchduleList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/{schedule_id}")
	public ResponseEntity<ApplySchedule> detail(@PathVariable("schedule_id")int scheduleId) {
		ApplySchedule schedule = applyScheduleService.viewApplySchedule(scheduleId);
		if (schedule == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(schedule, HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody ApplySchedule applySchedule) {
		applyScheduleService.addApplySchedule(applySchedule);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{schedule_id}")
	public ResponseEntity<?> update(@PathVariable("schedule_id")int scheduleId, @RequestBody ApplySchedule applySchedule) {
		applySchedule.setScheduleId(scheduleId);
		boolean isUpdated = applyScheduleService.modifyApplySchedule(applySchedule);
		if (isUpdated) {
			ApplySchedule updatedSchedule = applyScheduleService.viewApplySchedule(scheduleId);
			return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
	}
	@DeleteMapping("/{schedule_id}")
	public ResponseEntity<?> delete(@PathVariable("schedule_id")int scheduleId) {
		applyScheduleService.removeApplySchedule(scheduleId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
