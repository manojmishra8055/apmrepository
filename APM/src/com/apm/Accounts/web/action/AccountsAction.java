package com.apm.Accounts.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.Accounts.eu.bi.AccountsDAO;
import com.apm.Accounts.eu.blogic.jdbc.JDBCAccountsDAO;
import com.apm.Accounts.eu.entity.Accounts;
import com.apm.Accounts.web.form.AccountsForm;
import com.apm.DiaryManagement.eu.bi.CompleteAptmDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCCompleteAptmDAO;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class AccountsAction extends BaseAction implements ModelDriven<AccountsForm>{
	
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	AccountsForm accountsForm = new AccountsForm();
	
	
	public String execute() throws Exception {
		if(!verifyLogin(request)){
			return "login";
		}
		Connection connection = null;
		try{
			
			connection = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			String payby = accountsForm.getPayby();
			
			ArrayList<Accounts>accountList = accountsDAO.getAccountList(accountsForm.getClientId(),payby);
			
			
			accountsForm.setAccountList(accountList);
			CompleteAppointment completeAppointment = new CompleteAppointment();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			completeAppointment = completeAptmDAO.getInsuranceCompanyName(accountsForm.getClientId());
			accountsForm.setInsuranceCompany(completeAppointment.getInsuranceCompanyName() +" " + completeAppointment.getInsuranceCompanyOwnerName() + " " + completeAppointment.getInsuranceCompanyAddress());
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return SUCCESS;
	}
	
	
	public String payment() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			String payby = request.getParameter("payby");
			String client = request.getParameter("client");
			String numberOfChages = request.getParameter("numberOfChages");
			String creditCharge = request.getParameter("creditCharge");
			
			int invoiceid = Integer.parseInt(request.getParameter("invoiceid"));
			int clientid = Integer.parseInt(request.getParameter("clientid"));
			
			
			accountsForm.setClient(client);
			accountsForm.setClientId(Integer.toString(clientid));
			ArrayList<Accounts>assesmentList = accountsDAO.getAssesmentList(invoiceid);
			accountsForm.setAssesmentList(assesmentList);
			accountsForm.setCreditCharge(creditCharge);
			accountsForm.setInvoiceid(invoiceid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return "payment";
	}
	
	public String pay() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			String invoiceid = request.getParameter("invoiceid");
			String payAmount = request.getParameter("payAmount");
			String howpaid = request.getParameter("howpaid");
			String invoiceDate = request.getParameter("invoiceDate");
			String paid = request.getParameter("paid");
			
			int result = accountsDAO.updatePayment(invoiceid,payAmount,howpaid,invoiceDate,paid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return null;
	}
	
	public String invoice() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			
			
			CompleteAppointment completeAppointment = new CompleteAppointment();
			
			completeAppointment = completeAptmDAO.getInsuranceCompanyName(accountsForm.getClientId());
			accountsForm.setInsuranceCompany("Company : "+completeAppointment.getInsuranceCompanyName() + " Owner : " + completeAppointment.getInsuranceCompanyOwnerName() + "Address: " + completeAppointment.getInsuranceCompanyAddress());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		return "invoice";
	}
	
	public String preview() throws SQLException{
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			ArrayList<Accounts>assesmentList = accountsDAO.getAssesmentList(accountsForm.getInvoiceid());
			
			int charges = 0;
			for(Accounts accounts : assesmentList){
				charges = charges + Integer.parseInt(accounts.getCharges().trim());
			}
			
			int payAmount = accountsDAO.getPayAmount(accountsForm.getInvoiceid());
			
			int debitAmounnt = charges - payAmount;
			
			accountsForm.setCreditCharge(Integer.toString(charges));
			accountsForm.setAssesmentList(assesmentList);
			accountsForm.setPayAmount(payAmount);
			accountsForm.setDebitAmounnt(Integer.toString(debitAmounnt));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return "preview";
	}
	
	public String payby() throws SQLException{
		
		Connection connection  = null;
		try{
			
			connection  = Connection_provider.getconnection();
			AccountsDAO accountsDAO = new JDBCAccountsDAO(connection);
			
			int invoiceid = Integer.parseInt(request.getParameter("invoiceid"));
			String payby = request.getParameter("payby");
			
			int result = accountsDAO.updatePayBy(invoiceid,payby);
			
			System.out.println(payby);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return null;
	}
	

	public AccountsForm getModel() {
		
		return accountsForm;
	}

}
