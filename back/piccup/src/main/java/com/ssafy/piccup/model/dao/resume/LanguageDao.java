package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Language;

public interface LanguageDao {
	
	// 어학 조회 (resume 기반)
    public List<Language> selectAllLanguages(int resumeId);

    // 어학 추가
    public int insertLanguage(Language language);
}
