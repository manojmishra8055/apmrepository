package com.apm.DiaryManagement.web.common;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCDiaryManagentDAO;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.DateTimeUtils;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

public class JQGridMasterAllDiaryUser {
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONData(String diaryuserid,String commencing) throws JSONException {
		
		commencing = DateTimeUtils.getCommencingDate(commencing);
		System.out.println(diaryuserid);
		JSONObject jsonOutResult = new JSONObject();
		
		ArrayList<Object> list = new ArrayList<Object>(); 
		HashMap<String, Object> hashMap;
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
			System.out.println(loginInfo.getUserId());
			//int year = (Integer) session.getAttribute("year");
			ArrayList<DiaryManagement>allDiaryUserList = new ArrayList<DiaryManagement>();
			boolean checkAvailibility = diaryManagementDAO.checkPractitionerAvailibility(commencing,diaryuserid);
			
			if(checkAvailibility){
				allDiaryUserList = diaryManagementDAO.getAllDiaryUserAppointmentSlotData(diaryuserid,loginInfo.getId(),commencing);
			}
			
			
			JSONArray array = new JSONArray();
			
			
			for(DiaryManagement diaryManagement : allDiaryUserList){
				
				JSONObject jsonRecordsList = new JSONObject();
				jsonRecordsList.put("id", diaryManagement.getId());
				jsonRecordsList.put("starttime", diaryManagement.getSTime());
				jsonRecordsList.put("endtime", diaryManagement.getEndTime());
				jsonRecordsList.put("apmtduration", diaryManagement.getApmtDuration());
				jsonRecordsList.put("location", diaryManagement.getLocation());
				jsonRecordsList.put("color", diaryManagement.getLocationColor());
				jsonRecordsList.put("tdcode", diaryManagement.getTdCode());
				jsonRecordsList.put("weekname", diaryManagement.getWeekName());
				jsonRecordsList.put("commencing", diaryManagement.getCommencing());
				jsonRecordsList.put("weekfullname", diaryManagement.getWeekFullName());
				jsonRecordsList.put("onlinebooking", diaryManagement.isOnlineBooking());
				jsonRecordsList.put("diaryUser", diaryManagement.getDiaryUser());
				jsonRecordsList.put("practitionerid", diaryManagement.getDiarUserid());
				
				
				array.add(jsonRecordsList);
			}
		
			jsonOutResult.put("jsonOutResult", array);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		
		return jsonOutResult;
		
		
	}

}
