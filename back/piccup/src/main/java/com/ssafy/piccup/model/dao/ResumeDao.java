package com.ssafy.piccup.model.dao;

import com.ssafy.piccup.model.dto.Resume;

public interface ResumeDao {
	// 이력서 조회
	public Resume selectResume(int userId);
	
	// 이력서 추가
	public void insertResume(Resume resume);
	
	// 이력서 삭제
	public void deleteResume(int resumeId);
	
	// 이력서 수정
	public void updateResume(Resume resume);
}