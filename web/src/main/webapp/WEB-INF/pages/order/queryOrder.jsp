<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="queryerror.title"/></title>
    <meta name="heading" content="<fmt:message key='queryorder.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script
	src="<c:url value='/scripts/latest-jquery/jquery-1.5.1.min.js'/>"
	type="text/javascript"></script>
    <script type="text/javascript">   
    $(document).ready(function() {
    	
    	var callbackorder = "";
    	var CALLBACK_API_URL = "../api/callbackOrder?input=";
    	
    	$('[name="selectall"]').change(function() {
	    	  if ($(this).is(':checked')) {
	    		  	$('.selectableCheckbox').attr('checked', true);
	    		  } else {
	    			$('.selectableCheckbox').attr('checked', false);
	    		  }
	    });
    	
    	$('[name="callbackorder"]').click(function() {    	    		
    		
    		var callbackorder = "";
    		var i=0;
    		$('[name="checkbb[]"]:checked').each(function () {
    			if(i==0)    				
    				callbackorder = callbackorder + $(this).val();
    			else
    				callbackorder = callbackorder +","+ $(this).val();
    			i++;
    		});
    		
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : CALLBACK_API_URL+callbackorder,
				dataType: 'json',
				cache: false,
				timeout : 500000,
				success : function(result) {
						console.log("SUCCESS: ", result);
						window.location.href = "queryOrder";					
					},
					error : function(e) {
						console.log("ERROR: ", e);
						alert(e);
					},
					done : function(e) {
						console.log("DONE");
					}  
    		});
    		
	    }); 
    	
    	
    	var showselectall = ${showselectall};
        if(!showselectall)                   	
        	$('[name=callbackorder]').hide();	        
        
        var errorsize = ${errorsize};
        if(errorsize==0)        
        	$('[name=callbackorder]').attr( "disabled", true );       
        
    	
    });	        
    </script>
</head>
<body>
<h2><fmt:message key="queryorderform.title"/></h2><br />
<div id="search">
<form class="form-search" method="get" action="${ctx}/order/queryOrder" id="searchForm">
	<div class="input-append">
	    <input type="text" class="span8 search-query" size="20" name="q" id="query" value="${param.q}"
	           placeholder="MSISDN OR OMORDERID"/>
	    <input class="btn" type="submit" value="<fmt:message key="button.search"/>"/>
	</div>
</form>
</div>

<display:table name="queryOrder" cellspacing="0" cellpadding="0" requestURI="" sort="list"  id="queryOrder" pagesize="25" class="table" export="true">   
     <c:if test="${showselectall}">
	   <display:column title="<input type='checkbox' name='selectall' />" media="html">
	          <input type="checkbox" name="checkbb[]" value="${queryOrder.CWORDERID}" class="selectableCheckbox" />
		</display:column>
	</c:if>    
    <display:column property="CWORDERID" escapeXml="true" sortable="true" titleKey="OM ORDERID" style="width: 25%"
        url="/order/queryOrderForm" paramId="CWORDERID" paramProperty="CWORDERID"/>      
    <display:column property="OPERATIONCODE" escapeXml="true" sortable="true" titleKey="OPERATION" style="width: 25%"
        url="/order/queryOrderForm" paramId="CWORDERID" paramProperty="CWORDERID"/>
    <display:column property="SOURCESYSTEMID" escapeXml="true" sortable="true" titleKey="SOURCESYSTEM" style="width: 25%"
        url="/order/queryOrderForm" paramId="CWORDERID" paramProperty="CWORDERID"/>
    <display:column property="CWORDERCREATIONDATE" escapeXml="false" sortable="true" titleKey="CREATE DATE" style="width: 25%"
        url="/order/queryOrderForm" paramId="CWORDERID" paramProperty="CWORDERID" format="{0,date,dd-MM-yyyy HH:mm:ss}"/>
</display:table>
	<br />
	<div class="input-append">
    	<input type="button" class="btn btn-primary" name="callbackorder"  value="Callback"/>        
    </div>
    <br />
        

<script type="text/javascript">
    highlightTableRows("users");
</script>
</body>
