package com.ssafy.piccup.service.resume;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.resume.ActivityDao;
import com.ssafy.piccup.model.dto.resume.Activity;

@Service
public class ActivityServiceImpl implements ActivityService {

	private final ActivityDao activityDao;
	
	public ActivityServiceImpl(ActivityDao ActivityDao) {
		this.activityDao = ActivityDao;
	}
	
	// 대내외활동 전체 조회
	@Override
	public List<Activity> readActivityList() {
		return activityDao.selectAllActivity();
	}

    // 대내외활동 추가
	@Transactional
	@Override
	public boolean createActivity(Activity activity) {
		int result = activityDao.insertActivity(activity);
		return result == 1;
	}

    // 대내외활동 수정
	@Transactional
	@Override
	public boolean updateActivity(Activity activity) {
		int result = activityDao.updateActivity(activity);
		return result == 1;
	}

    // 대내외활동 삭제
	@Transactional
	@Override
	public boolean deleteActivity(int actId) {
		int result = activityDao.deleteActivity(actId);
		return result == 1;
	}

}
