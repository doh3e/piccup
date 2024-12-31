package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.PaperDao;
import com.ssafy.piccup.model.dto.resume.Paper;

@Service
public class PaperServiceImpl implements PaperService {

	private final PaperDao paperDao;
	
	public PaperServiceImpl(PaperDao PaperDao) {
		this.paperDao = PaperDao;
	}
	
	// 논문 조회 (resume 기반)
	@Override
	public List<Paper> readPaperList(int resumeId) {
		List<Paper> paperList = paperDao.selectAllPapers(resumeId);
		return paperList.isEmpty() ? new ArrayList<Paper>() : paperList;
	}
	
	// 논문 리스트 추가
	@Transactional
	@Override
	public void createPaperList(List<Paper> papers, int resumeId) {
		int result = 0;
		try {
			for (Paper paper : papers) {
				paper.setResumeId(resumeId);
				if (paperDao.insertPaper(paper) == 1) result += 1;
			}
			if (result != papers.size()) {
				throw new RuntimeException("create PaperList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
	}
}
