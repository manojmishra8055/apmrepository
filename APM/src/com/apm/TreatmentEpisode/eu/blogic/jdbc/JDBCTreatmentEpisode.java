package com.apm.TreatmentEpisode.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.TreatmentEpisode.eu.bi.TreatmentEpisodeDAO;
import com.apm.TreatmentEpisode.eu.entity.TreatmentEpisode;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;

public class JDBCTreatmentEpisode extends JDBCBaseDAO implements TreatmentEpisodeDAO{
	
	public JDBCTreatmentEpisode(Connection connection){
		
		this.connection = connection;
		
	}

	public int saveTreatmentEpisode(TreatmentEpisode treatmentEpisode) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into apm_treatment_episode (clientid,clientname,practitionerid,name,ref_date,ref_source,ref_name,ref_contact,ref_letter,payby,spendlimit,sessions,discahrgeletter,startdate,authcode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, treatmentEpisode.getClientId());
			preparedStatement.setString(2, treatmentEpisode.getClientName());
			preparedStatement.setString(3, treatmentEpisode.getDiaryUser());
			preparedStatement.setString(4, treatmentEpisode.getTreatmentEpisodeName());
			preparedStatement.setString(5, treatmentEpisode.getReferalDate());
			preparedStatement.setString(6, treatmentEpisode.getReferralSource());
			preparedStatement.setString(7, treatmentEpisode.getReferralName());
			preparedStatement.setString(8, treatmentEpisode.getReferralContact());
			preparedStatement.setString(9, treatmentEpisode.getReferralLetter());
			preparedStatement.setString(10, treatmentEpisode.getPayby());
			preparedStatement.setString(11, treatmentEpisode.getSpendLimit());
			preparedStatement.setString(12, treatmentEpisode.getConsultationLimit());
			preparedStatement.setString(13, treatmentEpisode.getDischargeLetter());
			preparedStatement.setString(14, treatmentEpisode.getTreatmentStartDate());
			preparedStatement.setString(15, treatmentEpisode.getAuthorisationCode());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<TreatmentEpisode> getTreatmentEpisodeList(String clientId) {
		PreparedStatement preparedStatement = null;
		ArrayList<TreatmentEpisode>list = new ArrayList<TreatmentEpisode>();
		String sql = "SELECT id,name FROM apm_treatment_episode where clientid="+clientId+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
				treatmentEpisode.setId(rs.getInt(1));
				treatmentEpisode.setTreatmentEpisodeName(rs.getString(2));
				list.add(treatmentEpisode);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public TreatmentEpisode getTreatmentEpisodeDetails(String tratmentepisodeid) {
		PreparedStatement preparedStatement = null;
		TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
		String sql = "SELECT id,authcode,sessions,payby FROM apm.apm_treatment_episode where id = "+tratmentepisodeid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				treatmentEpisode.setId(rs.getInt(1));
				treatmentEpisode.setAuthorisationCode(rs.getString(2));
				treatmentEpisode.setConsultationLimit(rs.getString(3));
				treatmentEpisode.setPayby(rs.getString(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return treatmentEpisode;
	}

	public int updateConsultationLimit(String sessions,
			String treatmentepisodeid) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_treatment_episode set sessions=? where id = "+treatmentepisodeid+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sessions);
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public TreatmentEpisode getParticularTreatEpiDetails(String id) {
		PreparedStatement preparedStatement = null;
		TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
		String sql = "SELECT id,clientid,clientname,practitionerid,name,ref_date,ref_source,ref_name,ref_contact,ref_letter,payby,spendlimit,sessions,discahrgeletter,startdate,authcode FROM apm.apm_treatment_episode where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				treatmentEpisode.setId(rs.getInt(1));
				treatmentEpisode.setClientId(rs.getInt(2));
				treatmentEpisode.setClientName(rs.getString(3));
				treatmentEpisode.setDiaryUser(rs.getString(4));
				treatmentEpisode.setTreatmentEpisodeName(rs.getString(5));
				treatmentEpisode.setReferalDate(rs.getString(6));
				treatmentEpisode.setReferralSource(rs.getString(7));
				treatmentEpisode.setReferralName(rs.getString(8));
				treatmentEpisode.setReferralContact(rs.getString(9));
				treatmentEpisode.setReferralLetter(rs.getString(10));
				treatmentEpisode.setPayby(rs.getString(11));
				treatmentEpisode.setSpendLimit(rs.getString(12));
				treatmentEpisode.setConsultationLimit(rs.getString(13));
				treatmentEpisode.setDischargeLetter(rs.getString(14));
				treatmentEpisode.setTreatmentStartDate(rs.getString(15));
				treatmentEpisode.setAuthorisationCode(rs.getString(16));
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return treatmentEpisode;
	}

	public ArrayList<TreatmentEpisode> getSourceOfReferralList() {
		PreparedStatement preparedStatement = null;
		ArrayList<TreatmentEpisode>list = new ArrayList<TreatmentEpisode>();
		String sql = "SELECT id,name FROM reference";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
				treatmentEpisode.setId(rs.getInt(1));
				treatmentEpisode.setReferralSource(rs.getString(2));
				list.add(treatmentEpisode);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateTreatmentEpisode(TreatmentEpisode treatmentEpisode, int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update apm_treatment_episode  set clientid = ?,clientname = ?,practitionerid = ?,name = ?,ref_date = ?,ref_source = ?,ref_name = ?,ref_contact = ?,ref_letter = ?,payby = ?,spendlimit = ?,sessions = ?,discahrgeletter = ?,startdate = ?,authcode = ? where id = "+id+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, treatmentEpisode.getClientId());
			preparedStatement.setString(2, treatmentEpisode.getClientName());
			preparedStatement.setString(3, treatmentEpisode.getDiaryUser());
			preparedStatement.setString(4, treatmentEpisode.getTreatmentEpisodeName());
			preparedStatement.setString(5, treatmentEpisode.getReferalDate());
			preparedStatement.setString(6, treatmentEpisode.getReferralSource());
			preparedStatement.setString(7, treatmentEpisode.getReferralName());
			preparedStatement.setString(8, treatmentEpisode.getReferralContact());
			preparedStatement.setString(9, treatmentEpisode.getReferralLetter());
			preparedStatement.setString(10, treatmentEpisode.getPayby());
			preparedStatement.setString(11, treatmentEpisode.getSpendLimit());
			preparedStatement.setString(12, treatmentEpisode.getConsultationLimit());
			preparedStatement.setString(13, treatmentEpisode.getDischargeLetter());
			preparedStatement.setString(14, treatmentEpisode.getTreatmentStartDate());
			preparedStatement.setString(15, treatmentEpisode.getAuthorisationCode());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteTreatmentEpisode(String id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from apm_treatment_episode where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
