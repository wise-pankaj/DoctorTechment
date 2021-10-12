package com.techment.controller;

import java.util.List;

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

import com.techment.dto.PatientDto;
import com.techment.entity.Patient;
import com.techment.exception.PatientNotFound;
import com.techment.service.IPatientService;

@RestController
@RequestMapping(value = "/clientController")
public class PatientController {
	
	@Autowired
	IPatientService clientService;
	
	@PostMapping(value = "/addPatient")
	public ResponseEntity<String> addnewClient(@RequestBody PatientDto client)
	{		
			String OutputString =clientService.AddClient(client);
			return new ResponseEntity<String>(OutputString,HttpStatus.ACCEPTED);		
	}
	
	@GetMapping("/viewAll")
	public List<PatientDto> ViewClients()
	{
		return clientService.GetClients();
	}
	
	@GetMapping("/viewAll/{id}")
	public PatientDto ViewClientById(@PathVariable int id)
	{
		try
		{
			PatientDto patient = clientService.GetClientById(id);
				return patient;
		}
		catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
		
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<String>  ViewClientById(@PathVariable int id,@RequestBody PatientDto client)
	{
			
			
			try {
				PatientDto clientupdate = clientService.GetClientById(id);
				if(clientupdate!=null)
				{
					clientupdate.setPatientId(id);
					clientupdate.setPatientAddress(client.getPatientAddress());
					clientupdate.setPatientAge(client.getPatientAge());
					clientupdate.setPatientBloodGroup(client.getPatientBloodGroup());
					clientupdate.setPatientEmail(client.getPatientEmail());
					clientupdate.setPatientGender(client.getPatientGender());
					clientupdate.setPatientMobile(client.getPatientMobile());
					clientupdate.setPatientName(client.getPatientName());
					clientupdate.setPatientPassword(client.getPatientPassword());
					
					clientService.AddClient(clientupdate);
					
					return new ResponseEntity<String>("Client Updated",HttpStatus.ACCEPTED);
				}
				else
					return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
			} catch (Exception e) {
				throw new PatientNotFound("No User found");
			}
			
			
				
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> DeleteClientById(@PathVariable int id)
	{
		try
		{

			clientService.DeleteClientById(id);
			return new ResponseEntity<String>("Client Deleted Successfully",HttpStatus.ACCEPTED);	
		}
		catch (Exception e) {
			throw new PatientNotFound("No User found");
		}
	}
	@GetMapping("/Login/{username}/{password}")
	public PatientDto LoginPatient(@PathVariable String username,@PathVariable String password)
	{
		return clientService.PatientLogin(username,password);
	}
	
	
}
