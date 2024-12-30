package com.ssafy.piccup.model.dao.coverletter;

import java.util.List;

import com.ssafy.piccup.model.dto.coverletter.CoverLetter;



public interface CoverLetterDao {
	
	public List<CoverLetter> selectAll(int userId);
	
	public CoverLetter selectOne(int id);
	
	public void insertCoverLetter(CoverLetter letter);
	
	public void deleteCoverLetter(int id);
	
	public int updateCoverLetter(CoverLetter letter);
	
	
}
