<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="querytoppinglog.title"/></title>
    <meta name="heading" content="<fmt:message key='queryoldorder.heading'/>"/>
    <meta name="menu" content="OrderMenu"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/scripts/css/smoothness/jquery-ui-1.10.3.custom.css'/>">  
	<script type="text/javascript" src="<c:url value='/scripts/js/jquery-1.9.1.js'/>"></script>  
	<script type="text/javascript" src="<c:url value='/scripts/js/jquery-ui-1.10.3.custom.min.js'/>"></script>  
	<script type="text/javascript">
		
	(function( $ ){
		
		   $.fn.selectTopping = function(toppingtypeValue,mobiletypeValue,toppingData,toppingVoice) {
			   
			   $('#topping option[value!=""]').remove();
			   
				
				if(toppingtypeValue === "" && mobiletypeValue === "prepaid")
				{	
					
					$.each(toppingData, function(key, value){
						
						if(value.mobileType === "prepaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				   $.each(toppingVoice, function(key, value){
						
						if(value.mobileType === "prepaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
				   
				}else if(toppingtypeValue === "" && mobiletypeValue === "postpaid")
				{	
					
					$.each(toppingData, function(key, value){
						
						if(value.mobileType === "postpaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				   $.each(toppingVoice, function(key, value){
						
						if(value.mobileType === "postpaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
				   
				}else if(toppingtypeValue === "data" && mobiletypeValue === "")
				{	
					$.each(toppingData, function(key, value){
					  	$('#topping').append($('<option>', { 
						       value: value.id,
						       text : value.name 
						}));
					});
					
				}else if(toppingtypeValue === "data" && mobiletypeValue === "prepaid")
				{
					$.each(toppingData, function(key, value){
						
						if(value.mobileType === "prepaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				}else if(toppingtypeValue === "data" && mobiletypeValue === "postpaid")
				{
					$.each(toppingData, function(key, value){
						
						if(value.mobileType === "postpaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				}else if(toppingtypeValue === "voice" && mobiletypeValue === "")
				{
					$.each(toppingVoice, function(key, value){
					  	$('#topping').append($('<option>', { 
						       value: value.id,
						       text : value.name 
						}));
					});
					
				}else if(toppingtypeValue === "voice" && mobiletypeValue === "prepaid")
				{
					$.each(toppingVoice, function(key, value){
						
						if(value.mobileType === "prepaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				}else if(toppingtypeValue === "voice" && mobiletypeValue === "postpaid")
				{
					
					$.each(toppingVoice, function(key, value){
						
						if(value.mobileType === "postpaid")
						{
							$('#topping').append($('<option>', { 
							       value: value.id,
							       text : value.name 
							}));
						}
					  	
					});
					
				}else if((toppingtypeValue === "" && mobiletypeValue === "") || (toppingtypeValue == "null" && mobiletypeValue == "null"))
				{
					
					$.each(toppingData, function(key, value){
					  	$('#topping').append($('<option>', { 
						       value: value.id,
						       text : value.name 
						}));
					});
					
					$.each(toppingVoice, function(key, value){
					  	$('#topping').append($('<option>', { 
						       value: value.id,
						       text : value.name 
						}));
					});
				}
		      return this;
		   }; 
	})( jQuery );	
	
	
	
	
	$(function(){
		
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

			
			var toppingtypecached = decodeURIComponent($.urlParam('toppingtype'));
			var mobiletypecached = decodeURIComponent($.urlParam('mobiletype'));
			var toppingcached = decodeURIComponent($.urlParam('topping'));
			var startDateTextBox = $('#startdate');
			var endDateTextBox = $('#enddate');
				
			var toppingData;
			var toppingVoice;
			
			
			
				
			$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "../search/api/getTopping/all",
					dataType: 'json',
					cache: false,
					timeout : 100000,
					success : function(result) {
						console.log("SUCCESS: ", result);
					
						toppingData = result.data;
						toppingVoice = result.voice;
						
						$('#topping').selectTopping(toppingtypecached,mobiletypecached,toppingData,toppingVoice);
						
						if(toppingtypecached !== null && toppingtypecached !== '')
							$('#toppingtype option[value="'+toppingtypecached+'"]').attr('selected','selected');
						
						if(mobiletypecached !== null && mobiletypecached !== '')
							$('#mobiletype option[value="'+mobiletypecached+'"]').attr('selected','selected');
						
						if(toppingcached !== null && toppingcached !== '')
							$('#topping option[value="'+toppingcached+'"]').attr('selected','selected');
						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			
			
			$('#toppingtype, #mobiletype').on('change', function (e) {
				
				var toppingtypeValue = $( "#toppingtype" ).val();
				var mobiletypeValue = $( "#mobiletype" ).val();
				
				$('#topping option[value!=""]').remove();
				toppingcached = '';
				$('#topping').selectTopping(toppingtypeValue,mobiletypeValue,toppingData,toppingVoice);
				
			});
			
			
			// Control input date
			
			$("#startdate").datepicker({
				maxDate: 0,
			 	dateFormat:'yy-mm-dd',
			 	onClose: function( selectedDate ) 
			 	{
			 		var minDate = $(this).datepicker('getDate');
			 		minDate.setDate(minDate.getDate()+1); 
			        $("#enddate").datepicker( "option", "minDate", minDate);
			    }
			});

			 $("#enddate").datepicker({
				maxDate: '+1d',
			 	dateFormat:'yy-mm-dd',
			 	onClose: function( selectedDate ) 
			 	{
			 		var maxDate = $(this).datepicker('getDate');
			 		maxDate.setDate(maxDate.getDate()-1); 
			        $("#startdate" ).datepicker( "option", "maxDate", maxDate );
			    }
			 });

		});  
	</script> 
        
</head>

<body>
<h2><fmt:message key="querytoppinglog.title"/></h2><br />
<form method="get" action="${ctx}/order/queryToppingLog" id="searchForm">
	<table border="0.5">
					<tr>
						<td><appfuse:label styleClass="desc" key="Msisdn" /></td>
						<td><input type="text" size="20" name="msisdn" id="msisdn" value="${param.msisdn}"
           					placeholder="MSISDN(66xxxxxxxxx)"/>
           				</td>
           					
           				<td><appfuse:label styleClass="desc" key="Topping type" /></td>
           				<td>
           					<select path="toppingtype" name="toppingtype" id="toppingtype" cssClass="large" cssErrorClass="large error" value="${param.toppingtype}" >
						       	<option value="">All</option>
						       	<option value="data">Data</option>
						       	<option value="voice">Voice</option>
					   		</select>
					   </td>
					</tr>
					
					<tr>
						<td><appfuse:label styleClass="desc" key="Mobile Type" /></td>
						<td><select path="mobiletype" name="mobiletype" id="mobiletype" cssClass="large" cssErrorClass="large error" value="${param.mobiletype}" >
						        	<option value="">All</option>
						        	<option value="prepaid">Prepaid</option>
						        	<option value="postpaid">Postpaid</option>     	
						   </select>
						 </td>
						 
						 <td><appfuse:label styleClass="desc" key="Topping" /></td>
						<td>
							<select path="topping" name="topping" id="topping" cssClass="large" cssErrorClass="large error" value="${param.topping}">
								<option value=""></option>
							</select>
						</td>
					</tr>	
					<tr>
						<td><appfuse:label styleClass="desc" key="Created>=" /></td>
						<td><input type="text" size="20" name="startdate" id="startdate" value="${param.startdate}"
           					placeholder="Start Date"/></td>
						<td><appfuse:label styleClass="desc" key="Created<=" /></td>
						<td><input type="text" size="20" name="enddate" id="enddate" value="${param.enddate}"
           					placeholder="End Date"/></td>
					</tr>				
					<tr>
						<td colspan="4"><input type="submit" value="<fmt:message key="button.search"/>" name="search"/></td>							
					</tr>
			</table>
</form>
<div id="search"></div>
<display:table name="queryTopping" cellspacing="0" cellpadding="0" requestURI=""  id="queryTopping" pagesize="25" class="table" export="true" sort="list">   
    <display:column property="msisdn" escapeXml="true" sortable="true" titleKey="MSISDN" style="width: 25%"/>
    <display:column property="topping" escapeXml="true" sortable="true" titleKey="PRICEPLAN" style="width: 25%"/>
    <display:column property="startDate" escapeXml="true" sortable="true" titleKey="STARTDATE" style="width: 30%"/>
    <display:column property="endDate" escapeXml="true" sortable="true" titleKey="ENDDATE" style="width: 30%" />
    <display:column property="mobileType" escapeXml="true" sortable="true" titleKey="MOBILE TYPE" style="width: 25%"/>
    <display:column property="sourceSystem" escapeXml="true" sortable="true" titleKey="SOURCESYSTEM" style="width: 25%"/>   
</display:table>


<script type="text/javascript">
    highlightTableRows("users");
</script>
</body>
