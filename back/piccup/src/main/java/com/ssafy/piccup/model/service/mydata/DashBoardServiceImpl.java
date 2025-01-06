package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.mydata.DashBoardDao;
import com.ssafy.piccup.model.dto.mydata.DashBoard;
import com.ssafy.piccup.model.dto.mydata.DashBoardNumberData;

@Service
public class DashBoardServiceImpl implements DashBoardService {
	
	private final DashBoardDao dashBoardDao;
	
	public DashBoardServiceImpl(DashBoardDao dashBoardDao) {
		this.dashBoardDao = dashBoardDao;
	}

	@Override
	public List<DashBoard> getDashBoard(int userId) {
		return dashBoardDao.selectDashBoardData(userId);
	}

	@Override
	public DashBoardNumberData getDashBoardNumberData(int userId) {
		return dashBoardDao.selectNumberData(userId);
	}

}
