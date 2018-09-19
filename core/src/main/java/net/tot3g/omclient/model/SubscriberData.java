package net.tot3g.omclient.model;

public class SubscriberData {

	private String msisdn;
	private String imsi;
	private boolean ifSuspend;
	private String Language;
	private String mvnoCode;
	private String mobileType;
	private String planId;
	private String iccid;
	private boolean voice=false; //Y:N
	private boolean voice_roaming=false;
	private boolean inter_roaming=false;
	private String voice_BarIn;
	private String voice_BarOut;
	private String roamingArea="";
	private String roamingAreaCode="";
	private boolean domestic_Roaming=false;
	private String domestic_Roaming_bar;
	private boolean data=false;
	private boolean data_roaming=false;
	private String data_bar;
	private boolean WiFi=false;
	private String WiFi_bar;
	private boolean service_RBT=false;
	private String service_RBT_bar;
	private boolean service_SMS=false;
	private String service_SMS_barin;
	private String service_SMS_barout;
	private boolean service_MMS=false;
	private boolean service_MCN=false;
	private boolean service_VDOCALL=false;
	private String service_VDOCALL_bar;
	private boolean Treatmentbar=false;
	private String Treatmentlevel;
	private String service_PCS_Control_priceingplan;
	private boolean service_PCS=false;
	private String service_PCS_Control_billingDate;
	//Edit by Wanatsanan 30/10/2014
	private String service_PCS_Control_topping;
	
	//SONGPON 11/10/2014
	private String service_PCS_Control_priceingplan_startdate;
	private String service_PCS_Control_topping_startdate;
	//SONGPON 15/05/2015
	private boolean rolling =false;
	//SONGPON 11/09/2015
	private String aluinidentification;  // from ALU IN 
	private String status;
	private String balance;
	private String activityDate;
	private String inactiveDate1;
	private String inactiveDate2;
	private String deactivityEndDate;
	private boolean adminBlocked=false;
	private boolean aluinisSuspend=false;
	
	//SONGPON 07/10/2015
	private String puk1;
	private String puk2;
	private String pin1;
	private String pin2;
	private String ki;
	//Edit by Wanatsanan 07/04/2016
	private String transportKey;
	
	//Edit by Wanatsanan 04/04/2016
	private String aluinSubscriberId_om;   // from OM
	
	//Edit by Wanatsanan 31/10/2016
	private String carrier_network_voice;
	private String carrier_network_data;
	
	
	
	public String getService_PCS_Control_billingDate() {
		return service_PCS_Control_billingDate;
	}
	public void setService_PCS_Control_billingDate(
			String service_PCS_Control_billingDate) {
		this.service_PCS_Control_billingDate = service_PCS_Control_billingDate;
	}
	public String getService_PCS_Control_priceingplan() {
		return service_PCS_Control_priceingplan;
	}
	public void setService_PCS_Control_priceingplan(
			String service_PCS_Control_priceingplan) {
		this.service_PCS_Control_priceingplan = service_PCS_Control_priceingplan;
	}
	public boolean isService_PCS() {
		return service_PCS;
	}
	public void setService_PCS(boolean service_PCS) {
		this.service_PCS = service_PCS;
	}
	
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getMvnoCode() {
		return mvnoCode;
	}
	public void setMvnoCode(String mvnoCode) {
		this.mvnoCode = mvnoCode;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public boolean isVoice() {
		return voice;
	}
	public void setVoice(boolean voice) {
		this.voice = voice;
	}	
	public boolean isDomestic_Roaming() {
		return domestic_Roaming;
	}
	public void setDomestic_Roaming(boolean domestic_Roaming) {
		this.domestic_Roaming = domestic_Roaming;
	}
	public boolean isData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}	
	public boolean isWiFi() {
		return WiFi;
	}
	public void setWiFi(boolean wiFi) {
		WiFi = wiFi;
	}	
	public boolean isService_RBT() {
		return service_RBT;
	}
	public void setService_RBT(boolean service_RBT) {
		this.service_RBT = service_RBT;
	}	
	public boolean isService_SMS() {
		return service_SMS;
	}
	public void setService_SMS(boolean service_SMS) {
		this.service_SMS = service_SMS;
	}
	public boolean isService_MMS() {
		return service_MMS;
	}
	public void setService_MMS(boolean service_MMS) {
		this.service_MMS = service_MMS;
	}
	public boolean isService_MCN() {
		return service_MCN;
	}
	public void setService_MCN(boolean service_MCN) {
		this.service_MCN = service_MCN;
	}
	public boolean isService_VDOCALL() {
		return service_VDOCALL;
	}
	public void setService_VDOCALL(boolean service_VDOCALL) {
		this.service_VDOCALL = service_VDOCALL;
	}
	public String getVoice_BarIn() {
		return voice_BarIn;
	}
	public void setVoice_BarIn(String voice_BarIn) {
		this.voice_BarIn = voice_BarIn;
	}
	public String getVoice_BarOut() {
		return voice_BarOut;
	}
	public void setVoice_BarOut(String voice_BarOut) {
		this.voice_BarOut = voice_BarOut;
	}	
	public String getData_bar() {
		return data_bar;
	}
	public void setData_bar(String data_bar) {
		this.data_bar = data_bar;
	}
	public String getWiFi_bar() {
		return WiFi_bar;
	}
	public void setWiFi_bar(String wiFi_bar) {
		WiFi_bar = wiFi_bar;
	}
	public String getService_RBT_bar() {
		return service_RBT_bar;
	}
	public void setService_RBT_bar(String service_RBT_bar) {
		this.service_RBT_bar = service_RBT_bar;
	}
	public String getService_SMS_barin() {
		return service_SMS_barin;
	}
	public void setService_SMS_barin(String service_SMS_barin) {
		this.service_SMS_barin = service_SMS_barin;
	}
	public String getService_SMS_barout() {
		return service_SMS_barout;
	}
	public void setService_SMS_barout(String service_SMS_barout) {
		this.service_SMS_barout = service_SMS_barout;
	}
	public String getService_VDOCALL_bar() {
		return service_VDOCALL_bar;
	}
	public void setService_VDOCALL_bar(String service_VDOCALL_bar) {
		this.service_VDOCALL_bar = service_VDOCALL_bar;
	}
	public void setDomestic_Roaming_bar(String domestic_Roaming_bar) {
		this.domestic_Roaming_bar = domestic_Roaming_bar;
	}
	public String getDomestic_Roaming_bar() {
		return domestic_Roaming_bar;
	}
	public void setIfSuspend(boolean ifSuspend) {
		this.ifSuspend = ifSuspend;
	}
	public boolean isIfSuspend() {
		return ifSuspend;
	}

	public void setTreatmentbar(boolean treatmentbar) {
		Treatmentbar = treatmentbar;
	}
	public boolean isTreatmentbar() {
		return Treatmentbar;
	}
	public void setTreatmentlevel(String treatmentlevel) {
		Treatmentlevel = treatmentlevel;
	}
	public String getTreatmentlevel() {
		return Treatmentlevel;
	}
	public String getRoamingArea() {
		return roamingArea;
	}
	public void setRoamingArea(String roamingArea) {
		this.roamingArea = roamingArea;
	}
	public boolean isVoice_roaming() {
		return voice_roaming;
	}
	public void setVoice_roaming(boolean voice_roaming) {
		this.voice_roaming = voice_roaming;
	}
	public boolean isData_roaming() {
		return data_roaming;
	}
	public void setData_roaming(boolean data_roaming) {
		this.data_roaming = data_roaming;
	}
	public boolean isInter_roaming() {
		return inter_roaming;
	}
	public void setInter_roaming(boolean inter_roaming) {
		this.inter_roaming = inter_roaming;
	}
	public String getRoamingAreaCode() {
		return roamingAreaCode;
	}
	public void setRoamingAreaCode(String roamingAreaCode) {
		this.roamingAreaCode = roamingAreaCode;
	}
	//Edit by Wanatsanan 30/10/2014
	public String getService_PCS_Control_topping() {
		return service_PCS_Control_topping;
	}
	//Edit by Wanatsanan 30/10/2014
	public void setService_PCS_Control_topping(
			String service_PCS_Control_topping) {
		this.service_PCS_Control_topping = service_PCS_Control_topping;
	}
	
	//SONGPON 10/11/2014
	public String getService_PCS_Control_topping_startdate() {
		return service_PCS_Control_topping_startdate;
	}
	public void setService_PCS_Control_topping_startdate(
			String service_PCS_Control_topping_startdate) {
		this.service_PCS_Control_topping_startdate = service_PCS_Control_topping_startdate;
	}
	//SONGPON 10/11/2014
	public String getService_PCS_Control_priceingplan_startdate() {
		return service_PCS_Control_priceingplan_startdate;
	}
	public void setService_PCS_Control_priceingplan_startdate(
			String service_PCS_Control_priceingplan_startdate) {
		this.service_PCS_Control_priceingplan_startdate = service_PCS_Control_priceingplan_startdate;
	}
	public boolean isRolling() {
		return rolling;
	}
	public void setRolling(boolean rolling) {
		this.rolling = rolling;
	}
	public String getAluinidentification() {
		return aluinidentification;
	}
	public void setAluinidentification(String aluinidentification) {
		this.aluinidentification = aluinidentification;
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
	public boolean isAdminBlocked() {
		return adminBlocked;
	}
	public void setAdminBlocked(boolean adminBlocked) {
		this.adminBlocked = adminBlocked;
	}
	public boolean isAluinisSuspend() {
		return aluinisSuspend;
	}
	public void setAluinisSuspend(boolean aluinisSuspend) {
		this.aluinisSuspend = aluinisSuspend;
	}
	public String getPuk1() {
		return puk1;
	}
	public void setPuk1(String puk1) {
		this.puk1 = puk1;
	}
	public String getPuk2() {
		return puk2;
	}
	public void setPuk2(String puk2) {
		this.puk2 = puk2;
	}
	public String getPin1() {
		return pin1;
	}
	public void setPin1(String pin1) {
		this.pin1 = pin1;
	}
	public String getPin2() {
		return pin2;
	}
	public void setPin2(String pin2) {
		this.pin2 = pin2;
	}
	public String getKi() {
		return ki;
	}
	public void setKi(String ki) {
		this.ki = ki;
	}
	public String getAluinSubscriberId_om() {
		return aluinSubscriberId_om;
	}
	public void setAluinSubscriberId_om(String aluinSubscriberId_om) {
		this.aluinSubscriberId_om = aluinSubscriberId_om;
	}
	public String getTransportKey() {
		return transportKey;
	}
	public void setTransportKey(String transportKey) {
		this.transportKey = transportKey;
	}
	public String getCarrier_network_voice() {
		return carrier_network_voice;
	}
	public void setCarrier_network_voice(String carrier_network_voice) {
		this.carrier_network_voice = carrier_network_voice;
	}
	public String getCarrier_network_data() {
		return carrier_network_data;
	}
	public void setCarrier_network_data(String carrier_network_data) {
		this.carrier_network_data = carrier_network_data;
	}
	
}
