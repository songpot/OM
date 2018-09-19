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
@Table(name = "transaction_adjust")
@Searchable
@XmlRootElement
public class TransactionAdjustLog {
	
	private String msisdn;
	private Long TrxID;
	private Date createTime;
	private String description;
	private String sourcesystem;
	private String volume;
	private String transactiontype;
	private String bucketname;
	
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
	
	@Column(length = 15)   
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	@Column(length = 10)   
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	@Column(length = 5)   
	public String getBucketname() {
		return bucketname;
	}
	public void setBucketname(String bucketname) {
		this.bucketname = bucketname;
	}
	

}
