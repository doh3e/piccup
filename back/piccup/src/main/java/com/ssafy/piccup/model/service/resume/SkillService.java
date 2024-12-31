package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Skill;


public interface SkillService {
	
	// 스킬 조회 (resume 기반)
    public List<Skill> readSkillList(int resumeId);

    // 스킬 리스트 추가
    public void createSkillList(List<Skill> skills, int resumeId);
}
