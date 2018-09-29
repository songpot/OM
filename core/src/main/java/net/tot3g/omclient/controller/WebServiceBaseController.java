package net.tot3g.omclient.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.tot3g.omclient.dao.SMS_Profile_Dao;
import net.tot3g.omclient.dao.WS_Mvno__Dao;
import net.tot3g.omclient.dao.WS_Transaction_SMS;
import net.tot3g.omclient.model.Transaction_SMS;
import net.tot3g.omclient.model.WS_MVNO;
import net.tot3g.omclient.util.SendSMS;

public class WebServiceBaseController {
	
	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private WS_Mvno__Dao ws_Mvno_Dao;
	
	@Autowired
	private SMS_Profile_Dao smsProfile_iec;
	
	@Autowired
	private SMS_Profile_Dao smsProfile_loxley;

	@Autowired
	private SMS_Profile_Dao smsProfile_tot;
	
	@Autowired
	private SMS_Profile_Dao smsProfile_penguin;
	
	@Autowired
	private SMS_Profile_Dao smsProfile_myw;
	
	@Autowired
	private SMS_Profile_Dao smsProfile_feel;
	
	@Autowired
	private SendSMS sms;
	
	@Autowired
	private WS_Transaction_SMS ws_transaction_sms;
	
	protected WS_MVNO checkMVNO(String username,String password,String operation)
	{		
		return ws_Mvno_Dao.getMvno(username, password, operation);
	}
	
	protected SMS_Profile_Dao getSMSProfileByMVNO(String username,String password,String operation){
		WS_MVNO mvnodata = checkMVNO(username, password, operation);
		if("OMWeb".equals(mvnodata.getWs_webappname()))
			return smsProfile_tot;
		else if("iec".equals(mvnodata.getWs_webappname()))
			return smsProfile_iec;
		else if("loxley".equals(mvnodata.getWs_webappname()))
			return smsProfile_loxley;			
		else if("myworld".equals(mvnodata.getWs_webappname()))
			return smsProfile_myw;
		else if("feel".equals(mvnodata.getWs_webappname()))
			return smsProfile_feel;
		else
			return smsProfile_penguin;
	}
	
	protected void sendSMS(WS_MVNO mvno,String msisdn,String message)
	{
		sms.setSENDER(mappingMVNOCode(mvno.getWs_webappname()));
		sms.setPhonenumber(msisdn);
		sms.setMessage(message);
			
		Thread newThrd = new Thread(sms);
		newThrd.start();
		
		log.info("[subscribePCS]["+msisdn+"] save transaction");

		Transaction_SMS smstransaction = new Transaction_SMS();
		smstransaction.setMsisdn("0" + msisdn.substring(2));
		smstransaction.setDescription(message);
		smstransaction.setSender(mappingMVNOCode(mvno.getWs_mvno_id()));

		ws_transaction_sms.save(smstransaction);
	}
	
	protected String mappingMVNOCode(String mvnoid)
	{
		if("OMWeb".equals(mvnoid))
			return "TOT3G";	
		else if("loxley".equals(mvnoid))
			return "i-Kool";
		else if("iec".equals(mvnoid))
			return "Buzzme";
		else if("myworld".equals(mvnoid))
			return "MYWORLD";
		else if("feel".equals(mvnoid))
			return "FEEL";
		else
			return "PENGUIN";		
	}

}
