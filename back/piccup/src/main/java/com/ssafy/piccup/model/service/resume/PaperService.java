package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Paper;


public interface PaperService {
	
	// 논문 조회 (resume 기반)
    public List<Paper> readPaperList(int resumeId);

    // 논문 리스트 추가
    public void createPaperList(List<Paper> papers, int resumeId);
}
