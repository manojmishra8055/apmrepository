package com.apm.Accounts.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Accounts.eu.bi.AccountsDAO;
import com.apm.Accounts.eu.entity.Accounts;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.main.common.constants.Constants;

public class JDBCAccountsDAO extends JDBCBaseDAO implements AccountsDAO{
	
	public JDBCAccountsDAO(Connection connection){
		this.connection = connection;
	}

	public ArrayList<Accounts> getAccountList(String clientId,String payby) {
		
		
		
		PreparedStatement preparedStatement = null;
		ArrayList<Accounts>list = new ArrayList<Accounts>();
		StringBuffer sql = new StringBuffer();
		
		if(payby.equals(Constants.PAY_BY_CLIENT)){
			sql.append("SELECT commencing,user,apmtType,sum(charge),invoiceid,paid,apm_invoice.payamount,count(apm_invoice_assesments.id),apm_invoice.practitionername,apm_invoice_assesments.paybuy,apm_invoice_assesments.clientId  FROM apm_invoice_assesments ");
			sql.append("inner join apm_invoice on apm_invoice.id = apm_invoice_assesments.invoiceid ");
			sql.append("where  apm_invoice_assesments.clientid="+clientId+" and apm_invoice_assesments.paybuy = 0 ");
			sql.append("group by invoiceid ");
			
		}else if(payby.equals(Constants.PAY_BY_THIRD_PARTY)){
			sql.append("SELECT commencing,user,apmtType,sum(charge),invoiceid,paid,apm_invoice.payamount,count(apm_invoice_assesments.id),apm_invoice.practitionername,apm_invoice_assesments.paybuy,apm_invoice_assesments.clientId FROM apm_invoice_assesments ");
			sql.append("inner join apm_invoice on apm_invoice.id = apm_invoice_assesments.invoiceid ");
			sql.append("where  apm_invoice_assesments.clientid="+clientId+" and apm_invoice_assesments.paybuy = 1 ");
			sql.append("group by invoiceid ");
		}else{
			sql.append("SELECT commencing,user,apmtType,sum(charge),invoiceid,paid,apm_invoice.payamount,count(apm_invoice_assesments.id),apm_invoice.practitionername,apm_invoice_assesments.paybuy,apm_invoice_assesments.clientId  FROM apm_invoice_assesments ");
			sql.append("inner join apm_invoice on apm_invoice.id = apm_invoice_assesments.invoiceid ");
			sql.append("where  apm_invoice_assesments.clientid="+clientId+" ");
			sql.append("group by invoiceid ");
		}
		
		
		try{
			preparedStatement = connection.prepareStatement(sql.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Accounts accounts = new Accounts();
				accounts.setCommencing(rs.getString(1));
				accounts.setClientName(rs.getString(2));
				accounts.setAppointmentType(rs.getString(3));
				accounts.setCreditCharge(rs.getString(4));
				accounts.setInvoiceid(rs.getInt(5));
				accounts.setPaid(rs.getBoolean(6));
				accounts.setPayAmount(rs.getInt(7));
				accounts.setNumberOfChages(rs.getInt(8));
				accounts.setPractitionerName(rs.getString(9));
				accounts.setPayby(rs.getString(10));
				accounts.setClientid(rs.getInt(11));
				
				int debitAmount = Integer.parseInt(rs.getString(4));
				debitAmount = debitAmount - accounts.getPayAmount();
				accounts.setDebitAmount(debitAmount);
				
				list.add(accounts);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Accounts> getAssesmentList(int invoiceid) {
		PreparedStatement preparedStatement = null;
		ArrayList<Accounts>list = new ArrayList<Accounts>();
		String sql = "SELECT id,commencing,user,apmtType,charge,practitionerName FROM apm_invoice_assesments where invoiceid = "+invoiceid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Accounts accounts = new Accounts();
				accounts.setId(rs.getInt(1));
				accounts.setCommencing(rs.getString(2));
				accounts.setClientName(rs.getString(3));
				accounts.setAppointmentType(rs.getString(4));
				accounts.setCharges(rs.getString(5));
				accounts.setPractitionerName(rs.getString(6));
				
				list.add(accounts);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updatePayment(String invoiceid, String payAmount,
			String howpaid, String invoiceDate,String paid) {
		
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_invoice set date=?,payamount=?,paid="+paid+",howpaid=? where id=?";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceDate);
			preparedStatement.setString(2, payAmount);
			preparedStatement.setString(3, howpaid);
			preparedStatement.setString(4, invoiceid);
			
			result = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getPayAmount(int invoiceid) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "SELECT payamount FROM apm_invoice where id = "+invoiceid+" ";
		
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

	public int updatePayBy(int invoiceid, String payby) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_invoice_assesments set paybuy = "+payby+" where invoiceid = "+invoiceid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
