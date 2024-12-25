package com.ssafy.piccup.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Resume;

public interface ResumeService {

	// 이력서 조회
	public List<Resume> findByUserId(int userId);
}
