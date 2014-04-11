package com.apm.Registration.eu.bi;

import java.util.ArrayList;

import com.apm.Registration.eu.entity.UserProfile;
import com.apm.common.utils.Pagination;

public interface UserProfileDAO {

	int saveUserprofile(UserProfile userprofile,int clinicid);
	int updateUserprofile(UserProfile userprofile);
	int deleteUserprofile(int selectedid);
	
	int getUserprofileCount(String searchText,int clinicid )throws Exception;

	UserProfile getUserprofileDetails(int selectedid);
	
	//ArrayList<UserProfile> getUserProfileList();
	
	ArrayList<UserProfile> getUserProfileList(Pagination pagination,String searchText,int clinicid)throws Exception;
	boolean isColorExist(String diarycolor);
	ArrayList<String> getJobTitleList();
	int insertJobTitle(UserProfile userProfile, String jobTitle);
	
}
