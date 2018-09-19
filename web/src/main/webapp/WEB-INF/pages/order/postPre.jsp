<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="postpre.title"/></title>
    <meta name="heading" content="<fmt:message key='postpre.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="postpre.title"/></h2><br />
<spring:bind path="postPre.*">
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

<form:form commandName="postPre" method="post" action="postPreForm" onsubmit="return onFormSubmit(this)" id="postPre">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<ul>
    <li class="info">
		<p><fmt:message key="postpre.message"/></p>
    </li>
   <li>
        <appfuse:label styleClass="desc" key="msisdn(66xxxxxxxxx)"/>
        <form:errors path="msisdn" cssClass="fieldError"/>
        <form:input path="msisdn" id="msisdn" cssClass="text large" cssErrorClass="text large error" maxlength="11"/>
    </li>
     <li>
        <appfuse:label styleClass="desc" key="Iccid"/>
        <form:errors path="iccid" cssClass="fieldError"/>
        <form:input path="iccid" id="iccid" cssClass="text large" cssErrorClass="text large error" maxlength="19"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="planId"/>
        <form:errors path="planid" cssClass="fieldError"/>
        <form:select path="planid" id="planid" cssClass="large" cssErrorClass="large error" items="${planList}" />
    </li>
    <li class="buttonBar bottom">
      <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.submit"/>"/>

      <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('postPre'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validatePostPre(theForm);
}
</script>

<v:javascript formName="postPre" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script></body>

