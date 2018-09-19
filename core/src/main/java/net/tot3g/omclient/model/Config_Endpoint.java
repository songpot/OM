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
@Table(name = "config_endpoint")
@Searchable
@XmlRootElement
public class Config_Endpoint {
	
	private Long TrxID;
	private String createuser;
	private Date createTime;
	private String description;
	private String sourcesystem;
	private String defaultvalue;
	private String username;
	private String password;
	private boolean active;	
	
	@Column(nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}			
	
	@Column(length = 40)   
	@SearchableProperty
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
	
	@Column(length = 255)   
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	
	@Column(length = 255)   
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	
	@Column
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Column(length = 255)   
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(length = 255)   
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}	
	
