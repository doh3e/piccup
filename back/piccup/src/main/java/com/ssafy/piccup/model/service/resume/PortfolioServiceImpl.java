package com.ssafy.piccup.model.service.resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dao.resume.PortfolioDao;
import com.ssafy.piccup.model.dto.resume.Award;
import com.ssafy.piccup.model.dto.resume.Portfolio;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class PortfolioServiceImpl implements PortfolioService{
	
    private final PortfolioDao portfolioDao;
	private final ResourceLoader resourceLoader; // 파일작업

    public PortfolioServiceImpl(PortfolioDao portfolioDao, ResourceLoader resourceLoader) {
    	this.portfolioDao = portfolioDao;
    	this.resourceLoader = resourceLoader;
    }

    // 포트폴리오 전체 조회
	@Override
	public List<Portfolio> readPortList(int resumeId) {
		List<Portfolio> portfolioList = portfolioDao.selectAllPort(resumeId);
		return portfolioList.isEmpty() ? new ArrayList<Portfolio>() : portfolioList;
	}

	// 포트폴리오 추가
	@Transactional
	@Override
	public boolean createPort(Portfolio portfolio, MultipartFile file) {
		int result = portfolioDao.insertPort(portfolio);
		return result == 1;
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

	// 포트폴리오 수정
	@Transactional
	@Override
	public boolean updatePort(Portfolio portfolio, MultipartFile file) {
		int result = portfolioDao.updatePort(portfolio);
		return result == 1;
	}

	// 포트폴리오 삭제
	@Transactional
	@Override
	public boolean deletePort(int portId) {
		int result = portfolioDao.deletePort(portId);
		return result == 1;
	}
	
	// 파일 추가
	@Transactional
	@Override
	public boolean uploadFile(Portfolio portfolio, MultipartFile file) {
		// 파일이 존재할 때 처리
		if (file != null && file.getSize() > 0) {
			try {
				// 실제 파일이름 생성
				String portFileName = file.getOriginalFilename(); 
				
				// 확장자 추출
	            String fileExtension = "";
	            if (portFileName != null && portFileName.contains(".")) {
	                fileExtension = portFileName.substring(portFileName.lastIndexOf("."));
	            }
	            // 고유한 파일 이름 생성 (UUID + 확장자)
	            String portFilePath = UUID.randomUUID().toString() + fileExtension;
				
				portfolio.setPortFileName(portFileName);
				portfolio.setPortFilePath(portFilePath);
				
				Resource resource = resourceLoader.getResource("classpath:/static/portfolio_files");
				file.transferTo(new File(resource.getFile(), portFilePath)); // 파일저장
				
				return true; // 파일변환 성공
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true; // 파일 변환 실패
	}
}
