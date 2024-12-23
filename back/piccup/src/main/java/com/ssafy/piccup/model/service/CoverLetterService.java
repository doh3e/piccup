package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.CoverLetter;

public interface CoverLetterService {
	public List<CoverLetter> getCoverLetterList();
	
	public CoverLetter viewCoverLetter(int id);
	
	public void addCoverLetter(CoverLetter letter);
	
	public void removeCoverLetter(int id);
	
	public boolean modifyCoverLetter(CoverLetter letter);
}
