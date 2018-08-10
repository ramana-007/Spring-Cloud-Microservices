package com.microservice.citydetails.controller;

import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.citydetails.entity.City;
import com.microservice.citydetails.service.CityService;
import com.microservice.citydetails.vo.ResponseVO;



@RestController
@RequestMapping("/cities")

public class CityDetailsController {
	private final CityService cityService;
	
	public CityDetailsController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping(value = "/{city_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<City>> get(@PathVariable("city_id") String cityId) {
		return ResponseEntity.ok(new ResponseVO<>(cityService.get(cityId)));
	}

	@DeleteMapping(value = "/{city_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<String>> delete(@PathVariable("city_id") String cityId) {
		cityService.delete(cityId);
		return ResponseEntity.ok(new ResponseVO<>(cityId));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO<City>> create(@RequestBody City city) {
		City savedCity = cityService.save(city);
		return ResponseEntity.created(URI.create("/" + city.getCityId())).body(new ResponseVO<>(savedCity));
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody City city) {
		cityService.update(city);
		return ResponseEntity.noContent().build();
	}
}
