package com.blc.eventManagement.repository;

import com.blc.eventManagement.model.City;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CityRepository extends JpaRepository<City, Long> {
}
