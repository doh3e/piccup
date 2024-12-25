package com.ssafy.piccup.model.dto.resume;


public class Portfolio {
	private int portId;
	private int resumeId; // 외래키
	private String portUrl;
	private String portFileName;
	private String portFilePath;
	
	
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


	public String getPortFileName() {
		return portFileName;
	}


	public void setPortFileName(String portFileName) {
		this.portFileName = portFileName;
	}


	public String getPortFilePath() {
		return portFilePath;
	}


	public void setPortFilePath(String portFilePath) {
		this.portFilePath = portFilePath;
	}
	
}
