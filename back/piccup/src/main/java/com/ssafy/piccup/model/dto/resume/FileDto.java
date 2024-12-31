package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDateTime;

public class FileDto {
	private int fileId;
	private int resumeId; // 외래키
	private LocalDateTime updatedAt;
	// 성적증명서
	private String eduFileName;
	private String eduFilePath;
	// 포트폴리오
	private String portFileName;
	private String portFilePath;
	// 경력증명서
	private String workFileName;
	private String workFilePath;
	
	public FileDto() {
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getEduFileName() {
		return eduFileName;
	}

	public void setEduFileName(String eduFileName) {
		this.eduFileName = eduFileName;
	}

	public String getEduFilePath() {
		return eduFilePath;
	}

	public void setEduFilePath(String eduFilePath) {
		this.eduFilePath = eduFilePath;
	}

	public String getPortFileName() {
		return portFileName;
	}

	public void setPortFileName(String portFileName) {
		this.portFileName = portFileName;
	}

	public String getPortFilePath() {
		return portFilePath;
	}

	public void setPortFilePath(String portFilePath) {
		this.portFilePath = portFilePath;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getWorkFileName() {
		return workFileName;
	}

	public void setWorkFileName(String workFileName) {
		this.workFileName = workFileName;
	}

	public String getWorkFilePath() {
		return workFilePath;
	}

	public void setWorkFilePath(String workFilePath) {
		this.workFilePath = workFilePath;
	}
}