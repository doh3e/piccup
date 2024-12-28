package com.ssafy.piccup.model.service.resume;


import com.ssafy.piccup.model.dto.resume.Resume;

public interface ResumeService {

	// 이력서 조회 (user기반)
	public Resume findByUserId(int userId);
	
	// 이력서 생성
	public void createResume(Resume resume);
	
	// 이력서 삭제
	public void deleteResumeByUser(int userId);
}
