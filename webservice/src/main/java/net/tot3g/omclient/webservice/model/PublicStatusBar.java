package net.tot3g.omclient.webservice.model;

public class PublicStatusBar {
	
	private String status;
	private String msisdn;
	private String voice_In;
	private String voice_Out;
	private String domestic_Roaming;
	private String data;
	private String WiFi;
	private String service_RBT;
	private String service_SMS_In;
	private String service_SMS_Out;
	private String service_VdoCall;
	private String service_VMS;
	private String service_VVMS;
	private boolean suspend;
	private boolean treatmentbar=false;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getVoice_In() {
		return voice_In;
	}
	public void setVoice_In(String voice_In) {
		this.voice_In = voice_In;
	}
	public String getVoice_Out() {
		return voice_Out;
	}
	public void setVoice_Out(String voice_Out) {
		this.voice_Out = voice_Out;
	}
	public String getDomestic_Roaming() {
		return domestic_Roaming;
	}
	public void setDomestic_Roaming(String domestic_Roaming) {
		this.domestic_Roaming = domestic_Roaming;
	}
	public String getWiFi() {
		return WiFi;
	}
	public void setWiFi(String wiFi) {
		WiFi = wiFi;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getService_SMS_In() {
		return service_SMS_In;
	}
	public void setService_SMS_In(String service_SMS_In) {
		this.service_SMS_In = service_SMS_In;
	}
	public String getService_RBT() {
		return service_RBT;
	}
	public void setService_RBT(String service_RBT) {
		this.service_RBT = service_RBT;
	}
	public String getService_SMS_Out() {
		return service_SMS_Out;
	}
	public void setService_SMS_Out(String service_SMS_Out) {
		this.service_SMS_Out = service_SMS_Out;
	}
	public String getService_VdoCall() {
		return service_VdoCall;
	}
	public void setService_VdoCall(String service_VdoCall) {
		this.service_VdoCall = service_VdoCall;
	}
	public String getService_VMS() {
		return service_VMS;
	}
	public void setService_VMS(String service_VMS) {
		this.service_VMS = service_VMS;
	}
	public String getService_VVMS() {
		return service_VVMS;
	}
	public void setService_VVMS(String service_VVMS) {
		this.service_VVMS = service_VVMS;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSuspend() {
		return suspend;
	}
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	public boolean isTreatmentbar() {
		return treatmentbar;
	}
	public void setTreatmentbar(boolean treatmentbar) {
		this.treatmentbar = treatmentbar;
	}

	

}
