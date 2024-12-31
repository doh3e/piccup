package com.ssafy.piccup.model.dao.coverletter;

import java.util.List;

import com.ssafy.piccup.model.dto.coverletter.ApplySchedule;

public interface ApplyScheduleDao {
	public List<ApplySchedule> selectAll();
	
	public ApplySchedule selectOne(int scheduleId);
	
	public void insertApplySchedule(ApplySchedule applySchedule);
	
	public void deleteApplySchedule(int scheduleId);
	
	public int updateApplySchedule(ApplySchedule applySchedule);
}
