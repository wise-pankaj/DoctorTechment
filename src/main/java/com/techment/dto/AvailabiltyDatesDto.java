package com.techment.dto;

import java.time.LocalDate;

import com.techment.entity.Doctor;

public class AvailabiltyDatesDto {

   private  DoctorDto doctor;
	
   private LocalDate fromDate;
   private LocalDate endDate;
public DoctorDto getDoctor() {
	return doctor;
}
public void setDoctor(DoctorDto doctor) {
	this.doctor = doctor;
}
public LocalDate getFromDate() {
	return fromDate;
}
public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public AvailabiltyDatesDto(DoctorDto doctor, LocalDate fromDate, LocalDate endDate) {
	super();
	this.doctor = doctor;
	this.fromDate = fromDate;
	this.endDate = endDate;
}
public AvailabiltyDatesDto() {
	super();
}
	
	
	
	
}
