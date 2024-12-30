package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.coverletter.CoverLetterDao;
import com.ssafy.piccup.model.dto.coverletter.CoverLetter;

@Service
public class CoverLetterServiceImpl implements CoverLetterService {
	private final CoverLetterDao coverLetterDao;
	
	public CoverLetterServiceImpl(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}
	
	@Override
	public List<CoverLetter> getCoverLetterListByUserId(int userId) {
		// TODO Auto-generated method stub
		return coverLetterDao.selectAll(userId);
	}

	@Override
	public CoverLetter viewCoverLetter(int id) {
		// TODO Auto-generated method stub
		return coverLetterDao.selectOne(id);
	}

	@Override
	public void addCoverLetter(CoverLetter letter) {
		// TODO Auto-generated method stub
		coverLetterDao.insertCoverLetter(letter);
	}

	@Override
	public void removeCoverLetter(int id) {
		// TODO Auto-generated method stub
		coverLetterDao.deleteCoverLetter(id);
		
	}

	@Override
	public boolean modifyCoverLetter(CoverLetter letter) {		
		int result = coverLetterDao.updateCoverLetter(letter);
		return result == 1;
	}
	

}
