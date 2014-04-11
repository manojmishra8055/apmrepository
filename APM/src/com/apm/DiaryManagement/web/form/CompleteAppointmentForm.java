package com.apm.DiaryManagement.web.form;

import java.util.ArrayList;

import com.apm.Accounts.eu.entity.Accounts;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.Registration.eu.entity.Location;

public class CompleteAppointmentForm {
	
	private String user;
	
	private ArrayList<Location>locationList;
	
	private ArrayList<AppointmentType>appointmentTypeList;
	
	private String charge;
	
	private String clientId;
	
	private int id;
	
	private String apmtType;
	
	private String charges;
	
	private String startTime;
	
	private String duration;
	
	private String practitionerId;
	
	private String practitionerName;
	
	private String chargeTotal;
	
	private String commencing;
	
	private String payBuy;
	
	private String invoiceDate;
	
	private int numberOfChages;
	
	private String insuranceCompany;

	private ArrayList<CompleteAppointment> clientChargeListDetail;
	
	private ArrayList<CompleteAppointment>assesmentList;
	
	private ArrayList<Accounts>invoiceAssesmentList;
	
	private String totalassesment;
	
	private Integer invoiceid;
	
	private String paidAmount;
	
	private String debitAmounnt;
	//unnati
	private ArrayList<DiaryManagement>userList;
	
	private ArrayList<String>startTimeList;
	
	private ArrayList<String>endTimeList;
	
	private ArrayList<String> apmtDurationList;
	
	private String diaryUser;
	
	


	
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDebitAmounnt() {
		return debitAmounnt;
	}
	public void setDebitAmounnt(String debitAmounnt) {
		this.debitAmounnt = debitAmounnt;
	}
	public int getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getTotalassesment() {
		return totalassesment;
	}
	public void setTotalassesment(String totalassesment) {
		this.totalassesment = totalassesment;
	}
	public ArrayList<CompleteAppointment> getClientChargeListDetail() {
		return clientChargeListDetail;
	}
	public void setClientChargeListDetail(
			ArrayList<CompleteAppointment> clientChargeListDetail) {
		this.clientChargeListDetail = clientChargeListDetail;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public ArrayList<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(ArrayList<Location> locationList) {
		this.locationList = locationList;
	}
	public ArrayList<AppointmentType> getAppointmentTypeList() {
		return appointmentTypeList;
	}
	public void setAppointmentTypeList(
			ArrayList<AppointmentType> appointmentTypeList) {
		this.appointmentTypeList = appointmentTypeList;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApmtType() {
		return apmtType;
	}
	public void setApmtType(String apmtType) {
		this.apmtType = apmtType;
	}
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getPractitionerId() {
		return practitionerId;
	}
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}
	public String getPractitionerName() {
		return practitionerName;
	}
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	
	public String getChargeTotal() {
		return chargeTotal;
	}
	public void setChargeTotal(String chargeTotal) {
		this.chargeTotal = chargeTotal;
	}
	public String getCommencing() {
		return commencing;
	}
	public void setCommencing(String commencing) {
		this.commencing = commencing;
	}
	public String getPayBuy() {
		return payBuy;
	}
	public void setPayBuy(String payBuy) {
		this.payBuy = payBuy;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public ArrayList<CompleteAppointment> getAssesmentList() {
		return assesmentList;
	}
	public void setAssesmentList(ArrayList<CompleteAppointment> assesmentList) {
		this.assesmentList = assesmentList;
	}
	public int getNumberOfChages() {
		return numberOfChages;
	}
	public void setNumberOfChages(int numberOfChages) {
		this.numberOfChages = numberOfChages;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public ArrayList<Accounts> getInvoiceAssesmentList() {
		return invoiceAssesmentList;
	}
	public void setInvoiceAssesmentList(ArrayList<Accounts> invoiceAssesmentList) {
		this.invoiceAssesmentList = invoiceAssesmentList;
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
	public String getDiaryUser() {
		return diaryUser;
	}
	public void setDiaryUser(String diaryUser) {
		this.diaryUser = diaryUser;
	}


}
