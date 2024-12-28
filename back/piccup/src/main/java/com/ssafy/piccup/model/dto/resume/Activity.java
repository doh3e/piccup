package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class Activity {
	private int actId;
	private int resumeId; // 외래키
  @Pattern(regexp = "아르바이트|동아리|자원봉사|교내활동|기타", message = "활동구분은 아르바이트, 동아리, 자원봉사, 교내활동, 기타 중 하나여야 합니다.")
	private String actType = "기타";
	@NotBlank(message = "활동명은 필수입니다. (Not Blank)")
	@NotNull(message = "활동명은 필수입니다. (Not Null")
  private String title;
	@PastOrPresent(message = "활동시작일은 미래일 수 없습니다.")
	private LocalDate startDate;
	@PastOrPresent(message = "활동종료일은 미래일 수 없습니다.")
	private LocalDate endDate;
	private String description;
	
	public Activity() {
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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