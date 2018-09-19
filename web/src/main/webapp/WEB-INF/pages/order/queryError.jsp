<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="queryerror.title"/></title>
    <meta name="heading" content="<fmt:message key='queryerror.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <meta http-equiv="refresh" content="300000">    
    <script
	src="<c:url value='/scripts/latest-jquery/jquery-1.5.1.min.js'/>"
	type="text/javascript"></script>
    <script type="text/javascript">   
    $(document).ready(function() {
    	
    	var repeatorder = "";
    	var REPEAT_API_URL = "../api/repeatStepOrder?input=";
    	var GO_API_URL = "../api/gonextStepOrder?input=";
    	var CANCEL_API_URL = "../api/cancelOrder?input=";
    	
    	$('[name="selectall"]').change(function() {
	    	  if ($(this).is(':checked')) {
	    		  	$('.selectableCheckbox').attr('checked', true);
	    		  } else {
	    			$('.selectableCheckbox').attr('checked', false);
	    		  }
	    });
    	
    	$('[name="repeatorder"]').click(function() {    	    		
    		
    		var repeatorder = "";
    		var i=0;
    		$('[name="checkbb[]"]:checked').each(function () {
    			if(i==0)    				
    				repeatorder = repeatorder + $(this).val();
    			else
    				repeatorder = repeatorder +","+ $(this).val();
    			i++;
    		});
    		
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : REPEAT_API_URL+repeatorder,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {
						console.log("SUCCESS: ", result);
						location.reload();						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
					}  
    		});
    		
	    }); 
    	
    	
    	$('[name="gonextorder"]').click(function() {
    		
    		if (!confirm("Are you sure to Gonextstep Order")) 
				return false;
    		
    		var repeatorder = "";
    		var i=0;
    		$('[name="checkbb[]"]:checked').each(function () {
    			if(i==0)    				
    				repeatorder = repeatorder + $(this).val();
    			else
    				repeatorder = repeatorder +","+ $(this).val();
    			i++;
    		});
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : GO_API_URL+repeatorder,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {
						console.log("SUCCESS: ", result);
						location.reload();						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
					}  
    		});
    		
	    });    	    	
    	
    	$('[name="cancelorder"]').click(function() {
    		
    		if (!confirm("Are you sure to Cancel Order")) 
				return false;
    			
    		var repeatorder = "";
    		var i=0;
    		$('[name="checkbb[]"]:checked').each(function () {
    			if(i==0)    				
    				repeatorder = repeatorder + $(this).val();
    			else
    				repeatorder = repeatorder +","+ $(this).val();
    			i++;
    		});
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : CANCEL_API_URL+repeatorder,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {
						console.log("SUCCESS: ", result);
						location.reload();						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
					}  
    		});
    		
	    });    	    	
    	
    	var showselectall = ${showselectall};
        if(!showselectall)    
        {        	
        	$('[name=repeatorder]').hide();	
        	$('[name=gonextorder]').hide();	
        	$('[name=cancelorder]').hide();	
        }
        
        var errorsize = ${errorsize};
        if(errorsize==0)
        {
        	$('[name=repeatorder]').attr( "disabled", true );
        	$('[name=gonextorder]').attr( "disabled", true );
        	$('[name=cancelorder]').attr( "disabled", true );
        }
    	
    });	        
    </script>
</head>
<body>
<h2><fmt:message key="queryerror.title"/></h2><br />
<div id="search">
<form class="form-search" method="get" action="${ctx}/order/queryError" id="searchForm">
	<div class="input-append">
    	<input type="text" class="span8 search-query" size="20" name="q" id="query" value="${param.q}"
           placeholder="Msisdn"/>
    	<input class="btn" type="submit" value="<fmt:message key="button.search"/>"/>
    </div>
</form>
</div>

<display:table name="queryError" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="queryError" pagesize="25" class="table" export="true" sort="list">
   <c:if test="${showselectall}">
	   <display:column title="<input type='checkbox' name='selectall' onClick='selectAll(this, \"selectableCheckbox\")' />" media="html">
	          <input type="checkbox" name="checkbb[]" value="${queryError.CWORDERID}" class="selectableCheckbox" />
		</display:column>
	</c:if>    
    <display:column property="MSISDN" escapeXml="true" sortable="true" titleKey="queryerror.msisdn" style="width: 25%" 
     url="/order/queryErrorForm" paramId="CWORDERID" paramProperty="CWORDERID"/> 
      <display:column property="IMSI" escapeXml="true" sortable="true" titleKey="queryerror.imsi" style="width: 25%"
        url="/order/queryErrorForm" paramId="CWORDERID" paramProperty="CWORDERID"/>    
    <display:column property="CWORDERID" escapeXml="true" sortable="true" titleKey="queryerror.cworderid" style="width: 25%"
        url="/order/queryErrorForm" paramId="CWORDERID" paramProperty="CWORDERID"/> 
     <display:column property="SHORTDESCRIPTION" escapeXml="true" sortable="true" titleKey="queryerror.shortdescription" style="width: 40%"
        url="/order/queryErrorForm" paramId="CWORDERID" paramProperty="CWORDERID"/> 
      
</display:table>

	<div class="input-append">
    	<input type="button" class="btn btn-primary" name="repeatorder"  value="Repeat Step"/>
        <input type="button" class="btn btn-primary" name="gonextorder"  value="Gonext Step"/>
        <input type="button" class="btn btn-primary" name="cancelorder"  value="Cancel Order"/>      
    </div>
    <br />
        
      

<script type="text/javascript">
    highlightTableRows("users");
</script>
</body>
