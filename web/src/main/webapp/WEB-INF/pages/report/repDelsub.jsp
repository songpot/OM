<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="repdelsub.title" />
</title>
<meta name="heading" content="<fmt:message key='repdelsub.heading'/>" />
<meta name="menu" content="ReportMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<spring:bind path="repDelsub.*">
	<c:if test="${not empty status.errorMessages}">
		<div class="error">
			<c:forEach var="error" items="${status.errorMessages}">
				<img src="<c:url value="/images/iconWarning.gif"/>"
					alt="<fmt:message key="icon.warning"/>" class="icon" />
				<c:out value="${error}" escapeXml="false" />
				<br />
			</c:forEach>
		</div>
	</c:if>
</spring:bind>

<form:form commandName="repDelsub" method="post" action="repDelsub"
	onsubmit="return onFormSubmit(this)" id="repDelsub">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	
    <appfuse:label styleClass="desc" key="Delsub Report"/>          
    <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="Generate Report"/>"/>     

</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('repDelsub'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validaterepDelsub(theForm);
}
</script>

<v:javascript formName="repDelsub" staticJavascript="false" />
<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>

