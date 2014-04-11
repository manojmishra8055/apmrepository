<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="common/js/pagination.js"></script>


<div id="login_main" class="main_layout_content">
	<h2 class="heading" >Clinic List</h2>
	
	<div id="login" class="block_div">
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<div>
			<s:form action="ClinicRegistration" theme="simple">
				<div align="center">Search: <s:textfield theme="simple" name="searchText" placeholder="Search by Name" size="80"/>
					<input type="submit" value="Go"/>
				</div>
			</s:form>
		</div>
		
		
			
		
		
			<div class="form_elements">	
						
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;" class="sortable <s:if test="#attr.pagination.sortColumn.equals('clinicname')">sorted <s:property value="#attr.pagination.sortClass"/> </s:if>">
						<a href="#" onclick="fnPagination(6,'fullname');">Clinic Name</a></th>
						
						<!--<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Description</th>
						--><th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Clinic Owner Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">User Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
					</tr>
					<s:if test="clinicList.size!=0">
						<s:iterator value="clinicList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><s:property  value="clinicName" /></td>
									<!--<td><s:property  value="description" /></td>
									--><td><s:property value="clinicOwner" /></td>
									<td><s:property value="userId" /></td>
									<s:hidden value="%{id}" name="id"></s:hidden>
									<s:url action="editClinicRegistration" id="edit">
    								<s:param name="id" value="%{id}"></s:param>
									</s:url>
     								<td><s:a href="%{edit}"><img src="common/images/edit.jpg"></img></s:a></td>
    								<s:url action="deleteClinicRegistration" id="delete">
									<s:param name="id" value="%{id}"></s:param>
									</s:url>
									<td><s:a href="%{delete}"><img src="common/images/delete.gif"></img></s:a></td>	
							</tr>

						</s:iterator>
					</s:if>
					<s:else>
						There is no Clinic List found!!
					</s:else>
							
				</table>
				
				<s:form action="ClinicRegistration.action" name="paginationForm" id="paginationForm" theme="simple">
			<table align="center">
				<tr>
					<td align="left">Showing all <b>(<s:property value="totalRecords"/> of <s:property value="pagerecords"/> Categories)</b></td>
				<td align="right"><%@ include file="/common/pages/pagination.jsp" %></td>
				
				</tr>
			</table>
		</s:form>
				
				
				
				
       			
       			

		
		
	</div>
</div>