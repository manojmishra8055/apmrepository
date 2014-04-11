<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="registration/js/edituserprofile.js"></script>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="registration/js/userProfileTab.js"></script>
<link href="registration/css/tabStyle.css" rel="stylesheet"/>
<div class="main_layout_content">
	
	<div id="contact_details" class="block_div"> 

	<h2 class="heading" >Edit User Profile</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<span class="error"><s:actionerror id="server_side_error"/></span>
	<div id="tab-container">  
   		<ul class="tab-menu">  
        <li id="userDetails" class="active">User Details</li>  
      	<li id="userSetup">User Setup</li>
        <li id="loginDetails">Login Details</li>  
        <li id="preferences">Preferences</li>  
          
    </ul>  
    <div class="clear"></div>  
    <div class="tab-top-border"></div>
		<s:form action="updatesaveUserProfile" id="userprofile_form" theme="simple" validate="True">
		<s:hidden name="id" id="id"></s:hidden>
		<div id="userDetails-tab" class="tab-content active">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="30%"/>
				<col width="30%"/>
								
								
								
								<tr>
									
									<td style="font-weight: bold;">First Name<span class="reqd-info">*</span></td>
									<td><s:textfield name="firstname" id="firstname" ></s:textfield> </td>
									
									
								
								</tr>
								
								<tr>
									
									<td style="font-weight: bold;">Last Name<span class="reqd-info">*</span></td>
									<td><s:textfield name="lastname" id="lastname" ></s:textfield> </td>
									
									
								
								</tr>
								
								<tr> 
									<td style="font-weight: bold;">Initial<span class="reqd-info">*</span></td>
										
									<td>
									<s:select id="initial" name="initial" list="initialList" headerKey="0" headerValue="Select Title" 
		   					 title="Select"  />	
									</td>
									
								
								</tr>
								
								<tr> 
									<td style="font-weight: bold;">Job Title<span class="reqd-info">*</span></td>
										
									<td>
										<s:select id="jobtitle" name="jobtitle" list="jobTitleList" headerKey="0" headerValue="Select Job Title" 
		   					 title="Select" onchange="showOtherJobTitle()"/>	
		   					
		   					
		   					<div id="jobTitle_other" style="display:none;"><s:textfield id = "otherJobTitle" name = "otherJobTitle"  onchange="addOtherJobTitle(this.value)"/>
							</div>
							</td>
								
								<tr> 
									<td style="font-weight: bold;">Discipline<span class="reqd-info">*</span></td>
										
									<td>
										<!--<SELECT name="discipline" style="width: 100px;"">
											<option value="1">Dummy One</option>
											<option value="2">Dummy Two</option>
											<option value="3">Dummy Three</option>
											<option value="4">Dummy Four</option>
											<option value="5">Dummy Five</option>
										</SELECT>
									-->
										
										<s:select name="diciplineName" list="diciplineList" id="diciplineName" >
											
										</s:select>
									
									</td>
								
								</tr>
					</table>
					
								
			</div>
			<div id="userSetup-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="30%"/>
				<col width="30%"/>
								
								
								
								<tr> 
									<td style="font-weight: bold;">This User</td>
										
									<td>
										<s:checkbox id="usercheck" name="usercheck">is a practitioner</s:checkbox>
									</td>
									
								
								</tr>
								
								<tr> 
									<td style="font-weight: bold;"></td>
										
									<td>
										<s:checkbox id="appointmentdiary" name="appointmentdiary" >has an Appointment Diary</s:checkbox>
									</td>
								
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Diary Color</td>
										
									<!--<td>
										 <s:textfield name="diarycolor" id="diarycolor" ></s:textfield> 
										<s:select name="diarycolor" list="diarycolorList" id="diarycolor" >
											
										</s:select>
									</td>
									-->								
									<td><s:textfield name="diarycolor" id="diarycolor" cssClass="color" value="66ff00"></s:textfield></td>
									
																									
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Diary Column Position</td>
										
									<td>
										<s:textfield name="diarycolumnposition" id="diarycolumnposition" ></s:textfield>
									</td>
									
																									
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Compression Rate %</td>
										
									<td>
										<s:textfield name="compressionrate" id="compressionrate" ></s:textfield>
									</td>
									
																									
								</tr>
								<tr> 
																								
									<td style="font-weight: bold;">Name to display for online Booking</td>
									<td>
										<s:textfield name="onlinename" id="onlinename" ></s:textfield>
									</td>	
																								
								</tr>
								
															
								<tr> 
									<td style="font-weight: bold;">This User</td>
										
									<td>
										<s:checkbox id="isavailableonline" name="isavailableonline">Is Available for online Booking?</s:checkbox>
									</td>
									
								
								</tr>
							</table>
				</div>	
						
							
			<div id="loginDetails-tab" class="tab-content">
				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="30%"/>
				<col width="30%"/>
								
								
								
								
								<tr> 
									<td style="font-weight: bold;">&nbsp;</td>
										
									<td>
										<s:checkbox id="loginsystem" name="loginsystem">This user needs to log into the system</s:checkbox>
									</td>
									
								
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">UserId</td>
										
									<td>
										<s:textfield name="userId" id="userId" ></s:textfield>
									</td>
									
																									
								</tr>
								
								
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Last changed</td>
										
									<td>
										<s:label id="lastchanged" name="lastchanged" theme="simple" />
									</td>
									
																									
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Change Freq</td>
										
									<td>
										<s:textfield name="changefre" id="changefre" ></s:textfield>&nbsp;(days 0=never)
									</td>
									
																									
								</tr>
								</table>
				</div>
							
			<div id="preferences-tab" class="tab-content">
			
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="30%"/>
				<col width="30%"/>
								
								<tr> 
									<td style="font-weight: bold;">Appointment Booking Confirmation Template<span class="reqd-info">*</span></td>
										
									<td>
										
										
										<s:select name="appointmentbookingcontem" list="abctList" id="appointmentbookingcontem" >
											
										</s:select>
									
									</td>
								
								</tr>
								
								<tr> 
									<td style="font-weight: bold;">Appointment DNA Template<span class="reqd-info">*</span></td>
										
									<td>
										
										
										<s:select name="appointmentbookingdnatem" list="adtList" id="appointmentbookingdnatem" >
											
										</s:select>
									
									</td>
								
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Contact E-mail Address</td>
										
									<td>
										<s:textfield id="email" name="email" key="label.email" labelposition="left" required="true" size="50"
										title="Enter valid email id, it will be used to send job notifications, eg. yourname@gmail.com, yourname@yahoo.co.in" />
									</td>
									
																									
								</tr>
								
								<tr> 
								
																	
									<td style="font-weight: bold;">Mobile No (for SMS Confirmation)</td>
										
									<td>
										<s:textfield id="mobile" name="mobile" key="label.mobileNo" labelposition="left" required="true" 
  										title="Specify valid mobile number, eg 9876543210" />
									</td>
									
																									
								</tr>
								
								<tr> 
									<td style="font-weight: bold;">Notify of new appointments booked via</td>
										
									<td>
										<s:checkbox id="apmremote" name="apmremote"></s:checkbox>APM Remote
										
									</td>
									
								
								</tr>
								<tr> 
									<td style="font-weight: bold;">&nbsp;</td>									
									<td>
										<s:checkbox id="onlinebooking" name="onlinebooking"></s:checkbox>Online Booking
									</td>
									
								
								</tr>
								
								<tr>
									<td colspan="6" align="center">
										<s:submit onclick="return validEntry()" cssClass="buttons"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" value=" Cancel " onclick="history.back(1);" class="buttons">
									</td>
									
									
								</tr>
								
				
				
				
				</table>
					</s:form>
		
			
			</div>
		
	<div id = "errorDiv" style="color: red">
			
	
		</div>	
	
</div>
	
</div>	
	
