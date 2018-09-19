<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="settingplanpolicy.title" /></title>
<meta name="heading" content="<fmt:message key='settingplanpolicy.heading'/>" />
<meta name="menu" content="OrderMenu" />
<script type="text/javascript"
	src="<c:url value='/scripts/selectbox.js'/>"></script>
<!-- <script
	src="<c:url value='/scripts/latest-jquery/jquery-1.5.1.min.js'/>"
	type="text/javascript"></script>-->
<!-- <script
	src="<c:url value='/scripts/lib/jquery_ui/1_10_3/jquery-ui-1.10.3.custom.min.js'/>"
	type="text/javascript"></script>-->

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

.ui-autocomplete {
    position: absolute;
    z-index: 1000;
    cursor: default;
    padding: 0;
    margin-top: 2px;
    list-style: none;
    background-color: #ffffff;
    border: 1px solid #ccc;
    -webkit-border-radius: 5px;
       -moz-border-radius: 5px;
            border-radius: 5px;
    -webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
       -moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}
.ui-autocomplete > li {
  padding: 3px 20px;
}
.ui-autocomplete > li.ui-state-focus {
  background-color: #DDD;
}
.ui-helper-hidden-accessible {
  display: none;
}

</style>
<script type="text/javascript">
 
$(document).ready(function() {
 
   var activeStatusValue = "${selectedActiveStatus}";
   var operation = "${operation}";
	
   
   if(activeStatusValue !== "")
   {
	   $('#isactive option[value="'+activeStatusValue+'"]').attr('selected','selected');
   }
   
  
   if(operation == "Edit")
   {   
	   $('#plan_id').attr('readonly','readonly');
   }
   
   $('#plan_id,#plan_allowed').keypress(function(e) {
       var a = [];
       var k = e.which;
   
       for (i = 48; i < 58; i++)
           a.push(i);
       a.push(8);
       a.push(127);
   
       if (!($.inArray(k,a)>=0))
           e.preventDefault();
       
   });
   
   $('#plan_id,#plan_allowed').focus(function(){
	   
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
   				
 	 			var pplan = [];
   				var dstallowedplan;
   				
   				//pplan.push("1100");
   				
   				
   				$.each(all_plan,function(key,value){
   					
   					pplan.push(value.id+'-'+value.name)
   						
				});
   				
   				
   				if(operation == "Add")
   					$('#plan_id').autocomplete({
   					
   						source: pplan
   					});
   					
   				
   			
   				$('#plan_allowed').autocomplete({
   			
   					source: pplan,
   					minLength: 0
   				
   				});
   				
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
   });
  
   
  
   
   
  $('input[name=save]').click(function(){
	   
	   $("input").prop('required',true);
   });
  
  $('input[name=cancel]').click(function(){
	   
	  //var t = $("#plan_id").val();
	  // alert(t);
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
<h2><fmt:message key="settingplanpolicy.title"/></h2><br />
<form:form class="form-horizontal" commandName="settingPlanPolicy" method="post" action="settingPlanPolicyForm"
	onsubmit="return onFormSubmit(this)" id="settingPlanPolicy">
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>" />
	<input type="hidden" name="operation" id="operation" value="<c:out value="${param.operation}"/>" />
	
	<input type="hidden" name="ppolicy_id" value="<c:out value="${param.ppolicy_id}"/>" />
	<input type="hidden" name="ppolicy_dst" value="<c:out value="${param.ppolicy_dst}"/>" />
	<input type="hidden" name="ppolicy_status" value="<c:out value="${param.ppolicy_status}"/>" />
	
	<div id="tab1" class="control-group">						
		<table class="table table-striped" border="0.5">
			
							 		
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Plan Policy ID" />
				<div class="controls autocomplete">
					<form:input path="plan_id" id="plan_id" cssClass="span5" cssErrorClass="span5 error" maxlength="4" required="false" placeholder="Plan Policy ID"/>
				</div>
			</div>
			
			<div class="control-group">
				<appfuse:label styleClass="control-label" key="Destination Plan" />
				<div class="controls">
					<form:input path="plan_allowed" id="plan_allowed" cssClass="span5" cssErrorClass="span5 error" maxlength="4" required="false" placeholder="Destination Plan"/>
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
  			  <div class="controls">
     				<input type="submit" class="btn btn-primary"  name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
      				<input type="submit" class="btn btn-inverse"  name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
      				
      		  </div>
  			</div>       

		</table>
			  
	</div>
</form:form>

<script type="text/javascript">
    Form.focusFirstElement($('settingPlanPolicy'));
    highlightFormElements();

<!-- This is here so we can exclude the selectAll call when roles is hidden -->
function onFormSubmit(theForm) 
{	
	var btn = this.bCancel;
	var operation = document.getElementById('operation').value;
	if(btn === false)
		if(operation == "Edit")
			if (confirm("Are you sure to Edit this Plan Policy")) 
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

