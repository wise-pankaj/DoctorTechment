package com.techment.service;

import java.util.List;

import com.techment.dto.AppointmentDto;
import com.techment.entity.Appointment;

public interface IAppointmentService {

	List<AppointmentDto> viewAllAppointments();
	AppointmentDto viewAppointmentForId(int id);
	String TakeAppointment(AppointmentDto appointment);
	String deleteAppointment(int id);
	
}
