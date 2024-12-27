package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Preference;

public interface PreferenceDao {
	
	// 취업우대 전체 조회
    public List<Preference> selectAllPreferences();

    // 취업우대 추가
    public int insertPreference(Preference preference);

    // 취업우대 수정
    public int updatePreference(Preference preference);

    // 취업우대 삭제
    public int deletePreference(int preferenceId);
}
