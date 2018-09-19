<%@ include file="/common/taglibs.jsp"%>



<head>
    <title><fmt:message key="queryexpire.title"/></title>
    <meta name="heading" content="<fmt:message key='queryexpire.heading'/>"/> 
</head>
<body>
<h2><fmt:message key="queryexpire.title"/></h2><br />
<div id="search">
<form method="get" action="${ctx}/order/queryEXPIREDATE" id="searchForm" >
    <input type="text" size="20" name="q" id="query" value="${param.q}"
           placeholder="Enter Msisdn(+66)" />
    <input type="submit" value="<fmt:message key="button.search"/>"/>    
</form>
</div>

 

<display:table name="queryEXPIREDATE" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="users" pagesize="25" class="table" export="true">
    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="Msisdn" style="width: 34%" />    
    <display:column property="expiredate" escapeXml="true" sortable="true" titleKey="ExpireDate" style="width: 34%" />       
</display:table>

<script type="text/javascript">
	    highlightTableRows("users");
</script>
</body>
