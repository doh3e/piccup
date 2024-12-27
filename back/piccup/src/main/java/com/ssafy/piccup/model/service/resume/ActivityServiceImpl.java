package com.ssafy.piccup.model.service.resume;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

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
	
	// 대내외활동 전체 조회 (resume 기반)
	@Override
	public List<Activity> readActivityList(int resumeId) {
		List<Activity> activityList = activityDao.selectAllActivity(resumeId);
		return activityList.isEmpty() ? new ArrayList<Activity>() : activityList;
	}

    // 대내외활동 추가
	@Transactional
	@Override
	public boolean createActivity(Activity activity) {
		int result = activityDao.insertActivity(activity);
		return result == 1;
	}
	
	// 대내외활동 리스트 추가
	@Transactional
	@Override
	public void createActivityList(List<Activity> activities, int resumeId) {
		int result = 0;
		try {
			for (Activity activity : activities) {
				activity.setResumeId(resumeId);
				if (activityDao.insertActivity(activity) == 1) result += 1;
			}
			if (result != activities.size()) {
				throw new RuntimeException("create ActivityList 불가");
			}
        } catch (Exception e) {
        	throw e;
        }
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
