package com.ssafy.piccup.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<Resume> findByUserId(int userId) {
		return resumeDao.selectResume(userId);
	}

}
