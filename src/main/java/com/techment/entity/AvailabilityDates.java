package com.techment.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AvailabilityDates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int availabilityId;


	
	private LocalDate fromDate;
	private LocalDate endDate;
	
	
	public int getAvailabilityId() {
		return availabilityId;
	}
	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
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
	public AvailabilityDates(int availabilityId, LocalDate fromDate, LocalDate endDate) {
		super();
		this.availabilityId=availabilityId;
		this.fromDate = fromDate;
		this.endDate = endDate;
	}
	public AvailabilityDates() {
		super();
	}
	
	
}
