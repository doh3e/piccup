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

import com.ssafy.piccup.model.dto.resume.Project;
import com.ssafy.piccup.service.resume.ProjectService;

// 프로젝트 테이블 관련
@RestController
@RequestMapping("/project")
public class ProjectController {

	// 의존성 주입
	private final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Project>> listProject(Model model) {
		List<Project> projects = projectService.readProjectList();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeProject(@RequestBody Project project) {
		// DB저장
		boolean isCreated = projectService.createProject(project);
		if (isCreated) {
			return new ResponseEntity<Project>(project, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("프로젝트 추가에 실패하였습니다.");
	}

	// 수정
	@PutMapping("/{projectId}")
	public ResponseEntity<String> modifyProject(@PathVariable("projectId") int projectId, @RequestBody Project project) {
		project.setProjectId(projectId);
		// DB 수정
		boolean isUpdated = projectService.updateProject(project);
		if (isUpdated) {
			return new ResponseEntity<>("프로젝트 수정을 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("프로젝트 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
	}

	// 삭제
	@DeleteMapping("/{projectId}")
	public ResponseEntity<String> removeProject(@PathVariable("projectId") int projectId) {
		boolean isDeleted = projectService.deleteProject(projectId);
		if (isDeleted) {
			return new ResponseEntity<>("프로젝트 삭제를 성공하였습니다.", HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("프로젝트 삭제를 실패하였습니다.");
	}
}
