package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dao.resume.PortfolioDao;
import com.ssafy.piccup.model.dto.resume.Portfolio;

@Service
public class PortfolioServiceImpl implements PortfolioService{
	
    private final PortfolioDao portfolioDao;

    public PortfolioServiceImpl(PortfolioDao portfolioDao) {
    	this.portfolioDao = portfolioDao;
    }

    // 포트폴리오 조회 (resume 기반)
	@Override
	public List<Portfolio> readPortList(int resumeId) {
		List<Portfolio> portfolioList = portfolioDao.selectAllPort(resumeId);
		return portfolioList.isEmpty() ? new ArrayList<Portfolio>() : portfolioList;
	}

	// 포트폴리오 리스트 추가 - 파일별도
	@Transactional
	@Override
	public void createPortfolioList(List<Portfolio> portfolios, int resumeId) {
		int result = 0;
		try {
			for (Portfolio portfolio : portfolios) {
				portfolio.setResumeId(resumeId);
				if (portfolioDao.insertPort(portfolio) == 1) result += 1;
			}
			if (result != portfolios.size()) {
				throw new RuntimeException("create PortfolioList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
