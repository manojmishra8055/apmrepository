package com.apm.DiaryManagement.eu.bi;

import java.util.ArrayList;

import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.Registration.eu.entity.Location;

public interface DiaryManagementDAO {

	int saveAppointmentSlot(DiaryManagement diaryManagement);

	ArrayList<DiaryManagement> getPractionerList(int year,int clinicid);

	ArrayList<Location> getLocationList(int id);

	

	String getWeekList(String tdCode, int year);

	ArrayList<DiaryManagement> getAppointmentSlotData(String diaryuserid,int clinicUserid,String tdcode,String year);

	int updateAppointment(int selectedid,DiaryManagement diaryManagement);

	int deleteAppointmentSlot(int selectedid);

	boolean checkUsertdCodeExist(String usertdcode,String year);

	int deleteAppointSlotByTdcode(String usertdcode,String year);

	int deleteAppointSlotByTdcode(String tdCode, String string, String location);

	ArrayList<DiaryManagement> getAppointmentSlotData(int id, String date,
			String year1);

	ArrayList<DiaryManagement> getAppointmentSlotData2(String diaryuserid,
			int id, String date, String string);

	ArrayList<DiaryManagement> getAppointmentSlotData3(int id, String date,
			String year1);

	ArrayList<DiaryManagement> getAllDiaryUserAppointmentSlotData(
			String diaryuserid, int id, String commencing);

	ArrayList<NotAvailableSlot> getApmtList(String diaryuserid,String practitionerid);

	boolean checkPractitionerAvailibility(String commencing, String diaryuserid);

	

	

	

}
