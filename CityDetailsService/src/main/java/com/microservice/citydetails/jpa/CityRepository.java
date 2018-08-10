package com.microservice.citydetails.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.citydetails.entity.City;

@Transactional
public interface CityRepository extends JpaRepository<City, String>{

}
