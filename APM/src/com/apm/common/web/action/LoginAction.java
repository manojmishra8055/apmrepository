package com.apm.common.web.action;





import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;




import com.apm.Appointment.eu.bi.BranchDAO;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.Appointment.eu.blogic.jdbc.JDBCBranchDAO;
import com.apm.Appointment.eu.entity.Branch;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.utils.Encryption;
import com.apm.Appointment.web.form.BranchForm;
import com.apm.Registration.eu.bi.ClinicDAO;
import com.apm.Registration.eu.blogic.jdbc.JDBCClinicDAO;
import com.apm.Registration.eu.entity.Clinic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;





public class LoginAction extends BaseAction implements ModelDriven<BranchForm> {
	
	
	BranchForm branchForm = new BranchForm();
	
	
	
	public String execute() throws SQLException{
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
		
		ClinicDAO clinicDAO = new JDBCClinicDAO(connection);
		
		Clinic clinic = clinicDAO.getuser(branchForm.getUserId());
		if(!branchForm.getUserId().equals(clinic.getUserId()) ){
			addActionError(getText("error.userid.notexist"));
			return INPUT;
		}
		String encPassword = Encryption.encryptSHA(branchForm.getPassword());
		if(!encPassword.equals(clinic.getPassword())){
			addActionError(getText("error.user.authfailed"));
			return INPUT;
		}
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId(clinic.getId());
		loginInfo.setUserId(clinic.getUserId());
		loginInfo.setFirstName(clinic.getFirstName());
		loginInfo.setLastName(clinic.getLastName());
		loginInfo.setClinicOwner(clinic.getClinicOwner());
		loginInfo.setUserType(clinic.getUserType());
		
		
		session.setAttribute("logininfo", loginInfo);
		LoginHelper.saveLoginInfo(request, loginInfo);
		
		/*if(clinic.getUserType() == 1){
			
			return "adminuser";
		}else if(clinic.getUserType() == 2){
			
			return "clinicowneruser";
		}else if(clinic.getUserType() == 3){
			
			return "practicemanageruser";
		}else if(clinic.getUserType() == 4){
			
			return "practitioneruser";
		}else if(clinic.getUserType() == 5){
			
			return "patientuser";
		}
		*/
		
		}catch (Exception e) {
 			e.printStackTrace();
		}
		
		finally{
			connection.close();
		}
		
		return SUCCESS;
	}
	
	

	public void validate() {
	    	
    	 /* Do not use 'else if' since it will cause to show only one error at a time */
    	 // If user is null or empty add error in field errors
		 if ( branchForm.getUserId() == null || branchForm.getUserId().length() == 0) {
	            addFieldError("userId", getText("error.userid.required") );	// set error message form property file
		 }
		 // If password is null or empty add error to field errors
	     if ( branchForm.getPassword() == null ||  branchForm.getPassword().length() == 0) {
	            addFieldError("password", getText("error.password.required")); 	// set error message form property file
	     }
    }

	public BranchForm getModel() {
		// TODO Auto-generated method stub
		return branchForm;
	}

	

	
	
	

}
