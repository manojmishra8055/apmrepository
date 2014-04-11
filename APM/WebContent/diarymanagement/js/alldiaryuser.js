	/*var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass {padding: 0px; margin: 0px; height:100%; text-align:center }';
	document.getElementsByTagName('head')[0].appendChild(style);
	
	var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass1 { min-height:10px; min-width:99px; }';
	document.getElementsByTagName('head')[0].appendChild(style);
	var time=0;*/
	


function setjsonDataAllUser(diaryUserId,commencing,col,size){
	//alert("hi"+col)
	//document.getElementById('diaryUser').value = diaryUserId;
	
	$.ajax({
		url: "diarymanagement/pages/JQGridMasterAllDiaryUser.jsp?diaryuserid="+diaryUserId+"&commencing="+commencing+" " ,
		dataType : "json",
		success : function(json) {
			//alert("Your JSON : " + JSON.stringify(json));
			
			
			  var data = JSON.parse(JSON.stringify(json));        
                     $.each(data,function(row,store)  {    
                        $.each(store,function(key,value) {
                            //id = value.id;
                            //name = value.name;
                           // address = value.address;
                            //age = value.age;
                           // alert(id + " : " + name + "  : " +address + " : " + age); 
                          	//alert(value.location);
                        
                          
                          var stdiff = parseInt(value.starttime) - 8
                          		stdiff = (parseInt(stdiff) * size) + parseInt(col);
                          		var tempStdiff = stdiff;
                          		
                          		//end time diff
                          		var etdiff = parseInt(value.endtime) - 8
                          		etdiff = (parseInt(etdiff) * size) + parseInt(col);
                          		
                          		var i=0;
                          		var j=0;
                          		
                          		var stemp = value.starttime.split(":");
                          		var etemp = value.endtime.split(":");
                          		var slength = parseInt(stemp[1])/5;
                          		var elength = parseInt(etemp[1])/5;
                          		
                          		var action = "edit";
                          		
                          		
                          		var timediff = getTimeDifference(value.starttime,value.endtime);
                          		var diffemp = timediff.split(":");
                          		var hour = parseInt(diffemp[0])*60;
                          		timediff = hour + parseInt(diffemp[1]);
                          		var divlength = timediff/5;
                          		
                          		//$('#1').attr('colspan', 3);
								for (i=parseInt(stdiff);i<=parseInt(etdiff);i=(i+size)){
									$(document.getElementById(i)).css('border-bottom', '0px');
									$(document.getElementById(i)).css('font-size', '12px');
									document.getElementById(i).className = 'cssClass';
									document.getElementById(i).onclick = "";
									//document.getElementById(i).ondblclick = function() {
									//	$(this).MessageBox(value.weekfullname,0,action,value.id,stdiff,value.starttime,value.endtime,value.apmtduration,value.location,value.onlinebooking,time);
									//}
									
								}
								
								
									var jcount = 0;
									
									divlength = divlength - 1;
									
										for(j=0;j<=divlength;j++){
										jcount = 5*parseInt(slength);
										
										document.getElementById(jcount+'min'+stdiff).className = 'cssClass1';
										
										$(document.getElementById('30min'+stdiff)).css('background-image', 'url("diarymanagement/img/line.png")');
										$(document.getElementById('30min'+stdiff)).css('background-repeat', 'repeat-x');
										
										$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'aqua');
										document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
													$(this).MessageBox(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,this.title);
													document.getElementById('choice').value = 1;
													document.getElementById('blockdiv').style.display = 'none';
													document.getElementById('modifyPopup').style.display = 'none';
													document.getElementById('clientdidnotattentpopup').style.display = 'none';
													document.getElementById('appointment').style.display = '';
													document.getElementById('reminderPopup').style.display = 'none';
													document.getElementById('apmtdiv').innerHTML = '<font color="black" >New Appointment</font>';
													editAppointId = 0;
													editCommencing = value.commencing;
													
												//set cookie commencing
												document.cookie = "cookiecommencing=" + commencing;
												document.cookie = "cookiePractitionerId=" + diaryUserId;
													
												document.getElementById('client').value = "";
												document.getElementById('notes').value = "";
												document.getElementById('apmtType').value = 0;
											
										}
										document.getElementById(jcount+'min'+stdiff).onclick = function() {
											setGlobalData(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,value.commencing,this.title);
										}
										slength = parseInt(slength) + 1;
										if(jcount==55){
											slength = 0;
											divlength = parseInt(divlength) - j;
											j = 0;
											stdiff = parseInt(stdiff) + size;
											
										}
										
										
									}
									
									
									
									
								setjsonAllUserAvailableData(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,col,diaryUserId,size,value.commencing);
								
								
                          	
                        
                          	
                      });        
                     });
			
		}
	});
}

function setjsonAllUserAvailableData(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid,col,practitionerid,size,commencing){

	

	$.ajax({
		url: "diarymanagement/pages/JQGridMasterAvailableData.jsp?diaryuserid="+diaryuserid+"&practitionerid="+practitionerid+" " ,
		dataType : "json",
		success : function(json) {
			//alert("Your JSON : " + JSON.stringify(json));
			
			
			
			  var data = JSON.parse(JSON.stringify(json));        
                     $.each(data,function(row,store)  {    
                        $.each(store,function(key,value) {
                            //id = value.id;
                            //name = value.name;
                           // address = value.address;
                            //age = value.age;
                           // alert(id + " : " + name + "  : " +address + " : " + age); 
                          	
                          
                          		var stdiff = parseInt(value.starttime) - 8
                          		stdiff = (parseInt(stdiff) * size) + parseInt(col);
                          		var tempStdiff = stdiff;
                          		
                          		
                          
                          //set appointment type color
                          		var stemp = value.starttime.split(":");
                          		var etemp = value.endtime.split(":");
                          		var slength = parseInt(stemp[1])/5;
                          		var elength = parseInt(etemp[1])/5;
                          		
                          		var timediff = getTimeDifference(value.starttime,value.endtime);
                          		var diffemp = timediff.split(":");
                          		var hour = parseInt(diffemp[0])*60;
                          		timediff = hour + parseInt(diffemp[1]);
                          		var divlength = timediff/5;
                          		
                          		var stdiff = tempStdiff;
                          		
                          			
                          		
                          		var jcount = 0;
									
									divlength = divlength - 1;
									
									for(j=0;j<=divlength;j++){
										jcount = 5*parseInt(slength);
										
										document.getElementById(jcount+'min'+stdiff).className = 'cssClass1';
										if(value.status == 0){
											if(value.iscompleted == true){
												$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'rgb(222, 240, 17)');
											}else{
												$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'yellow');
											}
											document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
												document.getElementById('blockdiv').style.display = 'none';
												document.getElementById('reminderPopup').style.display = 'none';
												
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,commencing);
												setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing,starttime,value.treatmentepisodeid,value.iscompleted);
												
											}
										}else if(value.status == 1){
											$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'rgb(236, 147, 147)');
											document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
												document.getElementById('blockdiv').style.display = 'none';
												document.getElementById('reminderPopup').style.display = 'none';
											
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,commencing);
												setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing,starttime,value.treatmentepisodeid,value.iscompleted);
												
											}
										}else{
											document.getElementById(jcount+'min'+stdiff).onclick = function() {
												setGlobalData(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid,commencing);
												 
											}
										}
										
										//document.getElementById(jcount+'min'+stdiff).onclick = function() {
										//			$(this).MessageBox(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid);
											
										//}
										
										slength = parseInt(slength) + 1;
										if(jcount==55){
											slength = 0;
											divlength = parseInt(divlength) - j;
											j = 0;
											stdiff = parseInt(stdiff) + size;
											
										}
										
										
									}
									
									
									
									if(etemp[1] != '00'){
                          				var eet = parseInt(etemp[1])-5;
                          				$(document.getElementById(eet+'min'+stdiff)).css('border-bottom', '1px solid #e69623');
                          				
                          				$(document.getElementById(stemp[1]+'min'+stdiff)).css('border-radius', '0px');
										$(document.getElementById(eet+'min'+stdiff)).css('border-radius', '0px');
                          			}
                          			
                          			
									//$(document.getElementById('30min'+stdiff)).css('background-image', 'url("")');
									//$(document.getElementById('30min'+stdiff)).css('background-repeat', '');
                          
                       		
                          	//write text 
                          		var stext = parseInt(stemp[1]);
								//var apttime = value.starttime + "-" + value.endtime;
								if(value.status == 0){
									if(value.arrivedstatus == 1){
										document.getElementById(stext+'min'+tempStdiff).style.color = "Blue";
									}else if(value.arrivedstatus == 2){
										document.getElementById(stext+'min'+tempStdiff).style.color = "green";
									}else{
										document.getElementById(stext+'min'+tempStdiff).style.color = "Black";
									}
									//value.notes = "";
									document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' +  value.clientname +","+""+value.notes+"" + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
									//document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' + value.clientname + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
									document.getElementById(stext+'min'+tempStdiff).title = value.notes + "," + "["+value.apmttype+"]";
								}else{
									document.getElementById(stext+'min'+tempStdiff).innerHTML =  '<div class="green">' + value.reasonforblock + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
									document.getElementById(stext+'min'+tempStdiff).title = value.notes + "," + "["+value.apmttype+"]";
								}
								
								if(value.status==0 && value.dna==true){
									document.getElementById(stext+'min'+tempStdiff).style.color = "Red";
								}
								
                        
                          	
                      });        
                     });
			
		}
	});
}



/*function getTimeDifference(startTime,endTime){
	var result = "";
	
   var startTimeArray = startTime.split(":");
   var startInputHrs = parseInt(startTimeArray[0]);
   var startInputMins = parseInt(startTimeArray[1]);

   var endTimeArray = endTime.split(":");
   var endInputHrs = parseInt(endTimeArray[0]);
   var endInputMins = parseInt(endTimeArray[1]);

   var startMin = startInputHrs*60 + startInputMins;
   var endMin = endInputHrs*60 + endInputMins;

   var result;

   if (endMin < startMin) {
       var minutesPerDay = 24*60; 
       result = minutesPerDay - startMin;  // Minutes till midnight
       result += endMin; // Minutes in the next day
   } else {
      result = endMin - startMin;
   }

   var minutesElapsed = result % 60;
   var hoursElapsed = (result - minutesElapsed) / 60;

  result =  hoursElapsed + ":" + (minutesElapsed < 10 ? '0'+minutesElapsed : minutesElapsed)  ;
  
  return result;

}*/