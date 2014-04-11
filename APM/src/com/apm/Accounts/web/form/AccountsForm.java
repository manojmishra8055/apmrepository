package com.apm.Accounts.web.form;

import java.util.ArrayList;

import com.apm.Accounts.eu.entity.Accounts;

public class AccountsForm {
	
	
	private String clientId;
	
	private String client;
	
	private String payby;
	
	private int numberOfChages;
	
	private String creditCharge;
	
	private int payAmount;
	
	private ArrayList<Accounts>assesmentList;
	
	private ArrayList<Accounts>accountList;
	
	private int invoiceid;
	
	private String invoiceDate;
	
	private String practitionerName;
	
	private String totalassesment;
	
	private String debitAmounnt;
	
	private String insuranceCompany;
	
	

	public String getDebitAmounnt() {
		return debitAmounnt;
	}

	public void setDebitAmounnt(String debitAmounnt) {
		this.debitAmounnt = debitAmounnt;
	}

	public String getTotalassesment() {
		return totalassesment;
	}

	public void setTotalassesment(String totalassesment) {
		this.totalassesment = totalassesment;
	}

	public String getPractitionerName() {
		return practitionerName;
	}

	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPayby() {
		return payby;
	}

	public void setPayby(String payby) {
		this.payby = payby;
	}

	public ArrayList<Accounts> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Accounts> accountList) {
		this.accountList = accountList;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public int getNumberOfChages() {
		return numberOfChages;
	}

	public void setNumberOfChages(int numberOfChages) {
		this.numberOfChages = numberOfChages;
	}

	public String getCreditCharge() {
		return creditCharge;
	}

	public void setCreditCharge(String creditCharge) {
		this.creditCharge = creditCharge;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public ArrayList<Accounts> getAssesmentList() {
		return assesmentList;
	}

	public void setAssesmentList(ArrayList<Accounts> assesmentList) {
		this.assesmentList = assesmentList;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}
