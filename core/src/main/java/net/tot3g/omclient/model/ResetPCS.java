package net.tot3g.omclient.model;

public class ResetPCS {
	
	private String msisdn;
	private String usedQuota;
	private String totalQuota;
	private String QOS;
	private String billingStartDate;
	private String billingDuration;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	public String getQOS() {
		return QOS;
	}
	public void setQOS(String qOS) {
		QOS = qOS;
	}
	public String getBillingStartDate() {
		return billingStartDate;
	}
	public void setBillingStartDate(String billingStartDate) {
		this.billingStartDate = billingStartDate;
	}
	public String getBillingDuration() {
		return billingDuration;
	}
	public void setBillingDuration(String billingDuration) {
		this.billingDuration = billingDuration;
	}

}
