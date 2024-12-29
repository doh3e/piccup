package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Activity;


public interface ActivityService {
	
	// 대내외활동 조회 (resume 기반)
    public List<Activity> readActivityList(int resumeId);
    
    // 대내외활동 리스트 추가
    public void createActivityList(List<Activity> activities, int resumeId);
}
