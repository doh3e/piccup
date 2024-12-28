package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.EducationDao;
import com.ssafy.piccup.model.dto.resume.Education;

@Service
public class EducationServiceImpl implements EducationService {

	private final EducationDao educationDao;
	
	public EducationServiceImpl(EducationDao educationDao) {
		this.educationDao = educationDao;
	}
	
	// 학력 조회 (resume 기반)
	@Override
	public List<Education> readEducationList(int resumeId) {
		List<Education> educationList = educationDao.selectAllEducation(resumeId);
		return educationList.isEmpty() ? new ArrayList<Education>() : educationList;
	}

	// 학력 리스트 추가
	@Transactional
	@Override
	public void createEducationList(List<Education> educations, int resumeId) {
		int result = 0;
		try {
			for (Education education : educations) {
				education.setResumeId(resumeId);
				if (educationDao.insertEducation(education) == 1) result += 1;
			}
			if (result != educations.size()) {
				throw new RuntimeException("create EducationList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }		
	}
}
