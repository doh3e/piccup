package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dto.PersonalInfo;
import com.ssafy.piccup.model.dto.Skill;
import com.ssafy.piccup.service.SkillService;

// 스킬 테이블 관련
@RestController
@RequestMapping("/skill")
public class SkillController {
	
	// 의존성 주입
	private final SkillService skillService;
	
	public SkillController(SkillService skillService) {
		this.skillService = skillService;
	}
	
	// 전체 조회
	@GetMapping("")
	public ResponseEntity<List<Skill>> listSkill(Model model) {
		List<Skill> skills = skillService.readSkillList();
		return new ResponseEntity<>(skills, HttpStatus.OK);
	}
	
	// 생성
	@PostMapping("")
	public ResponseEntity<?> writeSkill(@RequestBody Skill skill) {
		// DB저장
		boolean isCreated = skillService.createSkill(skill);
		if (isCreated) {
			return new ResponseEntity<Skill>(skill, HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스킬 추가에 실패하였습니다.");
	}
	
	// 수정
	@PutMapping("/{skillId}")
	public ResponseEntity<String> modifySkill(@PathVariable("skillId") int skillId, @RequestBody Skill skill) { 
		skill.setSkillId(skillId);
		// DB 수정
	    boolean isUpdated = skillService.updateSkill(skill);
	    if (isUpdated) {
	    	return new ResponseEntity<>("스킬 수정을 성공하였습니다.", HttpStatus.OK);	    	
	    }
	    return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body("스킬 수정을 실패하였습니다. 필수필드를 모두 포함하여야합니다.");
    }
	
	// 삭제
	@DeleteMapping("/{skillId}")
	public ResponseEntity<String> removeSkill(@PathVariable("skillId") int skillId){
		boolean isDeleted = skillService.deleteSkill(skillId);
	    if (isDeleted) {
	        return new ResponseEntity<>("스킬 삭제를 성공하였습니다.", HttpStatus.OK);
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스킬 삭제를 실패하였습니다.");
	}
}
