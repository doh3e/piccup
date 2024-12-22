package com.ssafy.piccup.service;

import java.util.List;

import com.ssafy.piccup.model.dto.Skill;


public interface SkillService {
	
	// 스킬 전체 조회
    public List<Skill> readSkillList();

    // 스킬 추가
    public boolean createSkill(Skill skill);

    // 스킬 수정
    public boolean updateSkill(Skill skill);

    // 스킬 삭제
    public boolean deleteSkill(int skillId);
}
