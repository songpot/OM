<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="queryoldorder.title"/></title>
    <meta name="heading" content="<fmt:message key='queryoldorder.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/scripts/css/smoothness/jquery-ui-1.10.3.custom.css'/>">  
	<script type="text/javascript" src="<c:url value='/scripts/js/jquery-1.9.1.js'/>"></script>  
	<script type="text/javascript" src="<c:url value='/scripts/js/jquery-ui-1.10.3.custom.min.js'/>"></script>  
	<script type="text/javascript">  
		$(function(){  
			var startDateTextBox = $('#startdate');
			var endDateTextBox = $('#enddate');

			startDateTextBox.datepicker({ 
				dateFormat: 'yy-mm-dd',
				maxDate:0,
				onClose: function(dateText, inst) {
					if (endDateTextBox.val() != '') {
						var testStartDate = startDateTextBox.datetimepicker('getDate');
						var testEndDate = endDateTextBox.datetimepicker('getDate');
						if (testStartDate > testEndDate)
							endDateTextBox.datetimepicker('setDate', testStartDate);
					}
					else {
						endDateTextBox.val(dateText);
					}
				},
				onSelect: function (selectedDateTime){
					endDateTextBox.datetimepicker('option', 'minDate', startDateTextBox.datetimepicker('getDate') );
				}
			});
			endDateTextBox.datepicker({ 
				dateFormat: 'yy-mm-dd',
				onClose: function(dateText, inst) {
					if (startDateTextBox.val() != '') {
						var testStartDate = startDateTextBox.datetimepicker('getDate');
						var testEndDate = endDateTextBox.datetimepicker('getDate');
						if (testStartDate > testEndDate)
							startDateTextBox.datetimepicker('setDate', testEndDate);
					}
					else {
						startDateTextBox.val(dateText);
					}
				},
				onSelect: function (selectedDateTime){
					startDateTextBox.datetimepicker('option', 'maxDate', endDateTextBox.datetimepicker('getDate') );
				}
			}); 
		});  
	</script> 
        
</head>

<body>
<h2><fmt:message key="queryoldorder.title"/></h2><br />
<form method="get" action="${ctx}/order/queryoldOrder" id="searchForm">
	<table border="0.5">
					<tr>
						<td><appfuse:label styleClass="desc" key="Msisdn" /></td>
						<td><input type="text" size="20" name="msisdn" id="msisdn" value="${param.msisdn}"
           					placeholder="MSISDN(66xxxxxxxxx)"/></td>
           				<td><appfuse:label styleClass="desc" key="Imsi" /></td>
						<td><input type="text" size="20" name="imsi" id="imsi" value="${param.imsi}"
           					placeholder="IMSI(52015xxxxxxxxx)"/></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="desc" key="Order ID" /></td>
						<td><input type="text" size="20" name="orderid" id="orderid" value="${param.orderid}"
           					placeholder="OrderID"/></td>
           				<td><appfuse:label styleClass="desc" key="User ID" /></td>
						<td><input type="text" size="20" name="userid" id="userid" value="${param.userid}"
           					placeholder="Order UserID"/></td>
					</tr>
    				<tr>
						<td><appfuse:label styleClass="desc" key="OM OrderID" /></td>
						<td><input type="text" size="20" name="cworderid" id="cworderid" value="${param.cworderid}"
           					placeholder="OM OrderID"/></td>
           				<td><appfuse:label styleClass="desc" key="Operation" /></td>
						<td><select path="operationcode" name="operationcode" id="operationcode" cssClass="large" cssErrorClass="large error" value="${param.operationcode}" >
						        	<option value="ALL"></option>
						        	<option value="ADDSUB">Add Subscriber</option>
						        	<option value="DELSUB">Disconnect Subscriber</option>
						        	<option value="MODPLAN">Change Plan</option>
						        	<option value="MODVAS">Change VAS</option>
						        	<option value="MODPCS">Change PCS</option>
						        	<option value="MODBARSTATE">Change Barring State</option>
						        	<option value="SUSPEND">Suspend Services</option>
						        	<option value="UNSUSPEND">UnSuspend Services</option>
						        	<option value="TREATMENTBAR">Treatment Barring</option>
						        	<option value="TREATMENTUNBAR">Treatment UnBarring</option>
						        	<option value="MODMOBILETYPE">Change Mobile Type</option>
						        	<option value="MODMSISDN">Change MSISDN</option>
						        	<option value="MODSIM">Change SIM</option>
						        	<option value="MODSUBINFO">Change Subscriber Information</option>
						        	<option value="MODROAMINGAREA">Change Roaming Area</option>
						   </select></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="desc" key="Mvno" /></td>
						<td><select path="mvnoid" id="mvnoid" name="mvnoid" cssClass="large" cssErrorClass="large error" value="${param.mvnoid}" >
						        	<option value="ALL"></option>
						        	<option value="11">TOT3G</option>
						        	<option value="21">Imobile</option>
						        	<option value="31">IEC</option>
						        	<option value="41">LOXLEY</option>
						        	<option value="51">365</option>
						        	<option value="61">MCONSULT</option>        	
						   </select></td>
						<td><appfuse:label styleClass="desc" key="Mobile Type" /></td>
						<td><select path="mobiletype" name="mobiletype" id="mobiletype" cssClass="large" cssErrorClass="large error" value="${param.mobiletype}" >
						        	<option value="ALL"></option>
						        	<option value="PRE">Prepaid</option>
						        	<option value="POST">Postpaid</option>     	
						   </select></td>
					</tr>	
					<tr>
						<td><appfuse:label styleClass="desc" key="Created>=" /></td>
						<td><input type="text" size="20" name="startdate" id="startdate" value="${param.startdate}"
           					placeholder="Start Date"/></td>
						<td><appfuse:label styleClass="desc" key="Created<=" /></td>
						<td><input type="text" size="20" name="enddate" id="enddate" value="${param.enddate}"
           					placeholder="End Date"/></td>
					</tr>				
					<tr>
						<td><input type="submit" value="<fmt:message key="button.search"/>"/></td>	
						<td colspan="3" ><appfuse:label styleClass="desc" key="Lastest Order Date : ${orderMaxDate}" /></td>							
					</tr>
			</table>
</form>
<div id="search"></div>
<display:table name="queryOrder" cellspacing="0" cellpadding="0" requestURI="" 
     id="queryOrder" pagesize="25" class="table" export="true" sort="list">   
    <display:column property="MSISDN" escapeXml="true" sortable="true" titleKey="MSISDN" style="width: 25%"/>
    <display:column property="IMSI" escapeXml="true" sortable="true" titleKey="IMSI" style="width: 25%"/>
    <display:column property="CWORDERID" escapeXml="true" sortable="true" titleKey="OM ORDERID" style="width: 25%"/>
    <display:column property="ORDERUSERID" escapeXml="true" sortable="true" titleKey="ORDERUSERID" style="width: 25%"/>      
    <display:column property="OPERATIONCODE" escapeXml="true" sortable="true" titleKey="OPERATIONCODE" style="width: 25%"/>    
    <display:column property="SOURCESYSTEMID" escapeXml="true" sortable="true" titleKey="SOURCESYSTEM" style="width: 25%"/>      
    <display:column property="CWORDERCREATIONDATE" escapeXml="false" sortable="true" titleKey="CREATEDATE" style="width: 30%" format="{0,date,dd-MM-yyyy HH:mm:ss}" /> 
</display:table>


<script type="text/javascript">
    highlightTableRows("users");
</script>
</body>
