package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.coverletter.ApplyStatus;

@Service
public interface ApplyStatusService {
	public List<ApplyStatus> getApplyStatusList();
	
	public ApplyStatus viewApplyStatus(int statusId);
	
	public void addApplyStatus(ApplyStatus applyStatus);
	
	public boolean removeApplyStatus(int statusId);
	
	public boolean modifyApplyStatus(ApplyStatus applyStatus);
}
