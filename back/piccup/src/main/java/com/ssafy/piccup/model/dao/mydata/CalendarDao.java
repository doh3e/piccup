package com.ssafy.piccup.model.dao.mydata;

import java.util.List;

import com.ssafy.piccup.model.dto.mydata.Schedule;


public interface CalendarDao {
	
	// 달력(스케줄) 전체 조회
	public List<Schedule> selectAllUserSchedule(int userId);
	
	// 스케줄 추가
	public void insertSchedule(Schedule schedule);
	

}
