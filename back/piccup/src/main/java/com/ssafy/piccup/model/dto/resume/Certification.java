package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Certification {
	private int certId;
	private int resumeId; // 외래키
    @NotNull(message = "자격증 이름은 필수입니다.")
	private String certName;
	private String publisher;
    @PastOrPresent(message = "취득 날짜는 미래일 수 없습니다.")
	private LocalDate obtainedDate;
	private String certCode;
	
	public Certification() {
	}

	public int getCertId() {
		return certId;
	}

	public void setCertId(int certId) {
		this.certId = certId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getObtainedDate() {
		return obtainedDate;
	}

	public void setObtainedDate(LocalDate obtainedDate) {
		this.obtainedDate = obtainedDate;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}	
	
}
