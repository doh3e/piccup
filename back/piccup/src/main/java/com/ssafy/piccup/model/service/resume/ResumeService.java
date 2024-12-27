package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Resume;

public interface ResumeService {

	// 이력서 조회
	public List<Resume> findByUserId(int userId);
	
	// 이력서 생성
	public boolean createResume(Resume resume);
}
