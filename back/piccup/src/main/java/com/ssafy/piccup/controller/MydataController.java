package com.ssafy.piccup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.JwtAuthenticationToken;
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

	// 달력 전체 보기
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

}
