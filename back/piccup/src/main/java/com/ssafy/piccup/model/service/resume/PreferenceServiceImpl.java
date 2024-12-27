package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public boolean createPreference(Preference preference) {
		int result = preferenceDao.insertPreference(preference);
		return result == 1;
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
