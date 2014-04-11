<%@taglib uri="/struts-tags" prefix="s" %>
<div id="login_main" class="main_layout_content">
	<h4 class="title" style="margin-right: 20px;margin-left: 45px">All AppointmentList</h4>
	
	<div id="login" class="block_div">
		
		
					<div class="form_elements">	
						
					Practioner Name :<b> <s:property value="practitonerName"/> </b>  Date : <b><s:property value="date"/></b> to <b><s:property value="toDate"/></b> 
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Time</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Duration</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Patient</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Appointment Type</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Note</th>
				
					</tr>
					<s:if test="practitionerApmtList.size!=0">
						<s:iterator value="practitionerApmtList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><s:property  value="sTime" /></td>
									<td><s:property  value="apmtDuration" /></td>
									<td><s:property  value="client" /></td>
									<td><s:property  value="apmtType" /></td>
									<td><s:property  value="notes" /></td>	
										
							</tr>

						</s:iterator>
					</s:if>
					</table>
					<s:else>
						There is no Appointment!!
					</s:else>
			
	</div>
</div>