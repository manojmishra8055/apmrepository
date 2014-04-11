<%@taglib uri="/struts-tags" prefix="s" %>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import="java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>

<script type="text/javascript" src="diarymanagement/js/paynow.js"></script>

	<h2 class="title" style="margin-left: 46px">Raise Invoice for <s:property value="client"/></h2><br><br>

<div id="login_main" class="main_layout_content">
	<div id="login" class="block_div">
	
	
		
			<%String currentDate = DateTimeUtils.getDateinSimpleFormate(new Date());
				String temp[] = currentDate.split(" ");
				
				
			%>							       
		<s:form action="invoiceAccounts" theme="simple">
			<s:hidden name="client" id="client"/>
			<s:hidden name="clientId" id="clientId"/>
			<s:hidden name="payby" id="payby"/>
			<s:hidden name="creditCharge" id="creditCharge"/>
			<s:hidden name="totalassesment" id="totalassesment"/>
			<s:hidden name="practitionerId" id="practitionerId"/>
			<s:hidden name="practitionerName" id="practitionerName"/>
			<s:hidden name="invoiceid" id="invoiceid"/>
			
									        
			<div class="menu" style="margin-top: -27px"><input id="invoiceDate" class="date-pick dp-applied" type="text" value="<%=temp[0] %>" name="invoiceDate"></input></div>
			<br>
			<div style="font-weight: bold; font-size: 12px;">Invoice can be raise as below</div>
			<br>
			<table width="100%" cellpadding="0" cellspacing="0" class="my-table">
				<tr>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Invoice No.</th>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">To</th>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Invoicee</th>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">No. of Charges</th>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Total</th>
					<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Location</th>
					
				</tr>
				<tr>
					<td><s:property value="invoiceid"/></td>
					<s:if test="payby == 0">
						<td>Client</td>
						<td><s:property value="client"/></td>
					</s:if>
					<s:else>
						<td>Third Party</td>
						<td><s:property value="insuranceCompany"/></td>
					</s:else>
					
					
					<td><s:property value="numberOfChages"/></td>
					<td>$<s:property value="creditCharge"/></td>
					<td></td>
				</tr>
				
			</table>
			<br>
			<div style="font-weight: bold; font-size: 12px;">Following Charges can be included in selected invoices</div>
			<hr/>
				<br>
					<table width="100%" id="assementtable" cellpadding="0" cellspacing="0" class="my-table">
					<tr>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Select</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Date</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Client</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Description</th>
						<th style="background:transparent url('common/images/table_header.gif') no-repeat scroll 0 0;">Total</th>
					</tr>
					<s:iterator value="assesmentList">
						<tr>
							<td><input type="checkbox" name="chid" id="<s:property value="id"/>" value="<s:property value="id"/>" checked="checked"></td>
							<td><s:property value="commencing"/></td>
							<td><s:property value="clientName"/></td>
							<td><s:property value="appointmentType"/></td>
							<td>$<s:property value="charges"/></td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="4"><b>Total</b></td>
						<td>$<s:property value="creditCharge"/></td>
					</tr>
					
				</table>
			
			<br>
				<div style="font-size: 12px;">Other details for this charge(Hard code need to work) </div>
				<div style="font-size: 12px;">Practitioner</div>
				<div><input type="text" name="practName" id="practName" value="<s:property value="practitionerName"/>" readonly="readonly"></div>
				<table class="my-table" style="font-size: 12px;" width="25%">
					<tr>
						<th>Charge Type</th>
						<th>Treatment</th>
					</tr>
					<tr>
						<td>Net</td>
						<td>$20</td>
					</tr>
					<tr>
						<td>Vat</td>
						<td>$0</td>
					</tr>
					<tr>
						<td>TOTAL</td>
						<td>$20</td>
					</tr>
				</table>
				
				<div><input type="submit" value=" Create Invoice "></div>
			</s:form>
			
			
	</div>
</div>