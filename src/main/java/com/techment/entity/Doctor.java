package com.techment.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	@NotNull(message = "name is required")
	@NotBlank(message = "name can not be empty")
	private String doctorName;

	@NotNull(message = "age is required")
	@Min(10)
	@Max(100)
	private int age;

	@NotNull(message = "experience is required")
	@Min(0)
	@Max(50)
	private int experience;

	@NotNull(message = "qualification is required")
	@NotBlank(message = "qualification can not be empty")
	private String qualification;

	@NotNull(message = "city is required")
	@NotBlank(message = "city can not be empty")
	private String city;

	@NotNull(message = "fees is required")
	private int fees;

	@NotNull(message = "gender is required")
	@NotBlank(message = "gender can not be empty")
	private String gender;

	@NotNull(message = "mobile is required")
	@NotBlank(message = "mobile can not be empty")
	@Column(unique = true)
	private String mobile;

	@NotNull(message = "address is required")
	@NotBlank(message = "address can not be empty")
	private String address;

	@NotNull(message = "bio is required")
	@NotBlank(message = "bio can not be empty")
	@Size(min = 5, max = 300)
	private String bio;

	


	@NotNull(message = "speciality is required")
	@NotBlank(message = "speciality can not be empty")
	private String speciality;

	   

	@NotNull(message = "password is required")
	@NotBlank(message = "password can not be empty")
	private String password;

	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "availabilityId", referencedColumnName = "availabilityId")
	private List<AvailabilityDates> availabilityDates;
	
	
   

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Doctor(@NotNull(message = "name is required") @NotBlank(message = "name can not be empty") String doctorName,
			@NotNull(message = "age is required") @Min(10) @Max(100) int age,
			@NotNull(message = "experience is required") @Min(0) @Max(50) int experience,
			@NotNull(message = "qualification is required") @NotBlank(message = "qualification can not be empty") String qualification,
			@NotNull(message = "city is required") @NotBlank(message = "city can not be empty") String city,
			@NotNull(message = "fees is required") int fees,
			@NotNull(message = "gender is required") @NotBlank(message = "gender can not be empty") String gender,
			@NotNull(message = "mobile is required") @NotBlank(message = "mobile can not be empty") String mobile,
			@NotNull(message = "address is required") @NotBlank(message = "address can not be empty") String address,
			@NotNull(message = "bio is required") @NotBlank(message = "bio can not be empty") @Size(min = 5, max = 300) String bio,
			@NotNull(message = "speciality is required") @NotBlank(message = "speciality can not be empty") String speciality,
			@NotNull(message = "password is required") @NotBlank(message = "password can not be empty") String password,
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




	public int getDoctorId() {
		return doctorId;
	}




	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public List<AvailabilityDates> getAvailabilityDates() {
		return availabilityDates;
	}




	public void setAvailabilityDates(List<AvailabilityDates> availabilityDates) {
		this.availabilityDates = availabilityDates;
	}




	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", age=" + age + ", experience="
				+ experience + ", qualification=" + qualification + ", city=" + city + ", fees=" + fees + ", gender="
				+ gender + ", mobile=" + mobile + ", address=" + address + ", bio=" + bio + ", speciality=" + speciality
				+ ", password=" + password + ", availabilityDates=" + availabilityDates + "]";
	}
	




}
