package com.ssafy.piccup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
import com.ssafy.piccup.model.dto.mydata.ApplyCalendarSchedule;
import com.ssafy.piccup.model.dto.mydata.DashBoard;
import com.ssafy.piccup.model.dto.mydata.DashBoardNumberData;
import com.ssafy.piccup.model.dto.mydata.Schedule;
import com.ssafy.piccup.model.service.mydata.CalendarService;
import com.ssafy.piccup.model.service.mydata.DashBoardService;

@RestController
@RequestMapping("/mydata")
public class MydataController {

	// 의존성 주입
	private final CalendarService calendarService;
	private final DashBoardService dashBoardService;

	public MydataController(CalendarService calendarService, DashBoardService dashBoardService) {
		this.calendarService = calendarService;
		this.dashBoardService = dashBoardService;
	}

	// 달력 전체 보기 (유저 전체 스케줄)
	@GetMapping("/calendar")
	public ResponseEntity<?> getCalendar() {

		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; // 토큰
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;

		try {
			List<Schedule> schedules = calendarService.getAllSchedule(userId);
			resultMap.put("schedules", schedules);
		}
		// 오류 예외처리
		catch (Exception e) {
			resultMap.clear();
			resultMap.put("message", "스케줄 데이터를 가져오는 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 유저의 임의 스케줄 추가
	@PostMapping("/calendar")
	public ResponseEntity<?> createSchedule(@RequestBody Schedule schedule) {

		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.CREATED;

		try {
			// Schedule 객체에 userId 설정
			schedule.setUserId(userId);

			// 스케줄 생성
			calendarService.createSchedule(schedule);
			resultMap.put("message", "스케줄이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			resultMap.clear();
			resultMap.put("message", "스케줄 생성 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}

	// 스케줄 하나만 보기
	@GetMapping("/calendar/{scheduleId}")
	public ResponseEntity<?> getScheduleById(@PathVariable int scheduleId) {

		// 현재 인증 정보에서 userId 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;

		try {
			// 스케줄 조회
			Schedule schedule = calendarService.getScheduleById(scheduleId);
			if (schedule == null || schedule.getUserId() != userId) {
				resultMap.put("message", "해당 스케줄을 조회할 권한이 없습니다.");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resultMap);
			}

			resultMap.put("schedule", schedule);
		} catch (Exception e) {
			resultMap.clear();
			resultMap.put("message", "스케줄 조회 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}

	// 스케줄 수정
	@PutMapping("/calendar/{scheduleId}")
	public ResponseEntity<?> updateSchedule(@PathVariable int scheduleId, @RequestBody Schedule schedule) {

		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;

		try {
			// 스케줄이 해당 사용자 소유인지 확인
			Schedule existingSchedule = calendarService.getScheduleById(scheduleId);
			if (existingSchedule == null || existingSchedule.getUserId() != userId) {
				resultMap.put("message", "수정 권한이 없습니다.");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resultMap);
			}

			// 스케줄 업데이트
			schedule.setScheduleId(scheduleId); // URL의 scheduleId를 덮어씌움
			schedule.setUserId(userId); // 인증된 userId를 덮어씌움
			calendarService.updateSchedule(schedule);

			resultMap.put("message", "스케줄이 성공적으로 수정되었습니다.");
		} catch (Exception e) {
			resultMap.clear();
			resultMap.put("message", "스케줄 수정 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}
	
	// 스케줄 삭제
	@DeleteMapping("/calendar/{scheduleId}")
	public ResponseEntity<?> deleteSchedule(@PathVariable int scheduleId) {

		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;

		try {
			// 스케줄이 해당 사용자 소유인지 확인
			Schedule existingSchedule = calendarService.getScheduleById(scheduleId);
			if (existingSchedule == null || existingSchedule.getUserId() != userId) {
				resultMap.put("message", "삭제 권한이 없습니다.");
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resultMap);
			}
			
			calendarService.deleteScheduleById(scheduleId);


			resultMap.put("message", "delete success");
		} catch (Exception e) {
			resultMap.clear();
			resultMap.put("message", "스케줄 삭제 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}

	// 지원 스케줄 전체 보기
	@GetMapping("/applyschedule")
	public ResponseEntity<?> getApplySchedule() {

		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 인증정보
		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication; // 토큰
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			List<ApplyCalendarSchedule> applySchedules = calendarService.getAllApplySchedules(userId);
			resultMap.put("applySchedules", applySchedules);
		} catch (Exception e) {
			resultMap.put("message", "지원 스케줄 데이터를 가져오는 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}

	// 지원 스케줄 상세 보기
	@GetMapping("/applyschedule/{applyId}")
	public ResponseEntity<?> getApplyScheduleDetail(@PathVariable int applyId) {
		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;

		try {
			// 특정 applyId의 지원 스케줄 조회
			ApplyCalendarSchedule applySchedule = calendarService.getApplyScheduleById(applyId, userId);
			if (applySchedule == null) {
				resultMap.put("message", "해당 지원 스케줄이 존재하지 않거나 접근 권한이 없습니다.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultMap);
			}

			resultMap.put("applySchedule", applySchedule);
		} catch (Exception e) {
			resultMap.put("message", "지원 스케줄 조회 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(resultMap, status);
	}
	
	// 나의 데이터 한 눈에 확인하기
	@GetMapping("/dashboard")
	public ResponseEntity<?> getDashBoard() {
		// 현재 인증 정보에서 user id 가져오기
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof JwtAuthenticationToken)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "인증 정보가 올바르지 않습니다."));
		}

		JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
		int userId = jwtAuth.getUserId();

		// 반환 데이터
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.OK;
		
		try {
			
			List<DashBoard> dashboard = dashBoardService.getDashBoard(userId);
			DashBoardNumberData dashBoardNumberData = dashBoardService.getDashBoardNumberData(userId);
			
		    resultMap.put("dashboard", dashboard);
		    resultMap.put("summary", dashBoardNumberData);
			
		} catch (Exception e) {
			resultMap.put("message", "대시보드 데이터 생성 중 오류 발생: " + e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;			
		}
		
		return new ResponseEntity<>(resultMap, status);
	}

}
