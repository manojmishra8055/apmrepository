<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="appointment/js/appointment_type.js"></script>
<script type="text/javascript" src="common/js/pagination.js"></script>

   
 
 

   
<div id="login_main" class="main_layout_content">
	<h2 class="title" style="margin-right: 20px">All Occupations List</h2>
	
	<div id="login" class="block_div">
		
					<div class="diaryuser">	
					<a style="text-decoration: none" href="addOccupationMaster" ><input type="button" value="Add" class="buttons"/></a> <br><br>
					</div>
				<div class="form_elements">
					
					
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
					</tr>
					<s:if test="occupationList.size!=0">
						<s:iterator value="occupationList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									
									
									<td><s:property  value="occupation"/></td>
									
									
									
									<s:hidden value="%{id}" name="id"></s:hidden>
									<s:url action="editOccupationMaster" id="edit">
    								<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
     								<td><s:a href="%{edit}"><img src="common/images/edit.jpg"></img></s:a></td>
    								<s:url action="deleteOccupationMaster" id="delete">
									<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
									<td><s:a href="%{delete}" onclick = "return confirmedDelete()"><img src="common/images/delete.gif"></img></s:a></td>	
							</tr>

						</s:iterator>
					</s:if>
					<s:else>
						There is no Occupation found!!
					</s:else>
							
				</table>  			

		<s:form action="occupationMaster" name="paginationForm" id="paginationForm" theme="simple">
				<table align="center">
					<tr>
						<td align="left">Showing all <b>(<s:property value="pagerecords"/> of <s:property value="totalRecords"/> Records)</b></td>
					<td align="right"><%@ include file="/common/pages/pagination.jsp" %></td>
					
					</tr>
					
				</table>
			</s:form>
		
	</div>
</div>