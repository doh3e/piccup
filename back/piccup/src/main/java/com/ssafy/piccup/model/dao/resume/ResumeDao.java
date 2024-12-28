package com.ssafy.piccup.model.dao.resume;


import com.ssafy.piccup.model.dto.resume.Resume;

public interface ResumeDao {
	// 이력서 조회 (user 기반)
	public Resume selectResumeByUser(int userId);
	
	// 이력서 추가
	public int insertResume(Resume resume);
	
	// 이력서 삭제
	public int deleteResumeByUser(int resumeId);
}