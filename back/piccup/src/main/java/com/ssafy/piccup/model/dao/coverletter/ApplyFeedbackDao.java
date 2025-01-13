package com.ssafy.piccup.model.dao.coverletter;

import java.util.List;

import com.ssafy.piccup.model.dto.coverletter.ApplyFeedback;

public interface ApplyFeedbackDao {
	public List<ApplyFeedback> selectAll(int userId);
	
	public ApplyFeedback selectOne(int feedbackId);
	
	public void insertApplyFeedback(ApplyFeedback applyFeedback);
	
	public int deleteApplyFeedback(int feedbackId);
	
	public int updateApplyFeedback(ApplyFeedback applyFeedback);
}
