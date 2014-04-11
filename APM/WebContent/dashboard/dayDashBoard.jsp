<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>Dashboard APM</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="dashboard/css/dailog.css" rel="stylesheet" type="text/css" />
    <link href="dashboard/css/calendar.css" rel="stylesheet" type="text/css" /> 
    <link href="dashboard/css/dp.css" rel="stylesheet" type="text/css" />   
    <link href="dashboard/css/alert.css" rel="stylesheet" type="text/css" /> 
    <link href="dashboard/css/main.css" rel="stylesheet" type="text/css" /> 
     <link rel="icon" href="dashboard/images/icon.ico">

  
</head>
<body>
    <div>

      <div id="calhead" style="padding-left:1px;padding-right:1px;">          
            <div class="cHead"><div class="ftitle">Appointment DashBoard</div>
            <div id="loadingpannel" class="ptogtitle loadicon" style="display: none;">Loading data...</div>
             
            </div>          
            
            <div id="caltoolbar" class="ctoolbar">
              <div id="faddbtn" class="fbutton">
                <div><span title='Click to Create New Event' class="addcal">

                New Event                
                </span></div>
            </div>
            <div class="btnseparator"></div>
             <div id="showtodaybtn" class="fbutton">
                <div><span title='Click to back to today ' class="showtoday">
                Today</span></div>
            </div>
              <div class="btnseparator"></div>

            <div id="showdaybtn" class="fbutton">
                <div><span title='Day' class="showdayview"><a href="dayNotAvailableSlot">Day</a></span></div>
            </div>
              <div  id="showweekbtn" class="fbutton fcurrent">
                <div><span title='Week' class="showweekview">
                	<a href="NotAvailableSlot">Week</a>
				</span></div>
            </div>
              <div  id="showmonthbtn" class="fbutton">
                <div><span title='Month' class="showmonthview">
                	<a href="#" onclick="showdiv()">Block</a>
                	
                </span></div>

            </div><!--
            <div class="btnseparator"></div>
              <div  id="showreflashbtn" class="fbutton">
                <div><span title='Refresh view' class="showdayflash">Refresh</span></div>
                </div>
             <div class="btnseparator"></div>
            <div id="sfprevbtn" title="Prev"  class="fbutton">
              <span class="fprev"></span>

            </div>
            <div id="sfnextbtn" title="Next" class="fbutton">
                <span class="fnext"></span>
            </div>
            <div class="fshowdatep fbutton">
                    <div>
                        <input type="hidden" name="txtshow" id="hdtxtshow" />
                        <span id="txtdatetimeshow">Loading</span>

                    </div>
            </div>
            
            -->
            
            <%String currentDate = DateTimeUtils.getDateinSimpleFormate(new Date());
				String temp[] = currentDate.split(" ");
				String temp1[] = temp[0].split("-");
				String date = temp1[0] + "/" + temp1[1] + "/" + temp1[2];
				
			%>		
             <div class="btnseparator"></div>
             <div  id="showmonthbtn" class="fbutton">
                <div><span  class=""> <input style="height: 12px;
padding: 3px" id="commencing" class="date-pick dp-applied" type="text" value="<%=date %>" name="commencing"></input></span></div>

            </div>
             <div class="btnseparator"></div>
             <div  id="showmonthbtn" class="fbutton">
                <div><span  class="">
                		Dairy User:<s:if test="%{#userList != 'null'}" >
				 					<s:select cssStyle="height: 20px;
padding: 0px" id="diaryUser" name="diaryUser" list="userList" listKey="id" listValue="diaryUser" headerKey="0" theme="simple" headerValue="Select User"   />
								</s:if></span></div>

            </div>
            
            <s:form action="NotAvailableSlot" id="weekfrom">
            	<input type="hidden" name="selectedCommencing" id="selectedCommencing"/>
            	<input type="hidden" name="selecteduserid" id="selecteduserid" />
            </s:form>
            <s:form action="allUserNotAvailableSlot" id="alluserfrm">
            	<input type="hidden" name="selectedCommencing" id="selectedCommencing"/>
            	<input type="hidden" name="selecteduserid" id="selecteduserid" />
            </s:form>
            
           
            
              <div class="btnseparator"></div>
            	 <div  id="showmonthbtn" class="fbutton">
            	 	<div><span  class=""><input id="gobtnid" type="submit" onclick="getDaySearch()" class="gosmall" value = "Go" style="margin-top: 0px; padding: 1px;"/>	
               </span></div>

            </div>
            
             <div class="btnseparator"></div>
            	 <div  id="showmonthbtn" class="fbutton">
                <div><span  class="">
                	<s:submit value=" Preview " onclick="getPrintData()" theme="simple" cssClass="buttons" style="margin-top: -1px; padding: 2px;"></s:submit>						
                	
                </span></div>

            </div>
            
            <div class="clear"></div>
            </div>
      </div>    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
     
</div>
    
</body>
</html>
