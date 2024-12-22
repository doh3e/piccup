package com.ssafy.piccup.model.dto;

public class Skill {
	private int skillId;
	private int resumeId; // 외래키
	private String skillName;
	private String skillLevel = "미지정";
	
	public Skill() {
	}
	
	public Skill(int skillId, int resumeId, String skillName, String skillLevel) {
		super();
		this.skillId = skillId;
		this.resumeId = resumeId;
		this.skillName = skillName;
		this.skillLevel = skillLevel;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
}
