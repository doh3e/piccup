package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.LanguageDao;
import com.ssafy.piccup.model.dto.resume.Award;
import com.ssafy.piccup.model.dto.resume.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	private final LanguageDao languageDao;
	
	public LanguageServiceImpl(LanguageDao LanguageDao) {
		this.languageDao = LanguageDao;
	}
	
	// 어학 전체 조회
	@Override
	public List<Language> readLanguageList(int resumeId) {
		List<Language> languageList = languageDao.selectAllLanguages(resumeId);
		return languageList.isEmpty() ? new ArrayList<Language>() : languageList;
	}

    // 어학 추가
	@Transactional
	@Override
	public boolean createLanguage(Language language) {
		int result = languageDao.insertLanguage(language);
		return result == 1;
	}

	// 어학 리스트 추가
	@Transactional
	@Override
	public void createLanguageList(List<Language> languages, int resumeId) {
		int result = 0;
		try {
			for (Language language : languages) {
				language.setResumeId(resumeId);
				if (languageDao.insertLanguage(language) == 1) result += 1;
			}
			if (result != languages.size()) {
				throw new RuntimeException("create LanguageList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
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
