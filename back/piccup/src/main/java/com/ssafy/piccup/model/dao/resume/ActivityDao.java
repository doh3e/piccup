package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Activity;

public interface ActivityDao {
	
	// 대내외활동 조회 (resume 기반)
    public List<Activity> selectAllActivity(int resumeId);

    // 대내외활동 추가
    public int insertActivity(Activity activity);
}
