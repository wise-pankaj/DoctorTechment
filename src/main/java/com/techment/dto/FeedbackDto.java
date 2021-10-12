package com.techment.dto;

import com.techment.entity.Doctor;
import com.techment.entity.Patient;

public class FeedbackDto {

	
	int rating;
	
	String feedbackComment;
	Patient patient;
	Doctor doctor;
	
	

	

	public FeedbackDto(int rating, String feedbackComment, Patient patient, Doctor doctor) {
		super();
		this.rating = rating;
		this.feedbackComment = feedbackComment;
		this.patient = patient;
		this.doctor = doctor;
	}
	public FeedbackDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedbackComment() {
		return feedbackComment;
	}
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
}
