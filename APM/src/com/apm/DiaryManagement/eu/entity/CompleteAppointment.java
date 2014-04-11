package com.apm.DiaryManagement.eu.entity;

public class CompleteAppointment{
	private int id;
	private String user;
	private String apmtType;
	private String charges;
	private String startTime;
	private String duration;
	private String practitionerId;
	private String practitionerName;
	private String clientId;
	private Double chargeTotal;
	private String commencing;
	private String payBuy;
	private String markAppointment;
	private String appointmentid;
	private String invoiceDate;
	
	//unnati
	
	private String insuranceCompanyName;
	private String insuranceCompanyAddress;
	private String insuranceCompanyOwnerName;
	
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(String appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getMarkAppointment() {
		return markAppointment;
	}
	public void setMarkAppointment(String markAppointment) {
		this.markAppointment = markAppointment;
	}
	public String getPayBuy() {
		return payBuy;
	}
	public void setPayBuy(String payBuy) {
		this.payBuy = payBuy;
	}
	public String getCommencing() {
		return commencing;
	}
	public void setCommencing(String commencing) {
		this.commencing = commencing;
	}
	public Double getChargeTotal() {
		return chargeTotal;
	}
	public void setChargeTotal(Double chargeTotal) {
		this.chargeTotal = chargeTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getInsuranceCompanyAddress() {
		return insuranceCompanyAddress;
	}
	public void setInsuranceCompanyAddress(String insuranceCompanyAddress) {
		this.insuranceCompanyAddress = insuranceCompanyAddress;
	}
	public String getInsuranceCompanyOwnerName() {
		return insuranceCompanyOwnerName;
	}
	public void setInsuranceCompanyOwnerName(String insuranceCompanyOwnerName) {
		this.insuranceCompanyOwnerName = insuranceCompanyOwnerName;
	}
}