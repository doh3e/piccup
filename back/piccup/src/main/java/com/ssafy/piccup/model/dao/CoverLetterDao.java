package com.ssafy.piccup.model.dao;

import java.util.List;

import com.ssafy.piccup.model.dto.CoverLetter;



public interface CoverLetterDao {
	
	public List<CoverLetter> selectAll();
	
	public CoverLetter selectOne(int id);
	
	public void insertCoverLetter(CoverLetter letter);
	
	public void deleteCoverLetter(int id);
	
	public int updateCoverLetter(CoverLetter letter);
	
	
}
