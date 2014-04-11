package com.apm.Master.eu.blogic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.Master.eu.bi.MasterDAO;
import com.apm.Master.eu.entity.Master;
import com.apm.common.eu.blogic.jdbc.JDBCBaseDAO;
import com.apm.common.utils.Pagination;

public class JDBCMasterDAO extends JDBCBaseDAO implements MasterDAO{
	
	public JDBCMasterDAO(Connection connection){
		this.connection = connection;
		
	}

	
	public ArrayList<Master> getOccupationList(Pagination pagination) {
		
		PreparedStatement preparedStatement = null;
		ArrayList<Master>list = new ArrayList<Master>();
		String sql = "SELECT id,occupation FROM occupation";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				Master master = new Master();
				
				master.setId(rs.getInt(1));
				master.setOccupation(rs.getString(2));
				
				list.add(master);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int getTotalOccupationCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from occupation";
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


	
	public int saveOccupation(Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into occupation(occupation) values(?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getOccupation());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	public Master getOccupation(int id,Master master) {
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT id,occupation FROM occupation where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				master.setId(rs.getInt(1));
				master.setOccupation(rs.getString(2));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return master;
	}



	public int updateOccupation(Master master, int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update occupation set occupation = ? where id = "+id+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getOccupation());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int deleteOccupation(int id, Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from occupation where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	
	public ArrayList<Master> getJobTitleList(Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<Master>list = new ArrayList<Master>();
		String sql = "SELECT id,jobtitle FROM job_title";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				Master master = new Master();
				
				master.setId(rs.getInt(1));
				master.setJobTitle(rs.getString(2));
				
				list.add(master);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	
	public int getTotalJobTitleCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from job_title";
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


	public int saveJobTitle(Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into job_title(jobtitle) values(?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getJobTitle());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	public Master getJobTitle(int id, Master master) {
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT id,jobtitle FROM job_title where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				master.setId(rs.getInt(1));
				master.setJobTitle(rs.getString(2));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return master;
	}


	public int updateJobTitle(Master master, int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update job_title set jobtitle = ? where id = "+id+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getJobTitle());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	public int deleteJobTitle(int id, Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from job_title where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Master> getReferenceList(Pagination pagination) {
		PreparedStatement preparedStatement = null;
		ArrayList<Master>list = new ArrayList<Master>();
		String sql = "SELECT id,name FROM reference";
		sql = pagination.getSQLQuery(sql);
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				Master master = new Master();
				
				master.setId(rs.getInt(1));
				master.setReference(rs.getString(2));
				
				list.add(master);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public int getTotalReferenceCount() {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String sql = "select count(*) from reference";
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


	public int saveReference(Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "insert into reference(name) values(?)";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getReference());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}


	public Master getReference(int id, Master master) {
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT id,name FROM reference where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				
				master.setId(rs.getInt(1));
				master.setReference(rs.getString(2));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return master;
	}


	public int updateReference(Master master, int id) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "update reference set name = ? where id = "+id+"";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, master.getReference());
			
			result = preparedStatement.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int deleteReference(int id, Master master) {
		PreparedStatement preparedStatement = null;
		int result = 0;
		String sql = "delete from reference where id = "+id+" ";
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			
			result = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}