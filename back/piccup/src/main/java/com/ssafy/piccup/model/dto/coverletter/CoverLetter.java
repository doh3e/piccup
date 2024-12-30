package com.ssafy.piccup.model.dto.coverletter;

public class CoverLetter {
	private int coverId;
	private int applyId;
	private int userId;
	private String category;
	private String coverTitle;
	private String coverContent;
	
	
	public CoverLetter() {
		
	}
	
	
	public CoverLetter(int applyId, int userId, String category, String coverTitle, String coverContent) {
		super();
		this.applyId = applyId;
		this.userId = userId;
		this.category = category;
		this.coverTitle = coverTitle;
		this.coverContent = coverContent;
	}


	public int getCoverId() {
		return coverId;
	}
	public void setCoverId(int coverId) {
		this.coverId = coverId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCoverTitle() {
		return coverTitle;
	}
	public void setCoverTitle(String coverTitle) {
		this.coverTitle = coverTitle;
	}
	public String getCoverContent() {
		return coverContent;
	}
	public void setCoverContent(String coverContent) {
		this.coverContent = coverContent;
	}


	@Override
	public String toString() {
		return "CoverLetter [coverId=" + coverId + ", applyId=" + applyId + ", userId=" + userId + ", category="
				+ category + ", coverTitle=" + coverTitle + ", coverContent=" + coverContent + "]";
	}
	

}
