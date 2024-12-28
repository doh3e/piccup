package com.ssafy.piccup.model.dto.resume;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Skill {
	private int skillId;
	private int resumeId; // 외래키
	@NotBlank(message = "스킬 이름은 필수입니다. (Not Blank)")
	@NotNull(message = "스킬 이름은 필수입니다. (Not Null)")
	private String skillName;
	@NotNull
	@Pattern(regexp = "미지정|초급|중급|고급|전문가", message = "스킬 레벨은 '미지정', '초급', '중급', '고급', '전문가' 중 하나여야 합니다.")
	private String skillLevel = "미지정";
	
	public Skill() {
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
