package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

public class Award {
	private int awardId;
	private int resumeId; // 외래키
	private String awardName;
	private String awardOrganization;
	private LocalDate awardDate;
	private String description;
	
	public Award() {
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardOrganization() {
		return awardOrganization;
	}

	public void setAwardOrganization(String awardOrganization) {
		this.awardOrganization = awardOrganization;
	}

	public LocalDate getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(LocalDate awardDate) {
		this.awardDate = awardDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}