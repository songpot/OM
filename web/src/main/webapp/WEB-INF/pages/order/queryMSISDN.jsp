<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="querymsisdn.title"/></title>
    <meta name="heading" content="<fmt:message key='querymsisdn.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
</head>
<body>
<h2><fmt:message key="querymsisdn.title"/></h2><br />
<div id="search">
	<form class="form-search" method="get" action="${ctx}/order/queryMSISDN" id="searchForm">
	 	<div class="input-append">
		    <input type="text"  class="span8 search-query" size="20" name="q" id="query" value="${param.q}"
		           placeholder="msisdn / pattern"/>
		    <input class="btn" type="submit" value="<fmt:message key="button.search"/>"/>
		</div>
	</form>
</div>

<display:table name="queryMSISDN" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="queryMSISDN" pagesize="25" class="table" export="true">
    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="querymsisdn.msisdn" style="width: 25%"
        url="/order/activateDynamic" paramId="msisdn" paramProperty="msisdn"/>    
</display:table>


<script type="text/javascript">
    highlightTableRows("users");
</script>
</body>
