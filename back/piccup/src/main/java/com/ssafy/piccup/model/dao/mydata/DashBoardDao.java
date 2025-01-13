package com.ssafy.piccup.model.dao.mydata;

import java.util.List;

import com.ssafy.piccup.model.dto.mydata.DashBoard;
import com.ssafy.piccup.model.dto.mydata.DashBoardNumberData;

public interface DashBoardDao {

	List<DashBoard> selectDashBoardData(int userId);

	DashBoardNumberData selectNumberData(int userId);

}
