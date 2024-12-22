package com.ssafy.piccup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.SkillDao;
import com.ssafy.piccup.model.dto.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	private final SkillDao skillDao;
	
	public SkillServiceImpl(SkillDao SkillDao) {
		this.skillDao = SkillDao;
	}
	
	// 스킬 전체 조회
	@Override
	public List<Skill> readSkillList() {
		return skillDao.selectAllSkills();
	}

    // 스킬 추가
	@Transactional
	@Override
	public boolean createSkill(Skill skill) {
		int result = skillDao.insertSkill(skill);
		return result == 1;
	}

    // 스킬 수정
	@Transactional
	@Override
	public boolean updateSkill(Skill skill) {
		int result = skillDao.updateSkill(skill);
		return result == 1;
	}

    // 스킬 삭제
	@Transactional
	@Override
	public boolean deleteSkill(int skillId) {
		int result = skillDao.deleteSkill(skillId);
		return result == 1;
	}

}
