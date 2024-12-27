package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Language;


public interface LanguageService {
	
	// 어학 전체 조회
    public List<Language> readLanguageList();

    // 어학 추가
    public boolean createLanguage(Language oversea);

    // 어학 수정
    public boolean updateLanguage(Language oversea);

    // 어학 삭제
    public boolean deleteLanguage(int overseaId);
}
