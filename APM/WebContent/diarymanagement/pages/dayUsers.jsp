<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.ArrayList"%>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import = "java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>

<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />

<link href="diarymanagement/css/subModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/common.js"></script>
<script type="text/javascript" src="diarymanagement/js/subModal.js"></script>


<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="diarymanagement/js/notavailableslotpopupscript.js"></script>
<script type="text/javascript" src="diarymanagement/js/dayUsers.js"></script>


<iframe id="background">
</iframe>

<div id="login_main" class="main_layoutdash_content"><!--

	

		<h2 class="title" >Appointment Dairy</h2>
	
		<div class="menu">
		
		<input type="submit" value="Block" onclick="showdiv()" class="buttons">
		
		
		<a href="allUserNotAvailableSlot"><input type="button" style="text-decoration: none" value="All Show" class="allShowButtons"/></a> 
		<a href="dayNotAvailableSlot"><input type="button" style="text-decoration: none" value="Day Work" class="allShowButtons"></a> 
		<a href="NotAvailableSlot"><input type="button" style="text-decoration: none;" value="User Work Week" class="allShowButtons"> </a>
	  </div>
	--><div id="login" class="blockdash_div">
		<s:if test="hasActionMessages()"> 
			<div id="common_message" class="message">
				<s:actionmessage id="common_message_text" theme="simple"/>
			</div>
		</s:if> 
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		

			<%@ include file="/diarymanagement/pages/commonAppointmentView.jsp" %>
			<%@ include file="/dashboard/dayDashBoard.jsp" %>									
					
								       
										        
										        
										       
			<!--<div class="dairyuser">
				Date: <input id="commencing" class="date-pick dp-applied" type="text" value="<%=date %>" name="commencing"></input>
				Dairy User:<s:if test="%{#userList != 'null'}" >
				 				<s:select id="diaryUser" name="diaryUser" list="userList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User"   />
							</s:if>
							
				<input type="submit" onclick="getDaySearch()"  class="buttons">		
				<s:submit value="Print & Preview" onclick="getPrintData()" theme="simple" cssClass="buttons"></s:submit>
					
			</div>
			
			
			-->
			<br><br>
			<table width="100%" cellpadding="0" cellspacing="0" class="timer-table" id = "tab1">
			
			<col width="3%"/>
			<col width="60%"/>
			
			
				<tr>
					<th style="background-color: #E8F1F8"></th>
					<th id="day_id" style="text-align: center;">Monday</th>
					
				</tr>
				<% int ct=8; 
					int countslot = 1;
					String weekName[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
					String tempCt = "";
					String tempMinute = "";
				%>
				<%for(int i=1;i<=17;i++){ %>
					<tr>
						<td style="font-size: 18px; font-weight: bold; text-align: center; background-color: #E8F1F8" valign="top"><%=ct %>:00</td>
						
						
							<td valign="top" id="<%=countslot %>" >
								<%for(int k=0;k<=11;k++){ %>
										<%
											tempCt =  Integer.toString(ct);
											tempMinute = Integer.toString((5*k));
											if(ct <= 9) {
												tempCt = "0" + Integer.toString(ct);
											}
											if((5*k) <= 9) {
												tempMinute = "0" + Integer.toString((5*k));
											}
										%>
											
										
									<%if(k==6){ %>
										<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=tempCt %>:<%=tempMinute %>" style="background-image: url('diarymanagement/img/line.png');background-repeat:repeat-x; " ></div>
									<%}else{ %>
										<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=tempCt %>:<%=tempMinute %>" ></div>
									<% }%>
        							
        						<% }%>
								
							</td>
							<%countslot++; %>
						
						
						
						<%ct++; %>
					</tr>
					
				<% }%>
			</table>
				
</div>
</div>			
		
