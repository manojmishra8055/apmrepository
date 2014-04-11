package com.apm.DiaryManagement.eu.entity;

import java.util.ArrayList;

public class Client{
	private int id;
	private String firstName;
	private String lastName;
	private String title;
	private String mobNo;
	private String email;
	private String gender;
	private String dob;
	private String town;
	private String country;
	private String address;
	private String sourceOfIntro;
	private String reference;
	private String postCode;
	
	//Third Party attribute
	
	private String type;
	private String typeName;
	private String thirdPartyType;
	private String thirdPartyTypeName;
	private String thirdPartyCompanyName;
	//21st march
	private String occupation;
	private String expiryDate;
	private String defaultNotes;
	private String accountsNotes;
	private String criticalInfo;
	
	//28th march
	private String whopay;
	private String policyAuthorzCode;
	private String policyNo;
	private ArrayList<Client> otherOption ;
	
	private String knownAs;
	private String county;
	private String homeNo;
	private String workNo;
	private String emailCc;
	private String prefContactMode;
	private String emergencyContName;
	private String emergencyContNo;
	private String patientType;
	
	
	
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getDefaultNotes() {
		return defaultNotes;
	}
	public void setDefaultNotes(String defaultNotes) {
		this.defaultNotes = defaultNotes;
	}
	public String getAccountsNotes() {
		return accountsNotes;
	}
	public void setAccountsNotes(String accountsNotes) {
		this.accountsNotes = accountsNotes;
	}
	public String getCriticalInfo() {
		return criticalInfo;
	}
	public void setCriticalInfo(String criticalInfo) {
		this.criticalInfo = criticalInfo;
	}
	public String getThirdPartyType() {
		return thirdPartyType;
	}
	public void setThirdPartyType(String thirdPartyType) {
		this.thirdPartyType = thirdPartyType;
	}
	public String getThirdPartyTypeName() {
		return thirdPartyTypeName;
	}
	public void setThirdPartyTypeName(String thirdPartyTypeName) {
		this.thirdPartyTypeName = thirdPartyTypeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSourceOfIntro() {
		return sourceOfIntro;
	}
	public void setSourceOfIntro(String sourceOfIntro) {
		this.sourceOfIntro = sourceOfIntro;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getThirdPartyCompanyName() {
		return thirdPartyCompanyName;
	}
	public void setThirdPartyCompanyName(String thirdPartyCompanyName) {
		this.thirdPartyCompanyName = thirdPartyCompanyName;
	}
	public String getPolicyAuthorzCode() {
		return policyAuthorzCode;
	}
	public void setPolicyAuthorzCode(String policyAuthorzCode) {
		this.policyAuthorzCode = policyAuthorzCode;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getWhopay() {
		return whopay;
	}
	public void setWhopay(String whopay) {
		this.whopay = whopay;
	}
	public ArrayList<Client> getOtherOption() {
		return otherOption;
	}
	public void setOtherOption(ArrayList<Client> otherOption) {
		this.otherOption = otherOption;
	}
	public String getKnownAs() {
		return knownAs;
	}
	public void setKnownAs(String knownAs) {
		this.knownAs = knownAs;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getEmailCc() {
		return emailCc;
	}
	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}
	public String getPrefContactMode() {
		return prefContactMode;
	}
	public void setPrefContactMode(String prefContactMode) {
		this.prefContactMode = prefContactMode;
	}
	public String getEmergencyContName() {
		return emergencyContName;
	}
	public void setEmergencyContName(String emergencyContName) {
		this.emergencyContName = emergencyContName;
	}
	public String getEmergencyContNo() {
		return emergencyContNo;
	}
	public void setEmergencyContNo(String emergencyContNo) {
		this.emergencyContNo = emergencyContNo;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	
	
	
	
}