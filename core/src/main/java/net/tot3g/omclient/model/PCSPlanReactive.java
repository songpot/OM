package net.tot3g.omclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pcs_plan_reactivated")
@XmlRootElement
public class PCSPlanReactive {

	private int ID;
	private String Promotion_ID;
	private String PCS_priceplan;
	private int Isgreeting;
	private String greetingmessage;
	
	@Id
	@Column(name="ID")	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@Column(name="Promotion_ID")
	public String getPromotion_ID() {
		return Promotion_ID;
	}
	public void setPromotion_ID(String promotion_ID) {
		Promotion_ID = promotion_ID;
	}
	
	@Column(name="PCS_priceplan")
	public String getPCS_priceplan() {
		return PCS_priceplan;
	}
	public void setPCS_priceplan(String pCS_priceplan) {
		PCS_priceplan = pCS_priceplan;
	}
	
	@Column(name="Isgreeting")
	public int getIsgreeting() {
		return Isgreeting;
	}
	public void setIsgreeting(int isgreeting) {
		Isgreeting = isgreeting;
	}
	
	@Column(name="greetingmessage")
	public String getGreetingmessage() {
		return greetingmessage;
	}
	public void setGreetingmessage(String greetingmessage) {
		this.greetingmessage = greetingmessage;
	}
}
