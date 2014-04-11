package com.apm.DiaryManagement.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.apm.DiaryManagement.eu.bi.ClientDAO;
import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Pagination;

public class JDBCClientDAO extends JDBCBaseDAO implements ClientDAO {
	
	public JDBCClientDAO(Connection connection){
		this.connection = connection;
		
	}

	public ArrayList<Client> getAllPatient() {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,title,firstname,surname,mobno,email,gender,dob,address,town,country,postcode,refrence,sourceofintro,third_party_id,third_party_name_id,occupation,expiryDate,whopay,policyauthorzcode,policyno,knownAs,county,homeNo,workNo,emailCc,prefContactMode,emergencyContName,emergencyContNo,patientType from apm_patient";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setTitle(rs.getString(2));
				client.setFirstName(rs.getString(3));
				client.setLastName(rs.getString(4));
				client.setMobNo(rs.getString(5));
				client.setEmail(rs.getString(6));
				client.setGender(rs.getString(7));
				client.setDob(rs.getString(8));
				client.setAddress(rs.getString(9));
				client.setTown(rs.getString(10));
				client.setCountry(rs.getString(11));
				client.setPostCode(rs.getString(12));
				client.setReference(rs.getString(13));
				client.setSourceOfIntro(rs.getString(14));
				client.setType(rs.getString(15));
				client.setTypeName(rs.getString(16));
				
				
				String thirdPartyType = getType(rs.getString(15));
				String thirdPartyTypeName = getTypeName(rs.getString(16));
				
				client.setThirdPartyType(thirdPartyType);
				client.setThirdPartyTypeName(thirdPartyTypeName);
				client.setOccupation(rs.getString(17));
				client.setExpiryDate(rs.getString(18));
				client.setWhopay(rs.getString(19));
				client.setPolicyAuthorzCode(rs.getString(20));
				client.setPolicyNo(rs.getString(21));
				client.setKnownAs(rs.getString(22));
				client.setCounty(rs.getString(23));
				client.setHomeNo(rs.getString(24));
				client.setWorkNo(rs.getString(25));
				client.setEmailCc(rs.getString(26));
				client.setPrefContactMode(rs.getString(27));
				client.setEmergencyContName(rs.getString(28));
				client.setEmergencyContNo(rs.getString(29));
				client.setPatientType(rs.getString(30));
				
				
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}

	private String getTypeName(String type) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT name FROM apm_third_party_details where  id = "+type+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String getType(String typeName) {
		PreparedStatement preparedStatement = null;
		String result = "";
		String sql = "SELECT name FROM apm_third_party where  id = "+typeName+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int savePatient(Client client) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_patient(title,firstname,surname,mobno,email,gender,dob,address,town,country,postcode,refrence,sourceofintro,third_party_id,third_party_name_id,occupation,expiryDate,whopay,policyauthorzcode,policyno,knownAs,county,homeNo,workNo,emailCc,prefContactMode,emergencyContName,emergencyContNo,patientType)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, client.getTitle());
			preparedStatement.setString(2, client.getFirstName());
			preparedStatement.setString(3, client.getLastName());
			preparedStatement.setString(4, client.getMobNo());
			preparedStatement.setString(5, client.getEmail());
			preparedStatement.setString(6, client.getGender());
			preparedStatement.setString(7, client.getDob());
			preparedStatement.setString(8, client.getAddress());
			preparedStatement.setString(9, client.getTown());
			preparedStatement.setString(10, client.getCountry());
			preparedStatement.setString(11, client.getPostCode());
			preparedStatement.setString(12, client.getReference());
			preparedStatement.setString(13, client.getSourceOfIntro());
			preparedStatement.setString(14, client.getType());
			preparedStatement.setString(15, client.getTypeName());
			preparedStatement.setString(16, client.getOccupation());
			preparedStatement.setString(17, client.getExpiryDate());
			preparedStatement.setString(18, client.getWhopay());
			preparedStatement.setString(19, client.getPolicyAuthorzCode());
			preparedStatement.setString(20, client.getPolicyNo());
			preparedStatement.setString(21, client.getKnownAs());
			preparedStatement.setString(22, client.getCounty());
			preparedStatement.setString(23, client.getHomeNo());
			preparedStatement.setString(24, client.getWorkNo());
			preparedStatement.setString(25, client.getEmailCc());
			preparedStatement.setString(26, client.getPrefContactMode());
			preparedStatement.setString(27, client.getEmergencyContName());
			preparedStatement.setString(28, client.getEmergencyContNo());
			preparedStatement.setString(29, client.getPatientType());
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Client getPatient(int id) {
		PreparedStatement preparedStatement = null;
		String sql = "select id,title,firstname,surname,mobno,email,gender,dob,address,town,country,postcode,refrence,sourceofintro,third_party_id,third_party_name_id,occupation,expiryDate,whopay,policyauthorzcode,policyno,knownAs,county,homeNo,workNo,emailCc,prefContactMode,emergencyContName,emergencyContNo,patientType from apm_patient where id = "+id+"";
		Client client = new Client();
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				client.setId(rs.getInt(1));
				client.setTitle(rs.getString(2));
				client.setFirstName(rs.getString(3));
				client.setLastName(rs.getString(4));
				client.setMobNo(rs.getString(5));
				client.setEmail(rs.getString(6));
				client.setGender(rs.getString(7));
				client.setDob(rs.getString(8));
				client.setAddress(rs.getString(9));
				client.setTown(rs.getString(10));
				client.setCountry(rs.getString(11));
				client.setPostCode(rs.getString(12));
				client.setReference(rs.getString(13));
				client.setSourceOfIntro(rs.getString(14));
				client.setType(rs.getString(15));
				client.setTypeName(rs.getString(16));
				client.setOccupation(rs.getString(17));
				client.setExpiryDate(rs.getString(18));
				client.setWhopay(rs.getString(19));
				client.setPolicyAuthorzCode(rs.getString(20));
				client.setPolicyNo(rs.getString(21));
				client.setKnownAs(rs.getString(22));
				client.setCounty(rs.getString(23));
				client.setHomeNo(rs.getString(24));
				client.setWorkNo(rs.getString(25));
				client.setEmailCc(rs.getString(26));
				client.setPrefContactMode(rs.getString(27));
				client.setEmergencyContName(rs.getString(28));
				client.setEmergencyContNo(rs.getString(29));
				client.setPatientType(rs.getString(30));
				
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	public int updatePatient(Client client, int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_patient set title=?,firstname=?,surname=?,mobno=?,email=?,gender=?,dob=?,address=?,town=?,country=?,postcode=?,refrence=?,sourceofintro=?,third_party_id = ?,third_party_name_id = ?,occupation = ?,expiryDate = ?,whopay = ?,policyauthorzcode = ?,policyno = ?,knownAs = ?,county = ?,homeNo = ?,workNo = ?,emailCc = ?,prefContactMode = ?,emergencyContName = ?,emergencyContNo = ?,patientType = ? where id = "+id+"";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, client.getTitle());
			preparedStatement.setString(2, client.getFirstName());
			preparedStatement.setString(3, client.getLastName());
			preparedStatement.setString(4, client.getMobNo());
			preparedStatement.setString(5, client.getEmail());
			preparedStatement.setString(6, client.getGender());
			preparedStatement.setString(7, client.getDob());
			preparedStatement.setString(8, client.getAddress());
			preparedStatement.setString(9, client.getTown());
			preparedStatement.setString(10, client.getCountry());
			preparedStatement.setString(11, client.getPostCode());
			preparedStatement.setString(12, client.getReference());
			preparedStatement.setString(13, client.getSourceOfIntro());
			preparedStatement.setString(14, client.getType());
			preparedStatement.setString(15, client.getTypeName());
			preparedStatement.setString(16, client.getOccupation());
			preparedStatement.setString(17, client.getExpiryDate());
			preparedStatement.setString(18, client.getWhopay());
			preparedStatement.setString(19,client.getPolicyAuthorzCode());
			preparedStatement.setString(20, client.getPolicyNo());
			preparedStatement.setString(21, client.getKnownAs());
			preparedStatement.setString(22, client.getCounty());
			preparedStatement.setString(23, client.getHomeNo());
			preparedStatement.setString(24, client.getWorkNo());
			preparedStatement.setString(25, client.getEmailCc());
			preparedStatement.setString(26, client.getPrefContactMode());
			preparedStatement.setString(27, client.getEmergencyContName());
			preparedStatement.setString(28, client.getEmergencyContNo());
			preparedStatement.setString(29, client.getPatientType());
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int deleteClient(int id, Client client) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_patient where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public ArrayList<Client> getThirdPartyType() {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,name from apm_third_party";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setType(rs.getString(2));
				
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<Client> getThirdPartyTypeName() {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,name,company_name from apm_third_party_details";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setTypeName(rs.getString(2));
				client.setThirdPartyCompanyName(rs.getString(3));
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ArrayList<Client> getThirdTypeNameList(int id) {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,name,company_name from apm_third_party_details where third_party_id = '"+id+"'";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setTypeName(rs.getString(2));
				client.setThirdPartyCompanyName(rs.getString(3));
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int updateThirdPartyDetails(Client client, String id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_patient set third_party_id = ?,third_party_name_id = ? where id = "+id+"";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, client.getType());
			preparedStatement.setString(2, client.getTypeName());
			
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public ArrayList<String> getOccupationList() {
		PreparedStatement preparedStatement = null;
		ArrayList<String>list = new ArrayList<String>();
		String sql = "select occupation from occupation";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				String occupation = rs.getString(1);
			
				list.add(occupation);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> getReferenceList() {
		PreparedStatement preparedStatement = null;
		ArrayList<String>list = new ArrayList<String>();
		String sql = "select name from reference";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				String reference = rs.getString(1);
			
				list.add(reference);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insertOtherOccupation(Client client, String otherOccupation) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into occupation(occupation)values(?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, otherOccupation);
			
			
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int insertOtherReference(Client client, String otherReference) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into reference(name)values(?)";
		try{
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, otherReference);
			
			
			result = preparedStatement.executeUpdate();

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public ArrayList<String> getInitialList() {
		PreparedStatement preparedStatement = null;
		ArrayList<String>list = new ArrayList<String>();
		String sql = "select initial from initial";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				String initial = rs.getString(1);
			
				list.add(initial);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

	public ArrayList<Client> getClient(String searchClient) {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,title,firstname,surname,mobno,email,gender,dob,address,town,country,postcode,refrence,sourceofintro,third_party_id,third_party_name_id,occupation,expiryDate,whopay,policyauthorzcode,policyno,knownAs,county,homeNo,workNo,emailCc,prefContactMode,emergencyContName,emergencyContNo,patientType from apm_patient where firstname like('%"+searchClient+"%')";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setTitle(rs.getString(2));
				client.setFirstName(rs.getString(3));
				client.setLastName(rs.getString(4));
				client.setMobNo(rs.getString(5));
				client.setEmail(rs.getString(6));
				client.setGender(rs.getString(7));
				client.setDob(rs.getString(8));
				client.setAddress(rs.getString(9));
				client.setTown(rs.getString(10));
				client.setCountry(rs.getString(11));
				client.setPostCode(rs.getString(12));
				client.setReference(rs.getString(13));
				client.setSourceOfIntro(rs.getString(14));
				client.setType(rs.getString(15));
				client.setTypeName(rs.getString(16));
				
				
				String thirdPartyType = getType(rs.getString(15));
				String thirdPartyTypeName = getTypeName(rs.getString(16));
				
				client.setThirdPartyType(thirdPartyType);
				client.setThirdPartyTypeName(thirdPartyTypeName);
				client.setOccupation(rs.getString(17));
				client.setExpiryDate(rs.getString(18));
				client.setWhopay(rs.getString(19));
				client.setPolicyAuthorzCode(rs.getString(20));
				client.setPolicyNo(rs.getString(21));
				client.setKnownAs(rs.getString(22));
				client.setCounty(rs.getString(23));
				client.setHomeNo(rs.getString(24));
				client.setWorkNo(rs.getString(25));
				client.setEmailCc(rs.getString(26));
				client.setPrefContactMode(rs.getString(27));
				client.setEmergencyContName(rs.getString(28));
				client.setEmergencyContNo(rs.getString(29));
				client.setPatientType(rs.getString(30));
				
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> getSourceOfIntroList() {
		PreparedStatement preparedStatement = null;
		ArrayList<String>list = new ArrayList<String>();
		String sql = "select name from source_of_introduction";
		
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				
				String source = rs.getString(1);
			
				list.add(source);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Client> getAllPatient(Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<Client>list = new ArrayList<Client>();
		String sql = "select id,title,firstname,surname,mobno,email,gender,dob,address,town,country,postcode,refrence,sourceofintro,third_party_id,third_party_name_id,occupation,expiryDate,whopay,policyauthorzcode,policyno from apm_patient";
		sql = pagination.getSQLQuery(sql);
		try{
			
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt(1));
				client.setTitle(rs.getString(2));
				client.setFirstName(rs.getString(3));
				client.setLastName(rs.getString(4));
				client.setMobNo(rs.getString(5));
				client.setEmail(rs.getString(6));
				client.setGender(rs.getString(7));
				client.setDob(rs.getString(8));
				client.setAddress(rs.getString(9));
				client.setTown(rs.getString(10));
				client.setCountry(rs.getString(11));
				client.setPostCode(rs.getString(12));
				client.setReference(rs.getString(13));
				client.setSourceOfIntro(rs.getString(14));
				client.setType(rs.getString(15));
				client.setTypeName(rs.getString(16));
				
				
				String thirdPartyType = getType(rs.getString(15));
				String thirdPartyTypeName = getTypeName(rs.getString(16));
				
				client.setThirdPartyType(thirdPartyType);
				client.setThirdPartyTypeName(thirdPartyTypeName);
				client.setOccupation(rs.getString(17));
				client.setExpiryDate(rs.getString(18));
				client.setWhopay(rs.getString(19));
				client.setPolicyAuthorzCode(rs.getString(20));
				client.setPolicyNo(rs.getString(21));
				
				list.add(client);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public int getTotalClientCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from apm_patient";
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

	
	
}
