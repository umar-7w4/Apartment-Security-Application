package com.cg.asm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String mobileNo;
	private String emailId;

	@OneToOne
	@JoinColumn(name = "guards_traning_id", referencedColumnName = "guardsTraningId")
	private GuardsTraning guardsTraning;
	
	public User() {
		super();
	}
	

	public User(int userId, String firstName, String lastName, String loginId, String password, String mobileNo,
			String emailId, GuardsTraning guardsTraning) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.guardsTraning = guardsTraning;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public GuardsTraning getGuardsTraning() {
		return guardsTraning;
	}


	public void setGuardsTraning(GuardsTraning guardsTraning) {
		this.guardsTraning = guardsTraning;
	}
	

}
