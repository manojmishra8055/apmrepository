<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="common/js/login.js"></script>


<div id="login_main" class="main_layout_content">
	
	<h2 class="title">Login to your APM account</h2><br><br>
	<div id="login" class="block_div">
		
		<span id="mandatory_message" class="error">Note:Fields marked with asterisk(*) are required.</span> 
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="Login" id="login_form" theme="simple">
			<div class="form_elements">				
				 <table width="100%" class = "boxclientthirdpartycharge" style="font-size: 12px">

					<col width="10%"/>
					<col width="2%"/>
					<col width="30%"/>
					<tr>
						<td>UserID<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:textfield id="userId" name="userId" title="Enter user id" />
						</td>
					</tr>
					<tr>
						<td>Password<span class="reqd-info">*</span></td>
						<td align="center">:</td>
						<td>
							<s:password id="password" name="password" title="Enter Password" />
						</td>
					</tr>
					<tr>
		 			<td>
		 				<table align="center">
		 					<tr>
		 						<td><s:submit cssClass="buttons" /></td>
		 						<td><s:reset cssClass="buttons"/></td>
		 					</tr>
		 				</table>
		 			</td>
		 		</tr>
				</table>
				
				
				
				
				
				
				
       			
       			
		
		</s:form>
		
		<!--<div id="login_other">
       		<h5><s:a href="inputForgotUserIdPassword">Forgot Password/User ID?</s:a></h5>
       		<h5>Not a member yet: <s:a href="inputRegistration">Join UnlockJobs.com</s:a></h5>
       	</div>
	--></div>
</div>