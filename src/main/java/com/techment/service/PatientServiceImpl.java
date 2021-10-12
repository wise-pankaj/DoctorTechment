package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techment.dao.IPatientDao;
import com.techment.dao.IUserDao;
import com.techment.dto.PatientDto;
import com.techment.entity.Patient;
import com.techment.entity.User;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientDao clientdao;
	
	@Autowired
	IUserDao user;
	
	
	
	
	@Override
	public String AddClient(PatientDto client) {
		
		
		if(client.getPatientAddress()==null||client.getPatientAddress()=="")
		{
			return "Please Give The Proper Address";
		}
		else if(client.getPatientAge()<1||client.getPatientAge()>110)
		{
			return "Please Give The Proper Age";
		}
		else if(client.getPatientBloodGroup()==null||client.getPatientBloodGroup()=="")
		{
			return "Please Give The Proper Blood Group";
		}
		else if(client.getPatientEmail()==null||client.getPatientEmail()=="")
		{
			return "Please Give The Proper Email";
		}
		else if(client.getPatientGender()==null||client.getPatientGender()=="")
		{
			return "Please Give The Proper Gender";
		}
		else if(client.getPatientMobile()==null||client.getPatientMobile()=="")
		{
			return "Please Give The Proper Mobile Number";
		}
		else if(client.getPatientName()==null||client.getPatientName()=="")
		{
			return "Please Give The Proper Name";
		}
		else if(client.getPatientPassword()==null||client.getPatientPassword()=="")
		{
			return "Please Give The Proper Password";
		}
		else
		{
			
		Patient patient = new Patient(client.getPatientName(),
				client.getPatientMobile(),client.getPatientEmail()
				,client.getPatientPassword(),client.getPatientBloodGroup()
				,client.getPatientGender(),client.getPatientAge(),client.getPatientAddress());
		if(client.getPatientId()!=0)
		{
			patient.setPatientId(client.getPatientId());
		}
		
		else
		{
			if(user.findByUsername(client.getPatientMobile())==null)
			{
				user.save(new User(client.getPatientMobile(), client.getPatientPassword(), "Patient"));
			}
		}
		
		
		clientdao.save(patient);
		return "Details Of Client Added Successfully";
	}
		}

	@Override
	public List<PatientDto> GetClients() {
		List<Patient> clients = clientdao.findAll();
		List<PatientDto> clientList = new ArrayList<PatientDto>();
		for(Patient client : clients )
		{
			clientList.add(new PatientDto(client.getPatientName(),
					client.getPatientMobile(), client.getPatientEmail(),
					client.getPatientPassword(), client.getPatientBloodGroup(),
					client.getPatientGender(), client.getPatientAge(), client.getPatientAddress()));			
		}
		return clientList;
	}

	@Override
	public PatientDto GetClientById(int id) {
		Patient client = clientdao.findById(id).get();
//		if(client==null)
//		{
//			return "No Client With This Id";
//		}
		PatientDto clientdto =new PatientDto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return clientdto;
	}

	@Override
	public String DeleteClientById(int id) {
		
		clientdao.deleteById(id);
		return "Client Deleted Successfully";
	}

	@Override
	public PatientDto PatientLogin(String username, String password) {
		Patient client = clientdao.findByPatientMobileAndPatientPassword(username, password);
		PatientDto patient =new PatientDto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return patient;
//		return null;
	}

}
