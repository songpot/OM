<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="barsub.title"/></title>
    <meta name="heading" content="<fmt:message key='barsub.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="barsub.title"/></h2><br />
<spring:bind path="barSub.*">
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

<form:form class="form-horizontal" commandName="barSub" method="post" action="barSubForm" onsubmit="return onFormSubmit(this)" id="barSub">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>
<input type="hidden" name="barstatus" value="1" />



<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div> 
  <div class="control-group">
  	<appfuse:label styleClass="control-label" key="service"/>
    <form:errors path="service" cssClass="fieldError"/>   
    <div class="controls">
     	 <form:select path="service" id="service" cssClass="span4" cssErrorClass="large error" >
        	<form:option value="voiceincoming">Voice Incoming</form:option>
        	<form:option value="voiceoutgoing">Voice outgoing</form:option>
        	<form:option value="data">Data</form:option>
        	<form:option value="inter">International Call</form:option>        	
        	<form:option value="rbt">Ring Back Tone</form:option>
        	<form:option value="smsin">SMS Incomeing</form:option>
        	<form:option value="smsout">SMS OutGoing</form:option>
        	<form:option value="videocall">VideoCall</form:option>
        	<form:option value="vms">VMS</form:option>
        	<form:option value="vvms">VVMS</form:option>
        	<form:option value="wifi">Wifi</form:option>     
        	<form:option value="roaming">Roaming AWN</form:option>             	
			<form:option value="roamingInternational">Roaming International</form:option>			
        </form:select>
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
    Form.focusFirstElement($('barSub'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Bar")) 
		return validatebarSub(theForm);
	else
		return false;     
}
</script>

<v:javascript formName="barSub" staticJavascript="false"/>
</body>

