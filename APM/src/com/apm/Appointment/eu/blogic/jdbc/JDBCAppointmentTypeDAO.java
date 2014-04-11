package com.apm.Appointment.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Appointment.eu.bi.AppointmentDAO;
import com.apm.Appointment.eu.bi.AppointmentTypeDAO;
import com.apm.Appointment.eu.entity.Appointment;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Pagination;

public class JDBCAppointmentTypeDAO extends JDBCBaseDAO implements AppointmentTypeDAO{
	
	public JDBCAppointmentTypeDAO(Connection connection){
		this.connection = connection;
		
	}

	public ArrayList<AppointmentType> getAppointmentTypeList(Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<AppointmentType>list = new ArrayList<AppointmentType>();
		String sql = "SELECT id,name,description,category,duration,colorcode,charges FROM apm_appointment_type";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				AppointmentType appointmentType = new AppointmentType();
				
				appointmentType.setId(rs.getInt(1));
				appointmentType.setName(rs.getString(2));
				appointmentType.setDescription(rs.getString(3));
				appointmentType.setCategory(rs.getString(4));
				appointmentType.setDuration(rs.getString(5));
				appointmentType.setColor(rs.getString(6));
				appointmentType.setCharges(rs.getString(7));
				
				list.add(appointmentType);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<AppointmentType> getColorList() {
		PreparedStatement preparedStatement = null;
		ArrayList<AppointmentType>list = new ArrayList<AppointmentType>();
		String sql = "SELECT id,color FROM color  ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				AppointmentType appointmentType = new AppointmentType();
				
				appointmentType.setId(rs.getInt(1));
				appointmentType.setColor(rs.getString(2));
				
				list.add(appointmentType);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int saveAppointmentType(AppointmentType appointmentType) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_appointment_type(name,description,category,duration,colorcode,charges) values(?,?,?,?,?,?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, appointmentType.getName());
			preparedStatement.setString(2, appointmentType.getDescription());
			preparedStatement.setString(3, appointmentType.getCategory());
			preparedStatement.setString(4, appointmentType.getDuration());
			preparedStatement.setString(5, "#"+appointmentType.getColor());
			preparedStatement.setString(6, appointmentType.getCharges());
			
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public AppointmentType getAppointment(int id) {
		PreparedStatement preparedStatement = null;
		AppointmentType appointmentType = new AppointmentType();
		String sql = "SELECT id,name,description,category,duration,colorcode,charges FROM apm_appointment_type where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				
				appointmentType.setId(rs.getInt(1));
				appointmentType.setName(rs.getString(2));
				appointmentType.setDescription(rs.getString(3));
				appointmentType.setCategory(rs.getString(4));
				appointmentType.setDuration(rs.getString(5));
				appointmentType.setColor(rs.getString(6));
				appointmentType.setCharges(rs.getString(7));
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentType;
	}

	public int updateAppointmentType(AppointmentType appointmentType,int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_appointment_type set name = ?,description = ?,category = ?,duration = ?,colorcode = ?,charges = ? where id = "+id+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, appointmentType.getName());
			preparedStatement.setString(2, appointmentType.getDescription());
			preparedStatement.setString(3, appointmentType.getCategory());
			preparedStatement.setString(4, appointmentType.getDuration());
			preparedStatement.setString(5, "#"+appointmentType.getColor());
			preparedStatement.setString(6, appointmentType.getCharges());
			
			
			result = preparedStatement.executeUpdate();
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int deleteAppoitmentType(int id, AppointmentType appointmentType) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_appointment_type where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public int getTotalApmtTypeCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from apm_appointment_type";
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
