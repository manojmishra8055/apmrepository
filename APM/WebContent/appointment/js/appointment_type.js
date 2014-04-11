$(document).ready(function(){
	var validator = $("#appointType_form").validate({
		onsubmit: true,
		rules : {
			name : {
				required : true
				
				
			},	
			
			
				
			color : {
				required : true,
				remote: 'CheckColorCodeApp'
				
				},
				
		 duration :{ 
		 		selected : true
		 },
		 
		 charges : {
				 required : true,
				 integer : true
				 
				 }
		
		},
		messages : {
				
				
			name : {
			required : error.name.required
			
				
			},	
			
			color : {
				required : error.color.required,
				remote : error.color.alreadyExist
			},
			duration : {
				selected : error.duration.selected
			},
				
			charges : {
				required : error.charges.required,
				integer : error.charges.integer
			}
		
	},
		
	});
	
	
});	



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
