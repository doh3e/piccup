package com.ssafy.piccup.model.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class PersonalInfo {
	private int infoId;
    @NotNull(message = "성별은 필수입니다.")

	private int resumeId;
	private String username;
	private LocalDate birthDate;
	private String gender = "미지정";
	private String email;
	private String homePhone;
	private String mobilePhone;
	private String address;
	private String addressDetail;
	private int postalCode;
	private String profileImgPath = "profile_images/default.png";
	private String profileImgName = "default.png";
	private String degree;
	private String hobby;
	private String specialty;

	
	public PersonalInfo() {
	}
	
	// 모든 필드 포함
	public PersonalInfo(int infoId, int resumeId, String username, LocalDate birthDate, String gender, String email,
			String homePhone, String mobilePhone, String address, String addressDetail, int postalCode, String profileImgPath,
			String profileImgName, String degree, String hobby, String specialty) {
		this.infoId = infoId;
		this.resumeId = resumeId;
		this.username = username;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.address = address;
		this.addressDetail = addressDetail;
		this.postalCode = postalCode;
		this.degree = degree;
		this.profileImgPath = profileImgPath;
		this.profileImgName = profileImgName;
		this.hobby = hobby;
		this.specialty = specialty;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}	
	
	public String getProfileImgPath() {
		return profileImgPath;
	}

	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}

	public String getProfileImgName() {
		return profileImgName;
	}

	public void setProfileImgName(String profileImgName) {
		this.profileImgName = profileImgName;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}	
	
}
