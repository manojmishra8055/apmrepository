<%@taglib uri="/struts-tags" prefix="s" %>

<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import="java.util.Date"%>

<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>

<script type="text/javascript" src="diarymanagement/js/completePayment.js"></script>

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
	<div class="mddiv">Invoice Created</div><br> 
	<s:form action="previewCompleteApmt" theme="simple">
		<s:hidden name="invoiceid" id="invoiceid"/>
		<s:hidden name="payBuy" id="payBuy"/>
		<div>Invoicee <s:textfield  name="user" id="user" readonly="true"/> 
			&nbsp;&nbsp;&nbsp;
			Total $<s:textfield  name="chargeTotal" id="chargeTotal" size="10" readonly="true"/>
		</div>
		<div><hr></div>
		<br>
		<div><textarea cols="40" rows="5" name="address" id="address"><s:property value="user"/></textarea>
			&nbsp;&nbsp;&nbsp;
			<s:textfield name="invoiceDate" id="invoiceDate" cssClass="date-pick dp-applied"/>
		</div>
		<div><hr></div>
		<br>
		<div>
			<div style="font-size: 14px; font-weight: bold;">Is this invoice issued?
				<input type="checkbox" name="issued" id="issued"  onclick="setInvoice()"/>
			</div>
			
			&nbsp;&nbsp;&nbsp;
			<div>You cannot make changes to issued invoices</div>
		</div>
		<div><hr></div>
		<br>
		<div>
			<div style="font-size: 16px; font-weight: bold;">Has this invoice been paid?
				<input type="checkbox" name="paid" id="paid"  onclick="updatePayment('<s:property value="invoiceid"/>')"/>
				&nbsp;&nbsp;&nbsp;
				<font style="font-size: 12px; font-weight: normal;" >Payment Mode</font>
				<select name="howpaid" id="howpaid">
					<option value="Cash">Cash</option>
					<option value="BACS">BACS</option>
					<option value="Cheque">"Cheque"</option>
					<option value="C/Card">C/Card</option>
					<option value="D/Card">D/Card</option>
					<option value="D/D">D/D</option>
					<option value="Other">Other</option>
					<option value="S/O">S/O</option>
				</select>
				
				&nbsp;&nbsp;&nbsp;
			<font style="font-size: 12px; font-weight: normal;" >Payment Amount $</font> <s:textfield name="paidAmount" id="payAmount"  value="%{chargeTotal}" size="10"/>
			</div><!--
			
			&nbsp;&nbsp;&nbsp;
			<div>You cannot make changes to issued invoices</div>
		--></div>
		<div><hr></div>
		<br>
		<div><b>Preview or pirnt your invoices</b><input type="submit" value="Print/Preview"></div>
	</s:form>
	
	<!--<div><a href="paynowCompleteApmt">Modify Invoice</a>	</div>
	--></div>
</div>	