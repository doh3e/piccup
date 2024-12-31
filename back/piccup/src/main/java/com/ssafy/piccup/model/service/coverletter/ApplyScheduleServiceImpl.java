package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.coverletter.ApplyScheduleDao;
import com.ssafy.piccup.model.dto.coverletter.ApplySchedule;

@Service
public class ApplyScheduleServiceImpl implements ApplyScheduleService{
	private final ApplyScheduleDao applyScheduleDao;
	public ApplyScheduleServiceImpl(ApplyScheduleDao applyScheduleDao) {
		this.applyScheduleDao = applyScheduleDao;
	}
	
	@Override
	public List<ApplySchedule> getApplySchduleList() {
		// TODO Auto-generated method stub
		return applyScheduleDao.selectAll();
	}

	@Override
	public ApplySchedule viewApplySchedule(int scheduleId) {
		// TODO Auto-generated method stub
		return applyScheduleDao.selectOne(scheduleId);
	}

	@Override
	public void addApplySchedule(ApplySchedule applySchedule) {
		// TODO Auto-generated method stub
		applyScheduleDao.insertApplySchedule(applySchedule);
		
	}

	@Override
	public void removeApplySchedule(int scheduled) {
		// TODO Auto-generated method stub
		applyScheduleDao.deleteApplySchedule(scheduled);
		
	}

	@Override
	public boolean modifyApplySchedule(ApplySchedule applySchedule) {
		// TODO Auto-generated method stub
		int result = applyScheduleDao.updateApplySchedule(applySchedule);
		return result == 1;
		
	}
	

}
