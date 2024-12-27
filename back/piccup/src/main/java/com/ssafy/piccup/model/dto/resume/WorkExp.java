package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkExp {
	private int expId;
	private int resumeId; // 외래키
	private String company;
	private String department;
	private LocalDate startDate;
	private LocalDate endDate;
	@JsonProperty("isCurrent")
	private boolean isCurrent;
	private String position;
	private int salary;
	private String description;
	private String expFileName;
	private String expFilePath;
	
	public WorkExp() {
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpFileName() {
		return expFileName;
	}

	public void setExpFileName(String expFileName) {
		this.expFileName = expFileName;
	}

	public String getExpFilePath() {
		return expFilePath;
	}

	public void setExpFilePath(String expFilePath) {
		this.expFilePath = expFilePath;
	}
	
}