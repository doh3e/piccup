package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.WorkExp;

public interface WorkExpDao {
	
	// 경력 전체 조회
    public List<WorkExp> selectAllWorkExp(int resumeId);

    // 경력 추가
    public int insertWorkExp(WorkExp workExp);

    // 경력 수정
    public int updateWorkExp(WorkExp workExp);

    // 경력 삭제
    public int deleteWorkExp(int expId);
    
   
}
