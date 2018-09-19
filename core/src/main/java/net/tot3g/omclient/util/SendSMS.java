package net.tot3g.omclient.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class SendSMS  implements Runnable {
	
	private String phonenumber;
	private String message;

	public void run() {
		
		String username= "SOAPservice";
		String password= "soapSERVICE";
		
		URL url;
		try {
			url = new URL("http://203.113.6.37/Send%20Text%20Message.htm?PhoneNumber="+phonenumber+"&Text="+URLEncoder.encode(message, "UTF-8")+"&InfoCharCounter=&sender=TOT3G&Submit=SUBMIT");
			URLConnection uc = url.openConnection();
			String userpass = username + ":" + password;
			String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
			uc.setRequestProperty ("Authorization", basicAuth);
			uc.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
