package com.apm.TreatmentEpisode.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.DiaryManagement.eu.bi.CompleteAptmDAO;
import com.apm.DiaryManagement.eu.bi.NotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCCompleteAptmDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCNotAvailableSlotDAO;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.TreatmentEpisode.eu.bi.TreatmentEpisodeDAO;
import com.apm.TreatmentEpisode.eu.blogic.jdbc.JDBCTreatmentEpisode;
import com.apm.TreatmentEpisode.eu.entity.TreatmentEpisode;
import com.apm.TreatmentEpisode.web.form.TreatmentEpisodeForm;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class TreatmentEpisodeAction extends BaseAction implements Preparable, ModelDriven<TreatmentEpisodeForm>{

	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	TreatmentEpisodeForm treatmwntEpisodeForm = new TreatmentEpisodeForm();
	
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	
	
	public String save() throws SQLException{
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			
			TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
			
			treatmentEpisode.setClientId(treatmwntEpisodeForm.getClientId());
			treatmentEpisode.setTreatmentStartDate(treatmwntEpisodeForm.getTreatmentStartDate());
			treatmentEpisode.setClientName(treatmwntEpisodeForm.getInvoicee());
			treatmentEpisode.setDiaryUser(treatmwntEpisodeForm.getDiaryUser());
			treatmentEpisode.setTreatmentEpisodeName(treatmwntEpisodeForm.getTreatmentEpisodeName());
			treatmentEpisode.setReferalDate(treatmwntEpisodeForm.getReferalDate());
			treatmentEpisode.setReferralName(treatmwntEpisodeForm.getReferralName());
			treatmentEpisode.setReferralSource(treatmwntEpisodeForm.getReferralSource());
			treatmentEpisode.setReferralContact(treatmwntEpisodeForm.getReferralContact());
			treatmentEpisode.setReferralLetter(treatmwntEpisodeForm.getReferralLetter());
			treatmentEpisode.setPayby(treatmwntEpisodeForm.getPayby());
			treatmentEpisode.setAuthorisationCode(treatmwntEpisodeForm.getAuthorisationCode());
			treatmentEpisode.setSpendLimit(treatmwntEpisodeForm.getSpendLimit());
			treatmentEpisode.setConsultationLimit(treatmwntEpisodeForm.getConsultationLimit());
			treatmentEpisode.setDischargeLetter(treatmwntEpisodeForm.getDischargeLetter());
			
			int result = treatmentEpisodeDAO.saveTreatmentEpisode(treatmentEpisode);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		return null;
	}
	
	
	public String change() throws SQLException{
		Connection connection = null;
		String sessions = request.getParameter("sessions");
		String treatmentepisodeid = request.getParameter("tratmentepisodeid");
		try{
			
			connection = Connection_provider.getconnection();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			
			int reult = treatmentEpisodeDAO.updateConsultationLimit(sessions,treatmentepisodeid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		return null;
	}
	
	
	public String set() throws SQLException{
		
		Connection connection = null;
		String clientId = request.getParameter("clientid");
		try{
			
			connection = Connection_provider.getconnection();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			
			ArrayList<TreatmentEpisode>treatmentEpisodeList = treatmentEpisodeDAO.getTreatmentEpisodeList(clientId);
			
			StringBuffer str = new StringBuffer();
			str.append("<select name='treatmentEpisode' id='treatmentEpisode' style='width:157px'>");
			str.append("<option value='0'>Select Treatment Episode</option>");
			for(TreatmentEpisode treatmentEpisode : treatmentEpisodeList){
				str.append("<option value='"+treatmentEpisode.getId()+"'>"+treatmentEpisode.getTreatmentEpisodeName()+"</option>");
			}
			str.append("</select>");
			str.append("<a href='inputTreatmentEpisode' style='text-decoration: none' target='blank' onclick='window.open(this.href, 'mywin', ");
			str.append("'left=20,top=20,width=800,height=500,toolbar=1,resizable=0'); return false;'> <input type='button' value = 'Add' class = 'buttons' disabled='disabled'></a>");
			str.append("");
			
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(""+str.toString()+""); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return null;
	}
	
	
	public String details() throws SQLException{
		Connection connection = null;
		String tratmentepisodeid = request.getParameter("tratmentepisodeid");
		try{
			
			connection = Connection_provider.getconnection();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			
			TreatmentEpisode treatmentEpisode = treatmentEpisodeDAO.getTreatmentEpisodeDetails(tratmentepisodeid);
			
			StringBuffer str = new StringBuffer();
			str.append(treatmentEpisode.getAuthorisationCode() + "/" + treatmentEpisode.getConsultationLimit() + "/" + treatmentEpisode.getPayby());
			
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(""+str.toString()+""); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return null;
	}
	
	
	public String thirdparty() throws SQLException{
		Connection connection = null;
		String clientId = request.getParameter("clientid");
		try{
			
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			CompleteAppointment completeAppointment =  completeAptmDAO.getInsuranceCompanyName(clientId);
			
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(""+completeAppointment.getInsuranceCompanyName()+""); 
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		return null;
	}
	
	public String show() throws SQLException{
		
		int id = treatmwntEpisodeForm.getClientId();
		String clientId = Integer.toString(id);
		Connection connection = null;
		
		try{
			
			connection = Connection_provider.getconnection();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			ArrayList<TreatmentEpisode>treatmentEpisodeList = new ArrayList<TreatmentEpisode>();
			
			treatmentEpisodeList = treatmentEpisodeDAO.getTreatmentEpisodeList(clientId);
			treatmwntEpisodeForm.setTreatmentEpisodeList(treatmentEpisodeList);
			treatmwntEpisodeForm.setClient(treatmwntEpisodeForm.getClient());
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return "showTreatmentEpisode";
	}
	
	public String addPage() throws SQLException{
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			ArrayList<TreatmentEpisode> sourceOfReferralList = treatmentEpisodeDAO.getSourceOfReferralList();
			treatmwntEpisodeForm.setSourceOfReferralList(sourceOfReferralList);
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return "addTreatmentPage";
	}
	
	public String edit() throws SQLException{
		String id = request.getParameter("selectedid");
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			ArrayList<TreatmentEpisode> sourceOfReferralList = treatmentEpisodeDAO.getSourceOfReferralList();
			treatmwntEpisodeForm.setSourceOfReferralList(sourceOfReferralList);
			TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
			
			treatmentEpisode = treatmentEpisodeDAO.getParticularTreatEpiDetails(id);
			treatmwntEpisodeForm.setId(treatmentEpisode.getId());
			treatmwntEpisodeForm.setClientId(treatmentEpisode.getClientId());
			treatmwntEpisodeForm.setTreatmentStartDate(treatmentEpisode.getTreatmentStartDate());
			treatmwntEpisodeForm.setClientName(treatmentEpisode.getClientName());
			treatmwntEpisodeForm.setDiaryUser(treatmentEpisode.getDiaryUser());
			treatmwntEpisodeForm.setTreatmentEpisodeName(treatmentEpisode.getTreatmentEpisodeName());
			treatmwntEpisodeForm.setReferalDate(treatmentEpisode.getReferalDate());
			treatmwntEpisodeForm.setReferralName(treatmentEpisode.getReferralName());
			treatmwntEpisodeForm.setReferralSource(treatmentEpisode.getReferralSource());
			treatmwntEpisodeForm.setReferralContact(treatmentEpisode.getReferralContact());
			treatmwntEpisodeForm.setReferralLetter(treatmentEpisode.getReferralLetter());
			treatmwntEpisodeForm.setPayby(treatmentEpisode.getPayby());
			treatmwntEpisodeForm.setAuthorisationCode(treatmentEpisode.getAuthorisationCode());
			treatmwntEpisodeForm.setSpendLimit(treatmentEpisode.getSpendLimit());
			treatmwntEpisodeForm.setConsultationLimit(treatmentEpisode.getConsultationLimit());
			treatmwntEpisodeForm.setDischargeLetter(treatmentEpisode.getDischargeLetter());
			treatmwntEpisodeForm.setClient(treatmentEpisode.getClientName());
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return "editTreatmentEpisodePage";
	}
		
	public String updateSave() throws SQLException{
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			CompleteAptmDAO completeAptmDAO = new JDBCCompleteAptmDAO(connection);
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			
			TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
			int id = treatmwntEpisodeForm.getId();
			treatmentEpisode.setClientId(treatmwntEpisodeForm.getClientId());
			treatmentEpisode.setTreatmentStartDate(treatmwntEpisodeForm.getTreatmentStartDate());
			treatmentEpisode.setClientName(treatmwntEpisodeForm.getInvoicee());
			treatmentEpisode.setDiaryUser(treatmwntEpisodeForm.getDiaryUser());
			treatmentEpisode.setTreatmentEpisodeName(treatmwntEpisodeForm.getTreatmentEpisodeName());
			treatmentEpisode.setReferalDate(treatmwntEpisodeForm.getReferalDate());
			treatmentEpisode.setReferralName(treatmwntEpisodeForm.getReferralName());
			treatmentEpisode.setReferralSource(treatmwntEpisodeForm.getReferralSource());
			treatmentEpisode.setReferralContact(treatmwntEpisodeForm.getReferralContact());
			treatmentEpisode.setReferralLetter(treatmwntEpisodeForm.getReferralLetter());
			treatmentEpisode.setPayby(treatmwntEpisodeForm.getPayby());
			treatmentEpisode.setAuthorisationCode(treatmwntEpisodeForm.getAuthorisationCode());
			treatmentEpisode.setSpendLimit(treatmwntEpisodeForm.getSpendLimit());
			treatmentEpisode.setConsultationLimit(treatmwntEpisodeForm.getConsultationLimit());
			treatmentEpisode.setDischargeLetter(treatmwntEpisodeForm.getDischargeLetter());
			
			int result = treatmentEpisodeDAO.updateTreatmentEpisode(treatmentEpisode,id);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
		return "updateSave";
	}
	
	public String delete() throws SQLException{
		
		String id = request.getParameter("selectedid");
		int result = 0;
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			TreatmentEpisode treatmentEpisode = new TreatmentEpisode();
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			result = treatmentEpisodeDAO.deleteTreatmentEpisode(id); 
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		return "deleteTreatmentEpisode";
	}
	public TreatmentEpisodeForm getModel() {
		
		return treatmwntEpisodeForm;
	}

	public void prepare() throws Exception {
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			NotAvailableSlotDAO notAvailableSlotDAO = new JDBCNotAvailableSlotDAO(connection);
			
			ArrayList<DiaryManagement>userList = notAvailableSlotDAO.getUserList(loginInfo.getId());
			treatmwntEpisodeForm.setUserList(userList);
			
			TreatmentEpisodeDAO treatmentEpisodeDAO = new JDBCTreatmentEpisode(connection);
			ArrayList<TreatmentEpisode> sourceOfReferralList = treatmentEpisodeDAO.getSourceOfReferralList();
			treatmwntEpisodeForm.setSourceOfReferralList(sourceOfReferralList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
			connection.close();
		}
		
	}
		

}
