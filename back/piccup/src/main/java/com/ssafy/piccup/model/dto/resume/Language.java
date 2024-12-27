package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

public class Language {
	private int languageId;
	private int resumeId; // 외래키
	private String languageName;
	private String testName;
	private String score;
	private LocalDate obtainedDate;
	private String certCode;
	
	public Language() {
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public LocalDate getObtainedAt() {
		return obtainedDate;
	}

	public void setObtainedAt(LocalDate obtainedDate) {
		this.obtainedDate = obtainedDate;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}
	
	
}