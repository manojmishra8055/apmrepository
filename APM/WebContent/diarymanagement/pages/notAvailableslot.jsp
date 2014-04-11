<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.ArrayList"%>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import = "java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<script type="text/javascript" src="diarymanagement/js/completeApmt.js"></script>


<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<link href="diarymanagement/css/subModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/common.js"></script>
<script type="text/javascript" src="diarymanagement/js/subModal.js"></script>


<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="diarymanagement/js/notavailableslotpopupscript.js"></script>


<iframe id="background">
</iframe>

<div id="login_main" class="main_layoutdash_content"><!--

	

	<h2 class="title" style="margin-left: 10px">Appointment Dairy</h2>
	<div class ="menu">
		<input type="submit" value="New" onclick="showPopWin('newAppoinmentNotAvailableSlot', 500, 400, null);" disabled="disabled" class="buttons">
		<input type="submit" value="Modify" onclick="$(this).MessageBox()" disabled="disabled" class="buttons">
		<input type="submit" value="Delete" disabled="disabled" class="buttons">
		
		<input type="submit" value="Block" onclick="showdiv()" class="buttons">
	
		
		<a href="allUserNotAvailableSlot" style="text-decoration: none"><input type="button" style="text-decoration: none" value="All Show" class="allShowButtons"/></a> 
		<a href="dayNotAvailableSlot" style="text-decoration: none"><input type="button" style="text-decoration: none" value="Day Work" class="allShowButtons"></a> 
		<a href="NotAvailableSlot" style="text-decoration: none"><input type="button" style="text-decoration: none;" value="User Work Week" class="allShowButtons"> </a>
	  </div>
	--><div id="login" class="blockdash_div">
		<s:if test="hasActionMessages()"> 
			<div id="common_message" class="message">
				<s:actionmessage id="common_message_text" theme="simple"/>
			</div>
		</s:if> 
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		
			<%@ include file="/diarymanagement/pages/commonAppointmentView.jsp" %>


											
					
								       
										        
										        
			<%@ include file="/dashboard/Dashboard.jsp" %>							       
			<!--<div class = "dairyuser">
				Date: <input id="commencing" class="date-pick dp-applied" type="text" value="<%=date %>" name="commencing"></input>
				Dairy User:<s:if test="%{#userList != 'null'}" >
				 				<s:select id="diaryUser" name="diaryUser" list="userList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User"   />
							</s:if>
							
				<input type="submit" onclick="getSearch()" class="gosmall" value = "Go">	
				
				<s:submit value="Print & Preview" onclick="getPrintData()" theme="simple" cssClass="buttons"></s:submit>
						
			</div>
			
			--><br><br>
			<table width="100%" cellpadding="0" cellspacing="0" class="timer-table" id = "tab1" style="table-layout: fixed;">
			<col width="5%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="18%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="15%"/>
			
				<!--<tr>
					<td align="right"><input type="button" value="Close" onclick="goClose();"></td>
				</tr>
				--><tr>
					<th style="background-color: #E8F1F8"></th>
					<th id="wn0">Monday</th>
					<th id="wn1">Tuesday</th>
					<th id="wn2">Wednesday</th>
					<th id="wn3">Thursday</th>
					<th id="wn4">Friday</th>
					<th id="wn5">Saturday</th>
					<th id="wn6">Sunday</th>
					<th></th>
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
						
						<% for(int j=0;j<=6;j++){%>
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
						<% }%>
						
					
						<%ct++; %>
					</tr>
					
				<% }%>
			</table>
				
</div>
</div>	



<table width="100%" border="0" cellspacing="0" cellpadding="0" id="shownotebox" style="display: none;" >
  <tr>
    <td>   
    
<div id="bbit-cal-buddle" style="z-index: 180; width: 400px; visibility: visible; left: 180px; top: 158px;" class="bubble">
<table class="bubble-table" cellspacing="0" cellpadding="0"><tbody><tr><td class="bubble-cell-side"><div id="tl1" class="bubble-corner"><div class="bubble-sprite bubble-tl"></div></div></td><td class="bubble-cell-main"><div class="bubble-top"></div></td><td class="bubble-cell-side"><div id="tr1" class="bubble-corner"><div class="bubble-sprite bubble-tr"></div></div>  </td></tr><tr><td class="bubble-mid" colspan="3"><div style="overflow: hidden" id="bubbleContent1"><div><div></div><div class="cb-root">
    
<table width="200" border="0" cellspacing="0" cellpadding="0">
<tr>
<td>
How r u ?
</td>
</tr>
</table>
    
&nbsp; </div></div></div></td></tr><tr><td><div id="bl1" class="bubble-corner"><div class="bubble-sprite bubble-bl"></div></div></td><td><div class="bubble-bottom"></div></td><td><div id="br1" class="bubble-corner"><div class="bubble-sprite bubble-br"></div></div></td></tr></tbody></table><div id="bubbleClose1" class="bubble-closebutton"></div><div id="prong2" class="prong"><div class="bubble-sprite"></div></div></div>
      </td>
  </tr>
</table>		
		
