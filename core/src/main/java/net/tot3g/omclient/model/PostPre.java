package net.tot3g.omclient.model;

public class PostPre {
	private String msisdn;
	private String iccid;
	private String planid;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getIccid() {
		return iccid;
	}

}
