package com.ssafy.piccup.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.ApplyDao;
import com.ssafy.piccup.model.dto.Apply;

@Service
public class ApplyServiceImpl implements ApplyService {
	private final ApplyDao applyDao;
	
	public ApplyServiceImpl(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	@Override
	public List<Apply> getApplyListByUserId(int userId) {
		// TODO Auto-generated method stub
		return applyDao.selectAll(userId);
	}

	@Override
	public Apply viewApply(int applyId) {
		// TODO Auto-generated method stub
		return applyDao.selectOne(applyId);
	}

	@Override
	public void addApply(Apply apply) {
		applyDao.insertApply(apply);
		
	}

	@Override
	public void removeApply(int applyId) {
		applyDao.deleteApply(applyId);
		
	}

	@Override
	public boolean updateApply(Apply apply) {
		int isUpdated = applyDao.updateApply(apply);
		return isUpdated == 1;
	}

	

}
