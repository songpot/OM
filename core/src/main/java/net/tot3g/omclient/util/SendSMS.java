package net.tot3g.omclient.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SendSMS implements Runnable{
	
	private final Log log = LogFactory.getLog(getClass());
	
	private String phonenumber;
	private String message;
	private String SENDER="TOT3G";	

	public void run() {
		
		String username= "SOAPservice";
		String password= "soapSERVICE";
		
		URL url;
		for(int i=0;i<3;i++)
		{
			try {
				log.info("["+phonenumber+"] sendsms ");
				
				url = new URL("http://203.113.6.37/Send%20Text%20Message.htm?PhoneNumber="+phonenumber+"&Text="+URLEncoder.encode(message, "UTF-8")+"&InfoCharCounter=&sender="+SENDER+"&Submit=SUBMIT");
				URLConnection uc = url.openConnection();
				String userpass = username + ":" + password;
				String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
				uc.setRequestProperty ("Authorization", basicAuth);
				uc.getInputStream();
				break;
			} catch (MalformedURLException e) {
				log.info("["+phonenumber+"] sendsms Error : "+e.getStackTrace());			
				e.printStackTrace();
			} catch (IOException e) {			
				
				log.info("["+phonenumber+"] sendsms Error : "+e.getStackTrace());
				
				e.printStackTrace();
			} 
		}
		
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getSENDER() {
		return SENDER;
	}

	public void setSENDER(String sENDER) {
		SENDER = sENDER;
	}

}
