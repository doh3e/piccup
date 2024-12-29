package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Portfolio;

public interface PortfolioDao {

	// 포트폴리오 조회 (resume 기반)
    public List<Portfolio> selectAllPort(int resumeId);

    // 포트폴리오 저장 - 파일 별도
    public int insertPort(Portfolio portfolio);
}
