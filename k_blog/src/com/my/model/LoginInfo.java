package com.my.model;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class LoginInfo {
	
	@Pattern(regexp="123",message="hello world")
	@Size(min=123, max=1123231) 
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
