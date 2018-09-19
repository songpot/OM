<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="changelanguage.title"/></title>
    <meta name="heading" content="<fmt:message key='changelanguage.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<body>
<h2><fmt:message key="changelanguage.title"/></h2><br />
<spring:bind path="changeLanguage.*">
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

<form:form class="form-horizontal" commandName="changeLanguage" method="post" action="changeLanguageForm" onsubmit="return onFormSubmit(this)" id="changeLanguage">
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>


<div class="control-group">
   	<appfuse:label styleClass="control-label" key="Msisdn (0xxxxxxxxx)"/>
    <form:errors path="msisdn" cssClass="fieldError"/>
    <div class="controls">
     	<form:input path="msisdn" id="msisdn" class="text large" cssErrorClass="text large error" maxlength="11" />
    </div>
  </div>
  <div class="control-group">
   	<appfuse:label styleClass="control-label" key="language"/>
    <form:errors path="language" cssClass="fieldError"/>
    <div class="controls">
     	<form:select path="language" id="language" cssClass="large" cssErrorClass="large error">
        	<form:option value="1">Thai</form:option>
        	<form:option value="2">English</form:option>
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
    Form.focusFirstElement($('changeLanguage'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
	if (confirm("Are you sure to Change Language")) 
		 return validateChangeLanguage(theForm);
	else
		return false;        
}
</script>

<v:javascript formName="changeLanguage" staticJavascript="false"/>
</body>

