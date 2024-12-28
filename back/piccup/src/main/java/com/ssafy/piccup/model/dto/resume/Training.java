package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class Training {
	private int trainingId;
	private int resumeId; // 외래키
	@NotBlank(message = "교육 이름은 필수입니다. (Not Blank)")
    @NotNull(message = "교육 이름은 필수입니다. (Not Null)")
	private String trainingName;
	@NotBlank(message = "교육 기관은 필수입니다. (Not Blank)")
    @NotNull(message = "교육 기관은 필수입니다. (Not Null")
	private String institution;
    @PastOrPresent(message = "교육 시작 날짜는 미래날짜일 수 없습니다.")
	private LocalDate startDate;
    @PastOrPresent(message = "교육 종료 날짜는 미래날짜일 수 없습니다.")
	private LocalDate endDate;
	private String description;
	
	public Training() {
	}
	
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
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
