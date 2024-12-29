package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.SkillDao;
import com.ssafy.piccup.model.dto.resume.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	private final SkillDao skillDao;
	
	public SkillServiceImpl(SkillDao SkillDao) {
		this.skillDao = SkillDao;
	}
	
	// 스킬 조회 (resume 기반)
	@Override
	public List<Skill> readSkillList(int resumeId) {
		List<Skill> skillList = skillDao.selectAllSkills(resumeId);
		return skillList.isEmpty() ? new ArrayList<Skill>() : skillList;
	}

	// 스킬 리스트 추가
	@Transactional
	@Override
	public void createSkillList(List<Skill> skills, int resumeId) {
		int result = 0;
		try {
			for (Skill skill : skills) {
				skill.setResumeId(resumeId);
				if (skillDao.insertSkill(skill) == 1) result += 1;
			}
			if (result != skills.size()) {
				throw new RuntimeException("create SkillList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
