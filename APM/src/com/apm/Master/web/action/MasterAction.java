package com.apm.Master.web.action;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.Appointment.eu.bi.AppointmentTypeDAO;
import com.apm.Appointment.eu.blogic.jdbc.JDBCAppointmentTypeDAO;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.Appointment.web.form.AppointmentTypeForm;
import com.apm.Master.eu.bi.MasterDAO;
import com.apm.Master.eu.blogic.jdbc.JDBCMasterDAO;
import com.apm.Master.eu.entity.Master;
import com.apm.Master.web.form.MasterForm;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MasterAction extends BaseAction implements Preparable, ModelDriven<MasterForm>{
	
	MasterForm masterForm = new MasterForm();
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	private Pagination pagination = new Pagination(20, 1);
	public Pagination getPagination() {
		return pagination;
	}


	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public String occupation() {
		
		if(!verifyLogin(request)){
			return "login";
		}
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			int totalCount = masterDAO.getTotalOccupationCount();
			pagination.setPreperties(totalCount);
			
			ArrayList<Master>occupationList = masterDAO.getOccupationList(pagination);
			pagination.setPage_records(occupationList.size());
			masterForm.setTotalRecords(totalCount);
			masterForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			masterForm.setOccupationList(occupationList);
		}
		catch (Exception e) {
			
		}
		
		return "occupationPage";
		
	}
	
	public String addOccupation(){
		
		
		
		return "addOccupationPage";
	}
	
	public String saveOccupation(){
		Connection connection = null;
		int result = 0;
		try{
			connection = Connection_provider.getconnection();
			Master master = new Master();
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			master.setOccupation(masterForm.getOccupation());
		
			
			result = masterDAO.saveOccupation(master);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "saveOccupationSucess";
	}

	public String editOccupation(){
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		
		Master master = new Master();
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master = masterDAO.getOccupation(id,master);
			masterForm.setId(master.getId());
			masterForm.setOccupation(master.getOccupation());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return "editOccupationPage";
	}
	
	public String updateOccupation(){
		Connection connection = null;
		int result = 0;
		try{
			int id = masterForm.getId();
			connection = Connection_provider.getconnection();
			Master master = new Master();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master.setOccupation(masterForm.getOccupation());
		
			result = masterDAO.updateOccupation(master,id);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "updateOccupation";
	}
	
	public String deleteOccupation(){
		int result = 0;
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		Master master = new Master();
		
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			
			result = masterDAO.deleteOccupation(id,master);	
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return "deleteOccupation";
	}
	
	public String jobTitle(){
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			int totalCount = masterDAO.getTotalJobTitleCount();
			pagination.setPreperties(totalCount);
			
			ArrayList<Master>jobTitleList = masterDAO.getJobTitleList(pagination);
			pagination.setPage_records(jobTitleList.size());
			masterForm.setTotalRecords(totalCount);
			masterForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			masterForm.setJobTitleList(jobTitleList);
		}
		catch (Exception e) {
			
		}
		return "jobTitlePage";
		
	}
	
	public String addJobTitle(){
		return "addJobTitlePage";
	}
	
	public String saveJobTitle(){
		Connection connection = null;
		int result = 0;
		try{
			connection = Connection_provider.getconnection();
			Master master = new Master();
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master.setJobTitle(masterForm.getJobTitle());
			
			result = masterDAO.saveJobTitle(master);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "saveJobTitleSucess";
		
	}
	public String editJobTitle(){
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		
		Master master = new Master();
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master = masterDAO.getJobTitle(id,master);
			masterForm.setId(master.getId());
			masterForm.setJobTitle(master.getJobTitle());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "editJobTitlePage";
	}
	
	public String updateJobTitle(){
		Connection connection = null;
		int result = 0;
		try{
			int id = masterForm.getId();
			connection = Connection_provider.getconnection();
			Master master = new Master();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master.setJobTitle(masterForm.getJobTitle());
		
			result = masterDAO.updateJobTitle(master,id);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "updateJobTitle";
	}
	
	public String deleteJobTitle(){
		int result = 0;
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		Master master = new Master();
		
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			
			result = masterDAO.deleteJobTitle(id,master);	
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return "deleteJobTitle";
	}
	
	public String reference(){
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			int totalCount = masterDAO.getTotalReferenceCount();
			pagination.setPreperties(totalCount);
			
			ArrayList<Master>referenceList = masterDAO.getReferenceList(pagination);
			pagination.setPage_records(referenceList.size());
			masterForm.setTotalRecords(totalCount);
			masterForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			masterForm.setReferenceList(referenceList);
		}
		catch (Exception e) {
			
		}
		return "referencePage";
	}
	
	public String addReference(){
		return "addReferencePage";
	}
	
	public String saveReference(){
		Connection connection = null;
		int result = 0;
		try{
			connection = Connection_provider.getconnection();
			Master master = new Master();
			
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			master.setReference(masterForm.getReference());
			
			result = masterDAO.saveReference(master);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "saveReferenceSucess";
	}
	
	public String editReference(){
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		
		Master master = new Master();
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			master = masterDAO.getReference(id,master);
			masterForm.setId(master.getId());
			masterForm.setReference(master.getReference());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return "editReferencePage";
		
	}
	
	public String updateReference(){
		Connection connection = null;
		int result = 0;
		try{
			int id = masterForm.getId();
			connection = Connection_provider.getconnection();
			Master master = new Master();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			master.setReference(masterForm.getReference());
			result = masterDAO.updateReference(master,id);
			
		}
		catch (Exception e) {
			
		}
		return "updateReference";
	}
	
	public String deleteReference(){
		int result = 0;
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		Master master = new Master();
		
		try{
			
			connection = Connection_provider.getconnection();
			MasterDAO masterDAO = new JDBCMasterDAO(connection);
			
			
			result = masterDAO.deleteReference(id,master);	
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return  "deleteReference";
	}
	public void prepare() throws Exception {
		
		
	}


	
	public MasterForm getModel() {
		
		return masterForm;
	}
}