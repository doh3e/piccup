package com.ssafy.piccup.service.resume;

import com.ssafy.piccup.model.dto.resume.Resume;

public interface ResumeService {

	// 이력서 조회
	public Resume findByUserId(int userId);
}
