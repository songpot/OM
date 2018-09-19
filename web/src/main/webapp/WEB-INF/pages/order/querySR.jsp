<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="querysr.title"/></title>
    <meta name="menu" content="<fmt:message key='querysr.heading'/>"/> 
</head>
<body>

<h2><fmt:message key="querysr.title"/></h2>
	<div id="search">
		<form class="form-search"  method="get" action="${ctx}/order/querySR" id="searchForm" >		
			<div class="input-append">		 	
				<input class="span8 search-query"  type="text" size="20" name="q" id="query" value="${param.q}"
		     	      placeholder="Enter Msisdn(+66)" />		    	
		    	<input type="submit" class="btn" value="<fmt:message key="button.search"/>"/>
		    </div>
		</form>
	
	</div>	

	<display:table name="querySR" cellspacing="0" cellpadding="0" requestURI="" 
	    defaultsort="1" id="users" pagesize="25" class="table" export="true">
	    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="Msisdn" style="width: 34%" url="/order/querySRDetail?from=list" paramId="msisdn" paramProperty="msisdn"/>    
	    <display:column property="imsi" escapeXml="true" sortable="true" titleKey="Imsi" style="width: 34%" />
	    <display:column property="iccid" escapeXml="true" sortable="true" titleKey="U-SIM" style="width: 34%" />       
	    <display:column property="mvnoCode" escapeXml="true" sortable="true" titleKey="MVNO" style="width: 34%" />
	    <display:column property="mobileType" escapeXml="true" sortable="true" titleKey="MobileType" style="width: 34%" />    
	</display:table>
	
	<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>
	
</body>
