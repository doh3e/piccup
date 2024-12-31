package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.coverletter.ApplySchedule;

@Service
public interface ApplyScheduleService {
	public List<ApplySchedule> getApplySchduleList();
	
	public ApplySchedule viewApplySchedule(int scheduleId);
	
	public void addApplySchedule(ApplySchedule applySchedule);
	
	public void removeApplySchedule(int scheduled);
	
	public boolean modifyApplySchedule(ApplySchedule applySchedule);
}
