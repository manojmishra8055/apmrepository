package com.apm.Appointment.eu.bi;

import java.util.ArrayList;

import com.apm.Appointment.eu.entity.Appointment;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.Registration.eu.entity.Location;

public interface AppointmentDAO {

	int saveAppointment(Appointment appointment);

	ArrayList<Appointment> getPractitionerList(int clinicId);

	ArrayList<Location> getLocationList(int practitionerid);

	ArrayList<AppointmentType> getAppointmentTypeList(int practitionerid);

	ArrayList<Appointment> getApptAvailiability(int practitionerid, String date);

	String getStartTime(int practitionerid, String location, String date);

}
