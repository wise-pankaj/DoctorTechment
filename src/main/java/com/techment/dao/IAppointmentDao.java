package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.Appointment;

@Repository
public interface IAppointmentDao extends JpaRepository<Appointment, Integer>{
	

}
