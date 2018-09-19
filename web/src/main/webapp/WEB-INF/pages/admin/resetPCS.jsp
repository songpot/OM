<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="resetPCS.title"/></title>
    <meta name="heading" content="<fmt:message key='resetPCS.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>

<h2><fmt:message key="resetPCS.title"/></h2><br />
<spring:bind path="resetPCS.*">
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

<form:form class="form-horizontal" commandName="resetPCS" method="post" action="resetPCSForm" onsubmit="return onFormSubmit(this)" id="resetPCS">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>


<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div> 
  <div class="control-group">
  		<appfuse:label styleClass="control-label" key="QOS"/>
        <form:errors path="QOS" cssClass="fieldError"/>             
	    <div class="controls">
	     	<form:select path="QOS" id="QOS" cssClass="span6" cssErrorClass="span4 error">
	        	<form:option value="SAMART_POSTPAID_VOLUME_QOS">SAMART_POSTPAID_VOLUME_QOS (Download : 6144000 , Upload : 8192000)</form:option>
	        	<form:option value="QOS7200">QOS7200 (Download : 8192000 , Upload : 2048000)</form:option>
	        	<form:option value="QOS2M">QOS2M (Download : 2048000 , Upload : 2048000)</form:option>
	        	<form:option value="QOS1M">QOS2M (Download : 1024000 , Upload : 1024000)</form:option>
	        	<form:option value="QOS512">QOS512 (Download : 512000 , Upload : 512000)</form:option>
	        	<form:option value="QOS384">QOS384 (Download : 384000 , Upload : 384000)</form:option>
	        	<form:option value="QOS256">QOS256 (Download : 256000 , Upload : 256000)</form:option>
	        	<form:option value="QOS128">QOS128 (Download : 128000 , Upload : 128000)</form:option>
	        	<form:option value="QOS64">QOS64 (Download : 64000 , Upload : 64000)</form:option>        	
	        </form:select>  
	    </div>
  </div>  
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="Total Quota"/>
    <form:errors path="totalQuota" cssClass="fieldError"/>          	
    <div class="controls">
     	<form:input path="totalQuota" id="totalQuota" cssClass="text large" cssErrorClass="text large error" maxlength="30"/>       
    </div>
  </div>
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="Used Quota"/>
    <form:errors path="usedQuota" cssClass="fieldError"/>    
    <div class="controls">
     	<form:input path="usedQuota" id="usedQuota" cssClass="text large" cssErrorClass="text large error" maxlength="30"/>
    </div>
  </div>
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="Start Date"/>
    <form:errors path="billingStartDate" cssClass="fieldError"/>    
    <div class="controls">
     	<form:input path="billingStartDate" id="billingStartDate" cssClass="text large" cssErrorClass="text large error" maxlength="30"/>
    </div>
  </div>
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="Duration"/>
    <form:errors path="billingDuration" cssClass="fieldError"/>    
    <div class="controls">
     	<form:input path="billingDuration" id="billingDuration" cssClass="text large" cssErrorClass="text large error" maxlength="30"/>
    </div>
  </div>
  <div class="control-group">   	
    <div class="controls">
     	<input type="submit" class="btn btn-primary"  name="save" onclick="bCancel=false" value="<fmt:message key="button.submit"/>"/>

      <input type="submit" class="btn btn-inverse"  name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </div>
  </div>          
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('resetPCS'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Reset Policy")) 
		return validateResetPCS(theForm);
	else
		return false;  
    
}
</script>

<v:javascript formName="resetPCS" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script></body>

