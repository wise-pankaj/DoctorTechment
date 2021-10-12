package com.techment.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;





@Entity

public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	private int rating;
	private String feedbackComment;
	
	@ManyToOne
	@JoinColumn(name = "patientId" , referencedColumnName = "patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
	private Doctor doctor;
	
	

	
	public Feedback(int rating, String feedbackComment, Patient patient, Doctor doctor) {
		super();
		
		this.rating = rating;
		this.feedbackComment = feedbackComment;
		this.patient = patient;
		this.doctor = doctor;
	}

	public Feedback() {
		super();
		
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	
	

}
