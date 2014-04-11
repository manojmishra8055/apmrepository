package com.apm.DiaryManagement.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;

public class JDBCDiaryManagentDAO extends JDBCBaseDAO implements DiaryManagementDAO {
	
	public JDBCDiaryManagentDAO(Connection connection){
		this.connection = connection;
		
	}

	public int saveAppointmentSlot(DiaryManagement diaryManagement) {
		
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_apmt_slot(commencing,diaryuser,diaryuserid,location,room,description,starttime,endtime,apmtduration,onlinebooking,tdcode,weekname,year,weekfullname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, diaryManagement.getCommencing());
			preparedStatement.setString(2, diaryManagement.getSelectedDiaryUser());
			preparedStatement.setInt(3, diaryManagement.getDiarUserid());
			preparedStatement.setString(4, diaryManagement.getLocation());;
			preparedStatement.setString(5, diaryManagement.getRoom());
			preparedStatement.setString(6, diaryManagement.getDescription());
			preparedStatement.setString(7, diaryManagement.getSTime());
			preparedStatement.setString(8, diaryManagement.getEndTime());
			preparedStatement.setString(9, diaryManagement.getApmtDuration());
			preparedStatement.setBoolean(10, diaryManagement.isOnlineBooking());
			preparedStatement.setString(11, diaryManagement.getTdCode());
			preparedStatement.setString(12, diaryManagement.getWeekName());
			preparedStatement.setString(13, diaryManagement.getYear());
			preparedStatement.setString(14, diaryManagement.getWeekFullName());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<DiaryManagement> getPractionerList(int year,int clinicid) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "select id,firstname,lastname,diarycolor from apm_user where usertype = 4 and clinicid = "+clinicid+" " ;
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs  = preparedStatement.executeQuery();
			while(rs.next()){
				
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setDiarUserid(rs.getInt(1));
				diaryManagement.setFirstName(rs.getString(2));
				diaryManagement.setLastName(rs.getString(3));
				diaryManagement.setDiaryColor(rs.getString(4));
				
				ArrayList<DiaryManagement>tdcodeList = getTdCodeList(year,diaryManagement.getDiarUserid());
				ArrayList<Tdcode>tdDataList = new ArrayList<Tdcode>();
				
				
				
				
				
				for(DiaryManagement tds : tdcodeList){
					 String weeklistname = getWeekList(tds.getTdCode(),year);
					 String temp[] = weeklistname.split(",");
					 weeklistname = getWeekShortName(temp);
					 String location = getAppoinmentLocation(tds.getTdCode(),year);
					 String colorname = getLocationColor(location,clinicid);
					 
					 Tdcode tdcode = new Tdcode();
					 tdcode.setWeekListName(weeklistname);
					 tdcode.setColorName(colorname);
					 tdcode.setTdCode(tds.getTdCode());
					
					 tdDataList.add(tdcode);
				}
				
				diaryManagement.setTdDataList(tdDataList);
				
				list.add(diaryManagement);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	public String getWeekShortName(String weekFullName[]){
		String week[] = new String[7];
		StringBuffer str = new StringBuffer();
		for(String s : weekFullName){
			if(s.equals("Monday")){
				week[0] = "M";
			}
			if(s.equals("Tuesday")){
				week[1] = "T";
			}
			if(s.equals("Wednesday")){
				week[2] = "W";
			}
			if(s.equals("Thursday")){
				week[3] = "T";
			}
			if(s.equals("Friday")){
				week[4] = "F";
			}
			if(s.equals("Saturday")){
				week[5] = "S";
			}
			if(s.equals("Sunday")){
				week[6] = "S";
			}
		}
		
		for(String s : week){
			if(s == null){
				s = "";
			}else{
				str.append(s);
			}
			
		}
		
		return str.toString();
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

	public ArrayList<DiaryManagement> getTdCodeList(int year,int diaryuserid) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement> list = new ArrayList<DiaryManagement>();
		String sql = "SELECT tdcode FROM apm_apmt_slot where year = "+year+" and diaryuserid = "+diaryuserid+" group by tdcode ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs  = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setTdCode(rs.getString(1));
				list.add(diaryManagement);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getWeekList(String tdCode, int year) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT weekfullname FROM apm_apmt_slot where tdcode = ? and year = ?  group by weekfullname ";
		StringBuffer str = new StringBuffer();
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tdCode);
			preparedStatement.setInt(2, year);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				str.append(rs.getString(1) + ",");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}

	public String getAppoinmentLocation(String tdCode, int year) {
		PreparedStatement  preparedStatement = null;
		String result = "";
		String sql = "SELECT location  FROM apm_apmt_slot where tdcode = ? and year = ? group by tdcode";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tdCode);
			preparedStatement.setInt(2, year);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getLocationColor(String location, int userId) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT color FROM apm_clinic_location where  userid = ? and location = ? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, location);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<DiaryManagement> getAppointmentSlotData(String diaryuserid,int clinicUserid,String tdcode,String year) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "SELECT id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,onlinebooking FROM apm_apmt_slot where diaryuserid= "+diaryuserid+" and tdcode = ? and year = ? ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tdcode);
			preparedStatement.setString(2, year);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setSTime(rs.getString(2));
				diaryManagement.setEndTime(rs.getString(3));
				diaryManagement.setApmtDuration(rs.getString(4));
				diaryManagement.setLocation(rs.getString(5));
				String locationColor = getLocationColor(diaryManagement.getLocation(), clinicUserid);
				diaryManagement.setLocationColor(locationColor);
				diaryManagement.setTdCode(rs.getString(6));
				diaryManagement.setWeekName(rs.getString(7));
				diaryManagement.setCommencing(rs.getString(8));
				diaryManagement.setWeekFullName(rs.getString(9));
				diaryManagement.setOnlineBooking(rs.getBoolean(10));
				
				
				
				list.add(diaryManagement);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	


	public int updateAppointment(int selectedid, DiaryManagement diaryManagement) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_apmt_slot set starttime=?,endtime=?,apmtduration=?,location=?,onlinebooking=? where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, diaryManagement.getSTime());
			preparedStatement.setString(2, diaryManagement.getEndTime());
			preparedStatement.setString(3, diaryManagement.getApmtDuration());
			preparedStatement.setString(4, diaryManagement.getLocation());
			preparedStatement.setBoolean(5, diaryManagement.isOnlineBooking());
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteAppointmentSlot(int selectedid) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_apmt_slot where id = "+selectedid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkUsertdCodeExist(String usertdcode,String year) {
		PreparedStatement preparedStatement = null;
		boolean result = false;
		String sql = "SELECT * FROM apm_apmt_slot where tdcode = ?  and year = ? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usertdcode);
			preparedStatement.setString(2, year);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteAppointSlotByTdcode(String usertdcode,String year) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_apmt_slot where tdcode = ? and year = ? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usertdcode);
			preparedStatement.setString(2, year);
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteAppointSlotByTdcode(String usertdcode,String year,String location) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_apmt_slot where tdcode = ? and year = ? and location =? ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usertdcode);
			preparedStatement.setString(2, year);
			preparedStatement.setString(3, location);
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public ArrayList<DiaryManagement> getAppointmentSlotData(int id,
			String date, String year) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "SELECT id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,onlinebooking FROM apm_apmt_slot where commencing = '"+date+"' and year = '"+year+"' ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setSTime(rs.getString(2));
				diaryManagement.setEndTime(rs.getString(3));
				diaryManagement.setApmtDuration(rs.getString(4));
				diaryManagement.setLocation(rs.getString(5));
				String locationColor = getLocationColor(diaryManagement.getLocation(), id);
				diaryManagement.setLocationColor(locationColor);
				diaryManagement.setTdCode(rs.getString(6));
				diaryManagement.setWeekName(rs.getString(7));
				diaryManagement.setCommencing(rs.getString(8));
				diaryManagement.setWeekFullName(rs.getString(9));
				diaryManagement.setOnlineBooking(rs.getBoolean(10));
				
				list.add(diaryManagement);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<DiaryManagement> getAppointmentSlotData2(
			String diaryuserid, int id, String date, String year) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "SELECT id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,onlinebooking,diaryuser,diaryuserid FROM apm_apmt_slot where diaryuserid= "+diaryuserid+" and commencing = '"+date+"' and year = '"+year+"' ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setSTime(rs.getString(2));
				diaryManagement.setEndTime(rs.getString(3));
				diaryManagement.setApmtDuration(rs.getString(4));
				diaryManagement.setLocation(rs.getString(5));
				String locationColor = getLocationColor(diaryManagement.getLocation(), id);
				diaryManagement.setLocationColor(locationColor);
				diaryManagement.setTdCode(rs.getString(6));
				diaryManagement.setWeekName(rs.getString(7));
				diaryManagement.setCommencing(rs.getString(8));
				diaryManagement.setWeekFullName(rs.getString(9));
				diaryManagement.setOnlineBooking(rs.getBoolean(10));
				diaryManagement.setDiaryUser(rs.getString(11));
				diaryManagement.setDiarUserid(rs.getInt(12));
				
				list.add(diaryManagement);
			}

			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<DiaryManagement> getAppointmentSlotData3(int id,
			String date, String year1) {
	
			PreparedStatement preparedStatement = null;
			ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
			String sql = "SELECT id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,onlinebooking,diaryuserid FROM apm_apmt_slot where commencing = '"+date+"' and year = '"+year1+"' ";
			
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					DiaryManagement diaryManagement = new DiaryManagement();
					diaryManagement.setId(rs.getInt(1));
					diaryManagement.setSTime(rs.getString(2));
					diaryManagement.setEndTime(rs.getString(3));
					diaryManagement.setApmtDuration(rs.getString(4));
					diaryManagement.setLocation(rs.getString(5));
					String locationColor = getLocationColor(diaryManagement.getLocation(), id);
					diaryManagement.setLocationColor(locationColor);
					diaryManagement.setTdCode(rs.getString(6));
					diaryManagement.setWeekName(rs.getString(7));
					diaryManagement.setCommencing(rs.getString(8));
					diaryManagement.setWeekFullName(rs.getString(9));
					diaryManagement.setOnlineBooking(rs.getBoolean(10));
					diaryManagement.setDiarUserid(rs.getInt(11));
					
					list.add(diaryManagement);
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}

	
	public ArrayList<DiaryManagement> getAllDiaryUserAppointmentSlotData(
			String diaryuserid, int clinicUserid, String commencing) {
		PreparedStatement preparedStatement = null;
		ArrayList<DiaryManagement>list = new ArrayList<DiaryManagement>();
		String sql = "SELECT id,starttime,endtime,apmtduration,location,tdcode,weekname,commencing,weekfullname,onlinebooking,diaryuser,diaryuserid FROM apm_apmt_slot where diaryuserid= "+diaryuserid+" and commencing = ?  ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, commencing);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				DiaryManagement diaryManagement = new DiaryManagement();
				diaryManagement.setId(rs.getInt(1));
				diaryManagement.setSTime(rs.getString(2));
				diaryManagement.setEndTime(rs.getString(3));
				diaryManagement.setApmtDuration(rs.getString(4));
				diaryManagement.setLocation(rs.getString(5));
				String locationColor = getLocationColor(diaryManagement.getLocation(), clinicUserid);
				diaryManagement.setLocationColor(locationColor);
				diaryManagement.setTdCode(rs.getString(6));
				diaryManagement.setWeekName(rs.getString(7));
				diaryManagement.setCommencing(rs.getString(8));
				diaryManagement.setWeekFullName(rs.getString(9));
				diaryManagement.setOnlineBooking(rs.getBoolean(10));
				diaryManagement.setDiaryUser(rs.getString(11));
				diaryManagement.setDiarUserid(rs.getInt(12));
				
				list.add(diaryManagement);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<NotAvailableSlot> getApmtList(String diaryuserid,String practitionerid) {
		PreparedStatement preparedStatement = null;
		ArrayList<NotAvailableSlot>list = new ArrayList<NotAvailableSlot>();
		String sql = "SELECT id,clientname,aptmtype,starttime,endtime,duration,notes,status,arrivedstatus,dna,clientId,commencing,diaryuserid,charge,reasonforblock,treatmentEpisodeId from apm_available_slot where apmslotid="+diaryuserid+" and diaryuserid="+practitionerid+" ";

		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
				notAvailableSlot.setId(rs.getInt(1));
				notAvailableSlot.setClientName(rs.getString(2));
				notAvailableSlot.setApmtType(rs.getString(3));
				notAvailableSlot.setSTime(rs.getString(4));
				notAvailableSlot.setEndTime(rs.getString(5));
				notAvailableSlot.setDuration(rs.getString(6));
				notAvailableSlot.setNotes(rs.getString(7));
				notAvailableSlot.setStatus(rs.getString(8));
				notAvailableSlot.setArrivedStatus(rs.getInt(9));
				notAvailableSlot.setDna(rs.getBoolean(10));
				notAvailableSlot.setClientId(rs.getString(11));
				notAvailableSlot.setCommencing(rs.getString(12));
				notAvailableSlot.setDiaryUserId(rs.getInt(13));
				notAvailableSlot.setCharge(rs.getDouble(14));
				notAvailableSlot.setReasonforblock(rs.getString(15));
				notAvailableSlot.setTreatmentEpisodeId(rs.getString(16));
				
				
				int practitionerId = rs.getInt(13);
				int clientId = rs.getInt(11);
				
				String practitionerEmailId = getpractitionerEmailId(practitionerId);
				String clientEmailId = getclientEmailId(clientId);
				
				notAvailableSlot.setPractitionerEmail(practitionerEmailId);
				notAvailableSlot.setClientEmail(clientEmailId);
				
				
				//check appointment completed
				boolean isCompleted = checkAppointmentCompleted(notAvailableSlot.getId());
				notAvailableSlot.setAppointmentCompleted(isCompleted);
				
				list.add(notAvailableSlot);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	


	private boolean checkAppointmentCompleted(int id) {
		PreparedStatement preparedStatement = null;
		boolean result = false;
		String sql = "SELECT * FROM apm_invoice_assesments where appointmentid = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				result = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getclientEmailId(int clientId) {
		PreparedStatement preparedStatement = null;
		
		String practitionerEmailId = "";
		String sql = "select email from apm_patient where id = "+clientId+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				practitionerEmailId = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return practitionerEmailId;
	}

	private String getpractitionerEmailId(int practitionerId) {
		PreparedStatement preparedStatement = null;
		String clientEmailId = " ";
		String sql = "select email from apm_user where id = '"+practitionerId+"'";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				clientEmailId = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientEmailId;
	}

	public boolean checkPractitionerAvailibility(String commencing,
			String diaryuserid) {
		
		PreparedStatement preparedStatement = null;
		boolean result = false;
		String sql = "SELECT * FROM apm_apmt_slot where diaryuserid="+diaryuserid+" and commencing=? ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, commencing);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

		
	



	

	

	
	
		
}
