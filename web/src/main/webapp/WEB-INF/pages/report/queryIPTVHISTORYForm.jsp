<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="queryiptvhistoryForm.title" />
</title>
<meta name="heading" content="<fmt:message key='queryiptvhistoryForm.heading'/>" />
<meta name="menu" content="Report" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<spring:bind path="queryIPTVHISTORYForm.*">
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

<form:form commandName="queryIPTVHISTORYForm" method="POST" action="queryIPTVHISTORYForm"
	onsubmit="return onFormSubmit(this)" id="queryIPTVHISTORYForm">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	<table border="0.5">
		<tr>
			<td><appfuse:label styleClass="desc" key="IPTV ID" /></td>
			<td><form:input path="trxid" id="trxid" cssClass="text large"
					readonly="true" cssErrorClass="text large error" maxlength="11" />
			</td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Msisdn" /></td>
			<td><form:input path="msisdn" id="msisdn" cssClass="text large"
					readonly="true" cssErrorClass="text large error" maxlength="15" />
			</td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Subscribe Date" /></td>
			<td><form:input path="createdate" id="createdate" cssClass="text large"
					readonly="true" cssErrorClass="text large error" maxlength="15" />
			</td>
		</tr>		
		<tr>
		    <td><input type="submit" class="button" name="save" onclick="bCancel=false" value="forgot"/></td>
			<td><input type="submit" class="button" name="save" onclick="bCancel=false" value="resend"/></td>			 	
		</tr>
	</table>
       
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('queryIPTVHISTORYForm'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validatequeryIPTVHISTORYForm(theForm);
}
</script>

<v:javascript formName="queryIPTVHISTORYForm" staticJavascript="false" />
<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>

