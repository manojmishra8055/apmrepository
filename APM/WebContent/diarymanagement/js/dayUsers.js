function getDaySearch(){
	 		actionType =  2;
			var date = document.getElementById("commencing").value;
			var id = document.getElementById('diaryUser').value;
			var count = 0;
			for(i=1;i<=17;i++){
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
				/*var mm = tempDate[1];
				var yy = tempDate[2];
				var dd = parseInt(tempDate[0]) + j;
				//date = dd + "/" + mm + "/" + yy;
				date = getCalDate(dd,mm,yy)*/
				
				date = tempDate[0] + "-" + tempDate[1] +  "-" + tempDate[2];
				
				setDayJsoData(id,date);
			
			
			
}


function setDayJsoData(diaryUserId,date){

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
                          	
                          
                          		
                         		var col = 1;
                          		//start time diff
                          		var stdiff = parseInt(value.starttime) - 8
                          		stdiff = (parseInt(stdiff) * 1) + parseInt(col);
                          		var tempStdiff = stdiff;
                          		
                          		//end time diff
                          		var etdiff = parseInt(value.endtime) - 8
                          		etdiff = (parseInt(etdiff) * 1) + parseInt(col);
                          		
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
								for (i=parseInt(stdiff);i<=parseInt(etdiff);i=(i+1)){
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
											stdiff = parseInt(stdiff) + 1;
											
										}
										
										
									}
									
								setDayUserjsonAvailableData(value.id,value.starttime,value.endtime,value.apmtduration,value.location,value.diaryUser,diaryUserId,col,value.practitionerid,1,value.commencing);
								
								
								
							
							
							
							
                        });        
                     });
			
		}
	});
			
			
}	



function setDayUserjsonAvailableData(diaryuserid,starttime,endtime,appointmentduration,location,diaryusername,userid,col,practitionerid,size,commencing){

	

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
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing);
												setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing,starttime,value.treatmentepisodeid,value.iscompleted);
												
											}
										}else if(value.status == 1){
											$(document.getElementById(jcount+'min'+stdiff)).css('background-color', 'rgb(236, 147, 147)');
											document.getElementById(jcount+'min'+stdiff).ondblclick = function() {
												document.getElementById('blockdiv').style.display = 'none';
												document.getElementById('reminderPopup').style.display = 'none';
											
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,commencing);
												//setModifyPopup(value.status,value.starttime,value.endtime,value.duration,value.clientname,value.notes,value.apmttype,value.id,value.arrivedstatus,value.dna,userid,value.clientId,value.commencing,value.practitionerEmail,value.clientEmail,value.charge,commencing);
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
                          			}
                          			
                          			$(document.getElementById(stemp[1]+'min'+stdiff)).css('border-radius', '0px');
									$(document.getElementById(etemp[1]+'min'+stdiff)).css('border-radius', '0px');
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
									document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' + value.clientname +","+""+value.notes+"" + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
									document.getElementById(stext+'min'+tempStdiff).title = value.notes + "," + "["+value.apmttype+"]";
								}else{
									document.getElementById(stext+'min'+tempStdiff).innerHTML = '<div class="green">' +  value.notes + ","+value.starttime+"," + ""+value.duration+" Min" + '</div>';
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

