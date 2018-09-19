<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="queryorderform.title" />
</title>
<meta name="heading" content="<fmt:message key='queryorderform.heading'/>" />
<meta name="menu" content="OrderMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="queryorderform.title"/></h2><br />
<spring:bind path="queryOrderForm.*">
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

<form:form commandName="queryOrderForm" method="post" action="queryOrderForm"
	onsubmit="return onFormSubmit(this)" id="queryForm">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	<table border="0.5" width="50%">
		<tr>
			<td><appfuse:label styleClass="desc" key="OM OrderID" /></td>
			<td><form:input path="CWORDERID" id="OMorderId" cssClass="span12"
					readonly="true" cssErrorClass="span12 error" maxlength="11" />
			</td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Msisdn" /></td>
			<td><form:input path="MSISDN" id="Msisdn" cssClass="span12"
					readonly="true" cssErrorClass="span12 error" maxlength="15" />
			</td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Ismi" /></td>
			<td><form:input path="IMSI" id="Imsi" cssClass="span12"
					readonly="true" cssErrorClass="span12 error" maxlength="15" />
			</td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Order Date" /></td>
			<td><form:input path="CWORDERCREATIONDATE" id="Order Date"
					cssClass="span12" readonly="true"
					cssErrorClass="span12 error" maxlength="15" /></td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Source System" /></td>
			<td><form:input path="SOURCESYSTEMID" id="Source System"
					cssClass="span12" readonly="true"
					cssErrorClass="span12 error" maxlength="15" /></td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Mobile Type" /></td>
			<td><form:input path="MOBILETYPE" id="Mobile Type"
					cssClass="span12" readonly="true"
					cssErrorClass="span12 error" maxlength="15" /></td>
		</tr>
		<tr>
			<td><appfuse:label styleClass="desc" key="Operation Code" /></td>
			<td><form:input path="OPERATIONCODE" id="Operation Code"
					cssClass="span12" readonly="true"
					cssErrorClass="span12 error" maxlength="15" /></td>
		</tr>		
		<tr>
			<td></td>
			<td><input type="submit"  class="btn btn-primary" name="save" onclick="bCancel=false" value="CallBack"/></td>			 	
		</tr>
		
	</table>
    <br />
    <br />   
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('queryOrderForm'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validatequeryOrderForm(theForm);
}
</script>

<v:javascript formName="queryOrderForm" staticJavascript="false" />
<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>
</body>

