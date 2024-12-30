package com.ssafy.piccup.model.dao;

import java.util.List;

import com.ssafy.piccup.model.dto.ApplyFeedback;

public interface ApplyFeedbackDao {
	public List<ApplyFeedback> selectAll();
	
	public ApplyFeedback selectOne(int feedbackId);
	
	public void insertApplyFeedback(ApplyFeedback applyFeedback);
	
	public int deleteApplyFeedback(int feedbackId);
	
	public int updateApplyFeedback(ApplyFeedback applyFeedback);
}
