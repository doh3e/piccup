package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.mydata.Schedule;

@Service
public interface CalendarService {
	
	public List<Schedule> getAllSchedule(int userId);
	public void createSchedule(Schedule schedule);
}
