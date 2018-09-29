package net.tot3g.omclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "applicationconfig")
@XmlRootElement
public class ApplicationConfig {
	
	private int id;
	private String appkey;
	private String value;
	
	@Column(name="value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Column(name="appkey")
	public String getKey() {
		return appkey;
	}
	public void setKey(String appkey) {
		this.appkey = appkey;
	}
	
	@Id
	@Column(name="Application_Config_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
