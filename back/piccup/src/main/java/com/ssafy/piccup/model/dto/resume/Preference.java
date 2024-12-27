package com.ssafy.piccup.model.dto.resume;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Preference {
	private int preId;
	private int resumeId; // 외래키
	@JsonProperty("isVeteran")
	private boolean isVeteran = false;
	@JsonProperty("isProtected")
	private boolean isProtected = false;
	@JsonProperty("isDisabled")
	private boolean isDisabled = false;
	private String disLevel = "해당없음";
	private String military = "해당없음";
	@JsonProperty("isAgree")
	private boolean isAgree = false;
	
	public Preference() {
	}

	public int getPreId() {
		return preId;
	}

	public void setPreId(int preId) {
		this.preId = preId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public boolean isVeteran() {
		return isVeteran;
	}

	public void setVeteran(boolean isVeteran) {
		this.isVeteran = isVeteran;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getDisLevel() {
		return disLevel;
	}

	public void setDisLevel(String disLevel) {
		this.disLevel = disLevel;
	}

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	public boolean isAgree() {
		return isAgree;
	}

	public void setAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}
	
}