<%@taglib uri="/struts-tags" prefix="s" %>

<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<script type="text/javascript" src="common/js/pagination.js"></script>
<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script type="text/javascript" src="diarymanagement/js/appointmentdiaryReport.js"></script>



	<h4 class="heading" align="center">Appointment Diary User Report</h4>
	
	
		
		
		
						
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
					<s:else>
						There is no Record found!!
					</s:else>
							
				</table>
				
			
				
				
				
				
       			
       			

		
		
	