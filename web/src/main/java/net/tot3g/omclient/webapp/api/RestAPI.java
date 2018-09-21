package net.tot3g.omclient.webapp.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.tot3g.omclient.Constants;

public class RestAPI extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private final Log log = LogFactory.getLog(getClass());

    public static final String AUTHFAIL = "Authentication Failed";
       
    public RestAPI() {
        super();        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rawrequest = org.apache.commons.io.IOUtils.toString(request.getInputStream(),"UTF-8");
    	//jObj = new JSONObject(rawrequest);
		
		String remoteip = request.getRemoteAddr();
		log.info("IP : "+remoteip);
		
		String[] whitelistip = Constants.WHITELISTIP.split(",");
		// Convert String Array to List
        List<String> list = Arrays.asList(whitelistip);
        
        if(list.contains(remoteip)){
        	log.info("Allowed list");
        	log.info(rawrequest);
        }
        else
        {
        	log.info(AUTHFAIL);
        }
		
		
	}

}
