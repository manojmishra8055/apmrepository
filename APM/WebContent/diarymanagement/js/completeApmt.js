var cookieUserName = "";
var cookieStarttime = "";
var cookieDuration = "";
var cookiePractitioner = "";
var cookieapmtType = "";
var cookiePractitionerId = "";
var cookieClientId = "";
var cookiecommencing = " ";
var cookieCharge= "";
var cookieSelectedAppointmentid = "";
var practitionerName = "";
var TreatmentEpiode = "";

	window.onload = function(){
		cookieUserName=read_cookie("cookieUserName");
		cookieStarttime=read_cookie("cookieStarttime");
		cookieDuration=read_cookie("cookieDuration");
		cookiePractitioner=read_cookie("cookiePractitioner");
		cookieapmtType=read_cookie("cookieapmtType");
		cookiePractitionerId=read_cookie("cookiePractitionerId");
		cookieClientId=read_cookie("cookieClientId"); 
		cookiecommencing=read_cookie("cookiecommencing");
		cookieCharge = read_cookie("cookieCharge");
		cookieSelectedAppointmentid = read_cookie("cookieSelectedAppointmentid");
		
		//alert(cookieClientId);
		document.getElementById('usernamediv').innerHTML = cookieUserName;
		
		var doller = "$";
		document.getElementById('durationdiv').innerHTML = ""+cookieStarttime+" - "+cookieDuration+" min Appointment with "+cookiePractitioner+" is Complete";
		document.getElementById('chargediv').innerHTML = "The charge has been created To "+cookieUserName+" "+cookieapmtType+" "+cookieCharge+" "+doller+"  ";
		document.getElementById('chargetodiv').innerHTML = cookieUserName;
		
		document.getElementById('clientId').value = cookieClientId;
		document.getElementById('practitionerName').value = cookiePractitioner;
		document.getElementById('practitionerId').value = cookiePractitionerId;
		
		
		getTreatmentEpisodeDetailsAjax();
		
}
	
function getTreatmentEpisodeDetailsAjax(){
	
	var tratmentepisodeid = read_cookie("cookieTreatmentEpisode");
	
	var url = "detailsTreatmentEpisode?tratmentepisodeid="+tratmentepisodeid+"";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = getTreatmentEpisodeDetailsAjaxRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}	


function getTreatmentEpisodeDetailsAjaxRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   TreatmentEpiode = req.responseText;
			   
			   var temp = TreatmentEpiode.split("/");
			   document.getElementById('authcode').value = temp[0];
			   document.getElementById('tmntesode').innerHTML = "Treatment 1 of  ("+temp[1]+")";
			   
			   document.cookie = "cookieConsultationLimit=" + temp[1];
			   var payby = temp[2];
			   document.cookie = "cookiePayBy=" + payby;
			  
			   if(payby == 'Client'){
			   		 document.getElementById('tmntesode').innerHTML = '';
			   		 document.getElementById('authcodetr').style.display = 'none';
			   		 document.getElementById('payBuy').value = 0;
			   }else{
			   		setThirdPartyNameAjax();
			   		 document.getElementById('payBuy').value = 1;
			   }
			
		}
	}
}	


function setThirdPartyNameAjax(){
	
	var clientid = read_cookie("cookieClientId");
	
	var url = "thirdpartyTreatmentEpisode?clientid="+clientid+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setThirdPartyNameAjaxRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function setThirdPartyNameAjaxRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById('chargetodiv').innerHTML = req.responseText;
			document.cookie = "cookieThirdPartyName=" + req.responseText;
		}
	}

}	
	

function setAppointmentTypeCharge(apmtTypeId)
{
	//alert(apmtTypeId);

	var url = "getApmtChargeCompleteApmt?apmtTypeId="+apmtTypeId+"";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setAppointmentTypeChargeRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}
var tempDuration = 0;
function setAppointmentTypeChargeRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   document.getElementById("chargeajax").innerHTML = req.responseText;
				
			
			
			
		}
	}
}


function setChargeAmount(){

var flag = 0;
//var payBuy = $("input[name='payBuy']:checked").val();
var payBuy = document.getElementById('payBuy').value;

var markAppointment = 1;

var charge = parseInt(document.getElementById('charge').value);

var temp = document.getElementById('totalcharge').value;

var apmtTypeId = document.getElementById('apmtType').value;

  if(apmtTypeId == 0){
	apmtTypeId = cookieapmtType;
	charge = cookieCharge;
	
}

var total = parseInt(charge) + parseInt(temp);
document.getElementById('totalcharge').value = parseInt(total) ;

var url = "saveChargeCompleteApmt?apmtTypeId="+apmtTypeId+"&cookieUserName="+cookieUserName+"&charge= "+charge+"&cookieDuration="+cookieDuration+"&cookieStarttime="+cookieStarttime+"&cookiePractitionerId="+cookiePractitionerId+"&cookieClientId="+cookieClientId+"&cookiePractitioner="+cookiePractitioner+"&cookiecommencing="+cookiecommencing+"&payBuy="+payBuy+"&markAppointment="+markAppointment+"&cookieSelectedAppointmentid="+cookieSelectedAppointmentid+" ";


if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setChargeAmountRequest;
    req.open("GET", url, true); 
              
    req.send(null);


}

function setChargeAmountRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   document.getElementById("chargeTotalajax").innerHTML = req.responseText;
				setCashDesk();		
			
			
			
		}
	}
}

function setCashDesk(){
var selectedUser = document.getElementById('clientId').value;
	//alert(selectedUser);
	//alert(cookiecommencing);

var url = "cashDeskCompleteApmt?selectedUser="+selectedUser+"&date="+cookiecommencing+"" ;


if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setCashDeskRequest;
    req.open("GET", url, true); 
              
    req.send(null);


}

function setCashDeskRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   document.getElementById("cashDesk").innerHTML = req.responseText;
					document.getElementById('chargeTotal').value = document.getElementById('hiddenTotal').value;	
			
			
			
		}
	}
}



function OpenCashdeskpopUP(){
	var selectedUser = document.getElementById('clientId').value;
	showPopWin("cashDeskCompleteApmt?selectedUser="+selectedUser+"&date="+cookiecommencing+"", 400, 400, null);
}



function saveApmtCompletedRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   

			
			
			
		}
	}
}

//unnati 25 th march
function resetAppointmentField(){
	var duration = document.getElementById('duration').value;
			
			total = "00:00:00";
	//globalEndTime = etime;
	
	var stime = document.getElementById('sTime').value;
	
	var total = getTimeTotal(duration,stime);
	//alert(total)
	document.getElementById('endTime').value = total;
	
}

function setApmtChargeAndDuration(apmtTypeId)
{
	//alert(apmtTypeId);
	
	var url = "getApChargeAndDurationCompleteApmt?apmtTypeId="+apmtTypeId+"";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setApmtChargeAndDurationRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}
var tempDuration = 0;
function setApmtChargeAndDurationRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   document.getElementById("chargeajax").innerHTML = req.responseText;
				
			var duration = document.getElementById('duration').value;
			
			total = "00:00:00";
	//globalEndTime = etime;
	
	var stime = document.getElementById('sTime').value;
	
	var total = getTimeTotal(duration,stime);
	//alert(total)
	document.getElementById('endTime').value = total;
	var charge = document.getElementById('charge').value;
	var totalcharge = document.getElementById('chargeTotal').value;
	
	document.getElementById('chargeTotal').value = parseInt(charge)+parseInt(totalcharge);
	
	
			
			
		}
	}
}

function setInvoiceeAsClient(){
var client = document.getElementById('client').value;
if(client =="")
{
	alert("Please select Client by Clicking on Search Button");
}
var client = document.getElementById('client').value;
document.getElementById('invoicee').value = client;
}
function setInvoiceeAsThirdParty(){
var client = document.getElementById('client').value;
if(client =="")
{
	alert("Please select Client by Clicking on Search Button");
}
var clientId = document.getElementById('clientId').value;
var url = "getThirdPartyCompleteApmt?clientId="+clientId+"";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setInvoiceeAsThirdPartyRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function setInvoiceeAsThirdPartyRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			   document.getElementById("thirdPartyAjax").innerHTML = req.responseText;
				
			
			
			
		}
	}
}



function getTimeTotal(time1,time2)
{
var time1_hr = "";
var time1_min = "";
var time2_hr = "";
var time2_min = "";
var total_hrtime = "";
var total_mintime = "";
var generated_Hour = 0;
    time1_hr = time1.split(":")[0];
    time1_min = time1.split(":")[1];
    time2_hr = time2.split(":")[0];
    time2_min = time2.split(":")[1];

    total_hrtime = 1* time1_hr + 1*time2_hr;

    //alert(total_hrtime);
    total_mintime = 1* time1_min + 1*time2_min;
    //alert(total_mintime);

    if(total_mintime>=60)
    {
        total_mintime = total_mintime - 60;
        total_hrtime = total_hrtime + 1;
    }

    if(total_hrtime>=24)
    {
        total_hrtime = total_hrtime -24 ;
                if(total_hrtime<10)
    total_hrtime = "0"+total_hrtime;

    }
    
    if(total_hrtime <=9){
    	total_hrtime = "0" + total_hrtime;
    }
    if(total_mintime <= 5){
    	total_mintime = "0" + total_mintime;
    }
    

	return total_hrtime+":"+total_mintime;

//alert(total_hrtime+":"+total_mintime);  
}
function setPractioner(){
	var e = document.getElementById('diaryUser');
	practitionerName = e.options[e.selectedIndex].text;
	document.getElementById('practitionerName').value = practitionerName;
	document.getElementById('practitionerId').value = document.getElementById('diaryUser').value;

}
function saveClientCharge(){
	var payBuy = $("input[name='payBuy']:checked").val();
 	var markAppointment = 0;
	var charge = parseInt(document.getElementById('charge').value);
	var apmtTypeId = document.getElementById('apmtType').value;
	var client = document.getElementById('client').value;
	var clientId = document.getElementById('clientId').value;
	var duration = document.getElementById('duration').value;
	var startTime = document.getElementById('sTime').value;
	var endTime = document.getElementById('endTime').value;
	var practionerId = document.getElementById('diaryUser').value;
	var date = document.getElementById('commencing').value;
	cookieSelectedAppointmentid = 0;
	var url = "saveChargeCompleteApmt?apmtTypeId="+apmtTypeId+"&cookieUserName="+client+"&charge= "+charge+"&cookieDuration="+duration+"&cookieStarttime="+startTime+"&cookiePractitionerId="+practionerId+"&cookieClientId="+clientId+"&cookiePractitioner="+practitionerName+"&cookiecommencing="+date+"&payBuy="+payBuy+"&markAppointment="+markAppointment+"&cookieSelectedAppointmentid="+cookieSelectedAppointmentid+" ";

if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setChargeAmountRequest;
    req.open("GET", url, true); 
              
    req.send(null);


}
function setDNACharge()
{
//alert(cookieCharge);
//alert(cookiePractitioner);
//alert(cookiePractitionerId);
document.getElementById('practitionerName').value = cookiePractitioner;
document.getElementById('practitionerId').value = cookiePractitionerId;

}

function confirmedDelete(id){
	//alert(id);

  	var url = "deleteCashDeskCompleteApmt?selectedid="+id+"";
  
 
if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = confirmedDeleteRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function confirmedDeleteRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			  // document.getElementById("thirdPartyAjax").innerHTML = req.responseText;
				setCashDesk();
			
			
			
		}
	}
}

