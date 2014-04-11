<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>

   
 
 

   
<div id="login_main" class="main_layout_content">
	<h2 class="title" style="margin-right: 20px">All Treatment Episode</h2>
	
	<div id="login" class="block_div">
		
					
		<div class="form_elements">
		 <s:form action="showTreatmentEpisode">
			<table>
				<tr>
				   <td><b>Client</b></td>
				   <td align="center">:</td>
				   <s:hidden name="clientId" id = "clientId" theme="simple"></s:hidden>  
				   <td><s:textfield name="client" id = "client" readonly="true" size="18" theme="simple"></s:textfield><a href="Client" style="text-decoration: none" target="blank" onclick="window.open(this.href, 'mywin',
						'left=20,top=20,width=800,height=500,toolbar=1,resizable=0'); return false;"> <input type="button" value = "Search" class = "buttons"></a>
					</td>
					<td><s:submit value="Show Treatment Episode" theme="simple" cssClass="buttons"></s:submit></td>
					<td>
					<a href="inputTreatmentEpisode" style="text-decoration: none" target="blank" onclick="window.open(this.href, 'mywin',
					'left=20,top=20,width=800,height=500,toolbar=1,resizable=0'); return false;"> 
					</td>
					<td>
						<a href="addPageTreatmentEpisode" style="text-decoration: none" ><input type="button" class = "buttons" value = "Add"></a>
					</td>
				</tr>
			</table>
					
					
				<table id="results" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
				<%int count = 1; %>
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Sr.No.</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Name</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
					</tr>
					<s:if test="treatmentEpisodeList.size!=0">
						<s:iterator value="treatmentEpisodeList" status="rowstatus">
						<tr>	
							<s:if test="#rowstatus.even == true">
								<tr class="ac_odd">
							</s:if>
									
									<td><%=count%></td>
									<td><s:property  value="treatmentEpisodeName" /></td>
									
									
									<s:url action="editTreatmentEpisode" id="edit">
    								<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
     								<td><s:a href="%{edit}"><img src="common/images/edit.jpg"></img></s:a></td>
    								<s:url action="deleteTreatmentEpisode" id="delete">
									<s:param name="selectedid" value="%{id}"></s:param>
									</s:url>
									<td><s:a href="%{delete}" onclick = "return confirmedDelete()"><img src="common/images/delete.gif"></img></s:a></td>	
							</tr>
						<%count++;%>
						</s:iterator>
						
					</s:if>
					
							
				</table>  			

				<s:else>
						There is no Treatment Episode found!!
				</s:else>
		</s:form>
	</div>
</div>