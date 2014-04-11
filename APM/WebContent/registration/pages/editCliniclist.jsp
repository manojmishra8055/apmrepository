<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.apm.Registration.eu.entity.*"%>
<script type="text/javascript" src="registration/js/editclinic.js"></script>
<script type="text/javascript" src="jscolor/jscolor.js"></script> 
 

<div id="login_main" class="main_layout_content">

	<h2 class="heading" >Edit Clinic Profile</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="login" class="block_div">
		<span class="error"><s:actionerror id="server_side_error"/></span>
		
		<s:form action="updatesaveClinicRegistration" id="cliniclist_form" theme="simple" validate="True">
			<s:hidden name="id" id="id"></s:hidden>
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
		 		<tr>
		 			<td colspan="3"><b>Access to Subscription</b><hr></td>
		 		</tr>
		 		<tr>
		 			<td valign="top">Package Subscription</td>
		 			<td valign="top" align="center">:</td>
		 			<td>
		 				<table width="100%">
		 					<tr>
		 						<td> 
		 							<s:checkbox name="standalone" id="standalone" title="Local APM with Local DB without any backup"/><s:label value="StandAlone"></s:label>
					
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="hostedDB" id="hostedDB" title="(Only DB is backed up betn Local DB and Server)"/><s:label value="Hosted DB"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="onlineSingleDevice" id="onlineSingleDevice" title="(Online Single Device (PC))"/><s:label value="Online(single device (PC))"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="onlineMultiDevice" id="onlineMultiDevice" title="(Online Multi Device StandAlone, Online, Online Mobile Apps, Responsive Apps"/><s:label value="Online(Multi Device)"></s:label>
		 						</td>
		 					</tr>
		 					
		 					
		 				</table>
		 				
		 			</td>
		 		</tr>
		 		
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
		 							<s:checkbox name="diaryManagement" id="diaryManagement" title="Diary Maangement"/><s:label value="Diary Maangement"></s:label>
 							
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="appointmentBooking" id="appointmentBooking" title="Appointment Booking"/><s:label value="Appointment Booking"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td>
		 							<s:checkbox name="basicFinance" id="basicFinance" title="Basic Finance"/><s:label value="Basic Finance"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td style="padding-left: 3px; font-weight: bold;"><u>Advance Package ( All of above + ) :</u></td>
		 					</tr>
		 					<tr>
		 						<td> 
		 							<s:checkbox name="fullFinance" id="fullFinance" title="Full Finance"/><s:label value="Full Finance"></s:label>
	 							
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="medicalRecord" id="medicalRecord" title="Medical Record"/><s:label value="Medical Record"></s:label>
		 						</td>
		 					</tr>
		 					
		 					<tr>
		 						<td style="padding-left: 3px; font-weight: bold;"><u>Premier Package ( All of above + ) : </u> </td>
		 					</tr>
		 					<tr>
		 						<td> 
		 							<s:checkbox name="clinicResourceMngment" id="clinicResourceMngment" title="Clinic Resource Management"/><s:label value="Clinic Resource Management"></s:label>
		 								
		 							
		 						</td>
		 						
		 					</tr>
		 					<tr>
		 						<td>
		 							<s:checkbox name="clinicPayrollMngment" id="clinicPayrollMngment" title="Clinic Payroll Management"/><s:label value="Clinic Payroll Management"></s:label>
		 						</td>
		 					</tr>
		 				</table>
		 				
		 			</td>
		 		</tr>
		 		
		 		
		 		
		 		
		 		<tr><td colspan="3"></td></tr>
		 		
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
		 		<!--<tr>
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
		 		--><tr><td colspan="3" style="height: 8px;"></td></tr>
		 		
		 		<tr>
		 			<td colspan="3"><b>Clinic Location</b><hr></td>
		 		</tr>
		 		
		 		
		
		<!-- Lcation1 --> 	
				
				<tr>
					<td colspan="3">
						<table id="addressesTable" style="font-size: 12px;">
							<tr>
								<th align="center">Country</th>
								<th align="center">City</th>
								<th align="center">Postcode</th>
								<th align="center">Address</th>
								<th align="center">Location</th>
								<th align="center">Color</th>
							</tr>
							<%int lcount = (Integer)session.getAttribute("locationcount"); %>
							
							<%ArrayList<Clinic>clinicLocationlist = (ArrayList<Clinic>)session.getAttribute("clinicLocationlist"); 
								int i = 0;
							%>
							<%ArrayList<Clinic>colorList = (ArrayList<Clinic>)session.getAttribute("colorList"); 
								int j = 0;
							%>
								
										
										
										<% for(Clinic clinicList:clinicLocationlist ) {%>
											<tr>
												<td><input class="Countrytxt" type="text" name="location[<%=i%>].country" value="<%=clinicList.getCountry() %>" ><span style="display:none; color:rgb(204, 41, 0);font-family:verdana;font-size:14px;" id="lblcountry<%=i%>">Please enter country</span></td>
												<td><input class="Citytxt" type="text" name="location[<%=i%>].city" value="<%=clinicList.getCity() %>" ><span style="display:none; color:rgb(204, 41, 0);;font-family:verdana;font-size:14px;" id="lblcity<%=i%>">Please enter City</span></td>
												<td><input class="Pincodetxt" type="text" name="location[<%=i%>].pinCode" value="<%=clinicList.getPinCode() %>"><span style="display:none; color:rgb(204, 41, 0);;font-family:verdana;font-size:14px;" id="lblpinCode<%=i%>">Please enter Pincode</span></td>
												<td><textarea class="Addresstxt" name="location[<%=i%>].address" ><%=clinicList.getAddress() %></textarea><span style="display:none; color:rgb(204, 41, 0);;font-family:verdana;font-size:14px;"  id="lbladdress<%=i%>" >Please enter address</span></td>
												<td><input class="Locationnametxt" type="text" name="location[<%=i%>].locationname" value="<%=clinicList.getLocationname() %>"><span style="display:none; color:rgb(204, 41, 0);;font-family:verdana;font-size:14px;" id="lbllocation<%=i%>">Please enter Location</span></td>
												<td><input type="text" name="location[<%=i%>].colorName" class="color" value="<%=clinicList.getColorName()%>"></td>	
												
												<td><input style="display:none" type="text" name="location[<%=i%>].locationid" value="<%=clinicList.getLocationid() %>"></td>
											</tr>
											<% i++;%>
										<%} %>
						
						</table>
					</td>
				</tr>
		 		
		 		<!--<tr>
					<td><INPUT type="button" value="Add More" onclick="addRow('addressesTable')" /> </td>
				</tr>
		 		
		 		
		 		
		 		
		 		--><tr>
		 			<td colspan="3">
		 				<table align="center">
		 					<tr>
		 						<td><s:submit theme="simple" cssClass="buttons" /></td>
		 						<td><s:reset theme="simple" cssClass="buttons"/></td>
		 					</tr>
		 				</table>
		 			</td>
		 		</tr>
		 		
		 	</table>
		
		</s:form>
		
	
	</div>
	
	
	
</div>