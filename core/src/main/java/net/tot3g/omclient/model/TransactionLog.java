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
@Table(name = "transaction_log")
@Searchable
@XmlRootElement
public class TransactionLog {
	
	private String msisdn;
	private Long TrxID;
	private Date createTime;
	private String description;
	private String sourcesystem;
	private String voice_topping_id;
	private String pcs_id;
	
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
	
	@Column(length = 40)   
	public String getSourcesystem() {
		return sourcesystem;
	}
	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}
	
	@Column(length = 2)   
	public String getVoice_topping_id() {
		return voice_topping_id;
	}
	public void setVoice_topping_id(String voice_topping_id) {
		this.voice_topping_id = voice_topping_id;
	}
	
	@Column(length = 2)   
	public String getPcs_id() {
		return pcs_id;
	}
	public void setPcs_id(String pcs_id) {
		this.pcs_id = pcs_id;
	}
	
	@Column(length = 255)   
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	

}
