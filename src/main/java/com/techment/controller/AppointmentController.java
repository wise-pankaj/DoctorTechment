package com.techment.controller;

import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.AppointmentDto;
import com.techment.dto.PatientDto;
import com.techment.exception.PatientNotFound;
import com.techment.service.AppointmentServiceImpl;
import com.techment.service.IAppointmentService;

@RestController
@RequestMapping(value = "/Appointmentcontroller")
public class AppointmentController {

	@Autowired
	IAppointmentService appointmentService;
	
	@GetMapping("/showAllAppointments")
	public List<AppointmentDto> showall()
	{
		List<AppointmentDto> appointments = appointmentService.viewAllAppointments();
		return appointments;
	}
	
	@GetMapping("showAppointment/{id}")
	public AppointmentDto show(int id)
	{		
		try
		{
			AppointmentDto appointment = appointmentService.viewAppointmentForId(id);			
			return appointment;
		}
		catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
		
		
	}
	
	@PostMapping("TakeAppointment")
	public ResponseEntity<String> AddAppointment(AppointmentDto appointment)
	{
		String Output = appointmentService.TakeAppointment(appointment);
		return new ResponseEntity<String>(Output,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("CancelAppointment/{id}")
	public ResponseEntity<String> DeleteAppointment(int id)
	{

		String Output = appointmentService.deleteAppointment(id);
		return new ResponseEntity<String>(Output,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/UpdateAppointment")
	public ResponseEntity<String> UpdateAppointment(@PathVariable int id ,@RequestBody AppointmentDto appointmentdto)
	{
		
		
		
		
		
		try {
			AppointmentDto appointment = appointmentService.viewAppointmentForId(id);
			if(appointment!=null)
			{
				appointment.setAppointmentDate(appointmentdto.getAppointmentDate());
				appointment.setAppointmentStatus(appointment.getAppointmentStatus());
				appointment.setRemarks(appointmentdto.getRemarks());
				appointmentService.TakeAppointment(appointment);
				
				return new ResponseEntity<String>("Appointment Successfully updated",HttpStatus.ACCEPTED);
			}
			else
				return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
		} catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
		
		
		
		
		
	}
}
