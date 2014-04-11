var tempCount = 0;
var month = 0;
var ct = 0;
var year = 0;
var startValue = 1;

/* 
 * hide or show dialog box on delete event
 * 
 * */
displayTooltip = false;
var messageDelay = 10000;
jQuery.fn.center = function () {
		
		this.css("position","absolute");
		//this.css("top", ( $(window).height() - this.height() ) / 2+$(window).scrollTop() + "px");
		this.css("left", ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px");
		
		return this;
	};
	

$(document).ready(function(){
	$("#previewDiv").hide();
	
});		
	
	
function goClose(){
	
	$("#background").fadeOut("slow");
	$("#previewDiv").hide();
	window.location.reload();
	//document.getElementById('calander').style.display = "";
	//$(document.getElementById("c"+tempCount)).css('background-color', '');
	
	
	
}

var tempusername = "";
var tempdate = "";
var tempyear = "";
var tempdiaryuserid = "";
var temptdcode = "";

function goPreview(username,date,year,diaryuserid,tdcode){

	
	tempusername = username;
	tempdate = date;
	tempyear = year;
	tempdiaryuserid = diaryuserid;
	temptdcode = tdcode;
	
	
	$("#background").css({"opacity" : "0.7"}).fadeIn("slow");			
	$("#previewDiv").center().fadeIn("slow");
	
	document.getElementById('diaryUser').value = username;
	document.getElementById('diaryuserid').value = diaryuserid;
	document.getElementById('tdcode').value = tdcode;
	
	var str = date.split(" ");
	var commencing = str[1] + "/" + str[0] + "/" + year;
	document.getElementById('commencing').value = commencing;
	
	var caldate = parseInt(str[1]);
	
	
	
	document.getElementById('mon_id').innerHTML = "Monday"  + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('tue_id').innerHTML = "Tuesday"  + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('wed_id').innerHTML = "Wednesday" + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('thu_id').innerHTML = "Thursday" + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('fri_id').innerHTML = "Friday" + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('sat_id').innerHTML = "Saturday" + " " + caldate;
		caldate = caldate+1;
		caldate = getCalDate(caldate,str[0],year);
	document.getElementById('sun_id').innerHTML = "Sunday" + " " + caldate;
	
	//clear all td color
	var i=0;
	/*for(i=1;i<=119;i++){
		$(document.getElementById(i)).css('background-color', '');
		document.getElementById(i).innerHTML = "";
	}*/
	
	/*var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass { background-color: yellow; padding: 0px; margin: 0px; text-align:center }';
	document.getElementsByTagName('head')[0].appendChild(style);
	
	
	document.getElementById('2').className = 'cssClass';
	
   	document.getElementById('60min2').className = 'cssClass1';
   	document.getElementById('55min2').className = 'cssClass1';
   	document.getElementById('50min2').className = 'cssClass1';
   	document.getElementById('45min2').className = 'cssClass1';*/
	
	setJsoData(diaryuserid,tdcode);
		
	//$("#calander").hide();
	
	
	
	
}


//data repeat by week function 
function repeatByWeek(){
	var tdcode = temptdcode;
	var weekNumber =document.getElementById('weekNumber').value;
	var diaryYear = document.getElementById('diaryYear').value;
	var diaryUser = document.getElementById('diaryUser').value;
	
	var url = "repeatslotDiaryMangent?tdcode="+tdcode+"&weekNumber="+weekNumber+"&diaryYear="+diaryYear+"&diaryUserid="+tempdiaryuserid+"&diaryUser="+diaryUser+" ";
   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = repeatByWeektRequest;
    req.open("GET", url, true); 
              
    req.send(null);
} 

function repeatByWeektRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			alert("Appointment slot has been repeated successfully!!");
			window.location.reload();
		}
	}
}


	var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass {padding: 0px; margin: 0px; height:144px; text-align:center }';
	document.getElementsByTagName('head')[0].appendChild(style);
	
	var style = document.createElement('style');
	style.type = 'text/css';
	style.innerHTML = '.cssClass1 { min-height:12px }';
	document.getElementsByTagName('head')[0].appendChild(style);
	var time=0;
function setJsoData(diaryuserid,tdcode){
	$.ajax({
		url: "diarymanagement/pages/JQGridMaster.jsp?diaryuserid="+diaryuserid+"&tdcode="+tdcode+" " ,
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
									$(document.getElementById(i)).css('font-size', '10px');
									document.getElementById(i).className = 'cssClass';
									document.getElementById(i).onclick = "";
									//document.getElementById(i).ondblclick = function() {
									//	$(this).MessageBox(value.weekfullname,col,action,value.id,stdiff,value.starttime,value.endtime,value.apmtduration,value.location,value.onlinebooking,time);
									//}
									
								}
								
								
									var jcount = 0;
									
									divlength = divlength - 1;
									
									for(j=0;j<=divlength;j++){
										jcount = 5*parseInt(slength);
										
										document.getElementById(jcount+'min'+stdiff).className = 'cssClass1';
										$(document.getElementById(jcount+'min'+stdiff)).css('background-color', value.color);
										slength = parseInt(slength) + 1;
										document.getElementById(jcount+'min'+stdiff).onclick = "";
										document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
											$(this).MessageBox(value.weekfullname,col,action,value.id,stdiff,value.starttime,value.endtime,value.apmtduration,value.location,value.onlinebooking,time);
										}
										if(jcount==55){
											slength = 0;
											divlength = parseInt(divlength) - j;
											j = 0;
											stdiff = parseInt(stdiff) + 7;
											
										}
										
										
									}
									
								
								//write text 
                          		if(parseInt(stemp[1]) >= 45){
                          			tempStdiff = parseInt(tempStdiff)+7;
                          			stemp[1] = 5;
                          		}
                          		
								var stext = parseInt(stemp[1]);
								var apttime = value.starttime + "-" + value.endtime + "," + value.location;
								
								document.getElementById(stext+'min'+tempStdiff).innerHTML = apttime;
								//stext = parseInt(stext)+5;
								//document.getElementById(stext+'min'+tempStdiff).innerHTML = "("+value.apmtduration+"min)";
								//stext = parseInt(stext)+5;
								//document.getElementById(stext+'min'+tempStdiff).innerHTML = value.location;
								
								
							}//col 1
							
							if(value.weekfullname == "Tuesday"){
                          		var col = 2;
                          		setWeekTimer(value.weekfullname,2,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 2
							
							if(value.weekfullname == "Wednesday"){
                          		var col = 3;
                          		setWeekTimer(value.weekfullname,3,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 3
							
							if(value.weekfullname == "Thursday"){
                          		var col = 4;
                          		setWeekTimer(value.weekfullname,4,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 4
							
							if(value.weekfullname == "Friday"){
                          		var col = 5;
                          		setWeekTimer(value.weekfullname,5,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 5
							
							if(value.weekfullname == "Saturday"){
                          		var col = 6;
                          		setWeekTimer(value.weekfullname,6,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 6
							
							if(value.weekfullname == "Sunday"){
                          		var col = 7;
                          		setWeekTimer(value.weekfullname,7,value.starttime,value.endtime,value.id,value.apmtduration,value.location,value.onlinebooking,value.color)
							}//col 7
							
							
                        });        
                     });
			
		}
	});
	
	}



function setWeekTimer(weekfullname,col,starttime,endtime,id,apmtduration,location,onlinebooking,color){
	
	//var col = 1;
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
		$(document.getElementById(i)).css('font-size', '10px');
		document.getElementById(i).className = 'cssClass';
		document.getElementById(i).onclick = "";
		//document.getElementById(i).ondblclick = function() {
		//	$(this).MessageBox(weekfullname,col,action,id,stdiff,starttime,endtime,apmtduration,location,onlinebooking,time);
		//}
		
	}


	var jcount = 0;
	
	divlength = divlength - 1;
	
	for(j=0;j<=divlength;j++){
		jcount = 5*parseInt(slength);
		
		document.getElementById(jcount+'min'+stdiff).className = 'cssClass1';
		$(document.getElementById(jcount+'min'+stdiff)).css('background-color', color);
		slength = parseInt(slength) + 1;
		document.getElementById(jcount+'min'+stdiff).onclick = "";
		document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
			$(this).MessageBox(weekfullname,col,action,id,stdiff,starttime,endtime,apmtduration,location,onlinebooking,time);
		}
		if(jcount==55){
			slength = 0;
			divlength = parseInt(divlength) - j;
			j = 0;
			stdiff = parseInt(stdiff) + 7;
			
		}
		
		
	}
	

	//write text 
	if(parseInt(stemp[1]) >= 45){
		tempStdiff = parseInt(tempStdiff)+7;
		stemp[1] = 5;
	}
                  		
	var stext = parseInt(stemp[1]);
	var apttime = starttime + "-" + endtime + "," + location;
	
	document.getElementById(stext+'min'+tempStdiff).innerHTML = apttime;
	//stext = parseInt(stext)+5;
	//document.getElementById(stext+'min'+tempStdiff).innerHTML = "("+apmtduration+"min)";
	//stext = parseInt(stext)+5;
	//document.getElementById(stext+'min'+tempStdiff).innerHTML = location;
	
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

//get caldate
function getCalDate(caldate,month,year){
	if((month=="Jan") || (month=="Mar") || (month=="May") || (month=="July") || (month=="Aug") || (month=="Oct") ||  (month=="Dec")){
		if(caldate > 31){
			caldate =  parseInt(caldate) - 1
			caldate =  parseInt(caldate) - 30 
		}
	}else if(month=="Feb"){
		if(parseInt(year)%4==0){
			
			if(caldate > 29){
				//caldate =  parseInt(caldate) - 1
				caldate =  parseInt(caldate) - 29 
			}
		}else{
		
			if(caldate > 28){
				//caldate =  parseInt(caldate) - 1
				caldate =  parseInt(caldate) - 28
				 
			}
		}
	
	}else{
		if(caldate > 30){
			caldate =  parseInt(caldate) - 1
			caldate =  parseInt(caldate) - 30 
			
			
		}
	}
	
	return caldate;
}


function getMonthNumber(month){
	var result = 0;
	if(month=="Jan")
		result = 01;
	if(month=="Feb")
		result = 02;
	if(month=="Mar")
		result = 03;
	if(month=="Apr")
		result = 04;
	if(month=="May")
		result = 05;
	if(month=="Jun")
		result = 06;
	if(month=="Jul")
		result = 07;
	if(month=="Aug")
		result = 08;
	if(month=="Sep")
		result = 09;
	if(month=="Oct")
		result = 10;
	if(month=="Nov")
		result = 11;
	if(month=="Dec")
		result = 12;
		
		return  result;
}

