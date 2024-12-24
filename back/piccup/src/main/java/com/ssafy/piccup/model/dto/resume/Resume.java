package com.ssafy.piccup.model.dto.resume;

import java.security.Timestamp;

public class Resume {
	private int resumeId; // 이력서 고유id
	private int userId; // 유저 고유id (외래키)
	private Timestamp updatedAt; // 수정일자
	
	public Resume() {
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}	
	
}
