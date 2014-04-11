package com.apm.ThirdParties.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.DiaryManagement.eu.bi.AppointmentDiaryReportDAO;
import com.apm.DiaryManagement.eu.entity.AppointmentDiaryReport;
import com.apm.ThirdParties.eu.bi.ThirdPartyDAO;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Pagination;

public class JDBCThirdPartyDAO extends JDBCBaseDAO implements ThirdPartyDAO {
	
	public JDBCThirdPartyDAO(Connection connection){
			
			this.connection = connection;
		}

	public ArrayList<ThirdParty> getThirdPartyList() {
		PreparedStatement preparedStatement = null;
		ArrayList<ThirdParty>list = new ArrayList<ThirdParty>();
		String sql = "select id,name,description from apm_third_party";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				ThirdParty thirdParty = new ThirdParty();
				thirdParty.setId(rs.getInt(1));
				thirdParty.setName(rs.getString(2));
				thirdParty.setDescription(rs.getString(3));
				list.add(thirdParty);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int saveDetails(String type,ThirdParty thirdParty) {
		int result = 0;
		
		PreparedStatement pstm = null;
		
		
		String sql = "insert into apm_third_party_details(third_party_id,type,name,salutation,title,department,search_name,telephone_line,email,email_cc,notes,company_details,company_name,address,town,country,postcode,telephone,fax,web,reference_no,company_email,warning_msg,account_notes,acc_must_be_in_credit,acc_credit_limit,acc_warning_limit,default_apmt_booking_confim,confm_contact_email,default_apmt_dna,dna_contact_email) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, thirdParty.getType());;
			String typeName = getTypeName(thirdParty.getType());
			pstm.setString(2, typeName);
			pstm.setString(3, thirdParty.getName());
			pstm.setString(4, thirdParty.getSalutation());
			pstm.setString(5, thirdParty.getTitle());
			pstm.setString(6, thirdParty.getDepartment());
			pstm.setString(7, thirdParty.getSearchName());
			pstm.setString(8, thirdParty.getTelephoneLine());
			pstm.setString(9, thirdParty.getEmail());
			pstm.setString(10, thirdParty.getEmailCc());
			pstm.setString(11, thirdParty.getNotes());
			pstm.setString(12, thirdParty.getCompanyDetails());
			
			pstm.setString(13, thirdParty.getCompanyName());
			pstm.setString(14, thirdParty.getAddress());
			pstm.setString(15, thirdParty.getTown());
			pstm.setString(16, thirdParty.getCountry());
			pstm.setString(17, thirdParty.getPostcode());
			pstm.setString(18, thirdParty.getCompnyTelephone());
			pstm.setString(19, thirdParty.getFax());
			pstm.setString(20, thirdParty.getWeb());
			pstm.setString(21, thirdParty.getReferenceNo());
			pstm.setString(22, thirdParty.getCompnyEmail());
			
			pstm.setString(23, thirdParty.getWarningMsg());
			pstm.setString(24, thirdParty.getAccountsNotes());
			pstm.setBoolean(25, thirdParty.isAccountMustBeInCredit());
			pstm.setString(26, thirdParty.getAccountCreditLimit());
			pstm.setString(27, thirdParty.getAccountWarningLimit());
			pstm.setString(28, thirdParty.getDefaultApmtBookingConfmTemp());
			pstm.setString(29, thirdParty.getConfContactEmail());
			pstm.setString(30, thirdParty.getDefaultApmtDnaTemp());
			pstm.setString(31, thirdParty.getDnaContactEmail());
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	private String getTypeName(String type) {
		String typeName = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "select name from apm_third_party where id = "+type+"";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				typeName = rs.getString(1);
				}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return typeName;
	}

	public ArrayList<ThirdParty> getThirdPartyDetailsList(String type) {
		PreparedStatement preparedStatement = null;
		ArrayList<ThirdParty>list = new ArrayList<ThirdParty>();
		String sql = "select id,third_party_id,type,name,salutation,title,department,search_name,telephone_line,email,email_cc,notes,company_details,company_name,address,town,country,postcode,telephone,fax,web,reference_no,company_email,warning_msg,account_notes,acc_must_be_in_credit,acc_credit_limit,acc_warning_limit,default_apmt_booking_confim,confm_contact_email,default_apmt_dna,dna_contact_email from apm_third_party_details where third_party_id = "+type+"";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				ThirdParty thirdParty = new ThirdParty();
				thirdParty.setId(rs.getInt(1));
				thirdParty.setThirdPartyId(rs.getInt(2));
				thirdParty.setType(rs.getString(3));
				thirdParty.setName(rs.getString(4));
				
				
				thirdParty.setSalutation(rs.getString(5));
				thirdParty.setTitle(rs.getString(6));
				thirdParty.setDepartment(rs.getString(7));
				thirdParty.setSearchName(rs.getString(8));
				thirdParty.setTelephoneLine(rs.getString(9));
				thirdParty.setEmail(rs.getString(10));
				thirdParty.setEmailCc(rs.getString(11));
				thirdParty.setNotes(rs.getString(12));
				thirdParty.setCompanyDetails(rs.getString(13));
				
				thirdParty.setCompanyName(rs.getString(14));
				thirdParty.setAddress(rs.getString(15));
				thirdParty.setTown(rs.getString(16));
				thirdParty.setCountry(rs.getString(17));
				thirdParty.setPostcode(rs.getString(18));
				thirdParty.setCompnyTelephone(rs.getString(19));
				thirdParty.setFax(rs.getString(20));
				thirdParty.setWeb(rs.getString(21));
				thirdParty.setReferenceNo(rs.getString(22));
				thirdParty.setCompnyEmail(rs.getString(23));
				
				thirdParty.setWarningMsg(rs.getString(24));
				thirdParty.setAccountsNotes(rs.getString(25));
				thirdParty.setAccountMustBeInCredit(rs.getBoolean(26));
				thirdParty.setAccountCreditLimit(rs.getString(27));
				thirdParty.setAccountWarningLimit(rs.getString(28));
				thirdParty.setDefaultApmtBookingConfmTemp(rs.getString(29));
				thirdParty.setConfContactEmail(rs.getString(30));
				thirdParty.setDefaultApmtDnaTemp(rs.getString(31));
				thirdParty.setDnaContactEmail(rs.getString(32));
				
				list.add(thirdParty);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int editDetails(String type, int id, ThirdParty thirdParty) {
int result = 0;
		
		PreparedStatement pstm = null;
		
		
		String sql = "update apm_third_party_details set name=?,salutation=?,title=?,department=?,search_name=?,telephone_line=?,email=?,email_cc=?,notes=?,company_details=?,company_name=?,address=?,town=?,country=?,postcode=?,telephone=?,fax=?,web=?,reference_no=?,company_email=?,warning_msg=?,account_notes=?,acc_must_be_in_credit=?,acc_credit_limit=?,acc_warning_limit=?,default_apmt_booking_confim=?,confm_contact_email=?,default_apmt_dna=?,dna_contact_email=? where id = "+id+" and type = '"+type+"' "; 
		try {
			pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, thirdParty.getName());
			pstm.setString(2, thirdParty.getSalutation());
			pstm.setString(3, thirdParty.getTitle());
			pstm.setString(4, thirdParty.getDepartment());
			pstm.setString(5, thirdParty.getSearchName());
			pstm.setString(6, thirdParty.getTelephoneLine());
			pstm.setString(7, thirdParty.getEmail());
			pstm.setString(8, thirdParty.getEmailCc());
			pstm.setString(9, thirdParty.getNotes());
			pstm.setString(10, thirdParty.getCompanyDetails());
			
			pstm.setString(11, thirdParty.getCompanyName());
			pstm.setString(12, thirdParty.getAddress());
			pstm.setString(13, thirdParty.getTown());
			pstm.setString(14, thirdParty.getCountry());
			pstm.setString(15, thirdParty.getPostcode());
			pstm.setString(16, thirdParty.getCompnyTelephone());
			pstm.setString(17, thirdParty.getFax());
			pstm.setString(18, thirdParty.getWeb());
			pstm.setString(19, thirdParty.getReferenceNo());
			pstm.setString(20, thirdParty.getCompnyEmail());
			
			pstm.setString(21, thirdParty.getWarningMsg());
			pstm.setString(22, thirdParty.getAccountsNotes());
			pstm.setBoolean(23, thirdParty.isAccountMustBeInCredit());
			pstm.setString(24, thirdParty.getAccountCreditLimit());
			pstm.setString(25, thirdParty.getAccountWarningLimit());
			pstm.setString(26, thirdParty.getDefaultApmtBookingConfmTemp());
			pstm.setString(27, thirdParty.getConfContactEmail());
			pstm.setString(28, thirdParty.getDefaultApmtDnaTemp());
			pstm.setString(29, thirdParty.getDnaContactEmail());
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	public int deleteDetail(int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_third_party_details where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int saveType(ThirdParty thirdParty) {
int result = 0;
		
		PreparedStatement pstm = null;
		
		
		String sql = "insert into apm_third_party(name,description) values (?,?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, thirdParty.getType());
			pstm.setString(2, thirdParty.getDescription());
			
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	public ThirdParty getTypeDetail(int id) {
		PreparedStatement preparedStatement = null;
		ThirdParty thirdParty = new ThirdParty();
		String sql = "select id,name,description from apm_third_party where id = "+id+"";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				thirdParty.setId(rs.getInt(1));
				thirdParty.setType(rs.getString(2));
				thirdParty.setDescription(rs.getString(3));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return thirdParty;
	}

	public int updateType(int id, ThirdParty thirdParty) {
		int result = 0;
		
		PreparedStatement pstm = null;
		
		
		String sql = "update apm_third_party set name= ?,description=? where id = "+id+"";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, thirdParty.getType());
			pstm.setString(2, thirdParty.getDescription());
			
			
			result = pstm.executeUpdate();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return result;
	}

	public int deleteType(int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_third_party where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<ThirdParty> getThirdPartyDetailsList() {
		PreparedStatement preparedStatement = null;
		ArrayList<ThirdParty>list = new ArrayList<ThirdParty>();
		String sql = "select id,third_party_id,type,name,salutation,title,department,search_name,telephone_line,email,email_cc,notes,company_details,company_name,address,town,country,postcode,telephone,fax,web,reference_no,company_email,warning_msg,account_notes,acc_must_be_in_credit,acc_credit_limit,acc_warning_limit,default_apmt_booking_confim,confm_contact_email,default_apmt_dna,dna_contact_email from apm_third_party_details";
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				ThirdParty thirdParty = new ThirdParty();
				thirdParty.setId(rs.getInt(1));
				thirdParty.setThirdPartyId(rs.getInt(2));
				thirdParty.setType(rs.getString(3));
				thirdParty.setName(rs.getString(4));
				
				
				thirdParty.setSalutation(rs.getString(5));
				thirdParty.setTitle(rs.getString(6));
				thirdParty.setDepartment(rs.getString(7));
				thirdParty.setSearchName(rs.getString(8));
				thirdParty.setTelephoneLine(rs.getString(9));
				thirdParty.setEmail(rs.getString(10));
				thirdParty.setEmailCc(rs.getString(11));
				thirdParty.setNotes(rs.getString(12));
				thirdParty.setCompanyDetails(rs.getString(13));
				
				thirdParty.setCompanyName(rs.getString(14));
				thirdParty.setAddress(rs.getString(15));
				thirdParty.setTown(rs.getString(16));
				thirdParty.setCountry(rs.getString(17));
				thirdParty.setPostcode(rs.getString(18));
				thirdParty.setCompnyTelephone(rs.getString(19));
				thirdParty.setFax(rs.getString(20));
				thirdParty.setWeb(rs.getString(21));
				thirdParty.setReferenceNo(rs.getString(22));
				thirdParty.setCompnyEmail(rs.getString(23));
				
				thirdParty.setWarningMsg(rs.getString(24));
				thirdParty.setAccountsNotes(rs.getString(25));
				thirdParty.setAccountMustBeInCredit(rs.getBoolean(26));
				thirdParty.setAccountCreditLimit(rs.getString(27));
				thirdParty.setAccountWarningLimit(rs.getString(28));
				thirdParty.setDefaultApmtBookingConfmTemp(rs.getString(29));
				thirdParty.setConfContactEmail(rs.getString(30));
				thirdParty.setDefaultApmtDnaTemp(rs.getString(31));
				thirdParty.setDnaContactEmail(rs.getString(32));
				
				list.add(thirdParty);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getThirdPartyCount(String type) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from apm_third_party_details where third_party_id = "+type+"";
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

	public ArrayList<ThirdParty> getThirdPartyDetailsList(String type,
			Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<ThirdParty>list = new ArrayList<ThirdParty>();
		String sql = "select id,third_party_id,type,name,salutation,title,department,search_name,telephone_line,email,email_cc,notes,company_details,company_name,address,town,country,postcode,telephone,fax,web,reference_no,company_email,warning_msg,account_notes,acc_must_be_in_credit,acc_credit_limit,acc_warning_limit,default_apmt_booking_confim,confm_contact_email,default_apmt_dna,dna_contact_email from apm_third_party_details where third_party_id = "+type+"";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				ThirdParty thirdParty = new ThirdParty();
				thirdParty.setId(rs.getInt(1));
				thirdParty.setThirdPartyId(rs.getInt(2));
				thirdParty.setType(rs.getString(3));
				thirdParty.setName(rs.getString(4));
				
				
				thirdParty.setSalutation(rs.getString(5));
				thirdParty.setTitle(rs.getString(6));
				thirdParty.setDepartment(rs.getString(7));
				thirdParty.setSearchName(rs.getString(8));
				thirdParty.setTelephoneLine(rs.getString(9));
				thirdParty.setEmail(rs.getString(10));
				thirdParty.setEmailCc(rs.getString(11));
				thirdParty.setNotes(rs.getString(12));
				thirdParty.setCompanyDetails(rs.getString(13));
				
				thirdParty.setCompanyName(rs.getString(14));
				thirdParty.setAddress(rs.getString(15));
				thirdParty.setTown(rs.getString(16));
				thirdParty.setCountry(rs.getString(17));
				thirdParty.setPostcode(rs.getString(18));
				thirdParty.setCompnyTelephone(rs.getString(19));
				thirdParty.setFax(rs.getString(20));
				thirdParty.setWeb(rs.getString(21));
				thirdParty.setReferenceNo(rs.getString(22));
				thirdParty.setCompnyEmail(rs.getString(23));
				
				thirdParty.setWarningMsg(rs.getString(24));
				thirdParty.setAccountsNotes(rs.getString(25));
				thirdParty.setAccountMustBeInCredit(rs.getBoolean(26));
				thirdParty.setAccountCreditLimit(rs.getString(27));
				thirdParty.setAccountWarningLimit(rs.getString(28));
				thirdParty.setDefaultApmtBookingConfmTemp(rs.getString(29));
				thirdParty.setConfContactEmail(rs.getString(30));
				thirdParty.setDefaultApmtDnaTemp(rs.getString(31));
				thirdParty.setDnaContactEmail(rs.getString(32));
				
				list.add(thirdParty);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getThirdPartyTypeCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from apm_third_party";
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

	

	public ArrayList<ThirdParty> getThirdPartyList(Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<ThirdParty>list = new ArrayList<ThirdParty>();
		String sql = "select id,name,description from apm_third_party";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				ThirdParty thirdParty = new ThirdParty();
				thirdParty.setId(rs.getInt(1));
				thirdParty.setName(rs.getString(2));
				thirdParty.setDescription(rs.getString(3));
				list.add(thirdParty);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
