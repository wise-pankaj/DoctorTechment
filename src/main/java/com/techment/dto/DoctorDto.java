package com.techment.dto;

import java.util.List;

import com.techment.entity.AvailabilityDates;

public class DoctorDto {

	private String doctorName;
	private int age;
	private int experience;
	private String qualification;
	private String city;
	private int fees;
	private String gender;
	private String mobile;
	private String address;
	private String bio;
	private String speciality;
	private String password;

	private List<AvailabilityDates> availabilityDates;

	public DoctorDto() {

	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<AvailabilityDates> getAvailabilityDates() {
		return availabilityDates;
	}

	public void setAvailabilityDates(List<AvailabilityDates> availabilityDates) {
		this.availabilityDates = availabilityDates;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DoctorDto(String doctorName, int age, int experience, String qualification, String city, int fees,
			String gender, String mobile, String address, String bio, String speciality, String password,
			List<AvailabilityDates> availabilityDates) {
		super();
		this.doctorName = doctorName;
		this.age = age;
		this.experience = experience;
		this.qualification = qualification;
		this.city = city;
		this.fees = fees;
		this.gender = gender;
		this.mobile = mobile;
		this.address = address;
		this.bio = bio;
		this.speciality = speciality;
		this.password = password;
		this.availabilityDates = availabilityDates;
	}


	
	
	
	
	
}