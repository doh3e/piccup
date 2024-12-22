package com.ssafy.piccup.model.dto;

public class Resume {
	private int resumeId; // 이력서 고유id
	private String updatedAt; // 수정일자
	
	public Resume() {
	}
	
	public Resume(int resumeId) {
		this.resumeId = resumeId;
//		this.updatedAt = updatedAt;
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
//
//	public void setUpdatedAt(String updatedAt) {
//		this.updatedAt = updatedAt;
//	}
}
