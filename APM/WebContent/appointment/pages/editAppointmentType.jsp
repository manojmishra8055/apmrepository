<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="appointment/js/appointment_type.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title" >Edit Appointment Type</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="login" class="block_div">
		
		
		<s:form action="updateAppointmentType" id="appointType_form" theme="simple">
			<div class="form_elements">				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
					<col width="10%"/>
					<col width="2%"/>
					<col width="30%"/>
					<tr>
					<s:hidden id = "id" name= "id"></s:hidden>
						<td>Name<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="name" name="name"/>
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
						<td>
							<s:textfield id="duration" name="duration" title="Enter Duration" />
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