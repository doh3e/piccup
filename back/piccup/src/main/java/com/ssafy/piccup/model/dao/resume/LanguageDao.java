package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Language;

public interface LanguageDao {
	
	// 어학 전체 조회
    public List<Language> selectAllLanguages(int resumeId);

    // 어학 추가
    public int insertLanguage(Language language);

    // 어학 수정
    public int updateLanguage(Language language);

    // 어학 삭제
    public int deleteLanguage(int languageId);
}
