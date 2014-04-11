package com.apm.Appointment.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Appointment.eu.bi.AppointmentDAO;
import com.apm.Appointment.eu.entity.Appointment;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;


public class JDBCAppointmentDAO extends JDBCBaseDAO implements AppointmentDAO{
	
	public JDBCAppointmentDAO(Connection connection){
		this.connection = connection;
		
	}

	
	public int saveAppointment(Appointment appointment) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into appointment(practitionerid,appt_type,patient_type,title,firstname,lastname,phone,phone_type,dob,email,remainder_type,whendate,fromtime,totime,repeat_type,repeveryweek,appttocreate,notes) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, appointment.getPractitioner());
			preparedStatement.setString(2, appointment.getAppointmentType());
			preparedStatement.setString(3, appointment.getPatientType());
			preparedStatement.setString(4, appointment.getTitle());
			preparedStatement.setString(5, appointment.getFirstName());
			preparedStatement.setString(6, appointment.getLastName());
			preparedStatement.setString(7, appointment.getContactNo());
			preparedStatement.setString(8, appointment.getComDevice());
			preparedStatement.setString(9, appointment.getDob());
			preparedStatement.setString(10, appointment.getEmail());
			preparedStatement.setString(11, appointment.getAutoremaindertype());;
			preparedStatement.setString(12, appointment.getWhen());
			preparedStatement.setString(13, appointment.getHour() + ":" + appointment.getMinute());
			preparedStatement.setString(14, appointment.getTohour() + ":" + appointment.getTominute());
			preparedStatement.setString(15, appointment.getRepeat());
			preparedStatement.setString(16, appointment.getRevery());
			preparedStatement.setString(17, appointment.getHappointment());
			preparedStatement.setString(18, appointment.getNotes());
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	public ArrayList<Appointment> getPractitionerList(int clinicId) {
		PreparedStatement preparedStatement = null;
		ArrayList<Appointment>list = new ArrayList<Appointment>();
		String sql = "SELECT id,firstname,lastname FROM apm.apm_user where clinicid= "+clinicId+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Appointment appointment = new Appointment();
				appointment.setPractitionerID(rs.getInt(1));
				appointment.setPractitionerName(rs.getString(2) + " " + rs.getString(2));
				
				list.add(appointment);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public ArrayList<Location> getLocationList(int practitionerid) {
		PreparedStatement preparedStatement = null;
		ArrayList<Location>list = new ArrayList<Location>();
		String sql = "SELECT location FROM apm_apmt_slot where diaryuserid="+practitionerid+" group by location ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Location location = new Location();
				location.setLocation(rs.getString(1));
				
				list.add(location);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public ArrayList<AppointmentType> getAppointmentTypeList(int practitionerid) {
		PreparedStatement preparedStatement = null;
		ArrayList<AppointmentType>list = new ArrayList<AppointmentType>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT apm_appointment_type.id,name,duration FROM apm_appointment_type_user ");
		sql.append("inner join apm_appointment_type on apm_appointment_type_user.appintmenttypeid = apm_appointment_type.id ");
		sql.append("and apm_appointment_type_user.practitionerid = "+practitionerid+" ");
		
		try{
			preparedStatement = connection.prepareStatement(sql.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				AppointmentType appointmentType = new AppointmentType();
				appointmentType.setId(rs.getInt(1));
				appointmentType.setName(rs.getString(2));
				appointmentType.setDuration(rs.getString(3));
				
				list.add(appointmentType);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	public ArrayList<Appointment> getApptAvailiability(int practitionerid, String date) {
		PreparedStatement preparedStatement = null;
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		String sql = "SELECT starttime,endtime,location FROM apm_apmt_slot where diaryuserid=? and commencing = ? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, practitionerid);
			preparedStatement.setString(2,date);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Appointment appointment = new Appointment();
				appointment.setStarttime(rs.getString(1));
				appointment.setEdndtime(rs.getString(2));
				appointment.setLocation(rs.getString(3));
				
				list.add(appointment);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public String getStartTime(int practitionerid, String location, String date) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT starttime FROM apm_apmt_slot where diaryuserid=? and location=? and commencing=? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, practitionerid);
			preparedStatement.setString(2, location);
			preparedStatement.setString(3, date);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
