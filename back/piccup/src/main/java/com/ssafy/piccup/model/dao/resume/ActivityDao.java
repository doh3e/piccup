package com.ssafy.piccup.model.dao.resume;

import java.util.List;

import com.ssafy.piccup.model.dto.resume.Activity;

public interface ActivityDao {
	
	// 대내외활동 전체 조회
    public List<Activity> selectAllActivity();

    // 대내외활동 추가
    public int insertActivity(Activity activity);

    // 대내외활동 수정
    public int updateActivity(Activity activity);

    // 대내외활동 삭제
    public int deleteActivity(int actId);
}
