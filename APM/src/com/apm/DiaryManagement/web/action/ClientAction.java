package com.apm.DiaryManagement.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.DiaryManagement.eu.bi.ClientDAO;
import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCClientDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCDiaryManagentDAO;
import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.DiaryManagement.eu.entity.CompleteAppointment;
import com.apm.DiaryManagement.web.form.ClientForm;
import com.apm.TreatmentEpisode.eu.bi.TreatmentEpisodeDAO;
import com.apm.TreatmentEpisode.eu.blogic.jdbc.JDBCTreatmentEpisode;
import com.apm.TreatmentEpisode.eu.entity.TreatmentEpisode;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.web.utils.PopulateData;
import com.apm.common.web.utils.PopulateList;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;





public class ClientAction extends BaseAction implements Preparable, ModelDriven<ClientForm> {

	ClientForm clientForm = new ClientForm();
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
	
	public String execute() throws Exception {
		
		if(!verifyLogin(request)){
			return "login";
		}
		
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> allPatientList = new ArrayList<Client>();
		try{
			connection = Connection_provider.getconnection();
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			allPatientList = clientDAO.getAllPatient();
			
			clientForm.setAllPatientList(allPatientList);
			
			
			StringBuffer str = new StringBuffer();
			

			
			str.append("<table width = '50%' id = 'allPatient' cellpadding='0' cellspacing='0' class='my-table' > ");
			str.append("<tr>");
			str.append("<th>Name</th> ");
			str.append("</tr>");
			
			for(Client client1:allPatientList){
			str.append("<tr>");
			String firstName= client1.getFirstName();
			str.append("<td onclick = setClientName('"+firstName+"','"+client1.getId()+"','"+client1.getType()+"','"+client1.getTypeName()+"')>"+client1.getFirstName()+" "+client1.getLastName()+"</td>");
			str.append("</tr>");
			}
			
			
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache");
			
			response.getWriter().write(""+str.toString()+""); 
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		
		return null;
	}
	public String manage() throws SQLException{
		if(!verifyLogin(request)){
			return "login";
		}
		
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> allPatientList = new ArrayList<Client>();
		try{
			connection = Connection_provider.getconnection();
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			int totalCount = clientDAO.getTotalClientCount();
			pagination.setPreperties(totalCount);
			
			allPatientList = clientDAO.getAllPatient(pagination);
			pagination.setPage_records(allPatientList.size());
			clientForm.setTotalRecords(totalCount);
			clientForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			
			
			clientForm.setAllPatientList(allPatientList);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "manage";
	}
	
	public String save() throws SQLException{
		Connection connection = null;
		try{
			
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			client.setTitle(clientForm.getTitle());
			client.setFirstName(clientForm.getFirstName());
			client.setLastName(clientForm.getLastName());
			client.setAddress(clientForm.getAddress());
			client.setCountry(clientForm.getCountry());
			client.setDob(clientForm.getDob());
			client.setEmail(clientForm.getEmail());
			client.setGender(clientForm.getGender());
			client.setMobNo(clientForm.getMobNo());
			client.setPostCode(clientForm.getPostCode());
			
			String other = "Other";
			if(clientForm.getReference().equalsIgnoreCase(other))
			{
				clientForm.setReference(clientForm.getOtherRef());
			}
			
			client.setReference(clientForm.getReference());
			client.setSourceOfIntro(clientForm.getSourceOfIntro());
			client.setTown(clientForm.getTown());
			client.setType(clientForm.getType());
			client.setTypeName(clientForm.getTypeName());
			if(clientForm.getOccupation().equalsIgnoreCase(other))
			{
				clientForm.setOccupation(clientForm.getOtherOccupation());
			}
			
			client.setOccupation(clientForm.getOccupation());
			client.setExpiryDate(clientForm.getExpiryDate());
			client.setWhopay(clientForm.getWhopay());
			client.setPolicyAuthorzCode(clientForm.getPolicyAuthorzCode());
			client.setPolicyNo(clientForm.getPolicyNo());
			
			
			
			client.setKnownAs(clientForm.getKnownAs());
			client.setCounty(clientForm.getCounty());
			client.setHomeNo(clientForm.getHomeNo());
			client.setWorkNo(clientForm.getWorkNo());
			client.setEmailCc(clientForm.getEmailCc());
			client.setPrefContactMode(clientForm.getPrefContactMode());
			client.setEmergencyContName(clientForm.getEmergencyContName());
			client.setEmergencyContNo(clientForm.getEmergencyContNo());
			client.setPatientType(clientForm.getPatientType());
			
			
			int result = clientDAO.savePatient(client);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return "save";
	}
	
	public String add() throws SQLException{
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> sourceOfIntroList = new ArrayList<String>();
		try{
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			clientForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			clientForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			clientForm.setInitialList(initialList);
			
			sourceOfIntroList = clientDAO.getSourceOfIntroList();
			clientForm.setSourceOfIntroList(sourceOfIntroList);
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return null;
	}
	
	public String addPatient() throws SQLException{
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> sourceOfIntroList = new ArrayList<String>();
		try{
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			clientForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			clientForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			clientForm.setInitialList(initialList);
			
			sourceOfIntroList = clientDAO.getSourceOfIntroList();
			clientForm.setSourceOfIntroList(sourceOfIntroList);
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "addPatient";
	}
	public String edit() throws SQLException{
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		Connection connection = null;
		try{
			int id = Integer.parseInt(request.getParameter("selectedid"));
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			clientForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			clientForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			clientForm.setInitialList(initialList);
			
			client = clientDAO.getPatient(id);
			clientForm.setTitle(client.getTitle());
			clientForm.setFirstName(client.getFirstName());
			clientForm.setLastName(client.getLastName());
			clientForm.setAddress(client.getAddress());
			clientForm.setCountry(client.getCountry());
			clientForm.setDob(client.getDob());
			clientForm.setEmail(client.getEmail());
			clientForm.setGender(client.getGender());
			clientForm.setMobNo(client.getMobNo());
			clientForm.setPostCode(client.getPostCode());
			clientForm.setReference(client.getReference());
			clientForm.setSourceOfIntro(client.getSourceOfIntro());
			clientForm.setTown(client.getTown());
			clientForm.setId(client.getId());
			clientForm.setType(client.getType());
			clientForm.setTypeName(client.getTypeName());
			clientForm.setExpiryDate(client.getExpiryDate());
			clientForm.setOccupation(client.getOccupation());
			
			clientForm.setExpiryDate(client.getExpiryDate());
			clientForm.setWhopay(client.getWhopay());
			clientForm.setPolicyAuthorzCode(client.getPolicyAuthorzCode());
			clientForm.setPolicyNo(client.getPolicyNo());
			clientForm.setKnownAs(client.getKnownAs());
			clientForm.setCounty(client.getCounty());
			clientForm.setHomeNo(client.getHomeNo());
			clientForm.setWorkNo(client.getWorkNo());
			clientForm.setEmailCc(client.getEmailCc());
			clientForm.setPrefContactMode(client.getPrefContactMode());
			clientForm.setEmergencyContName(client.getEmergencyContName());
			clientForm.setEmergencyContNo(client.getEmergencyContNo());
			clientForm.setPatientType(client.getPatientType());
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "editClientPage";
	}
	
	public String editPatient() throws SQLException{
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		Connection connection = null;
		try{
			int id = Integer.parseInt(request.getParameter("selectedid"));
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			clientForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			clientForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			clientForm.setInitialList(initialList);
			
			client = clientDAO.getPatient(id);
			clientForm.setTitle(client.getTitle());
			clientForm.setFirstName(client.getFirstName());
			clientForm.setLastName(client.getLastName());
			clientForm.setAddress(client.getAddress());
			clientForm.setCountry(client.getCountry());
			clientForm.setDob(client.getDob());
			clientForm.setEmail(client.getEmail());
			clientForm.setGender(client.getGender());
			clientForm.setMobNo(client.getMobNo());
			clientForm.setPostCode(client.getPostCode());
			clientForm.setReference(client.getReference());
			clientForm.setSourceOfIntro(client.getSourceOfIntro());
			clientForm.setTown(client.getTown());
			clientForm.setId(client.getId());
			clientForm.setType(client.getType());
			clientForm.setTypeName(client.getTypeName());
			clientForm.setExpiryDate(client.getExpiryDate());
			clientForm.setOccupation(client.getOccupation());
			
			clientForm.setExpiryDate(client.getExpiryDate());
			clientForm.setWhopay(client.getWhopay());
			clientForm.setPolicyAuthorzCode(client.getPolicyAuthorzCode());
			clientForm.setPolicyNo(client.getPolicyNo());
			clientForm.setKnownAs(client.getKnownAs());
			clientForm.setCounty(client.getCounty());
			clientForm.setHomeNo(client.getHomeNo());
			clientForm.setWorkNo(client.getWorkNo());
			clientForm.setEmailCc(client.getEmailCc());
			clientForm.setPrefContactMode(client.getPrefContactMode());
			clientForm.setEmergencyContName(client.getEmergencyContName());
			clientForm.setEmergencyContNo(client.getEmergencyContNo());
			clientForm.setPatientType(client.getPatientType());
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "editPatientPage";
	}
	
	public String update() throws SQLException{
		Connection connection = null;
		try{
			int id = clientForm.getId();
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			client.setTitle(clientForm.getTitle());
			client.setFirstName(clientForm.getFirstName());
			client.setLastName(clientForm.getLastName());
			client.setAddress(clientForm.getAddress());
			client.setCountry(clientForm.getCountry());
			client.setDob(clientForm.getDob());
			client.setEmail(clientForm.getEmail());
			client.setGender(clientForm.getGender());
			client.setMobNo(clientForm.getMobNo());
			client.setPostCode(clientForm.getPostCode());
			String other = "Other";
			if(clientForm.getReference().equalsIgnoreCase(other))
			{
				clientForm.setReference(clientForm.getOtherRef());
			}
			
			client.setReference(clientForm.getReference());
			client.setSourceOfIntro(clientForm.getSourceOfIntro());
			client.setTown(clientForm.getTown());
			client.setType(clientForm.getType());
			client.setTypeName(clientForm.getTypeName());
			
			if(clientForm.getOccupation().equalsIgnoreCase(other))
			{
				clientForm.setOccupation(clientForm.getOtherOccupation());
			}
			
			client.setOccupation(clientForm.getOccupation());
			client.setExpiryDate(clientForm.getExpiryDate());
			client.setWhopay(clientForm.getWhopay());
			client.setPolicyAuthorzCode(clientForm.getPolicyAuthorzCode());
			client.setPolicyNo(clientForm.getPolicyNo());
			client.setKnownAs(clientForm.getKnownAs());
			client.setCounty(clientForm.getCounty());
			client.setHomeNo(clientForm.getHomeNo());
			client.setWorkNo(clientForm.getWorkNo());
			client.setEmailCc(clientForm.getEmailCc());
			client.setPrefContactMode(clientForm.getPrefContactMode());
			client.setEmergencyContName(clientForm.getEmergencyContName());
			client.setEmergencyContNo(clientForm.getEmergencyContNo());
			client.setPatientType(clientForm.getPatientType());
			int result = clientDAO.updatePatient(client,id);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "updateClient";
	}
	
	public String delete() throws SQLException{
		int result = 0;
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		Client client = new Client();
		try{
			
			connection = Connection_provider.getconnection();
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			
			result = clientDAO.deleteClient(id,client);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "deletePatient";
	}
	//Client Third Party Log // Unnati date : 19th march
	
	public String thirdPartyLog() throws SQLException{
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		try{
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "thirdPartyLog";
	}
	
	
	public String setTypeNameDropDown(){
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			 
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			 ArrayList<Client>ajaxTypeNameList = clientDAO.getThirdTypeNameList(id);
			 
			 StringBuffer dropDownAjax = new StringBuffer();
				dropDownAjax.append("<select id='typeName' name = 'typeName'>");
					dropDownAjax.append("<option value = '0'>Select 3rd Party Name</option>");
					if(ajaxTypeNameList.size()!=0){
						for(Client client : ajaxTypeNameList){
							dropDownAjax.append("<option value = '"+client.getId()+"'>"+client.getThirdPartyCompanyName()+"</option>");
						}
						
					}
				dropDownAjax.append("</select>");
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				
				response.getWriter().write(""+dropDownAjax.toString()+""); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
		
	}
	
	public String updateThirdPartyDetails(){
		Connection connection = null;
		try{
			String id = clientForm.getClientId();
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			
			client.setType(clientForm.getType());
			client.setTypeName(clientForm.getTypeName());
			int result = clientDAO.updateThirdPartyDetails(client,id);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return "updateThirdPartyDetails";
	}
	
	public String addOtherOccupation() throws SQLException{
		String otherOccupation = request.getParameter("otherOccupation");
		Connection connection = null;
		try{
			String id = clientForm.getClientId();
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			
			
			int result = clientDAO.insertOtherOccupation(client,otherOccupation);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return null;
	}
	
	public String addOtherReference() throws SQLException{
		String otherReference = request.getParameter("otherReference");
		Connection connection = null;
		try{
			String id = clientForm.getClientId();
			Client client = new Client();
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			
			
			int result = clientDAO.insertOtherReference(client,otherReference);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return null;
	}
	
	public String search() throws SQLException{
		String searchClient = clientForm.getSearchText();
		Connection connection = null;
		ArrayList<Client> allPatientList = new ArrayList<Client>();
		try{
			connection = Connection_provider.getconnection();
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			allPatientList = clientDAO.getClient(searchClient);
			
			clientForm.setAllPatientList(allPatientList);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		
		return "manage";
	}
	
	public String searchParticular() throws SQLException{
		String searchClient = clientForm.getSearchText();
		Connection connection = null;
		ArrayList<Client> allPatientList = new ArrayList<Client>();
		try{
			connection = Connection_provider.getconnection();
			
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			allPatientList = clientDAO.getClient(searchClient);
			
			clientForm.setAllPatientList(allPatientList);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return SUCCESS;
	}
	

	
	public void prepare() throws Exception {
		Connection connection = null;
		Client client = new Client();
		ArrayList<Client> thirdPartyTypeList = new ArrayList<Client>();
		ArrayList<Client> thirdPartyTypeNameList = new ArrayList<Client>();
		ArrayList<String> clientOccupationList = new ArrayList<String>();
		ArrayList<String> refrenceList = new ArrayList<String>();
		ArrayList<String> initialList = new ArrayList<String>();
		ArrayList<String> sourceOfIntroList = new ArrayList<String>();
		try{
			
			connection = Connection_provider.getconnection();
			ClientDAO clientDAO = new JDBCClientDAO(connection);
			thirdPartyTypeList = clientDAO.getThirdPartyType();
			clientForm.setThirdPartyTypeList(thirdPartyTypeList);
			
			thirdPartyTypeNameList = clientDAO.getThirdPartyTypeName();
			clientForm.setThirdPartyTypeNameList(thirdPartyTypeNameList);
			
			clientOccupationList = clientDAO.getOccupationList();
			clientOccupationList.add("Other");
			
			clientForm.setClientOccupationList(clientOccupationList);
			
			refrenceList = clientDAO.getReferenceList();
			refrenceList.add("Other");
			clientForm.setRefrenceList(refrenceList);
			
			initialList = clientDAO.getInitialList();
			clientForm.setInitialList(initialList);
			
			sourceOfIntroList = clientDAO.getSourceOfIntroList();
			clientForm.setSourceOfIntroList(sourceOfIntroList);
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		clientForm.setCountryList(PopulateList.countryList());
		clientForm.setOccupationList(PopulateList.occupationList());
	}

	public ClientForm getModel() {
		
		return clientForm;
	}
}