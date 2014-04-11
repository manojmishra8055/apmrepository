function showApmtDiaryReport(){

var fromDate = document.getElementById('fromDate').value;
var toDate = document.getElementById('toDate').value;
var diaryUserId = document.getElementById('diaryUser').value;

alert(fromDate);
alert(toDate);
alert(diaryUserId);

var url = "showApmtDiaryReport?fromDate="+fromDate+"&toDate="+toDate+"&diaryUserId="+diaryUserId+"";

   
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) {
		isIE = true;
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}   
               
    req.onreadystatechange = showApmtDiaryReportRequest;
    req.open("GET", url, true); 
              
    req.send(null);

}

function showApmtDiaryReportRequest(){
	if (req.readyState == 4) {
		if (req.status == 200) {
			
			
			
			
		}
	}
}

function showPreview(){
	var fromDate = document.getElementById('fromDate').value;
	var toDate = document.getElementById('toDate').value;
	var diaryUserId = document.getElementById('diaryUser').value;
	showPopWin("reportPreviewApmtDiaryReport?fromDate="+fromDate+"&toDate="+toDate+"&diaryUserId="+diaryUserId+"", 800, 550, null);
}