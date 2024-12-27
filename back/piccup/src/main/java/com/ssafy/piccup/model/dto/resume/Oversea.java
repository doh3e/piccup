package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

public class Oversea {
	private int overseaId;
	private int resumeId; // 외래키
	private String country;
	private LocalDate startDate;
	private LocalDate endDate;
	private String description;
	
	public Oversea() {
	}

	public int getOverseaId() {
		return overseaId;
	}

	public void setOverseaId(int overseaId) {
		this.overseaId = overseaId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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