package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IAppointmentDao;
import com.techment.dto.AppointmentDto;
import com.techment.entity.Appointment;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentDao Appointmentdao;
	
	@Override
	public List<AppointmentDto> viewAllAppointments() {
		List<Appointment> appointments = Appointmentdao.findAll();
		List<AppointmentDto> appointmentdtos = new ArrayList<AppointmentDto>();
		for(Appointment appointment :appointments)
		{
			appointmentdtos.add(new AppointmentDto(appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getPatient(), appointment.getDoctor()));
		}
		
		
		
		return appointmentdtos;
	}

	@Override
	public AppointmentDto viewAppointmentForId(int id) {
		Appointment appointment = Appointmentdao.findById(id).get();
		AppointmentDto appointmentdto = new AppointmentDto(appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getPatient(), appointment.getDoctor());

		return appointmentdto;
	}

	@Override
	public String TakeAppointment(AppointmentDto appointment) {

		Appointment addappointment = new Appointment(appointment.getAppointmentDate(), appointment.getAppointmentStatus(), appointment.getRemarks(), appointment.getPatient(), appointment.getDoctor());
				if(appointment.getAppointmentId()!=0)
		{
			addappointment.setAppointmentId(appointment.getAppointmentId());
		}
					Appointmentdao.save(addappointment);
		return "Appointment Scheduled Sucessfully";
	}

	@Override
	public String deleteAppointment(int id) {
		
		Appointmentdao.deleteById(id);
		return "Appointment Cancelled Sucessfully";
	}

}
