package com.techment.service;

import java.util.List;

import com.techment.dto.PatientDto;

public interface IPatientService {

	String AddClient(PatientDto client);//Add
	List<PatientDto> GetClients();//View All
	PatientDto GetClientById(int id);//View one
	String DeleteClientById(int id);//Delete
	PatientDto PatientLogin(String username,String password); // View respect to mobile and password
	
	
	
}
