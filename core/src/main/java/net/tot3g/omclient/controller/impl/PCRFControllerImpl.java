package net.tot3g.omclient.controller.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.connector.INTERNAL.JSONConnector;
import net.tot3g.omclient.controller.PCRFController;
import net.tot3g.omclient.controller.WebServiceBaseController;
import net.tot3g.omclient.dao.SMS_Profile_Dao;
import net.tot3g.omclient.model.PCSAllData;
import net.tot3g.omclient.model.Response;
import net.tot3g.omclient.model.SMS_Profile;
import net.tot3g.omclient.model.SubscriberData;
import net.tot3g.omclient.model.WS_MVNO;
import net.tot3g.omclient.util.SendSMS;

public class PCRFControllerImpl extends WebServiceBaseController implements PCRFController {

	private final Log log = LogFactory.getLog(getClass());

	public static final String AUTHFAIL = "Authentication Failed";

	/*
	 * 
	 * JSON Request SPEC
	 * 
	 * operation = SubscribePCS ,msisdn ,priceplan
	 * 
	 * JSON Return SPEC
	 * 
	 * issuccess omorderid remaining mobiletype description
	 * 
	 */

	// WEBSERVICE PART

	@Autowired
	private JSONConnector jsonconnector;

	//

	public Response callsubscribePCS(String username, String password, String priceplan, String msisdn) {
		//INITIAL
		JSONObject requestobj = new JSONObject();
		Response res = new Response();
		
		log.info("[subscribePCS][" + msisdn + "] subscribePCS checkmvno");
		WS_MVNO mvno = checkMVNO(username, password, "subscribePCS");
		if (mvno.getWs_webappname() == null) {
			log.info("[subscribePCS][" + msisdn + "] subscribePCS "+AUTHFAIL);
			
			res.setResponseCode("Error");
			res.setDescription("You has not permission to use this service");
			return res;
		}
		
		try {
			log.info("[subscribePCS][" + msisdn + "] subscribePCS Create JSON Request");
			requestobj.put("operation", "subscribepcs");
			requestobj.put("msisdn", msisdn);
			requestobj.put("priceplan", priceplan);

			log.info("[subscribePCS][" + msisdn + "] subscribePCS Call RestAPI");
			String response = jsonconnector
					.sendJSONRequest(Constants.IPSERVER + "/" + mvno.getWs_webappname() + "/restapi", requestobj);
			
			log.info("[subscribePCS][" + msisdn + "] subscribePCS get RestAPI response and convert to JSON");
			JSONObject jsonres = new JSONObject(response);
			
			log.info("[subscribePCS][" + msisdn + "] subscribePCS get require response parameter");
			boolean issuccess = "true".equals(jsonres.getString("issuccess"))?true:false;
			String omorderid = jsonres.getString("omorderid");
			String remaining = jsonres.getString("remaining");	
			
			log.info("[subscribePCS][" + msisdn + "] subscribePCS check issuccess");
			if(issuccess)
			{
				log.info("[subscribePCS][" + msisdn + "] subscribePCS success");
				if(remaining!=null||!"".equals(remaining))
				{
					log.info("[subscribePCS][" + msisdn + "] subscribePCS set PREPAID Response");
					
					res.setResponseCode("Success");
					res.setDescription("Order id : "+ omorderid	+ " ,Remaining Money="+remaining);
					
					log.info("[subscribePCS][" + msisdn + "] subscribePCS get SMS message by username");
					
					SMS_Profile_Dao sms_profile = getSMSProfileByMVNO(username, password, "subpcs");
					List<SMS_Profile> sms_profile_list = sms_profile.getSMSMessage("register");
					if (sms_profile_list != null && sms_profile_list.size() > 0) {
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS sendsms and save sms transacion log");
						
						sendSMS(mvno,"0" + msisdn.substring(2),sms_profile_list.get(0).getSms_profile_messagetxt());					
					}								
				}
				else
				{
					log.info("[subscribePCS][" + msisdn + "] subscribePCS set POSTPAID Response");
					
					res.setResponseCode("Success");
					res.setDescription("Order id : "+ omorderid);
					
					log.info("[subscribePCS][" + msisdn + "] subscribePCS get SMS message by username");
					
					SMS_Profile_Dao sms_profile = getSMSProfileByMVNO(username, password, "subpcs");
					List<SMS_Profile> sms_profile_list = sms_profile.getSMSMessage("register");
					if (sms_profile_list != null && sms_profile_list.size() > 0) {
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS sendsms and save sms transacion log");
						
						sendSMS(mvno,"0" + msisdn.substring(2),sms_profile_list.get(0).getSms_profile_messagetxt());					
					}
				}
				
				return res;
			}
			else
			{
				log.info("[subscribePCS][" + msisdn + "] subscribePCS Failed");
				
				String description = jsonres.getString("description");
				
				if("Error Not enoght money".equals(description))
				{
					log.info("[subscribePCS][" + msisdn + "] subscribePCS Failed by Not enoght money");
					
					res.setResponseCode("Error");
					res.setDescription("Not enoght money");
					
					log.info("[subscribePCS][" + msisdn + "] subscribePCS get SMS message by username");
					
					SMS_Profile_Dao sms_profile = getSMSProfileByMVNO(username, password, "subpcs");
					List<SMS_Profile> sms_profile_list = sms_profile.getSMSMessage("credit");
					if (sms_profile_list != null && sms_profile_list.size() > 0) {
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS sendsms and save sms transacion log");
						
						sendSMS(mvno,"0" + msisdn.substring(2),sms_profile_list.get(0).getSms_profile_messagetxt());					
					}
					
					return res;
				}
				else if("Error Period is not end to Renew".equals(description))
				{
					log.info("[subscribePCS][" + msisdn + "] subscribePCS Failed by Period is not end to Renew");
					
					
					res.setResponseCode("Error");
					res.setDescription("Period is not end to Renew");										
					
					log.info("[subscribePCS][" + msisdn + "] subscribePCS get SMS message by username");
					
					SMS_Profile_Dao sms_profile = getSMSProfileByMVNO(username, password, "subpcs");
					List<SMS_Profile> sms_profile_list = sms_profile.getSMSMessage("PERIODNOTEND");
					if (sms_profile_list != null && sms_profile_list.size() > 0) {
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS get message to send sms");
						
						String msg = sms_profile_list.get(0).getSms_profile_messagetxt();

						log.info("[subscribePCS]["+msisdn+"] subscribePCS retrive existing topping name and enddate from Response");
						
						String toppingname = jsonres.getString("toppingname");	
						String enddate = jsonres.getString("enddate");	

						msg = MessageFormat.format(msg, new Object[] {toppingname, enddate });
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS sendsms and save sms transacion log");
						
						sendSMS(mvno,"0" + msisdn.substring(2),msg);					
					}
					
					return res;					
				}
				
				log.info("[subscribePCS]["+msisdn+"] subscribePCS another mapping error");

				for (int i = 0; i < Constants.MAPPINGOM.length; i++) {
					String mappingdata = Constants.MAPPINGOM[i];
					if (mappingdata.equals(description)) {
						String smsdescription = Constants.DESCRIPTIONMAPPINGOM[i];
						
						log.info("[subscribePCS]["+msisdn+"] subscribePCS error : "+smsdescription);
						
						res.setResponseCode("Error");
						res.setDescription(smsdescription);

							SMS_Profile_Dao sms_profile = getSMSProfileByMVNO(username, password, "subpcs");
							List<SMS_Profile> sms_profile_list = sms_profile.getSMSMessage(Constants.SMSSENDING[i]);
							if (sms_profile_list != null
									&& sms_profile_list.size() > 0) {
								
								log.info("[subscribePCS]["+msisdn+"] subscribePCS sendsms and save sms transacion log");
								
								sendSMS(mvno,"0" + msisdn.substring(2),sms_profile_list.get(0).getSms_profile_messagetxt());					
								return res;
							}

						}						
					}

				}
		}
		catch(Exception ex)
		{
			res.setResponseCode("Error");
			if(Constants.DEBUG)
				res.setDescription("EXCEPTION : "+ex.getLocalizedMessage());
			else
				res.setDescription("EXCEPTION");
			
			return res;
		}
			

		return res;
	}

	private PCSAllData queryPCS_All(String msisdn) {
		// TODO Auto-generated method stub
		return null;
	}

}
