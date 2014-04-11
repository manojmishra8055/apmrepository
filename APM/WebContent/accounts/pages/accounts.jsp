<%@taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="accounts/js/accounts.js"></script>

<div id="login_main" class="main_layout_content">
<h2 class="title" style="margin-right: 8px; margin-left: -17px">Accounts</h2>
	<div id="login" class="block_div">
		<span class="error"><s:actionerror id="server_side_error"/></span>
		<s:form action="Accounts" id="category_form" theme="simple"> 
			<div class="form_elements">	
				<div class="dairyuser">Select Accounts
				<!--<s:radio name="payby" id="payby" list="{'Client','Third Party'}" value="'Client'"/>  -->
					<s:select name="payby" list="#{'Client':'Client','Third Party':'Third Party','0':'All'}"></s:select>
					&nbsp;&nbsp;&nbsp;&nbsp;
					Client<s:textfield name="client" id="client" size="25" readonly="true"/>
					<s:hidden name="clientId" id = "clientId" ></s:hidden>  
					<a href="Client" target="blank" onclick="window.open(this.href, 'mywin',
					'left=20,top=20,width=1000px,height=600px,toolbar=1,resizable=0'); return false;"><input type="button" value=" Search " class="buttons"></a>
					
					<input type="submit" value="History Included" class="buttons">
					<div><hr/></div>
				<div>
					<s:textarea name="insuranceCompany" id="insuranceCompany" rows="4" cols="40"></s:textarea>
				</div>
				</div>
				
				
				<table cellpadding="0" cellspacing="0" class="my-table" style="width: 80%;margin-left: 29px">
					<col width="15%">
					<col width="8%">
					<col width="8%">
					<col width="40%">
					<col width="8%">
					<col width="8%">
					<col width="8%">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">date</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;"></th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Ref</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0; text-align: center;">Description</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Debit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Credit</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Payment</th>
					</tr>
					
					<s:iterator value="accountList">
						<s:if test="debitAmount>0">
							<tr style="color: blue;">
								<td><s:property value="commencing"/></td>
								<td>Payment</td>
								<td>ref</td>
								<td><s:property value="ClientName"/> | <s:property value="appointmentType"/></td>
								<td><s:property value="debitAmount"/></td>
								<td><s:property value="payAmount"/></td>
								<s:url action="paymentAccounts" id="paymentAccounts">
									<s:param name="payby" value="%{payby}"/>
									<s:param name="client" value="%{client}"/>
									<s:param name="numberOfChages" value="%{numberOfChages}"/>
									<s:param name="creditCharge" value="%{creditCharge}"/>
									<s:param name="invoiceid" value="%{invoiceid}"/>
									<s:param name="invoiceid" value="%{invoiceid}"/>
									<s:param name="practitionerName" value="%{practitionerName}"/>
									<s:param name="clientid" value="%{clientid}"/>
								</s:url>
								<s:if test="debitAmount>0">
									<td><s:a href="%{paymentAccounts}">Update</s:a></td>
								</s:if>
								<s:else>
									<td>Paid</td>
								</s:else>
								
							</tr>
						</s:if>
						<s:else>
							<tr style="color: orange;">
								<td><s:property value="commencing"/></td>
								<td>Payment</td>
								<td>ref</td>
								<td><s:property value="ClientName"/> | <s:property value="appointmentType"/></td>
								<td><s:property value="debitAmount"/></td>
								<td><s:property value="payAmount"/></td>
								<s:url action="paymentAccounts" id="paymentAccounts">
									<s:param name="payby" value="%{payby}"/>
									<s:param name="client" value="%{client}"/>
									<s:param name="numberOfChages" value="%{numberOfChages}"/>
									<s:param name="creditCharge" value="%{creditCharge}"/>
									<s:param name="invoiceid" value="%{invoiceid}"/>
									<s:param name="invoiceid" value="%{invoiceid}"/>
									<s:param name="practitionerName" value="%{practitionerName}"/>
									<s:param name="clientid" value="%{clientid}"/>
								</s:url>
								<s:if test="debitAmount>0">
									<td><s:a href="%{paymentAccounts}">Update</s:a></td>
								</s:if>
								<s:else>
									<td>Paid</td>
								</s:else>
							</tr>
						</s:else>
					</s:iterator>
				</table>
				
			</div>
			
			</s:form>
	
	</div>
</div>