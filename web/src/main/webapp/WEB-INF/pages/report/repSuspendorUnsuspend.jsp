<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="repsuspendorunsuspend.title"/></title>
    <meta name="heading" content="<fmt:message key='repsuspendorunsuspend.heading'/>"/> 
</head>
<link rel="stylesheet" type="text/css" href="<c:url value='/scripts/css/smoothness/jquery-ui-1.10.3.custom.css'/>">  
<script type="text/javascript" src="<c:url value='/scripts/js/jquery-1.9.1.js'/>"></script>  
<script type="text/javascript" src="<c:url value='/scripts/js/jquery-ui-1.10.3.custom.min.js'/>"></script>  
<script type="text/javascript">  
$(function(){  
    $("#datefrom").datepicker({ dateFormat: 'dd/mm/yy' });  
    $("#dateTO").datepicker({ dateFormat: 'dd/mm/yy' });  
});  
</script> 


<div id="search">
<form method="get" action="${ctx}/report/repSuspendorUnsuspend" id="searchForm" >
    Start Date : <input type="text" size="20" name="datefrom" id="datefrom" value="${param.datefrom}"
           placeholder="Date From" /><br />
    
    End Date   : <input type="text" size="20" name="dateTO" id="dateTO" value="${param.dateTO}"
           placeholder="Date To" /><br />   
           
    Operation   : <select name="operationcode" id="operationcode" >
					  <option value="SUSPEND">Suspend</option>
					  <option value="UNSUSPEND">Unsuspend</option>
					  <option value="ALL">All</option>
				  </select><br />  
	       
    <input type="submit" value="<fmt:message key="button.search"/>"/><br />    
</form>
</div>
<br />

<display:table name="repSuspendorUnsuspend" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="users" pagesize="25" class="table" export="true">
    <display:column property="MSISDN" escapeXml="true" sortable="true" titleKey="Msisdn" style="width: 34%" />    
    <display:column property="IMSI" escapeXml="true" sortable="true" titleKey="Imsi" style="width: 34%" />
    <display:column property="OPERATIONCODE" escapeXml="true" sortable="true" titleKey="Operation" style="width: 34%" />
    <display:column property="CWORDERCREATIONDATE" escapeXml="true" sortable="true" titleKey="OrderCreationdate" style="width: 34%" />           
</display:table>

<script type="text/javascript">
    highlightTableRows("users");
</script>

