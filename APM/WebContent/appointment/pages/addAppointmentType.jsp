<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="appointment/js/appointment_type.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title" >Add Appointment Type</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="login" class="block_div">
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="saveAppointmentType" id="appointType_form" theme="simple">
			<div class="form_elements">				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
					<col width="10%"/>
					<col width="2%"/>
					<col width="30%"/>
					<tr>
						<td>Name<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="name" name="name" title="Enter Name" />
						</td>
					</tr>
					<tr>
						<td>Description</td>
						<td align="center">:</td>
						<td>
							<s:textarea id="description" name="description" title="Enter description" />
						</td>
					</tr>
					
					<tr>
						<td>Category</td>
						<td align="center">:</td>
						<td>
							<s:textfield id="category" name="category" title="Enter Category" />
						</td>
					</tr>
					<tr>
						<td>Duration<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						
							
							<td><s:if test="%{#apmtDurationList != 'null'}">
												<s:select id="duration" name="duration" list="apmtDurationList"  headerKey="0" headerValue="00:00"	 theme="simple"  />
											</s:if>
											</td>
						
					</tr>
					
					<tr>
						<td>Color<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td><s:textfield id="color" name="color" cssClass="color" /></td>								
						
					</tr>
					
					<tr>
						<td>Charges<span class="reqd-info">*</span></td>
						<td align="center">:</td>
					<td><s:textfield id="charges" name="charges"/></td>
					</tr>
						
					
					<tr>
		 			<td>
		 				<table align="center">
		 					<tr>
		 						<td><s:submit cssClass="buttons"/></td>
		 						<td><s:reset cssClass="buttons"/></td>
		 						<td><input type="button" value=" Cancel " onclick="history.back(1);" class="buttons"></td>
		 						
		 					</tr>
		 				</table>
		 			</td>
		 		</tr>
				</table>
				
				
				
				
				
				
				
       			
       			
		
		</s:form>
		
		
	</div>
</div>