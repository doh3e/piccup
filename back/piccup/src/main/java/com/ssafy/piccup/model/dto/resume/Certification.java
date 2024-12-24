package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

public class Certification {
	private int certId;
	private int resumeId; // 외래키
	private String certName;
	private String publisher;
	private LocalDate obtainedAt;
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

	public LocalDate getObtainedAt() {
		return obtainedAt;
	}

	public void setObtainedAt(LocalDate obtainedAt) {
		this.obtainedAt = obtainedAt;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}	
	
}
