package com.ssafy.piccup.model.dto;

public class User {
	private int userId;
	private String email;
	private String nickname;
	private String password;
	private String profileImg;
	private String mobilePhone;
	private String createdAt;
	
	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public User(String email, String nickname, String password) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}

	public User(String email, String nickname, String password, String profileImg, String mobilePhone) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.profileImg = profileImg;
		this.mobilePhone = mobilePhone;
	}

	public User(int userId, String email, String nickname, String password, String profileImg, String mobilePhone,
			String createdAt) {
		this.userId = userId;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.profileImg = profileImg;
		this.mobilePhone = mobilePhone;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", profileImg=" + profileImg + ", mobilePhone=" + mobilePhone + ", createdAt=" + createdAt + "]";
	}
	
	
}
