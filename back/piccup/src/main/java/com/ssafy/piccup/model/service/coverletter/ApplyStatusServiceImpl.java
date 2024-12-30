package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.coverletter.ApplyStatusDao;
import com.ssafy.piccup.model.dto.coverletter.ApplyStatus;

@Service
public class ApplyStatusServiceImpl implements ApplyStatusService {

	private final ApplyStatusDao applyStatusDao;
	
	public ApplyStatusServiceImpl(ApplyStatusDao applyStatusDao) {
		this.applyStatusDao = applyStatusDao;
	}
	
	@Override
	public List<ApplyStatus> getApplyStatusList() {
		return applyStatusDao.selectAll();
	}

	@Override
	public ApplyStatus viewApplyStatus(int statusId) {
		return applyStatusDao.selectOne(statusId);
	}

	@Override
	public void addApplyStatus(ApplyStatus applyStatus) {
		applyStatusDao.insertApplyStatus(applyStatus);
		
	}

	@Override
	public boolean removeApplyStatus(int statusId) {
		int result = applyStatusDao.deleteApplyStatus(statusId);
		return result == 1;
	}

	@Override
	public boolean modifyApplyStatus(ApplyStatus applyStatus) {
		int result = applyStatusDao.updateApplyStatus(applyStatus);
		return result == 1;
	}

}
