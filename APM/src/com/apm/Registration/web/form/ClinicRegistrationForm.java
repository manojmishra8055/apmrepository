package com.apm.Registration.web.form;

import java.util.ArrayList;
import java.util.Collection;

import com.apm.Registration.eu.entity.Location;
import com.apm.Registration.eu.entity.Clinic;


public class ClinicRegistrationForm {
	
	ArrayList<Clinic>clinicList;
	ArrayList<Clinic>cliniclocationList;
	ArrayList<Clinic>colorList;
	public ArrayList<Clinic> getColorList() {
		return colorList;
	}

	public void setColorList(ArrayList<Clinic> colorList) {
		this.colorList = colorList;
	}

	public ArrayList<Clinic> getCliniclocationList() {
		return cliniclocationList;
	}

	public void setCliniclocationList(ArrayList<Clinic> cliniclocationList) {
		this.cliniclocationList = cliniclocationList;
	}

	public ArrayList<Clinic> getClinicList() {
		return clinicList;
	}

	public void setClinicList(
			ArrayList<Clinic> clinicList) {
		this.clinicList = clinicList;
	}
	
	
	private int id;
	
	
	private String uuserType;
	
	private String firstname;
	
	private String lastname;
	
	private String userId;
	
	private String password;
	
	private String confirmPassword;
	
	private String[] pkgsubscription; 
	
	private String[] funSubscription;
	
	private boolean isactive;
	
	private boolean standalone;
	
	private boolean hostedDB;
	
	private boolean onlineSingleDevice;
	
	private boolean onlineMultiDevice;
	
	private boolean DiaryManagement;
	
	private boolean AppointmentBooking;
	
	private boolean BasicFinance;
	
	private boolean fullFinance;
	
	private boolean medicalRecord;
	
	private boolean clinicResourceMngment;
	
	private boolean clinicPayrollMngment;
	
	
	private String searchText = "";
	
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
	
	private String colorName;
	
	private String locationname;
	
	private Collection<Location> location;
	
	
	public String[] getFunSubscription() {
		return funSubscription;
	}

	public void setFunSubscription(String[] funSubscription) {
		this.funSubscription = funSubscription;
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

	public String[] getPkgsubscription() {
		return pkgsubscription;
	}

	public void setPkgsubscription(String[] pkgsubscription) {
		this.pkgsubscription = pkgsubscription;
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

	public Collection<Location> getLocation() {
		return location;
	}

	public void setLocation(Collection<Location> location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public boolean isStandalone() {
		return standalone;
	}

	public void setStandalone(boolean standalone) {
		this.standalone = standalone;
	}

	public boolean isHostedDB() {
		return hostedDB;
	}

	public void setHostedDB(boolean hostedDB) {
		this.hostedDB = hostedDB;
	}

	public boolean isOnlineSingleDevice() {
		return onlineSingleDevice;
	}

	public void setOnlineSingleDevice(boolean onlineSingleDevice) {
		this.onlineSingleDevice = onlineSingleDevice;
	}

	public boolean isOnlineMultiDevice() {
		return onlineMultiDevice;
	}

	public void setOnlineMultiDevice(boolean onlineMultiDevice) {
		this.onlineMultiDevice = onlineMultiDevice;
	}

	public boolean isDiaryManagement() {
		return DiaryManagement;
	}

	public void setDiaryManagement(boolean diaryManagement) {
		DiaryManagement = diaryManagement;
	}

	public boolean isAppointmentBooking() {
		return AppointmentBooking;
	}

	public void setAppointmentBooking(boolean appointmentBooking) {
		AppointmentBooking = appointmentBooking;
	}

	public boolean isBasicFinance() {
		return BasicFinance;
	}

	public void setBasicFinance(boolean basicFinance) {
		BasicFinance = basicFinance;
	}

	public boolean isFullFinance() {
		return fullFinance;
	}

	public void setFullFinance(boolean fullFinance) {
		this.fullFinance = fullFinance;
	}

	public boolean isMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(boolean medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public boolean isClinicResourceMngment() {
		return clinicResourceMngment;
	}

	public void setClinicResourceMngment(boolean clinicResourceMngment) {
		this.clinicResourceMngment = clinicResourceMngment;
	}

	public boolean isClinicPayrollMngment() {
		return clinicPayrollMngment;
	}

	public void setClinicPayrollMngment(boolean clinicPayrollMngment) {
		this.clinicPayrollMngment = clinicPayrollMngment;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getUuserType() {
		return uuserType;
	}

	public void setUuserType(String uuserType) {
		this.uuserType = uuserType;
	}


	
	
	
	

}
