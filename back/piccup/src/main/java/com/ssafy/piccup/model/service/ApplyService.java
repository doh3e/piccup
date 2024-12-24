package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.Apply;

public interface ApplyService {
	public List<Apply> getApplyList();
	
	public Apply viewApply(int id);
	
	public void addApply(Apply apply);
	
	public void removeApply(int applyId);
	
	public boolean updateApply(Apply apply);
}
