package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;


public class Resume {
	private int resumeId; // 이력서 고유id
	@NotNull
	private int userId; // 유저 고유id (외래키)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedAt; // 수정일자
	
	// data - 직렬화에서 제외
	private transient PersonalInfo personalInfo;
    private transient List<Project> projects;
    private transient List<Language> languages;
    private transient Preference preference;
    private transient List<Portfolio> portfolios;
    private transient List<Training> trainings;
    private transient List<WorkExp> workExp;
    private transient List<Education> educations;
    private transient List<Certification> certifications;
    private transient List<Paper> papers;
    private transient List<Oversea> overseas;
    private transient List<Skill> skills;
    private transient List<Activity> activities;
    private transient List<Award> awards;
    private transient List<Patent> patents;
	
	public Resume() {
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public List<WorkExp> getWorkExp() {
		return workExp;
	}

	public void setWorkExp(List<WorkExp> workExp) {
		this.workExp = workExp;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	public List<Oversea> getOverseas() {
		return overseas;
	}

	public void setOverseas(List<Oversea> overseas) {
		this.overseas = overseas;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}

	public List<Patent> getPatents() {
		return patents;
	}

	public void setPatents(List<Patent> patents) {
		this.patents = patents;
	}	
	
}