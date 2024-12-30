package com.ssafy.piccup.model.service;

import java.util.List;

import com.ssafy.piccup.model.dto.ApplyFeedback;

public interface ApplyFeedbackService {
	public List<ApplyFeedback> getApplyFeedbackList();
	
	public ApplyFeedback viewApplyFeedback(int feedbackId);
	
	public void addApplyFeedback(ApplyFeedback applyFeedback);
	
	public boolean removeApplyFeedback(int feedbackId);
	
	public boolean modifyApplyFeedback(ApplyFeedback applyFeedback);
}
