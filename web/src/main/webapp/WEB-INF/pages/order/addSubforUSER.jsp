<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="addsub.title"/></title>
    <meta name="heading" content="<fmt:message key='addsub.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<body>
<h2><fmt:message key="addsub.title"/></h2><br />
<spring:bind path="addSub.*">
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

<form:form commandName="addSub" method="post" action="addSubForm" onsubmit="return onFormSubmit(this)" id="addSub">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<ul>
    <li class="info">
		<p><fmt:message key="addsub.message"/></p>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="msisdn(66xxxxxxxxx)"/>
        <form:errors path="msisdn" cssClass="fieldError"/>
        <form:input path="msisdn" id="msisdn" cssClass="text large" cssErrorClass="text large error" maxlength="11" readonly="true" />
    </li>
    <li>
        <appfuse:label styleClass="desc" key="iccid"/>
        <form:errors path="iccid" cssClass="fieldError"/>
        <form:input path="iccid" id="imsi" cssClass="text large" cssErrorClass="text large error" maxlength="19"/>
    </li>    
    <li>
        <appfuse:label styleClass="desc" key="planId"/>
        <form:errors path="planId" cssClass="fieldError"/>
        <form:select path="planId" id="planId" cssClass="large" cssErrorClass="large error" items="${planList}" />        
    </li>
    <li class="buttonBar bottom">
      <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.submit"/>"/>

      <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('addSub'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Add SubScriber")) 
		return validateAddSub(theForm);
	else
		return false;  
    
}
</script>

<v:javascript formName="addSub" staticJavascript="false"/>
</body>

