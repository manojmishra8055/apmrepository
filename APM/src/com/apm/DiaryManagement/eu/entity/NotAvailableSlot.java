package com.apm.DiaryManagement.eu.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.DiaryManagement.web.common.Month;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.utils.DateTimeUtils;

public class NotAvailableSlot {
	private int id;
	
	private String diaryUser;
	
	String currentDate = DateTimeUtils.getDateinSimpleStringFormate(new Date());
	String dateTemp[] = currentDate.split(" ");
	String temp[] =  dateTemp[0].split("-");
	private String commencing = temp[2] + "/" + temp[1] + "/"  + temp[0];
	
	private ArrayList<DiaryManagement>userList;

	private ArrayList<String>startTimeList;
	
	private ArrayList<String>endTimeList;
	
	private ArrayList<String> apmtDurationList;
	
	private String actionType;
	private String locationColor;
	private String sTime;
	private String endTime;
	private String apmtDuration;
	private ArrayList<Location>locationList;
	private String location;
	private String dept;
	private String room;
	private String client;
	private String apmtType;
	private String notes;
	private int apmtSlotId;
	private int diaryUserId;
	
	private String duration;
	
	private String clientName;
	
	private String treatmentEpisodeId;
	
	private boolean appointmentCompleted;
	
	//block attributes
	
	private String blockslotId;
	private String blockdiaryUserId;
	private String blockuser;
	private String blocklocation;
	private String blockroom;
	private String blockdate;
	private String blocksTime;
	private String blockendTime;
	private String blockapmtDuration;
	private String reasonforblock;
	private String status;
	private String blocknotes;
	
	private String clientId;
	
	private String clientEmail;
	private String practitionerEmail;
	
	private double charge;
	//arrived status
	private int arrivedStatus;
	private boolean dna;

	public boolean isDna() {
		return dna;
	}
	public void setDna(boolean dna) {
		this.dna = dna;
	}
	public int getArrivedStatus() {
		return arrivedStatus;
	}
	public void setArrivedStatus(int arrivedStatus) {
		this.arrivedStatus = arrivedStatus;
	}
	public String getBlocknotes() {
		return blocknotes;
	}
	public void setBlocknotes(String blocknotes) {
		this.blocknotes = blocknotes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getDiaryUserId() {
		return diaryUserId;
	}
	public void setDiaryUserId(int diaryUserId) {
		this.diaryUserId = diaryUserId;
	}
	public int getApmtSlotId() {
		return apmtSlotId;
	}
	public void setApmtSlotId(int apmtSlotId) {
		this.apmtSlotId = apmtSlotId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiaryUser() {
		return diaryUser;
	}
	public void setDiaryUser(String diaryUser) {
		this.diaryUser = diaryUser;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String[] getDateTemp() {
		return dateTemp;
	}
	public void setDateTemp(String[] dateTemp) {
		this.dateTemp = dateTemp;
	}
	public String[] getTemp() {
		return temp;
	}
	public void setTemp(String[] temp) {
		this.temp = temp;
	}
	public String getCommencing() {
		return commencing;
	}
	public void setCommencing(String commencing) {
		this.commencing = commencing;
	}
	public ArrayList<DiaryManagement> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<DiaryManagement> userList) {
		this.userList = userList;
	}
	public ArrayList<String> getStartTimeList() {
		return startTimeList;
	}
	public void setStartTimeList(ArrayList<String> startTimeList) {
		this.startTimeList = startTimeList;
	}
	public ArrayList<String> getEndTimeList() {
		return endTimeList;
	}
	public void setEndTimeList(ArrayList<String> endTimeList) {
		this.endTimeList = endTimeList;
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
	public String getApmtDuration() {
		return apmtDuration;
	}
	public void setApmtDuration(String apmtDuration) {
		this.apmtDuration = apmtDuration;
	}
	public ArrayList<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(ArrayList<Location> locationList) {
		this.locationList = locationList;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getApmtType() {
		return apmtType;
	}
	public void setApmtType(String apmtType) {
		this.apmtType = apmtType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getLocationColor() {
		return locationColor;
	}
	public void setLocationColor(String locationColor) {
		this.locationColor = locationColor;
	}
	public String getBlockslotId() {
		return blockslotId;
	}
	public void setBlockslotId(String blockslotId) {
		this.blockslotId = blockslotId;
	}
	public String getBlockdiaryUserId() {
		return blockdiaryUserId;
	}
	public void setBlockdiaryUserId(String blockdiaryUserId) {
		this.blockdiaryUserId = blockdiaryUserId;
	}
	public String getBlockuser() {
		return blockuser;
	}
	public void setBlockuser(String blockuser) {
		this.blockuser = blockuser;
	}
	public String getBlocklocation() {
		return blocklocation;
	}
	public void setBlocklocation(String blocklocation) {
		this.blocklocation = blocklocation;
	}
	public String getBlockroom() {
		return blockroom;
	}
	public void setBlockroom(String blockroom) {
		this.blockroom = blockroom;
	}
	public String getBlockdate() {
		return blockdate;
	}
	public void setBlockdate(String blockdate) {
		this.blockdate = blockdate;
	}
	public String getBlocksTime() {
		return blocksTime;
	}
	public void setBlocksTime(String blocksTime) {
		this.blocksTime = blocksTime;
	}
	public String getBlockendTime() {
		return blockendTime;
	}
	public void setBlockendTime(String blockendTime) {
		this.blockendTime = blockendTime;
	}
	public String getBlockapmtDuration() {
		return blockapmtDuration;
	}
	public void setBlockapmtDuration(String blockapmtDuration) {
		this.blockapmtDuration = blockapmtDuration;
	}
	public String getReasonforblock() {
		return reasonforblock;
	}
	public void setReasonforblock(String reasonforblock) {
		this.reasonforblock = reasonforblock;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getPractitionerEmail() {
		return practitionerEmail;
	}
	public void setPractitionerEmail(String practitionerEmail) {
		this.practitionerEmail = practitionerEmail;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public String getTreatmentEpisodeId() {
		return treatmentEpisodeId;
	}
	public void setTreatmentEpisodeId(String treatmentEpisodeId) {
		this.treatmentEpisodeId = treatmentEpisodeId;
	}
	public boolean isAppointmentCompleted() {
		return appointmentCompleted;
	}
	public void setAppointmentCompleted(boolean appointmentCompleted) {
		this.appointmentCompleted = appointmentCompleted;
	}
	
	
}
