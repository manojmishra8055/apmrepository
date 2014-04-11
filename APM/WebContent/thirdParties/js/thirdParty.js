var name = "";

function showAddThirdPartyPopup(){

	var type  = document.getElementById('name').value;
	//alert(type);
	showPopWin("addDetailThirdParty?type="+type+"", 550, 600, null);
}

function showEditThirdPartyPopup(id,thirdPartyId,type,name,salutation,title,department,searchName,telephoneLine,email,emailCc,notes,companyDetails,companyName,address,town,country,postcode,compnyTelephone,fax,web,referenceNo,compnyEmail,warningMsg,accountsNotes,accountMustBeInCredit,accountCreditLimit,accountWarningLimit,defaultApmtBookingConfmTemp,defaultApmtDnaTemp,confContactEmail,dnaContactEmail){
//alert(id);
	showPopWin("editDetailThirdParty?id="+id+"&thirdPartyId="+thirdPartyId+"&type="+type+"&name="+name+"&salutation="+salutation+"&title="+title+"&department="+department+"&searchName="+searchName+"&telephoneLine="+telephoneLine+"&email="+email+"&emailCc="+emailCc+"&notes="+notes+"&companyDetails="+companyDetails+"&companyName="+companyName+"&address="+address+"&town="+town+"&country="+country+"&postcode="+postcode+"&compnyTelephone="+compnyTelephone+"&fax="+fax+"&web="+web+"&referenceNo="+referenceNo+"&compnyEmail="+compnyEmail+"&warningMsg="+warningMsg+"&accountsNotes="+accountsNotes+"&accountMustBeInCredit="+accountMustBeInCredit+"&accountCreditLimit="+accountCreditLimit+"&accountWarningLimit="+accountWarningLimit+"&defaultApmtBookingConfmTemp="+defaultApmtBookingConfmTemp+"&defaultApmtDnaTemp="+defaultApmtDnaTemp+"&confContactEmail="+confContactEmail+"&dnaContactEmail="+dnaContactEmail+"", 550, 600, null);

}
function showListRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			
			}
	}
}
function confirmedDelete(){

var r=confirm("Are you sure you want to delete this entry");
if (r==true)
  {
  return true;
  }
else
  {
  return false;
  }

}

$(document).ready(function(){
	
	var validator = $("#thirdParty_form").validate({
		onsubmit: true,
		rules : {
			
			name :{ 
		 		selected : true
		 		
		 	},
		 	
			
			
			
				
		},
		
		
		messages : {	
			
			name : {
				selected : error.name.selected
			},
			
			
		},
		
	});
	
	
});	



