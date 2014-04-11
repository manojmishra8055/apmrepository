<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="thirdParties/js/thirdpartyType.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="heading" >Third Party Type</h2>
	<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
	<div id="login" class="block_div">
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="saveTypeThirdParty" id="thirdPartyType_form" theme="simple">
			<div class="form_elements">				
			    <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">
					<col width="10%"/>
					<col width="2%"/>
					<col width="30%"/>
					
					<tr>
						<td>Name<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="type" name="type" title="Enter Type" />
						</td>
					</tr>
					
					<tr>
						<td>Description</td>
						<td align="center">:</td>
						<td>
							<s:textarea id="description" name="description" title="Enter description " />
						</td>
					</tr>
					<tr>
		 			<td>
		 				<table align="center">
		 					<tr>
		 						<td><s:submit cssClass="buttons"/></td>
		 						<td><s:reset cssClass="buttons"/></td>
		 					</tr>
		 				</table>
		 			</td>
		 		</tr>
				</table>
				
				
				
				
				
				
				
       			
       			
		
		</s:form>
		
		
	</div>
</div>