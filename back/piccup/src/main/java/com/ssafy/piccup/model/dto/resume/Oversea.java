package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Oversea {
	private int overseaId;
	private int resumeId; // 외래키
	@NotBlank(message = "국가명은 필수입니다. (Not Blank)")
    @NotNull(message = "국가명은 필수입니다. (Not Null)")
	private String country;
    @PastOrPresent(message = "시작 날짜는 미래일 수 없습니다.")
	private LocalDate startDate;
    @PastOrPresent(message = "종료 날짜는 미래일 수 없습니다.")
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