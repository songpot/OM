package net.tot3g.omclient.webapp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hp.foss.webservice.GetMSISDNInfoResponseData;
import com.hp.foss.webservice.GetSIMCardInfoRequestData;
import com.hp.foss.webservice.GetSIMCardInfoResponseData;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.connector.CGWINConnector;
import net.tot3g.omclient.connector.SIMMConnector;
import net.tot3g.omclient.model.ALUInfoSub;
import net.tot3g.omclient.model.AddSub;
import net.tot3g.omclient.model.Price_plan;
import net.tot3g.omclient.model.Response;
import net.tot3g.omclient.model.SubscriberData;
import net.tot3g.omclient.service.UserManager;
import net.tot3g.omclient.webapp.controller.BaseFormController;

@Controller
@RequestMapping("/mainMenu")
public class MainMenuController extends BaseFormController {
	
	@Autowired
	private SIMMConnector simmconnector;
	
	@Autowired
	private CGWINConnector cgwinConnector;
	
	@RequestMapping(method = { RequestMethod.GET })
	protected ModelAndView display(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Locale locale = request.getLocale();	
		log.info("Loading ApplicationConfig.....");
		
		String mvnocode = Constants.MVNO_Code;
		
		log.info("Testing Connector.....");
		log.info("Testing GetSIMCardInfo Connector");
		GetSIMCardInfoResponseData responsedata =  simmconnector.getSimcardInfo("520151100036989");
		
		log.info("Testing GetMSISDNInfo Connector");
		GetMSISDNInfoResponseData responsemsisdndata =  simmconnector.getMSISDNInfo("893000933");
		
		log.info("Testing ALUIN Connector");
		ALUInfoSub alusubinfo =  cgwinConnector.getSubscriberALUInfoSub("66905070602","TOT3G");



		saveMessage(request,getText("company.name", mvnocode, locale));			
		
		return new ModelAndView("/mainMenu");
	}
}
