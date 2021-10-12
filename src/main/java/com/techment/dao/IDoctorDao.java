package com.techment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.dto.DoctorDto;
import com.techment.entity.Doctor;

public interface IDoctorDao extends JpaRepository<Doctor, Integer> {

	List <Doctor> findBySpeciality(String speciality);

	Doctor findByMobile(String mobile);
	
}
