package com.ssafy.piccup.model.service.mydata;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.mydata.DashBoardDao;

@Service
public class DashBoardServiceImpl implements DashBoardService {
	
	private final DashBoardDao dashBoardDao;
	
	public DashBoardServiceImpl(DashBoardDao dashBoardDao) {
		this.dashBoardDao = dashBoardDao;
	}

}
