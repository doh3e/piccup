package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.mydata.CalendarDao;
import com.ssafy.piccup.model.dto.mydata.ApplyCalendarSchedule;
import com.ssafy.piccup.model.dto.mydata.Schedule;

@Service
public class CalendarServiceImpl implements CalendarService {

	private final CalendarDao calendarDao;

	public CalendarServiceImpl(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}

	// 스케줄 조회
	@Override
	public List<Schedule> getAllSchedule(int userId) {
		return calendarDao.selectAllUserSchedule(userId);
	}

	// 스케줄 생성
	@Transactional
	@Override
	public void createSchedule(Schedule schedule) {
		calendarDao.insertSchedule(schedule);
	}

	// 스케줄 단일 조회
	@Override
	public Schedule getScheduleById(int scheduleId) {
		return calendarDao.selectOneScheduleById(scheduleId);
	}

	// 스케줄 수정
	@Override
	public void updateSchedule(Schedule schedule) {
		calendarDao.updateSchedule(schedule);
	}
	
	// 스케줄 삭제
	@Override
	public void deleteScheduleById(int scheduleId) {
		calendarDao.deleteSchedule(scheduleId);
	}

	// 지원 스케줄 조회
	@Override
	public List<ApplyCalendarSchedule> getAllApplySchedules(int userId) {
		return calendarDao.selectAllApplySchedules(userId);
	}
	
	// 지원 스케줄 상세 조회
	@Override
	public ApplyCalendarSchedule getApplyScheduleById(int applyId, int userId) {
		return calendarDao.selectOneApplyScheduleById(applyId, userId);
	}


}
