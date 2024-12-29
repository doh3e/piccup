package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Portfolio;

public interface PortfolioService {
	
	// 포트폴리오 조회 (resume기반)
    public List<Portfolio> readPortList(int resumeId);

    // 포트폴리오 리스트 추가 - 파일별도
    public void createPortfolioList(List<Portfolio> portfolios, int resumeId);
}
