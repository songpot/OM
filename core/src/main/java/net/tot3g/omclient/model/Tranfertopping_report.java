package net.tot3g.omclient.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

public class Tranfertopping_report{
	
	private String sourcemsisdn;
	private String targetmsisdn;
	private String TrxID;
	private String money;
	private String createTime;
	private String identificationCode;
	private String sourcesystem;
	private String voice_topping_id;
	private String pcs_id;
		
	public String getTrxID() {
		return TrxID;
	}
	public void setTrxID(String trxID) {
		TrxID = trxID;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getIdentificationCode() {
		return identificationCode;
	}
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}
	public String getSourcesystem() {
		return sourcesystem;
	}
	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}
	public String getVoice_topping_id() {
		return voice_topping_id;
	}
	public void setVoice_topping_id(String voice_topping_id) {
		this.voice_topping_id = voice_topping_id;
	}
	public String getPcs_id() {
		return pcs_id;
	}
	public void setPcs_id(String pcs_id) {
		this.pcs_id = pcs_id;
	}
	public String getSourcemsisdn() {
		return sourcemsisdn;
	}
	public void setSourcemsisdn(String sourcemsisdn) {
		this.sourcemsisdn = sourcemsisdn;
	}
	public String getTargetmsisdn() {
		return targetmsisdn;
	}
	public void setTargetmsisdn(String targetmsisdn) {
		this.targetmsisdn = targetmsisdn;
	}
	
	
}
