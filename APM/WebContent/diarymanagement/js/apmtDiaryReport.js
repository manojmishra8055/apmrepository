$(document).ready(function(){
	
	var validator = $("#apmtDiaryReport_frm").validate({
		onsubmit: true,
		rules : {
			diaryUser : {
				selected : true
				
			},	
			
			fromDate : {
				required : true
			},
			
			toDate : {
              required: true
             
          	},
          	
          	
 },
		
		
		messages : {	
			diaryUser : {
				selected : error.diaryUser.selected
			},	
			fromDate : {
				required : error.fromDate.required
			},	
			toDate : {
				required : error.toDate.required
				
			},
			
			
			
			
		},
		
	});
	
	
});	