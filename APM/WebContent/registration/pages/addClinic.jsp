<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="registration/js/clinic.js"></script>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="registration/js/tab.js"></script>
<link href="registration/css/tabStyle.css" rel="stylesheet"/>


<div class="main_layout_content">
	
	<div id="contact_details" class="block_div"> 
	<h2 class="heading" align="center" >Create Clinic Account</h2><!--
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	--><span class="error"><font color="red"><s:actionerror id="server_side_error"/></font></span>
	<div id="tab-container">  
    <ul class="tab-menu">  
        <li id="generalInformation" class="active">General Information</li>  
        <li id="packageSubscription">Package Subscription</li>  
        <li id="functionalitySubscription">Functionality Subscription</li>
        <li id="accountInformation">Account Information</li>  
        <li id="clinicLocation">Clinic Location</li>  
          
    </ul>  
    <div class="clear"></div>  
    <div class="tab-top-border"></div>
	<s:form action="saveClinicRegistration" id="registerfrm" theme="simple" >
		
		
		 	
	<div id="generalInformation-tab" class="tab-content active">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 		<col width="10%"/>
		 		<col width="2%"/>
		 		<col width="18%"/>
		 		<tr>
		 			<td colspan="3"><b>General Information</b><hr></td>
		 		</tr>
		 		
		 		<tr>
		 			<td>Clinic Name<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td><s:textfield name="clinicName" id="clinicName" size="50"/></td>
		 		</tr>
		 		
		 		<tr>
		 			<td>Clinic Owner Name(SPOC)<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td><s:textfield name="clinicOwner" id="clinicOwner" size="50"/></td>
		 		</tr>
		 		
		 		<tr>
		 			<td>Email-Address<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td>
	 					<s:textfield id="email" name="email" key="label.email" labelposition="left" required="true" size="50"
						title="Enter valid email id, it will be used to send job notifications, eg. yourname@gmail.com, yourname@yahoo.co.in" />
					</td>
		 		</tr>
		 		
		 		<tr>
		 			<td>Mobile No<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td>
	 					<s:textfield id="mobileNo" name="mobileNo" key="label.mobileNo" labelposition="left" required="true" 
  						title="Specify valid mobile number, eg 9876543210" />
					</td>
		 		</tr>
		 		
		 		<tr>
		 			<td>Landline No<span class="reqd-info"></span></td>
		 			<td align="center">:</td>
		 			<td>
	 					<s:textfield id="landline" name="landLine" key="label.mobileNo" labelposition="left" required="true" 
  						title="Specify valid mobile number, eg 9876543210" />
					</td>
		 		</tr>
		 		<tr><td colspan="3" style="height: 8px;"></td></tr>
		 		</table>
		</div>
		
		 		<!--<tr>
		 			<td colspan="3"><b>Access to Subscription</b><hr></td>
		 		</tr>
		 		-->
		<div id="packageSubscription-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 		<col width="10%"/>
		 		<col width="2%"/>
		 		<col width="18%"/> 
		 		<tr>
		 			<td valign="top">Package Subscription</td>
		 			<td align="center" valign="top">:</td>
		 			<td valign="top">
		 				<table width="100%">
		 					<tr>
		 						<td valign="top"> 
		 							<s:checkbox name="pkgsubscription" id="standalone" fieldValue="standalone" value="%{isStandalone}" title="Local APM with Local DB without any backup" /><s:label value="StanAlone"></s:label>
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="pkgsubscription" id="hostedDB" fieldValue="hostedDB" value="%{isHostedDB}" title="(Only DB is backed up betn Local DB and Server)" /><s:label value="Hosted DB"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="pkgsubscription" id="onlineSingleDevice" fieldValue="onlineSingleDevice" value="%{isOnlineSingleDevice}" title="(Online Single Device (PC))" /><s:label value="Online(single device (PC))"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="pkgsubscription" id="onlineMultiDevice" fieldValue="onlineMultiDevice" value="%{isOnlineMultiDevice}" title="(Online Multi Device StandAlone, Online, Online Mobile Apps, Responsive Apps" />
		 							<s:label value="Online(Multi Device)"></s:label>
		 						</td>
		 					</tr>
		 					
		 				</table>
		 				
		 			</td>
		 		</tr>
		 		</table>
		 	</div>
		 	
		 	<div id="functionalitySubscription-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 		<col width="10%"/>
		 		<col width="2%"/>
		 		<col width="18%"/> 	
		 		<tr>
		 			<td valign="top">Functionality Subscription</td>
		 			<td align="center" valign="top">:</td>
		 			<td>
		 				<table width="100%">
		 					<tr>
		 						<td style="padding-left: 3px; font-weight: bold;"><u>Basic Package :</u> </td>
		 					</tr>
		 					<tr>
		 						<td> 
		 							<s:checkbox name="funSubscription" id="diaryManagement" fieldValue="diaryManagement" value="%{isDiaryManagement}" title="Diary Maangement"/><s:label value="Diary Maangement"></s:label>
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="funSubscription" id="appointmentBooking" fieldValue="appointmentBooking" value="%{isAppointmentBooking}" title="Appointment Booking"/><s:label value="Appointment Booking"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="funSubscription" id="basicFinance" fieldValue="basicFinance" value="%{isBasicFinance}" title="Basic Finance"/><s:label value="Basic Finance"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td style="padding-left: 3px; font-weight: bold;"><u>Advance Package ( All of above + ) :</u></td>
		 					</tr>
		 					<tr>
		 						<td> 
		 							<s:checkbox name="funSubscription" id="fullFinance" fieldValue="fullFinance" value="%{isFullFinance}" title="Full Finance"/><s:label value="Full Finance"></s:label>
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="funSubscription" id="medicalRecord" fieldValue="medicalRecord" value="%{isMedicalRecord}" title="Medical Record"/><s:label value="Medical Record"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td style="padding-left: 3px; font-weight: bold;"><u>Premier Package ( All of above + ) : </u> </td>
		 					</tr>
		 					<tr>
		 						<td> 
		 							<s:checkbox name="funSubscription" id="clinicResourceMngment" fieldValue="clinicResourceMngment" value="%{clinicResourceMngment}" title="Clinic Resource Management"/><s:label value="Clinic Resource Management"></s:label>
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="funSubscription" id="clinicPayrollMngment" fieldValue="clinicPayrollMngment" value="%{clinicPayrollMngment}" title="Clinic Payroll Management"/><s:label value="Clinic Payroll Management"></s:label>
		 						</td>
		 					</tr>
		 					
		 				</table>
		 				
		 			</td>
		 		</tr>
		 	</table>	
		 	</div>	
		 		
		 <div id="accountInformation-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 		<col width="10%"/>
		 		<col width="2%"/>
		 		<col width="18%"/> 	
		 		
		 		<tr>
		 			<td colspan="3"><b>Account Information</b><hr></td>
		 		</tr>
		 
		 
		 		<tr>
		 			<td>UserID<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td>
		 				<s:textfield id="userid" name="userId"  theme="simple"
						title="Minimum 6 characters, no special characters except underscore, starts with alphabet, no whitespaces between words,
					 	eg. sachin_verma, sachinverma, sachin123" />
					</td>
		 		</tr>
		 		<tr>
		 			<td>PassWord<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td>
	 					<s:password	id="password" name="password" theme="simple" 
		 				title="Minimum 6 characters, make it hard to guess" />
					</td>
		 		</tr>
		 		<tr>
		 			<td>Confirm PassWord<span class="reqd-info">*</span></td>
		 			<td align="center">:</td>
		 			<td>
	 					<s:password id="confirmPassword" name="confirmPassword" key="label.confirmPassword" labelposition="left" required="true" 
						title="Re-enter above password" />
					</td>
		 		</tr>
		 		<tr><td colspan="3" style="height: 8px;"></td></tr>
		 		
		 		
		 		
		 	</table>
		 	</div>	
		
		<div id="clinicLocation-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 		<col width="10%"/>
		 		<col width="2%"/>
		 		<col width="18%"/> 	
			<!-- Lcation1 --> 	
				<tr>
		 			<td colspan="3"><b>Clinic Location</b><hr></td>
		 		</tr>
				<tr>
					<td colspan="3">
						<table id="addressesTable" style="font-size: 11px;">
							<tr>
								<th align="center">Check</th>
								<th align="center">Sr. No</th>
								<th align="center">Country</th>
								<th align="center">City</th>
								<th align="center">Postcode</th>
								<th align="center">Address</th>
								<th align="center">Location</th>
								<th align="center">Color</th>
							</tr>
							<tr>
								 <TD><INPUT type="checkbox" name="chk"/></TD>
            					 <TD> 1 </TD>
								<td><input type="text" name="location[0].country" size="10"></td>
								<td><input type="text" name="location[0].city" size="10"></td>
								<td><input type="text" name="location[0].pinCode" size="10"></td>
								<td><textarea name="location[0].address"></textarea></td>
								<td><input type="text" name="location[0].locationname" size="10"></td>
								
								<td><input type="text" name="location[0].colorName" class="color" value=" " size="10"></td>
							</tr>
						</table>
					</td>
				</tr>
		 		
		 		<tr>
					<td><INPUT type="button" value="Add More" onclick="addRow('addressesTable')" /> 
					<INPUT type="button" value="Delete Row" onclick="deleteRow('addressesTable')" /> </td>
				</tr>
		 	
		 		<tr>
		 			<td colspan="3">
		 				<table align="center">
		 					<tr>
		 						<td><s:submit theme="simple" onclick="return validEntry()" cssClass="buttons"/></td>
		 						<td><s:reset theme="simple" cssClass="buttons"/></td>
		 						<td><input type="button" value=" Back " onclick="history.back(1);" class="buttons"></td>
		 					</tr>
		 				</table>
		 			</td>
		 		</tr>
		 		
		 	</table>
		 </s:form>
		 
	</div>
	
	
</div>	

<div id = "errorDiv" style="color: red">
			
	
		</div>									
</div>