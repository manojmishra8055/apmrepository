package com.apm.DiaryManagement.eu.entity;

import java.io.Serializable;
import java.util.ArrayList;

import com.apm.DiaryManagement.web.common.Month;

public class DiaryManagement implements Serializable{
	
	private int id;
	
	private String commencing;
	
	private String selectedDiaryUser;
	
	private String location;
	
	private String room;
	
	private String description;
	
	private boolean onlineBooking;
	
	private String sTime;
	
	private String endTime;
	
	private String apmtDuration;
	
	private int diarUserid;
	
	private String firstName;
	
	private String lastName;
	
	private String tdCode;
	
	private String weekName;
	
	private String year;
	
	private ArrayList<Tdcode>tdDataList;
	
	private ArrayList<Month>monthtdList;
	
	private String diaryColor;
	
	private String locationColor;
	
	private String weekFullName;
	
	private String diaryUser;
	
	
	


	
	public String getDiaryUser() {
		return diaryUser;
	}

	public void setDiaryUser(String diaryUser) {
		this.diaryUser = diaryUser;
	}

	public String getWeekFullName() {
		return weekFullName;
	}

	public void setWeekFullName(String weekFullName) {
		this.weekFullName = weekFullName;
	}

	public String getDiaryColor() {
		return diaryColor;
	}

	public void setDiaryColor(String diaryColor) {
		this.diaryColor = diaryColor;
	}

	public ArrayList<Month> getMonthtdList() {
		return monthtdList;
	}

	public void setMonthtdList(ArrayList<Month> monthtdList) {
		this.monthtdList = monthtdList;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCommencing() {
		return commencing;
	}

	public void setCommencing(String commencing) {
		this.commencing = commencing;
	}

	public String getSelectedDiaryUser() {
		return selectedDiaryUser;
	}

	public void setSelectedDiaryUser(String selectedDiaryUser) {
		this.selectedDiaryUser = selectedDiaryUser;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnlineBooking() {
		return onlineBooking;
	}

	public void setOnlineBooking(boolean onlineBooking) {
		this.onlineBooking = onlineBooking;
	}

	public String getSTime() {
		return sTime;
	}

	public void setSTime(String time) {
		sTime = time;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public int getDiarUserid() {
		return diarUserid;
	}

	public void setDiarUserid(int diarUserid) {
		this.diarUserid = diarUserid;
	}

	public String getApmtDuration() {
		return apmtDuration;
	}

	public void setApmtDuration(String apmtDuration) {
		this.apmtDuration = apmtDuration;
	}

	public String getTdCode() {
		return tdCode;
	}

	public void setTdCode(String tdCode) {
		this.tdCode = tdCode;
	}

	public ArrayList<Tdcode> getTdDataList() {
		return tdDataList;
	}

	public void setTdDataList(ArrayList<Tdcode> tdDataList) {
		this.tdDataList = tdDataList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationColor() {
		return locationColor;
	}

	public void setLocationColor(String locationColor) {
		this.locationColor = locationColor;
	}

	
	
	

}
