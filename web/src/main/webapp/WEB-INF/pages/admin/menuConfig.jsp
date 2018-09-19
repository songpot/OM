<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menuconfig.title"/></title>
    <meta name="heading" content="<fmt:message key='menuconfig.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<spring:bind path="menuConfig.*">
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

<form:form commandName="menuConfig" method="post" action="menuConfigForm" onsubmit="return onFormSubmit(this)" id="menuConfig">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<ul>
    <li class="info">
		<p><fmt:message key="menuconfig.message"/></p>
    </li>
   <li>
        <appfuse:label styleClass="desc" key="Menu Config"/>
        <form:errors path="xmldata" cssClass="fieldError"/>
        <form:textarea path="xmldata" id="xmldata"></form:textarea>
    </li>   
    <li class="buttonBar bottom">
      <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.submit"/>"/>

      <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
    </li>
</ul>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('menuConfig'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to save")) 
		return validateMenuConfig(theForm);
	else
		return false;     
}
</script>

<v:javascript formName="menuConfig" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

