<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.ArrayList"%>
<%@page import = "java.util.Date"%>
<%@page import="com.apm.common.utils.DateTimeUtils"%>
<%@page import="com.apm.DiaryManagement.eu.entity.DiaryManagement"%>



<link href="common/css/datePicker1.css" rel="stylesheet"/>
<script src="common/js/date.js" type="text/javascript"></script>
<script src="common/js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script src="common/js/CalenderPicture.js" type="text/javascript"></script>
<link href="diarymanagement/css/popupstyle.css" rel="stylesheet" type="text/css" />
<link href="diarymanagement/css/subModal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="diarymanagement/js/common.js"></script>
<script type="text/javascript" src="diarymanagement/js/subModal.js"></script>




<script type="text/javascript" src="diarymanagement/js/alldiaryuser.js"></script>

<script type="text/javascript" src="diarymanagement/js/nonavailableslot.js"></script>
<script type="text/javascript" src="diarymanagement/js/notavailableslotpopupscript.js"></script>

<iframe id="background">
</iframe>

<div id="login_main" class="main_layoutdash_content">

	

	<!--<h2 class="title" >Appointment Dairy</h2>
	
		<div class="menu">
		<input type="submit" value="New" onclick="showPopWin('newAppoinmentNotAvailableSlot', 500, 400, null);" disabled="disabled" class="buttons">
		<input type="submit" value="Modify" onclick="$(this).MessageBox()" disabled="disabled" class="buttons">
		<input type="submit" value="Delete" disabled="disabled" class="buttons">
		
		<input type="submit" value="Block" onclick="showdiv()" class="buttons">
		
		
		<a href="allUserNotAvailableSlot"><input type="button" style="text-decoration: none" value="All Show" class="allShowButtons"/></a> 
		<a href="dayNotAvailableSlot"><input type="button" style="text-decoration: none" value="Day Work" class="allShowButtons"></a> 
		<a href="NotAvailableSlot"><input type="button" style="text-decoration: none;" value="User Work Week" class="allShowButtons"> </a>
	  </div>
	
	--><div id="login" class="blockdash_div">
		<s:if test="hasActionMessages()"> 
			<div id="common_message" class="message">
				<s:actionmessage id="common_message_text" theme="simple"/>
			</div>
		</s:if> 
		
		<span class="error"><s:actionerror id="server_side_error"/></span>
		
	
		
<!-- popup div -->	


	
		<%@ include file="/diarymanagement/pages/commonAppointmentView.jsp" %>
		
			<%@ include file="/dashboard/Dashboard.jsp" %><!--		
		
		
		<div class="form_elements" >	
			
								
			<div class="dairyuser">
				Date: <s:textfield id="commencing" cssClass="date-pick dp-applied"  name="commencing" ></s:textfield>
				<input type="button" value="Show" onclick="showAvailiability()" class="buttons">
				<input type="button" value="Preview" onclick="getPrintDataOfAll()" class="buttons"/>
					
			</div>
			--><br><br>
			
			<s:form action="allUserNotAvailableSlot" theme="simple">
			<script type="text/javascript">
				function showAvailiability(){
				
				actionType = 1;
				
					<%ArrayList<DiaryManagement>list = (ArrayList<DiaryManagement>)session.getAttribute("allDiaryUser"); int col = 1; int length = 17*list.size();%>
					var length = <%=length%>
					
					for(i=1;i<=length;i++){
						$(document.getElementById(i)).css('border-bottom', '1px solid #DFD8D4');
						document.getElementById(i).ondblclick = '';
						for(j=0;j<=11;j++){
							count = 5*j;
							$(document.getElementById(count+'min'+i)).css('background-color', 'white');
							document.getElementById(count+'min'+i).innerHTML = '';
							$(document.getElementById(count+'min'+i)).css('border-bottom', '');
							count = parseInt(count)+1;
						}
					}
					
					<%if(list.size()!=0){%>
						<%for(DiaryManagement diaryManagement : list){%>
							setjsonDataAllUser(<%=diaryManagement.getId()%>,document.getElementById('commencing').value,<%=col%>,<%=list.size()%>);
						<%col++;}%>
						
					<%}%>
				}
					
			</script>
			
			<table width="100%" cellpadding="0" cellspacing="0" class="timer-table" id = "tab1" style="table-layout: fixed;">
				<col width="3%"/>
				<s:iterator value="userList" status="rowstatus">
					<col width="10%"/>
				</s:iterator>
				
				
				
				<tr>
					<th style="background-color: #E8F1F8"></th>
					<s:iterator value="userList" status="rowstatus">
						<input type="hidden" name="diaryUser" id="diaryUser">
						<th style="width: 99px;"><s:property value="diaryUser"/></th>
					</s:iterator>
					
				</tr>
				
				<% int ct=8; 
					int countslot = 1;
					
					int size = (Integer)session.getAttribute("userListSize");
					String tempCt = "";
					String tempMinute = "";
				%>
				
				<%for(int i=1;i<=17;i++){ %>
				
					<tr>
					
						<td style="font-size: 18px; font-weight: bold; text-align: center; background-color: #E8F1F8" valign="top"><%=ct %>:00</td>
						
						<s:iterator value="userList" status="rowstatus">
							<td  valign="top" id="<%=countslot %>">
								<%for(int k=0;k<=11;k++){ %>
        								<%
											tempCt =  Integer.toString(ct);
											tempMinute = Integer.toString((5*k));
											if(ct <= 9) {
												tempCt = "0" + Integer.toString(ct);
											}
											if((5*k) <= 9) {
												tempMinute = "0" + Integer.toString((5*k));
											}
										%>
											
										
										<%if(k==6){ %>
											<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=tempCt %>:<%=tempMinute %>" style="background-image: url('diarymanagement/img/line.png');background-repeat:repeat-x; " ></div>
										<%}else{ %>
											<div id="<%=(5*k) %>min<%=countslot %>"  class="yellow" title="<%=tempCt %>:<%=tempMinute %>" ></div>
										<% }%>
        						<% }%>
								
							</td>
							<%countslot++; %>
						</s:iterator>
						
						
						<%ct++; %>
					
					</tr>
					
				<% }%>
				
			</table>
		
		</s:form>
		
				
</div>
</div>			
		
