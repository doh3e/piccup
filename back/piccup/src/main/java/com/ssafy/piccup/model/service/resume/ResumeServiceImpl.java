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
	
	// 이력서 조회
	@Override
	public Resume findByUserId(int userId) {
		return resumeDao.selectResume(userId);
	}
	
	// 이력서 생성
	@Transactional
	@Override
	public void createResume(Resume resume) {
		int result = 0;
		try {
	        result = resumeDao.insertResume(resume);
	        if (result != 1) {
	            throw new RuntimeException("createResume 불가");
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}

}
