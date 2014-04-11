
$(document).ready(function(){
	var clientname = read_cookie("cookieUserName");
	
	var cookiecommencing=read_cookie("cookiecommencing");
	var tempdate = cookiecommencing.split('-');
	cookiecommencing = tempdate[2]+'/'+tempdate[1]+'/'+tempdate[0];
	var practitionerid = read_cookie("cookiePractitionerId");
	var clientid = read_cookie("cookieClientId");
	
	
	document.getElementById('namediv').innerHTML = clientname + ','
	document.getElementById('treatmentStartDate').value = cookiecommencing;
	document.getElementById('diaryUser').value = practitionerid;
	document.getElementById('invoicee').value = clientname;
	document.getElementById('clientId').value = clientid;
	
});		
	
	
function closeTreatment(){

	document.getElementById('treatmentEpisodeFrm').submit();
	window.close();
	return false;
}




function setPayBy(payby){
	if(payby == 'Third Party'){
		document.getElementById('thirdPartyName').style.display = '';
		document.getElementById('authorisationCode').disabled = '';
		document.getElementById('spendLimit').disabled = '';
		document.getElementById('consultationLimit').disabled = '';
		setThirdPartyNameAjax();
	}else{
		document.getElementById('thirdPartyName').style.display = 'none';
		document.getElementById('authorisationCode').disabled = true;
		document.getElementById('spendLimit').disabled = true;
		document.getElementById('consultationLimit').disabled = true;
		
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
			document.getElementById('thirdPartyName').value = req.responseText;
		}
	}

}