<%@ include file="/common/taglibs.jsp"%>



<head>
    <title><fmt:message key="queryiptvhistory.title"/></title>
    <meta name="heading" content="<fmt:message key='queryiptvhistory.heading'/>"/> 
</head>

<div id="search">
<form method="get" action="${ctx}/report/queryIPTVHISTORY" id="searchForm" >
    <input type="text" size="20" name="q" id="query" value="${param.q}"
           placeholder="Enter Msisdn(+66)" />
    <input type="submit" value="<fmt:message key="button.search"/>"/>    
</form>
</div>

 

<display:table name="queryIPTVHISTORY" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="users" pagesize="25" class="table" export="true">
    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="Msisdn" style="width: 34%" url="/report/queryIPTVHISTORYForm" paramId="iptvreport_ID" paramProperty="iptvreport_ID" />    
    <display:column property="createdate" escapeXml="true" sortable="true" titleKey="Creation Date" style="width: 34%" url="/report/queryIPTVHISTORYForm" paramId="iptvreport_ID" paramProperty="iptvreport_ID" />          
</display:table>

<script type="text/javascript">
	    highlightTableRows("users");
</script>
