<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="settingvoicetopping.title" /></title>
<meta name="heading" content="<fmt:message key='settingvoicetopping.heading'/>" />
<meta name="menu" content="OrderMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
<script
	src="<c:url value='/scripts/latest-jquery/jquery-1.5.1.min.js'/>"
	type="text/javascript"></script>
<style type="text/css">
.container {
	width: 100%;
	background: #ffff;
	margin: 10px auto;
}

ul.tabs {
	margin: 0;
	padding: 0;
	float: left;
	list-style: none;
	height: 32px;
	border-bottom: 1px solid #999;
	border-left: 1px solid #999;
	width: 100%;
}

ul.tabs li {
	float: left;
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	border: 1px solid #999;
	border-left: none;
	margin-bottom: -1px;
	background: #F0F0F0;
	overflow: hidden;
	position: relative;
}

ul.tabs li a {
	text-decoration: none;
	color: #000;
	display: block;
	font-size: 1.2em;
	padding: 0 20px;
	border: 1px solid #fff;
	outline: none;
}

ul.tabs li a:hover {
	background: #ccc;
}

html ul.tabs li.active,html ul.tabs li.active a:hover {
	background: #ffff;
}


.tab_container {
	border: 1px solid #999;
	border-top: none;
	clear: both;
	float: left;
	width: 100%;
	background: #fff;
	-moz-border-radius-bottomright: 5px;
	-khtml-border-radius-bottomright: 5px;
	-webkit-border-bottom-right-radius: 5px;
	-moz-border-radius-bottomleft: 5px;
	-khtml-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px;
}

.tab_content {
	padding: 20px;
	font-size: 1.2em;
}

.tab_content h2 {
	font-weight: normal;
	padding-bottom: 10px;
	border-bottom: 1px dashed #ddd;
	font-size: 1.8em;
}

.tab_content h3 a {
	color: #254588;
}

.tab_content img {
	float: left;
	margin: 0 20px 20px 0;
	border: 1px solid #ddd;
	padding: 5px;
}

.hidden {
 display: none;
}

.cdr_updated {
  font-size: 0.8em;
}

.note{
	display: inline-block;
	color: red;
}
</style>
<script type="text/javascript">
 
$(document).ready(function() {
 
   var amountTypeValue = "${selectedAmountType}";
   var activeStatusValue = "${selectedActiveStatus}";
   var showStatusValue = "${selectedShowStatus}";
   var mobileTypeValue = "${selectedMobileType}";
   var operation = "${operation}";
	
   if(amountTypeValue !== "")
   {
	   $('#amountType option[value="'+amountTypeValue+'"]').attr('selected','selected');
   }
   
   if(activeStatusValue !== "")
   {
	   $('#isactive option[value="'+activeStatusValue+'"]').attr('selected','selected');
   }
   
   if(showStatusValue !== "")
   {
	   $('#isshow option[value="'+showStatusValue+'"]').attr('selected','selected');
   }
   
   if(mobileTypeValue !== "")
   {
	   $('#mobileType option[value="'+mobileTypeValue+'"]').attr('selected','selected');
   }
   
   if(operation == "Edit")
   {   
	   $('#planID').attr('readonly','readonly');
   }
   
   $('#planID').keypress(function(e) {
       var a = [];
       var k = e.which;
   
       for (i = 48; i < 58; i++)
           a.push(i);
       a.push(8);
       a.push(127);
   
       if (!($.inArray(k,a)>=0))
           e.preventDefault();
   });
   
   
  $('input[name=save]').click(function(){
	   
	   $("input").prop('required',true);
   });
  
  $('input[name=cancel]').click(function(){
	   
	   $("input").removeAttr('required');
  });
  
 
	//Default Action
  /*  $(".tab_content").hide(); //Hide all content
    $("ul.tabs li:first").addClass("active").show(); //Activate first tab
    $(".tab_content:first").show(); //Show first tab content
    
         
    //On Click Event
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
        $(activeTab).fadeIn(); //Fade in the active content
        return false;
    });
    
    $('input[type=checkbox]').attr('disabled','true');*/
 
});
</script>
</head>
<body>
<h2><fmt:message key="settingvoicetopping.title"/></h2><br />
<form:form class="form-horizontal" commandName="settingVoiceTopping" method="post" action="settingVoiceToppingForm"
	onsubmit="return onFormSubmit(this)" id="settingVoiceTopping">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	<input type="hidden" name="operation" id="operation" value="<c:out value="${param.operation}"/>" />
	
	<input type="hidden" name="vtname" value="<c:out value="${param.vtname}"/>" />
	<input type="hidden" name="vtstatus" value="<c:out value="${param.vtstatus}"/>" />
	
	<div id="tab1" class="control-group">						
		<table class="table table-striped" border="0.5">
			
							 		
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Voice Topping ID" />
				<div class="controls">
					<form:input path="planID" id="planID" cssClass="span5" cssErrorClass="span5 error" maxlength="3" required="false" placeholder="Voice Topping ID"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Voice Topping Name" />
				<div class="controls">
					<form:input path="description" id="description" cssClass="span5" cssErrorClass="span5 error" maxlength="20" required="false" placeholder="Voice Topping Name"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Price" />
				<div class="controls">
					<form:input path="price" id="price" cssClass="span5" cssErrorClass="span5 error" maxlength="15" type="number" min="0" value="0" required="false" />
				</div>
			</div>
		
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Amount" />
				<div class="controls">
					<form:input path="amount" id="amount" cssClass="span5" cssErrorClass="span5 error" maxlength="15" type="number" min="0" value="0" required="false" />
				</div>
			</div>
		
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Amount Type" />
				<div class="controls">
					<form:select path= "amountType" id="amountType">
  						<form:option value="minutes">Minutes</form:option>
  						<form:option value="hours">Hours</form:option>
  						<form:option value="date">Date</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Active Status" />
				<div class="controls">
					<form:select path= "isactive" id="isactive">
  						<form:option value="0">Active</form:option>
  						<form:option value="1">Inactive</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Show Status" />
				<div class="controls">
					<form:select path= "isshow" id="isshow">
  						<form:option value="0">Show</form:option>
  						<form:option value="1">Hide</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Mobile Type" />
				<div class="controls">
					<form:select path= "mobileType" id="mobileType">
  						<form:option value="prepaid">Prepaid</form:option>
  						<form:option value="postpaid">Postpaid</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Profile Reference" />
				<div class="controls">
					<form:input path="profRef" id="profRef" cssClass="span5" cssErrorClass="span5 error" maxlength="15" required="false" placeholder="Profile Reference"/>
				</div>
			</div>
			
			<div class="control-group">   	
  			  <div class="controls">
     				<input type="submit" class="btn btn-primary"  name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
      				<input type="submit" class="btn btn-inverse"  name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
      				
      		  </div>
  			</div>       

		</table>
			  
	</div>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('settingVoiceTopping'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) 
{	
	var btn = this.bCancel;
	var operation = document.getElementById('operation').value;
	if(btn === false)
		if(operation == "Edit")
			if (confirm("Are you sure to Edit this Voice Topping")) 
				return validateAddSub(theForm); //****
			else
				return false;
		else
			return validateAddSub(theForm); //****
	
}

</script>

<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>
</body>

