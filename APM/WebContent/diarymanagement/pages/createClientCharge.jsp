<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.ArrayList"%>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import = "java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>

<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="common/js/pagination.js"></script>


<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="diarymanagement/js/notavailableslotpopupscript.js"></script>
<script type="text/javascript" src="diarymanagement/js/completeApmt.js"></script>


<iframe id="background">
</iframe>

<div id="login_main" class="main_layout_content">
	<h2 class="heading" style="margin-left: 24px">Client Charge</h2>
		<div class="form_elements" >	
		<s:form action="paynowCompleteApmt" theme="simple" validate="True">
			    <table width="60%" class = "boxclientthirdpartycharge" style="font-size: 12px">
			<col width="10%" />
				<col width="2%" />
				<col width="10%" />		 
			
				
					<tr>
						<td>Client:</td>
						<td align="center">:</td>
						<td><s:textfield name="client" id = "client" readonly="true"></s:textfield></td>
						<td>
						<s:hidden name="clientId" id = "clientId" ></s:hidden>  
						<a href="Client" style="text-decoration: none" target="blank" onclick="window.open(this.href, 'mywin',
											'left=20,top=20,width=600,height=500,toolbar=1,resizable=0'); return false;">
											<input type = "button" value="Search" class="buttons"/>
											</a>
						</td>
					</tr>
					<tr>
						<td>Practitioner</td>
						<td align="center">:</td>
						<td>
						<s:if test="%{#userList != 'null'}" >
				 		<s:select id="diaryUser" name="diaryUser" list="userList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User" onchange="setPractioner(this.value)"  />
						</s:if>
						<s:hidden id = "practitionerName" name = "practitionerName"></s:hidden>
						<s:hidden name="practitionerId" id="practitionerId"/>
						</td>
				   </tr>
				   <tr>
						<td>Department:</td>
						<td align="center">:</td>
						<td><s:select id="dept" name="dept" list="{'Any Department','Physiotherapy','Podiatry','Osteopathy','Classes'}" theme="simple" /></td>
				   </tr>
				   <tr>
						<td>Location:</td>
						<td align="center">:</td>
						<td><s:if test="%{#locationList != 'null'}">
						<s:select id="location" name="location" list="locationList" listKey="location" headerValue="Select Location"
													listValue="location" theme="simple" />
						</s:if></td>
					</tr>
				<%String currentDate = DateTimeUtils.getDateinSimpleFormate(new Date());
				String temp[] = currentDate.split(" ");
				String temp1[] = temp[0].split("-");
				String date = temp1[0] + "/" + temp1[1] + "/" + temp1[2];
				
				%>							       
				<tr>
					<td>Date:</td>
					<td align="center">:</td>						        
					<td><input id="commencing" class="date-pick dp-applied" type="text" value="<%=date %>" name="commencing"></input></td>
				</tr>
				<tr>
					<td>Start Time </td>
					<td align="center">:</td>
					<td>
					<s:if test="%{#startTimeList != 'null'}">
					<s:select id="sTime" name="sTime" list="startTimeList" theme="simple" onchange="resetAppointmentField();" />
					</s:if></td>
				</tr>
				<tr>
					<td>End Time</td>
					<td align="center">:</td>
					<td><s:if test="%{#endTimeList != 'null'}">
					<s:select id="endTime" name="endTime" list="endTimeList" theme="simple" disabled="true"/>
					</s:if>
				</td>
				</tr>
				
				<tr>
				
					<td>Appointment Type</td>
					<td align="center">:</td>	
					<td><s:select name = "apmtType" id = "apmtType" list="appointmentTypeList" listKey="name" listValue="name" headerKey="0" headerValue="Select Appointment Type" onchange="setApmtChargeAndDuration(this.value)"></s:select>
					</td>
					<td id="chargeajax">
					<input type="text" id = "charge" name="charge"/>
					Duration :<input type="text" id = "duration" name="duration"/>
				</td>
				
				</tr>
				<tr>
					
					
					<td>Total Charges: </td>
					<td align="center">:</td>
					<td id ="chargeTotalajax"><input type="text" id = "chargeTotal" name="chargeTotal" value="0"/></td>
				</tr>
				</table>
				
			    <table width="60%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<tr>
				<td><b>Select who will Pay this charge</b><input type="radio"   name="payBuy" value="0" onclick="setInvoiceeAsClient()">Client
				<input type="radio" name="payBuy" value="1" onclick="setInvoiceeAsThirdParty()">Third Party </td> 
				</tr>
				<tr>
				<td></td>
				<td id = "thirdPartyAjax"><b>Invoicee</b><s:textfield name="invoicee" id = "invoicee" readonly="true"/></td>
				
				<tr>
				<td><input type="button" value="Save Charge" onclick="saveClientCharge()" class="buttons"/>
				<input type="submit" value="Pay Now" class="buttons"></td>
				</tr>
			</table>
		</s:form>
	 </div>
</div>