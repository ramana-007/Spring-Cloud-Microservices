package com.microservice.citydetails.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author D
 *
 */

@Entity
@Table(name = "products", schema = "product")

public class City implements Serializable{
	
@Id
private String cityId;
private String originCity;
private String destinationCity;

@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
@Temporal(TemporalType.TIMESTAMP)
private Date departureTime;

@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
@Temporal(TemporalType.TIMESTAMP)
private Date arrivalTime;

public City(String cityId, String originCity, String destinationCity, Date departureTime, Date arrivalTime) {
	super();
	this.cityId = cityId;
	this.originCity = originCity;
	this.destinationCity = destinationCity;
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
}

public String getCityId() {
	return cityId;
}

public void setCityId(String cityId) {
	this.cityId = cityId;
}

public String getOriginCity() {
	return originCity;
}

public void setOriginCity(String originCity) {
	this.originCity = originCity;
}

public String getDestinationCity() {
	return destinationCity;
}

public void setDestinationCity(String destinationCity) {
	this.destinationCity = destinationCity;
}

public Date getDepartureTime() {
	return departureTime;
}

public void setDepartureTime(Date departureTime) {
	this.departureTime = departureTime;
}

public Date getArrivalTime() {
	return arrivalTime;
}

public void setArrivalTime(Date arrivalTime) {
	this.arrivalTime = arrivalTime;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("City [id=").append(cityId).append(", originCity=").append(originCity).append(", destinationCity=").append(destinationCity)
			.append(", departureTime=").append(departureTime).append(", arrivalTime=").append(arrivalTime).append("]");
	return builder.toString();
}

}
