<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="activateReadySub.title"/></title>
    <meta name="heading" content="<fmt:message key='activateReadySub.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<body>
<h2><fmt:message key="activateReadySub.title"/></h2><br />
<spring:bind path="activateReadySub.*">
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

<form:form class="form-horizontal"  commandName="activateReadySub" method="post" action="activateReadySubForm" onsubmit="return onFormSubmit(this)" id="activateReadySub">
<div class="control-group">
   <p><fmt:message key="activateReadySub.message"/></p>
    
</div>   
<div class="control-group">
   	<appfuse:label styleClass="control-label" key="ICCID (U-SIM)"/>
    <form:errors path="iccid" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="iccid" id="iccid" cssClass="text large" cssErrorClass="text large error" maxlength="19"/>
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
    Form.focusFirstElement($('activateReadySub'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Activate SubScriber")) 
		return validateActivateReadySub(theForm);
	else
		return false;  
    
}
</script>

<v:javascript formName="activateReadySub" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
</body>

