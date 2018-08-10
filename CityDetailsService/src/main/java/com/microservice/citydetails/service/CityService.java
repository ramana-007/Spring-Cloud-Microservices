package com.microservice.citydetails.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.microservice.citydetails.entity.City;
import com.microservice.citydetails.jpa.CityRepository;

@Service
public class CityService implements GenericService<City, String>{
	private final CityRepository cityRepository;
	
	
	public CityService(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public String getId(City entity) {
		return entity.getCityId();
	}

	@Override
	public CrudRepository<City, String> getRepository() {
		return this.cityRepository;
	}

}
