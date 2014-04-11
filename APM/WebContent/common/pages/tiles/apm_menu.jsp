
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@page import="com.apm.common.web.common.helper.LoginInfo"%>
<%@page import="com.apm.common.web.common.helper.LoginHelper"%>
<link rel="icon" href="images/icon.ico">
<link rel="stylesheet" type="text/css" href="Design/MenuItems/pro_drop_1.css" />
<link href="Design/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Design/js/jquery.js"></script>
<script type="text/javascript" src="Design/js/interface.js"></script>
<script src="Design/MenuItems/stuHover.js" type="text/javascript"></script>



<table style="background-color: #7ecefd;" width="100%" border="0">
  <tr>
    <td>


<div id="Menu" style="background-image:url(MenuItems/BG.gif); background-repeat:repeat-x; width:100%; height:29px;">
<ul id="nav" name="nav">
<!--<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title=""> File</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title=""> Edit</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title=""> View</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title=""> Tolls</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title=""> Help</span></a></li>

-->


	<%LoginInfo loginInfo = LoginHelper.getLoginInfo(request); %>
			<s:if test="(#session.LOGIN_INFO != null)&&(#session.LOGGED_IN)">
				
				<li class="top"><a href="Logout" id="services" class="top_link"><span class="top_link">Logout</span></a></li>
					<%if(loginInfo.getUserType() == 1){ %>
						<li class="top"><a href="ClinicRegistration" id="services" class="top_link"><span class="top_link">Clinic</span></a></li>	
						
					<%} %>
					<%if(loginInfo.getUserType() == 2){ %>
						<li class="top"><a href="#" id="services" class="top_link"><span class="top_link">Master</span></a>
							<ul class="sub">
								<li><a href="DiaryMangent">Diary Management</a></li>
								<li><a href="UserProfile">Practitioner</a></li>
								
								<!--<li class="top"><a href="NotAvailableSlot">Not Available Slot</a></li>
								--><li><a href="AppointmentType">Appointment Type</a></li>
								<li><a href="occupationMaster">Occupation</a></li>
								<li><a href="jobTitleMaster">Job Title</a></li>
								<li><a href="referenceMaster">Reference</a></li>
								
							</ul>
						</li>
						<li class="top"><a href="#" id="services" class="top_link"><span class="top_link">Accounts</span></a>
							<ul class="sub">
								<li><a href="inputAccounts">Accounts</a></li>
								<li><a href="createChargeCompleteApmt">Create Charge</a></li>
							</ul>
						</li>
						<li class="top"><a href="allUserNotAvailableSlot" id="services" class="top_link"><span class="top_link">Appointment</span></a></li>
						<li class="top"><a href="#" id="services" class="top_link"><span class="top_link">Report</span></a>
							<ul class="sub">
								<li><a href="ApmtDiaryReport">Appointments Diary List Report</a></li>
								<li><a href="walkInAndPreBookedApmtDiaryReport">Walk In and Pre-Booked Appointment</a></li>
							</ul>
						</li>
						
						<!-- Unnati -->
						<li class="top"><a href="#" id="services" class="top_link"><span class="top_link">Third-Parties</span></a>
							<ul class="sub">
								<li><a href="ThirdParty">List Third Party </a></li>
								<li><a href="typeListThirdParty">Third Party Type</a></li>
								
								
							</ul>
						</li>
						
						<li class="top"><a href="#" id="services" class="top_link"><span class="top_link">Manage Client</span></a>
							<ul class="sub">
								<li><a href="manageClient">Client</a></li>
								<li><a href="showTreatmentEpisode">Treatment Episode</a></li>
								
								
								
							</ul>
						</li>		
						
							
									
					<%} %>
					<%if(loginInfo.getUserType() == 3){ %>
						<li class="top"><a href="PracticeManager" id="services" class="top_link"><span class="top_link">Practice Manager</span></a></li>		
					<%} %>
					<%if(loginInfo.getUserType() == 4){ %>
						<li class="top"><a href="UserProfile" id="services" class="top_link"><span class="top_link">Practitioner</span></a></li>		
					<%} %>
					<%if(loginInfo.getUserType() == 5){ %>
						<li class="top"><a href="Appointment" id="services" class="top_link"><span class="top_link">Appointment</span></a></li>		
					<%} %>
				
				
				</s:if>	
			
			<s:else>
				<li class="top"><a href="inputLogin" id="services" class="top_link"><span class="top_link">Login</span></a></li>
				<li class="top"><a href="inputClinicRegistration" id="services" class="top_link"><span class="top_link">Clinic Registration</span></a></li>
			</s:else>



<div class="topmenuright">
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title="Web designing Company in India"> Hi Guest</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title="Web designing Company in India"> Admin</span></a></li>
<li class="top"><a href="#22" id="services" class="top_link"><span class="top_link" title="Web designing Company in India"> Nagpur</span></a></li>
</div>

</ul>
</div>
    
 
    </td>
  </tr>
</table>



