package com.ssafy.piccup.model.service;

import com.ssafy.piccup.model.dao.CalendarDao;

public class CalendarServiceImpl implements CalendarService {
	
	private final CalendarDao calendarDao;
	
	public CalendarServiceImpl(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}

}
