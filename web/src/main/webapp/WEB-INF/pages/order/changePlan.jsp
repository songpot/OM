<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="changeplan.title"/></title>
    <meta name="heading" content="<fmt:message key='changeplan.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="changeplan.title"/></h2><br />
<spring:bind path="changePlan.*">
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

<form:form class="form-horizontal" commandName="changePlan" method="post" action="changePlanForm" onsubmit="return onFormSubmit(this)" id="changePlan">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" cssClass="text large" cssErrorClass="text large error" maxlength="11"/>
    </div>
  </div>   
  <div class="control-group">
   	<appfuse:label styleClass="control-label" key="Promotion"/>
    <form:errors path="planId" cssClass="fieldError"/>
    <div class="controls">
     	<form:select path="planId" id="planId" cssClass="span4" cssErrorClass="large error" items="${planList}" />
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
    Form.focusFirstElement($('changePlan'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Change Plan")) 
		return validateChangePlan(theForm);
	else
		return false;     
}
</script>

<v:javascript formName="changePlan" staticJavascript="false"/>
</body>

