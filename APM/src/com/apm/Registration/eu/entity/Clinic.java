package com.apm.Registration.eu.entity;

import java.util.ArrayList;

public class Clinic {
	
	ArrayList<Clinic>clinicList;
	ArrayList<Clinic>cliniclocationList;
	
	public ArrayList<Clinic> getClinicList() {
		return clinicList;
	}

	
	public ArrayList<Clinic> getCliniclocationList() {
		return cliniclocationList;
	}

	public void setCliniclocationList(
			ArrayList<Clinic> cliniclocationList) {
		this.cliniclocationList = cliniclocationList;
	}

	public void setClinicList(
			ArrayList<Clinic> clinicList) {
		this.clinicList = clinicList;
	}
	
	private int id;
	
	private String userId;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String uuserType;
	
	private int userType;
	
	private String adminAccessPssword;
	
	private String confirmPassword;
	
//package subscription
	
	private boolean isStandalone = false;
	
	private boolean isHostedDB = false;
	
	private boolean isOnlineSingleDevice = false;
	
	private boolean isOnlineMultiDevice = false;
	
	
	
//functionality subscription
	
	private boolean isDiaryManagement = false;
	
	private boolean isAppointmentBooking = false;
	
	private boolean isBasicFinance = false;
	
	private boolean isFullFinance = false;
	
	private boolean isMedicalRecord = false;
	
	private boolean isClinicPayrollMngment = false;
	
	private boolean isClinicResourceMngment = false;
	
	private String clinicName;
	
	private String clinicOwner;
	
	private String email;
	
	private String mobileNo;
	
	private String landLine;
	
	private String country;
	
	private String city;
	
	private String address;
	
	private String pinCode;
	
	private int locationid;
	
	private String locationname;
	
	private String colorName;
	
	private String searchText = "";
	
	public String getLocationname() {
		return locationname;
	}


	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}


	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	

	public boolean isStandalone() {
		return isStandalone;
	}

	public void setStandalone(boolean isStandalone) {
		this.isStandalone = isStandalone;
	}
	
	

	public boolean isHostedDB() {
		return isHostedDB;
	}

	public void setHostedDB(boolean isHostedDB) {
		this.isHostedDB = isHostedDB;
	}

	public boolean isOnlineSingleDevice() {
		return isOnlineSingleDevice;
	}

	public void setOnlineSingleDevice(boolean isOnlineSingleDevice) {
		this.isOnlineSingleDevice = isOnlineSingleDevice;
	}

	public boolean isOnlineMultiDevice() {
		return isOnlineMultiDevice;
	}

	public void setOnlineMultiDevice(boolean isOnlineMultiDevice) {
		this.isOnlineMultiDevice = isOnlineMultiDevice;
	}

	public boolean isDiaryManagement() {
		return isDiaryManagement;
	}

	public void setDiaryManagement(boolean isDiaryManagement) {
		this.isDiaryManagement = isDiaryManagement;
	}

	public boolean isAppointmentBooking() {
		return isAppointmentBooking;
	}

	public void setAppointmentBooking(boolean isAppointmentBooking) {
		this.isAppointmentBooking = isAppointmentBooking;
	}

	public boolean isBasicFinance() {
		return isBasicFinance;
	}

	public void setBasicFinance(boolean isBasicFinance) {
		this.isBasicFinance = isBasicFinance;
	}

	public boolean isFullFinance() {
		return isFullFinance;
	}

	public void setFullFinance(boolean isFullFinance) {
		this.isFullFinance = isFullFinance;
	}

	public boolean isMedicalRecord() {
		return isMedicalRecord;
	}

	public void setMedicalRecord(boolean isMedicalRecord) {
		this.isMedicalRecord = isMedicalRecord;
	}

	public void setClinicPayrollMngment(boolean isClinicPayrollMngment) {
		this.isClinicPayrollMngment = isClinicPayrollMngment;
	}

	public void setClinicResourceMngment(boolean isClinicResourceMngment) {
		this.isClinicResourceMngment = isClinicResourceMngment;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicOwner() {
		return clinicOwner;
	}

	public void setClinicOwner(String clinicOwner) {
		this.clinicOwner = clinicOwner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getCountry() {
		return country;
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

	
	public boolean isClinicPayrollMngment() {
		return isClinicPayrollMngment;
	}

	public boolean isClinicResourceMngment() {
		return isClinicResourceMngment;
	}

	public String getAdminAccessPssword() {
		return adminAccessPssword;
	}

	public void setAdminAccessPssword(String adminAccessPssword) {
		this.adminAccessPssword = adminAccessPssword;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	public String getUuserType() {
		return uuserType;
	}


	public void setUuserType(String uuserType) {
		this.uuserType = uuserType;
	}


}
