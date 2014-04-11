package com.apm.DiaryManagement.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.bi.CompleteAptmDAO;
import com.apm.DiaryManagement.eu.bi.NotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;



public class JDBCCompleteAptmDAO extends JDBCBaseDAO implements CompleteAptmDAO {
		
		public JDBCCompleteAptmDAO(Connection connection){
				
				this.connection = connection;
			}

		public AppointmentType getAptmTypeCharge(String apmtType,
				AppointmentType appointmentType) {
			PreparedStatement preparedStatement = null;
			
			String sql = "SELECT id,duration,name,charges FROM apm_appointment_type where name = '"+apmtType+"' ";
			
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					
					appointmentType.setId(rs.getInt(1));
					appointmentType.setDuration(rs.getString(2));
					appointmentType.setName(rs.getString(3));
					appointmentType.setCharges(rs.getString(4));
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return appointmentType;
		}

		public int saveCharge(CompleteAppointment completeAppointment) {
			PreparedStatement preparedStatement = null;
			int result = 0;
			String sql = "insert into apm_patient_complete_apmt(user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing,paybuy,markAppointment,appointmentid)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			try{
				preparedStatement = connection.prepareStatement(sql);
			
				preparedStatement.setString(1, completeAppointment.getUser());
				preparedStatement.setString(2, completeAppointment.getApmtType());
				preparedStatement.setString(3, completeAppointment.getCharges());
				preparedStatement.setString(4, completeAppointment.getStartTime());
				preparedStatement.setString(5, completeAppointment.getDuration());
				preparedStatement.setString(6, completeAppointment.getPractitionerId());
				preparedStatement.setString(7, completeAppointment.getPractitionerName());
				preparedStatement.setString(8, completeAppointment.getClientId());
				preparedStatement.setString(9, completeAppointment.getCommencing());
				preparedStatement.setString(10, completeAppointment.getPayBuy());
				preparedStatement.setString(11, completeAppointment.getMarkAppointment());
				preparedStatement.setString(12, completeAppointment.getAppointmentid());
				result = preparedStatement.executeUpdate();

			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		public ArrayList<CompleteAppointment> getPatientChrageDetails(String id,String date) {
			PreparedStatement preparedStatement = null;
			ArrayList<CompleteAppointment> clientChargeListDetail = new ArrayList<CompleteAppointment>();
			String sql = "SELECT id,user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing FROM apm_patient_complete_apmt where clientId = "+id+" and commencing = '"+date+"' ";
			double chargeTotal = 0;
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					CompleteAppointment completeAppointment = new CompleteAppointment();
					completeAppointment.setId(rs.getInt(1));
					completeAppointment.setUser(rs.getString(2));
					completeAppointment.setApmtType(rs.getString(3));
					completeAppointment.setCharges(rs.getString(4));
					completeAppointment.setStartTime(rs.getString(5));
					completeAppointment.setDuration(rs.getString(6));
					completeAppointment.setPractitionerId(rs.getString(7));
					completeAppointment.setPractitionerName(rs.getString(8));
					completeAppointment.setClientId(rs.getString(9));
					completeAppointment.setCommencing(rs.getString(10));
					double total = Double.parseDouble((rs.getString(4)));
					chargeTotal = chargeTotal + total;
					completeAppointment.setChargeTotal(chargeTotal);
					
					clientChargeListDetail.add(completeAppointment);
					
					
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return clientChargeListDetail;
		}

		public CompleteAppointment getPatientDetails(String id,
				CompleteAppointment completeAppointment,String date) {
			PreparedStatement preparedStatement = null;
			String sql = "SELECT id,user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing FROM apm_patient_complete_apmt where clientId = "+id+" and commencing = '"+date+"' ";
			
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					completeAppointment.setId(rs.getInt(1));
					completeAppointment.setUser(rs.getString(2));
					completeAppointment.setApmtType(rs.getString(3));
					completeAppointment.setCharges(rs.getString(4));
					completeAppointment.setStartTime(rs.getString(5));
					completeAppointment.setDuration(rs.getString(6));
					completeAppointment.setPractitionerId(rs.getString(7));
					completeAppointment.setPractitionerName(rs.getString(8));
					completeAppointment.setClientId(rs.getString(9));
					completeAppointment.setCommencing(rs.getString(10));
					
					
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return completeAppointment;
		}

		public int deleteComplteApmt() {
			PreparedStatement preparedStatement = null;
			int result = 0;
			String sql = "truncate apm_patient_complete_apmt";
			
			try{
				preparedStatement = connection.prepareStatement(sql);
				result = preparedStatement.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			    
			return result;
		}

		public ArrayList<CompleteAppointment> getAssesmentList(String payBuy) {
			PreparedStatement preparedStatement = null;
			ArrayList<CompleteAppointment>list = new ArrayList<CompleteAppointment>();
			String sql = "SELECT id,commencing,user,apmtType,charge FROM apm_patient_complete_apmt where paybuy= "+payBuy+" ";
			
			try{
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					CompleteAppointment completeAppointment = new CompleteAppointment();
					completeAppointment.setId(rs.getInt(1));
					completeAppointment.setCommencing(rs.getString(2));
					completeAppointment.setUser(rs.getString(3));
					completeAppointment.setApmtType(rs.getString(4));
					completeAppointment.setCharges(rs.getString(5));
					
					
					
					list.add(completeAppointment);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public CompleteAppointment getInsuranceCompanyName(String clientId) {
			PreparedStatement preparedStatement = null;
			String result = "";
			CompleteAppointment completeAppointment = new CompleteAppointment();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT company_name,apm_third_party_details.address,name FROM apm_third_party_details ");
			sql.append("inner join apm_patient on apm_patient.third_party_name_id = apm_third_party_details.id ");
			sql.append("and apm_patient.id = "+clientId+" ");
			
			try{
				preparedStatement = connection.prepareStatement(sql.toString());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					completeAppointment.setInsuranceCompanyName(rs.getString(1));
					completeAppointment.setInsuranceCompanyAddress(rs.getString(2));
					completeAppointment.setInsuranceCompanyOwnerName(rs.getString(3));
					
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return completeAppointment;
		}

		public int saveAmpmInvoice(CompleteAppointment completeAppointment) {
			PreparedStatement preparedStatement = null;
			int result = 0;
			String sql = "insert into apm_invoice(clientid,practitionerid,clientname,practitionername,date) values(?,?,?,?,?)";
			int invoiceid = 0;
			try{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, completeAppointment.getClientId());
				preparedStatement.setString(2, completeAppointment.getPractitionerId());
				preparedStatement.setString(3, completeAppointment.getUser());
				preparedStatement.setString(4, completeAppointment.getPractitionerName());
				preparedStatement.setString(5, completeAppointment.getInvoiceDate());
				
				result = preparedStatement.executeUpdate();
				
				if(result == 1){
					ResultSet resultSet = preparedStatement.getGeneratedKeys();
					if(resultSet.next()){
						invoiceid = resultSet.getInt(1);  
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return invoiceid;
		}

		public ArrayList<CompleteAppointment> getAssesmentList(String payBuy,
				String totalassesment) {
			PreparedStatement preparedStatement = null;
			ArrayList<CompleteAppointment>list = new ArrayList<CompleteAppointment>();
			
			String temp[] = totalassesment.split(",");
			
			String sql = "";
			if(temp.length > 1){
				sql = "SELECT id,user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing,paybuy,markAppointment,appointmentid FROM apm_patient_complete_apmt where paybuy= "+payBuy+" and id in("+totalassesment+")";
			}else{
				sql = "SELECT id,user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing,paybuy,markAppointment,appointmentid FROM apm_patient_complete_apmt where paybuy= "+payBuy+" ";
			}
			 
			
			try{
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					CompleteAppointment completeAppointment = new CompleteAppointment();
					completeAppointment.setId(rs.getInt(1));
					completeAppointment.setUser(rs.getString(2));
					completeAppointment.setApmtType(rs.getString(3));
					completeAppointment.setCharges(rs.getString(4));
					completeAppointment.setStartTime(rs.getString(5));
					completeAppointment.setDuration(rs.getString(6));
					completeAppointment.setPractitionerId(rs.getString(7));
					completeAppointment.setPractitionerName(rs.getString(8));
					completeAppointment.setClientId(rs.getString(9));
					completeAppointment.setCommencing(rs.getString(10));
					completeAppointment.setPayBuy(rs.getString(11));
					completeAppointment.setMarkAppointment(rs.getString(12));
					completeAppointment.setAppointmentid(rs.getString(13));
					
					
					
					list.add(completeAppointment);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
			
		}

		
		
		public int saveInvoiceAssesment(
				CompleteAppointment completeAppointment, int invoice) {
			PreparedStatement preparedStatement = null;
			int result = 0;
			String sql = "insert into apm_invoice_assesments (user,apmtType,charge,startTime,duration,practitionerId,practitionerName,clientId,commencing,paybuy,markAppointment,appointmentid,invoiceid) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, completeAppointment.getUser());
				preparedStatement.setString(2, completeAppointment.getApmtType());
				preparedStatement.setString(3, completeAppointment.getCharges());
				preparedStatement.setString(4, completeAppointment.getStartTime());
				preparedStatement.setString(5, completeAppointment.getDuration());
				preparedStatement.setString(6, completeAppointment.getPractitionerId());
				preparedStatement.setString(7, completeAppointment.getPractitionerName());
				preparedStatement.setString(8, completeAppointment.getClientId());
				preparedStatement.setString(9, completeAppointment.getCommencing());
				preparedStatement.setString(10, completeAppointment.getPayBuy());
				preparedStatement.setString(11, completeAppointment.getMarkAppointment());
				preparedStatement.setString(12, completeAppointment.getAppointmentid());
				preparedStatement.setInt(13, invoice);
				
				result = preparedStatement.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}

		public ThirdParty getThirdParty(String clientId, ThirdParty thirdParty) {
			PreparedStatement preparedStatement = null;
			
			String sql = "SELECT third_party_id from apm_patient where id = "+clientId+" ";
			
			try{
				
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					
					thirdParty.setThirdPartyId(rs.getInt(1));
					String company = getThirdPartycomanyName(rs.getInt(1));
					thirdParty.setCompanyName(company);
					
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return thirdParty;
		}

		private String getThirdPartycomanyName(int int1) {
			String company = null;
			PreparedStatement preparedStatement = null;
			
			String sql = "select company_name from apm_third_party_details where third_party_id = "+int1+"";
			try{
				preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					
					
					company = rs.getString(1);
					}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return company;
		}

		public int deleteCash(int id, CompleteAppointment completeAppointment) {
			PreparedStatement preparedStatement = null;
			int result = 0;
			String sql = "delete from apm_patient_complete_apmt where id = "+id+" ";
			
			try{
				preparedStatement = connection.prepareStatement(sql);
				
				result = preparedStatement.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
