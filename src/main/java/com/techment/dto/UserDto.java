package com.techment.dto;

public class UserDto {
	
	
	String username;
	String password;
	String role;
	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	


	//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
}
