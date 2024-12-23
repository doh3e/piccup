package com.ssafy.piccup.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.CoverLetterDao;
import com.ssafy.piccup.model.dto.CoverLetter;

@Service
public class CoverLetterServiceImpl implements CoverLetterService {
	private final CoverLetterDao coverLetterDao;
	
	public CoverLetterServiceImpl(CoverLetterDao coverLetterDao) {
		this.coverLetterDao = coverLetterDao;
	}
	
	@Override
	public List<CoverLetter> getCoverLetterList() {
		// TODO Auto-generated method stub
		return coverLetterDao.selectAll();
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
