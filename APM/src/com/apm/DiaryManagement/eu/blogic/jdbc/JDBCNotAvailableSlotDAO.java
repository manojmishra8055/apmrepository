package com.apm.DiaryManagement.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.bi.NotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;

public class JDBCNotAvailableSlotDAO extends JDBCBaseDAO implements NotAvailableSlotDAO {
	
public JDBCNotAvailableSlotDAO(Connection connection){
		
		this.connection = connection;
	}
	



	
	public ArrayList<DiaryManagement> getUserList(int clinicid,String commencing) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT apm_apmt_slot.id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,apm_apmt_slot.onlinebooking,apm_apmt_slot.diaryuser FROM apm_apmt_slot ");
		sql.append("inner join apm_user on apm_apmt_slot.diaryuserid = apm_user.id and apm_user.clinicid = ? and apm_apmt_slot.commencing=? order by apm_user.id");
		
		
		try{
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt(1, clinicid);
			preparedStatement.setString(2, commencing);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setSTime(rs.getString(2));
				diaryManagement.setEndTime(rs.getString(3));
				diaryManagement.setApmtDuration(rs.getString(4));
				diaryManagement.setLocation(rs.getString(5));
				String locationColor = getLocationColor(diaryManagement.getLocation(), clinicid);
				diaryManagement.setLocationColor(locationColor);
				diaryManagement.setTdCode(rs.getString(6));
				diaryManagement.setWeekName(rs.getString(7));
				diaryManagement.setCommencing(rs.getString(8));
				diaryManagement.setWeekFullName(rs.getString(9));
				diaryManagement.setOnlineBooking(rs.getBoolean(10));
				diaryManagement.setDiaryUser(rs.getString(11));
		
				
				list.add(diaryManagement);
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public ArrayList<Location> getLocationList(int id) {
		PreparedStatement preparedStatement = null;
		ArrayList<Location>list = new ArrayList<Location>();
		String sql = "select country,city,address,postcode,location,color from apm_clinic_location where userid= "+id+" ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Location location = new Location();
				location.setCountry(rs.getString(1));
				location.setCity(rs.getString(2));
				location.setAddress(rs.getString(3));
				location.setPinCode(rs.getString(4));
				location.setLocation(rs.getString(5));
				location.setColorName(rs.getString(6));
				
				list.add(location);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<NotAvailableSlot> getList(int id,String date) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		
		
		
		String sql = "SELECT id,starttime,endtime,apmtduration,location,commencing FROM apm_apmt_slot where diaryuserid = "+id+" and commencing = '"+date+"' ";
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notavailableslot = new NotAvailableSlot();
				notavailableslot.setId(rs.getInt(1));
				notavailableslot.setSTime(rs.getString(2));
				notavailableslot.setEndTime(rs.getString(3));
				notavailableslot.setApmtDuration(rs.getString(4));
				notavailableslot.setLocation(rs.getString(5));
				String locationColor = getLocationColor(notavailableslot.getLocation(), id);
				notavailableslot.setLocationColor(locationColor);
				notavailableslot.setCommencing(rs.getString(6));
				
				
				list.add(notavailableslot);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
		
		
	}

	private String getLocationColor(String location, int id) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT color FROM apm_clinic_location where  userid = "+id+" and location = '"+location+"' ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public ArrayList<DiaryManagement> getUserList(int id) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "select id,firstname,lastname from apm_user where clinicid = "+id+" ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setDiaryUser(rs.getString(2) + " " + rs.getString(3));
				
				list.add(diaryManagement);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}





	public int saveAppointment(NotAvailableSlot notAvailableSlot) {
		int result = 0;
		int id = 0;
		PreparedStatement pstm = null;
		String sql = "insert into apm_available_slot(apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,dept,location,room,clientname,aptmtype,duration,clientId,charge,treatmentEpisodeId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, notAvailableSlot.getApmtSlotId());
			pstm.setString(2,notAvailableSlot.getCommencing());
			pstm.setString(3, notAvailableSlot.getSTime());
			pstm.setString(4, notAvailableSlot.getEndTime());
			pstm.setString(5, notAvailableSlot.getNotes());
			pstm.setInt(6, notAvailableSlot.getDiaryUserId());
			pstm.setString(7, notAvailableSlot.getDiaryUser());
			pstm.setString(8, notAvailableSlot.getDept());
			pstm.setString(9, notAvailableSlot.getLocation());
			pstm.setString(10, notAvailableSlot.getRoom());
			pstm.setString(11, notAvailableSlot.getClient());
			pstm.setString(12, notAvailableSlot.getApmtType());
			pstm.setString(13, notAvailableSlot.getApmtDuration());
			pstm.setString(14, notAvailableSlot.getClientId());
			double charge = getCharge(notAvailableSlot.getApmtType());
			pstm.setDouble(15, charge);
			pstm.setString(16, notAvailableSlot.getTreatmentEpisodeId());
			result = pstm.executeUpdate();
			
			if(result == 1){
				ResultSet resultSet = pstm.getGeneratedKeys();
				if(resultSet.next()){
					id = resultSet.getInt(1);  
				}
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return id;
	}


	



	public ArrayList<NotAvailableSlot> getNewAppointmentData(String diaryuserId, String commencing) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		String sql = "SELECT id,apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,dept,location,room,clientname,aptmtype from apm_available_slot where diaryuserid = "+diaryuserId+" and commencing = "+commencing+" ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
				notAvailableSlot.setId(rs.getInt(1));
				notAvailableSlot.setApmtSlotId(rs.getInt(2));
				notAvailableSlot.setCommencing(rs.getString(3));
				notAvailableSlot.setSTime(rs.getString(4));
				notAvailableSlot.setEndTime(rs.getString(5));
				notAvailableSlot.setNotes(rs.getString(6));
				notAvailableSlot.setDiaryUserId(rs.getInt(7));
				notAvailableSlot.setDept(rs.getString(8));
				notAvailableSlot.setLocation(rs.getString(9));
				notAvailableSlot.setRoom(rs.getString(10));
				notAvailableSlot.setClient(rs.getString(11));
				notAvailableSlot.setApmtType(rs.getString(12));
				
				
				
				
				list.add(notAvailableSlot);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	public int saveBlockSlot(NotAvailableSlot notAvailableSlot) {
		int result = 0;
		
		PreparedStatement pstm = null;
		String sql = "insert into apm_available_slot(apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,location,room,reasonforblock,status,duration) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, notAvailableSlot.getApmtSlotId());
			pstm.setString(2,notAvailableSlot.getCommencing());
			pstm.setString(3, notAvailableSlot.getSTime());
			pstm.setString(4, notAvailableSlot.getEndTime());
			pstm.setString(5, notAvailableSlot.getNotes());
			pstm.setInt(6, notAvailableSlot.getDiaryUserId());
			pstm.setString(7, notAvailableSlot.getDiaryUser());
			pstm.setString(8, notAvailableSlot.getLocation());
			pstm.setString(9, notAvailableSlot.getRoom());
			pstm.setString(10, notAvailableSlot.getReasonforblock());
			pstm.setString(11, notAvailableSlot.getStatus());
			pstm.setString(12, notAvailableSlot.getApmtDuration());
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}





	public ArrayList<AppointmentType> getAppointmentTypeList() {
		PreparedStatement preparedStatement = null;
		ArrayList<AppointmentType>list = new ArrayList<AppointmentType>();
		String sql = "SELECT duration,name FROM apm_appointment_type ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				AppointmentType appointmentType = new AppointmentType();
				appointmentType.setDuration(rs.getString(1));
				appointmentType.setName(rs.getString(2));
				list.add(appointmentType);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	public int updateAppointment(NotAvailableSlot notAvailableSlot,int selectedid) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "update apm_available_slot set starttime=?,endtime=?,duration=?,notes=?,clientname=?,aptmtype=?,clientId=?,treatmentEpisodeId=? where id = "+selectedid+" ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, notAvailableSlot.getSTime());
			preparedStatement.setString(2, notAvailableSlot.getEndTime());
			preparedStatement.setString(3, notAvailableSlot.getApmtDuration());
			preparedStatement.setString(4, notAvailableSlot.getNotes());
			preparedStatement.setString(5, notAvailableSlot.getClient());
			preparedStatement.setString(6, notAvailableSlot.getApmtType());
			preparedStatement.setString(7, notAvailableSlot.getClientId());
			preparedStatement.setString(8, notAvailableSlot.getTreatmentEpisodeId());
			
			
			result = preparedStatement.executeUpdate();
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}





	public int updateBlockSlot(NotAvailableSlot notAvailableSlot, int selectedid) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_available_slot set starttime=?,endtime=?,duration=?,notes=?,reasonforblock=? where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, notAvailableSlot.getSTime());
			preparedStatement.setString(2, notAvailableSlot.getEndTime());
			preparedStatement.setString(3, notAvailableSlot.getApmtDuration());
			preparedStatement.setString(4, notAvailableSlot.getNotes());
			preparedStatement.setString(5, notAvailableSlot.getReasonforblock());
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





	public int updateClientHasArrived(int selectedid, int status) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_available_slot set arrivedstatus ="+status+" where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





	public int updateClientIsBeingSeen(int selectedid, int status) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_available_slot set arrivedstatus ="+status+" where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
		
	}





	public int updateResetNotArrived(int selectedid, int status) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_available_slot set arrivedstatus ="+status+" where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
		
	}





	public int updateDNA(int selectedid, String notes, boolean dna,
			String dnaReason) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_available_slot set  notes=?,dna=?,dnaReason=? where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, notes);
			preparedStatement.setBoolean(2, dna);
			preparedStatement.setString(3, dnaReason);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





	public int saveCharge(NotAvailableSlot notAvailableSlot, String apmtType,int id) {
		int result = 0;
		
		PreparedStatement pstm = null;
		String sql = "insert into apm_patient_complete_apmt(user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing,startUserId)values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1,notAvailableSlot.getClient());
			pstm.setString(2, notAvailableSlot.getApmtType());
			double charge = getCharge(apmtType);
			pstm.setDouble(3, charge);
			pstm.setString(4, notAvailableSlot.getSTime());
			pstm.setString(5, notAvailableSlot.getApmtDuration());
			pstm.setInt(6, notAvailableSlot.getDiaryUserId());
			pstm.setString(7, notAvailableSlot.getDiaryUser());
			pstm.setString(8, notAvailableSlot.getClientId());
			pstm.setString(9,notAvailableSlot.getCommencing());
			pstm.setInt(10, id);
			
			
			
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}





	private double getCharge(String apmtType) {
		PreparedStatement preparedStatement = null;
		double charge = 0.0;
		String sql = "select charges from apm_appointment_type where name = '"+apmtType+"'";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				charge = rs.getDouble(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return charge;
	}





	public int updateCharge(NotAvailableSlot notAvailableSlot, String apmtType,
			int selectedid) {
		int result = 0;
		
		PreparedStatement pstm = null;
		String sql = "update apm_patient_complete_apmt set user=?,apmtType=?,charge=?,startTime=?,duration=?,practitionerName=?,clientId=?,commencing=? where startUserId = "+selectedid+"";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1,notAvailableSlot.getClient());
			pstm.setString(2, notAvailableSlot.getApmtType());
			double charge = getCharge(apmtType);
			pstm.setDouble(3, charge);
			pstm.setString(4, notAvailableSlot.getSTime());
			pstm.setString(5, notAvailableSlot.getApmtDuration());
			pstm.setString(6, notAvailableSlot.getDiaryUser());
			pstm.setString(7, notAvailableSlot.getClientId());
			pstm.setString(8,notAvailableSlot.getCommencing());
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
	}





	public ArrayList<NotAvailableSlot> getPrintDataOfWeek(String practionerId,
			String fromDate, String toDate) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		String sql = "SELECT id,apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,dept,location,room,clientname,aptmtype,duration from apm_available_slot where diaryuserid = "+practionerId+" and commencing between '"+fromDate+"' AND '"+toDate+"' ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
				notAvailableSlot.setId(rs.getInt(1));
				notAvailableSlot.setApmtSlotId(rs.getInt(2));
				notAvailableSlot.setCommencing(rs.getString(3));
				notAvailableSlot.setSTime(rs.getString(4));
				notAvailableSlot.setEndTime(rs.getString(5));
				notAvailableSlot.setNotes(rs.getString(6));
				notAvailableSlot.setDiaryUserId(rs.getInt(7));
				notAvailableSlot.setDiaryUser(rs.getString(8));
				notAvailableSlot.setDept(rs.getString(9));
				notAvailableSlot.setLocation(rs.getString(10));
				notAvailableSlot.setRoom(rs.getString(11));
				notAvailableSlot.setClient(rs.getString(12));
				notAvailableSlot.setApmtType(rs.getString(13));
				notAvailableSlot.setApmtDuration(rs.getString(14));
				
				
				
				
				
				list.add(notAvailableSlot);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	public ArrayList<NotAvailableSlot> getPractitionerPrintData(
			String practionerId, String date) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		String sql = "SELECT id,apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,dept,location,room,clientname,aptmtype,duration from apm_available_slot where diaryuserid = "+practionerId+" and commencing = '"+date+"' ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
				notAvailableSlot.setId(rs.getInt(1));
				notAvailableSlot.setApmtSlotId(rs.getInt(2));
				notAvailableSlot.setCommencing(rs.getString(3));
				notAvailableSlot.setSTime(rs.getString(4));
				notAvailableSlot.setEndTime(rs.getString(5));
				notAvailableSlot.setNotes(rs.getString(6));
				notAvailableSlot.setDiaryUserId(rs.getInt(7));
				notAvailableSlot.setDiaryUser(rs.getString(8));
				notAvailableSlot.setDept(rs.getString(9));
				notAvailableSlot.setLocation(rs.getString(10));
				notAvailableSlot.setRoom(rs.getString(11));
				notAvailableSlot.setClient(rs.getString(12));
				notAvailableSlot.setApmtType(rs.getString(13));
				notAvailableSlot.setApmtDuration(rs.getString(14));
				
				
				
				
				
				list.add(notAvailableSlot);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	public ArrayList<NotAvailableSlot> getAllPractitionerPrintData(String date) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		String sql = "SELECT id,apmslotid,commencing,starttime,endtime,notes,diaryuserid,diaryusername,dept,location,room,clientname,aptmtype,duration from apm_available_slot where commencing = '"+date+"' ";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
				notAvailableSlot.setId(rs.getInt(1));
				notAvailableSlot.setApmtSlotId(rs.getInt(2));
				notAvailableSlot.setCommencing(rs.getString(3));
				notAvailableSlot.setSTime(rs.getString(4));
				notAvailableSlot.setEndTime(rs.getString(5));
				notAvailableSlot.setNotes(rs.getString(6));
				notAvailableSlot.setDiaryUserId(rs.getInt(7));
				notAvailableSlot.setDiaryUser(rs.getString(8));
				notAvailableSlot.setDept(rs.getString(9));
				notAvailableSlot.setLocation(rs.getString(10));
				notAvailableSlot.setRoom(rs.getString(11));
				notAvailableSlot.setClient(rs.getString(12));
				notAvailableSlot.setApmtType(rs.getString(13));
				notAvailableSlot.setApmtDuration(rs.getString(14));
				list.add(notAvailableSlot);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}





	
}
