<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="refilldate.title"/></title>
    <meta name="heading" content="<fmt:message key='refilldate.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="refilldate.title"/></h2><br />
<spring:bind path="refillDate.*">
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

<form:form commandName="refillDate" method="post" action="refillDateForm" onsubmit="return onFormSubmit(this)" id="refillDate">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<ul>
    <li class="info">
		<p><fmt:message key="refilldate.message"/></p>
    </li>
   <li>
        <appfuse:label styleClass="desc" key="msisdn(66xxxxxxxxx)"/>
        <form:errors path="msisdn" cssClass="fieldError"/>
        <form:input path="msisdn" id="msisdn" cssClass="text large" cssErrorClass="text large error" maxlength="11"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="Date to refill"/>
        <form:errors path="refilldate" cssClass="fieldError"/>
        <form:select path="refilldate" id="refilldate" cssClass="large" cssErrorClass="large error">
        	<form:option value="030">30</form:option>
        </form:select>
    </li>
    <li class="buttonBar bottom">
      <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.submit"/>"/>

      <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('refillDate'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Refill Date")) 
		 return validaterefillDate(theForm);
	else
		return false;        
}
</script>

<v:javascript formName="refillDate" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
</body>

