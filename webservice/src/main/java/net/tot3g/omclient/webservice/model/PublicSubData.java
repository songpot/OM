package net.tot3g.omclient.webservice.model;

public class PublicSubData {
		
	private String success;
	private String imsi;
	private String iccid;
	private String msisdn;
	private String planID;
	private String mobiletype;
	
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getSuccess() {
		return success;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public String getMobiletype() {
		return mobiletype;
	}
	public void setMobiletype(String mobiletype) {
		this.mobiletype = mobiletype;
	}	

}
