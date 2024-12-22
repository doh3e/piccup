package com.ssafy.piccup.service;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.ResumeDao;
import com.ssafy.piccup.model.dto.Resume;

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

}
