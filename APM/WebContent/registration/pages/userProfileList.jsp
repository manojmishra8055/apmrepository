<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="registration/js/userprofile.js"></script>

<script type="text/javascript" src="common/js/pagination.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title">User Profile</h2>
	
	<div id="login" class="block_div">
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<div class="diaryuser"> <a style="text-decoration: none" href="inputUserProfile" ><input type="button" value="Add" class="buttons" style="margin-left: 8px;"/></a>
			<s:form action="UserProfile" theme="simple">
				<div align="center"><s:textfield theme="simple" name="searchText" placeholder="Search by Name" size="80" cssClass="Search"/>
					<input type="submit" value="Go" class="go"/>
				</div>
			</s:form>
		</div>
		
		
			
		
		
			<div class="form_elements">	
						
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;" class="sortable <s:if test="#attr.pagination.sortColumn.equals('fullname')">sorted <s:property value="#attr.pagination.sortClass"/> </s:if>">
						<a style="text-decoration: none" href="#" onclick="fnPagination(6,'firstname');">First Name</a></th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Last Name</th>
						<!--<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Description</th>
						--><th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Job Title</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Discription</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
					</tr>
					<s:if test="userProfileList.size!=0">
						<s:iterator value="userProfileList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><s:property  value="firstname" /></td>
									<td><s:property  value="lastname" /></td>
									<td><s:property value="jobtitle" /></td>
									<td><s:property value="discription" /></td>
									<s:hidden value="%{id}" name="id"></s:hidden>
									<s:url action="editUserProfile" id="edit">
    								<s:param name="id" value="%{id}"></s:param>
									</s:url>
     								<td><s:a href="%{edit}"><img src="common/images/edit.jpg"></img></s:a></td>
    								<s:url action="deleteUserProfile" id="delete">
									<s:param name="id" value="%{id}"></s:param>
									</s:url>
									<td><s:a href="%{delete}" onclick = "return confirmedDelete()"><img src="common/images/delete.gif"></img></s:a></td>	
							</tr>

						</s:iterator>
					</s:if>
					<s:else>
						There is no User Profile found!!
					</s:else>
							
				</table>
				
				<s:form action="UserProfile" name="paginationForm" id="paginationForm" theme="simple">
				<table align="center">
					<tr>
						<td align="left">Showing all <b>(<s:property value="pagerecords"/> of <s:property value="totalRecords"/> Records)</b></td>
					<td align="right"><%@ include file="/common/pages/pagination.jsp" %></td>
					
					</tr>
					
				</table>
			</s:form>	
				
				
				
				
       			
       			

		
		
	</div>
</div>