package com.apm.Registration.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import com.apm.DiaryManagement.eu.bi.ClientDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCClientDAO;
import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.Registration.eu.bi.UserProfileDAO;

import com.apm.Registration.eu.blogic.jdbc.JDBCUserProfileDAO;

import com.apm.Registration.eu.entity.UserProfile;
import com.apm.Registration.web.form.UserProfileForm;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserProfileAction extends BaseAction implements Preparable, ModelDriven<UserProfileForm>  {
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	UserProfileForm userProfileForm = new UserProfileForm();
	private Pagination pagination = new Pagination(20, 1);
		public Pagination getPagination() {
			return pagination;
		}


		public void setPagination(Pagination pagination) {
			this.pagination = pagination;
		}
	
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	
	
	public String execute() throws Exception {
		
		if(!verifyLogin(request)){
			return "login";
		}
		
		//show practice manager
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
			
			
			int totalCount = userProfileDAO.getUserprofileCount(userProfileForm.getSearchText(),loginInfo.getId());
			pagination.setPreperties(totalCount);
			
			
			
			ArrayList<UserProfile>userProfile = userProfileDAO.getUserProfileList(pagination,userProfileForm.getSearchText(),loginInfo.getId());
			userProfileForm.setUserProfileList(userProfile);
			pagination.setPage_records(userProfile.size());
			userProfileForm.setTotalRecords(totalCount);
			userProfileForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
	 
		return SUCCESS;
	}
	
	public String input() throws SQLException{
		Connection connection = null;
		Client client = new Client();
		
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> jobTitleList = new ArrayList<String>();
		try{
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			
			
			initialList = clientDAO.getInitialList();
			userProfileForm.setInitialList(initialList);
			
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			jobTitleList = userProfileDAO.getJobTitleList();
			jobTitleList.add("Other");
			userProfileForm.setJobTitleList(jobTitleList);
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
finally{
			
			connection.close();
		}
		return "input";
	}
	
	public String save() throws SQLException{
		
		//save practice manager
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			
			//start coding
			
			//connection = Connection_provider.getconnection();
			//practiceManagerDAO practitionerDAO = new JDBCParcticeManagerDAO(connection);
			 
			UserProfile userprofile = new UserProfile();
			
			userprofile.setFirstname(userProfileForm.getFirstname());
			userprofile.setLastname(userProfileForm.getLastname());
			userprofile.setInitial(userProfileForm.getInitial());
			
			String other = "Other";
			if(userProfileForm.getJobtitle().equalsIgnoreCase(other))
			{
				userProfileForm.setJobtitle(userProfileForm.getOtherJobTitle());
			}
			
			userprofile.setJobtitle(userProfileForm.getJobtitle());
			/*userprofile.setDiscription(userProfileForm.getDiscription());*/
			userprofile.setDiciplineName(userProfileForm.getDiciplineName());
			userprofile.setRegisterno(userProfileForm.getRegisterno());
			userprofile.setUsergroup(userProfileForm.getUsergroup());
			
						
			userprofile.setUsercheck(userProfileForm.isUsercheck());
			userprofile.setAppointmentdiary(userProfileForm.isAppointmentdiary());
			userprofile.setDiarycolor(userProfileForm.getDiarycolor());
			userprofile.setDiarycolumnposition(userProfileForm.getDiarycolumnposition());
			userprofile.setCompressionrate(userProfileForm.getCompressionrate());
			userprofile.setOnlinename(userProfileForm.getOnlinename());
			userprofile.setIsavailableonline(userProfileForm.isIsavailableonline());
			userprofile.setLoginsystem(userProfileForm.isLoginsystem());
			userprofile.setUserid(userProfileForm.getUserId());
			userprofile.setPassword(userProfileForm.getPassword());
			userprofile.setLastchanged(userProfileForm.getLastchanged());
			userprofile.setChangefre(userProfileForm.getChangefre());
			userprofile.setAppointmentbookingcontem(userProfileForm.getAppointmentbookingcontem());
			userprofile.setAppointmentbookingdnatem(userProfileForm.getAppointmentbookingdnatem());
			userprofile.setEmail(userProfileForm.getEmail());
			userprofile.setMobile(userProfileForm.getMobile());
			userprofile.setApmremote(userProfileForm.isApmremote());
			
			userprofile.setOnlinebooking(userProfileForm.isOnlinebooking());
			
			userprofile.setUserType(4);
			
			/*boolean usercheck;
			usercheck=userProfileForm.isUsercheck();
			
			if(usercheck)
			{
				userprofile.setUserType(userProfileForm.getUserType());
			}
			else
			{
				userprofile.setUserType(6);
			}
					*/			
			
			int reult = userProfileDAO.saveUserprofile(userprofile,loginInfo.getId());
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		return "save";
	}
	
	
	public String updatesave () throws SQLException
	{
		if(!verifyLogin(request)){
			return "login";
		}
		
		int selectedid = Integer.parseInt(request.getParameter("id"));
		Connection connection = null;
		
		try{
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.ServletActionContext.HTTP_REQUEST);
			UserProfile UserProfileForm = new UserProfile();
			/*int selectedid = practicemanagerForm.getId();*/
			
			 connection = Connection_provider.getconnection();

			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			
			
			UserProfileForm.setFirstname(userProfileForm.getFirstname());
			UserProfileForm.setLastname(userProfileForm.getLastname());
			UserProfileForm.setInitial(userProfileForm.getInitial());
			String other = "Other";
			if(userProfileForm.getJobtitle().equalsIgnoreCase(other))
			{
				userProfileForm.setJobtitle(userProfileForm.getOtherJobTitle());
			}
			UserProfileForm.setJobtitle(userProfileForm.getJobtitle());
			/*UserProfileForm.setDiscription(userProfileForm.getDiscription());*/
			UserProfileForm.setDiciplineName(userProfileForm.getDiciplineName());
			UserProfileForm.setRegisterno(userProfileForm.getRegisterno());
			UserProfileForm.setUsergroup(userProfileForm.getUsergroup());
			UserProfileForm.setUsercheck(userProfileForm.isUsercheck());
			UserProfileForm.setAppointmentdiary(userProfileForm.isAppointmentdiary());
			UserProfileForm.setDiarycolor(userProfileForm.getDiarycolor());
			UserProfileForm.setDiarycolumnposition(userProfileForm.getDiarycolumnposition());
			UserProfileForm.setCompressionrate(userProfileForm.getCompressionrate());
			UserProfileForm.setOnlinename(userProfileForm.getOnlinename());
			UserProfileForm.setIsavailableonline(userProfileForm.isIsavailableonline());
			UserProfileForm.setLoginsystem(userProfileForm.isLoginsystem());
			UserProfileForm.setUserid(userProfileForm.getUserId());
			UserProfileForm.setPassword(userProfileForm.getPassword());
			UserProfileForm.setLastchanged(userProfileForm.getLastchanged());
			UserProfileForm.setChangefre(userProfileForm.getChangefre());
			UserProfileForm.setAppointmentbookingcontem(userProfileForm.getAppointmentbookingcontem());
			UserProfileForm.setAppointmentbookingdnatem(userProfileForm.getAppointmentbookingdnatem());
			UserProfileForm.setEmail(userProfileForm.getEmail());
			UserProfileForm.setMobile(userProfileForm.getMobile());
			UserProfileForm.setApmremote(userProfileForm.isApmremote());
			UserProfileForm.setOnlinebooking(userProfileForm.isOnlinebooking());
		
			
			UserProfileForm.setId(selectedid);
			int result=userProfileDAO.updateUserprofile(UserProfileForm);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		return "updatesave";
	}
	
	public String edit() throws SQLException{
		int selectedid = Integer.parseInt(request.getParameter("id"));
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			
			ArrayList<String> initialList = new ArrayList<String>();
			ArrayList<String> jobTitleList = new ArrayList<String>();
			
				
				connection = Connection_provider.getconnection();
				ClientDAO clientDAO = new JDBCClientDAO(connection);
				
				
				initialList = clientDAO.getInitialList();
				userProfileForm.setInitialList(initialList);
				
				jobTitleList = userProfileDAO.getJobTitleList();
				jobTitleList.add("Other");
				userProfileForm.setJobTitleList(jobTitleList);
			
			//start coding
			UserProfile userprofile = userProfileDAO.getUserprofileDetails(selectedid);
			
			
			/*userprofile.setUserprofileId(userprofile.getUserprofileId());*/
			userProfileForm.setFirstname(userprofile.getFirstname());
			userProfileForm.setLastname(userprofile.getLastname());
			userProfileForm.setInitial(userprofile.getInitial());
			userProfileForm.setJobtitle(userprofile.getJobtitle());
			/*userProfileForm.setDiscription(userprofile.getDiscription());*/
			userProfileForm.setDiciplineName(userprofile.getDiciplineName());
			userProfileForm.setRegisterno(userprofile.getRegisterno());
			userProfileForm.setUsergroup(userprofile.getUsergroup());
			userProfileForm.setUsercheck(userprofile.isUsercheck());
			userProfileForm.setAppointmentdiary(userprofile.isAppointmentdiary());
			userProfileForm.setDiarycolor(userprofile.getDiarycolor());
			userProfileForm.setDiarycolumnposition(userprofile.getDiarycolumnposition());
			userProfileForm.setCompressionrate(userprofile.getCompressionrate());
			userProfileForm.setOnlinename(userprofile.getOnlinename());
			userProfileForm.setIsavailableonline(userprofile.isIsavailableonline());
			userProfileForm.setLoginsystem(userprofile.isLoginsystem());
			userProfileForm.setUserId(userprofile.getUserid());
			/*userProfileForm.setPassword(userprofile.getPassword());*/
			userProfileForm.setLastchanged(userprofile.getLastchanged());
			userProfileForm.setChangefre(userprofile.getChangefre());
			userProfileForm.setAppointmentbookingcontem(userprofile.getAppointmentbookingcontem());
			userProfileForm.setAppointmentbookingdnatem(userprofile.getAppointmentbookingdnatem());
			userProfileForm.setEmail(userprofile.getEmail());
			userProfileForm.setMobile(userprofile.getMobile());
			userProfileForm.setApmremote(userprofile.isApmremote());
			userProfileForm.setOnlinebooking(userprofile.isOnlinebooking());
			
			
			userProfileForm.setId(userprofile.getId());
			
			//userProfileForm.setDiciplineName("Dummy three");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		
		return "edit";
	}
	
	public String delete() throws SQLException{
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			//UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			
			//start coding
			
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.ServletActionContext.HTTP_REQUEST);
			int selectedid= Integer.parseInt(request.getParameter("id"));
			//UserProfileDAO userprofileDAO = new JDBCUserProfileDAO(connection);
			
			
			/*int deleteUserProfile = userProfileDAO.deleteUserprofile(selectedid);*/
			int result = userProfileDAO.deleteUserprofile(selectedid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		
		return "delete";
	}
	
	
	public UserProfileForm getModel() {
		
		return userProfileForm;
	}


	public void prepare() throws Exception {
		
		ArrayList<String>diciplineList = new ArrayList<String>();
		diciplineList.add("Dummy One");
		diciplineList.add("Dummy two");
		diciplineList.add("Dummy three");
		diciplineList.add("Dummy four");
		
		userProfileForm.setDiciplineList(diciplineList);
		
		ArrayList<String>diarycolorList = new ArrayList<String>();
		diarycolorList.add("Green");
		diarycolorList.add("Blue");
		diarycolorList.add("Red");
		diarycolorList.add("White");
		diarycolorList.add("Maroon");
		diarycolorList.add("Yellow");
		
		userProfileForm.setDiarycolorList(diarycolorList);
		
		ArrayList<String>abctList = new ArrayList<String>();
		abctList.add("Appointment Confirmation");
		abctList.add("Appointment Follow Up Reminder");
		abctList.add("Appiontment Reminder");
		abctList.add("Appt Confirmation - Plates");
		abctList.add("Diabetic Assessment Reminder");
		abctList.add("Patient Cancellation");
		
		userProfileForm.setAbctList(abctList);
		
		ArrayList<String>adtList = new ArrayList<String>();
		adtList.add("Appointment Confirmation");
		adtList.add("Appointment Follow Up Reminder");
		adtList.add("Appiontment Reminder");
		adtList.add("Appt Confirmation - Plates");
		adtList.add("Diabetic Assessment Reminder");
		adtList.add("Patient Cancellation");
		
		userProfileForm.setAdtList(adtList);
		
	}
	
	public String addOtherJobTitle() throws SQLException{
		String jobTitle = request.getParameter("jobtitle");
		Connection connection = null;
		try{
			UserProfile userProfile = new UserProfile();
			connection = Connection_provider.getconnection();
			UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			
			
			int result = userProfileDAO.insertJobTitle(userProfile,jobTitle);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			
			connection.close();
		}
		return null;
	}

}
