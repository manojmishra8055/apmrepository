package com.apm.Registration.eu.entity;

public class Location {
	
	private int locationid;
	
	private String country;
	
	private String  city;
	
	private String address;
	
	private String pinCode;
	
	private String location;
	
	private String colorName;
	
	private String locationname;

	public String getCountry() {
		return country;
	}

	public int getLocationid() {
		return locationid;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
