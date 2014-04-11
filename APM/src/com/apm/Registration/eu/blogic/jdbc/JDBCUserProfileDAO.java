package com.apm.Registration.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Registration.eu.bi.UserProfileDAO;
import com.apm.Registration.eu.entity.UserProfile;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Encryption;
import com.apm.common.utils.Pagination;

public class JDBCUserProfileDAO extends JDBCBaseDAO implements UserProfileDAO {

	
public JDBCUserProfileDAO(Connection connection){
		
		this.connection = connection;
	}

	
	public ArrayList<UserProfile> getUserProfileList(Pagination pagination,String searchText,int clinicid) {
		PreparedStatement preparedStatement = null;
		ArrayList<UserProfile>list = new ArrayList<UserProfile>();
	
		
		String sql = "select id,firstname,lastname,jobtitle,discription from apm_user where firstname like('%"+searchText+"%') or jobtitle like('%"+searchText+"%')  and usertype = 4 and clinicid = "+clinicid+" " ;
		sql = pagination.getSQLQuery(sql);
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				UserProfile userprofile = new UserProfile();
				userprofile.setId(rs.getInt(1));
				userprofile.setFirstname(rs.getString(2));
				userprofile.setLastname(rs.getString(3));
				userprofile.setJobtitle(rs.getString(4));
				userprofile.setDiscription(rs.getString(5));
				
				list.add(userprofile);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getUserprofileCount(String searchText,int clinicid) throws Exception {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from apm_user where firstname like('%"+searchText+"%') or jobtitle like('%"+searchText+"%')  and usertype = 4  and clinicid = "+clinicid+" ";
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
	
public int saveUserprofile(UserProfile userprofile,int clinicid) {
		
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_user(firstname,lastname,initial,jobtitle,discription,registerno,usergroup,isapractitioner,appointmentdiary,diarycolor,diarycolumnposition,compressionrate,onlinename,isavailableonline," +
				"loginsystem,userid,password,lastchanged,changefre,appointmentbookingcontem,appointmentbookingdnatem,email,mobile,apmremote,onlinebooking,usertype,clinicid)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			/*preparedStatement.setInt(1, userprofile.getId());*/
			preparedStatement.setString(1, userprofile.getFirstname());
			preparedStatement.setString(2, userprofile.getLastname());
			preparedStatement.setString(3, userprofile.getInitial());
			preparedStatement.setString(4, userprofile.getJobtitle());
			/*preparedStatement.setString(4, userprofile.getDiscription());*/
			preparedStatement.setString(5, userprofile.getDiciplineName());
			preparedStatement.setString(6, userprofile.getRegisterno());
			preparedStatement.setString(7,userprofile.getUsergroup());
			preparedStatement.setBoolean(8, userprofile.isUsercheck());
			preparedStatement.setBoolean(9,userprofile.isAppointmentdiary());
			preparedStatement.setString(10, "#"+userprofile.getDiarycolor());
			preparedStatement.setString(11,userprofile.getDiarycolumnposition());
			preparedStatement.setInt(12,userprofile.getCompressionrate());
			preparedStatement.setString(13,userprofile.getOnlinename());
			preparedStatement.setBoolean(14,userprofile.isIsavailableonline());
			preparedStatement.setBoolean(15, userprofile.isLoginsystem());
			preparedStatement.setString(16, userprofile.getUserid());
			
			String encPassword = Encryption.encryptSHA(userprofile.getPassword());
			preparedStatement.setString(17,encPassword);
			/*preparedStatement.setString(16, userprofile.getPassword());*/
			preparedStatement.setString(18, userprofile.getLastchanged());
			preparedStatement.setInt(19, userprofile.getChangefre());
			preparedStatement.setString(20,userprofile.getAppointmentbookingcontem());
			preparedStatement.setString(21,userprofile.getAppointmentbookingdnatem());
			preparedStatement.setString(22, userprofile.getEmail());
			preparedStatement.setString(23, userprofile.getMobile());
			preparedStatement.setBoolean(24, userprofile.isApmremote());
			preparedStatement.setBoolean(25, userprofile.isOnlinebooking());
			
			
			preparedStatement.setInt(26,4);
			
			/*boolean usercheck;
			usercheck=userprofile.isUsercheck();
			
			if(usercheck)
			{
				preparedStatement.setInt(26,4);
			}
			else
			{
				preparedStatement.setInt(26,6);
			}*/
			
			preparedStatement.setInt(27, clinicid);
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}

	public int deleteUserprofile(int selectedid) {
		int result=0;
		try{
			/*String sql="delete from userprofile where id= " +selectedid;*/
			String sql="delete from apm_user where id= " +selectedid;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			result= preparedStatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public int updateUserprofile(UserProfile userprofile)
	{
		
		PreparedStatement preparedStatement = null;
		int result = 0;
		/*String sql = "UPDATE userprofile INNER JOIN usersetup ON userprofile.id = usersetup.userid set userprofile.fullname=?,userprofile.initial=?,userprofile.jobtitle=?,userprofile.discription=?,userprofile.registerno=?,userprofile.usergroup=?," +
				" usersetup.isapractitioner=?,usersetup.appointmentdiary=?,usersetup.diarycolor=?,usersetup.diarycolumnposition=?,usersetup.compressionrate=?," +
				" usersetup.onlinename=?,usersetup.isavailableonline=? where userprofile.id=?";*/
		
		String sql = "UPDATE apm_user set firstname=?,lastname=?,initial=?,jobtitle=?,discription=?,registerno=?,usergroup=?,isapractitioner=?,appointmentdiary=?,diarycolor=?,diarycolumnposition=?," +
				"compressionrate=?,onlinename=?,isavailableonline=?,loginsystem=?,userid=?,lastchanged=?,changefre=?,appointmentbookingcontem=?,appointmentbookingdnatem=?,email=?,mobile=?,apmremote=?,onlinebooking=? where id=?";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, userprofile.getFirstname());
			preparedStatement.setString(2, userprofile.getLastname());
			preparedStatement.setString(3, userprofile.getInitial());
			preparedStatement.setString(4, userprofile.getJobtitle());
			/*preparedStatement.setString(4, userprofile.getDiscription());*/
			preparedStatement.setString(5, userprofile.getDiciplineName());
			preparedStatement.setString(6, userprofile.getRegisterno());
			
			preparedStatement.setString(7, userprofile.getUsergroup());
			preparedStatement.setBoolean(8, userprofile.isUsercheck());
			preparedStatement.setBoolean(9, userprofile.isAppointmentdiary());
			
			preparedStatement.setString(10, "#"+userprofile.getDiarycolor());
			preparedStatement.setString(11, userprofile.getDiarycolumnposition());
			preparedStatement.setInt(12, userprofile.getCompressionrate());
			
			preparedStatement.setString(13, userprofile.getOnlinename());
			preparedStatement.setBoolean(14, userprofile.isIsavailableonline());
			preparedStatement.setBoolean(15, userprofile.isLoginsystem());
			preparedStatement.setString(16, userprofile.getUserid());
			/*preparedStatement.setString(16, userprofile.getPassword());*/
			preparedStatement.setString(17, userprofile.getLastchanged());
			preparedStatement.setInt(18, userprofile.getChangefre());
			preparedStatement.setString(19,userprofile.getAppointmentbookingcontem());
			preparedStatement.setString(20,userprofile.getAppointmentbookingdnatem());
			preparedStatement.setString(21, userprofile.getEmail());
			preparedStatement.setString(22, userprofile.getMobile());
			preparedStatement.setBoolean(23, userprofile.isApmremote());
			preparedStatement.setBoolean(24, userprofile.isOnlinebooking());
							
			preparedStatement.setInt(25, userprofile.getId());
			
			
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<UserProfile> getUserprofileList() {
		PreparedStatement preparedStatement = null;
		ArrayList<UserProfile>list = new ArrayList<UserProfile>();
		String sql = "SELECT uf.fullname, uf.initial,uf.jobtitle,uf.discription,uf.registerno,uf.usergroup," +
					"us.isapractitioner,us.appointmentdiary,us.diarycolor,us.diarycolumnposition,us.compressionrate," +
					"us.onlinename,us.isavailableonline" +
					"FROM userprofile AS uf INNER JOIN usersetup AS us ON uf.id = us.userid";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				UserProfile userprofile = new UserProfile();
				userprofile.setId(rs.getInt(1));
				userprofile.setFullname(rs.getString(2));
				userprofile.setInitial(rs.getString(3));
				userprofile.setJobtitle(rs.getString(4));
				/*userprofile.setDiscription(rs.getString(5));*/
				userprofile.setDiciplineName (rs.getString(5));
				userprofile.setRegisterno(rs.getString(6));
				userprofile.setUsergroup(rs.getString(7));
				userprofile.setUsercheck(rs.getBoolean(8));
				userprofile.setAppointmentdiary(rs.getBoolean(9));
				userprofile.setDiarycolor(rs.getString(10));
				userprofile.setDiarycolumnposition(rs.getString(11));
				userprofile.setCompressionrate(rs.getInt(12));
				userprofile.setOnlinename(rs.getString(13));
			
				
				list.add(userprofile);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public UserProfile getUserprofileDetails(int selectedid) {
		
		PreparedStatement preparedStatement = null;
		UserProfile userprofile = new UserProfile();
		
		/*String sql = "SELECT uf.fullname, uf.initial,uf.jobtitle,uf.discription,uf.registerno,uf.usergroup,"+
					"us.isapractitioner,us.appointmentdiary,us.diarycolor,us.diarycolumnposition,us.compressionrate,"+
					"us.onlinename,us.isavailableonline"+
					"FROM userprofile AS uf INNER JOIN usersetup AS us ON uf.id = us.userid where userprofile.id = ?";*/
		
		/*String sql = "SELECT * from userprofile where id=?";*/
		/*String sql = "SELECT * from apm_user where id=? and usertype = 4 ";*/
		String sql = "SELECT * from apm_user where id=?";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectedid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				/*userprofile.setId(rs.getInt(1));*/
				userprofile.setFirstname(rs.getString("firstname"));
				userprofile.setLastname(rs.getString("lastname"));
				userprofile.setInitial(rs.getString("initial"));
				userprofile.setJobtitle(rs.getString("jobtitle"));
				/*userprofile.setDiscription(rs.getString(5));*/
				userprofile.setDiciplineName(rs.getString("discription"));
				userprofile.setRegisterno(rs.getString("registerno"));
				userprofile.setUsergroup(rs.getString("usergroup"));
				userprofile.setUsercheck(rs.getBoolean("isapractitioner"));
				userprofile.setAppointmentdiary(rs.getBoolean("appointmentdiary"));
				userprofile.setDiarycolor(rs.getString("diarycolor"));
				userprofile.setDiarycolumnposition(rs.getString("diarycolumnposition"));
				userprofile.setCompressionrate(rs.getInt("compressionrate"));
				userprofile.setOnlinename(rs.getString("onlinename"));
				userprofile.setIsavailableonline(rs.getBoolean("isavailableonline"));
				userprofile.setLoginsystem(rs.getBoolean("loginsystem"));
				userprofile.setUserid(rs.getString("userid"));
				userprofile.setLastchanged(rs.getString("lastchanged"));
				userprofile.setChangefre(rs.getInt("changefre"));
				userprofile.setAppointmentbookingcontem(rs.getString("appointmentbookingcontem"));
				userprofile.setAppointmentbookingdnatem(rs.getString("appointmentbookingdnatem"));
				userprofile.setEmail(rs.getString("email"));
				userprofile.setMobile(rs.getString("mobile"));
				userprofile.setApmremote(rs.getBoolean("apmremote"));
				userprofile.setOnlinebooking(rs.getBoolean("onlinebooking"));
				userprofile.setId(selectedid);
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return userprofile;
	}


	public boolean isColorExist(String diarycolor) {
		PreparedStatement preparedStatement = null;
		
		boolean result = false;
		String sql = "select diarycolor,color,colorcode from apm_user,apm_clinic_location,apm_appointment_type where diarycolor = '"+diarycolor+"' or color = '"+diarycolor+"' or colorcode = '"+diarycolor+"';";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = true;
			}
		}catch (Exception e) {
			
		}
		
		
		return result;
	}


	public ArrayList<String> getJobTitleList() {
		PreparedStatement preparedStatement = null;
		ArrayList<String>list = new ArrayList<String>();
		String sql = "select jobtitle from job_title";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				String jobtitle = rs.getString(1);
			
				list.add(jobtitle);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public int insertJobTitle(UserProfile userProfile, String jobTitle) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into job_title(jobtitle)values(?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, jobTitle);
			
			
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	
}
