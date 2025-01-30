package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	@Id
	private int userId;
	private String userName;
	private String userMail;
	private Long mobileNum;
	private String userPassword;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int userId, String userName, String userMail, Long mobileNum, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
		this.mobileNum = mobileNum;
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
