package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.mydata.ApplyCalendarSchedule;
import com.ssafy.piccup.model.dto.mydata.Schedule;

@Service
public interface CalendarService {
	
	public List<Schedule> getAllSchedule(int userId);
	
	public void createSchedule(Schedule schedule);
	
	public Schedule getScheduleById(int scheduleId);
	
	public void updateSchedule(Schedule schedule);

	public List<ApplyCalendarSchedule> getAllApplySchedules(int userId);

	public ApplyCalendarSchedule getApplyScheduleById(int applyId, int userId);
}
