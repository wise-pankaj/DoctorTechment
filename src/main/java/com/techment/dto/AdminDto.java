package com.techment.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.techment.entity.Admin;

	public class AdminDto {

		int id;
		String name;
		String contactnumber;
		String email;
		String token;
		String password;
		
		public AdminDto() {
			super();
		}
		public AdminDto( String name, String contactnumber, String email, String password) {
			super();
		
			this.name = name;
			this.contactnumber = contactnumber;
			this.email = email;
		
		}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContactnumber() {
			return contactnumber;
		}
		public void setContactnumber(String contactnumber) {
			this.contactnumber = contactnumber;
		}
		public String getEmail() {
			return email;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
	
		
		

		
}
