package com.techment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Id
	@NotNull (message="username is required")
	@NotBlank (message="username can not be empty")
	@Column(unique = true)
	private String username;
	
	@NotNull (message="password is required")
	@NotBlank (message="password can not be empty")
	private String password;
	
	private String role;
	
	private String token;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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

	
	public User() {
		
	}
	
	
	public User(
			@NotNull(message = "username is required") @NotBlank(message = "username can not be empty") String username,
			@NotNull(message = "password is required") @NotBlank(message = "password can not be empty") String password,
			String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	
}
