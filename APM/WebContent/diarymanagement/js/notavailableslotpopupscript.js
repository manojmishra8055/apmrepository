/* 
	author: istockphp.com
*/
var diaryuserId = "";
var commencing = "";
var diaryUser1 = "";
var stime = "";
var etime = "";
var loc = " ";
var id1 = "";
var tempDiaryUserName="";
var tempStatus = "";
var editStartTime = "";
var editEndTime = "";
var editDuration = "";
var editClientName = "";
var editNotes = "";
var editAppointType = "";
var editAppointId = 0;
var practitionerEmailId="";
var clientEmailId="";
var patientId = "";
var editCommencing = "";
var blockDivTime = "";
var slotstarttime = "";
var editTreatmentEpisode;


displayTooltip = false;
var messageDelay = 10000;
jQuery.fn.center = function () {
		
		this.css("position","absolute");
		this.css("top", ( $(window).height() - this.height() ) / 2+$(window).scrollTop() + "px");
		//this.css("left", ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px");
		
		return this;
	};
	
$(document).ready(function(){
	$("#previewDiv").hide();
	

});	

function showdiv(){

	
	document.getElementById('choice').value = 0;
	document.getElementById('modifyPopup').style.display = 'none';
	document.getElementById('appointment').style.display = 'none';
	document.getElementById('clientdidnotattentpopup').style.display = 'none';
	document.getElementById('blockdiv').style.display = '';
	document.getElementById('reminderPopup').style.display = 'none';
	//alert(diaryUser1);
	
	document.getElementById('blockapmtdiv').innerHTML = '<font color="white">Non Available Appointment Slot</font>';
	document.getElementById('blocknotes').value = "";
	
$(this).MessageBox(null,0,null,id1,null,stime,etime,null,loc,null,null,diaryUser1,commencing,id1);
	
	
}

//set client has arrived
function clienthasarrived(status){
	var url = "setresetNotAvailableSlot?selectedid="+editAppointId+"&status="+status+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = clienthasarrivedRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}

function clienthasarrivedRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
		
			document.getElementById('clienthasarrived').style.display = 'none';
			document.getElementById('clientisbeingseen').style.display = '';
			document.getElementById('resetnotarrived').style.display = '';
			document.getElementById('clientdidnotcome').style.display = 'none';
			//disable
			$(this).cancelSlot();			
			
			/*getSearch();
			showAvailiability();
			getDaySearch();*/
			
			setCommonAction();
		}
	}

}

function setCommonAction(){
	
	if(actionType == 0){
		getSearch();
	}else if(actionType == 1){
		showAvailiability();
	}else{
	
		getDaySearch();
	}
}

//set client is being seen
function setClientIsBeingSeen(status){
	var url = "clientIsBeingSeenNotAvailableSlot?selectedid="+editAppointId+"&status="+status+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setClientIsBeingSeenRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}

function setClientIsBeingSeenRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById('clienthasarrived').style.display = 'none';
			document.getElementById('clientisbeingseen').style.display = 'none';
			document.getElementById('resetnotarrived').style.display = '';
			document.getElementById('clientdidnotcome').style.display = 'none';
			//disable
			$(this).cancelSlot();			
			
			setCommonAction();
			
			alert("Ok,Client has been Called!!");
		}	
	}
}


//Reset Not Arrived
function ResetToNotArrived(status){
	var url = "resetNotArrivedNotAvailableSlot?selectedid="+editAppointId+"&status="+status+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = ResetToNotArrivedRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}

function ResetToNotArrivedRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById('clienthasarrived').style.display = '';
			document.getElementById('clientisbeingseen').style.display = '';
			document.getElementById('resetnotarrived').style.display = 'none';
			document.getElementById('clientdidnotcome').style.display = '';
			//disable
			$(this).cancelSlot();			
			
			setCommonAction();
		}
	}

}


//set clint did not attend
function setClientDidNotCome(){
	document.getElementById('clientdidnotattentpopup').style.display = '';
	document.getElementById('modifyPopup').style.display = 'none';
	
	document.getElementById('missedappointmentwith').value = tempDiaryUserName;
	document.getElementById('didnotattendDate').value = "17/03/2014";
	document.getElementById('didnotattentTime').value = editStartTime;
	document.getElementById('didnotattentDuration').value = editDuration;
	document.getElementById('didnotattendNotes').value = editNotes;
	document.getElementById('dnachk').checked = true;
	
}

//set client did not attent confirm
function setClientDidNotComeConfirm(){
	
	var dnaNotes = document.getElementById('didnotattendNotes').value;
	var dna = document.getElementById('dnachk').checked ;
	var dnaReason = document.getElementById('why').value;
	
	
	var url = "didnotAttendNotAvailableSlot?selectedid="+editAppointId+"&dnaNotes="+dnaNotes+"&dna="+dna+"&dnaReason="+dnaReason+" ";	
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setClientDidNotComeConfirmRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function setClientDidNotComeConfirmRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			
				$(this).cancelSlot();			
				
				setCommonAction();
		
		}
	}
}




//set modify popup
function setModifyPopup(status,starttime,endtime,duration,clientName,notes,apmtType,appointmentId,arrivedstatus,dna,userid,clientId,commencing,practitionerEmail,clientEmail,charge,commencing,slotstarttime,treatmentEpisode,iscompleted){

if(status ==1){
	document.getElementById('completeapmt').disabled="disabled";
	document.getElementById('clientarrived').disabled="disabled";
	document.getElementById('clientseen').disabled="disabled";
	document.getElementById('dna').disabled="disabled";
	document.getElementById('reminder').disabled="disabled";
	
}
else{
	
	if(iscompleted == true){
		document.getElementById('completeapmt').disabled="disabled";
	}else{
		document.getElementById('completeapmt').disabled="";
	}
	document.getElementById('clientarrived').disabled="";
	document.getElementById('clientseen').disabled="";
	document.getElementById('dna').disabled="";
	document.getElementById('reminder').disabled="";
	
	//set treatment episode
	setTreatmentEpisode();
	
}
//disabled popup button
	
	tempStatus = status;
	editStartTime = starttime;
	editEndTime = endtime;
	editDuration = duration;
	editClientName = clientName;
	editNotes = notes;
	editAppointType = apmtType;
	editAppointId = appointmentId;
	editCommencing = commencing;
	slotstarttime = slotstarttime;
	editTreatmentEpisode = treatmentEpisode;
	
	
	
	//for reminder mail
	clientName = clientName;
	diaryuserId  = userid;
	practitionerEmailId = practitionerEmail;
	clientEmailId = clientEmail;
	patientId = clientId;
	
	
	if(arrivedstatus == 1){
		document.getElementById('clienthasarrived').style.display = 'none';
		document.getElementById('clientisbeingseen').style.display = '';
		document.getElementById('resetnotarrived').style.display = '';
	}else if(arrivedstatus == 2){
			document.getElementById('clienthasarrived').style.display = 'none';
			document.getElementById('clientisbeingseen').style.display = 'none';
			document.getElementById('resetnotarrived').style.display = '';
	}else{
			document.getElementById('clienthasarrived').style.display = '';
			document.getElementById('clientisbeingseen').style.display = '';
			document.getElementById('resetnotarrived').style.display = 'none';
	}
	
	document.getElementById('appointment').style.display = 'none';
	document.getElementById('modifyPopup').style.display = '';
	
	document.getElementById('user').value = tempDiaryUserName;
	
		/*document.getElementById('modifyHeading').innerHTML = 'Client Appointment';
		document.getElementById('modifyClient').innerHTML = editClientName;
		document.getElementById('modifyDate').innerHTML = commencing;*/
	
	if(status==0 && dna==true){
		document.getElementById('modifyPopup').style.display = 'none';
		document.getElementById('clientdidnotattentpopup').style.display = '';
		
			document.getElementById('missedappointmentwith').value = tempDiaryUserName;
			document.getElementById('didnotattendDate').value = "17/03/2014";
			document.getElementById('didnotattentTime').value = editStartTime;
			document.getElementById('didnotattentDuration').value = editDuration;
			document.getElementById('didnotattendNotes').value = editNotes;
			document.getElementById('dnachk').checked = dna;
	}
	if(status==0 && dna==false){
		document.getElementById('modifyPopup').style.display = '';
		document.getElementById('clientdidnotattentpopup').style.display = 'none';
	}
	if(status==1 && dna==false){
		document.getElementById('modifyPopup').style.display = '';
		document.getElementById('clientdidnotattentpopup').style.display = 'none';
	}
	
	document.getElementById('modifyHeading').innerHTML = 'Client Appointment';
		document.getElementById('modifyClient').innerHTML = editClientName;
		
	
	document.cookie = "cookieUserName=" + clientName;//Cookie name with value
	document.cookie = "cookieStarttime=" + starttime;
	document.cookie = "cookieDuration=" + duration;
	document.cookie = "cookiePractitioner=" + tempDiaryUserName;
	document.cookie = "cookieapmtType=" + apmtType;
	document.cookie = "cookiePractitionerId=" + userid;
	document.cookie = "cookieClientId=" + clientId;
	document.cookie = "cookiecommencing=" + commencing;
	document.cookie = "cookieCharge=" + charge;
	document.cookie = "cookieSelectedAppointmentid=" + editAppointId;
	document.cookie = "cookieTreatmentEpisode=" + editTreatmentEpisode;
	
	
	
	$(this).MessageBox(null,editStartTime,editEndTime,editDuration,loc,tempDiaryUserName,null,userid,clientId,commencing,practitionerEmail,clientEmail,charge);
}

function modifythisAppointment(){
	if(tempStatus == 0){
		
	
	
	//alert(patientId);
		document.getElementById('appointment').style.display = '';
		document.getElementById('blockdiv').style.display = 'none';
		document.getElementById('modifyPopup').style.display = 'none';
		document.getElementById('reminderPopup').style.display = 'none';
		
		document.getElementById('user').value = tempDiaryUserName;
		document.getElementById('location').value = loc;
		document.getElementById('sTime').value = editStartTime;
		document.getElementById('endTime').value = editEndTime;
		document.getElementById('apmtDuration').value = editDuration;
		document.getElementById('client').value = editClientName;
		document.getElementById('clientId').value = patientId;
		
		$("#apmtType option:contains(" + editAppointType + ")").attr('selected', 'selected');
		
		
		document.getElementById('treatmentEpisode').value = editTreatmentEpisode;
		
		 
		//$("#apmtType:selected").text() = editAppointType;
		document.getElementById('notes').value = editNotes;
		
		document.getElementById('apmtdiv').innerHTML = '<font color="white" > Modify New Appointment</font>';
		
		
	}else if(tempStatus == 1){
	
	
		document.getElementById('appointment').style.display = 'none';
		document.getElementById('blockdiv').style.display = '';
		document.getElementById('modifyPopup').style.display = 'none';
		document.getElementById('reminderPopup').style.display = 'none';
		
		document.getElementById('blockuser').value = tempDiaryUserName;
		document.getElementById('blocklocation').value = loc;
		document.getElementById('blocksTime').value = editStartTime;
		document.getElementById('blockendTime').value = editEndTime;
		document.getElementById('blockapmtDuration').value = editDuration;
		document.getElementById('blocknotes').value = editNotes;
		
		document.getElementById('blockapmtdiv').innerHTML = '<font color="white">Modify Non Available Appointment Slot</font>';
		
	}else{
	
	}
	
	$(this).MessageBox(null,editStartTime,editEndTime,editDuration,loc,tempDiaryUserName,null,null);
}

function reminder(){
		document.getElementById('appointment').style.display = 'none';
		document.getElementById('blockdiv').style.display = 'none';
		document.getElementById('modifyPopup').style.display = 'none';
		document.getElementById('reminderPopup').style.display = '';
		
		document.getElementById('user').value = tempDiaryUserName;
		document.getElementById('location').value = loc;
		document.getElementById('sTime').value = editStartTime;
		document.getElementById('endTime').value = editEndTime;
		document.getElementById('apmtDuration').value = editDuration;
		document.getElementById('client').value = editClientName;
		document.getElementById('clientId').value = patientId;
		 
		document.getElementById('notes').value = editNotes;
		
		document.getElementById('remiderHeading').innerHTML = 'Appointment Confirmation and Reminder';
		document.getElementById('remiderClient').innerHTML = editClientName;
		document.getElementById('remiderdate').innerHTML = commencing ;
		
		
		
		//Reminder filed set
		//alert(patientId);
		
		
		/*document.getElementById('practitionersName').value = tempDiaryUserName;
		document.getElementById('practitionersId').value = diaryuserId;
		document.getElementById('clientName').value = editClientName;
		document.getElementById('patientId').value = patientId;
		document.getElementById('aptmStartTime').value = editStartTime;
		document.getElementById('aptmDuration').value = editDuration;
		document.getElementById('aptmlocation').value = loc;
		document.getElementById('clientEmail').value = practitionerEmailId;
		document.getElementById('practitionersEmail').value = clientEmailId;*/
		
		
		
		
		

}


jQuery(function($) {

 $.fn.MessageBox = function(id,starttime,endtime,apmtduration,location,diaryUser,diaryUserId,divtime) {
	
 		document.getElementById('slotId').value = id;
 		document.getElementById('blockdiaryUserId').value = diaryUserId;
 		document.getElementById('blockslotId').value = id;
		document.getElementById('sTime').value = starttime;
 		document.getElementById('endTime').value = endtime;
 		//document.getElementById('apmtDuration').value = apmtduration;
 		document.getElementById('location').value = location;
 		
 		if(editAppointId==0){
 			document.getElementById('sTime').value = divtime;
 			document.getElementById('blocksTime').value = blockDivTime;
 			document.getElementById('blockendTime').value = etime;
 			document.getElementById('apmtDuration').value = 0;
 			document.getElementById('blockapmtDuration').value = 0;
 		}
 		
 		document.getElementById('blocklocation').value = loc;
 		
 			/*diaryUser1 = diaryUser;
			stime = starttime;
			etime = endtime;
			loc = location;
			id1 = id;*/
			
			
			
			
			var date = editCommencing;
			var id = document.getElementById('diaryUser').value;
			
			
			document.getElementById('date').value = date;
			document.getElementById('diaryUserId').value = diaryUserId;
			document.getElementById('user').value = diaryUser;
			commencing = editCommencing;
							
			
			
			document.getElementById('date').value = commencing;
			document.getElementById('diaryUserId').value = diaryUserId;
			document.getElementById('blockuser').value = tempDiaryUserName;
			document.getElementById('blockdate').value = commencing;
			var location = document.getElementById('location');
			
			
		var str = '<input class = "buttons"  type="button" value="Submit" onclick="$(this).saveSlot(\''+editAppointId+'\',\''+starttime+'\');"/>'
 		str = str + '<input class = "buttons"  type="button" value="Cancel" onclick="$(this).cancelSlot();"/>'
 		document.getElementById('submitslot').innerHTML = str;
 		
 		var str = '<input class = "buttons" type="button" value="Submit" onclick="$(this).blockSave(\''+editAppointId+'\',\''+stime+'\');"/>'
 		str = str + '<input class = "buttons"  type="button" value="Cancel" onclick="$(this).cancelSlot();"/>'
 		document.getElementById('submitblockslot').innerHTML = str;
			
			
			 loading(); // loading
			setTimeout(function(){ // then show popup, deley in .5 second
				loadPopup(); // function show popup 
			}, 500); // .5 second
			
			
			
			return false;
        };
	
	
	
	/* event for close the popup */
	$("div.close").hover(
					function() {
						$('span.ecs_tooltip').show();
					},
					function () {
    					$('span.ecs_tooltip').hide();
  					}
				);
	
	$("div.close").click(function() {
		disablePopup();  // function close pop up
	});
	
	$(this).keyup(function(event) {
		if (event.which == 27) { // 27 is 'Ecs' in the keyboard
			disablePopup();  // function close pop up
		}  	
	});
	
	$("div#backgroundPopup").click(function() {
		disablePopup();  // function close pop up
	});
	
	$('a.livebox').click(function() {
		alert('Hello World!');
	return false;
	});
	

	 /************** start: functions. **************/
	function loading() {
		$("div.loader").show();  
	}
	function closeloading() {
		$("div.loader").fadeOut('normal');  
	}
	
	var popupStatus = 0; // set value
	
	function loadPopup() { 
		if(popupStatus == 0) { // if value is 0, show popup
			closeloading(); // fadeout loading
			
			
			$("#background").css({"opacity" : "0.7"}).fadeIn("slow");
			$("#previewDiv").center().fadeIn("slow");	
			
			//$("#previewDiv").fadeIn(0500); // fadein popup div
			
			//$("#backgroundPopup").css("opacity", "0.7"); // css opacity, supports IE7, IE8
			//$("#backgroundPopup").fadeIn(0001); 
			popupStatus = 1; // and set value to 1
		}	
	}
		
	function disablePopup() {
		if(popupStatus == 1) { // if value is 1, close popup
			$("#background").fadeOut("slow");
			$("#previewDiv").hide();
			popupStatus = 0;  // and set value to 0
		}
	}
	/************** end: functions. **************/
	
	$.fn.saveSlot = function(id,starttime){
		var tempDuration = document.getElementById('apmtDuration').value;
		if(document.getElementById('apmtDuration').value == 0){
			alert("Please Enter Appointmen Type");
		}else{
		
			//chek start time
			var stime = document.getElementById('sTime').value;
			
			var initStime = stime+":"+"00";
			starttime = starttime+":"+"00";
			
			if(id > 0){
				starttime = slotstarttime;
			}
			
			//check end time
			var total = getTimeTotal(tempDuration,stime);
			
			total = total+":"+"00";
			var tempglobalEndTime = etime+":"+"00";
			
			var totalstarttime = total,
	    	endtime = tempglobalEndTime;
	    	
	    	if(initStime < starttime){
				alert("Please enter valid start time")
			}else if(totalstarttime > endtime){
	    		alert("Please Enter Valid Time");
	    	}else if(document.getElementById('client').value==""){
	    		alert("Please Enter Client");
	    	}else if(document.getElementById('apmtType').value==0){
	    		alert("Please Enter Appointmen Type");
	    	}else if(document.getElementById('notes').value==""){
	    		alert("Please Enter Notes")
	    	}else if(document.getElementById('treatmentEpisode').value == 0){
	    		alert("Please Select/Add Treatmen Episode");
	    	}else{
	    		
	    		var commencing = document.getElementById('date').value;
				var currentdate = getCurrentDate();
				//commencing = dateFormat(commencing);
				
				//check by time
				//alert(commencing)
				
				
				if (new Date(commencing) < new Date(currentdate)) {
					alert("Please contact Admin to add or edit this slot!!")
				}else if((new Date(commencing).getTime() == new Date(currentdate).getTime()) && (initStime < getCurrentTime())){
					alert("Please contact Admin to add or edit this slot!!")
				}else{
					saveAppointmentSlot(id);
					disablePopup(); 
				}
	    		
				
	    	}
		
		}
		
		
	
	};
	
	$.fn.blockSave = function(id,starttime){
		
		if(document.getElementById('blockapmtDuration').value == 0){
			alert("Plese Select Duration")
		}else{
			
			//check start time
			var stime = document.getElementById('blocksTime').value;
			
			var initStime = stime+":"+"00";
			starttime = starttime+":"+"00";
			
			if(id > 0){
				starttime = slotstarttime;
			}
			
			//check end time
			var duration = document.getElementById('blockapmtDuration').value;
			var total = getTimeTotal(duration,stime);
			
			total = total+":"+"00";
			var tempglobalEndTime = etime+":"+"00";
			
			var totalstarttime = total,
	    	endtime = tempglobalEndTime;
	    	
	    	if(initStime < starttime){
				alert("Please enter valid start time")
			}else if(totalstarttime > endtime){
	    		alert("Please Enter Valid Time");
	    	}else if(document.getElementById('blocknotes').value == 0){
	    		alert("Please Enter Notes")
	    	}else{
	    		var commencing = document.getElementById('date').value;
				var currentdate = getCurrentDate();
				//commencing = dateFormat(commencing);
				
				
				
				if (new Date(commencing) < new Date(currentdate)) {
					alert("Please contact Admin to add or edit this slot!!")
				}else if((new Date(commencing).getTime() == new Date(currentdate).getTime()) && (initStime < getCurrentTime())){
					alert("Please contact Admin to add or edit this slot!!")
				}else{
	    			saveBlockAppointmentSlot(id);
	    			disablePopup(); 
	    		}
				
	    	}
	    	
		}
		
		
	
	};
	
	$.fn.cancelSlot = function(){
		
		disablePopup(); 
	
	};
	
	
}); // jQuery End

function saveAppointmentSlot(id){
	
	//alert(id1);
	
	var slotId = document.getElementById('slotId').value;
	 commencing = document.getElementById('date').value;
	var location = document.getElementById('location').value;
	var room = document.getElementById('room').value;
	var sTime = document.getElementById('sTime').value;
	var endTime = document.getElementById('endTime').value;
	var apmtDuration = document.getElementById('apmtDuration').value;
	 diaryuserId = document.getElementById('diaryUserId').value;
	var client = document.getElementById('client').value;
	var dept = document.getElementById('dept').value;
	var apmtType = $("#apmtType option:selected").text();
	var notes = document.getElementById('notes').value;
	var diaryUser = document.getElementById('user').value;
	var clientId = document.getElementById('clientId').value;
	var treatmentEpisodeId = document.getElementById('treatmentEpisode').value;
	
	var url = "saveAppoinmentNotAvailableSlot?slotId="+slotId+"&commencing="+commencing+"&location="+location+"&room="+room+"&sTime="+sTime+"&endTime="+endTime+"&apmtDuration="+apmtDuration+"&diaryuserId="+diaryuserId+"&client="+client+"&dept="+dept+"&apmtType="+apmtType+"&notes="+notes+"&diaryUser="+diaryUser+"&selectedid="+id+"&clientId="+clientId+"&treatmentEpisodeId="+treatmentEpisodeId+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = saveAppointmentSlotRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function saveAppointmentSlotRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			//alert("Appointment slot has been set successfully!!");
			
			//setJsoData1(diaryUserId,commencing);
			//goPreview(tempusername,tempdate,tempyear,tempdiaryuserid,temptdcode)
			//window.location.reload();
			
			setCommonAction();
			
			
		}
	}
}

//save block

function saveBlockAppointmentSlot(id){
	
	//alert(id);
	
	var slotId = diaryUser1;
	 commencing = document.getElementById('blockdate').value;
	var location = document.getElementById('blocklocation').value;
	var room = document.getElementById('blockroom').value;
	var sTime = document.getElementById('blocksTime').value;
	var endTime = document.getElementById('blockendTime').value;
	var apmtDuration = document.getElementById('blockapmtDuration').value;
	 diaryuserId = id1;
	
	var reasonforblock = document.getElementById('reasonforblock').value;
	var notes = document.getElementById('blocknotes').value;
	var diaryUser = tempDiaryUserName;
	
	var status = document.getElementById('status').value;
	var url = "saveBlockNotAvailableSlot?slotId="+slotId+"&commencing="+commencing+"&location="+location+"&room="+room+"&sTime="+sTime+"&endTime="+endTime+"&apmtDuration="+apmtDuration+"&diaryuserId="+diaryuserId+"&reasonforblock="+reasonforblock+"&notes="+notes+"&diaryUser="+diaryUser+"&status="+status+"&selectedid="+id+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = saveBlockRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function saveBlockRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			//alert("Block slot has been set successfully!!");
			
			//setJsoData1(diaryUserId,commencing);
			//goPreview(tempusername,tempdate,tempyear,tempdiaryuserid,temptdcode)
			//window.location.reload();
			
			setCommonAction();
		}
	}
}

function completeApmt(){
$(this).cancelSlot();	
window.open('inputCompleteApmt.action?selectedUser='+tempDiaryUserName+'', 'mywin',
											'left=20,top=20,width=800,height=400,toolbar=1,resizable=0'); return false;
											
											
											
}	

function emailSend(){
//alert(commencing);
/*alert(diaryuserId);
alert(editClientName);
alert(patientId);
alert(editStartTime);
alert(editDuration);
alert(loc);
alert(practitionerEmailId);
alert(clientEmailId);*/
var url = "emailSendNotAvailableSlot?practitionerName="+tempDiaryUserName+"&practitionerId="+diaryuserId+"&clientName="+editClientName+"&clientId="+patientId+"&startTime="+editStartTime+"&duration="+editDuration+"&location="+loc+"&practitionerEmailId="+practitionerEmailId+"&clientEmailId="+clientEmailId+"&commencing="+commencing+"";

   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = emailSendRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function emailSendRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			alert("Email Send successfully!!");
			
			
			
		}
	}
}

