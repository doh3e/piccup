package com.ssafy.piccup.model.dao.mydata;

import java.util.List;

import com.ssafy.piccup.model.dto.mydata.ApplyCalendarSchedule;
import com.ssafy.piccup.model.dto.mydata.Schedule;


public interface CalendarDao {
	
	// 달력(스케줄) 전체 조회
	public List<Schedule> selectAllUserSchedule(int userId);
	
	// 스케줄 추가
	public void insertSchedule(Schedule schedule);

	// 스케줄 하나만 조회
	public Schedule selectOneScheduleById(int scheduleId);

	// 스케줄 수정하기
	public void updateSchedule(Schedule schedule);

	// 스케줄 삭제하기
	public void deleteSchedule(int scheduleId);
	
	// 지원 스케줄 전체 조회
	public List<ApplyCalendarSchedule> selectAllApplySchedules(int userId);
	
	// 지원 스케줄 상세 조회
	public ApplyCalendarSchedule selectOneApplyScheduleById(int applyId, int userId);

	
}
