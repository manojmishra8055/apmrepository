package com.apm.DiaryManagement.eu.bi;

import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.Registration.eu.entity.Location;

public interface NotAvailableSlotDAO {
	
	
	
	ArrayList<DiaryManagement> getUserList(int clinicid,String commencing);
	ArrayList<Location> getLocationList(int id);
	ArrayList<NotAvailableSlot> getList(int id, String date);
	ArrayList<DiaryManagement> getUserList(int id);
	int saveAppointment(NotAvailableSlot notAvailableSlot);
	int saveBlockSlot(NotAvailableSlot notAvailableSlot);
	ArrayList<AppointmentType> getAppointmentTypeList();
	int updateAppointment(NotAvailableSlot notAvailableSlot,int selectedid);
	int updateBlockSlot(NotAvailableSlot notAvailableSlot, int selectedid);
	int updateClientHasArrived(int selectedid, int status);
	int updateClientIsBeingSeen(int selectedid, int status);
	int updateResetNotArrived(int selectedid, int status);
	int updateDNA(int selectedid, String notes, boolean dna,
			String dnaReason);
	int saveCharge(NotAvailableSlot notAvailableSlot, String apmtType, int result);
	int updateCharge(NotAvailableSlot notAvailableSlot, String apmtType,
			int selectedid);
	
	ArrayList<NotAvailableSlot> getPrintDataOfWeek(String practionerId,
			String fromDate, String toDate);
	ArrayList<NotAvailableSlot> getPractitionerPrintData(String practionerId,
			String date);
	ArrayList<NotAvailableSlot> getAllPractitionerPrintData(String date);
}
