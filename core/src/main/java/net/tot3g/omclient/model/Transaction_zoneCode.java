package net.tot3g.omclient.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity
@Table(name = "transaction_zonecode")
@Searchable
@XmlRootElement
public class Transaction_zoneCode {
	
	private String msisdn;
	private Long TrxID;
	private Date createTime;
	private String existingarea;
	private String newarea;
	private String userid;
	
	@Column(nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
		
	@Column(nullable = false, length = 12)
    @SearchableProperty
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}				
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getTrxID() {
		return TrxID;
	}
	public void setTrxID(Long trxID) {
		TrxID = trxID;
	}
	
	@Column(length = 40)   
	public String getExistingarea() {
		return existingarea;
	}
	public void setExistingarea(String existingarea) {
		this.existingarea = existingarea;
	}
	
	@Column(length = 40)   
	public String getNewarea() {
		return newarea;
	}
	public void setNewarea(String newarea) {
		this.newarea = newarea;
	}
	
	@Column(length = 40)   
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

}
