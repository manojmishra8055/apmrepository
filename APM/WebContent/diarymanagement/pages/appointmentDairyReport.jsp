<%@taglib uri="/struts-tags" prefix="s" %>

<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<link href="diarymanagement/css/subModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/common.js"></script>
<script type="text/javascript" src="diarymanagement/js/subModal.js"></script>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<script type="text/javascript" src="common/js/pagination.js"></script>
<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script type="text/javascript" src="diarymanagement/js/appointmentdiaryReport.js"></script>
<script type="text/javascript" src="diarymanagement/js/apmtDiaryReport.js"></script>



<div id="login_main" class="main_layout_content">
	<h2 class="heading" >Appointment Diary User Report</h2>
	
	
	
		<s:form action="showApmtDiaryReport" id = "apmtDiaryReport_frm">
		<div class="dairyuser">
		
			<table style="margin-left:263px;margin-top: -15px">
			
			<tr>
			<td>Dairy User:</td>
			
			<s:if test="%{#diaryUserList != 'null'}" >
				 			<td><s:select id="diaryUser" name="diaryUser" list="diaryUserList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User"   /></td>
				</s:if>
				
				
				<td>From Date :</td>
				<td><s:textfield name = "fromDate" id = "fromDate" cssClass="date-pick dp-applied" theme="simple"></s:textfield></td>
				
				<td>To Date :</td>
				<td><s:textfield name = "toDate" id = "toDate" cssClass="date-pick dp-applied" theme="simple"></s:textfield></td>
				
				
				<td><s:submit value="Go" theme="simple" cssClass="buttons"></s:submit></td>
				<td>
				<input type="button" value="Print Preview" onclick="showPreview()" class="buttons"></td> 
				</tr>	
				
			
			</table>
			
		</div>
		
		<div class="form_elements">	
						
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Date</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Time</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Duration</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Diary User</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Client Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">New</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Exist</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Attend</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">DNA</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Details</th>
						
						
					</tr>
					<s:if test="apmtDiaryReportList.size!=0">
						<s:iterator value="apmtDiaryReportList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><s:property  value="date" /></td>
									<td><s:property  value="startTime" /></td>
									<td><s:property  value="duration" /></td>
									<td><s:property  value="diaryUser" /></td>
									<td><s:property  value="clientName" /></td>
									<td><s:property  value="newClient" /></td>
									<td><s:property  value="exist" /></td>
									<td><s:property  value="attend" /></td>
									<td><s:property  value="dna" /></td>
									<td><s:property  value="notes" /></td>
									
									
									
									
									
							</tr>

						</s:iterator>
					</s:if>
					</table>
					<s:else>
						There is no Record found!!
					</s:else>
							
				</div>
			
				
			</s:form>	
				</div>
				
				
				
       			
       			

		

