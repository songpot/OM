package net.tot3g.omclient.model;


public class VoiceTopping{
	
	private String planID;
	private String description;
	private String price;
	private String amount;
	private String amountType;	//day or hours
	private String mobileType;
	private String profRef;
	private String sogRef;
	private String isactive; // 0=true, 1=false
	private String isshow; 	 // 0=true, 1=false
	
	
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	public String getProfRef() {
		return profRef;
	}
	public void setProfRef(String profRef) {
		this.profRef = profRef;
	}
	public String getSogRef() {
		return sogRef;
	}
	public void setSogRef(String sogRef) {
		this.sogRef = sogRef;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	
	
}
