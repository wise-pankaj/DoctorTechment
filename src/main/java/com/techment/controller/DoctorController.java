package com.techment.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.techment.dao.IDoctorDao;
import com.techment.dto.DoctorDto;
import com.techment.entity.Doctor;
import com.techment.exception.AlreadyExist;
import com.techment.exception.NotFound;
import com.techment.service.IDoctorService;

@RestController
@RequestMapping(value = "doctorController")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	@Autowired
	IDoctorDao dao;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<String> registerDoctor( @RequestBody DoctorDto doctor)
	{
	try {
		
		Doctor doc = dao.findByMobile(doctor.getMobile());
		System.out.println(doc);
		if(doc==null)
		{
			doctorService.addDoctor(doctor);	
			return new ResponseEntity<String>("Doctor Registered Successfully",HttpStatus.CREATED);
		}
		
		else {
			throw new AlreadyExist("already exist");
		}
		
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		throw new AlreadyExist("already exist");
	}
	}
	
	@GetMapping("/getDoctor/{id}")
	public DoctorDto getDoctor(@Valid @PathVariable int id)
	{
		try {
			
			return doctorService.getDoctor(id);
		}catch(Exception e) {
			throw new NotFound("doctor not found ");
		}
		
		
	
	}
	
	@DeleteMapping("/removeDoctor")
	public String removeDoctor(@Valid @RequestBody int id) {
		
      try {
			
	return doctorService.removeDoctor(id);
		}catch(Exception e) {
			throw new NotFound("doctor not found ");
		}
		
		
		
	}
	
	@GetMapping("/getDoctorList")
	public List<DoctorDto> getDoctorList(){
		try {
			return doctorService.getDoctorList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	@GetMapping("/getDoctorListBySpeciality/{speciality}")
	public List<DoctorDto> getDoctorListBySpeciality(@Valid @PathVariable String speciality){
		return doctorService.getDoctorListBySpeciality(speciality);
	}
	
	@PutMapping("/updateDoctor/{id}")
	public String updateDoctor(@Valid @RequestBody DoctorDto doctor,@PathVariable int id)
	{
		
		
	      try {
				
	    		
	  		return doctorService.updateDoctor(doctor, id);
			}catch(Exception e) {
				throw new NotFound("doctor not found ");
			}
		
	
	}
	
	
}
