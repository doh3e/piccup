package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dao.resume.EducationDao;
import com.ssafy.piccup.model.dto.resume.Education;

@Service
public class EducationServiceImpl implements EducationService {

	private final EducationDao educationDao;
	
	public EducationServiceImpl(EducationDao educationDao) {
		this.educationDao = educationDao;
	}
	
	// 학력 전체 조회
	@Override
	public List<Education> readEducationList(int resumeId) {
		List<Education> educationList = educationDao.selectAllEducation(resumeId);
		return educationList.isEmpty() ? new ArrayList<Education>() : educationList;
	}

    // 학력 추가
	@Transactional
	@Override
	public boolean createEducation(Education education, MultipartFile file) {
		int result = educationDao.insertEducation(education);
		return result == 1;
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

	// 학력 수정
	@Transactional
	@Override
	public boolean updateEducation(Education education, MultipartFile file) {
		int result = educationDao.updateEducation(education);
		return result == 1;
	}

    // 학력 삭제
	@Transactional
	@Override
	public boolean deleteEducation(int eduId) {
		int result = educationDao.deleteEducation(eduId);
		return result == 1;
	}
}
