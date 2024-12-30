package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.ApplyStatus;

public interface ApplyStatusService {
	public List<ApplyStatus> getApplyStatusList();
	
	public ApplyStatus viewApplyStatus(int statusId);
	
	public void addApplyStatus(ApplyStatus applyStatus);
	
	public boolean removeApplyStatus(int statusId);
	
	public boolean modifyApplyStatus(ApplyStatus applyStatus);
}
