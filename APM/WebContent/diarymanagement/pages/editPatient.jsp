<%@taglib uri="/struts-tags" prefix="s" %>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<link href="common/css/datePicker1.css" rel="stylesheet"/>
<link href="diarymanagement/css/tabStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/addPatientTab.js"></script>
	<h2 class="title" >Add Patient Details</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="tab-container">  
    <ul class="tab-menu">  
        <li id="nameAddress" class="active">Name/Address</li>  
        <li id="contacts">Contacts</li> 
        <li id="otherInfo">Other Info</li>  
        <li id="sourceOfPayment">Source of Payment</li>
       
       
          
    </ul>  
    <div class="clear"></div>  
    <div class="tab-top-border"></div>
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="updateClient" id="category_form" theme="simple">					
			<div id="nameAddress-tab" class="tab-content active">				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="20%" />
				<col width="2%" />
				<col width="30%" />
				<s:hidden id = "id" name = "id"></s:hidden>
				
					<tr>
						<td>Title<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:select id="title" name="title" list="initialList" headerKey="0" headerValue="Select Title" 
		   					 title="Select"/>	
						</td>
					</tr>
					<tr>
						<td>First Name<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="firstName" name="firstName" title="Enter First Name" />
						</td>
					</tr>
					
					<tr>
						<td>Surname<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="lastName" name="lastName" title="Enter SurName" />
						</td>
					</tr>
					<tr>
						<td>Known As<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="knownAs" name="knownAs" title="Enter Salutation" />
						</td>
					</tr>
					<tr>
						<td>Gender<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:select id="gender" name="gender" list="{'Male','Female'}" />
						</td>
					</tr>
					<tr>
						<td>Dob<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							
							<s:textfield id = "dob" name="dob"  cssClass="date-pick dp-applied"/>
						</td>
					</tr>
					<tr>
						<td>Address<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textarea id="address" name="address" title="Enter Address" />
						</td>
					</tr>
					<tr>
						<td>Town</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="town" name="town" title="Enter Town" />
						</td>
					</tr>
					<tr>
						<td>County</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="county" name="county" title="Enter County" />
						</td>
					</tr>
					<tr>
						<td>Country<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							
	 						<s:if test="%{#countryList != 'null'}" >
		   					<s:select id="country" name="country" list="countryList" headerKey="0" headerValue="Select Country" 
		   					key="label.country" labelposition="left"  
							title="Select your country from list" />
   	   					</s:if>
					</td>
					</tr>
					
					<tr>
						<td>Post Code</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="postCode" name="postCode" title="Enter postCode" />
						</td>
					</tr>
					</table>
				</div>
			<div id="contacts-tab" class="tab-content">				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				 <col width="20%" />
				 <col width="2%" />
				 <col width="30%" />	
					<tr>
						<td>Home</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="homeNo" name="homeNo" title="Enter Home Contact No" />
						</td>
					</tr>
					<tr>
						<td>Work</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="workNo" name="workNo" title="Enter Work Contact No" />
						</td>
					</tr>
					<tr>
						<td>Mobile No<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="mobNo" name="mobNo" title="Enter Mobile No" />
						</td>
					</tr>
					<tr>
						<td>Email<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="email" name="email" title="Enter Email" />
						</td>
					</tr>
					<tr>
						<td>Email CC</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="emailCc" name="emailCc" title="Enter EmailCc" />
						</td>
					</tr>
					<tr>
						<td>Prefered Contact Mode<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:select id="prefContactMode" name="prefContactMode" headerValue="Select Preference" list="{'Work','Home','Mobile','Email','EmailCc'}" title="Select Prefered Contact Mode" />
						</td>
					</tr>
					<tr>
						<td>Emergency Contact Name</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="emergencyContName" name="emergencyContName" title="Enter Emergency Contact Name" />
						</td>
					</tr>
					<tr>
						<td>Emergency Contact No.</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="emergencyContNo" name="emergencyContNo" title="Enter Emergency Contact No." />
						</td>
					</tr>
					</table>
				</div>
					
		<div id="otherInfo-tab" class="tab-content">
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
				<col width="20%" />
				<col width="2%" />
				<col width="30%" />
					
					<tr>
						<td>Reference<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							 <s:select id="reference" name="reference" list="refrenceList" headerKey="0" headerValue="Select Reference" 
		   					 title="Select your Reference from list"  onchange="showOtherRefernce()"/>	</td>
		   					<td>
		   					
		   					<div id="reference_other" style="display:none;"><s:textfield id = "otherRef" name = "otherRef" type="text" onchange="addOtherReference(this.value)"/>
							</div>
		   				</td>
					</tr>
					
					<tr>
						<td>Source of Introduction</td>
						<td align="center">:</td>
						<td>
							<s:select id="sourceOfIntro" name="sourceOfIntro" list="sourceOfIntroList" headerKey="0" headerValue="Select Source" 
		   					 title="Select your Source from list"  />
						</td>
					</tr>
					<tr>
						<td>Occupation<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							
		   					<s:select id="occupation" name="occupation" list="clientOccupationList" headerKey="0" headerValue="Select Occupation" 
		   					 title="Select your Occupation from list" onchange="showOtherOccupation()" />
		   					 
   	   						
					</td>
					<td>
					<div id="occupation_other" style="display:none;"><s:textfield id = "otherOccupation" name = "otherOccupation" type="text" onchange="addOtherOccupation(this.value)"/>
							</div>
					</td>
					</tr>
					
					<tr>
						<td>Patient Type<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:select id="patientType" name="patientType" list="{'NHS','Private'}" title="Select Patient Type" headerValue="Select Patient Type"/>
						</td>
					</tr>
					
				</table>
			</div>
		<div id="sourceOfPayment-tab" class="tab-content">
			     <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
					<col width="20%" />
					<col width="2%" />
					<col width="30%" />
					<tr>
					<td>Select who will Pay</td>
					<td align="center">:</td>
					<td><s:select id = "whopay" name = "whopay" list="{'Self','Third Party'}" onchange="showHide()"></s:select> </td>
					</tr>
					
				</table>
				
                   <s:if test="whopay == 'Third Party'">     
                    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
							<col width="20%" />
							<col width="2%" />
							<col width="30%" />			
					<tr>	
					<th colspan="3"><b>Third Party Details Information</b></th>
					</tr>
					<tr>
					</tr> 							
					<tr>
					<td>Third Party Type</td>
					<td align="center">:</td>
					<td><s:select id="type" name="type" list="thirdPartyTypeList" listKey="id" listValue="type" headerKey="0" theme="simple" headerValue="Select Type" onchange="setTypeName(this.value)"/></td>
					
					</tr>
					<tr>
					<td>Company Name</td>
					<td align="center">:</td>
					<td><s:select id="typeName" name="typeName" list="thirdPartyTypeNameList" listKey="id" listValue="thirdPartyCompanyName" headerKey="0" theme="simple" headerValue="Select Company"/></td>
					</tr>
					<tr>
					<td>Policy Authorization Code</td>
					<td align="center">:</td>
					<td><s:textfield name = "policyAuthorzCode" id = "policyAuthorzCode"/> </td>
					</tr>
					<tr>
					<td>Policy No.</td>
					<td align="center">:</td>
					<td><s:textfield name = "policyNo" id = "policyNo"/> </td>
					</tr>
					<tr>
					<td>Expiry Date</td>
					<td align="center">:</td>
					<td><s:textfield name = "expiryDate" id = "expiryDate" cssClass="date-pick dp-applied"/> </td>
					</tr>
					
				</table> 
                </s:if>  
			    
					<table align="center">
		 					<tr>
		 						<td><s:submit onclick="return validEntry()" cssClass="buttons"/></td>
		 						<td><s:reset cssClass="buttons"/></td>
		 						<td><input type="button" value=" Cancel " onclick="history.back(1);" class="buttons"></td>
		 						
		 					</tr>
		 				</table>
				
				</div>
				
		
		
				
		
						
					
					
				
		
	</s:form>
		
		<div id = "errorDiv" style="color: red">
			
	
		</div>
		
	