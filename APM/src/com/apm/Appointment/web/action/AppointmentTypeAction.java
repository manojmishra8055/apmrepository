package com.apm.Appointment.web.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.security.krb5.internal.APOptions;

import com.apm.Appointment.eu.bi.AppointmentDAO;
import com.apm.Appointment.eu.bi.AppointmentTypeDAO;
import com.apm.Appointment.eu.blogic.jdbc.JDBCAppointmentDAO;
import com.apm.Appointment.eu.blogic.jdbc.JDBCAppointmentTypeDAO;
import com.apm.Appointment.eu.entity.AppointmentType;
import com.apm.Appointment.web.form.AppointmentForm;
import com.apm.Appointment.web.form.AppointmentTypeForm;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.Pagination;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.web.utils.PopulateList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.corba.se.impl.oa.poa.AOMEntry;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

public class AppointmentTypeAction extends BaseAction implements Preparable, ModelDriven<AppointmentTypeForm>{
	
	
	AppointmentTypeForm appointmentTypeForm = new AppointmentTypeForm();
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
		try{
			connection = Connection_provider.getconnection();
			
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			
			
			int totalCount = appointmentTypeDAO.getTotalApmtTypeCount();
			pagination.setPreperties(totalCount);
			
			ArrayList<AppointmentType>appointmentTypeList = appointmentTypeDAO.getAppointmentTypeList(pagination);
			pagination.setPage_records(appointmentTypeList.size());
			appointmentTypeForm.setTotalRecords(totalCount);
			appointmentTypeForm.setPagerecords(Integer.toString(pagination.getPage_records()));
			appointmentTypeForm.setAppointmentTypeList(appointmentTypeList);
		}
		catch (Exception e) {
			
		}
		finally{
			connection.close();
		}
		
		
		return SUCCESS;
		
		
}
	
	public String add() throws SQLException{
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			ArrayList<AppointmentType>colorList = appointmentTypeDAO.getColorList();
			
			appointmentTypeForm.setColorList(colorList);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		
		return "addAppointmentPage";
	}

	public String save() throws SQLException{
		Connection connection = null;
		int result = 0;
		try{
			connection = Connection_provider.getconnection();
			AppointmentType appointmentType = new AppointmentType();
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			
			appointmentType.setName(appointmentTypeForm.getName());
			appointmentType.setDescription(appointmentTypeForm.getDescription());
			appointmentType.setCategory(appointmentTypeForm.getCategory());
			appointmentType.setDuration(appointmentTypeForm.getDuration());
			appointmentType.setColor(appointmentTypeForm.getColor());
			appointmentType.setCharges(appointmentTypeForm.getCharges());
			
			
			result = appointmentTypeDAO.saveAppointmentType(appointmentType);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "save";
	}
	
	public String edit() throws SQLException{
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		AppointmentType appointmentType = new AppointmentType();
		try{
			
			connection = Connection_provider.getconnection();
			
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			
			ArrayList<AppointmentType>colorList = appointmentTypeDAO.getColorList();
			
			appointmentTypeForm.setColorList(colorList);
			appointmentType = appointmentTypeDAO.getAppointment(id);
			appointmentTypeForm.setId(appointmentType.getId());
			appointmentTypeForm.setName(appointmentType.getName());
			appointmentTypeForm.setDescription(appointmentType.getDescription());
			appointmentTypeForm.setCategory(appointmentType.getCategory());
			appointmentTypeForm.setDuration(appointmentType.getDuration());
			appointmentTypeForm.setColor(appointmentType.getColor());
			appointmentTypeForm.setCharges(appointmentType.getCharges());
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		
		return "editPage";
	}
	
	public String update() throws SQLException{
		Connection connection = null;
		int result = 0;
		try{
			int id = appointmentTypeForm.getId();
			connection = Connection_provider.getconnection();
			AppointmentType appointmentType = new AppointmentType();
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			
			appointmentType.setName(appointmentTypeForm.getName());
			appointmentType.setDescription(appointmentTypeForm.getDescription());
			appointmentType.setCategory(appointmentTypeForm.getCategory());
			appointmentType.setDuration(appointmentTypeForm.getDuration());
			appointmentType.setColor(appointmentTypeForm.getColor());
			appointmentType.setCharges(appointmentTypeForm.getCharges());
			
			
			result = appointmentTypeDAO.updateAppointmentType(appointmentType,id);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		return "update";
	}
	public String delete() throws SQLException{
		int result = 0;
		int id =Integer.parseInt(request.getParameter("selectedid"));
		Connection connection = null;
		AppointmentType appointmentType = new AppointmentType();
		try{
			
			connection = Connection_provider.getconnection();
			
			AppointmentTypeDAO appointmentTypeDAO = new JDBCAppointmentTypeDAO(connection);
			
			result = appointmentTypeDAO.deleteAppoitmentType(id,appointmentType);
			
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			connection.close();
		}
		
		return "delete";
	}
	
	
	public void prepare() throws Exception {
		appointmentTypeForm.setApmtDurationList(PopulateList.apmtDurationList());

		
	}

	public AppointmentTypeForm getModel() {
		
		return appointmentTypeForm;
	}
}