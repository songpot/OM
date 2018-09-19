package net.tot3g.omclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;


@Entity
@Table(name = "price_plan")
@XmlRootElement
public class Price_plan {
	
	@Id
	@Column(name="planID", length=30,nullable=false)	
	 public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	
	@Column(name="mvno", length=50,nullable=false)	
	public String getMvno() {
		return mvno;
	}
	public void setMvno(String mvno) {
		this.mvno = mvno;
	}
	
	@Column(name="mvnoCode", length=15,nullable=false)	
	public String getMvnoCode() {
		return mvnoCode;
	}
	public void setMvnoCode(String mvnoCode) {
		this.mvnoCode = mvnoCode;
	}
	
	@Column(name="mobileType", length=15,nullable=false)	
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	
	@Column(name="description", length=255)	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="price", length=15)	
	  public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name="isactive", length=1)	
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	@Column(name="iskeeppcs", length=1)	
	public String getIsKeepPCS() {
		return isKeepPCS;
	}
	public void setIsKeepPCS(String isKeepPCS) {
		this.isKeepPCS = isKeepPCS;
	}


	 private String planID;
	 private String mvno;
	 private String mvnoCode;
	 private String mobileType;
	 private String description;
	 private String price;
     private String isactive;
     private String isKeepPCS;
}
