package net.tot3g.omclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "rolling_policy")
@XmlRootElement
public class PolicyRolling{
	
	private int rolling_policy_id;
	private String planID;
	private String pcs_priceplan;
	private String isactive; 
	private String startqos;
	
	@Id
	@GeneratedValue
	@Column(name="rolling_policy_id", length=5,nullable=false)	
	public int getRolling_policy_id() {
		return rolling_policy_id;
	}
	public void setRolling_policy_id(int rolling_policy_id) {
		this.rolling_policy_id = rolling_policy_id;
	}
	
	@Column(name="planID", length=255,nullable=false)
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	
	@Column(name="pcs_priceplan", length=255,nullable=false)
	public String getPcs_priceplan() {
		return pcs_priceplan;
	}
	public void setPcs_priceplan(String priceplanname_name) {
		this.pcs_priceplan = priceplanname_name;
	}
	
	@Column(name="isactive", length=255,nullable=false)
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	
	@Column(name="startqos", length=255)
	public String getStartqos() {
		return startqos;
	}
	public void setStartqos(String startqos) {
		this.startqos = startqos;
	}
	
	
	

}
