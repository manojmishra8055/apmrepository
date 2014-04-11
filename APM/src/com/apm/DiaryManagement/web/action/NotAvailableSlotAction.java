package com.apm.DiaryManagement.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.Appointment.eu.entity.Appointment;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.bi.ClientDAO;
import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.bi.NotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCClientDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCDiaryManagentDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCNotAvailableSlotDAO;

import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.DiaryManagement.web.common.ApmDate;
import com.apm.DiaryManagement.web.common.DateOfWeek;
import com.apm.DiaryManagement.web.common.Month;
import com.apm.DiaryManagement.web.form.NotAvailableSlotForm;

import com.apm.Registration.eu.entity.Location;

import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.DateTimeUtils;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.web.utils.PopulateData;
import com.apm.common.web.utils.PopulateList;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class NotAvailableSlotAction extends BaseAction implements Preparable, ModelDriven<NotAvailableSlotForm> {
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	NotAvailableSlotForm notAvailableSlotForm = new NotAvailableSlotForm();
	private Pagination pagination = new Pagination(10, 1);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	
public String execute() throws Exception {
		
		if(!verifyLogin(request)){
			return "login";
		}
		
		//show practice manager
		Connection connection = null;
		try{
			
			String selecteduserid = request.getParameter("selecteduserid");
			String selectedCommencing = request.getParameter("selectedCommencing");
			System.out.println(selecteduserid);
			
			connection = Connection_provider.getconnection();
			NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
			
			
			
			
			//start coding
			ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId());
			
			notAvailableSlotForm.setUserList(userList);
			notAvailableSlotForm.setDiaryUser(selecteduserid);
			notAvailableSlotForm.setCommencing(selectedCommencing);
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
	 
		return SUCCESS;
	}

public String allUser() throws SQLException{
	if(!verifyLogin(request)){
		
		return "login";
	}
	
	Connection connection = null;
	try{
		
		String selectedCommencing = request.getParameter("selectedCommencing");
		
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
		//start coding
		String commencing  = notAvailableSlotForm.getCommencing();
		String temp[] = commencing.split("/");
		commencing = temp[2] + "-" + temp[1] + "-" + temp[0];
		//ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId(),commencing);
		
		ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId());
		
		notAvailableSlotForm.setUserList(userList);
		notAvailableSlotForm.setDiaryUser("0");
		notAvailableSlotForm.setCommencing(selectedCommencing);
		session.setAttribute("userListSize", userList.size());
		session.setAttribute("allDiaryUser", userList);
		
		
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> sourceOfIntroList = new ArrayList<String>();
		
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			notAvailableSlotForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			notAvailableSlotForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			notAvailableSlotForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			notAvailableSlotForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			notAvailableSlotForm.setInitialList(initialList);
			
			sourceOfIntroList = clientDAO.getSourceOfIntroList();
			notAvailableSlotForm.setSourceOfIntroList(sourceOfIntroList);
			
			
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		
		connection.close();
	}
	return "allUser";
}


public String day() throws SQLException{
	
	if(!verifyLogin(request)){
		return "login";
	}
	
	//show practice manager
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		//start coding
		ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId());
		
		notAvailableSlotForm.setUserList(userList);
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		
		connection.close();
	}
 
	return "day";
}

//set client has arrived
public String setreset() throws SQLException{
	
	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	int status = Integer.parseInt(request.getParameter("status"));
	
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		int result =  notAvailableSlotDAO.updateClientHasArrived(selectedid,status);
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		connection.close();
	}
	
	return null;
}

//set client is being seen
public String clientIsBeingSeen() throws SQLException{

	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	int status = Integer.parseInt(request.getParameter("status"));
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		int result = notAvailableSlotDAO.updateClientIsBeingSeen(selectedid,status);
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		connection.close();
	}
	
	
	return null;
}

public String resetNotArrived() throws SQLException{
	
	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	int status = Integer.parseInt(request.getParameter("status"));
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		int result = notAvailableSlotDAO.updateResetNotArrived(selectedid,status);
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		
		connection.close();
	}
	
	return null;
}


//client did not attent confirmation
public String didnotAttend() throws SQLException{
	
	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	
	String notes = request.getParameter("dnaNotes");
	boolean dna = Boolean.parseBoolean(request.getParameter("dna"));
	String dnaReason = request.getParameter("dnaReason");
	
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		int result = notAvailableSlotDAO.updateDNA(selectedid,notes,dna,dnaReason);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
	
	return null;
}


public NotAvailableSlotForm getModel() {
	
	return notAvailableSlotForm;
}
public String saveAppoinment() throws SQLException{
	Connection connection = null;
	int result = 0;
	
	String slotId = request.getParameter("slotId");
	String commencing = request.getParameter("commencing");
	/* String temp[] = commencing.split("/");
	 commencing = temp[2]+"-"+temp[1]+"-"+temp[0];*/
	String location = request.getParameter("location");
	String room = request.getParameter("room");
	String sTime = request.getParameter("sTime");
	String endTime = request.getParameter("endTime");
	String apmtDuration = request.getParameter("apmtDuration");
	String diaryuserId = request.getParameter("diaryuserId");
	String client = request.getParameter("client");
	String dept = request.getParameter("dept");
	String apmtType = request.getParameter("apmtType");
	String notes = request.getParameter("notes");
	String diaryUser = request.getParameter("diaryUser");
	String clientId = request.getParameter("clientId");
	String treatmentEpisodeId = request.getParameter("treatmentEpisodeId");
	
	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	
	int slotId1 = 0;
	int diaryuserId1 = 0;
	
	if(selectedid == 0){
		slotId1 = Integer.parseInt(slotId);
		diaryuserId1 = Integer.parseInt(diaryuserId);
	}
	
	
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
		notAvailableSlot.setApmtSlotId(slotId1);
		notAvailableSlot.setDiaryUserId(diaryuserId1);
		notAvailableSlot.setDiaryUser(diaryUser);
		notAvailableSlot.setDept(dept);
		notAvailableSlot.setLocation(location);
		notAvailableSlot.setRoom(room);
		notAvailableSlot.setCommencing(commencing);
		notAvailableSlot.setSTime(sTime);
		notAvailableSlot.setEndTime(endTime);
		notAvailableSlot.setApmtDuration(apmtDuration);
		notAvailableSlot.setClient(client);
		notAvailableSlot.setApmtType(apmtType);
		notAvailableSlot.setNotes(notes);
		notAvailableSlot.setClientId(clientId);
		notAvailableSlot.setTreatmentEpisodeId(treatmentEpisodeId);
		
		NotAvailableSlotDAO notAvailableSlotDAO = new  JDBCNotAvailableSlotDAO(connection);
		if(selectedid == 0){
			result = notAvailableSlotDAO.saveAppointment(notAvailableSlot);
			//result = notAvailableSlotDAO.saveCharge(notAvailableSlot,apmtType,result);
		}else{
			int update = notAvailableSlotDAO.updateAppointment(notAvailableSlot,selectedid);
			//int update1 =  notAvailableSlotDAO.updateCharge(notAvailableSlot,apmtType,selectedid);
		}
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	finally{
		connection.close();
	}
	
	return null;
}

public String saveBlock() throws SQLException{
	Connection connection = null;
	int result = 0;
	
	String slotId = request.getParameter("slotId");
	String commencing = request.getParameter("commencing");
	
	 
	String location = request.getParameter("location");
	String room = request.getParameter("room");
	String sTime = request.getParameter("sTime");
	String endTime = request.getParameter("endTime");
	String apmtDuration = request.getParameter("apmtDuration");
	String diaryuserId = request.getParameter("diaryuserId");
	
	String reasonforblock = request.getParameter("reasonforblock");
	String notes = request.getParameter("notes");
	String diaryUser = request.getParameter("diaryUser");
	String status = request.getParameter("status");
	
	int selectedid = Integer.parseInt(request.getParameter("selectedid"));
	int slotId1 = 0;
	int diaryuserId1 = 0;
	
	if(selectedid == 0){
		slotId1 = Integer.parseInt(slotId);
		diaryuserId1 = Integer.parseInt(diaryuserId);
	}
	
	
	
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlot notAvailableSlot = new NotAvailableSlot();
		notAvailableSlot.setApmtSlotId(slotId1);
		notAvailableSlot.setDiaryUserId(diaryuserId1);
		notAvailableSlot.setDiaryUser(diaryUser);
		
		notAvailableSlot.setLocation(location);
		notAvailableSlot.setRoom(room);
		notAvailableSlot.setCommencing(commencing);
		notAvailableSlot.setSTime(sTime);
		notAvailableSlot.setEndTime(endTime);
		notAvailableSlot.setApmtDuration(apmtDuration);
		
		notAvailableSlot.setReasonforblock(reasonforblock);
		notAvailableSlot.setNotes(notes);
		notAvailableSlot.setStatus(status);
		
		NotAvailableSlotDAO notAvailableSlotDAO = new  JDBCNotAvailableSlotDAO(connection);
		if(selectedid == 0){
			result = notAvailableSlotDAO.saveBlockSlot(notAvailableSlot);
		}else{
			int update  = notAvailableSlotDAO.updateBlockSlot(notAvailableSlot,selectedid);
		}
	
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	return null;
}




public void prepare() throws Exception {
	Connection connection = null;
	
	ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
	ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
	ArrayList<String> clientOccupationList = new ArrayList<String>();
	ArrayList<String> refrenceList = new ArrayList<String>();
	ArrayList<String> initialList = new ArrayList<String>();
	ArrayList<String> sourceOfIntroList = new ArrayList<String>();
	try{
		
		connection = Connection_provider.getconnection();
		ClientDAO clientDAO = new JDBCClientDAO(connection);
		thirdPartyTypeList = clientDAO.getThirdPartyType();
		notAvailableSlotForm.setThirdPartyTypeList(thirdPartyTypeList);
		
		thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
		notAvailableSlotForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
		
		clientOccupationList = clientDAO.getOccupationList();
		clientOccupationList.add("Other");
		
		notAvailableSlotForm.setClientOccupationList(clientOccupationList);
		
		refrenceList = clientDAO.getReferenceList();
		refrenceList.add("Other");
		notAvailableSlotForm.setRefrenceList(refrenceList);
		
		initialList = clientDAO.getInitialList();
		notAvailableSlotForm.setInitialList(initialList);
		
		sourceOfIntroList = clientDAO.getSourceOfIntroList();
		notAvailableSlotForm.setSourceOfIntroList(sourceOfIntroList);
		
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		ArrayList<Location>locationList = notAvailableSlotDAO.getLocationList(loginInfo.getId());
		notAvailableSlotForm.setLocationList(locationList);
		
		ArrayList<AppointmentType>appointmentTypeList = notAvailableSlotDAO.getAppointmentTypeList();
		notAvailableSlotForm.setAppointmentTypeList(appointmentTypeList);
	}catch (Exception e) {
		// TODO: handle exception
	}
	finally{
		connection.close();
	}
	
	notAvailableSlotForm.setCountryList(PopulateList.countryList());
	
	
	notAvailableSlotForm.setStartTimeList(PopulateList.startTimeList());
	notAvailableSlotForm.setEndTimeList(PopulateList.endTimeList());
	notAvailableSlotForm.setApmtDurationList(PopulateList.apmtDurationList());
	notAvailableSlotForm.setApmtBlockDurationList(PopulateList.apmBlocktDurationList());
	
	

}



public String newAppoinment(){
	return "newAppoinment";
}

//email send code
public String emailSend(){
	String practitionerName = request.getParameter("practitionerName");
	String practitionerId = request.getParameter("practitionerId");
	String clientName = request.getParameter("clientName");
	String clientId = request.getParameter("clientId");
	String startTime = request.getParameter("startTime");
	String duration = request.getParameter("duration");
	String practitionerEmailId = request.getParameter("practitionerEmailId");	
	String clientEmailId = request.getParameter("clientEmailId");
	String location = request.getParameter("location");
	String date = request.getParameter("commencing");
	String subject = "Appointment Details";
	SendMailTLS mailTLS = new SendMailTLS();
	StringBuffer str = new StringBuffer();

	//Practitioner Mail
	str.append("<table width = '30%'> ");

	str.append("<tr>");
	str.append("<td><b>"+practitionerName+"</b></td> ");
	str.append("</tr>");
	str.append("<b>Appointment Details:</b>");

	str.append("<tr>");
	str.append("<td>Date:</td>");
	str.append("<td>"+date+"</td> ");
	str.append("</tr>");

	str.append("<tr>");
	str.append("<td>Start time:</td>");
	str.append("<td>"+startTime+"</td> ");
	str.append("</tr>");

	str.append("<tr>");
	str.append("<td>Duration:</td>");
	str.append("<td>"+duration+"</td> ");
	str.append("</tr>");

	str.append("<tr>");
	str.append("<td>Client Name:</td>");
	str.append("<td>"+clientName+"</td> ");
	str.append("</tr>");

	str.append("<tr>");
	str.append("<td>Location:</td>");
	str.append("<td>"+location+"</td> ");
	str.append("</tr>");

	str.append("</table>");
	try{
	mailTLS.sendMail(practitionerEmailId,subject, str.toString());
	}catch (Exception e) {
		e.printStackTrace();
	}

	//Client Mail
	StringBuffer str1 = new StringBuffer();
	str1.append("<table width = '30%'> ");

	str1.append("<tr>");
	str1.append("<td><b>"+clientName+"</b></td> ");
	str1.append("</tr>");
	str1.append("<b>Appointment Details:</b>");

	str1.append("<tr>");
	str1.append("<td>Date:</td>");
	str1.append("<td>"+date+"</td> ");
	str1.append("</tr>");

	str1.append("<tr>");
	str1.append("<td>Start time:</td>");
	str1.append("<td>"+startTime+"</td> ");
	str1.append("</tr>");

	str1.append("<tr>");
	str1.append("<td>Duration:</td>");
	str1.append("<td>"+duration+"</td> ");
	str1.append("</tr>");

	str1.append("<tr>");
	str1.append("<td>Practitioner Name:</td>");
	str1.append("<td>"+practitionerName+"</td> ");
	str1.append("</tr>");

	str1.append("<tr>");
	str1.append("<td>Location:</td>");
	str1.append("<td>"+location+"</td> ");
	str1.append("</tr>");

	str1.append("</table>");
	try{
	mailTLS.sendMail(clientEmailId,subject, str1.toString());
	}catch (Exception e) {
		e.printStackTrace();
	}
	


		
		return null;
	}

//29th march unnati

public String getPrintDataOfWeek() throws SQLException{
	Connection connection = null;
	
	DateTimeUtils dateTimeUtils = new DateTimeUtils();
	String practionerId = request.getParameter("practitionerId");
	String fromDate = request.getParameter("date");
	String practioner = request.getParameter("practitioner");
	ApmDate d1 = dateTimeUtils.getApmDate(fromDate, 6);
	int toDay = d1.getDate(); 
	int toMonth = d1.getMonth();
	int toYear = d1.getYear();
	notAvailableSlotForm.setDate(fromDate);
	
	String temp[] = fromDate.split("/");
	fromDate = temp[2] + "-" + temp[1] + "-" + temp[0];
	String todd = "";
	String tomm = "";
	todd = Integer.toString(toDay);
	tomm = Integer.toString(toMonth);
	if(toDay <=9){
		
		todd = "0" + todd;
	}
	if(toMonth <=9){
		
		tomm = "0" + tomm;
	}
	String toDate = Integer.toString(toYear) + "-"+ tomm + "-" +todd;
	String toDate1 = todd +"/" +tomm +"/" + Integer.toString(toYear);
	notAvailableSlotForm.setToDate(toDate1);
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		ArrayList<NotAvailableSlot>practitionerApmtList = notAvailableSlotDAO.getPrintDataOfWeek(practionerId,fromDate,toDate);
		notAvailableSlotForm.setPractitionerApmtList(practitionerApmtList);
		notAvailableSlotForm.setPractitonerName(practioner);
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	finally{
		connection.close();
	}
	return "getPrintDataOfWeek";
}
public String getPractionerPrintData() throws SQLException{
	String practionerId = request.getParameter("practitionerId");
	String date = request.getParameter("date");
	String practioner = request.getParameter("practitioner");
	notAvailableSlotForm.setDate(date);
	String temp[] = date.split("/");
	date = temp[2] + "-" + temp[1] + "-" + temp[0];
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		ArrayList<NotAvailableSlot>practitionerApmtList = notAvailableSlotDAO.getPractitionerPrintData(practionerId,date);
		notAvailableSlotForm.setPractitionerApmtList(practitionerApmtList);
		notAvailableSlotForm.setPractitonerName(practioner);
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	return "getPractionerPrintData";
}
public String getAllPrintData() throws SQLException{
	String date = request.getParameter("date");
	
	String temp[] = date.split("/");
	date = temp[2] + "-" + temp[1] + "-" + temp[0];
	Connection connection = null;
	try{
		connection = Connection_provider.getconnection();
		NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
		
		ArrayList<NotAvailableSlot>practitionerApmtList = notAvailableSlotDAO.getAllPractitionerPrintData(date);
		notAvailableSlotForm.setPractitionerApmtList(practitionerApmtList);
			
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	
	return "getAllPrintData";
}
}
