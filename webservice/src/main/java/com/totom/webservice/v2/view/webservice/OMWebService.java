package com.totom.webservice.v2.view.webservice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.jws.HandlerChain;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.controller.PCRFController;
import net.tot3g.omclient.model.Response;
import net.tot3g.omclient.webservice.model.PublicLanguageData;
import net.tot3g.omclient.webservice.model.PublicStatusBar;
import net.tot3g.omclient.webservice.model.PublicSubData;
import net.tot3g.omclient.webservice.model.SIMMMobileType;

public class OMWebService {
	
	public OMWebService()
	{
		
	}
	
	public Response[] subscribePCS(String username , String password ,String priceplan,String msisdn)	
	{	
		//Initialize
		Response response = new Response();
		Collection<Response> details = new ArrayList<Response>();		
		try {
			
			PCRFController subscribtion = (PCRFController)Constants.ctx.getBean("pcrfController"); 

			//Call Controller
			response = subscribtion.callsubscribePCS(username, password, priceplan, msisdn);
			details.add(response);
		} catch (Exception e) {
			//Exception
			e.printStackTrace();
			response.setResponseCode("Error");			
			if(Constants.DEBUG)
				response.setDescription("EXCEPTION : "+e.getLocalizedMessage());
			else
				response.setDescription("EXCEPTION");
			
			details.add(response);
		}
		
		return details.toArray(new Response[0]);
	}
	
	public Response[] subscribeDATA(String username , String password ,String priceplan,String msisdn)	
	{						
		
		Collection<Response> details = new ArrayList<Response>();		
		
		Response response = new Response();
		//DataController subscribtion = (DataController)Constant.ctx.getBean("datacontroller"); 
		try {
			//TODO ADD SUBSCRIBEDATA LOGIC
			//response = subscribtion.subscribeData(username, password, priceplan, msisdn);
			details.add(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}
	
	public Response[] resetPCS(String username,String password, String usedQuota, String totalQuota, String QOS,String billingstartdate,String billingduration,String msisdn)	
	{						
		
		Collection<Response> details = new ArrayList<Response>();		
		
		Response response = new Response();
		//PCSController subscribtion = (PCSController)Constant.ctx.getBean("pcscontroller"); 
		try {
			//TODO ADD resetPCS LOGIC
			//response = subscribtion.resetPCS(username, password, usedQuota, totalQuota, QOS,billingstartdate,billingduration,msisdn);
			details.add(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}
	
	public Response[] unsubscribePCS(String username , String password ,String msisdn)	
	{		 		
		
		Collection<Response> details = new ArrayList<Response>();		
		
		Response response = new Response();
		//PCSController subscribtion = (PCSController)Constant.ctx.getBean("pcscontroller"); 
		try {
			//TODO ADD UNSUBPCS LOGIC
			//response = subscribtion.unsubscribePCS(username, password, msisdn);
			details.add(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}
	
	public PublicSubData[] querySubscriber(String username , String password ,String msisdn,String iccid,String imsi)
	{				
		
		Collection<PublicSubData> details = new ArrayList<PublicSubData>();	
		
		PublicSubData subdata = new PublicSubData();
		
		//TODO ADD querySubscriber LOGIC			
		//SubscriberController commandObj = (SubscriberController) Constant.ctx.getBean("subscribercontroller");
			
		//PublicSubData subdata = commandObj.querySubscriber(username, password, msisdn,iccid,imsi);
		details.add(subdata);	
				
		
		return details.toArray(new PublicSubData[0]);
	}
	
	public PublicLanguageData[] queryLanguageSubscriber(String username , String password ,String msisdn,String iccid,String imsi)
	{		
		
		Collection<PublicLanguageData> details = new ArrayList<PublicLanguageData>();				
		PublicLanguageData subdata = new PublicLanguageData();
		
		//TODO ADD querySubscriber LOGIC			
		//SubscriberController commandObj = (SubscriberController) Constant.ctx.getBean("subscribercontroller");
			
		//PublicLanguageData subdata = commandObj.queryLanguage(username, password, msisdn,iccid,imsi);
		details.add(subdata);
		
		return details.toArray(new PublicLanguageData[0]);

	}
	
	public Response[] barsubscriber(String username , String password ,String msisdn,String operation)	
	{		
		
		Collection<Response> details = new ArrayList<Response>();	
		Response response = new Response();
		
		//BarController barcontroller = (BarController)Constant.ctx.getBean("barcontroller"); 
		try {
		//  TODO ADD barsubscriber LOGIC			
		//	Response response = barcontroller.barSubscriber(username, password, msisdn,operation);
			details.add(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}			

		
		return details.toArray(new Response[0]);
	}
	
	public Response[] unbarsubscriber(String username , String password ,String msisdn,String operation)	
	{		
		
		Collection<Response> details = new ArrayList<Response>();	
		Response response = new Response();
		//UnbarController unbarcontroller = (UnbarController)Constant.ctx.getBean("unbarcontroller"); 
		try {
			//  TODO ADD unbarsubscriber LOGIC			
			//Response response = unbarcontroller.unbarSubscriber(username, password, msisdn,operation);
			details.add(response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}			

		
		return details.toArray(new Response[0]);
	}
	
	public Response[] activateMSISDN(String username , String password ,String msisdn)	
	{		
		
		Collection<Response> details = new ArrayList<Response>();	
		Response response = new Response();
		//UnbarController unbarcontroller = (UnbarController)Constant.ctx.getBean("unbarcontroller"); 
		try {
			//TODO ADD activateMSISDN LOGIC			
			//Response response = unbarcontroller.ActivateMSISDN(username, password, msisdn);
			details.add(response);
		} catch (Exception e) {			
			e.printStackTrace();
		}			

		
		return details.toArray(new Response[0]);
	}
	
	public Response[] changePlan(String username , String password ,String priceplan,String msisdn)	
	{		
		
		Collection<Response> details = new ArrayList<Response>();	
		Response response = new Response();
		//PlanController plancontroller = (PlanController)Constant.ctx.getBean("planController"); 
		try {
			//TODO ADD changePlan LOGIC			
			//Response response = plancontroller.changePlan(username, password, priceplan,msisdn);
			details.add(response);
		} catch (Exception e) {			
			e.printStackTrace();
		}			

		
		return details.toArray(new Response[0]);
	}
	
	public Response[] changeLanguage(String username , String password ,String msisdn,String langcode)	
	{		 	
		Collection<Response> details = new ArrayList<Response>();				
		Response response = new Response();
		
		//SubscriberController subscribtion = (SubscriberController)Constant.ctx.getBean("subscribercontroller");
		try {
			//TODO ADD changeLanguage LOGIC			
			//response = subscribtion.changeLanguage(username, password, msisdn, langcode);
			details.add(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}
	
	public PublicStatusBar[] queryStatusBarOfSubscriber(String username , String password ,String msisdn,String iccid,String imsi)
	{		
		Collection<PublicStatusBar> details = new ArrayList<PublicStatusBar>();		
		PublicStatusBar subdata = new PublicStatusBar();
		
		//TODO ADD queryStatusBarOfSubscriber LOGIC			
		//SubscriberController commandObj = (SubscriberController) Constant.ctx.getBean("subscribercontroller");
		
		//PublicStatusBar subdata = commandObj.queryStatusBar(username, password, msisdn, iccid, imsi);
		details.add(subdata);	
	
		return details.toArray(new PublicStatusBar[0]);
	}
	
	public Response[] subscribeVoiceTopping(String username , String password ,String promotionid,String msisdn)	
	{						
		
		Collection<Response> details = new ArrayList<Response>();		
		
		Response response = new Response();
		//VoiceController subscribtion = (VoiceController)Constant.ctx.getBean("voicecontroller"); 
		try {
			//TODO ADD subscribeVoiceTopping LOGIC			
			//response = subscribtion.subscribeVoiceTopping(username, password, promotionid, msisdn);
			details.add(response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}
	
	public SIMMMobileType[] getSIMMMobiletype(String msisdn)	
	{		 	
		Collection<SIMMMobileType> details = new ArrayList<SIMMMobileType>();				

		//TODO ADD getSIMMMobiletype LOGIC		
		//SIMMSubmitter commandObj = (SIMMSubmitter) Constant.ctx.getBean("SIMMSubmitter");
			
		//String mobiletype = commandObj.getSIMMType(msisdn);
		//String brandcode = commandObj.getBrandcode(msisdn);
		
		SIMMMobileType simtype = new SIMMMobileType();
		simtype.setMsisdn(msisdn);
		//simtype.setMobiletype(mobiletype);	
		//simtype.setBrandcode(brandcode);
		details.add(simtype);
		
		return details.toArray(new SIMMMobileType[0]);
	}
	
	public Response[] suspend(String username , String password ,String msisdn)	
	{		 	
		Collection<Response> details = new ArrayList<Response>();				
		Response res = new Response();
		
		//TODO ADD suspend LOGIC		
		//SubscriberController commandObj = (SubscriberController) Constant.ctx.getBean("subscribercontroller");
			
		//Response res = commandObj.suspend(username, password, msisdn);
		
		details.add(res);
		
		return details.toArray(new Response[0]);
	}
	
	public Response[] unsuspend(String username , String password ,String msisdn)	
	{		 	
		Collection<Response> details = new ArrayList<Response>();				
		Response res = new Response();
		
		//TODO ADD unsuspend LOGIC		
		//SubscriberController commandObj = (SubscriberController) Constant.ctx.getBean("subscribercontroller");
			
		//Response res = commandObj.unsuspend(username, password, msisdn);
		
		details.add(res);
		
		return details.toArray(new Response[0]);
	}
	
	public Response[] subscribePCSToOTHER(String username , String password ,String priceplan,String targetmsisdn,String sourcemsisdn)	
	{						
		
		Collection<Response> details = new ArrayList<Response>();				
		Response response = new Response();
		
		//PCSController subscribtion = (PCSController)Constant.ctx.getBean("pcscontroller"); 
		try {
			//TODO ADD subscribePCSToOTHER LOGIC		
			//response = subscribtion.subscribePCSTOOTHER(username, password, priceplan, targetmsisdn, sourcemsisdn);
			details.add(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details.toArray(new Response[0]);
	}

}
