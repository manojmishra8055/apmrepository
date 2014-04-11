<%@taglib uri="/struts-tags" prefix="s" %>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<link href="common/css/datePicker1.css" rel="stylesheet"/>
<link href="diarymanagement/css/tabStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/addPatientTab.js"></script>
	<h2 class="title" >Add Patient Details ooooo</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="saveClient" id="category_form" theme="simple">
			
			
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				
					<tr>
						<td>Title<span class="reqd-info">*</span></td>
						<td>Firstname<span class="reqd-info">*</span></td>
						<td>Surname<span class="reqd-info">*</span>
					</tr>
					<tr>
						<td><s:select id="title" name="title" list="initialList" title="Select" theme="simple" /></td>
		   				<td><s:textfield id="firstName" name="firstName" title="Enter First Name" theme="simple" /></td>
		   				<td><s:textfield id="lastName" name="lastName" title="Enter SurName"  theme="simple"/></td>
		   				
					</tr>
					<tr>
						
						<td colspan="2">Gender:<span class="reqd-info">*</span><s:select id="gender" name="gender" list="{'Male','Female'}"  theme="simple" />Dob:<span class="reqd-info">*</span></td>
					    <td><input type="text" id = "dob" name="dob"  class="date-pick dp-applied" ></td>
					</tr>
					
					<tr>
					
						<td>Address<span class="reqd-info">*</span></td>
						<td><input type="text" id="address" name="address" title="Enter Address" size="40"/></td>
						
						
					</tr>
					<tr>
					<td>Town</td>
					<td><s:textfield id="town" name="town" title="Enter Town" /></td>
					
					</tr>
					<tr>
					<td>County</td>
					<td><s:textfield id="county" name="county" title="Enter County" theme="simple" /></td>
						
					</tr>	
					<tr>
					<td>Country<span class="reqd-info">*</span></td>
					<td><s:if test="%{#countryList != 'null'}" >
		   					<s:select id="country" name="country" list="countryList" headerKey="0" headerValue="Select Country" 
		   					labelposition="left"  
							title="Select your country from list" theme="simple" />
   	   					</s:if></td>
   	   					
					</tr>
					
					<tr>
					<td>Post Code :</td>
					<td> <input type="text" id="postCode" name="postCode" title="Enter postCode" /></td>
					</tr>
					
					
					
					
		
					</table>
							
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				
					<tr>
						<td>Home</td>
						
						<td>
							<s:textfield id="homeNo" name="homeNo" title="Enter Home Contact No" />
						</td>
					</tr>
					<tr>
						<td>Work</td>
						
						<td>
							<s:textfield id="workNo" name="workNo" title="Enter Work Contact No" />
						</td>
					</tr>
					<tr>
						<td>Mobile No<span class="reqd-info">*</span></td>
						
						<td>
							<s:textfield id="mobNo" name="mobNo" title="Enter Mobile No" />
						</td>
					</tr>
					<tr>
						<td>Email<span class="reqd-info">*</span></td>
						
						<td>
							<s:textfield id="email" name="email" title="Enter Email" />
						</td>
					</tr>
					<tr>
						<td>Source of Introduction</td>
						
						<td>
							<s:select id="sourceOfIntro" name="sourceOfIntro" list="sourceOfIntroList" headerKey="0" headerValue="Select Source" 
		   					 title="Select your Source from list"  />
						</td>
					</tr>
					
					</table>
				
			   
				
				
				
		
		
				
		
						
					
					
				
		
	</s:form>
		
		<div id = "errorDiv" style="color: red">
			
	
		</div>
		
	