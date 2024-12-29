package com.ssafy.piccup.model.service.resume;

import com.ssafy.piccup.model.dto.resume.Preference;


public interface PreferenceService {
	
	// 취업우대 조회 (resume기반)
    public Preference readPreferenceByResume(int resumeId);

    // 취업우대 추가
    public void createPreference(Preference preference);
}
