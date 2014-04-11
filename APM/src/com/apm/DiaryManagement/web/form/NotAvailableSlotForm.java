package com.apm.DiaryManagement.web.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.DiaryManagement.web.common.Month;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.utils.DateTimeUtils;


public class NotAvailableSlotForm {
	
	private int id;
	
	private String diaryUser;
	
	String currentDate = DateTimeUtils.getDateinSimpleStringFormate(new Date());
	String dateTemp[] = currentDate.split(" ");
	String temp[] =  dateTemp[0].split("-");

	
	private String commencing = temp[0] + "/" + temp[1] + "/" + temp[2];
	
	private ArrayList<DiaryManagement>userList;

	private ArrayList<String>startTimeList;
	
	private ArrayList<String>endTimeList;
	
	private ArrayList<String> apmtDurationList;
	
	private ArrayList<String> apmtBlockDurationList;
	
	private ArrayList<AppointmentType>appointmentTypeList;
	
	private String actionType;
	
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
	private String user;
	private String date;
	private int diaryUserId;
	private int slotId;

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
	
	private String practitonerName;
	private String toDate;
	
	private ArrayList<String> clientOccupationList;
	private ArrayList<String> refrenceList;
	private ArrayList<String> initialList;
	ArrayList<String> sourceOfIntroList;
	private ArrayList<String> countryList;
	private ArrayList<Client> thirdPartyTypeList;
	private ArrayList<Client> thirdPartyTypeNameList;

	
	
	private ArrayList<NotAvailableSlot>practitionerApmtList;
	public ArrayList<NotAvailableSlot> getPractitionerApmtList() {
		return practitionerApmtList;
	}

	public void setPractitionerApmtList(
			ArrayList<NotAvailableSlot> practitionerApmtList) {
		this.practitionerApmtList = practitionerApmtList;
	}

	public String getBlocknotes() {
		return blocknotes;
	}

	public void setBlocknotes(String blocknotes) {
		this.blocknotes = blocknotes;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getDiaryUserId() {
		return diaryUserId;
	}

	public void setDiaryUserId(int diaryUserId) {
		this.diaryUserId = diaryUserId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public ArrayList<DiaryManagement> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<DiaryManagement> userList) {
		this.userList = userList;
	}

	public String getCommencing() {
		return commencing;
	}

	public void setCommencing(String commencing) {
		this.commencing = commencing;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<AppointmentType> getAppointmentTypeList() {
		return appointmentTypeList;
	}

	public void setAppointmentTypeList(
			ArrayList<AppointmentType> appointmentTypeList) {
		this.appointmentTypeList = appointmentTypeList;
	}

	public ArrayList<String> getApmtBlockDurationList() {
		return apmtBlockDurationList;
	}

	public void setApmtBlockDurationList(ArrayList<String> apmtBlockDurationList) {
		this.apmtBlockDurationList = apmtBlockDurationList;
	}

	public String getPractitonerName() {
		return practitonerName;
	}

	public void setPractitonerName(String practitonerName) {
		this.practitonerName = practitonerName;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public ArrayList<String> getClientOccupationList() {
		return clientOccupationList;
	}

	public void setClientOccupationList(ArrayList<String> clientOccupationList) {
		this.clientOccupationList = clientOccupationList;
	}

	public ArrayList<String> getRefrenceList() {
		return refrenceList;
	}

	public void setRefrenceList(ArrayList<String> refrenceList) {
		this.refrenceList = refrenceList;
	}

	public ArrayList<String> getInitialList() {
		return initialList;
	}

	public void setInitialList(ArrayList<String> initialList) {
		this.initialList = initialList;
	}

	public ArrayList<String> getSourceOfIntroList() {
		return sourceOfIntroList;
	}

	public void setSourceOfIntroList(ArrayList<String> sourceOfIntroList) {
		this.sourceOfIntroList = sourceOfIntroList;
	}

	public ArrayList<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<String> countryList) {
		this.countryList = countryList;
	}

	public ArrayList<Client> getThirdPartyTypeList() {
		return thirdPartyTypeList;
	}

	public void setThirdPartyTypeList(ArrayList<Client> thirdPartyTypeList) {
		this.thirdPartyTypeList = thirdPartyTypeList;
	}

	public ArrayList<Client> getThirdPartyTypeNameList() {
		return thirdPartyTypeNameList;
	}

	public void setThirdPartyTypeNameList(ArrayList<Client> thirdPartyTypeNameList) {
		this.thirdPartyTypeNameList = thirdPartyTypeNameList;
	}
	

}
