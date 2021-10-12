package com.techment.dto;

import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
import com.techment.entity.Doctor;
import com.techment.entity.Patient;

public class AppointmentDto {

	private int appointmentId;
	
	private LocalDate appointmentDate;
	private String appointmentStatus;
	private String remarks;
	Patient patient;
	Doctor doctor;
	
	
	public AppointmentDto(LocalDate appointmentDate, String appointmentStatus, String remarks, Patient patient,
			Doctor doctor) {
		super();
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.remarks = remarks;
		this.patient = patient;
		this.doctor = doctor;
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
//	public Appointmentdto( LocalDate appointmentDate, String appointmentStatus, String remarks) {
//		super();
//		this.appointmentDate = appointmentDate;
//		this.appointmentStatus = appointmentStatus;
//		this.remarks = remarks;
//	}
	public AppointmentDto() {
		super();
	}
	
	
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
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
	
	
}
