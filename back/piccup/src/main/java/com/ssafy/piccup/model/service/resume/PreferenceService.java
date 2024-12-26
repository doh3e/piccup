package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Preference;


public interface PreferenceService {
	
	// 취업우대 전체 조회
    public List<Preference> readPreferenceList();

    // 취업우대 추가
    public boolean createPreference(Preference preference);

    // 취업우대 수정
    public boolean updatePreference(Preference preference);

    // 취업우대 삭제
    public boolean deletePreference(int preferenceId);
}
