package net.tot3g.omclient.webapp.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	/* localhost:8081/OMWeb/j_security_check?jkd=OMCRM&crmusername=test&crmpassword=test&userlevel=0 */
	
	private boolean postOnly;
	
	private AuthenticationManager crmAuthenticationManager;
	
	public static String userlevel = "";
	
	public boolean isPostOnly() {
    	return postOnly;
    }

	public void setPostOnly(boolean postOnly) {
    	this.postOnly = postOnly;
    }
	
	public AuthenticationManager getCrmAuthenticationManager() {
    	return crmAuthenticationManager;
    }

	public void setCrmAuthenticationManager(AuthenticationManager crmAuthenticationManager) {
    	this.crmAuthenticationManager = crmAuthenticationManager;
    }

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        userlevel = "";
        
        String fromCRM = request.getParameter("jkd");
		if (StringUtils.isNotBlank(fromCRM)&&fromCRM.equals("OMCRM")) {
			//ok
			username = request.getParameter("crmusername");
			password = request.getParameter("crmpassword");
			username = "OMCRM_"+username;
			userlevel = request.getParameter("userlevel");
			
		}	
		
		if (StringUtils.isNotBlank(fromCRM)&&fromCRM.equals("USSD")) {
			//ok
			username = request.getParameter("ussdusername");
			password = request.getParameter("ussdpassword");
			username = "USSD_"+username;
			userlevel = "1";			
		}

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();
        
       	

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Place the last username attempted into HttpSession for views
        HttpSession session = request.getSession(false);

        if (session != null || getAllowSessionCreation()) {
            request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
        }

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        if (StringUtils.isNotBlank(fromCRM)&&fromCRM.equals("OMCRM")) {
        	return getCrmAuthenticationManager().authenticate(authRequest);
        }
        else if (StringUtils.isNotBlank(fromCRM)&&fromCRM.equals("USSD"))	{
        	return getCrmAuthenticationManager().authenticate(authRequest);
        } else {
        	return this.getAuthenticationManager().authenticate(authRequest);
        }
        
    }	
	
	
}
