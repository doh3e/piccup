package com.ssafy.piccup.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Apply {
	private int applyId;               // apply_id (Primary Key)
    private int userId;                // user_id (Foreign Key)
    private String companyName;        // company_name
    private String companySize;        // company_size
    private String job;                // job
    private String industry;           // industry
    private LocalDateTime applyStartDate; // apply_start_date
    private LocalDateTime applyEndDate;   // apply_end_date
    private boolean isProgressing;     // is_progressing
    private String currentStatus;      // current_status
    private LocalDateTime updatedAt;   // updated_at
    private String feedback;
    
    private List<CoverLetter> coverLetters = new ArrayList<>();
    
    public Apply() {
	   
    }
    
	public Apply(int userId, String companyName, String companySize, String job, String industry,
			LocalDateTime applyStartDate, LocalDateTime applyEndDate, String feedback) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.companySize = companySize;
		this.job = job;
		this.industry = industry;
		this.applyStartDate = applyStartDate;
		this.applyEndDate = applyEndDate;
		this.feedback = feedback;
	}

	public Apply(String companyName, String companySize, String job, String industry, LocalDateTime applyStartDate,
			LocalDateTime applyEndDate, boolean isProgressing, String currentStatus, LocalDateTime updatedAt,
			String feedback) {
		super();
		this.companyName = companyName;
		this.companySize = companySize;
		this.job = job;
		this.industry = industry;
		this.applyStartDate = applyStartDate;
		this.applyEndDate = applyEndDate;
		this.isProgressing = isProgressing;
		this.currentStatus = currentStatus;
		this.updatedAt = updatedAt;
		this.feedback = feedback;
	}

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public LocalDateTime getApplyStartDate() {
		return applyStartDate;
	}

	public void setApplyStartDate(LocalDateTime applyStartDate) {
		this.applyStartDate = applyStartDate;
	}

	public LocalDateTime getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(LocalDateTime applyEndDate) {
		this.applyEndDate = applyEndDate;
	}

	public boolean isProgressing() {
		return isProgressing;
	}

	public void setProgressing(boolean isProgressing) {
		this.isProgressing = isProgressing;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

	public List<CoverLetter> getCoverLetters() {
		return coverLetters;
	}

	public void setCoverLetters(List<CoverLetter> coverLetters) {
		this.coverLetters = coverLetters;
	}

	@Override
	public String toString() {
		return "Apply [applyId=" + applyId + ", userId=" + userId + ", companyName=" + companyName + ", companySize="
				+ companySize + ", job=" + job + ", industry=" + industry + ", applyStartDate=" + applyStartDate
				+ ", applyEndDate=" + applyEndDate + ", isProgressing=" + isProgressing + ", currentStatus="
				+ currentStatus + ", updatedAt=" + updatedAt + ", feedback=" + feedback + "]";
	}
	
	
    
    
    
	
}
