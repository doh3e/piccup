package com.ssafy.piccup.model.dto;

public class Resume {
	private int resumeId;
	private String updatedAt;
	
	public Resume() {
	}
	
	// 모든 필드 포함
	public Resume(int resumeId, String updatedAt) {
		this.resumeId = resumeId;
		this.updatedAt = updatedAt;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
}
