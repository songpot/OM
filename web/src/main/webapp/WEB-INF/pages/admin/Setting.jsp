<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="setting.title" /></title>
<meta name="heading" content="<fmt:message key='setting.heading'/>" />
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

span.pagelinks {
    display: block;
    font-size: .95em;
    margin-bottom: 5px;
    margin-top: -18px;
    padding: 2px 0 2px 0;
    text-align: right;
    width: 100%;
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
	color: #000;
}

ul.tabs li.active a, ul.tabs li a.active{
	background-color:maroon;
	color: #fff;
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
	
	// Edit By Wanatsanan 25/07/2016
	$.urlParam = function(name){
		var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		if (results==null)
		{
		       return null;
		}
		else{
		       return results[1] || "";
		}
	}
	
	
	$(".tab_content").hide(); //Hide all content
	
	var tabNo = decodeURIComponent($.urlParam('from'));
	
	switch(tabNo) {
    case "voicetopping":
    	 $("#tab3").addClass("active").show();
    	 $('ul.tabs li a[href="#tab3"]').addClass("active").show();
        break;
    case "planpolicy":
    	 $("#tab4").addClass("active").show();
    	 $('ul.tabs li a[href="#tab4"]').addClass("active").show();
        break;
    default:
    	 $("ul.tabs li:first").addClass("active").show(); //Activate first tab
    	 $(".tab_content:first").show(); //Show first tab content 
	}
	
	

    //Default Action
  // $(".tab_content").hide(); //Hide all content
  //  $("ul.tabs li:first").addClass("active").show(); //Activate first tab
  //  $(".tab_content:first").show(); //Show first tab content        
         
    //On Click Event
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $("ul.tabs li a").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
        $(activeTab).fadeIn(); //Fade in the active content
        return false;
    });
    
    $('[name="pcsquery"]').click(function() {  
    	$('[name=from]').val("pcs");
    	$("#Setting").submit();        
    });
    
    $('[name="pcsreactive"]').click(function() {  
    	$('[name=from]').val("pcsreactive");
    	$("#Setting").submit();        
    });
    
    $('input[type=checkbox]').attr('disabled','true');
    
    // ***** Edit By Wanatsanan 25/07/2016 *****
    // Search #tab3 -- Voice Topping Policy
     
    $('[name="voicetoppingquery"]').click(function() {  
    	$('[name=from]').val("voicetopping");
    	$("#Setting").submit();
    });
    
    // Keep query voicetopping
    var vtname_q = $.urlParam('vtname');
	var vtstatus_q = $.urlParam('vtstatus');
	
    if(vtstatus_q !== null)
	  $('#vtstatus option[value="'+vtstatus_q+'"]').attr('selected','selected');
    
    var param_editvoicetopping = "vtname='"+vtname_q+"'&vtstatus='"+vtstatus_q+"'";

    // Delete voicetopping
    $("#deletevoicetopping").live("click",function(){
    	
    	var here = this;
    	
    	if(window.confirm("Are you sure to Delete this Voice Topping?"))
    	{
    		
    		var del_voicetopping_api = "../search/api/delvoicetopping?input=";
    		
    		var vt_id = $(this).attr("title");
    		
    		$.ajax({
				type : "GET",
				contentType : "application/json",
				url : del_voicetopping_api+vt_id,
				dataType: 'json',
				cache: false,
				timeout : 100000,
				success : function(result) {
					console.log("SUCCESS: ", result);
				
					$(here).closest('tr').find('td').fadeOut('fast',
		    	    		function(here){
		    	    			$(here).parents('tr:first').remove();
		    	    		});
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
    		
    	    	return false;
    	}
    	
    });
    
    
    // Search #tab4 -- Change Plan Policy 
    $('[name="planpolicyquery"]').click(function() {  
    	$('[name=from]').val("planpolicy");
    	$("#Setting").submit();        
    });
    
    // Option Search Box - Plan Policy
    var all_pplan_id;
	var all_dstallowedplan;
	
	 $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "../api/getallplantotprepaid",
			dataType: 'json',
			cache: false,
			timeout : 100000,
			success : function(result) {
				console.log("SUCCESS: ", result);
				
				all_plan = result.plan_id_name;
				
				$.each(all_plan, function(key, value){
				
					$('#ppolicy_id').append($('<option>', { 
						 value: value.id,
					     text : value.id+" - "+value.name
					}));
					
					$('#ppolicy_dst').append($('<option>', { 
						 value: value.id,
					     text : value.id+" - "+value.name
					}));
						
				});
				
			/*	$.each(all_dstallowedplan, function(key, value){
					
					$('#ppolicy_dst').append($('<option>', { 
						 value: value.id,
						 text : value.id+" - "+value.name 
					}));
				});*/
				
			
				// Keep query plan policy
			    var ppolicy_id_q = $.urlParam('ppolicy_id');
				var ppolicy_dst_q = $.urlParam('ppolicy_dst');
				var ppolicy_status_q = $.urlParam('ppolicy_status');
				
			    if(ppolicy_id_q !== null)
				  $('#ppolicy_id option[value="'+ppolicy_id_q+'"]').attr('selected','selected');
			    if(ppolicy_dst_q !== null)
					  $('#ppolicy_dst option[value="'+ppolicy_dst_q+'"]').attr('selected','selected');
			    if(ppolicy_status_q !== null)
					  $('#ppolicy_status option[value="'+ppolicy_status_q+'"]').attr('selected','selected');
			
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
				alert("s");
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	 
	// Delete planpolicy
	    $("#deleteplanpolicy").live("click",function(){
	    	
	    	var here = this;
	    	
	    	if(window.confirm("Are you sure to Delete this Plan Policy?"))
	    	{
	    		
	    		var del_planpolicy_api = "../api/delplanpolicy";
	    		
	    		var pp_id = $(this).attr("title");
	    		var pp_id_plan = pp_id.substring(0,pp_id.indexOf(","));
	    		var pp_id_plan_allowed = pp_id.substring(pp_id.lastIndexOf(",")+1);
	    		
	    		var pp_plan = "?plan_id="+pp_id_plan+"&plan_allowed="+pp_id_plan_allowed;
	    		
	    		$.ajax({
					type : "GET",
					contentType : "application/json",
					url : del_planpolicy_api+pp_plan,
					dataType: 'json',
					cache: false,
					timeout : 100000,
					success : function(result) {
						console.log("SUCCESS: ", result);
					
						$(here).closest('tr').find('td').fadeOut('fast',
			    	    		function(here){
			    	    			$(here).parents('tr:first').remove();
			    	    		});
						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
	    		
	    	    	return false;
	    	}
	    	
	    });
	
	  
	   
    
	
    
    
});
</script>
</head>
<body>
<form:form class="form-horizontal" commandName="Setting" method="get" action="SettingForm"
			onsubmit="return onFormSubmit(this)" id="Setting">
<input type="hidden" name="from" value="" />
	
<h2><fmt:message key="setting.title"/></h2><br />    
	<div class="container">
		<ul class="tabs">
			<li><a href="#tab1">PCS Profiles Policy</a></li>
			<li><a href="#tab2">PCS Reactivated Policy</a></li>
			<li><a href="#tab3">Voice Topping Policy</a></li>
			
			<!-- Edit by Wanatsanan 16/02/2016 -->
			<li><a href="#tab4">Change Plan Policy</a></li>			
						
		</ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">						
			 <table class="table table-striped" border="0.5">				 		
						<table border="0.5">
										<tr>
											<td><appfuse:label styleClass="desc" key="Policy Name" /></td>
											<td><input class="span8 search-query"  type="text" size="20" name="q" id="query" value="${param.q}" placeholder="Enter Policy name" /></td>
										</tr>
										<tr>
											<td><appfuse:label styleClass="desc" key="Enable" /></td>
											<td><select name="isactive"  value="${param.isactive}" >
											        	<option value="ALL">All</option>
											        	<option value="0">Enable</option>
											        	<option value="1">Disable</option>											        	   	
											   </select></td>			           				
										</tr>					    				
										<tr>
											<td><input type="submit" name="pcsquery" value="<fmt:message key="button.search"/>"/></td>	
											<td></td>																	
										</tr>
							</table>
					
					
					<display:table name="PCS_Setting" cellspacing="0" cellpadding="0" requestURI="" 
					    defaultsort="1" id="pcs" pagesize="25" class="table" export="true">					    
					    <display:column property="pcs_id" escapeXml="true" sortable="true" titleKey="Profile ID" style="width: 14%" url="/admin/settingPCS?operation=Edit" paramId="pcs_id" paramProperty="pcs_id"/>
					    <display:column property="priceplan" escapeXml="true" sortable="true" titleKey="Price plan" style="width: 50%" url="/admin/settingPCS?operation=Edit" paramId="pcs_id" paramProperty="pcs_id"/>    
					    <display:column property="mobiletype" escapeXml="true" sortable="true" titleKey="MobileType" style="width: 14%" paramId="pcs_id" paramProperty="pcs_id" />
					    <display:column sortProperty="active" sortable="true" titleKey="Enabled" style="width: 16%; padding-left: 15px" media="html">
					        <input type="checkbox" disabled="disabled" <c:if test="${pcs.active}">checked="checked"</c:if> />
					    </display:column>    
					    <display:column titleKey="Delete" style="width: 20%" >
						    	<input type="button" class="btn btn-primary" id="deletepcstopping" value="Delete" title="${pcs.pcs_id}"/>
						</display:column>   
					</display:table>
					<br />
					<div class="input-append">
				    	<input type="button" class="btn btn-primary" name="addnewpolicy"  value="ADD"/>				            
				    </div>

			  </table>
			  
			</div>
			<div id="tab2" class="tab_content">	
						<table class="table table-striped" border="0.5">				 		
									<table border="0.5">													
													<tr>
														<td><appfuse:label styleClass="desc" key="Greeting" /></td>
														<td><select name="isgreeting"  value="${param.isgreeting}" >
														        	<option value="ALL">All</option>
														        	<option value="0">Enable</option>
														        	<option value="1">Disable</option>											        	   	
														   </select></td>			           				
													</tr>					    				
													<tr>
														<td><input type="submit" name="pcsreactive" value="<fmt:message key="button.search"/>"/></td>	
														<td></td>																	
													</tr>
										</table>
								
								
								<display:table name="REACTIVATE_Setting" cellspacing="0" cellpadding="0" requestURI="" 
								    defaultsort="1" id="pcsreactivate" pagesize="25" class="table" export="true">					    
								    <display:column property="ID" escapeXml="true" sortable="true" titleKey="Profile ID" style="width: 14%" url="/admin/settingPCS" paramId="ID" paramProperty="ID"/>
								    <display:column property="Promotion_ID" escapeXml="true" sortable="true" titleKey="Price plan ID" style="width: 50%" url="/admin/settingPCS" paramId="ID" paramProperty="ID"/>  
								    <display:column property="PCS_priceplan" escapeXml="true" sortable="true" titleKey="PCS priceplan" style="width: 14%" paramId="ID" paramProperty="ID" />
								    <display:column property="Isgreeting" escapeXml="true" sortable="true" titleKey="IsGreeting" style="width: 14%" paramId="ID" paramProperty="ID" />
								</display:table>
								<br />
								<div class="input-append">
							    	<input type="button" class="btn btn-primary" name="addnewpolicy"  value="ADD"/>				            
							    </div>
			
						  </table>
			</div>
			<!-- Edit by Wanatsanan 22/07/2016 -->
			<div id="tab3" class="tab_content">			
				<table class="table table-striped" border="0.5">				 		
					<table border="0.5">
					
						<tr>
           					<td><appfuse:label styleClass="desc" key="Voice Topping Name" /></td>
           					<td><input type="text" size="20" name="vtname" id="vtname" value="${param.vtname}"
           						placeholder="Voice Topping Name"/>
           					</td>
						</tr>													
						<tr>
						 	<td><appfuse:label styleClass="desc" key="Status" /></td>
           					<td>
           						<select path="vtstatus" name="vtstatus" id="vtstatus" cssClass="large" cssErrorClass="large error">
						       		<option value="">All</option>
						       		<option value="0">Active</option>
						       		<option value="1">Inactive</option>
					   			</select>
					   		</td>
						</tr>
						<tr>
							<td><input type="submit" name="voicetoppingquery" value="<fmt:message key="button.search"/>"/></td>	
							<td></td>																	
						</tr>
					</table>
								
						<display:table name="Setting_VoiceTopping" cellspacing="0" cellpadding="0" requestURI="" 
						   defaultsort="1" id="voicetopping" pagesize="25" class="table" export="true">
						   
						  
						   		    
						    <display:column property="planID" escapeXml="true" sortable="true" titleKey="Voice Topping ID" style="width: 20%" />
						    <display:column property="description" escapeXml="true" sortable="true" titleKey="Voice Topping Name" style="width: 40%"/>
						    <display:column property="price" escapeXml="true" sortable="true" titleKey="Price" style="width: 14%" />
						    <display:column property="amount" escapeXml="true" sortable="true" titleKey="Amount" style="width: 14%" />   
						    <display:column property="amountType" escapeXml="true" sortable="true" titleKey="AmountType" style="width: 14%" />
						    <display:column property="mobileType" escapeXml="true" sortable="true" titleKey="MobileType" style="width: 14%" />
						    <display:column titleKey="Edit" style="width: 20%">
						    	<input type="button" class="btn btn-primary" id="editvoicetopping" value="Edit" onclick="location.href='<c:url value="/admin/settingVoiceTopping?planID=${voicetopping.planID}&operation=Edit&vtname=${param.vtname}&vtstatus=${param.vtstatus}"/>'" />
						    </display:column>  
						     <display:column titleKey="Delete" style="width: 20%" >
						    	<input type="button" class="btn btn-primary" id="deletevoicetopping" value="Delete" title="${voicetopping.planID}"/>
						    </display:column>   
						</display:table>
						
						<br />
						
						<div class="input-append">
							<input type="button" class="btn btn-primary" style="margin-right: 5px" onclick="location.href='<c:url value="/admin/settingVoiceTopping?operation=Add&vtname=${param.vtname}&vtstatus=${param.vtstatus}"/>'" value="<fmt:message key="button.add"/>" id="addvoicetopping"/> />		            
						</div>
			
				</table>	
			</div>
			<div id="tab4" class="tab_content">
				<table class="table table-striped" border="0.5">				 		
					<table border="0.5">
					
						<tr>
							<td><appfuse:label styleClass="desc" key="Plan ID" /></td>
							<td>
								<select path="ppolicy_id" name="ppolicy_id" id="ppolicy_id" cssClass="large" cssErrorClass="large error" value="${param.ppolicy_id}">
									<option value="">All</option>
								</select>
							</td>
           					
           					<td><appfuse:label styleClass="desc" key="Destination Plan" /></td>
						    <td>
								<select path="ppolicy_dst" name="ppolicy_dst" id="ppolicy_dst" cssClass="large" cssErrorClass="large error" value="${param.ppolicy_dst}">
									<option value="">All</option>
								</select>
							</td>
						</tr>											
					    <tr>
						 	<td><appfuse:label styleClass="desc" key="Status" /></td>
           					<td>
           						<select path="ppolicy_status" name="ppolicy_status" id="ppolicy_status" cssClass="large" cssErrorClass="large error" value="${param.ppolicy_status}">
						       		<option value="">All</option>
						       		<option value="0">Active</option>
						       		<option value="1">Inactive</option>
					   			</select>
					   		</td>
					   		<td></td>	
					   		<td></td>			
						</tr>
						<tr>
							<td><input type="submit" name="planpolicyquery" value="<fmt:message key="button.search"/>"/></td>
							<td></td>
							<td></td>		
							<td></td>																				
						</tr>
					</table>
								
						<display:table name="Setting_PlanPolicy" cellspacing="0" cellpadding="0" requestURI="" 
						   defaultsort="1" id="planpolicy" pagesize="25" class="table" export="true">
						   					    
						    <display:column property="plan_id" escapeXml="true" sortable="true" titleKey="Plan ID" style="width: 14%"/>
						    <display:column property="plan_allowed" escapeXml="true" sortable="true" titleKey="Destination Plan" style="width: 50%"/>
						    <display:column titleKey="Edit" style="width: 20%">
						    	<input type="button" class="btn btn-primary" id="editplanpolicy" value="Edit" onclick="location.href='<c:url value="/admin/settingPlanPolicy?plan_id=${planpolicy.plan_id}&plan_allowed=${planpolicy.plan_allowed}&operation=Edit&ppolicy_id=${param.ppolicy_id}&ppolicy_dst=${param.ppolicy_dst}&ppolicy_status=${param.ppolicy_status}" />'" />
						    </display:column>  
						     <display:column titleKey="Delete" style="width: 20%">
						    	<input type="button" class="btn btn-primary" id="deleteplanpolicy" value="Delete" title="${planpolicy.plan_id},${planpolicy.plan_allowed}" />
						    </display:column>     
						</display:table>
						<br />
						
						<div class="input-append">
							<input type="button" class="btn btn-primary" style="margin-right: 5px" onclick="location.href='<c:url value="/admin/settingPlanPolicy?operation=Add&ppolicy_id=${param.ppolicy_id}&ppolicy_dst=${param.ppolicy_dst}&ppolicy_status=${param.ppolicy_status}"/>'" value="<fmt:message key="button.add"/>" id="addplanpolicy"/> />     
						</div>
			
				</table>				
			</div>			
		</div>
	</div>

</form:form>
<script type="text/javascript">
    Form.focusFirstElement($('queryForm'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) {
    return validateQueryForm(theForm);
}
</script>

<v:javascript formName="addSub" staticJavascript="false" />
<script type="text/javascript"
	src="<c:url value="/scripts/validator.jsp"/>"></script>
</body>

