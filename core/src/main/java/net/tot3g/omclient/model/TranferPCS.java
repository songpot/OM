package net.tot3g.omclient.model;

public class TranferPCS {
	
	private String msisdn;
	private String pricingPlan;
	private String billingStartDate;
	private String totalQuota;
	private String usedQuota;
	private String billingDuration;
	private String billResetType;
	private String modpcstype;
	
	//Tranfer topping
	private String sourcemsisdn;
	private String toppingtype;
	
	//REQUEST ServletRequest
	 
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getPricingPlan() {
		return pricingPlan;
	}
	public void setPricingPlan(String pricingPlan) {
		this.pricingPlan = pricingPlan;
	}
	public String getBillingStartDate() {
		return billingStartDate;
	}
	public void setBillingStartDate(String billingStartDate) {
		this.billingStartDate = billingStartDate;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	public String getBillingDuration() {
		return billingDuration;
	}
	public void setBillingDuration(String billingDuration) {
		this.billingDuration = billingDuration;
	}
	public String getBillResetType() {
		return billResetType;
	}
	public void setBillResetType(String billResetType) {
		this.billResetType = billResetType;
	}
	public String getModpcstype() {
		return modpcstype;
	}
	public void setModpcstype(String modpcstype) {
		this.modpcstype = modpcstype;
	}
	public String getSourcemsisdn() {
		return sourcemsisdn;
	}
	public void setSourcemsisdn(String sourcemsisdn) {
		this.sourcemsisdn = sourcemsisdn;
	}
	public String getToppingtype() {
		return toppingtype;
	}
	public void setToppingtype(String toppingtype) {
		this.toppingtype = toppingtype;
	}

}
