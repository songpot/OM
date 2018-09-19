<%@ include file="/common/taglibs.jsp"%>

<head>
<title>Adjust Money</title>
<meta name="heading" content="Adjust Money" />
<meta name="menu" content="OrderMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
	<h2>Adjust Money</h2>
	<br />
	
	<form:form class="form-horizontal" commandName="adJustMoney" method="post"
		action="adJustMoneyForm" onsubmit="return onFormSubmit(this)" id="adJustMoney">
		<input type="hidden" name="from"
			value="<c:out value="${param.from}"/>" />


		<div class="control-group">
			<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)" />
			<form:errors path="msisdn" cssClass="fieldError" />
			<div class="controls">
				<form:input path="msisdn" id="msisdn" class="text large"
					cssErrorClass="text large error" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<appfuse:label styleClass="control-label" key="Volume (Satang)" />
			<form:errors path="volume" cssClass="fieldError" />
			<div class="controls">
				<form:input path="volume" id="volume" class="text large"
					cssErrorClass="text large error" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<appfuse:label styleClass="control-label" key="RefillType" />
			<form:errors path="type" cssClass="fieldError" />
			<div class="controls">
				<form:select path="type" id="type" cssClass="span4"
					cssErrorClass="large error">
					<form:option value="credit">Credit</form:option>
					<form:option value="debit">Debit</form:option>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<appfuse:label styleClass="control-label"
				key="Bucket (Mainbalance is blank)" />
			<form:errors path="bucket" cssClass="fieldError" />
			<div class="controls">
				<form:input path="bucket" id="bucket" class="text large"
					cssErrorClass="text large error" maxlength="11" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input type="submit" class="btn btn-primary" name="save"
					onclick="bCancel=false" value="<fmt:message key="button.submit"/>" />

				<input type="submit" class="btn btn-inverse" name="cancel"
					onclick="bCancel=true" value="<fmt:message key="button.cancel"/>" />
			</div>
		</div>
	</form:form>

	<script type="text/javascript">
    Form.focusFirstElement($('adJustMoney'));
    highlightFormElements();

	<!-- This is here so we can exclude the selectAll call when roles is hidden -->
	function onFormSubmit(theForm) {
			return validateadJustMoney(theForm);	
	}
</script>

	<v:javascript formName="adJustMoney" staticJavascript="false" />
</body>

