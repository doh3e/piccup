package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.piccup.model.dao.mydata.CalendarDao;
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

}
