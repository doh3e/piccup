package com.ssafy.piccup.model.service.coverletter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.piccup.model.dao.coverletter.ApplyFeedbackDao;
import com.ssafy.piccup.model.dto.coverletter.ApplyFeedback;

@Service
public class ApplyFeedbackServiceImpl implements ApplyFeedbackService {
	private final ApplyFeedbackDao applyFeedbackDao;

	public ApplyFeedbackServiceImpl(ApplyFeedbackDao applyFeedbackDao) {
		this.applyFeedbackDao = applyFeedbackDao;
	}

	@Override
	public List<ApplyFeedback> getApplyFeedbackList() {
		return applyFeedbackDao.selectAll();
	}

	@Override
	public ApplyFeedback viewApplyFeedback(int feedbackId) {
		return applyFeedbackDao.selectOne(feedbackId);
	}

	@Override
	public void addApplyFeedback(ApplyFeedback applyFeedback) {
		applyFeedbackDao.insertApplyFeedback(applyFeedback);
	}

	@Override
	public boolean removeApplyFeedback(int feedbackId) {
		int result = applyFeedbackDao.deleteApplyFeedback(feedbackId);
		return result == 1;
	}

	@Override
	public boolean modifyApplyFeedback(ApplyFeedback applyFeedback) {
		int result = applyFeedbackDao.updateApplyFeedback(applyFeedback);
		return result == 1;
	}
	
	
	
}
