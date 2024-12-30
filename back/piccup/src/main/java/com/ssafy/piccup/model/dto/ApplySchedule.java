package com.ssafy.piccup.model.dto;

import java.time.LocalDateTime;

public class ApplySchedule {
	private int scheduleId;
	private int applyId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	
	
	public ApplySchedule() {
		
	}
	
	
	public ApplySchedule(int scheduleId, int applyId, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.scheduleId = scheduleId;
		this.applyId = applyId;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "ApplySchedule [scheduleId=" + scheduleId + ", applyId=" + applyId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
