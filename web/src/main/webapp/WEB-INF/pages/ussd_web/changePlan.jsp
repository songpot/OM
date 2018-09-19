<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="changeplan.title"/></title>
    <meta name="heading" content="<fmt:message key='changeplan.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

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

<form:form commandName="changePlan" method="post" action="changePlanForm" onsubmit="return onFormSubmit(this)" id="changePlan">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<ul>
    <li class="info">
		<p><fmt:message key="changeplan.message"/></p>
    </li>
   <li>
        <appfuse:label styleClass="desc" key="msisdn(66xxxxxxxxx)"/>
        <form:errors path="msisdn" cssClass="fieldError"/>
        <form:input path="msisdn" id="msisdn" cssClass="text large" cssErrorClass="text large error" maxlength="11"/>
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
    Form.focusFirstElement($('changePlan'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validateChangePlan(theForm);
}
</script>

<v:javascript formName="changePlan" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

