package net.tot3g.omclient.model;

public class IptvResponse {
	
	private String TransactionID;
	private String TOTiptvUsername;
	private String TOTiptvPassword;
	private String Timestamp;
	private String PromotionStartDate;
	private String PromotionEndDate;
	private String ResentTransactionID;
	
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getTOTiptvUsername() {
		return TOTiptvUsername;
	}
	public void setTOTiptvUsername(String tOTiptvUsername) {
		TOTiptvUsername = tOTiptvUsername;
	}
	public String getTOTiptvPassword() {
		return TOTiptvPassword;
	}
	public void setTOTiptvPassword(String tOTiptvPassword) {
		TOTiptvPassword = tOTiptvPassword;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getPromotionStartDate() {
		return PromotionStartDate;
	}
	public void setPromotionStartDate(String promotionStartDate) {
		PromotionStartDate = promotionStartDate;
	}
	public String getPromotionEndDate() {
		return PromotionEndDate;
	}
	public void setPromotionEndDate(String promotionEndDate) {
		PromotionEndDate = promotionEndDate;
	}
	public String getResentTransactionID() {
		return ResentTransactionID;
	}
	public void setResentTransactionID(String resentTransactionID) {
		ResentTransactionID = resentTransactionID;
	}


}
