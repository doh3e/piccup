package com.ssafy.piccup.model.dto.resume;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class Education {
	private int eduId;
	private int resumeId; // 외래키
	@NotNull
    @Pattern(regexp = "선택안함|고등학교|대학\\(2,3년\\)|대학교\\(4년\\)|대학원", message = "학교 유형은 지정된 값 중 하나여야 합니다.")
	private String schoolType = "선택안함";
    @NotNull(message = "학교 이름은 필수입니다.")
	private String schoolName;
	private String major;
    @Past(message = "입학 날짜는 과거여야 합니다.")
	private LocalDate startDate;
    @PastOrPresent(message = "졸업 날짜는 현재 또는 미래여야 합니다.")
	private LocalDate endDate;
    @Pattern(regexp = "선택안함|졸업|졸업예정|재학 중|중퇴|수료|휴학", message = "학업 상태는 지정된 값 중 하나여야 합니다.")
	private String status = "선택안함";
	@JsonProperty("isTransfer")
	private boolean isTransfer = false;
	@Min(value = 0, message = "GPA는 0 이상이어야 합니다.")
    @Max(value = 5, message = "GPA는 5 이하여야 합니다.")
	private BigDecimal gpa;
	private BigDecimal majorGpa;
	private BigDecimal gpaScale;
	@JsonProperty("isQe")
	private boolean isQe;
	private Year qeYear;
	private String transcriptFileName;
	private String transcriptFilePath;
	
	public Education() {
	}

	public int getEduId() {
		return eduId;
	}

	public void setEduId(int eduId) {
		this.eduId = eduId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isTransfer() {
		return isTransfer;
	}

	public void setTransfer(boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	public BigDecimal getGpa() {
		return gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa;
	}

	public BigDecimal getMajorGpa() {
		return majorGpa;
	}

	public void setMajorGpa(BigDecimal majorGpa) {
		this.majorGpa = majorGpa;
	}

	public BigDecimal getGpaScale() {
		return gpaScale;
	}

	public void setGpaScale(BigDecimal gpaScale) {
		this.gpaScale = gpaScale;
	}

	public boolean isQe() {
		return isQe;
	}

	public void setQe(boolean isQe) {
		this.isQe = isQe;
	}

	public Year getQeYear() {
		return qeYear;
	}

	public void setQeYear(Year qeYear) {
		this.qeYear = qeYear;
	}

	public String getTranscriptFileName() {
		return transcriptFileName;
	}

	public void setTranscriptFileName(String transcriptFileName) {
		this.transcriptFileName = transcriptFileName;
	}

	public String getTranscriptFilePath() {
		return transcriptFilePath;
	}

	public void setTranscriptFilePath(String transcriptFilePath) {
		this.transcriptFilePath = transcriptFilePath;
	}
	
}