package com.apm.DiaryManagement.web.action;

import java.net.HttpCookie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.Accounts.eu.bi.AccountsDAO;
import com.apm.Accounts.eu.blogic.jdbc.JDBCAccountsDAO;
import com.apm.Accounts.eu.entity.Accounts;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.bi.ClientDAO;
import com.apm.DiaryManagement.eu.bi.CompleteAptmDAO;
import com.apm.DiaryManagement.eu.bi.NotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCClientDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCCompleteAptmDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCNotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.web.form.CompleteAppointmentForm;
import com.apm.DiaryManagement.web.form.NotAvailableSlotForm;
import com.apm.Registration.eu.entity.Location;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.web.utils.PopulateList;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class CompleteAppointmentAction extends BaseAction implements Preparable, ModelDriven<CompleteAppointmentForm>{
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	
	//NotAvailableSlotForm notAvailableSlotForm = new NotAvailableSlotForm();
	CompleteAppointmentForm completeAppointmentForm = new CompleteAppointmentForm();
	
	
	public String input() throws Exception {
		
		String x = (String) session.getAttribute("Test");
		String selectedUser = request.getParameter("selectedUser");
		completeAppointmentForm.setUser(selectedUser);
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			
			int result = completeAptmDAO.deleteComplteApmt();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return super.input();
	}
	
	
	public String saveCharge() throws SQLException{
		Double total = 0.00;
		
		
		
		String user = request.getParameter("cookieUserName");
		String apmtType = request.getParameter("apmtTypeId");
		String charge = request.getParameter("charge");
		String startTime = request.getParameter("cookieStarttime");
		String duration = request.getParameter("cookieDuration");
		String practitionerId = request.getParameter("cookiePractitionerId");
		String clientId = request.getParameter("cookieClientId");
		String practitionerName = request.getParameter("cookiePractitioner");
		String commencing = request.getParameter("cookiecommencing");
		String payBuy = request.getParameter("payBuy");
		String markAppointment = request.getParameter("markAppointment");
		String apppointmentid = request.getParameter("cookieSelectedAppointmentid");
		
		
		int result = 0;
		Connection connection = null;
		
		try{
			CompleteAppointment completeAppointment = new CompleteAppointment();
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			
			completeAppointment.setUser(user);
			completeAppointment.setApmtType(apmtType);
			completeAppointment.setCharges(charge);
			completeAppointment.setStartTime(startTime);
			completeAppointment.setDuration(duration);
			completeAppointment.setPractitionerId(practitionerId);
			completeAppointment.setPractitionerName(practitionerName);
			completeAppointment.setClientId(clientId);
			completeAppointment.setCommencing(commencing);
			completeAppointment.setPayBuy(payBuy);
			completeAppointment.setMarkAppointment(markAppointment);
			completeAppointment.setAppointmentid(apppointmentid);
			
			
			
			result = completeAptmDAO.saveCharge(completeAppointment);
			
			ArrayList<CompleteAppointment> clientChargeListDetail = new ArrayList<CompleteAppointment>();

			clientChargeListDetail = completeAptmDAO.getPatientChrageDetails(clientId,commencing);
			
			for(CompleteAppointment completeAppointment2:clientChargeListDetail){
				total = completeAppointment2.getChargeTotal();
			}
		//	completeAppointmentForm.setChargeTotal(total);
			
			 String textAjax = new String();
			 
			 textAjax = ("<input type = 'text' id = 'chargeTotal' name = 'chargeTotal' value = '"+total+ "$" +" '>");
			
			 
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				
				response.getWriter().write(""+textAjax.toString()+""); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return null;
	}
	
	public String cashDesk() throws SQLException{
		String id = request.getParameter("selectedUser");
		String date = request.getParameter("date");
		System.out.println(id);
		double total = 0;
		Connection connection = null;
		
		try{
			CompleteAppointment completeAppointment = new CompleteAppointment();
			ArrayList<CompleteAppointment> clientChargeListDetail = new ArrayList<CompleteAppointment>();
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			clientChargeListDetail = completeAptmDAO.getPatientChrageDetails(id,date);
			completeAppointmentForm.setClientChargeListDetail(clientChargeListDetail);
			
				//total = completeAppointment2.getChargeTotal();
				
					
				
			StringBuffer str = new StringBuffer();
			

			//Practitioner Mail
			str.append("<table width = '50%' id = 'cashDesk' cellpadding='0' cellspacing='0' class='my-table' > ");
			
			

			str.append("<tr>");
			str.append("<th>Id</th> ");
			str.append("<th>Appointment Type</th> ");
			str.append("<th>Charge</th> ");
			str.append("<th>Delete</th> ");
			str.append("</tr>");
			
			for(CompleteAppointment completeAppointment1:clientChargeListDetail){
			str.append("<tr>");
			str.append("<td>"+completeAppointment1.getId()+"</td>");
			str.append("<td>"+completeAppointment1.getApmtType()+"</td>");
			str.append("<td>"+completeAppointment1.getCharges()+"</td>");
			str.append("<td onclick = 'confirmedDelete("+completeAppointment1.getId()+")'><img src='common/images/delete.gif'></img></td>");

			str.append("</tr>");
			}
			str.append("</table>");
			for(CompleteAppointment completeAppointment2:clientChargeListDetail){
				total = completeAppointment2.getChargeTotal();
			}

			str.append("<tr>");
			str.append("<th colspan='2'>Total</th> ");
			
			str.append("<th colspan='2'>"+total+ "$" +"</th> ");
			str.append("</tr>");
			
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			
			response.getWriter().write(""+str.toString()+""); 
			
			
			
			/*completeAppointment = completeAptmDAO.getPatientDetails(id,completeAppointment,date);
			
			completeAppointmentForm.setUser(completeAppointment.getUser());
			completeAppointmentForm.setPractitionerName(completeAppointment.getPractitionerName());
			completeAppointmentForm.setCommencing(completeAppointment.getCommencing());
			
			
			for(CompleteAppointment completeAppointment2:clientChargeListDetail){
			total = completeAppointment2.getChargeTotal();
			
				
			}*/
				String textAjax = new String();
			 
				textAjax = ("<input type = 'hidden' id = 'hiddenTotal' name = 'hiddenTotal' value = '"+total+ "$" +" '>");
			
			 
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				
				response.getWriter().write(""+textAjax.toString()+"");
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return null;
	}
	
	
	public String paynow() throws SQLException{
		
			Connection connection = null;
			try{
				
				connection = Connection_provider.getconnection();
				CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
				ArrayList<CompleteAppointment>assesmentList = completeAptmDAO.getAssesmentList(completeAppointmentForm.getPayBuy());
				completeAppointmentForm.setAssesmentList(assesmentList);
				double charges = 0;
				
				for(CompleteAppointment completeAppointment: assesmentList){
					charges = charges + Double.parseDouble(completeAppointment.getCharges());
					completeAppointmentForm.setUser(completeAppointment.getUser());
				}
				
				completeAppointmentForm.setChargeTotal(Double.toString(charges));
				completeAppointmentForm.setNumberOfChages(assesmentList.size());
				CompleteAppointment completeAppointment = new CompleteAppointment();
				completeAppointmentForm.setPractitionerName(completeAppointmentForm.getPractitionerName());
				completeAppointment = completeAptmDAO.getInsuranceCompanyName(completeAppointmentForm.getClientId());
				completeAppointmentForm.setInsuranceCompany("Company : "+completeAppointment.getInsuranceCompanyName() + " Owner : " + completeAppointment.getInsuranceCompanyOwnerName() + "Address: " + completeAppointment.getInsuranceCompanyAddress());
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				connection.close();
			}
		return "paynow";
	}
	
	public String invoice() throws SQLException{
		
		Connection connection = null;
		try{
			
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			
			CompleteAppointment completeAppointment = new CompleteAppointment();
			completeAppointment.setClientId(completeAppointmentForm.getClientId());
			completeAppointment.setPractitionerId(completeAppointmentForm.getPractitionerId());
			completeAppointment.setUser(completeAppointmentForm.getUser());
			if(completeAppointmentForm.getPayBuy().equals(Constants.PAY_BY_THIRD_PARTY)){
				
				completeAppointment = completeAptmDAO.getInsuranceCompanyName(completeAppointmentForm.getClientId());
				completeAppointmentForm.setInsuranceCompany("Company : "+completeAppointment.getInsuranceCompanyName() + " Owner : " + completeAppointment.getInsuranceCompanyOwnerName() + "Address: " + completeAppointment.getInsuranceCompanyAddress());
			}
			completeAppointment.setPractitionerName(completeAppointmentForm.getPractitionerName());
			completeAppointment.setInvoiceDate(completeAppointmentForm.getInvoiceDate());
			
			int invoice = completeAptmDAO.saveAmpmInvoice(completeAppointment);
			
			ArrayList<CompleteAppointment>assesmentList = completeAptmDAO.getAssesmentList(completeAppointmentForm.getPayBuy(),completeAppointmentForm.getTotalassesment());
			
			for(CompleteAppointment appointment : assesmentList){
				int result = completeAptmDAO.saveInvoiceAssesment(appointment,invoice);
			}
			
			int result = completeAptmDAO.deleteComplteApmt();
			
			completeAppointmentForm.setInvoiceid(invoice);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return "invoice";
	}
	
	
	public String pay() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			String invoiceid = request.getParameter("invoiceid");
			String payAmount = request.getParameter("payAmount");
			String howpaid = request.getParameter("howpaid");
			String paid = request.getParameter("paid");
			String invoiceDate = request.getParameter("invoiceDate");
			
			int result = accountsDAO.updatePayment(invoiceid,payAmount,howpaid,invoiceDate,paid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return null;
	}
	
	
	
	
	public String preview() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			ArrayList<Accounts>assesmentList = accountsDAO.getAssesmentList(completeAppointmentForm.getInvoiceid());
			
			int charges = 0;
			for(Accounts accounts : assesmentList){
				charges = charges + Integer.parseInt(accounts.getCharges().trim());
			}
			
			int payAmount = accountsDAO.getPayAmount(completeAppointmentForm.getInvoiceid());
			
			int debitAmounnt = charges - payAmount;
			
			completeAppointmentForm.setChargeTotal(Integer.toString(charges));
			completeAppointmentForm.setInvoiceAssesmentList(assesmentList);
			completeAppointmentForm.setPaidAmount(Integer.toString(payAmount));
			
			completeAppointmentForm.setDebitAmounnt(Integer.toString(debitAmounnt));
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return "preview";
	}
	
	
	
	//unnati 24/04/2014
	
	public String createCharge() throws SQLException{
		if(!verifyLogin(request)){
			return "login";
		}Connection connection = null;
		try{
		//show practice manager
		
		
			connection = Connection_provider.getconnection();
			NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
			//start coding
			ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId());
			
			completeAppointmentForm.setUserList(userList);
			
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	 return "createClientCharge";
	}
	
	public String getThirdParty() throws SQLException{
		Connection connection = null;
		String clientId = request.getParameter("clientId");
		try{
			ThirdParty thirdParty = new ThirdParty();
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			thirdParty = completeAptmDAO.getThirdParty(clientId,thirdParty);
			//completeAppointmentForm.setCharge(appointmentType.getCharges());
			 String textAjax = new String();
			 textAjax = ("<b>Invoicee : " +"<input type = 'text' id = 'invoicee' name = 'invoicee' value = '"+thirdParty.getCompanyName()+"'>");
			
			 
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(""+textAjax.toString()+""); 
				
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally{
			connection.close();
		}
		return null;
	}
	
	
	public CompleteAppointmentForm getModel() {
		
		return completeAppointmentForm;
	}

	public void prepare() throws Exception {
		
		completeAppointmentForm.setStartTimeList(PopulateList.startTimeList());
		completeAppointmentForm.setEndTimeList(PopulateList.endTimeList());
		completeAppointmentForm.setApmtDurationList(PopulateList.apmtDurationList());
		Connection connection = null;
		
		try{
			connection = Connection_provider.getconnection();
			NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
			
			ArrayList<Location>locationList = notAvailableSlotDAO.getLocationList(loginInfo.getId());
			completeAppointmentForm.setLocationList(locationList);
			
			ArrayList<AppointmentType>appointmentTypeList = notAvailableSlotDAO.getAppointmentTypeList();
			completeAppointmentForm.setAppointmentTypeList(appointmentTypeList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
	}


//unnati 25th march

public String getApmtCharge() throws SQLException{
	Connection connection = null;
	String apmtType = request.getParameter("apmtTypeId");
	try{
		AppointmentType appointmentType = new AppointmentType();
		connection = Connection_provider.getconnection();
		CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
		appointmentType = completeAptmDAO.getAptmTypeCharge(apmtType,appointmentType);
		//completeAppointmentForm.setCharge(appointmentType.getCharges());
		 String textAjax = new String();
		 textAjax = ("<input type = 'text' id = 'charge' name = 'charge' size = '5' value = '"+appointmentType.getCharges()+ "$" +"'  >");
		
		 
				response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			
			response.getWriter().write(""+textAjax.toString()+""); 
			
		
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	finally{
		connection.close();
	}
	return null;
}

public String getApChargeAndDuration() throws SQLException{
	Connection connection = null;
	String apmtType = request.getParameter("apmtTypeId");
	try{
		AppointmentType appointmentType = new AppointmentType();
		connection = Connection_provider.getconnection();
		CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
		appointmentType = completeAptmDAO.getAptmTypeCharge(apmtType,appointmentType);
		//completeAppointmentForm.setCharge(appointmentType.getCharges());
		 String textAjax = new String();
		 textAjax = ("<input type = 'text' id = 'charge' name = 'charge' value = '"+appointmentType.getCharges()+"'>");
		 String textAjax1 = new String();
		 textAjax1 = (" Duration: " +"<input type = 'text' id = 'duration'  name = 'duration' value = '"+appointmentType.getDuration()+"'>");
		 
				response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			
			response.getWriter().write(""+textAjax.toString()+""); 
			response.getWriter().write(""+textAjax1.toString()+""); 
		
		
		
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	finally{
		connection.close();
	}
	return null;
}

public String deleteCashDesk() throws SQLException{
	int result = 0;
	int id =Integer.parseInt(request.getParameter("selectedid"));
	Connection connection = null;
	Client client = new Client();
	CompleteAppointment completeAppointment = new CompleteAppointment();
	try{
		
		connection = Connection_provider.getconnection();
		
		CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
		
		result = completeAptmDAO.deleteCash(id,completeAppointment);
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