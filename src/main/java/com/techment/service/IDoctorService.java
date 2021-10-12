package com.techment.service;

import java.util.List;

import javax.validation.Valid;

import com.techment.dto.DoctorDto;


public interface IDoctorService {

	String addDoctor( DoctorDto doctor);
	DoctorDto getDoctor(int id);
	String removeDoctor(int id);
	List<DoctorDto> getDoctorList();
	List<DoctorDto> getDoctorListBySpeciality(String speciality);
	String updateDoctor(DoctorDto doctor,int id);
	
}
