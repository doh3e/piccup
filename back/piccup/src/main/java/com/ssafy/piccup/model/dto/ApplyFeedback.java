package com.ssafy.piccup.model.dto;


public class ApplyFeedback {
	private int feedbackId;
	private int applyId;
	private int userId;
	private String feedbackStatus = "미지정";
	private String content;
	
	public ApplyFeedback() {
		super();
	}

	public ApplyFeedback(int applyId, int userId, String feedbackStatus, String content) {
		super();
		this.applyId = applyId;
		this.userId = userId;
		this.feedbackStatus = feedbackStatus;
		this.content = content;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ApplyFeedback [feedbackId=" + feedbackId + ", applyId=" + applyId + ", userId=" + userId
				+ ", feedbackStatus=" + feedbackStatus + ", content=" + content + "]";
	}
	
	
	
	
}
