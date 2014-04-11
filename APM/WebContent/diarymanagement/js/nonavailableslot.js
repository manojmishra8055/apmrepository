
var tempCount = 0;
var month = 0;
var ct = 0;
var year = 0;
var susername = " ";
var globalEndTime = 0;
var actionType = 0;



//javascript css
	var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass {padding: 0px; margin: 0px; height:144px; text-align:center }';
	document.getElementsByTagName('head')[0].appendChild(style);
	
	var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass1 { min-height:12px; min-width:99px; }';
	document.getElementsByTagName('head')[0].appendChild(style);
	var time=0; 

/* 
 * hide or show dialog box on delete event
 * 
 * */
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
	document.getElementById('closediv').style.display = '';
	
});		


function getSearch(){
	 		
	 		actionType = 0;
	 		
			var date = document.getElementById("commencing").value;
			var id = document.getElementById('diaryUser').value;
			var count = 0;
			for(i=1;i<=119;i++){
				$(document.getElementById(i)).css('border-bottom', '1px solid #DFD8D4');
				document.getElementById(i).ondblclick = '';
				for(j=0;j<=11;j++){
					count = 5*j;
					$(document.getElementById(count+'min'+i)).css('background-color', 'white');
					$(document.getElementById(count+'min'+i)).css('border-bottom', '');
					//$(document.getElementById(count+'min'+i)).css('border-bottom-style', '');
					document.getElementById(count+'min'+i).innerHTML = '';
					count = parseInt(count)+1;
				}
				
				
				//document.getElementById(i).innerHTML = "";
			}
			
			var tempDate = date.split("/");
			var mm = tempDate[1];
			var yy = tempDate[2];
			
			for(j=0;j<=6;j++){
				var dd = parseInt(tempDate[0]) + j;
				//date = dd + "/" + mm + "/" + yy;
				date = getCalDate(dd,mm,yy)
				var temp = date.split("-")
				document.getElementById('wn'+j).innerHTML = getMonthName(j) + " " + temp[0];
				
				setJsoData(id,date);
			}
			//setJsoData(id,date);
}



function setJsoData(diaryUserId,date){

	$.ajax({
		url: "diarymanagement/pages/JQGridMasterNotAvailableSlot.jsp?diaryUserId="+diaryUserId+"&date="+date+" " ,
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
                          	
                          	
                          	
                          globalEndTime = value.endtime;
                          	
                          	if(value.weekfullname == "Monday"){
                          		
                         		var col = 1;
                          		//start time diff
                          		var stdiff = parseInt(value.starttime) - 8
                          		stdiff = (parseInt(stdiff) * 7) + parseInt(col);
                          		var tempStdiff = stdiff;
                          		
                          		//end time diff
                          		var etdiff = parseInt(value.endtime) - 8
                          		etdiff = (parseInt(etdiff) * 7) + parseInt(col);
                          		
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
								for (i=parseInt(stdiff);i<=parseInt(etdiff);i=(i+7)){
									//$(document.getElementById(i)).css('border-bottom', '0px');
									//$(document.getElementById(i)).css('background-color', value.color);
									$(document.getElementById(i)).css('font-size', '12px');
									document.getElementById(i).className = 'cssClass';
									document.getElementById(i).onclick = "";
									//document.getElementById(i).ondblclick = function() {
									//	$(this).MessageBox(value.weekfullname,0,action,value.id,stdiff,value.starttime,value.endtime,value.apmtduration,value.location,value.onlinebooking,time);
									//}
									
								}
								
								
									var jcount = 0;
									var divtime = 0;
									
									divlength = divlength - 1;
									
									for(j=0;j<=divlength;j++){
										jcount = 5*parseInt(slength);
										
										document.getElementById(jcount+'min'+stdiff).className = 'cssClass1';
										//quua
										
										$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'aqua');
										
											$(document.getElementById('30min'+stdiff)).css('background-image', 'url("diarymanagement/img/line.png")');
											$(document.getElementById('30min'+stdiff)).css('background-repeat', 'repeat-x');
										
										document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
										$(this).MessageBox(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,this.title);
													document.getElementById('choice').value = 1;
													document.getElementById('blockdiv').style.display = 'none';
													document.getElementById('modifyPopup').style.display = 'none';
													document.getElementById('reminderPopup').style.display = 'none';
													document.getElementById('clientdidnotattentpopup').style.display = 'none';
													document.getElementById('appointment').style.display = '';
													document.getElementById('apmtdiv').innerHTML = '<font color="black" >New Appointment</font>';
													editAppointId = 0;
													editCommencimg = value.commencing;
													
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
											stdiff = parseInt(stdiff) + 7;
											
										}
										
										
									}
									
								setjsonAvailableData(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,col,value.practitionerid,value.commencing);
								
								
								
							}//col 1
							
							if(value.weekfullname == "Tuesday"){
                          		var col = 2;
                          		setWeekTimer(value.weekfullname,2,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 2
							
							if(value.weekfullname == "Wednesday"){
                          		var col = 3;
                          		setWeekTimer(value.weekfullname,3,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 3
							
							if(value.weekfullname == "Thursday"){
                          		var col = 4;
                          		setWeekTimer(value.weekfullname,4,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 4
							
							if(value.weekfullname == "Friday"){
                          		var col = 5;
                          		setWeekTimer(value.weekfullname,5,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 5
							
							if(value.weekfullname == "Saturday"){
                          		var col = 6;
                          		setWeekTimer(value.weekfullname,6,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 6
							
							if(value.weekfullname == "Sunday"){
                          		var col = 7;
                          		setWeekTimer(value.weekfullname,7,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color,tempStdiff,value.diaryUser,diaryUserId,value.practitionerid,value.commencing)
							}//col 7
							
							
                        });        
                     });
			
		}
	});
			
			
}	


function setjsonAvailableData(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid,col,practitionerid,commencing){

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
                          		stdiff = (parseInt(stdiff) * 7) + parseInt(col);
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
												
												setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing,starttime,value.treatmentepisodeid,value.iscompleted);
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail);
											
											}
										}else if(value.status == 1){
											$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'rgb(236, 147, 147)');
											document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
												document.getElementById('blockdiv').style.display = 'none';
												document.getElementById('reminderPopup').style.display = 'none';
												
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna);
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
											stdiff = parseInt(stdiff) + 7;
											
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
									//document.getElementById(stext+'min'+tempStdiff).className = 'green';
									document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' +  value.clientname +","+""+value.shortnotes+"" + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
									//document.getElementById(stext+'min'+tempStdiff).innerHTML =  '<div class="green">' + value.clientname + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>' ;
									document.getElementById(stext+'min'+tempStdiff).title = value.notes + "," + "["+value.apmttype+"]";
								}else{
									document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' + value.reasonforblock + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
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



function setGlobalData(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid,commencing,divtime){
	//alert(diaryusername)
	
	diaryUser1 = diaryuserid;
	stime = starttime;
	blockDivTime = divtime;
	etime = endtime;
	loc = location;
	id1 = userid;
	tempDiaryUserName = diaryusername;
	editCommencing = commencing;
	
	
}

	
function getTimeDifference(startTime,endTime){
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

}
function setWeekTimer(weekfullname,col,starttime,endtime,id,apmtduration,location,onlinebooking,color,tempStdiff,diaryUser,diaryUserId,practitionerid,commencing){
	
	//var col = 1;
	//start time diff
	//start time diff
                         		var stdiff = parseInt(starttime) - 8
                         		stdiff = (parseInt(stdiff) * 7) + parseInt(col);
                         		var tempStdiff = stdiff;
                         		
                         		//end time diff
                         		var etdiff = parseInt(endtime) - 8
                         		etdiff = (parseInt(etdiff) * 7) + parseInt(col);
                         		
                         		var i=0;
                         		var j=0;
                         		
                         		var stemp = starttime.split(":");
                         		var etemp = endtime.split(":");
                         		var slength = parseInt(stemp[1])/5;
                         		var elength = parseInt(etemp[1])/5;
                         		
                         		var action = "edit";
                         		
                         		
                         		var timediff = getTimeDifference(starttime,endtime);
                         		var diffemp = timediff.split(":");
                         		var hour = parseInt(diffemp[0])*60;
                         		timediff = hour + parseInt(diffemp[1]);
                         		var divlength = timediff/5;
                         		
                         		//$('#1').attr('colspan', 3);
							for (i=parseInt(stdiff);i<=parseInt(etdiff);i=(i+7)){
								//$(document.getElementById(i)).css('border-bottom', '0px');
								//$(document.getElementById(i)).css('background-color', value.color);
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
									$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'aqua');
									document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
												$(this).MessageBox(id,starttime,endtime,apmtduration,location,diaryUser,diaryUserId,this.title);
												document.getElementById('choice').value = 1;
												document.getElementById('blockdiv').style.display = 'none';
												document.getElementById('modifyPopup').style.display = 'none';
												document.getElementById('reminderPopup').style.display = 'none';
												document.getElementById('clientdidnotattentpopup').style.display = 'none';
												document.getElementById('appointment').style.display = '';
												document.getElementById('apmtdiv').innerHTML = '<font color="black" >New Appointment</font>';
												editAppointId = 0;
												editAppointId = 0;
												editCommencimg = commencing;
													
												//set cookie commencing
												document.cookie = "cookiecommencing=" + commencing;
												document.cookie = "cookiePractitionerId=" + diaryUserId;
												
												
												document.getElementById('client').value = "";
												document.getElementById('notes').value = "";
												document.getElementById('apmtType').value = 0;
										
									}
									document.getElementById(jcount+'min'+stdiff).onclick = function() {
										setGlobalData(id,starttime,endtime,apmtduration,location,diaryUser,diaryUserId,commencing,this.title);
									}
									slength = parseInt(slength) + 1;
									if(jcount==55){
										slength = 0;
										divlength = parseInt(divlength) - j;
										j = 0;
										stdiff = parseInt(stdiff) + 7;
										
									}
									
									
								}
								
							setjsonAvailableData(id,starttime,endtime,apmtduration,location,diaryUser,diaryUserId,col,practitionerid,commencing);
								
	
}


function resetAppointmentField(){

	/*document.getElementById('endTime').value = etime;
	document.getElementById('apmtDuration').value = '0';
	document.getElementById('apmtType').value = '0';*/
	
	setAppointmentTypeTime(tempDuration);
}	
	

var tempDuration = 0;
function setAppointmentTypeTime(duration){
	tempDuration=duration;
	total = "00:00:00";
	globalEndTime = etime;
	document.getElementById('apmtDuration').value = duration;
	var stime = document.getElementById('sTime').value;
	
	var total = getTimeTotal(duration,stime);
	//alert(total)
	document.getElementById('endTime').value = total;
	
	
}


//block div js code
function setBlockDivEndTime(duration){
	tempDuration = duration;
	var stime = document.getElementById('blocksTime').value;
	var endtime = getTimeTotal(stime,duration);
	
	document.getElementById('blockendTime').value = endtime;
}

function resetBlockDivField(){
	
	//document.getElementById('blockendTime').value = etime;
	//document.getElementById('blockapmtDuration').value = '0';
	setBlockDivEndTime(tempDuration);
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


function getCalDate(caldate,month,year){
	if((month==1) || (month==3) || (month==5) || (month==7) || (month==8) || (month==10) ||  (month==12)){
		if(caldate > 31){
			
			//caldate =  parseInt(caldate) - 1
			caldate =  parseInt(caldate) - 31 
			month = parseInt(month)+1;
			
			if(month==13){
				month = 1;
				year = parseInt(year)+1;
			}
			
			if(month <=9){
				month = "0"+month;
			}
		}
	}else if(month==2){
		if(parseInt(year)%4==0){
			
			if(caldate > 29){
				//caldate =  parseInt(caldate) - 1
				caldate =  parseInt(caldate) - 29 
				month = parseInt(month)+1;
				
				if(month <=9){
					month = "0"+month;
				}
			}
		}else{
		
			if(caldate > 28){
				//caldate =  parseInt(caldate) - 1
				caldate =  parseInt(caldate) - 28
				month = parseInt(month)+1;
				 
				if(month <=9){
					month = "0"+month;
				}
			}
		}
	
	}else{
		if(caldate > 30){
			//caldate =  parseInt(caldate) - 1
			caldate =  parseInt(caldate) - 30 
			month = parseInt(month)+1;
			
			if(month <=9){
				month = "0"+month;
			}
			
		}
	}
	
	
	if(caldate <=9){
		caldate = "0"+caldate;
	}
	
	
	caldate = caldate + "-" + month + "-" + year;
	//alert(caldate);
	return caldate;
}


function setClientName(name,id,type,typeName){
//alert(name);
//alert(id);
//alert(type);
//alert(typeName);
		document.getElementById("client").value = name;
		document.getElementById("clientId").value = id;
		
		
		//set cookie data
		document.cookie = "cookieUserName=" + name;
		document.cookie = "cookieClientId=" + id;
		
		document.getElementById('allPatientDiv').style.display = 'none';
		document.getElementById('appointment').style.display = '';
		
		document.getElementById("client").value = name;
		
		setTreatmentEpisode();
        
		
}

function setValue(name,id,type,typeName){
		
		document.getElementById("client").value = name;
		document.getElementById("clientId").value = id;
		
		
		//set cookie data
		document.cookie = "cookieUserName=" + name;
		document.cookie = "cookieClientId=" + id;
		
		document.getElementById('allPatientDiv').style.display = 'none';
		document.getElementById('appointment').style.display = '';
		
		document.getElementById("client").value = name;
		
		setTreatmentEpisode();
		
		
}
function showAllPatientPopUp(){

var url = "Client";



if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = showAllPatientPopUpRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}
function showAllPatientPopUpRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			document.getElementById("allPatient").innerHTML = req.responseText;
         	document.getElementById('allPatientDiv').style.display = '';
			document.getElementById('appointment').style.display = '';
			document.getElementById('addPatientDiv').style.display = 'none';
			
         }
	}
}

function addPatient(){
			//alert("M there");
			document.getElementById('addPatientDiv').style.display = '';
			document.getElementById('allPatientDiv').style.display = 'none';
			document.getElementById('appointment').style.display = 'none';
			
	

}
function setTreatmentEpisode(){
	
	var clientid = read_cookie("cookieClientId");
	
	var url = "setTreatmentEpisode?clientid="+clientid+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = setTreatmentEpisodeRequest;
    req.open("GET", url, true); 
              
    req.send(null);
}

function setTreatmentEpisodeRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById('treatmentepisodeajax').innerHTML = req.responseText;
		}
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

function getWeekPrintData(){
var practitionerId = document.getElementById('diaryUser').value;
var date = document.getElementById('commencing').value;


var e = document.getElementById('diaryUser');
var practitioner = e.options[e.selectedIndex].text;
//alert(practitioner);
//alert(date);
//alert(practitionerId);
showPopWin("getPrintDataOfWeekNotAvailableSlot?practitionerId="+practitionerId+"&date="+date+"&practitioner="+practitioner+"", 800, 550, null);


if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = getWeekPrintDataRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}


function getWeekPrintDataRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
         
         }
	}
}

function getPrintData(){
var practitionerId = document.getElementById('diaryUser').value;
var date = document.getElementById('commencing').value;

var e = document.getElementById('diaryUser');
			var practitioner = e.options[e.selectedIndex].text;


showPopWin("getPractionerPrintDataNotAvailableSlot?practitionerId="+practitionerId+"&date="+date+"&practitioner="+practitioner+"", 800, 550, null);


if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = getPrintDataRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}


function getPrintDataRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
         
         }
	}
}
function getPrintDataOfAll(){
var date = document.getElementById('commencing').value;
//alert(date);

showPopWin("getAllPrintDataNotAvailableSlot?date="+date+"", 800, 550, null);


if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = getPrintDataOfAllRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}


function getPrintDataOfAllRequest(){
if (req.readyState == 4) {
		if (req.status == 200) {
		
			
         
         }
	}
}

