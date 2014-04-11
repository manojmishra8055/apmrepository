package com.apm.Appointment.web.form;

import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;


public class AppointmentTypeForm{
	private int id;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private String duration;
	
	private String color;
	
	private ArrayList<AppointmentType>appointmentTypeList;
	
	private ArrayList<AppointmentType>colorList;
	
	private ArrayList<String> apmtDurationList;

	
	private String charges;
	private String pagerecords;
	private int totalRecords;



	public String getPagerecords() {
		return pagerecords;
	}

	public void setPagerecords(String pagerecords) {
		this.pagerecords = pagerecords;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<AppointmentType> getAppointmentTypeList() {
		return appointmentTypeList;
	}

	public void setAppointmentTypeList(
			ArrayList<AppointmentType> appointmentTypeList) {
		this.appointmentTypeList = appointmentTypeList;
	}

	public ArrayList<AppointmentType> getColorList() {
		return colorList;
	}

	public void setColorList(ArrayList<AppointmentType> colorList) {
		this.colorList = colorList;
	}

	public ArrayList<String> getApmtDurationList() {
		return apmtDurationList;
	}

	public void setApmtDurationList(ArrayList<String> apmtDurationList) {
		this.apmtDurationList = apmtDurationList;
	}
	
	
	
}