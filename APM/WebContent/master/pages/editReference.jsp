<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="jscolor/jscolor.js"></script>
<script type="text/javascript" src="appointment/js/appointment_type.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title" >Edir Source of Reference</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="login" class="block_div">
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="updateReferenceMaster" id="addOccupation_form" theme="simple">
			<div class="form_elements">				
			    <table width="40%" class = "boxclientthirdpartycharge" style="font-size: 12px">
					<col width="5%"/>
					<col width="2%"/>
					<col width="30%"/>
					<tr>
						<td>Source of Reference<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="reference" name="reference" title="Enter Reference" />
							<s:hidden id="id" name="id" />
						</td>
					</tr>
					</table>
					
					
		 			<table width="40%" class = "boxclientthirdpartycharge" style="font-size: 12px">
		 				 <col width="2%"/>
						 <col width="2%"/>
						 <col width="30%"/>
		 					<tr>
		 						<td><s:submit cssClass="buttons"/></td>
		 						<td><s:reset cssClass="buttons"/></td>
		 						<td><input type="button" value=" Cancel " onclick="history.back(1);" class="buttons"></td>
		 						
		 					</tr>
		 				</table>
		 			
			 
			</div>			
		</s:form>
		
		
	</div>
</div>