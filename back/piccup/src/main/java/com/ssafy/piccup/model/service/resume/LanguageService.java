package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Language;


public interface LanguageService {
	
	// 어학 조회 (resume 기반)
    public List<Language> readLanguageList(int resumeId);

    // 어학 리스트 추가
    public void createLanguageList(List<Language> languages, int resumeId);
}
