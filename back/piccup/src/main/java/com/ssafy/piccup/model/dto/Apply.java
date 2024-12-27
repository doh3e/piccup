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
    private LocalDateTime updatedAt;   // updated_at
    private LocalDateTime createdAt;   // created_at
    
    private List<CoverLetter> coverLetters = new ArrayList<>();
    
    public Apply() {
	   
    }
    public Apply(int userId, String companyName, String companySize, String job, String industry) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.companySize = companySize;
		this.job = job;
		this.industry = industry;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
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
				+ companySize + ", job=" + job + ", industry=" + industry + ", updatedAt=" + updatedAt + ", createdAt="
				+ createdAt + ", coverLetters=" + coverLetters + "]";
	}
    
    

	
	
    
    
    
	
}
