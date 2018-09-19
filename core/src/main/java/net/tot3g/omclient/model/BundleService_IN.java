package net.tot3g.omclient.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "bundle_service_in")
@XmlRootElement
public class BundleService_IN implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4923939596567897460L;
	private String bundle_service_id;
	private String voiceTopping_id;
	private boolean active;
	
	@Id
	@Column(name="bundle_service_id",length=5,nullable=false)	
	public String getBundle_service_id() {
		return bundle_service_id;
	}
	public void setBundle_service_id(String bundle_service_id) {
		this.bundle_service_id = bundle_service_id;
	}
	
	@Id
	@Column(name="voicetopping_id",length=5,nullable=false)	
	public String getVoiceTopping_id() {
		return voiceTopping_id;
	}
	public void setVoiceTopping_id(String voiceTopping_id) {
		this.voiceTopping_id = voiceTopping_id;
	}
	
	@Column(name="isActive")
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime
				* result
				+ ((bundle_service_id == null) ? 0 : bundle_service_id
						.hashCode());
		result = prime * result
				+ ((voiceTopping_id == null) ? 0 : voiceTopping_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BundleService_IN other = (BundleService_IN) obj;
		if (active != other.active)
			return false;
		if (bundle_service_id == null) {
			if (other.bundle_service_id != null)
				return false;
		} else if (!bundle_service_id.equals(other.bundle_service_id))
			return false;
		if (voiceTopping_id == null) {
			if (other.voiceTopping_id != null)
				return false;
		} else if (!voiceTopping_id.equals(other.voiceTopping_id))
			return false;
		return true;
	}
	
	
	
}
