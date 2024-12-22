package com.ssafy.piccup.service;

import com.ssafy.piccup.model.dto.Resume;

public interface ResumeService {

	// 이력서 조회
	public Resume findByUserId(int userId);
}
