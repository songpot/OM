<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="nav-collapse collapse">
<ul class="nav" >
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="OrderMenuforUser"/>
    <menu:displayMenu name="OrderMenuforUpper"/>
    <menu:displayMenu name="OrderMenuforUPERCALL"/> 
    <menu:displayMenu name="OrderMenuforManager"/>       
    <menu:displayMenu name="ErrorManagement"/>
    <menu:displayMenu name="ErrorManagementforManager"/>
    <menu:displayMenu name="ServiceRegistry"/>    
    <menu:displayMenu name="AdminMenu"/>    
    <menu:displayMenu name="Logout"/>
</ul>
</div>
</menu:useMenuDisplayer>
