package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Award {
	private int awardId;
	private int resumeId; // 외래키
	@NotBlank(message = "수상명은 필수입니다. (Not Blank)")
	@NotNull(message = "수상명은 필수입니다. (Not Null)")
	private String awardName;
	@NotBlank(message = "수상기관은 필수입니다. (Not Blank)")
	@NotNull(message = "수상기관은 필수입니다. (Not Null)")
	private String awardOrganization;
	@PastOrPresent(message = "수여일은 미래일 수 없습니다.")
	private LocalDate awardDate;
	private String description;
	
	public Award() {
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardOrganization() {
		return awardOrganization;
	}

	public void setAwardOrganization(String awardOrganization) {
		this.awardOrganization = awardOrganization;
	}

	public LocalDate getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(LocalDate awardDate) {
		this.awardDate = awardDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}