package net.tot3g.omclient.connector.INTERNAL;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;

public class JSONConnectorImpl implements JSONConnector,InitializingBean {
	
	private HttpClient client;

	public String sendJSONRequest(String url, JSONObject jsondata) throws IOException {		
		PostMethod post = new PostMethod(url);		
		post.setRequestHeader("Content-Type", "application/json;charset=UTF-8");		
		post.setRequestEntity(new ByteArrayRequestEntity(jsondata.toString().getBytes()));
		String response = null; 
		try {					
			client.executeMethod(post);
			response = org.apache.commons.io.IOUtils.toString(post.getResponseBodyAsStream(),"UTF-8");
		} finally {
			post.releaseConnection();
		}
		return response;
	}
	
	public void afterPropertiesSet() throws Exception {
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		this.client = new HttpClient(connectionManager);		

		this.client.getHttpConnectionManager().getParams().setConnectionTimeout(Integer.parseInt("30000"));  
		this.client.getHttpConnectionManager().getParams().setSoTimeout(Integer.parseInt("30000"));                       
	}	

}
