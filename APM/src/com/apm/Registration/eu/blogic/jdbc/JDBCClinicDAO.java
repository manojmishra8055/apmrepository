package com.apm.Registration.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Registration.eu.bi.ClinicDAO;
import com.apm.Registration.eu.entity.Clinic;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Encryption;
import com.apm.common.utils.Pagination;


public class JDBCClinicDAO extends JDBCBaseDAO implements ClinicDAO{
	
	public JDBCClinicDAO(Connection connection){
		this.connection = connection;
		
	}
	
	public ArrayList<Clinic> getClinicList(Pagination pagination,String searchText)
	throws Exception {
	PreparedStatement preparedStatement = null;
	ArrayList<Clinic>list = new ArrayList<Clinic>();
	/*String sql = "select id,clinicname,firstname,lastname from apm_user where clinicname like('%"+searchText+"%') and userid = ? ";*/
	
	String sql = "select id,clinicname,clinicowner,userid from apm_user where clinicname like('%"+searchText+"%') and usertype = 2 ";
	sql = pagination.getSQLQuery(sql);
	
try{
		
		preparedStatement = connection.prepareStatement(sql);
		//preparedStatement.setString(1,userID);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			
			Clinic cliniclist = new Clinic();
			
			//cliniclist.setId(rs.getInt(1));
			
			cliniclist.setId(rs.getInt(1));
			cliniclist.setClinicName(rs.getString(2));
			cliniclist.setClinicOwner(rs.getString(3));
			cliniclist.setUserId(rs.getString(4));
							
			list.add(cliniclist);
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	}
	
	public ArrayList<Clinic> getClinicList() {
		PreparedStatement preparedStatement = null;
		ArrayList<Clinic>list = new ArrayList<Clinic>();
		String sql = "select id,clinicname,clinicowner,userid from apm_user";
		
		
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				Clinic cliniclist = new Clinic();
				
				//cliniclist.setId(rs.getInt(1));
				
				cliniclist.setId(rs.getInt(1));
				cliniclist.setClinicName(rs.getString(2));
				//cliniclist.setFirstname(rs.getString(3));
				cliniclist.setClinicOwner(rs.getString(3));
				cliniclist.setUserId(rs.getString(4));
								
				list.add(cliniclist);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
public Clinic getCliniclistDetails(int selectedid) {
		
		PreparedStatement preparedStatement = null;
		
		
		Clinic cliniclist = new Clinic();
		
		
		
		/*String sql = "SELECT uf.fullname, uf.initial,uf.jobtitle,uf.discription,uf.registerno,uf.usergroup,"+
					"us.isapractitioner,us.appointmentdiary,us.diarycolor,us.diarycolumnposition,us.compressionrate,"+
					"us.onlinename,us.isavailableonline"+
					"FROM userprofile AS uf INNER JOIN usersetup AS us ON uf.id = us.userid where userprofile.id = ?";*/
		
		String sql = "SELECT * from apm_user where id=?";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectedid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				/*userprofile.setId(rs.getInt(1));*/
				cliniclist.setClinicName(rs.getString(2));
				cliniclist.setFirstName(rs.getString(3));
				cliniclist.setLastName(rs.getString(4));
				cliniclist.setUserId(rs.getString(5));
				cliniclist.setPassword(rs.getString(6));
				cliniclist.setEmail(rs.getString(14));
				cliniclist.setMobileNo(rs.getString(12));
				cliniclist.setLandLine(rs.getString(13));
				cliniclist.setClinicOwner(rs.getString(22));
				cliniclist.setStandalone(rs.getBoolean(23));
				cliniclist.setHostedDB(rs.getBoolean(24));
				cliniclist.setOnlineSingleDevice(rs.getBoolean(25));
				cliniclist.setOnlineMultiDevice(rs.getBoolean(26));
				cliniclist.setDiaryManagement(rs.getBoolean(27));
				cliniclist.setAppointmentBooking(rs.getBoolean(28));
				cliniclist.setBasicFinance(rs.getBoolean(29));
				cliniclist.setFullFinance(rs.getBoolean(30));
				cliniclist.setMedicalRecord(rs.getBoolean(31));
				cliniclist.setClinicResourceMngment(rs.getBoolean(32));
				cliniclist.setClinicPayrollMngment(rs.getBoolean(33));
				cliniclist.setId(selectedid);
				
				
			}
			
			
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliniclist;
	}

public ArrayList<Clinic> getClinicLocationList(int selectedid)
{
	PreparedStatement preparedLocationStatement = null;
	ArrayList<Clinic>list = new ArrayList<Clinic>();
	
	String sqlLocation = "SELECT * from apm_clinic_location where userid=?";
	
	try{
		preparedLocationStatement = connection.prepareStatement(sqlLocation);
		preparedLocationStatement.setInt(1, selectedid);
		ResultSet rslocation = preparedLocationStatement.executeQuery();
		
		while(rslocation.next())
		{
			
			Clinic cliniclist = new Clinic();
			cliniclist.setLocationid(rslocation.getInt(1));
			cliniclist.setCountry(rslocation.getString(2));
			cliniclist.setCity(rslocation.getString(3));
			cliniclist.setAddress(rslocation.getString(4));
			cliniclist.setPinCode(rslocation.getString(5));
			cliniclist.setLocationname(rslocation.getString(7));
			cliniclist.setColorName(rslocation.getString(8));
			
			list.add(cliniclist);
			
		}

	
}catch (Exception e) {
	e.printStackTrace();
}

 return list;
	
	
}

public int getCliniclistCount(String searchText) throws Exception {
	PreparedStatement preparedStatement = null;
	int result = 0;
	String sql = "select count(*) from apm_user  where clinicname like('%"+searchText+"%') and usertype = 2 ";
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

public int updateCliniclist(Clinic cliniclist)
{
	
	PreparedStatement preparedStatement = null;
	
	int result = 0;
	/*String sql = "UPDATE userprofile INNER JOIN usersetup ON userprofile.id = usersetup.userid set userprofile.fullname=?,userprofile.initial=?,userprofile.jobtitle=?,userprofile.discription=?,userprofile.registerno=?,userprofile.usergroup=?," +
			" usersetup.isapractitioner=?,usersetup.appointmentdiary=?,usersetup.diarycolor=?,usersetup.diarycolumnposition=?,usersetup.compressionrate=?," +
			" usersetup.onlinename=?,usersetup.isavailableonline=? where userprofile.id=?";*/
	
	String sql = "UPDATE apm_user set clinicname=?,firstname=?,lastname=?,userid=?,email=?,mobile=?,landline=?,clinicowner=?,standalone=?," +
			"hosteddb=?,onlinesingledevice=?,onlinemultidevice=?,diarymanagement=?,appointmentbooking=?," +
			"basicfinance=?,fullfinance=?,medicalrecord=?,clinicresourcemanagement=?,clinicpayrollmanagement=? where id=?";
	
	try{
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, cliniclist.getClinicName());
		preparedStatement.setString(2, cliniclist.getFirstName());
		preparedStatement.setString(3, cliniclist.getLastName());
		/*preparedStatement.setString(4, cliniclist.getDiscription());*/
		preparedStatement.setString(4, cliniclist.getUserId());
		/*preparedStatement.setString(5, cliniclist.getPassword());*/
		
		preparedStatement.setString(5, cliniclist.getEmail());
		preparedStatement.setString(6, cliniclist.getMobileNo());
		preparedStatement.setString(7, cliniclist.getLandLine());
		
		preparedStatement.setString(8, cliniclist.getClinicOwner());
		preparedStatement.setBoolean(9, cliniclist.isStandalone());
		preparedStatement.setBoolean(10, cliniclist.isHostedDB());
		
		preparedStatement.setBoolean(11, cliniclist.isOnlineSingleDevice());
		preparedStatement.setBoolean(12, cliniclist.isOnlineMultiDevice());
		preparedStatement.setBoolean(13,cliniclist.isDiaryManagement());
		preparedStatement.setBoolean(14,cliniclist.isAppointmentBooking());
		preparedStatement.setBoolean(15,cliniclist.isBasicFinance());
		preparedStatement.setBoolean(16,cliniclist.isFullFinance());
		preparedStatement.setBoolean(17,cliniclist.isMedicalRecord());
		preparedStatement.setBoolean(18,cliniclist.isClinicResourceMngment());
		preparedStatement.setBoolean(19,cliniclist.isClinicPayrollMngment());
						
		preparedStatement.setInt(20, cliniclist.getId());
		
		result = preparedStatement.executeUpdate();
		
			
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return result;
}

public int saveLocation(int selectedid, int locationid, Clinic cliniclist) {
	PreparedStatement preparedStatement = null;
	int result = 0;
	String sql = "UPDATE apm_clinic_location set country=?,city=?,address=?,postcode=?,location=?,color=? where userid=? and id=?";
	
	try{
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, cliniclist.getCountry());
		preparedStatement.setString(2, cliniclist.getCity());
		preparedStatement.setString(3, cliniclist.getAddress());
		preparedStatement.setString(4, cliniclist.getPinCode());
		preparedStatement.setString(5, cliniclist.getLocationname());
		preparedStatement.setString(6, "#"+cliniclist.getColorName());
		preparedStatement.setInt(7, selectedid);
		preparedStatement.setInt(8, locationid);
		
		result = preparedStatement.executeUpdate();
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return result;
}

public int deleteClinicList(int selectedid) {
	int result=0;
	try{
		String sql="delete from apm_user where id= " +selectedid;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		result= preparedStatement.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return result;
}
	
	public boolean isUserExist(String userid) {
		PreparedStatement preparedStatement = null;
		boolean result = false;
		String sql = "select * from apm_user where userid = ? ";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = true;
			}
		}catch (Exception e) {
			
		}
		
		
		return result;
	}


	public int saveClinic(Clinic clinic) {
		PreparedStatement preparedStatement = null;
		int userid = 0;
		String sql = "insert into apm_user (clinicname,clinicowner,email,mobile,landline,userid,password,standalone,hosteddb,onlinesingledevice,onlinemultidevice,diarymanagement,appointmentbooking,basicfinance,fullfinance,medicalrecord,clinicresourcemanagement,clinicpayrollmanagement,usertype) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int usertype = 2;
		try{
			
			String encPassword = Encryption.encryptSHA(clinic.getPassword());
			
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clinic.getClinicName());
			preparedStatement.setString(2, clinic.getClinicOwner());
			preparedStatement.setString(3, clinic.getEmail());
			preparedStatement.setString(4,clinic.getMobileNo());
			preparedStatement.setString(5, clinic.getLandLine());
			preparedStatement.setString(6, clinic.getUserId());
			preparedStatement.setString(7, encPassword);
			preparedStatement.setBoolean(8, clinic.isStandalone());
			preparedStatement.setBoolean(9, clinic.isHostedDB());
			preparedStatement.setBoolean(10, clinic.isOnlineSingleDevice());
			preparedStatement.setBoolean(11, clinic.isOnlineMultiDevice());
			preparedStatement.setBoolean(12, clinic.isDiaryManagement());
			preparedStatement.setBoolean(13, clinic.isAppointmentBooking());
			preparedStatement.setBoolean(14, clinic.isBasicFinance());
			preparedStatement.setBoolean(15, clinic.isFullFinance());
			preparedStatement.setBoolean(16, clinic.isMedicalRecord());
			preparedStatement.setBoolean(17, clinic.isClinicResourceMngment());
			preparedStatement.setBoolean(18, clinic.isClinicPayrollMngment());
			preparedStatement.setInt(19, usertype);
			
			
		
			
			int result = preparedStatement.executeUpdate();
			
			if(result == 1){
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()){
					userid = resultSet.getInt(1);  
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userid;
	}


	public int saveAdminAccessPassword(int userid, Clinic clinic) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_admin(userid,password) values(?,?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clinic.getUserId());
			preparedStatement.setString(2, clinic.getPassword());
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int saveLocation(int userid, Clinic clinic) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_clinic_location(country,city,address,postcode,location,color,userid) values(?,?,?,?,?,?,?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clinic.getCountry());
			preparedStatement.setString(2, clinic.getCity());
			preparedStatement.setString(3, clinic.getAddress());
			preparedStatement.setString(4, clinic.getPinCode());
			preparedStatement.setString(5, clinic.getLocationname());
			preparedStatement.setString(6,"#"+clinic.getColorName());
			preparedStatement.setInt(7, userid);
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public Clinic getuser(String userId) {
		PreparedStatement preparedStatement = null;
		Clinic clinic = new Clinic();
		/*String sql = "select id,userid,password,firstname,lastname,clinicowner,usertype from apm_user where userid=?";*/
		
		String sql = "select apm_user.id,userid,password,firstname,lastname,clinicowner,apm_user.usertype,usertypemaster.usertype as uusertype from apm_user "+
					"inner join usertypemaster on apm_user.usertype = usertypemaster.id "+
					"where userid=?";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				clinic.setId(rs.getInt(1));
				clinic.setUserId(rs.getString(2));
				clinic.setPassword(rs.getString(3));
				clinic.setFirstName(rs.getString(4));
				clinic.setLastName(rs.getString(5));
				clinic.setClinicOwner(rs.getString(6));
				clinic.setUserType(rs.getInt(7));
				clinic.setUuserType(rs.getString(8));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return clinic;
	}

	public ArrayList<Clinic> getColorList() {
		PreparedStatement preparedLocationStatement = null;
		ArrayList<Clinic>list = new ArrayList<Clinic>();
		
		String sqlLocation = "select id,color from color ";
		
		try{
			preparedLocationStatement = connection.prepareStatement(sqlLocation);
			
			ResultSet rslocation = preparedLocationStatement.executeQuery();
			
			while(rslocation.next())
			{
				
				Clinic clinic = new Clinic();
				clinic.setId(rslocation.getInt(1));
				clinic.setColorName(rslocation.getString(2));
				
				
				list.add(clinic);
				
			}

		
	}catch (Exception e) {
		e.printStackTrace();
	}

	return list;
	}


	

}
