package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDateTime;


public class Resume {
	private int resumeId; // 이력서 고유id
	private int userId; // 유저 고유id (외래키)
	private LocalDateTime updatedAt; // 수정일자
	
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}	
	
}
