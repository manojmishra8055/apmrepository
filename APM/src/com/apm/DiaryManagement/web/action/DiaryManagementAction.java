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

import com.apm.Appointment.eu.entity.Appointment;
import com.apm.DiaryManagement.eu.bi.DiaryManagementDAO;
import com.apm.DiaryManagement.eu.blogic.jdbc.JDBCDiaryManagentDAO;
import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.DiaryManagement.eu.entity.Tdcode;
import com.apm.DiaryManagement.web.common.ApmDate;
import com.apm.DiaryManagement.web.common.DateOfWeek;
import com.apm.DiaryManagement.web.common.Month;
import com.apm.DiaryManagement.web.form.DiaryManagementForm;
import com.apm.Registration.eu.entity.Location;
import com.apm.common.eu.blogic.jdbc.Connection_provider;
import com.apm.common.utils.DateTimeUtils;
import com.apm.common.web.action.BaseAction;
import com.apm.common.web.common.helper.LoginHelper;
import com.apm.common.web.common.helper.LoginInfo;
import com.apm.common.web.utils.PopulateData;
import com.apm.common.web.utils.PopulateList;
import com.apm.main.common.constants.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;





public class DiaryManagementAction extends BaseAction implements Preparable, ModelDriven<DiaryManagementForm> {

	DiaryManagementForm diaryManagementForm = new DiaryManagementForm();
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	HttpSession session = request.getSession(true);
	LoginInfo loginInfo = LoginHelper.getLoginInfo(request);
	
	public String execute() throws Exception {
		
		if(!verifyLogin(request)){
			return "login";
		}
		
		setDiary();
		/*Calendar now = Calendar.getInstance(); 
		int currentYear = now.get(Calendar.YEAR);
		diaryManagementForm.setDiaryYear(Integer.toString(currentYear));*/
		//set current year
		/*Calendar now = Calendar.getInstance(); 
		int diaryYear = now.get(Calendar.YEAR);
		
		diaryManagementForm.setDiaryYear(Integer.toString(diaryYear));*/
		
		return SUCCESS;
	}
	
	
	public void setDiary() throws SQLException{
		ArrayList<Month>monthList = new ArrayList<Month>();
		ArrayList<Month>monthtdList = new ArrayList<Month>();
		int year = Integer.parseInt(diaryManagementForm.getDiaryYear());
		
		ArrayList<DiaryManagement>tdUserList = new ArrayList<DiaryManagement>();
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			ArrayList<DiaryManagement>userList = diaryManagementDAO.getPractionerList(year,loginInfo.getId());
			
			for(int i=0;i<=11;i++){
				Month month = new Month();
				
				DiaryManagement diaryManagement = new DiaryManagement();
				
					ArrayList<DateOfWeek>dateStringList = getMonthWiseDateList(year,i);
					month.setDateStringList(dateStringList);
					monthList.add(month);
			}
			
			
			//design td
			for(DiaryManagement diaryManagement : userList){
				monthtdList = new ArrayList<Month>();
				for(int i=0;i<=11;i++){
					Month month = new Month();
					ArrayList<DateOfWeek>dateStringList = getMonthWiseDateList(year,i,diaryManagement);
					month.setDateStringList(dateStringList);
					monthtdList.add(month);
					
				}
				diaryManagement.setMonthtdList(monthtdList);
				tdUserList.add(diaryManagement);
			}
			
			/*for(DiaryManagement dm : tdUserList){
				System.out.println(dm.getFirstName());
				for(Month month : dm.getMonthtdList()){
					System.out.println(month.getMonthName());
					for(DateOfWeek dateOfWeek : month.getDateStringList()){
						
						System.out.println(dateOfWeek.getDateName());
						for(Tdcode tdcode : dateOfWeek.getTdcodelist()){
							System.out.println(tdcode.getWeekListName());
						}
					}
				}
			}*/
			
			
			
			diaryManagementForm.setUserList(userList);
			session.setAttribute("userList", userList);
			diaryManagementForm.setTdUserList(tdUserList);
			session.setAttribute("tdUserList", tdUserList);
			
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			connection.close();
		}
		
		
		
		
		
		diaryManagementForm.setMonthList(monthList);
		session.setAttribute("monthList", monthList);
		session.setAttribute("year", year);
		diaryManagementForm.setMonthtdList(monthtdList);
		
		int diaryLine = 0;
		for(Month month : monthList){
			for(DateOfWeek dateOfWeek : month.getDateStringList()){
				diaryLine++;
			}
			
		}
		session.setAttribute("diaryLine", diaryLine);
		
	}
	
	
	public String nextprev(){
		
		if(!verifyLogin(request)){
			return "login";
		}
		
		try{
			int currentYear = Integer.parseInt(diaryManagementForm.getDiaryYear());
			
			if(diaryManagementForm.getActionType().equals("Prev")){
				currentYear = currentYear -1;
				diaryManagementForm.setDiaryYear(Integer.toString(currentYear));
				setDiary();
			}
			if(diaryManagementForm.getActionType().equals("Next")){
				currentYear = currentYear + 1;
				diaryManagementForm.setDiaryYear(Integer.toString(currentYear));
				setDiary();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "nextprev";
	}
	
	
	//repeat slot
	public String repeatslot() throws SQLException{
		String tdcode = request.getParameter("tdcode");
		int weekNumber = Integer.parseInt(request.getParameter("weekNumber")); 
		String diaryYear = request.getParameter("diaryYear");
		int diaryUserid = Integer.parseInt(request.getParameter("diaryUserid"));
		String diaryUser = request.getParameter("diaryUser");
		
		Connection connection = null;
		try{
			connection = Connection_provider.getconnection();
			DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			
			ArrayList<DiaryManagement>diaryUserList = diaryManagementDAO.getAppointmentSlotData(Integer.toString(diaryUserid),loginInfo.getId(),tdcode,diaryYear);
			
			ArrayList<Month>montList = (ArrayList<Month>)session.getAttribute("monthList");
			
				int weekcount = 0;
				int oldweekcount = 0;
				
			//delete old data
				/*olb:
				for(Month months : montList){
					for(DateOfWeek dateOfWeek : months.getDateStringList()){
						System.out.println(dateOfWeek.getDateName());
						String usertdcode = dateOfWeek.getDateName() + "-" + diaryUserid;
						
						if(!tdcode.equals(usertdcode)){
							boolean isUsertdCodeExist = diaryManagementDAO.checkUsertdCodeExist(usertdcode,diaryYear);
							if(isUsertdCodeExist){
								int delete = diaryManagementDAO.deleteAppointSlotByTdcode(usertdcode,diaryYear);
							}
							
							
						}
						oldweekcount++;
						if(oldweekcount == weekNumber){
							System.out.println("hello");
							break olb;
						}
					}
				}*/
				
				
			ol:
			for(Month month : montList){
				for(DateOfWeek dateOfWeek : month.getDateStringList()){
					System.out.println(dateOfWeek.getDateName());
					String usertdcode = dateOfWeek.getDateName() + "-" + diaryUserid;
					
					if(!tdcode.equals(usertdcode)){
						boolean isUsertdCodeExist = diaryManagementDAO.checkUsertdCodeExist(usertdcode,diaryYear);
						if (isUsertdCodeExist){
							int delete = diaryManagementDAO.deleteAppointSlotByTdcode(usertdcode,diaryYear);
						}
						
						for(DiaryManagement diaryManagement : diaryUserList){
							diaryManagement.setCommencing("");
							diaryManagement.setTdCode(usertdcode);
							diaryManagement.setDiarUserid(diaryUserid);
							diaryManagement.setYear(diaryYear);
							diaryManagement.setSelectedDiaryUser(diaryUser);
							int result = diaryManagementDAO.saveAppointmentSlot(diaryManagement);
							
						}
					}
					weekcount++;
					if(weekcount == weekNumber){
						System.out.println("hello");
						break ol;
					}
						
				}
				
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
		
		System.out.println("repeat");
		
		return null;
	}
	
	
	//setslot
	
	public String saveslot() throws SQLException{
		if(!verifyLogin(request)){
			return "login";
		}
		DiaryManagement diaryManagement = new DiaryManagement();
		
		int selectedid = Integer.parseInt(request.getParameter("selectedid"));
		
		 String commencing = request.getParameter("commencing");
		/* String temp[] = commencing.split("/");
		 
		 if(temp.length > 0){
			 int dd = Integer.parseInt(temp[0]);
			 int mm = Integer.parseInt(temp[1]);
			 
			 if(dd < 10){
				 temp[0] = "0" + temp[0];
			 }
			 if(mm < 10){
				 temp[1] = "0" + temp[1];
			 }
		 }
		 
		 commencing = temp[0] + "/" + temp[1] + "/" + temp[2] ;*/
		 
	  String temp[] = commencing.split("/");
	  /*String monthNumber = DateTimeUtils.getYearNumber(temp[1]);
		 
		 
	 	int date = Integer.parseInt(temp[0]);
		String tsmpdate = temp[0];
		if(date < 10){
			 tsmpdate = "0"+date+"";
		}
		commencing = tsmpdate + "/" + monthNumber + "/" + temp[2] ;*/
			
		 String selectedDiaryUser = request.getParameter("selectedDiaryUser");;
		 String location = request.getParameter("location");
		 String room = request.getParameter("room");
		 String description = request.getParameter("description");
		 boolean onlineBooking = Boolean.parseBoolean(request.getParameter("onlineBooking"));
		 String sTime = request.getParameter("sTime");;
		 String endTime = request.getParameter("endTime");
		 String apmtDuration = request.getParameter("apmtDuration");
		 String selecteddiaryUserid = request.getParameter("selecteddiaryUserid");
		 String tdCode = request.getParameter("tdcode");
		 String weekname = request.getParameter("weekname");
		 
		 diaryManagement.setWeekFullName(weekname);
		 
		 weekname = DateTimeUtils.getWeekShortName(weekname);
		 
		 Connection connection = null;
		 
		 
		 diaryManagement.setCommencing(DateTimeUtils.getCommencingDate(commencing));
		 diaryManagement.setSelectedDiaryUser(selectedDiaryUser);
		 diaryManagement.setLocation(location);
		 diaryManagement.setRoom(room);
		 diaryManagement.setDescription(description);
		 diaryManagement.setOnlineBooking(onlineBooking);
		 diaryManagement.setSTime(sTime);
		 diaryManagement.setEndTime(endTime);
		 diaryManagement.setApmtDuration(apmtDuration);
		 diaryManagement.setDiarUserid(Integer.parseInt(selecteddiaryUserid));
		 diaryManagement.setTdCode(tdCode);
		 diaryManagement.setWeekName(weekname);
		 diaryManagement.setYear(temp[2]);
		 
		 
		 
		 
		 try{
			 connection = Connection_provider.getconnection();
			 DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			 
			 if(selectedid == 0){
				 boolean wholeweek = Boolean.parseBoolean(request.getParameter("wholeweek"));
				 if(wholeweek){
					 int year = (Integer) session.getAttribute("year");
					// int delete = diaryManagementDAO.deleteAppointSlotByTdcode(tdCode, Integer.toString(year),diaryManagement.getLocation());
					 //split tdcoe
					 String tempTdCode[] = tdCode.split("-");
					 String mondayDate[] = tempTdCode[0].split(" ");
					 
					 commencing = request.getParameter("commencing");
					 String tempCommencing[] = commencing.split("/");
					 //commencing = mondayDate[1]+"/"+tempCommencing[1]+"/"+tempCommencing[2];
					 //commencing = DateTimeUtils.getCommencingDate(commencing);
					 
					 int size = 0;
					 if(Integer.parseInt(tempCommencing[0]) >= Integer.parseInt(mondayDate[1])){
						 size = Integer.parseInt(tempCommencing[0]) - Integer.parseInt(mondayDate[1]);
					 }else{
						size =  Integer.parseInt(mondayDate[1]) + Integer.parseInt(tempCommencing[0]);
						size = size - Integer.parseInt(mondayDate[1]);
					 }
					  
					 int count = 0;
					 
					 for(int i=size;i<=6;i++){
						 ApmDate apmDate = DateTimeUtils.getApmDate(commencing,count);
						 System.out.println(apmDate.getDate() +"/"+ apmDate.getMonth()+"/"+apmDate.getYear());
						 String dd = Integer.toString(apmDate.getDate());
						 String mm = Integer.toString(apmDate.getMonth());
						 if(apmDate.getDate() < 10){
							 dd = "0" + apmDate.getDate();
						 }
						 if(apmDate.getMonth() < 10){
							 mm = "0" + apmDate.getMonth();
						 }
						 
						String sqldate = apmDate.getYear()+"-"+mm+"-"+dd;
						 
						 diaryManagement.setCommencing(sqldate);
						 diaryManagement.setWeekFullName(Constants.WEEK_NAME[i]);
						 //diaryManagement.setCommencing("");
						 weekname = DateTimeUtils.getWeekShortName(Constants.WEEK_NAME[i]);
						 diaryManagement.setWeekName(weekname);
						 
						 int result = diaryManagementDAO.saveAppointmentSlot(diaryManagement);
						 
						 count++;
					 }
					 System.out.println("repeat");
				 }else{
					 System.out.println("non repeat");
					 int result = diaryManagementDAO.saveAppointmentSlot(diaryManagement);
				 }
				 
			 }else{
				 int result = diaryManagementDAO.updateAppointment(selectedid,diaryManagement);
			 }
			
			 
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 finally{
				connection.close();
			}
		return null;
	}
	

	//delete slot
	
	public String deleteslot() throws SQLException{
		Connection connection = null;
		try{
			
			 connection = Connection_provider.getconnection();
			 DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			 
			 int selectedid = Integer.parseInt(request.getParameter("selectedid"));
			 System.out.println(selectedid);
			 
			 int delete = diaryManagementDAO.deleteAppointmentSlot(selectedid);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			connection.close();
		}
		
		return null;
	}
	
	
	public String start() throws SQLException{
		
		Connection connection = null;
		
		try{
			connection = Connection_provider.getconnection();
			DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			
			 int selectedid = Integer.parseInt(request.getParameter("selectedid"));
			 System.out.println(selectedid);
			 
			 	response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(""+selectedid+""); 
			 
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return null;
	}
	


	public DiaryManagementForm getModel() {
		
		return diaryManagementForm;
	}
	
	
	private ArrayList<DateOfWeek> getMonthWiseDateList(int year, int month) {
		ArrayList<DateOfWeek>list = new ArrayList<DateOfWeek>();
		
		try{
			
			
			Calendar c = Calendar.getInstance();
		    c.set( Calendar.YEAR, year );
		    c.set( Calendar.MONTH , month);
		    c.set( Calendar.DAY_OF_MONTH, 0 );
		    c.add( Calendar.DAY_OF_MONTH, -1 );

		    //System.out.println( c.getTime() );

		    int mondaysCount = 0;

		    while ( mondaysCount != 5 ) {
		    	DateOfWeek dateOfWeek = new DateOfWeek();
		        c.add( Calendar.DAY_OF_MONTH, 1 );
		        if ( c.get( Calendar.DAY_OF_WEEK ) == Calendar.MONDAY ) {
		            mondaysCount++; 
		            
		            String temp[] = c.getTime().toString().split(" ");
		            String dateStr = temp[1] + " " + temp[2];
		            dateOfWeek.setDateName(dateStr);
		            
		             
		             if(c.get(Calendar.MONTH) == month){
		            	 list.add(dateOfWeek);
		             }
		            //System.out.println(c.getTime() );
		            
		        }       
		    }
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	private ArrayList<DateOfWeek> getMonthWiseDateList(int year, int month,DiaryManagement diaryManagement) {
		ArrayList<DateOfWeek>list = new ArrayList<DateOfWeek>();
		
		String weekListName = "";
		String colorName = "";
		
		
		try{
			
			
			Calendar c = Calendar.getInstance();
		    c.set( Calendar.YEAR, year );
		    c.set( Calendar.MONTH , month);
		    c.set( Calendar.DAY_OF_MONTH, 0 );
		    c.add( Calendar.DAY_OF_MONTH, -1 );

		    //System.out.println( c.getTime() );

		    int mondaysCount = 0;

		    while ( mondaysCount != 5 ) {
		    	DateOfWeek dateOfWeek = new DateOfWeek();
		        c.add( Calendar.DAY_OF_MONTH, 1 );
		        if ( c.get( Calendar.DAY_OF_WEEK ) == Calendar.MONDAY ) {
		            mondaysCount++; 
		            
		            String temp[] = c.getTime().toString().split(" ");
		            String dateStr = temp[1] + " " + temp[2];
		            dateOfWeek.setDateName(dateStr);
		            dateOfWeek.setTdDateName(dateStr+"-"+diaryManagement.getDiarUserid());
		            
		            
		            ArrayList<Tdcode>tdcodelist = diaryManagement.getTdDataList();
		            for(Tdcode tdcode : tdcodelist){
		            	if(tdcode.getTdCode().equals(dateOfWeek.getTdDateName())){
		            		weekListName = tdcode.getWeekListName();
		            		colorName = diaryManagement.getDiaryColor();
		            		
		            		 dateOfWeek.setWeekListname(weekListName);
		 		            dateOfWeek.setColorName(colorName);
		            	}
		            }
		            
		           

		            if(c.get(Calendar.MONTH) == month){
		            	 list.add(dateOfWeek);
		             }
		            //System.out.println(c.getTime() );
		            
		        }       
		    }
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	


	public void prepare() throws Exception {
		
		diaryManagementForm.setStartTimeList(PopulateList.startTimeList());
		diaryManagementForm.setEndTimeList(PopulateList.endTimeList());
		diaryManagementForm.setApmtDurationList(PopulateList.apmtDurationList());
		
		Connection connection = null;
		
		try{
			connection = Connection_provider.getconnection();
			DiaryManagementDAO diaryManagementDAO = new JDBCDiaryManagentDAO(connection);
			
			ArrayList<Location>locationList = diaryManagementDAO.getLocationList(loginInfo.getId());
			diaryManagementForm.setLocationList(locationList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}
	

}
