package com.techment.dto;

public class UserDtoShow {
	
	String username;
	String token;
	
	
	public UserDtoShow() {
		super();
	}
	public UserDtoShow(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
