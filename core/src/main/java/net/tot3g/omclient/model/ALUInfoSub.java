package net.tot3g.omclient.model;

public class ALUInfoSub {
	
	private String accountProfileRef;
	private String cardNumber; // msisdn without 66
	private String imsi;
	private String status;	//0=create | 1=valid | 2=active | 3=inactive2 | 4=deactive2 | 5=inactive1 | 6=deactive1 | 7=no credit | 8=terminate
	private String balance;
	private boolean isAdminBlocked;
	private boolean isSuspend;
	private String beginValidityDate;
	private String endValidityDate;
	private String activityDate;
	private String inactiveDate1;
	private String inactiveDate2;
	private String deactivityEndDate;
	

	public String getAccountProfileRef() {
		return accountProfileRef;
	}
	public void setAccountProfileRef(String accountProfileRef) {
		this.accountProfileRef = accountProfileRef;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public boolean isAdminBlocked() {
		return isAdminBlocked;
	}
	public void setAdminBlocked(boolean isAdminBlocked) {
		this.isAdminBlocked = isAdminBlocked;
	}
	public boolean isSuspend() {
		return isSuspend;
	}
	public void setSuspend(boolean isSuspend) {
		this.isSuspend = isSuspend;
	}
	public String getBeginValidityDate() {
		return beginValidityDate;
	}
	public void setBeginValidityDate(String beginValidityDate) {
		this.beginValidityDate = beginValidityDate;
	}
	public String getEndValidityDate() {
		return endValidityDate;
	}
	public void setEndValidityDate(String endValidityDate) {
		this.endValidityDate = endValidityDate;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public String getInactiveDate1() {
		return inactiveDate1;
	}
	public void setInactiveDate1(String inactiveDate1) {
		this.inactiveDate1 = inactiveDate1;
	}
	public String getInactiveDate2() {
		return inactiveDate2;
	}
	public void setInactiveDate2(String inactiveDate2) {
		this.inactiveDate2 = inactiveDate2;
	}
	public String getDeactivityEndDate() {
		return deactivityEndDate;
	}
	public void setDeactivityEndDate(String deactivityEndDate) {
		this.deactivityEndDate = deactivityEndDate;
	}
	

}
