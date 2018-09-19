package net.tot3g.omclient.model;

public class PCSprofileElement {

    private String pricingPlan;
    private String totalQuota;
    private String billingDuration;
    private String billingStartDate;
    
	
	//***** Topping *****
//	private String  usedDownlinkQuota;
//	private boolean rolloverEnabled;
//	private boolean serviceEnabled;
//	private String  billResetType;
//	private String  usedUplinkQuota;
	private String  serviceId;
	private String  threshQuota;
//	private String  billingStartDate;
//	private boolean serviceElementCyclic;
//	private String  actionStatus;
//	private String  usedTime;
//	private String  accumulatedCharge;
	private String  usedQuota;
//	private String  imeiList;
	private String  billingResetDuration;	// billingResetDuration = billingDuration
	private String  billingStartDateTopping;
	private String  billResetType;
	
	
	public String getPricingPlan() {
		return pricingPlan;
	}
	public void setPricingPlan(String pricingPlan) {
		this.pricingPlan = pricingPlan;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	public String getBillingDuration() {
		return billingDuration;
	}
	public void setBillingDuration(String billingDuration) {
		this.billingDuration = billingDuration;
	}
	
	
	
	
	public String getBillingStartDate() {
		return billingStartDate;
	}
	public void setBillingStartDate(String billingStartDate) {
		this.billingStartDate = billingStartDate;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getThreshQuota() {
		return threshQuota;
	}
	public void setThreshQuota(String threshQuota) {
		this.threshQuota = threshQuota;
	}
	public String getBillingResetDuration() {
		return billingResetDuration;
	}
	public void setBillingResetDuration(String billingResetDuration) {
		this.billingResetDuration = billingResetDuration;
	}
	public String getBillingStartDateTopping() {
		return billingStartDateTopping;
	}
	public void setBillingStartDateTopping(String billingStartDateTopping) {
		this.billingStartDateTopping = billingStartDateTopping;
	}
	public String getBillResetType() {
		return billResetType;
	}
	public void setBillResetType(String billResetType) {
		this.billResetType = billResetType;
	}
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	

}
