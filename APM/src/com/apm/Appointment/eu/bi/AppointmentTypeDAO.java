package com.apm.Appointment.eu.bi;

import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.common.utils.Pagination;

public interface AppointmentTypeDAO {

	ArrayList<AppointmentType> getAppointmentTypeList(Pagination pagination);

	ArrayList<AppointmentType> getColorList();

	int saveAppointmentType(AppointmentType appointmentType);

	AppointmentType getAppointment(int id);

	int updateAppointmentType(AppointmentType appointmentType, int id);

	int deleteAppoitmentType(int id, AppointmentType appointmentType);

	int getTotalApmtTypeCount();

}
