package net.tot3g.omclient.model;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pcs_profile")
@XmlRootElement
public class PCSprofile {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 561852210436302775L;
	
	 private  String pcs_id;
	 private  String pcs_priceplan;
	 private  String totalQuota;
	 private  String usedQuota;		
	 private  String billingDuration;	
	 private  String billResetType;	
	 private  String price;	
	 private  String mvno;
	 private  String mobiletype;
     private  String preferredDomain;
	 private  String refQoSProfName;
	 private  String billingStartDate;
	 private  String actionStatus;
	 private  String priceplan;
	 private  String subscriberTimeThresholdQuota;
	 private  String pcsprofiletype;
	 private  String pcstype;
	 private  String ifnomainpcs_ID;
	 private  String iptvinternal_ID;
	 private  boolean active;
	 private  LinkedList<PCSElementData> pcsElementData;	
	 private  boolean bonus;
	 private  String bundle_service_id;
	 private  boolean accume;

	@Id
	@Column(name="pcs_id")	
	public String getPcs_id() {
		return pcs_id;
	}
	
	public void setPcs_id(String pcs_id) {
		this.pcs_id = pcs_id;
	}
	
	@Column(name="pcs_priceplan")
	public String getPcs_priceplan() {
		return pcs_priceplan;
	}
	
	public void setPcs_priceplan(String pcs_priceplan) {
		this.pcs_priceplan = pcs_priceplan;
	}
	
	@Column(name="totalQuota")
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	
	@Column(name="usedQuota")
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	
	@Column(name="billingDuration")
	public String getBillingDuration() {
		return billingDuration;
	}
	public void setBillingDuration(String billingDuration) {
		this.billingDuration = billingDuration;
	}
	
	@Column(name="billResetType")
	public String getBillResetType() {
		return billResetType;
	}
	public void setBillResetType(String billResetType) {
		this.billResetType = billResetType;
	}
	
	@Column(name="price")
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Column(name="mvnocode")
	public String getMvno() {
		return mvno;
	}
	
	public void setMvno(String mvno) {
		this.mvno = mvno;
	}
	
	@Column(name="mobiletype")
	public String getMobiletype() {
		return mobiletype;
	}
	
	public void setMobiletype(String mobiletype) {
		this.mobiletype = mobiletype;
	}

	@Column(name="preferredDomain")
	public String getPreferredDomain() {
			return preferredDomain;
	}

	
	public void setPreferredDomain(String preferredDomain) {
			this.preferredDomain = preferredDomain;
	}

	@Column(name="refQoSProfName")
	public String getRefQoSProfName() {
			return refQoSProfName;
	}

	public void setRefQoSProfName(String refQoSProfName) {
			this.refQoSProfName = refQoSProfName;
	}
		
	@Column(name="billingStartDate")
	public String getBillingStartDate() {
			return billingStartDate;
	}

	public void setBillingStartDate(String billingStartDate) {
			this.billingStartDate = billingStartDate;
	}

	@Column(name="actionStatus")
	public String getActionStatus() {
			return actionStatus;
	}

	public void setActionStatus(String actionStatus) {
			this.actionStatus = actionStatus;
	}
	
	@Column(name="priceplan")
	public String getPriceplan() {
		return priceplan;
	}

	public void setPriceplan(String priceplan) {
		this.priceplan = priceplan;
	}

	@Column(name="subscriberTimeThresholdQuota", length=255,nullable=false)
	public String getSubscriberTimeThresholdQuota() {
		return subscriberTimeThresholdQuota;
	}

	public void setSubscriberTimeThresholdQuota(
			String subscriberTimeThresholdQuota) {
		this.subscriberTimeThresholdQuota = subscriberTimeThresholdQuota;
	}

	@Column(name="pcsprofiletype_ID")
	public String getPcsprofiletype() {
		return pcsprofiletype;
	}

	public void setPcsprofiletype(String pcsprofiletype) {
		this.pcsprofiletype = pcsprofiletype;
	}

	@Column(name="pcstype_ID")
	public String getPcstype() {
		return pcstype;
	}

	public void setPcstype(String pcstype) {
		this.pcstype = pcstype;
	}

	@Column(name="ifnomainpcs_ID")
	public String getIfnomainpcs_ID() {
		return ifnomainpcs_ID;
	}

	public void setIfnomainpcs_ID(String ifnomainpcs_ID) {
		this.ifnomainpcs_ID = ifnomainpcs_ID;
	}

	@Column(name="iptvinternal_ID")
	public String getIptvinternal_ID() {
		return iptvinternal_ID;
	}

	public void setIptvinternal_ID(String iptvinternal_ID) {
		this.iptvinternal_ID = iptvinternal_ID;
	}

	public LinkedList<PCSElementData> getPcsElementData() {
		return pcsElementData;
	}

	public void setPcsElementData(LinkedList<PCSElementData> subelementdatalist) {
		this.pcsElementData = subelementdatalist;
	}

	@Column(name="isactive")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "bonus")
	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}

	@Column(name="bundle_service_id",length=5)
	public String getBundle_service_id() {
		return bundle_service_id;
	}

	public void setBundle_service_id(String bundle_service_id) {
		this.bundle_service_id = bundle_service_id;
	}

	@Column(name = "accumulate")
	public boolean isAccume() {
		return accume;
	}

	public void setAccume(boolean accume) {
		this.accume = accume;
	}	

	
}
