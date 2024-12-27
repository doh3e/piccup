package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Project {
	private int projectId;
	private int resumeId; // 외래키
    @NotNull(message = "프로젝트 이름은 필수입니다.")
	private String projectName;
	private String role;
    @PastOrPresent(message = "시작 날짜는 미래일 수 없습니다.")
	private LocalDate startDate;
    @PastOrPresent(message = "종료 날짜는 미래일 수 없습니다.")
	private LocalDate endDate;
	private String description;
	
	public Project() {
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}