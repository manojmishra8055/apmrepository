<%@taglib uri="/struts-tags" prefix="s" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.apm.DiaryManagement.eu.entity.DiaryManagement"%>
<script type="text/javascript" src="common/js/pagination.js"></script>

<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/diarymanagement.js"></script>
<script type="text/javascript" src="diarymanagement/js/popupscript.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="jsdatepick-calendar/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="jsdatepick-calendar/jsDatePick.jquery.min.1.3.js"></script>
<iframe id="background">
</iframe>


<div id="login_main" class="main_layout_content">
	<h2 class="heading" >Set Up Appointment Diaries </h2>
	
	<div id="login" class="block_div">
		
		<s:if test="hasActionMessages()"> 
			<div id="common_message" class="message">
				<s:actionmessage id="common_message_text" theme="simple"/>
			</div>
		</s:if> 
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		
		<div id="previewDiv" style="background-color: white;  left: 0px; width: 90%; ">
		
		
		<div id="toPopup"> 
	    	<div class="close"></div>
	       	<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
			<div id="popup_content" class="boxclientthirdpartycharge"> <!--your content start-->
           		<table width="100%" style="font-size: 12px;" >
           			<input type="hidden" name="selecteddiaryUserid" id="selecteddiaryUserid"/>
           			<input type="hidden" name="tdcode" id="tdcode"/>
           			<col width="10%"/>
           			<col width="2%"/>
           			<col width="30%"/>
           			<tr><td id="apmtheading" colspan="3" style="font-weight: bold; font-size: 12px;">
           				<u>Add Appointment</u>
           				<input type="checkbox" name="wholeweek" id="wholeweek"/>
           			</td></tr>
           			<tr><td colspan="3" style="font-weight: bold; font-size: 12px;">
           				Appointment Slot for <span id="wcday"></span> in W/c <span id="wc"></span>
           			</td></tr>
           			<tr><td colspan="3"></td></tr>
           			<tr>
           				<td>Diary User</td>
           				<td align="center">:</td>
           				<td><input type="text" name="selectedDiaryUser" id="selectedDiaryUser" /></td>
           			</tr>
           			<tr>
           				<td>Location</td>
           				<td align="center">:</td>
           				<td>
           					 <s:if test="%{#locationList != 'null'}" >
		   							<s:select name="location" list="locationList" listKey="location" listValue="location" theme="simple"   />
   	   							</s:if>
           				</td>
           			</tr>
           			<tr>
           				<td>Room</td>
           				<td align="center">:</td>
           				<td>
           					<select name="room" id="room">
           						<option value="Room1">Room1</option>
           						<option value="Room2">Room2</option>
           					</select>
           				</td>
           			</tr>
           			<tr>
           				<td>Description</td>
           				<td align="center">:</td>
           				<td>
           					<select name="description" id="description">
           						<option value="Room1">Description1</option>
           						<option value="Room2">Description2</option>
           					</select>
           				</td>
           			</tr>
           			<tr><td colspan="3"><hr/></td></tr>
           			<tr>
           				<td colspan="3">
           					Start Time : <s:if test="%{#startTimeList != 'null'}" >
		   							<s:select id="sTime" name="sTime" list="startTimeList"  
		   							theme="simple"/>
   	   							</s:if>
   	   							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           					End Time : <s:if test="%{#endTimeList != 'null'}" >
		   					<s:select id="endTime" name="endTime" list="endTimeList"  
		   					 theme="simple"/>
   	   					</s:if>

           				</td>
           			</tr>
           			<tr>
           				<td colspan="3">
           					Appointment Duration :
           					<s:if test="%{#apmtDurationList != 'null'}" >
			   					<s:select id="apmtDuration" name="apmtDuration" list="apmtDurationList"  
			   					 theme="simple"/>
   	   						</s:if>
           				</td>
           			</tr>
           			<tr><td colspan="3"><hr/></td></tr>
           			<tr><td colspan="3">
           				Online Patient Booking 
           				<s:checkbox name="onlineBooking" id="onlineBooking" fieldValue="false" theme="simple" ></s:checkbox>
           				is This Slot Available for Online Booking
           			</td></tr>
           			<tr><td colspan="3" ><hr/></td></tr>
           			<tr><td colspan="3" align="center" id="submitslot">
           				<input class="buttons" type="button" value="Submit" onclick="$(this).saveSlot('0');"/>
           				<input class = "buttons" type="button" value="Cancel" onclick="$(this).cancelSlot();"/> 
           			</td></tr>
           		</table>
        	</div> <!--your content end-->
    	 </div> <!--toPopup end-->
    
	<div class="loader"></div>
   	<div id="backgroundPopup"></div>
		<input type="hidden" name="diaryuserid" id="diaryuserid"/>
		
			<div style="background-color: #7ecefd;width: 697px;color: white;padding: 4px; width: 99%; height: 41px;">

			<font style="font-size: 12px; font-weight: bold;">Diary User :</font> <s:textfield size="30"  id="diaryUser" name="diaryUser" theme="simple"/>
			<font style="font-size: 12px; font-weight: bold;">for Week Commencing :</font>
			<input type="text" size="30" id="commencing" name="commencing">
				<input type="button" disabled="disabled" value="Repeat" title="Repeat by week" onclick="repeatByWeek()" class="buttons"/>
				<select name="weekNumber" id="weekNumber">
					<option value="1">1</option>
					<option value="4">4</option>
					<option value="12">12</option>
					<option value="26">26</option>
				</select>
				<input type="button" value=" Close " onclick="goClose();" class="buttons"/>
			</div>
			<br><br>
			<table width="100%" cellpadding="0" cellspacing="0" class="timer-table">
			<col width="2%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="10%"/>
			<col width="2%"/>
				
				<tr>
				
					<th></th>
					<th id="mon_id">Monday</th>
					<th id="tue_id">Tuesday</th>
					<th id="wed_id">Wednesday</th>
					<th id="thu_id">Thursday</th>
					<th id="fri_id">Friday</th>
					<th id="sat_id">Saturday</th>
					<th id="sun_id">Sunday</th>
					<th></th>
				</tr>
				<% int ct=8; 
					int countslot = 1;
					String weekName[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
				%>
				<%for(int i=1;i<=17;i++){ %>
					<tr>
						<td style="font-size: 10px;" valign="top"><%=ct %>:00</td>
						
						<% for(int j=0;j<=6;j++){%>
							<td valign="top" id="<%=countslot %>">
								<%for(int k=0;k<=11;k++){ %>
        							
        							<%if(k==6){ %>
										<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=ct %>:<%=(5*k) %>" onclick="$(this).MessageBox('<%=weekName[j] %>',<%=j %>,'save','0','0','','','','','','<%=ct %>')" style="background-image: url('diarymanagement/img/line.png');background-repeat:repeat-x; "></div>
									<%}else{ %>
										<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=ct %>:<%=(5*k) %>" onclick="$(this).MessageBox('<%=weekName[j] %>',<%=j %>,'save','0','0','','','','','','<%=ct %>')"></div>
									<% }%>
        							
        						<% }%>
								
							</td>
							<%countslot++; %>
						<% }%>
						
						<td style="font-size: 10px;" valign="top"><%=ct %>:00</td>
						<%ct++; %>
					</tr>
					
				<% }%>
			</table>
		</div>
		<div class="form_elements" style="width: 1000px">	
			
			<div align="center">
				<s:form action="nextprevDiaryMangent" theme="simple">
					<s:submit name="actionType" value="Prev" cssClass="buttons"/>
					<s:textfield cssStyle="text-align:center" name="diaryYear" id="diaryYear" size="5" readonly="true" theme="simple" cssClass="textfields"></s:textfield>
					<s:submit name="actionType" value="Next" cssClass="buttons"/>
					<br><br>
				</s:form>
				
			</div>
		
		<div style="overflow:scroll; width: 100%; height"  >
		<table width="100%" style="font-size: 10px;" class="diarymngmnt-table" cellpadding="0" cellspacing="0">
			<tr>
				<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Diary Users</th>
				<s:iterator value="monthList">
					<s:iterator value="DateStringList">
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;"><s:property value="dateName"/></th>
					</s:iterator>
				
				</s:iterator>
			
			</tr>
				
			<%int dcount = 1; %>
			<%ArrayList<DiaryManagement>userList = (ArrayList<DiaryManagement>)session.getAttribute("tdUserList"); 
				int i = 0;
			%>
			<s:iterator value="tdUserList">
					<%i++; %>
					<tr id="<%=i %>">
					
						<% int j=0;%>
						<s:iterator value="monthtdList">
							<%if(j == 0){ %>
								<td><s:property value="firstName"/> <s:property value="lastName"/></td>
							<% }%>
							<%j++; %>
							
							<s:iterator value="DateStringList">
								<s:if test="weekListname!=null">
									<td style="height: 5px; background-color: <s:property value="colorName"/>" id="<s:property value="dateName"/>" onclick="goPreview('<s:property value="firstName"/> <s:property value="lastName"/>','<s:property value="dateName"/>','<s:property value="diaryYear"/>','<s:property value="diarUserid"/>','<s:property value="tdDateName"/>')">
										<s:property value="weekListname"/>
									</td>
								</s:if>
								<s:else>
									<td style="height: 5px; background-color: <s:property value="colorName"/>" id="<s:property value="dateName"/>" onclick="goPreview('<s:property value="firstName"/> <s:property value="lastName"/>','<s:property value="dateName"/>','<s:property value="diaryYear"/>','<s:property value="diarUserid"/>','<s:property value="tdDateName"/>')">
										<div style="width: 49px;"></div>
									</td>
								</s:else>
								<%dcount++; %>
							</s:iterator>
						</s:iterator>
					</tr>
				</s:iterator>
				
				
			
			
			
		</table>
				
		</div>		
				
       			
       			

		
		
	</div>
</div>