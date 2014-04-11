<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="treatmentEpisode/js/addTreatmentEpisode.js"></script>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title">Edit Treatment Episode Details</h2><br><br>
	<div id="login" class="block_div">
	
		<div class="form_elements" id="treatmentEpisodeFrm">		
		<div style="font-weight: bold;" id="namediv">Rahul,male,12/02/1985 </div><br>
			<s:form action="updateSaveTreatmentEpisode" theme="simple" >
			<s:hidden name="clientId" id="clientId"/>
			<s:hidden name="client" id = "client" theme="simple"/>
				<table width="100%" style="font-size: 12px;">
					<tr>
						<td width="50%">
							<table width="100%">
								<col width="10%"/>
								<col width="2%"/>
								<col width="30%"/>
								<s:hidden id = "id" name = "id"></s:hidden>
								<tr>
									<td>Treatment Start Date</td>
									<td align="center">:</td>
									
									<td><s:textfield id="treatmentStartDate" cssClass="date-pick dp-applied"   name="treatmentStartDate"/></td>
									
								</tr>
								<tr>
									<td>Department</td>
									<td align="center">:</td>
									<td>
										<select name="department">
											<option value="0">Select Department</option>
										</select>
									</td>
								</tr>
								
							</table>
						
						</td>
						<td width="50%" valign="top">
							<table width="100%">
								<col width="10%"/>
								<col width="2%"/>
								<col width="30%"/>
								<tr>
									<td>Practitioner Responsible</td>
									<td align="center">:</td>
									<td>
										<s:if test="%{#userList != 'null'}" >
				 							<s:select id="diaryUser" name="diaryUser" list="userList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User" />
										</s:if>
									</td>
								</tr>
								<tr>
									<td>Location</td>
									<td align="center">:</td>
									<td>
										<select name="location">
											<option value="0">Select Location</option>
										</select>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2">Treatment Episode Name :<s:textfield name="treatmentEpisodeName" id="treatmentEpisodeName" size="40"/></td>
					</tr>
					<tr>
						<td colspan="2"><hr></td>
					</tr>
					<tr>
						<td colspan="2"><span>Referral Date</span><s:textfield name="referalDate" id="referalDate" cssClass="date-pick dp-applied"/>
						 &nbsp;&nbsp;&nbsp;&nbsp;	Referral Name : <s:textfield name="referralName" id="referralName"></s:textfield>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<table width="100%">
								<col width="10%"/>
								<col width="2%"/>
								<col width="30%"/>
								<tr>
									<td>Referral Source</td>
									<td align="center">:</td>
									<td>
										 
									<s:select list="sourceOfReferralList" name = "referralSource" id = "referralSource" theme="simple" headerKey="id" headerValue="Select Referral Source" listValue="referralSource" listKey="referralSource"></s:select>	
										
									</td>
								</tr>
								<tr>
								<td>Referral Contact</td>
									<td align="center">:</td>
									<td>
										<select name="referralContact" id="referralContact"> 
											<option value="0">Select Referral Contact</option>
										</select> 
									</td>
								</tr>
								<tr>
									<td colspan="3">
										Referral Letter : 
										<s:select list="{'Consultant Referral Letter','GP Referral Letter','Self Referral Letter'}"  name = "referralLetter" id = "referralLetter" theme="simple" headerValue="Select Referral Letter"></s:select>	

										<input type="button" value="Send/Scedule Letter">
									</td>
								</tr>
								<tr><td colspan="3"></td></tr>
								<tr>
									<td colspan="3" style="color: blue; font-weight: bold;">Select who will be paying for this Treatment Episode </td>
								</tr>
								<tr>
									<td colspan="3">
										<s:radio name="payby" id="" list="{'Client','Third Party'}" value="'Client'" onclick="setPayBy(this.value)"></s:radio>
										<s:textfield name="thirdPartyName" id="thirdPartyName" cssStyle="display:none;"/>
									</td>
								</tr>
								<tr>
									<td>Invoicee</td>
									<td align="center">:</td>
									<td>
										<s:textfield name="invoicee" id="invoicee"/>
									</td>
								</tr>
								<tr>
									<td>Third Party Authorisation Code</td>
									<td align="center">:</td>
									<td>
										<s:textfield name="authorisationCode" id="authorisationCode"  disabled="true"/>
									</td>
								</tr>
								<tr>
									<td>Spend Limit</td>
									<td align="center">:</td>
									<td>
										<s:textfield name="spendLimit" id="spendLimit"  disabled="true"/>
									</td>
								</tr>
								<tr>
									<td>No. of Consultation Limit</td>
									<td align="center">:</td>
									<td>
										<s:textfield name="consultationLimit" id="consultationLimit"  disabled="true"/>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										Discharge Letter : 
										<select name="dischargeLetter" id="dischargeLetter"> 
											<option value="0">Select</option>
										</select> 
										<input type="button" value="Send/Scedule Letter">
									</td>
								</tr>
								<tr>
									<td colspan="3"><hr></td>
								</tr>
								<tr>
									<td></td>
									<td><input class="buttons" type="submit" value="Update"></td>
		 						    <td><input type="button" value=" Cancel " onclick="history.back(1);" class="buttons"></td>
								</tr>
							</table>
							
							
							
						</td>
					</tr>
					
				</table>
				
				
			
				
			
			</s:form>
		</div>
	
	</div>
 </div>