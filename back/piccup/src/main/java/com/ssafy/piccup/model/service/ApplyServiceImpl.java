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
	public List<Apply> getApplyList() {
		// TODO Auto-generated method stub
		return applyDao.selectAll();
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
	public void removeApply(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateApply(Apply apply) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
