package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.AvailabilityDates;

public interface IAvailabilityDao extends JpaRepository<AvailabilityDates, Integer>{

}
