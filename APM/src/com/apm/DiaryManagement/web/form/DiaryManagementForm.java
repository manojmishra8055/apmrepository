package com.apm.DiaryManagement.web.form;

import java.util.ArrayList;
import java.util.Calendar;


import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.web.common.Month;
import com.apm.Registration.eu.entity.Location;

public class DiaryManagementForm {

	ArrayList<Month>monthList;
	
	private ArrayList<Month>monthtdList;
	
	Calendar now = Calendar.getInstance(); 
	
	private String diaryYear = Integer.toString(now.get(Calendar.YEAR));
	
	private String actionType;
	
	private String sTime;
	
	ArrayList<String>startTimeList;
	
	private String endTime;
	
	private ArrayList<String>endTimeList;
	
	private String apmtDuration;
	
	private ArrayList<String> apmtDurationList;
	
	private  String diaryUser;
	
	//diary slot data
	
	private String commencing;
	
	private String selectedDiaryUser;
	
	private String location;
	
	private String room;
	
	private String description;
	
	private boolean onlineBooking;
	
	private ArrayList<Location>locationList;
	
	private ArrayList<DiaryManagement>userList;
	
	private ArrayList<DiaryManagement>tdUserList;

	
	public ArrayList<DiaryManagement> getTdUserList() {
		return tdUserList;
	}

	public void setTdUserList(ArrayList<DiaryManagement> tdUserList) {
		this.tdUserList = tdUserList;
	}

	public ArrayList<DiaryManagement> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<DiaryManagement> userList) {
		this.userList = userList;
	}

	public ArrayList<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(ArrayList<Location> locationList) {
		this.locationList = locationList;
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

	public String getDiaryUser() {
		return diaryUser;
	}

	public void setDiaryUser(String diaryUser) {
		this.diaryUser = diaryUser;
	}

	public String getApmtDuration() {
		return apmtDuration;
	}

	public void setApmtDuration(String apmtDuration) {
		this.apmtDuration = apmtDuration;
	}

	

	public ArrayList<String> getApmtDurationList() {
		return apmtDurationList;
	}

	public void setApmtDurationList(ArrayList<String> apmtDurationList) {
		this.apmtDurationList = apmtDurationList;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public ArrayList<Month> getMonthList() {
		return monthList;
	}

	public void setMonthList(ArrayList<Month> monthList) {
		this.monthList = monthList;
	}

	


	

	public String getSTime() {
		return sTime;
	}

	public void setSTime(String time) {
		sTime = time;
	}

	public ArrayList<String> getStartTimeList() {
		return startTimeList;
	}

	public void setStartTimeList(ArrayList<String> startTimeList) {
		this.startTimeList = startTimeList;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ArrayList<String> getEndTimeList() {
		return endTimeList;
	}

	public void setEndTimeList(ArrayList<String> endTimeList) {
		this.endTimeList = endTimeList;
	}

	public String getDiaryYear() {
		return diaryYear;
	}

	public void setDiaryYear(String diaryYear) {
		this.diaryYear = diaryYear;
	}

	public ArrayList<Month> getMonthtdList() {
		return monthtdList;
	}

	public void setMonthtdList(ArrayList<Month> monthtdList) {
		this.monthtdList = monthtdList;
	}

	

}
