package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

public class Patent {
	private int patentId;
	private int resumeId; // 외래키
	private String patentTitle;
	private String inventor;
	private String patentCode;
	private String description;
	
	public Patent() {
	}

	public int getPatentId() {
		return patentId;
	}

	public void setPatentId(int patentId) {
		this.patentId = patentId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getPatentTitle() {
		return patentTitle;
	}

	public void setPatentTitle(String patentTitle) {
		this.patentTitle = patentTitle;
	}

	public String getInventor() {
		return inventor;
	}

	public void setInventor(String inventor) {
		this.inventor = inventor;
	}

	public String getPatentCode() {
		return patentCode;
	}

	public void setPatentCode(String patentCode) {
		this.patentCode = patentCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}