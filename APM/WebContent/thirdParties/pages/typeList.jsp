<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="common/js/pagination.js"></script>

   
 
 

   
<div id="login_main" class="main_layout_content">
	<h2 class="title" >All Third Party Type</h2>
	
	
					<div class = "menu">
					<a href="addTypeThirdParty" style="text-decoration: none" ><input type="button" class="buttons" value="Add"></a>
					</div>
	<div id="login" class="block_div">
		
		<div class="form_elements">	
						<input type="hidden" id = "client" name ="client" > 
					<input type="hidden" id = "clientId" name ="clientId" >
					
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Id</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Description</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
						
					</tr>
					<s:if test="thirdPartyTypeList.size!=0">
						<s:iterator value="thirdPartyTypeList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><s:property  value="id" /></td>
									
									<td><s:property  value="name" /></td>
									<td><s:property  value="description" /></td>
									
									
									
									
									
									
									<s:hidden value="%{id}" name="id"></s:hidden>
									<s:url action="editTypeThirdParty" id="edit">
    								<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
     								<td><s:a href="%{edit}"><img src="common/images/edit.jpg"></img></s:a></td>
    								<s:url action="deleteTypeThirdParty" id="delete">
									<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
									<td><s:a href="%{delete}" onclick = "return confirmedDelete()"><img src="common/images/delete.gif"></img></s:a></td>	
							</tr>

						</s:iterator>
					</s:if>
					<s:else>
						There is no Client found!!
					</s:else>
							
				</table>
				
				<s:form action="typeListThirdParty" name="paginationForm" id="paginationForm" theme="simple">
			<s:hidden name = "name"></s:hidden>
				<table align="center">
					<tr>
						<td align="left">Showing all <b>(<s:property value="pagerecords"/> of <s:property value="totalRecords"/> Records)</b></td>
					<td align="right"><%@ include file="/common/pages/pagination.jsp" %></td>
					
					</tr>
					
				</table>
			</s:form>	
				
				
		
	</div>
</div>