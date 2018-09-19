package net.tot3g.omclient.model;

import java.io.Serializable;

public class BarSub implements Serializable{

	private String msisdn;
	private String service;
	private String barstatus;
	
	//FROM HTTPREQUEST
	private String remoteUser;
	private String requestURL;
	private String userPrincipal;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getService() {
		return service;
	}
	public void setBarstatus(String barstatus) {
		this.barstatus = barstatus;
	}
	public String getBarstatus() {
		return barstatus;
	}
	public String getRemoteUser() {
		return remoteUser;
	}
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	public String getUserPrincipal() {
		return userPrincipal;
	}
	public void setUserPrincipal(String userPrincipal) {
		this.userPrincipal = userPrincipal;
	}
	
	
	
	
}
