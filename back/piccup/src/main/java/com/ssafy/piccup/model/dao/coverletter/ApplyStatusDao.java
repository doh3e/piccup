package com.ssafy.piccup.model.dao.coverletter;

import java.util.List;

import com.ssafy.piccup.model.dto.coverletter.ApplyStatus;

public interface ApplyStatusDao {
	public List<ApplyStatus> selectAll();
	
	public ApplyStatus selectOne(int stautsId);
	
	public void insertApplyStatus(ApplyStatus applyStatus);
	
	public int deleteApplyStatus(int statusId);
	
	public int updateApplyStatus(ApplyStatus applyStatus);
}
