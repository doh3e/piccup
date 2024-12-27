package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Education;

public interface EducationDao {
	
	// 학력 전체 조회
    public List<Education> selectAllEducation();

    // 학력 추가
    public int insertEducation(Education education);

    // 학력 수정
    public int updateEducation(Education education);

    // 학력 삭제
    public int deleteEducation(int eduId);
}
