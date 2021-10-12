package com.techment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.Patient;

@Repository
public interface IPatientDao extends JpaRepository<Patient, Integer > {
	Patient findByPatientMobileAndPatientPassword(String mobile,String Password);
	
}
