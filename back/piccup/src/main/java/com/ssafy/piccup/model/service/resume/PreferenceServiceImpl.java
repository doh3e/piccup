package com.ssafy.piccup.model.service.resume;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.PreferenceDao;
import com.ssafy.piccup.model.dto.resume.Preference;

@Service
public class PreferenceServiceImpl implements PreferenceService {

	private final PreferenceDao preferenceDao;
	
	public PreferenceServiceImpl(PreferenceDao PreferenceDao) {
		this.preferenceDao = PreferenceDao;
	}
	
	// 취업우대 조회 (resume기반)
	@Override
	public Preference readPreferenceByResume(int resumeId) {
		return preferenceDao.selectPreferenceByResume(resumeId);
	}

    // 취업우대 추가
	@Transactional
	@Override
	public void createPreference(Preference preference) {
		try {
			if (preferenceDao.insertPreference(preference) != 1) {
				throw new RuntimeException("create Preference 불가");
			}
		} catch (Exception e) {
		    throw e;
		}
	}

    // 취업우대 수정
	@Transactional
	@Override
	public boolean updatePreference(Preference preference) {
		int result = preferenceDao.updatePreference(preference);
		return result == 1;
	}

    // 취업우대 삭제
	@Transactional
	@Override
	public boolean deletePreference(int preferenceId) {
		int result = preferenceDao.deletePreference(preferenceId);
		return result == 1;
	}

}
