<%@taglib uri="/struts-tags" prefix="s" %>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import="java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>


<script type="text/javascript" src="accounts/js/payment.js"></script>

<script type="text/javascript">
	function setInvoice(){
	
		if(document.getElementById('issued').checked==true){
			document.getElementById('invoiceDate').disabled = true
			document.getElementById('address').disabled = true
		}else{
			document.getElementById('invoiceDate').disabled = '';
			document.getElementById('address').disabled = '';
		}
	}
	
	
</script>

<div id="login_main" class="main_layout_content">
	<div id="login" class="block_div" style="font-size: 12px;">
	<div style="width: 200px; font-weight: bold; font-size: 18px;">Update Invoice</div><br>
	<s:form action="previewAccounts" theme="simple">
		<s:hidden name="payby" id="payby"/>
		<s:hidden name="invoiceid" id="invoiceid"/>
		<div>Client&nbsp;<s:textfield  name="client" id="client" readonly="true"/> 
			&nbsp;&nbsp;&nbsp;
			Total $&nbsp;<s:textfield  name="creditCharge" id="creditCharge" size="10" readonly="true"/>
			&nbsp;&nbsp;&nbsp;
			<s:textfield name="invoiceDate" id="invoiceDate" cssClass="date-pick dp-applied"/>
		</div>
		<div><hr></div>
		<br>
		<div style="font-weight: bold;">Select the Account to Record the Payment For...</div><br>
		<div>
			Client &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
			<input type="radio" name="payby" id="payby" checked="checked" value="0" onclick="setPayBy('<s:property value="invoiceid"/>',this.value)">
			<s:textfield  name="client" id="client" readonly="true" size="50"/>
		</div>
		<div>
			Third Party<input type="radio" name="payby" id="payby" value="1" onclick="setPayBy('<s:property value="invoiceid"/>',this.value)">
			<s:textfield  name="insuranceCompany" id="insuranceCompany" readonly="true" size="50"/> 
		</div>
		<div><hr></div>
		<br>
		<div>
			<div style="font-size: 14px; font-weight: bold;">Invoice issued? Yes:
				<input type="checkbox" name="issued" id="issued" />
			</div>
			
			&nbsp;&nbsp;&nbsp;
			<div>You cannot make changes to issued invoices</div>
		</div>
		<div><hr></div>
		<br>
		<div>
			<div style="font-size: 16px; font-weight: bold;">Has this invoice been paid?
				<input type="checkbox" name="paid" id="paid"  onclick="setPayment('<s:property value="invoiceid"/>')"/>
				&nbsp;&nbsp;&nbsp;
				<font style="font-size: 12px; font-weight: normal;" >Payment Mode </font>
				<select name="howpaid" id="howpaid">
					<option value="0">Select</option>
					<option value="BACS">BACS</option>
					<option value="Cheque">"Cheque"</option>
					<option value="C/Card">C/Card</option>
					<option value="Cash">Cash</option>
					<option value="D/Card">D/Card</option>
					<option value="D/D">D/D</option>
					<option value="Other">Other</option>
					<option value="S/O">S/O</option>
				</select>
				
				&nbsp;&nbsp;&nbsp;
				<font style="font-size: 12px; font-weight: normal;" >Payment Amount $</font> <s:textfield name="payAmount" id="payAmount"  value="%{creditCharge}" size="10"/>
			</div>
			
		
		</div>
		<div><hr></div>
		<br>
		<div><b>Preview or pirnt your invoices</b><input type="submit" value="Print/Preview"></div>
	</s:form>
	
	<!--<div><a href="paynowCompleteApmt">Modify Invoice</a>	</div>
	--></div>
</div>	