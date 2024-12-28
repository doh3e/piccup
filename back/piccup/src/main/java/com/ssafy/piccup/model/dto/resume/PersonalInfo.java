package com.ssafy.piccup.model.dto.resume;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PersonalInfo {
	private int infoId;
	private int resumeId;
	private String username;
	private LocalDate birthDate;
    @Pattern(regexp = "남|여|미지정", message = "성별은 '남', '여', '미지정' 중 하나여야 합니다.")
	private String gender = "미지정";
    @Email(message = "이메일 형식이 올바르지 않습니다.")
	private String email;
    @Pattern(regexp = "^(\\d{2,4})-(\\d{3,4})-(\\d{4})$", message = "homePhone 형식이 올바르지 않습니다.")
	private String homePhone;
    @Pattern(regexp = "^(\\d{2,4})-(\\d{3,4})-(\\d{4})$", message = "mobilePhone 형식이 올바르지 않습니다.")
	private String mobilePhone;
	private String address;
	private String addressDetail;
	private int postalCode;
	private String profileImgPath = "profile_images/default.png";
	private String profileImgName = "default.png";
    @NotNull(message = "학위는 필수입니다.")
    @Pattern(regexp = "미지정|중등교육이수|학사|석사|박사", message = "학위는 '미지정', '중등교육이수', '학사', '석사', '박사' 중 하나여야 합니다.")
	private String degree = "미지정";
	private String hobby;
	private String specialty;

	 // 파일 필드 추가 - 이력서 생성용
    private transient MultipartFile file;
    
	public PersonalInfo() {
	}
	

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

	@Override
	public String toString() {
		return "PersonalInfo [infoId=" + infoId + ", resumeId=" + resumeId + ", username=" + username + ", birthDate="
				+ birthDate + ", gender=" + gender + ", email=" + email + ", homePhone=" + homePhone + ", mobilePhone="
				+ mobilePhone + ", address=" + address + ", addressDetail=" + addressDetail + ", postalCode="
				+ postalCode + ", profileImgPath=" + profileImgPath + ", profileImgName=" + profileImgName + ", degree="
				+ degree + ", hobby=" + hobby + ", specialty=" + specialty + "]";
	}

}
