package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;


public class ResumeSimple {
	private int resumeId; // 이력서 고유id
	@NotNull(message = "유저 ID는 필수입니다.")
	private int userId; // 유저 고유id (외래키)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt; // 수정일자
	
	public ResumeSimple() {
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

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}	
	
}