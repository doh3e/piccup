package com.ssafy.piccup.model.service.mydata;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.mydata.DashBoard;
import com.ssafy.piccup.model.dto.mydata.DashBoardNumberData;

@Service
public interface DashBoardService {

	List<DashBoard> getDashBoard(int userId);

	DashBoardNumberData getDashBoardNumberData(int userId);

}
