package com.ssafy.piccup.model.service.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Activity;


public interface ActivityService {
	
	// 대내외활동 전체 조회  (resume 기반)
    public List<Activity> readActivityList(int resumeId);
    
    // 대내외활동 리스트 추가
    public void createActivityList(List<Activity> activities, int resumeId);
    
    // ---

    // 대내외활동 추가
    public boolean createActivity(Activity activity);
    
    // 대내외활동 수정
    public boolean updateActivity(Activity activity);

    // 대내외활동 삭제
    public boolean deleteActivity(int actId);
}
