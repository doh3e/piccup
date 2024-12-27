package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Paper;

public interface PaperDao {
	
	// 논문 전체 조회
    public List<Paper> selectAllPapers(int resumeId);

    // 논문 추가
    public int insertPaper(Paper paper);

    // 논문 수정
    public int updatePaper(Paper paper);

    // 논문 삭제
    public int deletePaper(int paperId);
}
