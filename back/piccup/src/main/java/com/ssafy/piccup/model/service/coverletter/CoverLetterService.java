package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.coverletter.CoverLetter;

@Service
public interface CoverLetterService {
	public List<CoverLetter> getCoverLetterListByUserId(int userId);
	
	public CoverLetter viewCoverLetter(int id);
	
	public void addCoverLetter(CoverLetter letter);
	
	public void removeCoverLetter(int id);
	
	public boolean modifyCoverLetter(CoverLetter letter);
}
