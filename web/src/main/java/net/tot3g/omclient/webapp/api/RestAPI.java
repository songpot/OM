package net.tot3g.omclient.webapp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import net.tot3g.omclient.Constants;

public class RestAPI extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private final Log log = LogFactory.getLog(getClass());

    public static final String AUTHFAIL = "Authentication Failed";
       
    public RestAPI() {
        super();        
    }

	/**
	 * 
	 * JSON Return SPEC
	 *  
	 *  issuccess
	 *  omorderid
	 *  remaining
	 *  mobiletype
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
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
        	
        	JSONObject responseobj = new JSONObject();
        	
            try {
				responseobj.put("issuccess", "true");
				responseobj.put("omorderid", "0000000");
				responseobj.put("remaining", "1000");
				responseobj.put("mobiletype", "POST");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

            out.println(responseobj.toString());
        }
        else
        {
        	log.info(AUTHFAIL);
        }
		
		
	}

}
