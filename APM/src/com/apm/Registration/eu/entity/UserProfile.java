package com.apm.Registration.eu.entity;

import java.util.ArrayList;

public class UserProfile {

	private int id;
	
	private int userType;
	
	private int changefre;

	private String userid;
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}


	private String password;
	
	private boolean usercheck;
	
	private boolean appointmentdiary;
	
	private int compressionrate;
	
	private boolean isavailableonline;
	
	private boolean loginsystem;
	
	private boolean apmremote;
	
	private boolean onlinebooking;
	
	private String lastchanged;
	
	private String fullname;
	
	private String firstname;
	
	public String getLastchanged() {
		return lastchanged;
	}
	public void setLastchanged(String lastchanged) {
		this.lastchanged = lastchanged;
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
	
	
	private String lastname;
	
	private String diarycolor;
	
	private String diarycolumnposition;
	
	private String initial;
	
	private String jobtitle;
	
	private String discription;
	
	private String appointmentbookingcontem;
	
	public int getChangefre() {
		return changefre;
	}
	public void setChangefre(int changefre) {
		this.changefre = changefre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoginsystem() {
		return loginsystem;
	}
	public void setLoginsystem(boolean loginsystem) {
		this.loginsystem = loginsystem;
	}
	public boolean isApmremote() {
		return apmremote;
	}
	public void setApmremote(boolean apmremote) {
		this.apmremote = apmremote;
	}
	public boolean isOnlinebooking() {
		return onlinebooking;
	}
	public void setOnlinebooking(boolean onlinebooking) {
		this.onlinebooking = onlinebooking;
	}
	public String getAppointmentbookingcontem() {
		return appointmentbookingcontem;
	}
	public void setAppointmentbookingcontem(String appointmentbookingcontem) {
		this.appointmentbookingcontem = appointmentbookingcontem;
	}
	public String getAppointmentbookingdnatem() {
		return appointmentbookingdnatem;
	}
	public void setAppointmentbookingdnatem(String appointmentbookingdnatem) {
		this.appointmentbookingdnatem = appointmentbookingdnatem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	private String appointmentbookingdnatem;
	
	private String email;
	
	private String mobile;
	
	private String registerno;
	
	private String usergroup;	
	
	private String onlinename;
	
	private String diciplineName;
		
	public String getDiciplineName() {
		return diciplineName;
	}
	public void setDiciplineName(String diciplineName) {
		this.diciplineName = diciplineName;
	}
	public ArrayList<String> getDiciplineList() {
		return diciplineList;
	}
	public void setDiciplineList(ArrayList<String> diciplineList) {
		this.diciplineList = diciplineList;
	}
	private ArrayList<String>diciplineList;
	
	private ArrayList<String>diarycolorList;
	
	private ArrayList<String>abctList;
	
	private ArrayList<String>adtList;
		
	
	public int getId() {
		return id;
	}
	public ArrayList<String> getDiarycolorList() {
		return diarycolorList;
	}
	public void setDiarycolorList(ArrayList<String> diarycolorList) {
		this.diarycolorList = diarycolorList;
	}
	public void setId(int id) {
		this.id = id;
	}
	
		
		
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isUsercheck() {
		return usercheck;
	}
	public void setUsercheck(boolean usercheck) {
		this.usercheck = usercheck;
	}
	public int getCompressionrate()
	{
		return compressionrate;
	}
	
	public void setCompressionrate(int compressionrate)
	{
		this.compressionrate=compressionrate;		
	}
	
	public 	String getFullname()
	{
		return fullname;
	}
	
	public void setFullname(String fullname)
	{
		this.fullname=fullname;		
	}
	
	public 	String getDiarycolor()
	{
		return diarycolor;
	}
	
	public void setDiarycolor(String diarycolor)
	{
		this.diarycolor=diarycolor;		
	}
	
	public String getDiarycolumnposition()
	{
		return diarycolumnposition;
	}
	
	public void setDiarycolumnposition(String diarycolumnposition)
	{
		this.diarycolumnposition=diarycolumnposition;		
	}
	
	public String getInitial()
	{
		return initial;
	}
	
	public void setInitial(String initial)
	{
		this.initial=initial;
	}
	
	public String getJobtitle()
	{
		return jobtitle;
	}
	
	public void setJobtitle(String jobtitle)
	{
		this.jobtitle=jobtitle;
	}
	
	public String getDiscription()
	{
		return discription;
	}
	
	public void setDiscription(String discription)
	{
		this.discription=discription;
	}
	
	public String getRegisterno()
	{
		return registerno;
	}
	
	public void setRegisterno(String registerno)
	{
		this.registerno=registerno;
	}
	
	public String getUsergroup()
	{
		return usergroup;
	}
	
	public void setUsergroup(String usergroup)
	{
		this.usergroup=usergroup;
	}
	
	public String getOnlinename() {
		return onlinename;
	}

	public void setOnlinename(String onlinename) {
		this.onlinename = onlinename;
	}
	public boolean isAppointmentdiary() {
		return appointmentdiary;
	}
	public void setAppointmentdiary(boolean appointmentdiary) {
		this.appointmentdiary = appointmentdiary;
	}
	public boolean isIsavailableonline() {
		return isavailableonline;
	}
	public void setIsavailableonline(boolean isavailableonline) {
		this.isavailableonline = isavailableonline;
	}
	public ArrayList<String> getAbctList() {
		return abctList;
	}
	public void setAbctList(ArrayList<String> abctList) {
		this.abctList = abctList;
	}
	public ArrayList<String> getAdtList() {
		return adtList;
	}
	public void setAdtList(ArrayList<String> adtList) {
		this.adtList = adtList;
	}
	
		
}
