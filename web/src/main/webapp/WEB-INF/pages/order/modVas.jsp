<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="modvas.title"/></title>
    <meta name="heading" content="<fmt:message key='modvas.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>
<body>
<h2><fmt:message key="modvas.title"/></h2><br />
<spring:bind path="modVas.*">
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

<form:form class="form-horizontal" commandName="modVas" method="post" action="modVasForm" onsubmit="return onFormSubmit(this)" id="modVas">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>


<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div>  
  <div class="control-group">
   	<appfuse:label styleClass="control-label" key="VAS Service"/>
    <form:errors path="vasid" cssClass="fieldError"/>
    <div class="controls">
     	<form:select path="vasid" id="vasid" cssClass="large" cssErrorClass="large error">
        	<form:option value="VVMS">Video Mail</form:option>
        	<form:option value="VMS">Voice Mail</form:option>        
        	<form:option value="RBT">Ringback tone</form:option>
        	<form:option value="STREAMING">Streaming</form:option>
        	<form:option value="MCN">MissCall Notification</form:option>         	
        </form:select>     
    </div>
  </div>
  <div class="control-group">
   	<appfuse:label styleClass="control-label" key="Operation"/>
   	<form:errors path="modvastype" cssClass="fieldError"/>    
    <div class="controls">
     	<form:select path="modvastype" id="modvastype" cssClass="large" cssErrorClass="large error">
        	<form:option value="sub">subscription</form:option>
            <form:option value="unsub">Unsubscription</form:option>         	
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
    Form.focusFirstElement($('modVas'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to ChangeVas")) 
    	return validateModVas(theForm);
}
</script>

<v:javascript formName="modVas" staticJavascript="false"/>
</body>

