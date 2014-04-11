<%@taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>

<div id="login_main" class="main_layout_content">
	<h2 class="title" style="margin-right: 20px;margin-left: 45px">All Patients</h2>
	
	<div id="login" class="block_div">
		
		<div id="closediv" class="close" style="display: none;"></div>
		<div class="diaryuser" style="margin-top: 6px">
					<input type="button" class = "buttons" value = "Add New" style="margin-top: 2px" onclick="addPatient()">
					
					</div>
				<s:form action="searchParticularClient" theme="simple">
				<div align="center"><s:textfield theme="simple" name="searchText" placeholder="Search by Name" size="30" />
					<input type="submit" value="Go"/>
				</div>
			</s:form>
					<div class="form_elements">	
						<input type="hidden" id = "client" name ="client" > 
					<input type="hidden" id = "clientId" name ="clientId" >
				<table id="allPatient" cellpadding="0" cellspacing="0" class="my-table"  style="width:100%;">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Title</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Name</th>
						
				
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Edit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Delete</th>
					</tr>
					
					
							
				</table>
			
			
				
				
				
				
				
				
       			
       			

		
		
	
			
			
				
				
				
				
				
				
       			
       			

		
		
	</div>
</div>