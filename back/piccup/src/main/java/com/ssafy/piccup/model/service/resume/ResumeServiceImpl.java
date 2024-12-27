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
	public boolean createResume(Resume resume) {
		int result = resumeDao.insertResume(resume);
		return result == 1;
	}

}
