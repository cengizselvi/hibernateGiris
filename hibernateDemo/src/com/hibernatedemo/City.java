package com.hibernatedemo;

import javax.persistence.*;


@Entity // bir veritabanı nesnedi olduğunu söyledik
@Table(name="city")
public class City {
	@Id
	@Column(name="city_id")
	private int id;
	
	@Column(name="city")
	private String cityName;
	
	@Column(name="country_id")
	private String countryId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	

}
