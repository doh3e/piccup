package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Paper;

public interface PaperDao {
	
	// 논문 조회 (resume 기반)
    public List<Paper> selectAllPapers(int resumeId);

    // 논문 추가
    public int insertPaper(Paper paper);
}
