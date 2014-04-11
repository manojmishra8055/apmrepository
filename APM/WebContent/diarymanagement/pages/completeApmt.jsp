<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="diarymanagement/js/completeApmt.js"></script>
<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<link href="diarymanagement/css/subModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/common.js"></script>
<script type="text/javascript" src="diarymanagement/js/subModal.js"></script>

<div id="login_main" class="main_layout_content">


<script type="text/javascript" src="diarymanagement/js/completeApmt.js"></script>

	
	
	<div id="login" class="block_div">
			<div id="usernamediv" class="mddiv">Manoj Mishra</div><div class="mddiv" id="durationdiv">10:00 - 30 min Appointment with Jitendra Kumar is Complete</div>
			
			<div class="form_elements" >
				<s:form action="paynowCompleteApmt" theme="simple">
				<s:hidden id="markAppointment" name="markAppointment" value="1"/>
				
				<input type="hidden" id = "clientId" name = "clientId">
				<input type="hidden" name="practitionerName" id="practitionerName"/>
				<s:hidden name="practitionerId" id="practitionerId"/>
				<input type="hidden" id = "totalcharge" name="totalcharge" value="0"/>
				<s:hidden name="payBuy" id="payBuy"/>
				
				<div><font style="color: blue; font-weight: bold; font-size: 14px;">Charge for this Appointment </font><font color="brown" style="font-size: 12px;"><span id="tmntesode">Treatment 1 of (10) </span></font></div><br>
				<div id="chargediv" style="color: green; font-weight: bold;  font-size: 12px;">
					The charge has been created To unnati first appointment 10$
				</div>
				 
				<div style="font-size: 12px;">
					
					<table>
						<col width="20%"/>
						<col width="2%"/>
						<col width="30%"/>
						
						<tr>
							<td>Charge To:</td>
							<td align="center">:</td>
							<td style="color: red;"><div id="chargetodiv"></div></td>
						</tr>
						<tr id="authcodetr">
							<td>Auth.Code</td>
							<td align="center">:</td>
							<td><input type="text" name="authcode" id="authcode" size="10"></td>
						</tr>
						<hr>
						<tr><b>Add Additional Charges</b></tr>
						<tr>
							<!--<td><input type="radio"   name="payBuy" value="0" checked="checked">Client</td>
							<td><input type="radio"   name="payBuy" value="1">Third Party </td>
							
							-->
							<td>Appointment Type </td>
							<td align="center">:</td>
							<td><s:select name = "apmtType" id = "apmtType" list="appointmentTypeList" listKey="name" listValue="name" headerKey="0" headerValue="Select Appointment Type" onchange="setAppointmentTypeCharge(this.value)"></s:select></td>
							<td id="chargeajax">
								<input type="text" id = "charge" name="charge" size="5"/>
							</td>
						</tr>
						<tr>
							<td>Total Charges </td>
							<td align="center">:</td>
							<td id ="chargeTotalajax"><input type="text" id = "chargeTotal" name="chargeTotal" value="0.00"/></td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="button" value=" Update Charge "onclick="setChargeAmount()">
								<!--<input type="submit" value="Pay Now">
								
							--></td>
						
						</tr>
						
					</table>
				</div>
		
			
			<div style="font-size: 12px; color: red">
			<br>
				Note : Click on Update Charge button to show charges and add new charge.
			</div>
			
			<br>
<table id="cashDesk" cellpadding="0" cellspacing="0" class="my-table"  style="width:50%;">
			
			<tr>
				<th>Id</th>
				<th>Appointment Type</th>
				<th>Charge</th>
				<th>Delete</th>
				
			</tr>
			
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
			</table>
		<table>
		<tr>
		<td><input type="submit" value="Pay Now"></td>
		</tr>
		</table>
		</s:form>	
	</div>
	</div>

