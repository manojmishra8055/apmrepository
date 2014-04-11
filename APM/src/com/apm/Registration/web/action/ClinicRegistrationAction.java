package com.apm.Registration.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.apm.Registration.eu.bi.ClinicDAO;
import com.apm.Registration.eu.bi.UserProfileDAO;
import com.apm.Registration.eu.blogic.jdbc.JDBCClinicDAO;
import com.apm.Registration.eu.blogic.jdbc.JDBCUserProfileDAO;
import com.apm.Registration.eu.entity.Clinic;
import com.apm.Registration.eu.entity.Location;
import com.apm.Registration.web.form.ClinicRegistrationForm;

import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class ClinicRegistrationAction extends BaseAction implements ModelDriven<ClinicRegistrationForm> {
	
	ClinicRegistrationForm clinicRegistrationForm = new ClinicRegistrationForm();
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	
	Pagination pagination = new Pagination(10,1);
	
	
	@SkipValidation
	public String execute() throws Exception {
		
		if(!verifyLogin(request)){
			return "login";
		}
		// TODO Auto-generated method stub
		Connection connection = Connection_provider.getconnection();
		ClinicDAO clinicDAO = new JDBCClinicDAO(connection);
		LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
		
		//pagination
		int totalCount = clinicDAO.getCliniclistCount(clinicRegistrationForm.getSearchText());
		pagination.setPreperties(totalCount);
		
		ArrayList<Clinic>clinicList = clinicDAO.getClinicList(pagination,clinicRegistrationForm.getSearchText());
		clinicRegistrationForm.setClinicList(clinicList);

		
		return SUCCESS;
	}
	
	@SkipValidation
	public String save() throws SQLException{
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			ClinicDAO clinicDAO = new JDBCClinicDAO(connection);
			Clinic clinic = new Clinic();
			
			clinic.setClinicName(clinicRegistrationForm.getClinicName());
			clinic.setClinicOwner(clinicRegistrationForm.getClinicOwner());
			clinic.setEmail(clinicRegistrationForm.getEmail());
			clinic.setMobileNo(clinicRegistrationForm.getMobileNo());
			clinic.setLandLine(clinicRegistrationForm.getLandLine());
			
			clinic.setUserId(clinicRegistrationForm.getUserId());
			clinic.setPassword(clinicRegistrationForm.getPassword());
			
			
			
			
			
			for(String str : clinicRegistrationForm.getPkgsubscription()){
				
				if(str.equals(Constants.STANDALONE)){
					clinic.setStandalone(true);
				}else if(str.equals(Constants.HOSTED_DB)){
					clinic.setHostedDB(true);
				}else if(str.equals(Constants.ONLINE_SINGLE_DEVICE)){
					clinic.setOnlineSingleDevice(true);
				}else if(str.equals(Constants.ONLINE_MULTI_DEVICE)){
					clinic.setOnlineMultiDevice(true);
				}
				
				
			}
			
			for(String str : clinicRegistrationForm.getFunSubscription()){
				
				if(str.equals(Constants.DIARY_MANAGEMENT)){
					clinic.setDiaryManagement(true);
				}else if(str.equals(Constants.APPOINTMENT_BOOKING)){
					clinic.setAppointmentBooking(true);
				}else if(str.equals(Constants.BASIC_FINANCE)){
					clinic.setBasicFinance(true);
				}else if(str.equals(Constants.FULL_FINANCE)){
					clinic.setFullFinance(true);
				}else if(str.equals(Constants.MEDICAL_RECORD)){
					clinic.setMedicalRecord(true);
				}else if(str.equals(Constants.CLINIC_RESOURCE_MANAGEMENT)){
					clinic.setClinicResourceMngment(true);
				}else if(str.equals(Constants.CLINIC_PAYROLL_MANAGEMENT)){
					clinic.setClinicPayrollMngment(true);
				}
			}
			
			int userid = clinicDAO.saveClinic(clinic);
			
			int result = clinicDAO.saveAdminAccessPassword(userid, clinic);
			
			for(Location location : clinicRegistrationForm.getLocation()){
				clinic = new Clinic();
				clinic.setCountry(location.getCountry());
				clinic.setCity(location.getCity());
				clinic.setAddress(location.getAddress());
				clinic.setPinCode(location.getPinCode());
				clinic.setLocationname(location.getLocationname());
				clinic.setColorName(location.getColorName());
				
				result = clinicDAO.saveLocation(userid,clinic);
			}
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return "save";
	}
	
	@SkipValidation
	public String edit() throws SQLException{
		int selectedid = Integer.parseInt(request.getParameter("id"));
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			ClinicDAO clinicListDAO = new JDBCClinicDAO(connection);
			ArrayList<Clinic>colorList = new ArrayList<Clinic>();
			//start coding
			Clinic cliniclist = clinicListDAO.getCliniclistDetails(selectedid);
			colorList = clinicListDAO.getColorList();
			
			
			
			/*userprofile.setUserprofileId(userprofile.getUserprofileId());*/
			clinicRegistrationForm.setClinicName(cliniclist.getClinicName());
			clinicRegistrationForm.setFirstname(cliniclist.getFirstName());
			clinicRegistrationForm.setLastname(cliniclist.getLastName());
			clinicRegistrationForm.setUserId(cliniclist.getUserId());
			clinicRegistrationForm.setPassword(cliniclist.getPassword());
			clinicRegistrationForm.setEmail(cliniclist.getEmail());
			clinicRegistrationForm.setMobileNo(cliniclist.getMobileNo());
			clinicRegistrationForm.setLandLine(cliniclist.getLandLine());
			clinicRegistrationForm.setClinicOwner(cliniclist.getClinicOwner());
			clinicRegistrationForm.setStandalone(cliniclist.isStandalone());
			clinicRegistrationForm.setHostedDB(cliniclist.isHostedDB());
			clinicRegistrationForm.setOnlineSingleDevice(cliniclist.isOnlineSingleDevice());
			clinicRegistrationForm.setOnlineMultiDevice(cliniclist.isOnlineMultiDevice());
			clinicRegistrationForm.setDiaryManagement(cliniclist.isDiaryManagement());
			clinicRegistrationForm.setAppointmentBooking(cliniclist.isAppointmentBooking());
			clinicRegistrationForm.setBasicFinance(cliniclist.isBasicFinance());
			clinicRegistrationForm.setFullFinance(cliniclist.isFullFinance());
			clinicRegistrationForm.setMedicalRecord(cliniclist.isMedicalRecord());
			clinicRegistrationForm.setClinicResourceMngment(cliniclist.isClinicResourceMngment());
			clinicRegistrationForm.setClinicPayrollMngment(cliniclist.isClinicPayrollMngment());
			
			clinicRegistrationForm.setId(cliniclist.getId());
			ArrayList<Clinic> clinicLocationlist = new ArrayList<Clinic>();
			 clinicLocationlist = clinicListDAO.getClinicLocationList(selectedid);
			clinicRegistrationForm.setCliniclocationList(clinicLocationlist);
			
			int locationcount = 0;
			locationcount = clinicLocationlist.size();
			
			
			
			
			
			
			session.setAttribute("colorList", colorList);
			session.setAttribute("clinicLocationlist", clinicLocationlist);
			session.setAttribute("locationcount", locationcount);
			
			//userProfileForm.setDiciplineName("Dummy three");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		
		return "edit";
	}
	@SkipValidation
	public String updatesave() throws SQLException
	{
		if(!verifyLogin(request)){
			return "login";
		}
		
		int selectedid = Integer.parseInt(request.getParameter("id"));
		Connection connection = null;
		
		try{
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.ServletActionContext.HTTP_REQUEST);
			Clinic ClinicListForm = new Clinic(); 
			/*int selectedid = practicemanagerForm.getId();*/
			
			 connection = Connection_provider.getconnection();

			ClinicDAO clinicListDAO = new JDBCClinicDAO(connection);
			
			String color= clinicRegistrationForm.getColorName();
			ClinicListForm.setClinicName(clinicRegistrationForm.getClinicName());
			ClinicListForm.setFirstName(clinicRegistrationForm.getFirstname());
			ClinicListForm.setLastName(clinicRegistrationForm.getLastname());
			/*UserProfileForm.setDiscription(userProfileForm.getDiscription());*/
			ClinicListForm.setUserId(clinicRegistrationForm.getUserId());
			ClinicListForm.setPassword(clinicRegistrationForm.getPassword());
			ClinicListForm.setEmail(clinicRegistrationForm.getEmail());
			ClinicListForm.setMobileNo(clinicRegistrationForm.getMobileNo());
			ClinicListForm.setLandLine(clinicRegistrationForm.getLandLine());
			ClinicListForm.setClinicOwner(clinicRegistrationForm.getClinicOwner());
			ClinicListForm.setStandalone(clinicRegistrationForm.isStandalone());
			ClinicListForm.setHostedDB(clinicRegistrationForm.isHostedDB());
			ClinicListForm.setOnlineSingleDevice(clinicRegistrationForm.isOnlineSingleDevice());
			ClinicListForm.setOnlineMultiDevice(clinicRegistrationForm.isOnlineMultiDevice());
			ClinicListForm.setDiaryManagement(clinicRegistrationForm.isDiaryManagement());
			ClinicListForm.setAppointmentBooking(clinicRegistrationForm.isAppointmentBooking());
			ClinicListForm.setBasicFinance(clinicRegistrationForm.isBasicFinance());
			ClinicListForm.setFullFinance(clinicRegistrationForm.isFullFinance());
			ClinicListForm.setMedicalRecord(clinicRegistrationForm.isMedicalRecord());
			ClinicListForm.setClinicResourceMngment(clinicRegistrationForm.isClinicResourceMngment());
			ClinicListForm.setClinicPayrollMngment(clinicRegistrationForm.isClinicPayrollMngment());
			
		
			
			ClinicListForm.setId(selectedid);
			int result=clinicListDAO.updateCliniclist(ClinicListForm);
			
			
			for(Location location : clinicRegistrationForm.getLocation()){
				ClinicListForm = new Clinic(); 
				ClinicListForm.setLocationid(location.getLocationid());
				ClinicListForm.setCountry(location.getCountry());
				ClinicListForm.setCity(location.getCity());
				ClinicListForm.setAddress(location.getAddress());
				ClinicListForm.setPinCode(location.getPinCode());
				ClinicListForm.setLocationname(location.getLocationname());
				ClinicListForm.setColorName(location.getColorName());
				
				int locationid = location.getLocationid();
				
				result = clinicListDAO.saveLocation(selectedid,locationid,ClinicListForm);
			}
			
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
	@SkipValidation
	public String delete() throws SQLException{
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			//UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
			ClinicDAO clinicListDAO = new JDBCClinicDAO(connection);
			
			//start coding
			
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.ServletActionContext.HTTP_REQUEST);
			int selectedid= Integer.parseInt(request.getParameter("id"));
			//UserProfileDAO userprofileDAO = new JDBCUserProfileDAO(connection);
			
			
			/*int deleteUserProfile = userProfileDAO.deleteUserprofile(selectedid);*/
			int result = clinicListDAO.deleteClinicList(selectedid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		
		return "delete";
	}
	
	
	public void validate() {
    	
		try{
		
		for(Location location : clinicRegistrationForm.getLocation()){
			Clinic clinic = new Clinic();
			clinic.setCountry(location.getCountry());
			clinic.setCity(location.getCity());
			clinic.setAddress(location.getAddress());
			clinic.setPinCode(location.getPinCode());
			clinic.setLocationname(location.getLocationname());
			clinic.setColorName(location.getColorName());
			String locationvalue = location.getLocationname();
			 if (locationvalue.equals("")) {
		            addActionError("Enter Location");
			 }
			 if(location.getCountry().equals("")){
				 addActionError("Enter Country");
			 }
			 if(location.getCity().equals("")){
				 addActionError("Enter City");
			 }
			 if(location.getAddress().equals("")){
				 addActionError("Enter Address");
			 }
			 
			 else{	// else set response 'true'
					response.getWriter().write("true");
				}
			
		}
		
		Connection connection = Connection_provider.getconnection();
		LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
		UserProfileDAO userProfileDAO = new JDBCUserProfileDAO(connection);
		
		for(Location location : clinicRegistrationForm.getLocation()){
		
		String diarycolor = location.getColorName();
		
		
		boolean colorExist = userProfileDAO.isColorExist(diarycolor);
		
		
		if(colorExist){
			 addActionError("Try another color");
		}else{	// else set response 'true'
			response.getWriter().write("true");
		}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		 
   }
	
	public String input() throws Exception {
		
		return INPUT;
	}
	
	public ClinicRegistrationForm getModel() {
		// TODO Auto-generated method stub
		return clinicRegistrationForm;
	}


	public Pagination getPagination() {
		return pagination;
	}


	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
