<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="querySRDetail.title" /></title>
<meta name="heading" content="<fmt:message key='querySRDetail.heading'/>" />
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
 
    //Default Action
    $(".tab_content").hide(); //Hide all content
    $("ul.tabs li:first").addClass("active").show(); //Activate first tab
    $(".tab_content:first").show(); //Show first tab content
    
    var showinfor = ${showINinfor};
    if(!showinfor)
    {
    	$("#ininformation").hide();
    	$("#inIdtab1").hide();
    }
    
    var showinidmismatch = ${showInIdMismatch};
    if(!showinidmismatch)
    {
    	$("#error_inaluid").hide();
    }
    
    var showimsicooperate = ${showImsiCooperate};
    if(!showimsicooperate)
    {
    	$("#imsi_cooperate").hide();
    }
    
    var showplaninfor = ${showPLANinfor};
    if(!showplaninfor)
    {
    	$("#planinformation").hide();
    }
    
    <!-- Edit by Wanatsanan 16/02/2016 -->
    
    var showsiminfor = ${showSimInformation};
    if(!showsiminfor)
    {
    	$("#siminformation").hide();
    }
    
    var showpolicycontrol = ${showPolicyControl};
    if(!showpolicycontrol)
    {
    	$("#policycontrol").hide();
    }
    
    var showdatausage = ${showDataUsage};
    if(!showdatausage)
    {
    	$("#datausage").hide();
    }
         
    //On Click Event
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
        $(activeTab).fadeIn(); //Fade in the active content
        return false;
    });
    
    $('input[type=checkbox]').attr('disabled','true');
 
});
</script>
</head>
<body>
<spring:bind path="querySRDetail.*">
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
<h2><fmt:message key="querySRDetail.title"/></h2><br />
<form:form class="form-horizontal" commandName="querySRDetail" method="post" action="querySRDetailForm"
	onsubmit="return onFormSubmit(this)" id="querySRDetail">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />

	<div class="container">
		<ul class="tabs">
			<li><a href="#tab1">Subscriber</a></li>
			<li id="planinformation"><a href="#tab2">Plan Information</a></li>
			<li id="ininformation"><a href="#tab3">IN Information</a></li>
			
			<!-- Edit by Wanatsanan 16/02/2016 -->
			<li id="siminformation"><a href="#tab4">SIM Information</a></li>
			<li id="apnlist"><a href="#tab5">APN List</a></li>
			<li id="policycontrol"><a href="#tab6">Policy Control</a></li>			
			<li id="datausage"><a href="#tab7">Data Usage</a></li>
						
		</ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">
			 <table class="table table-striped" border="0.5">
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Msisdn" />
						<div class="controls">
							<form:input path="msisdn" id="msisdn"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="11" />
						</div>
					</div>
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Imsi" />
						<div class="controls">
							<form:input path="imsi" id="imsi" cssClass="span5"
								readonly="true" cssErrorClass="span5 error" maxlength="15" />
								<p class="note" id="imsi_cooperate">IMSI range in cooperate - cannot use internet</p>
						</div>
					</div>
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="U-SIM" />
						<div class="controls">
							<form:input path="iccid" id="iccid" cssClass="span5"
								readonly="true" cssErrorClass="span5 error" maxlength="15" />
						</div>
					</div>
					<div class="control-group">					
						<appfuse:label styleClass="control-label" key="Promotion" />
						<div class="controls">
							<form:input path="planId" id="planId"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="15" />
						</div>
					</div>
					<div class="control-group">					
						<appfuse:label styleClass="control-label" key="Mvno" />
						<div class="controls">
							<form:input path="mvnoCode" id="mvnoCode"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="15" />
						</div>
					</div>
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Mobile Type" />
						<div class="controls">
							<form:input path="mobileType" id="mobileType"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="15" />
						</div>
					</div>
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Language" />
						<div class="controls">
							<form:input path="Language" id="Language"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="15" />
						</div>
					</div>
					
					<div class="control-group" id="inIdtab1">
						<appfuse:label styleClass="control-label" key="IN Identification" />
						<div class="controls">
							<form:input path="aluinSubscriberId_om" id="aluinSubscriberId_om"
								cssClass="span5" readonly="true"
								cssErrorClass="span5 error" maxlength="15" />
							<p class="note" id="error_inaluid">Mismatch with IN</p>
						</div>
					</div>
					
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Rolling" />
						<div class="controls">
							<form:checkbox path="rolling" readonly="true" />
						</div>
					</div>
					<div class="control-group">					
						<appfuse:label styleClass="control-label" key="Suspense" />
						<div class="controls">
							<form:checkbox path="ifSuspend" readonly="true" />
						</div>
					</div>
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="Treatment Bar" />
						<div class="controls">
							<form:checkbox path="Treatmentbar" readonly="true" />
						</div>
					</div>	
					
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="MMS" />
				    	<div class="controls">
							<form:checkbox path="service_MMS" readonly="true" />
						</div>
					</div>
					
					<div class="control-group">
						<appfuse:label styleClass="control-label" key="MCN" />
						<div class="controls">
							<form:checkbox path="service_MCN" readonly="true" />
						</div>
					</div>
					
					<div class="control-group">					
						<appfuse:label styleClass="control-label" key="International Roaming" />
						<div class="controls">
							<form:checkbox path="inter_roaming" readonly="true" />
						</div>
					</div>
					<table border="0.5" style="width: 50%">																					
						<tr>
							<td><appfuse:label styleClass="control-label" key="Voice" /></td>
							<td align="left"><form:checkbox path="voice" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="Voice Roaming" /></td>
							<td><form:checkbox path="voice_roaming" readonly="true" />
							</td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label"
									key="Voice BarIn Status" /></td>
							<td><form:input path="voice_BarIn" id="voice_BarIn"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label"
									key="Voice BarOut Status" /></td>
							<td><form:input path="voice_BarOut" id="voice_BarOut"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						
						<!-- Edit By Wanatsanan 31/10/2016 -->
						<tr>
							<td><appfuse:label styleClass="control-label"
									key="Current Carrier Networks (Voice)" /></td>
							<td><form:input path="carrier_network_voice" id="carrier_network_voice"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						
						
						<tr>
							<td><appfuse:label styleClass="control-label" key="Area Status" /></td>
							<td><form:textarea path="roamingArea" rows="15" cols="5"
									id="roamingArea" cssClass="span15" readonly="true" style="width: 445px; height: 321px;"
									cssErrorClass="span10 error" /></td>
						</tr>
					</table>
					<table border="0.5" style="width: 50%">
						<tr>
							<td><appfuse:label styleClass="control-label" key="Data" /></td>
							<td><form:checkbox path="data" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="Data Roaming" /></td>
							<td><form:checkbox path="data_roaming" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="Data Bar Status" />
							</td>
							<td><form:input path="data_bar" id="data_bar"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						
						<!-- Edit By Wanatsanan 31/10/2016 -->
						<tr>
							<td><appfuse:label styleClass="control-label"
									key="Current Carrier Networks (Data)" /></td>
							<td><form:input path="carrier_network_data" id="carrier_network_data"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						
					</table>
					<table border="0.5" style="width: 50%">
						<tr>
							<td><appfuse:label styleClass="control-label" key="WiFi" /></td>
							<td><form:checkbox path="WiFi" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="WiFi Bar Status" />
							</td>
							<td><form:input path="WiFi_bar" id="WiFi_bar"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
					</table>
					<table border="0.5" style="width: 50%">
						<tr>
							<td><appfuse:label styleClass="control-label" key="RBT" /></td>
							<td><form:checkbox path="service_RBT" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="RBT Bar Status" />
							</td>
							<td><form:input path="service_RBT_bar" id="service_RBT_bar"
									cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
					</table>
					<table border="0.5" style="width: 50%">
						<tr>
							<td><appfuse:label styleClass="control-label" key="VideoCall" /></td>
							<td><form:checkbox path="service_VDOCALL" readonly="true" />
							</td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label"
									key="VideoCall Bar Status" /></td>
							<td><form:input path="service_VDOCALL_bar"
									id="service_VDOCALL_bar" cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
					</table>
					<table border="0.5" style="width: 50%">
						<tr>
							<td><appfuse:label styleClass="control-label" key="SMS" /></td>
							<td><form:checkbox path="service_SMS" readonly="true" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="SMS BarIn Status" />
							</td>
							<td><form:input path="service_SMS_barin"
									id="service_SMS_barin" cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
						<tr>
							<td><appfuse:label styleClass="control-label" key="SMS BarOut Status" />
							</td>
							<td><form:input path="service_SMS_barout"
									id="service_SMS_barout" cssClass="span10" readonly="true"
									cssErrorClass="span10 error" /></td>
						</tr>
					</table>
					<table border="0" style="width: 50%">
						<!-- SONGPON 10/11/2014 -->
						<!-- <table border="0.5">
							<tr>
								<td><appfuse:label styleClass="control-label" key="Policy Control" /></td>
								<td><form:checkbox path="service_PCS" readonly="true" /></td>
							</tr>
							<tr> -->
								<!-- Edit by Wanatsanan 30/10/2014 -->
								<!--  <td><appfuse:label styleClass="control-label" key="Policy Main" />
								</td>
								<td><form:input path="service_PCS_Control_priceingplan"
										id="service_PCS_Control_priceingplan" cssClass="span10"
										readonly="true" cssErrorClass="span10 error" /></td>
							</tr>
							<tr> -->
								<!-- Edit by Wanatsanan 30/10/2014 -->
								<!-- <td><appfuse:label styleClass="control-label" key="Start Date" /></td> -->
								<!-- SONGPON 10/11/2014 -->
								<!--  <td><form:input
										path="service_PCS_Control_priceingplan_startdate"
										id="service_PCS_Control_priceingplan_startdate"
										cssClass="span10" readonly="true"
										cssErrorClass="span10 error" /></td>
							</tr>
						</table> -->
						<!-- SONGPON 10/11/2014 -->						
						<!--  <table border="0.5">
							<tr>-->
								<!-- Edit by Wanatsanan 30/10/2014 -->
								<!-- <td><appfuse:label styleClass="control-label" key="Topping" /></td>
								<td><form:input path="service_PCS_Control_topping"
										id="service_PCS_Control_topping" cssClass="span10"
										readonly="true" cssErrorClass="span10 error" /></td>
							</tr>
							<tr> -->
								<!-- Edit by Wanatsanan 30/10/2014 -->
								<!-- <td><appfuse:label styleClass="control-label" key="Start Date" /></td>  -->
								<!-- SONGPON 10/11/2014 -->
								<!-- <td><form:input
										path="service_PCS_Control_topping_startdate"
										id="service_PCS_Control_topping_startdate"
										cssClass="span10" readonly="true"
										cssErrorClass="span10 error" /></td>
							</tr>
						</table>	-->					
						
					</table>

				</table>
			</div>
			<div id="tab2" class="tab_content">
				<form:form commandName="queryPlan" method="post" action="queryPlanForm"
					onsubmit="return onFormSubmit(this)" id="queryPlan">
				<table border="0.5" style="width: 50%">
					<tr>
						<td><appfuse:label styleClass="control-label" key="HLRTemplate" /></td>
						<td><form:input path="HLRTemplate" id="HLRTemplate"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="30" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Voice" /></td>
						<td><form:input path="voice" id="voice"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Domestic roaming" /></td>
						<td><form:input path="domestic_roaming" id="domestic_roaming" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="International Call" /></td>
						<td><form:input path="international_call" id="international_call" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="International Roaming" /></td>
						<td><form:input path="international_roaming" id="international_roaming"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Video Call" /></td>
						<td><form:input path="video_call" id="video_call"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="SMS" /></td>
						<td><form:input path="sms" id="sms"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>	
					<tr>
						<td><appfuse:label styleClass="control-label" key="MMS" /></td>
						<td><form:input path="mms" id="mms"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Data" /></td>
						<td><form:input path="data" id="data"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>	
					<tr>
						<td><appfuse:label styleClass="control-label" key="MCN" /></td>
						<td><form:input path="mcn" id="mcn"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>		
					<tr>
						<td><appfuse:label styleClass="control-label" key="PCRF" /></td>
						<td><form:input path="pcrf" id="pcrf"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="30" /></td>
					</tr>					
				</table>					
				</form:form>
			</div>
			<div id="tab3" class="tab_content">
				<table border="0.5" style="width: 80%">
					<tr>
						<td><appfuse:label styleClass="control-label" key="IN Identification" /></td>
						<td><form:input path="aluinidentification" id="aluinidentification"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="11" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Number Status" /></td>
						<td><form:input path="status" id="status" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="15" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Balance" /></td>
						<td><form:input path="balance" id="balance" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="15" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Active Date" /></td>
						<td><form:input path="activityDate" id="activityDate"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Inactive (Bar oneway)" /></td>
						<td><form:input path="inactiveDate1" id="inactiveDate1"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Inactive (Bar twoway)" /></td>
						<td><form:input path="inactiveDate2" id="inactiveDate2"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Deactive" /></td>
						<td><form:input path="deactivityEndDate" id="deactivityEndDate"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Admin Block" /></td>
						<td><form:checkbox path="adminBlocked" readonly="true" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="ALUIN Suspense" /></td>
						<td><form:checkbox path="aluinisSuspend" readonly="true" /></td>
					</tr>					
				</table>
			</div>
			<div id="tab4" class="tab_content">
				<table border="0.5" style="width: 50%">
					<tr>
						<td><appfuse:label styleClass="control-label" key="Imsi" /></td>
						<td><form:input path="imsi" id="imsi"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Iccid" /></td>
						<td><form:input path="iccid" id="iccid"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="20" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Encrypt Key" /></td>
						<td><form:input path="ki" id="ki" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="40" />
						</td>
					</tr>
					<!-- Edit by Wanatsanan 07/04/2016 -->
					<tr>
						<td><appfuse:label styleClass="control-label" key="Transport Key" /></td>
						<td><form:input path="transportKey" id="transportKey" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="40" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Puk1" /></td>
						<td><form:input path="puk1" id="puk1" cssClass="span10"
								readonly="true" cssErrorClass="span10 error" maxlength="15" />
						</td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Puk2" /></td>
						<td><form:input path="puk2" id="puk2"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Pin1" /></td>
						<td><form:input path="pin1" id="pin1"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>
					<tr>
						<td><appfuse:label styleClass="control-label" key="Pin2" /></td>
						<td><form:input path="pin2" id="pin2"
								cssClass="span10" readonly="true"
								cssErrorClass="span10 error" maxlength="15" /></td>
					</tr>							
				</table>
			</div>
			<div id="tab5" class="tab_content">
				<display:table name="queryAPN" cellspacing="0" cellpadding="0" requestURI="" 
					    defaultsort="1" id="users" pagesize="25" class="table" export="true">
					    <display:column property="apnId" escapeXml="true" sortable="true" titleKey="apnId" style="width: 34%" url="/order/querySRDetail?from=list" paramId="apnId" paramProperty="apnId" class="hidden" headerClass="hidden"/>
					    <display:column property="apnName" escapeXml="true" sortable="true" titleKey="APN name" style="width: 30%" />    
					    <display:column property="apnArea" escapeXml="true" sortable="true" titleKey="Used Area" style="width: 25%" />
					    <display:column property="qosProfile" escapeXml="true" sortable="true" titleKey="QOS" style="width: 25%" />       					    					        					    
				</display:table>
			</div>
			<div id="tab6" class="tab_content">
				<display:table name="queryPCS" cellspacing="0" cellpadding="0" requestURI="" 
					    defaultsort="1" id="users" pagesize="25" class="table" export="true">
					    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="Msisdn" style="width: 34%" url="/order/querySRDetail?from=list" paramId="msisdn" paramProperty="msisdn" class="hidden" headerClass="hidden"/>
					    <display:column property="policyname" escapeXml="true" sortable="true" titleKey="Policy name" style="width: 30%" />    
					    <display:column property="startdate" escapeXml="true" sortable="true" titleKey="Start Date" style="width: 25%" />
					    <display:column property="enddate" escapeXml="true" sortable="true" titleKey="End Date" style="width: 25%" />       					    					        
					    <display:column property="quota" escapeXml="true" sortable="true" titleKey="Quota" style="width: 34%" />
				</display:table>
			</div>
			<!-- Edit by Wanatsanan 16/02/2016 -->
			<div id="tab7" class="tab_content">
				<display:table name="queryDataUsage" cellspacing="0" cellpadding="0" requestURI="" 
					    defaultsort="1" id="users" pagesize="25" class="table" export="true">
					    <display:column property="dataname" escapeXml="true" sortable="true" titleKey="Name" style="width: 30%" />
					    <display:column property="usage" escapeXml="true" sortable="true" titleKey="Usage" style="width: 25%" />
				</display:table>
				<br />
				<br />
				<br />
				<br />
				<br />
				<br />
				<label class="cdr_updated">${lastUpdated}</label>
				<label class="cdr_updated">${nextUpdated}</label>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('querySRDetail'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validatequerySRDetail(theForm);
}
</script>

<v:javascript formName="addSub" staticJavascript="false" />
</body>

