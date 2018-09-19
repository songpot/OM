package net.tot3g.omclient.webapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.model.ChangePlan;
import net.tot3g.omclient.model.Menuconfig;
import net.tot3g.omclient.model.Price_plan;
import net.tot3g.omclient.model.Response;
import net.tot3g.omclient.model.SubscriberData;
import net.tot3g.omclient.webapp.listener.StartupListener;

@Controller
@RequestMapping("/admin/menuConfig*")
public class MenuController extends BaseFormController {
	

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Menuconfig menudata, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView("redirect:/mainMenu");
		}

		if (validator != null) { // validator is null during testing
			validator.validate(menudata, errors);
			if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
				return new ModelAndView("/admin/menuConfig", "menuconfig", menudata);
			}
		}
				
		
		FileWriter fw = new FileWriter(getServletContext().getRealPath("/WEB-INF/menu-config.xml"));
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw, true);
		
		pw.println(menudata.getXmldata());		
		
		
			
		return new ModelAndView("redirect:/mainMenu");
	}

	private ModelAndView ChangePlan(ChangePlan changePlan, HttpServletRequest request,
			Locale locale) throws RemoteException, Exception {
				
		return null;

	}

	@RequestMapping(method = { RequestMethod.POST,RequestMethod.GET })
	protected ModelAndView display(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		Menuconfig cf = new Menuconfig();
		
		InputStream resourceContent = getServletContext().getResourceAsStream("/WEB-INF/menu-config.xml");

		BufferedReader reader = new BufferedReader(new InputStreamReader(resourceContent));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	      sb.append(line + "\n");
	    }

	    cf.setXmldata(sb.toString());
	    
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("menuConfig", cf);
		return new ModelAndView("admin/menuConfig", model);
	}

	private boolean isFormSubmission(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("post");
	}
	
	protected static String httpGET(String urlString){
		String charset 	= "UTF-8";		
		StringBuilder content = new StringBuilder();
		try{			
			String line;
			URL url = new URL(urlString);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Accept-Charset", charset);
	
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	
			while ((line = bufferedReader.readLine()) != null){
				content.append(line + "\n");
			}
			
			bufferedReader.close();
			
			return content.toString();
		}catch(Exception e){
			return "";
		}
	}
	
}
