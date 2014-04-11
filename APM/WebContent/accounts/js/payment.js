function setPayment(invoiceid){
	
	var payAmount = document.getElementById('payAmount').value;
	var howpaid = document.getElementById('howpaid').value;
	var invoiceDate = document.getElementById('invoiceDate').value;
	var url = "payAccounts?invoiceid="+invoiceid+"&payAmount="+payAmount+"&howpaid="+howpaid+"&invoiceDate="+invoiceDate+" ";	
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setPaymentRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function setPaymentRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
		
		}
	}

}

function setPayBy(invoiceid,payby){
	var url = "paybyAccounts?invoiceid="+invoiceid+"&payby="+payby+" ";	
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setPaymentRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}

function setPayByRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
		
		}
	}
}
