package net.tot3g.omclient.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.webapp.listener.StartupListener;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * This class is used to reload the drop-downs initialized in the
 * StartupListener.
 *
 * <p>
 * <a href="ReloadController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/admin/reload*")
public class ReloadController {
    private transient final Log log = LogFactory.getLog(ReloadController.class);

    @RequestMapping(method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'execute' method");
        }

        StartupListener.setupContext(request.getSession().getServletContext());

        String referer = request.getHeader("Referer");
        
        Properties p = new Properties();
            	
    			try
    			{
    				p.loadFromXML(ReloadController.class.getResourceAsStream("/ApplicationConfig.properties"));
    				
    				System.out.println("ApplicationConfig.properties --> isAllowPostpaidSUBMIT : "+p.get("isAllowPostpaidSUBMIT"));
    				
    				Constants.isAllowPostpaidSUBMIT = "";
    				Constants.isPolicyChangeplanAllow = "";
    				Constants.TRANSPERMINUTE = "";
    				Constants.PROMOTION_CANSUBVOICETOPPING ="";
    				Constants.IMSI_COOPERATE_RANGE="";
    				Constants.CDR_RATING = "";
    				    				    		    			
    				Constants.isPolicyChangeplanAllow = (String) p.get("ispolicychangeplanallow");				
    				Constants.isAllowPostpaidSUBMIT = (String) p.get("isAllowPostpaidSUBMIT");
    				Constants.TRANSPERMINUTE = (String) p.get("tpm");
    				
    				Constants.PROMOTION_CANSUBVOICETOPPING = (String)p.getProperty("voicetoppingpromotion");    				
    				Constants.IMSI_COOPERATE_RANGE = (String)p.getProperty("imsi_cooperate");    			    			
    				Constants.CDR_RATING = (String)p.getProperty("cdr_rating");
    				Constants.MODPCS_TIMEROLLING = Boolean.valueOf(p.getProperty("modpcs_timerolling").toString());
    				Constants.CGW_ACT = Boolean.valueOf(p.getProperty("cgw_act").toString());    				
    				Constants.MODPCS_DATAROLLING = Boolean.valueOf(p.getProperty("modpcs_datarolling").toString());
    				Constants.MODPCS_SUBINTIME = Boolean.valueOf(p.getProperty("modpcs_subintime").toString());
    				
    				System.out.println("Constants.isAllowPostpaidSUBMIT --> isAllowPostpaidSUBMIT : "+Constants.isAllowPostpaidSUBMIT);
    				
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();		
    			}
    	

        if (referer != null) {
            log.info("reload complete, reloading user back to: " + referer);
            List<String> messages = (List) request.getSession().getAttribute(BaseFormController.MESSAGES_KEY);

            if (messages == null) {
                messages = new ArrayList();
            }

            messages.add("Reloading options completed successfully.");
            request.getSession().setAttribute(BaseFormController.MESSAGES_KEY, messages);

            response.sendRedirect(response.encodeRedirectURL(referer));
            return null;
        } else {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Context Reloaded</title>");
            out.println("</head>");
            out.println("<body bgcolor=\"white\">");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Context Reload Succeeded! Click OK to continue.');");
            out.println("history.back();");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }

        return null;
    }
    
}
