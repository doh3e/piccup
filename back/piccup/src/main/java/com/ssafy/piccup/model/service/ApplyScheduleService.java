package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.ApplySchedule;

public interface ApplyScheduleService {
	public List<ApplySchedule> getApplySchduleList();
	
	public ApplySchedule viewApplySchedule(int scheduleId);
	
	public void addApplySchedule(ApplySchedule applySchedule);
	
	public void removeApplySchedule(int scheduled);
	
	public boolean modifyApplySchedule(ApplySchedule applySchedule);
}
