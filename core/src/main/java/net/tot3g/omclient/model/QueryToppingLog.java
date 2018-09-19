package net.tot3g.omclient.model;

public class QueryToppingLog {
	
	private String msisdn;
	private String topping;
	private String toppingID;
	private String toppingType;
	private String mobileType;
	private String startDate;
	private String endDate;
	private String sourceSystem;
	private String duration;
	private String durationType;
	private String totalQuota;
	
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDurationType() {
		return durationType;
	}
	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}
	public String getToppingID() {
		return toppingID;
	}
	public void setToppingID(String toppingID) {
		this.toppingID = toppingID;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	public String getToppingType() {
		return toppingType;
	}
	public void setToppingType(String toppingType) {
		this.toppingType = toppingType;
	}
	
}
