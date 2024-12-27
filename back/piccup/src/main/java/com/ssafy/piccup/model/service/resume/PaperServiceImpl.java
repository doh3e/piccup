package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.PaperDao;
import com.ssafy.piccup.model.dto.resume.Paper;
import com.ssafy.piccup.model.dto.resume.Training;

@Service
public class PaperServiceImpl implements PaperService {

	private final PaperDao paperDao;
	
	public PaperServiceImpl(PaperDao PaperDao) {
		this.paperDao = PaperDao;
	}
	
	// 논문 전체 조회
	@Override
	public List<Paper> readPaperList(int resumeId) {
		List<Paper> paperList = paperDao.selectAllPapers(resumeId);
		return paperList.isEmpty() ? new ArrayList<Paper>() : paperList;
	}

    // 논문 추가
	@Transactional
	@Override
	public boolean createPaper(Paper paper) {
		int result = paperDao.insertPaper(paper);
		return result == 1;
	}

    // 논문 수정
	@Transactional
	@Override
	public boolean updatePaper(Paper paper) {
		int result = paperDao.updatePaper(paper);
		return result == 1;
	}

    // 논문 삭제
	@Transactional
	@Override
	public boolean deletePaper(int paperId) {
		int result = paperDao.deletePaper(paperId);
		return result == 1;
	}

}
