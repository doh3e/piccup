package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Skill;

public interface SkillDao {
	
	// 스킬 전체 조회
    public List<Skill> selectAllSkills();

    // 스킬 추가
    public int insertSkill(Skill skill);

    // 스킬 수정
    public int updateSkill(Skill skill);

    // 스킬 삭제
    public int deleteSkill(int skillId); // 실제 테이블에서 건드려지는 개수 반환 (1개 삭제 -> 1 or 0)
}
