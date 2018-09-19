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
 
   var activeStatusValue = "${selectedActiveStatus}";
   var billingresettypeValue = "${selectedbillResetType}";
   var mobileTypeValue = "${selectedMobileType}";
   var operation = "${operation}";
	 
   if(activeStatusValue !== "")
   {
	   $('#active option[value="'+activeStatusValue+'"]').attr('selected','selected');
   }
   
   if(billingresettypeValue !== "")
   {
	   $('#billResetType option[value="'+billingresettypeValue+'"]').attr('selected','selected');
   }
   
   if(mobileTypeValue !== "")
   {
	   $('#mobiletype option[value="'+mobileTypeValue+'"]').attr('selected','selected');
   }
   
   if(operation == "Edit")
   {   
	   $('#pcs_id').attr('readonly','readonly');
   }
   
   $('#pcs_id').keypress(function(e) {
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
<h2>PCS Topping Setting</h2><br />
<form:form class="form-horizontal" commandName="settingPCS" method="post" action="settingPCSForm"
	onsubmit="return onFormSubmit(this)" id="settingPCS">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	<input type="hidden" name="operation" id="operation" value="<c:out value="${param.operation}"/>" />
	
	<input type="hidden" name="vtname" value="<c:out value="${param.vtname}"/>" />
	<input type="hidden" name="vtstatus" value="<c:out value="${param.vtstatus}"/>" />
	
	<div id="tab1" class="control-group">						
		<table class="table table-striped" border="0.5">			
							 		
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="PCS Topping ID" />
				<div class="controls">
					<form:input path="pcs_id" id="pcs_id" cssClass="span5" cssErrorClass="span5 error" maxlength="3" required="false" placeholder="PCS Topping ID"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Name" />
				<div class="controls">
					<form:input path="priceplan" id="priceplan" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Name"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Price" />
				<div class="controls">
					<form:input path="price" id="price" cssClass="span5" cssErrorClass="span5 error" maxlength="15" type="number" min="0" value="0" required="false" />
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Mobile Type" />
				<div class="controls">
					<form:select path= "mobiletype" id="mobiletype">
						<form:option value="">Both</form:option>
  						<form:option value="prepaid">Prepaid</form:option>
  						<form:option value="postpaid">Postpaid</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Active Status" />
				<div class="controls">
					<form:select path= "active" id="active">
  						<form:option value="true">Active</form:option>
  						<form:option value="false">Inactive</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="PCS Priceplan" />
				<div class="controls">
					<form:input path="pcs_priceplan" id="pcs_priceplan" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="PCS Priceplan"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Total Quota (Byte)" />
				<div class="controls">
					<form:input path="totalQuota" id="totalQuota" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Total Quota (Byte)"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Used Quota (Byte)" />
				<div class="controls">
					<form:input path="usedQuota" id="usedQuota" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Used Quota (Byte)"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Billing Duration" />
				<div class="controls">
					<form:input path="billingDuration" id="billingDuration" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Billing Duration"/>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="Billing Reset Type" />
				<div class="controls">
					<form:select path= "billResetType" id="billResetType">
  						<form:option value="hours">Hours</form:option>
  						<form:option value="date">Date</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Preferred Domain" />
				<div class="controls">
					<form:input path="preferredDomain" id="preferredDomain" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Preferred Domain"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Price" />
				<div class="controls">
					<form:input path="price" id="price" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Price"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="MVNO CODE" />
				<div class="controls">
					<form:input path="mvno" id="mvno" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="MVNO CODE"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="QOS Reference Name" />
				<div class="controls">
					<form:input path="refQoSProfName" id="refQoSProfName" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="QOS Reference Name"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Start Date" />
				<div class="controls">
					<form:input path="billingStartDate" id="billingStartDate" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Start Date"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Action status code" />
				<div class="controls">
					<form:input path="actionStatus" id="actionStatus" cssClass="span5" cssErrorClass="span5 error" maxlength="255" required="false" placeholder="Action status code"/>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="PCS Type" />
				<div class="controls">
					<form:select path= "pcstype" id="pcstype">
  						<form:option value="main">Main Type</form:option>
  						<form:option value="element">Element Type</form:option>
					</form:select>
				</div>
			</div>
			
			<div class="control-group">					
				<appfuse:label styleClass="control-label" key="PCS Profile Type" />
				<div class="controls">
					<form:select path= "pcsprofiletype" id="pcsprofiletype">
  						<form:option value="intertop">Intertop</form:option>
  						<form:option value="iptv">Iptv</form:option>
  						<form:option value="socialtop">SocialTop</form:option>
  						<form:option value="directIN">Direct IN</form:option>
					</form:select>
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
			if (confirm("Are you sure to Edit this  Topping")) 
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

