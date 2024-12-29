package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Education;

public interface EducationDao {
	
	// 학력 조회 (resume 기반)
    public List<Education> selectAllEducation(int resumeId);

    // 학력 추가
    public int insertEducation(Education education);
}
