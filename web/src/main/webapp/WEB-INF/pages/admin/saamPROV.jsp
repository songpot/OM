<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="saamprov.title"/></title>
    <meta name="heading" content="<fmt:message key='saamprov.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
    <script src="<c:url value='/scripts/latest-jquery/jquery-1.5.1.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/scripts/latest-jquery/jquery.format.js'/>" type="text/javascript"></script>
    <script type="text/javascript">   
    $(document).ready(function() {
    	$('[name="template"]').change(function() {
    		var selectval = $(this).val();
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "../api/saam/getxmlrequest?input="+selectval,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {
						$('[name="xmldata"]').val(result.xml);					
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
    	$('[name="send"]').click(function() {
    		var selectval = $('[name="xmldata"]').val();    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "../api/saam/sendxmlrequest?input="+selectval,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {					
						$('[name="xmldata"]').val(result.xml);	
						$('[name="xmldata"]').format({method: 'xml'});
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
    	
    });
    </script>
</head>
<body>

<h2><fmt:message key="saamprov.title"/></h2><br />
<spring:bind path="saamPROV.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon"/>
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<form:form class="form-horizontal" commandName="saamPROV" method="post" action="saamPROVForm" onsubmit="return onFormSubmit(this)" id="saamPROV">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>


<div class="control-group">  
  <div class="control-group">
  		<appfuse:label styleClass="control-label" key="SAAM Template"/>
        <form:errors path="template" cssClass="fieldError"/>             
	    <div class="controls">
	     	<form:select name="template" path="template" id="template" cssClass="span6" cssErrorClass="span4 error" items="${fileList}" />	     			          
	    </div>
  </div>  
  <div class="control-group">
	  	<appfuse:label styleClass="control-label" key="XML"/>
	    <form:errors path="xmldata" cssClass="fieldError"/>  
	    <div class="controls">
	    	<form:textarea name="xmldata" path="xmldata" cssClass="span6" cssErrorClass="span4 error" id="xmldata" style="margin: 0px; height: 471px; width: 608px;" ></form:textarea>
	    </div>
  </div>  	
  <div class="control-group">   	
    <div class="controls">
     	<input type="button" class="btn btn-primary"  id="send" name="send"  value="Send"/>      
    </div>
  </div>          
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('saamPROV'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Send SAAM Command")) 
		return validatesaamPROV(theForm);
	else
		return false;  
    
}
</script>

<v:javascript formName="saamPROV" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script></body>

