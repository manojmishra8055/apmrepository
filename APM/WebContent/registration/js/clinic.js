
// refresh captcha by clicking refresh button
	/*$("#captcha_refresh").click(function() {
	
		var date = new Date();
		// get new image captcha, and set it as a source of captcha image
		// date.getTime() is added to make request different from previous requests
		// since requests are cached by browser, so captcha does not change if random 
		// parameters not added to request, in our case random parameter is time in milliseconds
		$("#captcha_image").attr("src","/tiles/images/jcaptcha.jpg?"+ date.getTime());
	});*/
	
function include(file)
{

  var script  = document.createElement('script');
  script.src  = file;
  script.type = 'text/javascript';
  script.defer = true;

  document.getElementsByTagName('head').item(0).appendChild(script);

}

/* include any js files here */
include("jscolor/jscolor.js");

	
	
	
	$(document).ready(function(){
	
	var validator = $("#registerfrm").validate({
		onsubmit: true,
		rules : {
			userId : {
				required : true,
				//minlength : constraint.userId.minlength,
				nowhitespace : true,
				remote: 'CheckUserId'
			},	
			password : {
				required : true,
				minlength : constraint.password.minlength
			},
			confirmPassword : {
				required : true,
				equalTo : "#password"	// compare with password
			},
			
			pkgsubscription: {
              required: true
              //minlength: 1
          	},
          	funSubscription : {
          		required : true
          	},
          	
          	clinicName : {
          		required : true,
          		regex :/^[a-zA-Z ]+$/
          	},
          	
          	clinicOwner : {
          		required : true,
          		regex :/^[a-zA-Z ]+$/
          	},
          	
          	name : {
				required : true,
				regex :/^[a-zA-Z ]+$/
			},
			pinCode : {
				integer : true,
				required : true
			},
			email : {
				required : true,
				email : true,
				//remote: '/UnlockJobs/user/CheckEmailId' // Action will be invoked to check if user with this email id already exist (Ajax call)
			},
			country : {
					required : true,
			},
			city : {
				required : true
			},
			address : {
				required : true
			},
			
			mobileNo : {
				required : true,
				mobilenumber : true
			},
			
			captchaCode : {
				required : true
			},
			
			colorName : {
				required : true
			},
			
				
		},
		
		
		messages : {	
			userId : {
				required : error.userId.required,
				minlength : jQuery.format(error.userId.minLength),	// format function replaces {0} with actual minimum length
				nowhitespace : error.userId.nowhitespace,
				remote: error.userId.alreadyExist
			},	
			password : {
				required : error.password.required,
				minlength : jQuery.format(error.password.minlength)
			},
			confirmPassword : {
				required : error.confirmPassword.required,
				minlength : jQuery.format(error.confirmPassword.minlength),	// format function replaces {0} with actual minimum length
				equalTo : error.confirmPassword.equalTo
			},
			
			pkgsubscription: {
				required : error.pkgsubscription.required
			},
			
			funSubscription : {
				required : error.funSubscription.required
			},
			
			clinicName : {
				required : error.clinicName.required,
				regex : error.clinicName.alphabets
			},
				
			clinicOwner : {
				required : error.clinicOwner.required,
				regex : error.clinicOwner.alphabets
			},
			
			name : {
				required : error.name.required,
				regex : error.name.alphabets
			},
			pinCode : {
				integer : error.pinCode.integer,
				required : error.pinCode.required
			},
			email : {
				required : error.email.required,
				email : error.email.email,
				remote: error.email.alreadyExist
			},
			country : {
					required : error.country.required
			},
			city : {
				required : error.city.required
			},
			
			address : {
				required : error.address.required
			},
			
			mobileNo : {
				required : error.mobileNo.required,
				mobilenumber : error.mobileNo.mobilenumber
			},
			
			captchaCode : {
				required : error.captchaCode.required
			},
			
			colorName : {
				required : error.colorName.required
			},
			
		},
		
	});
	
	
});	



//unnati

function validEntry(){
var clinicName = document.getElementById('clinicName').value;
var clinicOwner = document.getElementById('clinicOwner').value;
var email = document.getElementById('email').value;
var mobileNo = document.getElementById('mobileNo').value;
var landline = document.getElementById('landline').value;

var userid = document.getElementById('userid').value;
var password = document.getElementById('password').value;
var confirmPassword = document.getElementById('confirmPassword').value;

document.getElementById('errorDiv').innerHTML="";
var chk=0;
 var pkgsubscription = document.getElementsByName("pkgsubscription");
    var okay=false;
    for(var i=0,l=pkgsubscription.length;i<l;i++)
    {
        if(pkgsubscription[i].checked)
        {
            okay=true;
        }
    }
    if(okay){
    	
    }
    else {
    	var pkg = document.createElement("label");
        pkg.innerHTML = "Check at least one package in Package subcription Tab";
        document.getElementById('errorDiv').appendChild(pkg);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
    }

var funSubscription = document.getElementsByName("funSubscription");
    var okay1=false;
    for(var i=0,l=funSubscription.length;i<l;i++)
    {
        if(funSubscription[i].checked)
        {
            okay1=true;
        }
    }
    if(okay1){
    	
    }
    else {
    	var pkg = document.createElement("label");
        pkg.innerHTML = "Check at least one fuctionality package in Functionality subcription Tab";
        document.getElementById('errorDiv').appendChild(pkg);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
    }

 	
   	if (clinicName ==  "") {
      	var clinicName = document.createElement("label");
        clinicName.innerHTML = "Enter Clinic Name in General Info Tab";
        document.getElementById('errorDiv').appendChild(clinicName);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }   
     if (clinicOwner ==  "") {
      	var clinicOwner = document.createElement("label");
        clinicOwner.innerHTML = "Enter Clinic Owner in General Info Tab";
        document.getElementById('errorDiv').appendChild(clinicOwner);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }  
     var atpos=email.indexOf("@");
	 var dotpos=email.lastIndexOf(".");
     if (email ==  "") {
      	var email = document.createElement("label");
        email.innerHTML = "Enter email in General Info Tab";
        document.getElementById('errorDiv').appendChild(email);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     }  
     
	 else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length) {
        var email = document.createElement("label");
        email.innerHTML = "Enter valid email in General Info Tab"; 
        document.getElementById('errorDiv').appendChild(email);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
       	
        chk=1;
     }
     if (mobileNo ==  "") {
      	var mobileNo = document.createElement("label");
        mobileNo.innerHTML = "Enter mobile no in General Info Tab";
        document.getElementById('errorDiv').appendChild(mobileNo);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
     } 
     else if (isNaN(mobileNo)===true){
  	 var mobiledig = document.createElement("label");
     mobiledig.innerHTML = "Enter valid mobile no in Personal Detail Tab"; 
     document.getElementById('errorDiv').appendChild(mobiledig);
     document.getElementById('errorDiv').appendChild(document.createElement('br'));
  	chk=1;
	}
	
    if(userid == ""){
    	var userid = document.createElement("label");
        userid.innerHTML = "Enter User Id in Account Info Tab";
        document.getElementById('errorDiv').appendChild(userid);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
    } 
    if(password == ""){
    	var password = document.createElement("label");
        password.innerHTML = "Enter password in Account Info Tab";
        document.getElementById('errorDiv').appendChild(password);
        document.getElementById('errorDiv').appendChild(document.createElement('br'));
        chk=1;
    }  
    if(confirmPassword == ""){
    	var confirmPassword = document.createElement("label");
        confirmPassword.innerHTML = "Enter confirm password in Account Info Tab";
        document.getElementById('errorDiv').appendChild(confirmPassword);
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

function addRow(tableID) 
        {
        	var table = document.getElementById(tableID);

                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                var counts = rowCount - 1;
				
				var cell1 = row.insertCell(0);
            	var element1 = document.createElement("input");
           		element1.type = "checkbox";
            	element1.name="chkbox[]";
            	cell1.appendChild(element1);

				var cell2 = row.insertCell(1);
            	cell2.innerHTML = counts + 1;
            					
                var cell3 = row.insertCell(2);
                var houseNo = document.createElement("input");
                houseNo.type = "text";
                houseNo.size = "10";
                houseNo.name = "location[" + counts + "].country";
                cell3.appendChild(houseNo);

                var cell4 = row.insertCell(3);
                var street = document.createElement("input");
                street.type = "text";
                street.size = "10";
                street.name = "location[" + counts + "].city";
                cell4.appendChild(street);

                var cell5 = row.insertCell(4);
                var city = document.createElement("input");
                city.type = "text";
                city.size = "10";
                city.name = "location[" + counts + "].pinCode";
                cell5.appendChild(city);

                var cell6 = row.insertCell(5);
                var country = document.createElement("textarea");
                country.type = "text";
                country.size = "10";
                country.name = "location[" + counts + "].address";
                cell6.appendChild(country);
                
                var cell7 = row.insertCell(6);
                var llocation = document.createElement("input");
                llocation.type = "text";
                llocation.size = "10";
                llocation.name = "location[" + counts + "].locationname";
                cell7.appendChild(llocation);
                
                
                var cell8 = row.insertCell(7);
                var colorname = document.createElement("input");
                colorname.type = "text";
                colorname.size = "10";
                colorname.name = "location[" + counts + "].colorName";
                //colorname.class = "color";
                colorname.setAttribute("class", "color");
              	colorname.value = "FFFFFF"; 
                cell8.appendChild(colorname);
                jscolor.init();
              

        }
function deleteRow(tableID){
	try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 2) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
}
