package com.ssafy.piccup.model.dao.resume;


import com.ssafy.piccup.model.dto.resume.Preference;

public interface PreferenceDao {
	
	// 취업우대 조회 (resume 기반)
    public Preference selectPreferenceByResume(int resumeId);

    // 취업우대 추가
    public int insertPreference(Preference preference);
}
