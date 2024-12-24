package com.ssafy.piccup.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.LanguageDao;
import com.ssafy.piccup.model.dto.resume.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	private final LanguageDao languageDao;
	
	public LanguageServiceImpl(LanguageDao LanguageDao) {
		this.languageDao = LanguageDao;
	}
	
	// 어학 전체 조회
	@Override
	public List<Language> readLanguageList() {
		return languageDao.selectAllLanguages();
	}

    // 어학 추가
	@Transactional
	@Override
	public boolean createLanguage(Language language) {
		int result = languageDao.insertLanguage(language);
		return result == 1;
	}

    // 어학 수정
	@Transactional
	@Override
	public boolean updateLanguage(Language language) {
		int result = languageDao.updateLanguage(language);
		return result == 1;
	}

    // 어학 삭제
	@Transactional
	@Override
	public boolean deleteLanguage(int languageId) {
		int result = languageDao.deleteLanguage(languageId);
		return result == 1;
	}

}
