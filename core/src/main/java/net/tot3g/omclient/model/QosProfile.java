package net.tot3g.omclient.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


public class QosProfile  {
	
	private String qos_profile_id;
	private String qos_name;
	private String price;
	private String mvnoCode;
	private String mobiletype;
	private String promotionname;
	private String isactive;
	
	public String getQos_profile_id() {
		return qos_profile_id;
	}
	public void setQos_profile_id(String qos_profile_id) {
		this.qos_profile_id = qos_profile_id;
	}
	public String getQos_name() {
		return qos_name;
	}
	public void setQos_name(String qos_name) {
		this.qos_name = qos_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMvnoCode() {
		return mvnoCode;
	}
	public void setMvnoCode(String mvnoCode) {
		this.mvnoCode = mvnoCode;
	}
	public String getMobiletype() {
		return mobiletype;
	}
	public void setMobiletype(String mobiletype) {
		this.mobiletype = mobiletype;
	}
	public String getPromotionname() {
		return promotionname;
	}
	public void setPromotionname(String promotionname) {
		this.promotionname = promotionname;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}


}
