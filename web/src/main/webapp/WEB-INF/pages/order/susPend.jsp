<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="suspend.title"/></title>
    <meta name="heading" content="<fmt:message key='suspend.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="suspend.title"/></h2><br />
<spring:bind path="susPend.*">
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

<form:form class="form-horizontal" commandName="susPend" method="post" action="susPendForm" onsubmit="return onFormSubmit(this)" id="susPend">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
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
    Form.focusFirstElement($('susPend'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Suspend")) 
    	return validateSusPend(theForm);
	else
		return false;
}
</script>

<v:javascript formName="susPend" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script></body>

