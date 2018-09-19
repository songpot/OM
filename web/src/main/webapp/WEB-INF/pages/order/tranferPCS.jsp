<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="tranferpcs.title"/></title>
    <meta name="heading" content="<fmt:message key='tranferpcs.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="tranferpcs.title"/></h2><br />
<spring:bind path="modPCS.*">
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

<form:form class="form-horizontal" commandName="modPCS" method="post" action="tranferPCSForm" onsubmit="return onFormSubmit(this)" id="tranferPCS">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Source Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="sourcemsisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div> 
<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Target Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div> 
  <div class="control-group">
   	<appfuse:label styleClass="control-label" key="PCS Plan"/>
    <form:errors path="pricingPlan" cssClass="fieldError"/>
    <div class="controls">
     	<form:select path="pricingPlan" id="pricingPlan" cssClass="span4" cssErrorClass="large error" items="${pcsdata}" /> 
    </div>
  </div>   
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="Operation"/>
    <form:errors path="modpcstype" cssClass="fieldError"/>
    <div class="controls">
     	<form:select path="modpcstype" id="modpcstype" cssClass="large" cssErrorClass="large error">
        	<form:option value="sub">Subscription</form:option>
        	<form:option value="unsub">Unsubscription</form:option>
    	</form:select>
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
    Form.focusFirstElement($('modPCS'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Add Policy Control")) 
		return validateModPCS(theForm);
	else
		return false;     
}
</script>

<v:javascript formName="modPCS" staticJavascript="false"/>
</body>

