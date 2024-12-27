package com.ssafy.piccup.controller.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.resume.Training;
import com.ssafy.piccup.model.service.resume.TrainingService;

// 교육 테이블 관련
@RestController
@RequestMapping("/training")
public class TrainingController {

	// 의존성 주입
	private final TrainingService trainingService;

	public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Training>> listTraining(Model model) {
		List<Training> trainings = trainingService.readTrainingList();
		return new ResponseEntity<>(trainings, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeTraining(@RequestBody Training training) {
		// DB저장
		boolean isCreated = trainingService.createTraining(training);
		if (isCreated) {
			return new ResponseEntity<Training>(training, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("교육 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{trainingId}")
	public ResponseEntity<String> modifyTraining(@PathVariable("trainingId") int trainingId, @RequestBody Training training) {
		training.setTrainingId(trainingId);
		// DB 수정
		boolean isUpdated = trainingService.updateTraining(training);
		if (isUpdated) {
			return new ResponseEntity<>("교육 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("교육 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{trainingId}")
	public ResponseEntity<String> removeTraining(@PathVariable("trainingId") int trainingId) {
		boolean isDeleted = trainingService.deleteTraining(trainingId);
		if (isDeleted) {
			return new ResponseEntity<>("교육 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("교육 삭제를 실패하였습니다.");
	}
}
