package com.ssafy.piccup.controller.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.resume.Activity;
import com.ssafy.piccup.service.resume.ActivityService;

// 대내외활동 테이블 관련
@RestController
@RequestMapping("/activity")
public class ActivityController {

	// 의존성 주입
	private final ActivityService activityService;

	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Activity>> listActivity(Model model) {
		List<Activity> activitys = activityService.readActivityList();
		return new ResponseEntity<>(activitys, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeActivity(@RequestBody Activity activity) {
		// DB저장
		boolean isCreated = activityService.createActivity(activity);
		if (isCreated) {
			return new ResponseEntity<Activity>(activity, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("대내외활동 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{actId}")
	public ResponseEntity<String> modifyActivity(@PathVariable("actId") int actId, @RequestBody Activity activity) {
		activity.setActId(actId);
		// DB 수정
		boolean isUpdated = activityService.updateActivity(activity);
		if (isUpdated) {
			return new ResponseEntity<>("대내외활동 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("대내외활동 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{actId}")
	public ResponseEntity<String> removeActivity(@PathVariable("actId") int actId) {
		boolean isDeleted = activityService.deleteActivity(actId);
		if (isDeleted) {
			return new ResponseEntity<>("대내외활동 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("대내외활동 삭제를 실패하였습니다.");
	}
}
