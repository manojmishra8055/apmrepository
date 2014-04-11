package com.apm.DiaryManagement.eu.bi;

import java.sql.Connection;
import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;

public interface CompleteAptmDAO {

	AppointmentType getAptmTypeCharge(String apmtType, AppointmentType appointmentType);

	int saveCharge(CompleteAppointment completeAppointment);

	ArrayList<CompleteAppointment> getPatientChrageDetails(String id,String date);

	CompleteAppointment getPatientDetails(String id,
			CompleteAppointment completeAppointment,String date);

	int deleteComplteApmt();

	ArrayList<CompleteAppointment> getAssesmentList(String payBuy);

	CompleteAppointment getInsuranceCompanyName(String clientId);

	int saveAmpmInvoice(CompleteAppointment completeAppointment);

	ArrayList<CompleteAppointment> getAssesmentList(String payBuy,
			String totalassesment);

	int saveInvoiceAssesment(CompleteAppointment completeAppointment,
			int invoice);

	ThirdParty getThirdParty(String clientId, ThirdParty thirdParty);

	int deleteCash(int id, CompleteAppointment completeAppointment);
}