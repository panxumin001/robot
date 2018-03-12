package com.germaine.recureRobot.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.io.Serializable;

@EntityScan
public class User implements Serializable {

	private Integer mobile;
	private String socialSecurityNo; //用户社保号
	private String userName; //用户名
	private String nickName; //昵称
	private String passWord; //密码
	private String gender; //性别
	private String age; //年龄
	private String totalTrainingTime; //训练总时长

	public User(Integer mobile, String socialSecurityNo, String userName, String nickName, String passWord, String gender, String age, String totalTrainingTime) {
		this.mobile = mobile;
		this.socialSecurityNo = socialSecurityNo;
		this.userName = userName;
		this.nickName = nickName;
		this.passWord = passWord;
		this.gender = gender;
		this.age = age;
		this.totalTrainingTime = totalTrainingTime;
	}

	public User() {
	}

	public Integer getMobile() { return mobile != null ? mobile : 0 ; }

	public void setMobile(Integer mobile) { this.mobile = mobile; }

	public String getSocialSecurityNo() {
		return socialSecurityNo;
	}

	public void setSocialSecurityNo(String socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTotalTrainingTime() {
		return totalTrainingTime;
	}

	public void setTotalTrainingTime(String totalTrainingTime) {
		this.totalTrainingTime = totalTrainingTime;
	}
}