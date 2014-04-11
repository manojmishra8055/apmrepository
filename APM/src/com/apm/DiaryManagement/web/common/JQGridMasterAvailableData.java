package com.apm.DiaryManagement.web.common;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCDiaryManagentDAO;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.NotAvailableSlot;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.DateTimeUtils;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.opensymphony.xwork2.ActionContext;

public class JQGridMasterAvailableData {
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONData(String diaryuserid,String practitionerid) throws JSONException {
		
		
		System.out.println(">>>>>"+diaryuserid);
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
			//System.out.println(loginInfo.getUserId());
			//int year = (Integer) session.getAttribute("year");
			
			ArrayList<NotAvailableSlot>apmtList = diaryManagementDAO.getApmtList(diaryuserid,practitionerid);
			
			
			
			JSONArray array = new JSONArray();
			
			
			for(NotAvailableSlot notAvailableSlot : apmtList){
				
				JSONObject jsonRecordsList = new JSONObject();
				jsonRecordsList.put("id", notAvailableSlot.getId());
				jsonRecordsList.put("starttime", notAvailableSlot.getSTime());
				jsonRecordsList.put("endtime", notAvailableSlot.getEndTime());
				jsonRecordsList.put("apmtduration", notAvailableSlot.getApmtDuration());
				jsonRecordsList.put("clientname", notAvailableSlot.getClientName());
				jsonRecordsList.put("apmttype", notAvailableSlot.getApmtType());
				jsonRecordsList.put("notes", notAvailableSlot.getNotes());
				jsonRecordsList.put("duration", notAvailableSlot.getDuration());
				jsonRecordsList.put("status", notAvailableSlot.getStatus());
				jsonRecordsList.put("arrivedstatus", notAvailableSlot.getArrivedStatus());
				jsonRecordsList.put("dna", notAvailableSlot.isDna());
				jsonRecordsList.put("clientId", notAvailableSlot.getClientId());
				jsonRecordsList.put("commencing", notAvailableSlot.getCommencing());
				jsonRecordsList.put("practitionerEmail", notAvailableSlot.getPractitionerEmail());
				jsonRecordsList.put("clientEmail", notAvailableSlot.getClientEmail());
				jsonRecordsList.put("charge", notAvailableSlot.getCharge());
				jsonRecordsList.put("reasonforblock", notAvailableSlot.getReasonforblock());
				jsonRecordsList.put("shortnotes", notAvailableSlot.getNotes());
				if(notAvailableSlot.getNotes().length() > 50){
					jsonRecordsList.put("shortnotes", notAvailableSlot.getNotes().substring(0, 30));
				}
				jsonRecordsList.put("treatmentepisodeid", notAvailableSlot.getTreatmentEpisodeId());
				jsonRecordsList.put("iscompleted", notAvailableSlot.isAppointmentCompleted());
				
				
				array.add(jsonRecordsList);
			}
		
			jsonOutResult.put("jsonOutResult", array);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		
		return jsonOutResult;
		
		
	}

}
