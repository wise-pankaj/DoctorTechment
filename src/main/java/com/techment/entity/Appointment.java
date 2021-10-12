package com.techment.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "DoctorAppAppointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	

	private LocalDate appointmentDate;
	private String appointmentStatus;
	private String remarks;
	
		@ManyToOne
		@JoinColumn(name = "patientId" , referencedColumnName = "patientId")
		Patient patient;
		
		@ManyToOne
		@JoinColumn(name = "doctorId",referencedColumnName = "doctorId")
		Doctor doctor;
		

		
		
		

	public Appointment(LocalDate appointmentDate, String appointmentStatus, String remarks, Patient patient,
			Doctor doctor) {
		super();
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.remarks = remarks;
		this.patient = patient;
		this.doctor = doctor;
	}
	public Appointment() {
		super();
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}


	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
