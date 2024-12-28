package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Education;


public interface EducationService {
	
	// 학력 조회 (resume 기반)
    public List<Education> readEducationList(int resumeId);

    // 학력 리스트 추가 - 성적증명서 제외
    public void createEducationList(List<Education> educations, int resumeId);
}
