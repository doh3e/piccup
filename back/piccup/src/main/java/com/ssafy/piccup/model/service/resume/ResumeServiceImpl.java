package com.ssafy.piccup.model.service.resume;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.ResumeDao;
import com.ssafy.piccup.model.dto.resume.Resume;

@Service
public class ResumeServiceImpl implements ResumeService {

	private final ResumeDao resumeDao;
	
	public ResumeServiceImpl(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}
	
	// 이력서 조회 (user기반)
	@Override
	public Resume findByUserId(int userId) {
		return resumeDao.selectResumeByUser(userId);
	}
	
	// 이력서 생성
	@Transactional
	@Override
	public void createResume(Resume resume) {
		try {
			// 기존 Resume 존재 여부 확인
			Resume existingResume = resumeDao.selectResumeByUser(resume.getUserId());
			// 기존 Resume 삭제
			if (existingResume != null) {
				resumeDao.deleteResumeByUser(existingResume.getUserId());
			}

			// 새로운 Resume 생성
			if (resumeDao.insertResume(resume) != 1) {
				throw new RuntimeException("createResume 실패");
	        }
	    } catch (Exception e) {
	    	throw new RuntimeException("createResume 과정에서 오류 발생: " + e.getMessage(), e);
	    }
	}

	// 이력서 삭제
	@Transactional
	@Override
	public void deleteResumeByUser(int userId) {
		try {
			resumeDao.deleteResumeByUser(userId);
		} catch (Exception e) {
			throw new RuntimeException("deleteResume 과정에서 오류 발생: "+ e.getMessage(), e);
		}
	}
}
