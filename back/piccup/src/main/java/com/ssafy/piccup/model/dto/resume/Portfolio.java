package com.ssafy.piccup.model.dto.resume;


public class Portfolio {
	private int portId;
	private int resumeId; // 외래키
	private String portUrl;
	
	public Portfolio() {
	}


	public int getPortId() {
		return portId;
	}


	public void setPortId(int portId) {
		this.portId = portId;
	}


	public int getResumeId() {
		return resumeId;
	}


	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}


	public String getPortUrl() {
		return portUrl;
	}


	public void setPortUrl(String portUrl) {
		this.portUrl = portUrl;
	}
	
}
