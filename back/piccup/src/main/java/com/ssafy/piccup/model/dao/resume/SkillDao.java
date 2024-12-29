package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Skill;

public interface SkillDao {
	
	// 스킬 조회 (resume 기반)
    public List<Skill> selectAllSkills(int resumeId);

    // 스킬 추가
    public int insertSkill(Skill skill);
}
