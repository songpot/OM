package net.tot3g.omclient.connector.common;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.dao.Config_EndpointDao;
import net.tot3g.omclient.model.Config_Endpoint;

public class HTTPConnector implements InitializingBean {
	
	private String sourcesystem;	

	private HttpClient client;
	private Config_Endpoint endpoint;
	
	@Autowired
	private Config_EndpointDao config_endpointDao;
	
	//getServicesFromSR
	//Submit
	
	public String sendRequest(String xml) throws IOException {
		PostMethod post = new PostMethod(getUrl());		
		post.setRequestHeader("Content-Type", "text/xml;charset=UTF-8");		
		post.setRequestEntity(new ByteArrayRequestEntity(xml.getBytes()));
		String response = null; 
		try {					
			client.executeMethod(post);
			response = post.getResponseBodyAsString();
		} finally {
			post.releaseConnection();
		}
		return response;
	}
	
	public String sendRequestwithoutSOAPACTION(String xml) throws IOException {
		PostMethod post = new PostMethod(getUrl());		
		post.setRequestHeader("Content-Type", "text/xml;charset=UTF-8");		
		post.setRequestEntity(new ByteArrayRequestEntity(xml.getBytes()));
		String response = null; 
		try {			
			client.executeMethod(post);
			response = post.getResponseBodyAsString();
		} finally {
			post.releaseConnection();
		}
		return response;
	}
	
	public String getUrl() {
		
		if(endpoint==null)
			endpoint =  config_endpointDao.getConfigBySourcesystem(sourcesystem);		
		return endpoint.getDefaultvalue();
	}


	public void afterPropertiesSet() throws Exception {
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		this.client = new HttpClient(connectionManager);		

		this.client.getHttpConnectionManager().getParams().setConnectionTimeout(Integer.parseInt(Constants.NORMAL_TIMEOUT));  
		this.client.getHttpConnectionManager().getParams().setSoTimeout(Integer.parseInt(Constants.NORMAL_TIMEOUT)); 				
	}

	public String getSourcesystem() {
		return sourcesystem;
	}

	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}	
}
