package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.WorkExp;

public interface WorkExpDao {
	
	// 경력 조회 (resume 기반)
    public List<WorkExp> selectAllWorkExp(int resumeId);

    // 경력 추가
    public int insertWorkExp(WorkExp workExp);
}
