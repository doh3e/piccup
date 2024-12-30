package com.ssafy.piccup.model.dto;

public class ApplyStatus {
	private int statusId;
	private int applyId;
	private boolean isProgressing;
	private String currentStatus = "미지정";
	
	public ApplyStatus() {
		
	}
	

	public ApplyStatus(int applyId) {
		super();
		this.applyId = applyId;
	}


	public ApplyStatus(int applyId, boolean isProgressing, String currentStatus) {
		super();
		this.applyId = applyId;
		this.isProgressing = isProgressing;
		this.currentStatus = currentStatus;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
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
	
	
}
