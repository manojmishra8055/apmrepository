package com.apm.ThirdParties.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.DiaryManagement.eu.bi.AppointmentDiaryReportDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCAppointmentDiaryReportDAO;
import com.apm.DiaryManagement.eu.entity.AppointmentDiaryReport;
import com.apm.DiaryManagement.web.form.AppointmentDiaryReportForm;
import com.apm.ThirdParties.eu.bi.ThirdPartyDAO;
import com.apm.ThirdParties.eu.blogic.jdbc.JDBCThirdPartyDAO;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.ThirdParties.web.form.ThirdPartyForm;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ThirdPartyAction extends BaseAction implements Preparable, ModelDriven<ThirdPartyForm> {

	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	
	ThirdPartyForm thirdPartyForm = new ThirdPartyForm();
	private Pagination pagination = new Pagination(10, 1);
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
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
			ArrayList<ThirdParty>thirdPartyTypeList = thirdPartyDAO.getThirdPartyList();
			
			thirdPartyForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyForm.setThirdPartyName(thirdPartyForm.getThirdPartyName());
			
			ArrayList<ThirdParty>thirdPartyDetailList = thirdPartyDAO.getThirdPartyDetailsList();
			thirdPartyForm.setThirdPartyDetailList(thirdPartyDetailList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
	 
		return SUCCESS;
	}

public String addDetail(){
	String type = request.getParameter("type");
	thirdPartyForm.setType(type);
	return "addThirdPartyDetail";
}

public String saveDetails() throws SQLException{
	String type = thirdPartyForm.getType();
	ThirdParty thirdParty = new ThirdParty();
	//Personal Details field
	
	thirdParty.setType(type);
	thirdParty.setName(thirdPartyForm.getName());
	thirdParty.setSalutation(thirdPartyForm.getSalutation());
	thirdParty.setTitle(thirdPartyForm.getTitle());
	thirdParty.setDepartment(thirdPartyForm.getDepartment());
	thirdParty.setSearchName(thirdPartyForm.getSearchName());
	thirdParty.setTelephoneLine(thirdPartyForm.getTelephoneLine());
	thirdParty.setEmail(thirdPartyForm.getEmail());
	thirdParty.setEmailCc(thirdPartyForm.getEmailCc());
	thirdParty.setNotes(thirdPartyForm.getNotes());
	thirdParty.setCompanyDetails(thirdPartyForm.getCompanyDetails());
	
	//Company Details field
	
	thirdParty.setCompanyName(thirdPartyForm.getCompanyName());
	thirdParty.setAddress(thirdPartyForm.getAddress());
	thirdParty.setTown(thirdPartyForm.getTown());
	thirdParty.setCountry(thirdPartyForm.getCountry());
	thirdParty.setPostcode(thirdPartyForm.getPostcode());
	thirdParty.setCompnyTelephone(thirdPartyForm.getCompnyTelephone());
	thirdParty.setFax(thirdPartyForm.getFax());
	thirdParty.setWeb(thirdPartyForm.getWeb());
	thirdParty.setReferenceNo(thirdPartyForm.getReferenceNo());
	thirdParty.setCompnyEmail(thirdPartyForm.getCompnyEmail());
	
	//Account Setting
	
	thirdParty.setWarningMsg(thirdPartyForm.getWarningMsg());
	thirdParty.setAccountsNotes(thirdPartyForm.getAccountsNotes());
	thirdParty.setAccountMustBeInCredit(thirdPartyForm.isAccountMustBeInCredit());
	thirdParty.setAccountCreditLimit(thirdPartyForm.getAccountCreditLimit());
	thirdParty.setAccountWarningLimit(thirdPartyForm.getAccountWarningLimit());
	
	//Contact Preference
	
	thirdParty.setDefaultApmtBookingConfmTemp(thirdPartyForm.getDefaultApmtBookingConfmTemp());
	thirdParty.setConfContactEmail(thirdPartyForm.getConfContactEmail());
	thirdParty.setDefaultApmtDnaTemp(thirdPartyForm.getDefaultApmtDnaTemp());
	thirdParty.setDnaContactEmail(thirdPartyForm.getDnaContactEmail());
	
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
	
	int result = thirdPartyDAO.saveDetails(type,thirdParty);
	}
	catch (Exception e) {
		
	}
	finally{
		
		connection.close();
	}
	return "saveDetails";
}
public String showList() throws SQLException{
	//String type = request.getParameter("type");
	String type = thirdPartyForm.getName();
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
		ArrayList<ThirdParty>thirdPartyTypeList = thirdPartyDAO.getThirdPartyList();
		thirdPartyForm.setThirdPartyTypeList(thirdPartyTypeList);
		thirdPartyForm.setName(type);
		
		
		ArrayList<ThirdParty>thirdPartyDetailList = thirdPartyDAO.getThirdPartyDetailsList(type);
		
		
		
		thirdPartyForm.setThirdPartyDetailList(thirdPartyDetailList);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		
		connection.close();
	}
	return SUCCESS;
}

public String editDetail(){
	return "editThirdPartyDetail";
}

public String updateDetails() throws SQLException{
	String type = thirdPartyForm.getType();
	ThirdParty thirdParty = new ThirdParty();
	
	int id = thirdPartyForm.getId();
	//Personal Details field
	
	thirdParty.setType(type);
	thirdParty.setName(thirdPartyForm.getName());
	thirdParty.setSalutation(thirdPartyForm.getSalutation());
	thirdParty.setTitle(thirdPartyForm.getTitle());
	thirdParty.setDepartment(thirdPartyForm.getDepartment());
	thirdParty.setSearchName(thirdPartyForm.getSearchName());
	thirdParty.setTelephoneLine(thirdPartyForm.getTelephoneLine());
	thirdParty.setEmail(thirdPartyForm.getEmail());
	thirdParty.setEmailCc(thirdPartyForm.getEmailCc());
	thirdParty.setNotes(thirdPartyForm.getNotes());
	thirdParty.setCompanyDetails(thirdPartyForm.getCompanyDetails());
	
	//Company Details field
	
	thirdParty.setCompanyName(thirdPartyForm.getCompanyName());
	thirdParty.setAddress(thirdPartyForm.getAddress());
	thirdParty.setTown(thirdPartyForm.getTown());
	thirdParty.setCountry(thirdPartyForm.getCountry());
	thirdParty.setPostcode(thirdPartyForm.getPostcode());
	thirdParty.setCompnyTelephone(thirdPartyForm.getCompnyTelephone());
	thirdParty.setFax(thirdPartyForm.getFax());
	thirdParty.setWeb(thirdPartyForm.getWeb());
	thirdParty.setReferenceNo(thirdPartyForm.getReferenceNo());
	thirdParty.setCompnyEmail(thirdPartyForm.getCompnyEmail());
	
	//Account Setting
	
	thirdParty.setWarningMsg(thirdPartyForm.getWarningMsg());
	thirdParty.setAccountsNotes(thirdPartyForm.getAccountsNotes());
	thirdParty.setAccountMustBeInCredit(thirdPartyForm.isAccountMustBeInCredit());
	thirdParty.setAccountCreditLimit(thirdPartyForm.getAccountCreditLimit());
	thirdParty.setAccountWarningLimit(thirdPartyForm.getAccountWarningLimit());
	
	//Contact Preference
	
	thirdParty.setDefaultApmtBookingConfmTemp(thirdPartyForm.getDefaultApmtBookingConfmTemp());
	thirdParty.setConfContactEmail(thirdPartyForm.getConfContactEmail());
	thirdParty.setDefaultApmtDnaTemp(thirdPartyForm.getDefaultApmtDnaTemp());
	thirdParty.setDnaContactEmail(thirdPartyForm.getDnaContactEmail());
	
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
	
	int result = thirdPartyDAO.editDetails(type,id,thirdParty);
	}
	catch (Exception e) {
		
	}
	finally{
		
		connection.close();
	}
	return null;
}

public String deleteDetails() throws SQLException{
	int id = Integer.parseInt(request.getParameter("selectedid"));
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
	
	int result = thirdPartyDAO.deleteDetail(id);
	}
	catch (Exception e) {
		
	}
	finally{
		
		connection.close();
	}
	return "deleteSucess";
}

public String typeList() throws SQLException{
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
		int totalCount = thirdPartyDAO.getThirdPartyTypeCount();
		pagination.setPreperties(totalCount);
		ArrayList<ThirdParty>thirdPartyTypeList = thirdPartyDAO.getThirdPartyList(pagination);
		
		
		
		pagination.setPage_records(thirdPartyTypeList.size());
		thirdPartyForm.setTotalRecords(totalCount);
		thirdPartyForm.setPagerecords(Integer.toString(pagination.getPage_records()));
		thirdPartyForm.setThirdPartyTypeList(thirdPartyTypeList);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		
		connection.close();
	}
	return "typeList";
	
}

public String addType(){
	return "addType";
}
public String saveType() throws SQLException{
	ThirdParty thirdParty = new ThirdParty();
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
		
		thirdParty.setType(thirdPartyForm.getType());
		thirdParty.setDescription(thirdPartyForm.getDescription());
		
		int result = thirdPartyDAO.saveType(thirdParty);
		
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		
		connection.close();
	}
	return "saveType";
}

public String editType() throws SQLException{
	int id = Integer.parseInt(request.getParameter("selectedid"));
	ThirdParty thirdParty = new ThirdParty();
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
	
		thirdParty = thirdPartyDAO.getTypeDetail(id);
		thirdPartyForm.setType(thirdParty.getType());
		thirdPartyForm.setId(thirdParty.getId());
		thirdPartyForm.setDescription(thirdParty.getDescription());
	}
	catch (Exception e) {
		
	}
	finally{
		
		connection.close();
	}
	return "editTypePage";
}
public String updateType() throws SQLException{
	ThirdParty thirdParty = new ThirdParty();
	Connection connection = null;
	int id = thirdPartyForm.getId();
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
		
		thirdParty.setType(thirdPartyForm.getType());
		thirdParty.setDescription(thirdPartyForm.getDescription());
		
		int result = thirdPartyDAO.updateType(id,thirdParty);
		
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		
		connection.close();
	}
	return "updateType";
}

public String deleteType() throws SQLException{
	ThirdParty thirdParty = new ThirdParty();
	Connection connection = null;
	int id = Integer.parseInt(request.getParameter("selectedid"));
	try{
		connection = Connection_provider.getconnection();
		ThirdPartyDAO  thirdPartyDAO = new JDBCThirdPartyDAO(connection);
		
		
		
		int result = thirdPartyDAO.deleteType(id);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		
		connection.close();
	}
	return "deleteType";
}

public void prepare() throws Exception {
	// TODO Auto-generated method stub
	
}

public ThirdPartyForm getModel() {
	// TODO Auto-generated method stub
	return thirdPartyForm;
}
	
}
