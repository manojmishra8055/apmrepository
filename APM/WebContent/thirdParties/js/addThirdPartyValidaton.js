$(document).ready(function(){
	
	var validator = $("#thirdPartyDetails_frm").validate({
		onsubmit: true,
		rules : {
			
			telephoneLine :{ 
		 		integer : true
		 		
		 	},
		 	email : {
		 		email : true
		 	},
			emailCc : {
				email : true
			},
			compnyTelephone : {
				integer : true
			},
			compnyEmail : {
		 		email : true
		 	},
		 	confContactEmail : {
		 		email : true
		 	},
		 	dnaContactEmail : {
		 		email : true
		 	},
		 	accountCreditLimit : {
		 		integer : true
		 	},
		 	accountWarningLimit : {
		 		integer : true
		 	}
		 	
			
				
		},
		
		
		messages : {	
			
			telephoneLine : {
				integer : error.telephoneLine.integer
			},
			email : {
				email : error.email.email
			
			},
			emailCc : {
				email : error.emailCc.email
			
			},
			compnyTelephone : {
				integer : error.compnyTelephone.integer
			},
			compnyEmail : {
				email : error.compnyEmail.email
			
			},
			confContactEmail : {
				email : error.confContactEmail.email
			
			},
			dnaContactEmail : {
				email : error.dnaContactEmail.email
			
			},
			accountCreditLimit : {
				integer : error.accountCreditLimit.integer
			},
			
			accountWarningLimit : {
				integer : error.accountWarningLimit.integer
			},
			
		},
		
	});
	
	
});	




function validEntry(){
var name = document.getElementById('name').value;
var telephoneLine = document.getElementById('telephoneLine').value;
var email = document.getElementById('email').value;
var companyName = document.getElementById('companyName').value;
var address = document.getElementById('address').value;
var town = document.getElementById('town').value;
var country = document.getElementById('country').value;
var postcode = document.getElementById('postcode').value;
var compnyTelephone = document.getElementById('compnyTelephone').value;
var compnyEmail = document.getElementById('compnyEmail').value;
var confContactEmail = document.getElementById('confContactEmail').value;
var dnaContactEmail = document.getElementById('dnaContactEmail').value;
document.getElementById('errorDiv').innerHTML="";
var chk=0;
 	if (name ==  "") {
      	var name = document.createElement("label");
        name.innerHTML = "Enter Name in Personal Details Tab";
        document.getElementById('errorDiv').appendChild(name);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }   
     if (telephoneLine ==  "") {
      	var telephoneLine = document.createElement("label");
        telephoneLine.innerHTML = "Enter Telephone Line in Personal Details Tab";
        document.getElementById('errorDiv').appendChild(telephoneLine);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }  
      if (email ==  "") {
      	var email = document.createElement("label");
        email.innerHTML = "Enter Email in Personal Details Tab";
        document.getElementById('errorDiv').appendChild(email);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }
     if (companyName ==  "") {
      	var companyName = document.createElement("label");
        companyName.innerHTML = "Enter Company Name in Company Details Tab";
        document.getElementById('errorDiv').appendChild(companyName);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }   
	if (address ==  "") {
      	var address = document.createElement("label");
        address.innerHTML = "Enter Address in Company Details Tab";
        document.getElementById('errorDiv').appendChild(address);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }  
     if (town ==  "") {
      	var town = document.createElement("label");
        town.innerHTML = "Enter Town in Company Details Tab";
        document.getElementById('errorDiv').appendChild(town);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }  
     if (country ==  "") {
      	var country = document.createElement("label");
        country.innerHTML = "Enter Country in Company Details Tab";
        document.getElementById('errorDiv').appendChild(country);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }        
     if (postcode ==  "") {
      	var postcode = document.createElement("label");
        postcode.innerHTML = "Enter Post Code in Company Details Tab";
        document.getElementById('errorDiv').appendChild(postcode);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     } 
      if (compnyTelephone ==  "") {
      	var compnyTelephone = document.createElement("label");
        compnyTelephone.innerHTML = "Enter Telephone no in Company Details Tab";
        document.getElementById('errorDiv').appendChild(compnyTelephone);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }   
      if (compnyEmail ==  "") {
      	var compnyEmail = document.createElement("label");
        compnyEmail.innerHTML = "Enter Email in Company Details Tab";
        document.getElementById('errorDiv').appendChild(compnyEmail);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     } 
       if (confContactEmail ==  "") {
      	var confContactEmail = document.createElement("label");
        confContactEmail.innerHTML = "Enter Email in Contact Preference Tab";
        document.getElementById('errorDiv').appendChild(confContactEmail);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }   
     if (dnaContactEmail ==  "") {
      	var dnaContactEmail = document.createElement("label");
        dnaContactEmail.innerHTML = "Enter  DNA Email in Contact Preference Tab";
        document.getElementById('errorDiv').appendChild(dnaContactEmail);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }     
     
     if(chk==1)
     {
        return false;
     }
     else
     {
        return true;
     }

}