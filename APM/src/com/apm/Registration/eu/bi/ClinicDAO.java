package com.apm.Registration.eu.bi;

import java.util.ArrayList;

import com.apm.Registration.eu.entity.Clinic;
import com.apm.common.utils.Pagination;


import com.apm.Registration.eu.entity.Clinic;

public interface ClinicDAO {
	
	int deleteClinicList(int selectedid);
	int updateCliniclist(Clinic cliniclist);
	ArrayList<Clinic> getClinicLocationList(int selectedid);
	
	Clinic getCliniclistDetails(int selectedid);
	
	int saveLocation(int selectedid, int locationid, Clinic cliniclist);
	
	int getCliniclistCount(String searchText)throws Exception;
	
	ArrayList<Clinic> getClinicList(Pagination pagination,String searchText)throws Exception;

	boolean isUserExist(String userid);

	int saveClinic(Clinic clinic);

	int saveAdminAccessPassword(int userid, Clinic clinic);

	int saveLocation(int userid, Clinic clinic);

	Clinic getuser(String userId);
	ArrayList<Clinic> getColorList();

	
	
	

}
