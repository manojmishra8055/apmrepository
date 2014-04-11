$(document).ready(function(){
    var activeTabIndex = -1;
    var tabNames = ["nameAddress","contacts","otherInfo","sourceOfPayment"];

    $(".tab-menu > li").click(function(e){
        for(var i=0;i<tabNames.length;i++) {
            if(e.target.id == tabNames[i]) {
                activeTabIndex = i;
            } else {
                $("#"+tabNames[i]).removeClass("active");
                $("#"+tabNames[i]+"-tab").css("display", "none");
            }
        }
        $("#"+tabNames[activeTabIndex]+"-tab").fadeIn();
        $("#"+tabNames[activeTabIndex]).addClass("active");
        return false;
    });
});


 

 function validEntry(){
	var br = document.createElement('br');
 	var firstname = document.getElementById('firstName').value;
 	var surname = document.getElementById('lastName').value;
 	var mobile = document.getElementById('mobNo').value;
 	var email = document.getElementById('email').value;
 	var gender = document.getElementById('gender').value;
 	var dob = document.getElementById('dob').value;
 	var address = document.getElementById('address').value;
 	var country = document.getElementById('country').value;
 	var town = document.getElementById('town').value;
 	var postCode = document.getElementById('postCode').value;
 	var reference = document.getElementById('reference').value;
 	var sourceOfIntro = document.getElementById('sourceOfIntro').value;
 	var occupation = document.getElementById('occupation').value;
 	var type = document.getElementById('type').value;
 	var typeName = document.getElementById('typeName').value;
 	var expiryDate = document.getElementById('expiryDate').value;
 	
 	document.getElementById('errorDiv').innerHTML="";
 	var chk=0;
   	if (firstname ==  "") {
      	var firstName = document.createElement("label");
        firstName.innerHTML = "First Name is required in Personal Detail Tab";
        document.getElementById('errorDiv').appendChild(firstName);
        document.getElementById('errorDiv').appendChild(br);
        chk=1;
     }   
     if (surname ==  "") {
        var lastName = document.createElement("label");
        lastName.innerHTML = "Last name is required in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(lastName);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	chk=1;
     }
     if (mobile ==  "") {
        var mobile = document.createElement("label");
        mobile.innerHTML = "Mobile no is required in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(mobile);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
    else if (isNaN(mobile)===true){
  	 var mobiledig = document.createElement("label");
     mobiledig.innerHTML = "Enter valid mobile no in Personal Detail Tab"; 
     document.getElementById('errorDiv').appendChild(mobiledig);
     document.getElementById('errorDiv').appendChild(document.createElement('br'));
  	chk=1;
	}
	var atpos=email.indexOf("@");
	var dotpos=email.lastIndexOf(".");
	 if (email ==  "") {
        var email = document.createElement("label");
        email.innerHTML = "Enter email in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(email);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
     
	 else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
  	 {	
  	 	
  	 	var email1 = document.createElement("label");
        email1.innerHTML = "Enter valid Email Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(email1);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
  	 
  	 }
  	 
     if (dob ==  "") {
        var dob = document.createElement("label");
        dob.innerHTML = "Select DOB in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(dob);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
     if (address ==  "") {
        var address = document.createElement("label");
        address.innerHTML = "Enter Address in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(address);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
      if (country ==  "0") {
        var country = document.createElement("label");
        country.innerHTML = "Select country in Personal Detail Tab"; 
        document.getElementById('errorDiv').appendChild(country);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
     if (reference ==  "") {
        var reference = document.createElement("label");
        reference.innerHTML = "Enter Refrence in Profile Tab"; 
        document.getElementById('errorDiv').appendChild(reference);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
     if (occupation ==  "0") {
        var occupation = document.createElement("label");
        occupation.innerHTML = "Select Occupation in Profile Tab"; 
        document.getElementById('errorDiv').appendChild(occupation);
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
    
function setTypeName(id){
//alert(id);

	var url = "setTypeNameDropDownClient?id="+id+" ";

if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setTypeNameRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}    
function setTypeNameRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
    		document.getElementById("typeName").innerHTML = req.responseText;
         
         }
	}
}


function showHide() 
{
            if(document.getElementById("whopay").selectedIndex == 1) 
            {
                document.getElementById("hidden_html").style.display = ""; // This line makes the DIV visible
            } 
            else {            
                document.getElementById("hidden_html").style.display = "none"; // This line hides the DIV
            }
 } 
 
 function showOtherRefernce(){
			var e = document.getElementById('reference');
			var reference = e.options[e.selectedIndex].text;
			//alert(reference);
 		 	if(reference == 'Other') 
            {
                document.getElementById("reference_other").style.display = ""; // This line makes the DIV visible
            } 
            else {            
                document.getElementById("reference_other").style.display = "none"; // This line hides the DIV
            }
 }
function showOtherOccupation(){
			var e = document.getElementById('occupation');
			var occupation = e.options[e.selectedIndex].text;
			//alert(occupation);
 		 	if(occupation == 'Other') 
            {
                document.getElementById("occupation_other").style.display = ""; // This line makes the DIV visible
            } 
            else {            
                document.getElementById("occupation_other").style.display = "none"; // This line hides the DIV
            }
}
function addOtherOccupation(otherOccupation){
//alert(otherOccupation);
var url = "addOtherOccupationClient?otherOccupation="+otherOccupation+" ";
if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = addOtherOccupationRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}    
function addOtherOccupationRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
    		
         
         }
	}
}

function addOtherReference(otherReference){
//alert(otherReference);
var url = "addOtherReferenceClient?otherReference="+otherReference+" ";
if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = addOtherReferenceRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}    
function addOtherReferenceRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
    		
         
         }
	}
}