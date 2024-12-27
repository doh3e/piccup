package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Paper;


public interface PaperService {
	
	// 논문 전체 조회
    public List<Paper> readPaperList(int resumeId);

    // 논문 추가
    public boolean createPaper(Paper oversea);

    // 논문 수정
    public boolean updatePaper(Paper oversea);

    // 논문 삭제
    public boolean deletePaper(int overseaId);
}
