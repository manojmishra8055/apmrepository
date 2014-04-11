$(document).ready(function(){
	
	var validator = $("#apmtDiaryReport_frm").validate({
		onsubmit: true,
		rules : {
			fromDate : {
				required : true
			},	
			toDate : {
				required : true
				
			},
			diaryUser :{ 
		 		selected : true
		 	},
			
			
			
				
		},
		
		
		messages : {	
			fromDate : {
				required : error.fromDate.required
			},	
			fromDate : {
				required : error.fromDate.required
				
			},
			diaryUser : {
				selected : error.duration.selected
			},
			
			
		},
		
	});
	
	
});	
