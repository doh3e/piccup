package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Language {
	private int languageId;
	private int resumeId; // 외래키
    @NotNull(message = "언어명은 필수입니다.")
	private String languageName;
    @NotNull(message = "시험명은 필수입니다.")
	private String testName;
	private String score;
    @PastOrPresent(message = "취득 날짜는 미래일 수 없습니다.")
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