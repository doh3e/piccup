package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dto.coverletter.ApplyFeedback;

@Service
public interface ApplyFeedbackService {
	public List<ApplyFeedback> getApplyFeedbackList();
	
	public ApplyFeedback viewApplyFeedback(int feedbackId);
	
	public void addApplyFeedback(ApplyFeedback applyFeedback);
	
	public boolean removeApplyFeedback(int feedbackId);
	
	public boolean modifyApplyFeedback(ApplyFeedback applyFeedback);
}
