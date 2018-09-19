package net.tot3g.omclient.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "bundle_service")
@XmlRootElement
public class BundleService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5211187032231596655L;
	
	private String bundle_service_id;
	private String bundle_service_name;
	private boolean pcs;
	private boolean in;
	private boolean active;
	
	@Id
	@Column(name="bundle_service_id",length=5,nullable=false)	
	public String getBundle_service_id() {
		return bundle_service_id;
	}
	public void setBundle_service_id(String bundle_service_id) {
		this.bundle_service_id = bundle_service_id;
	}
	
	@Column(name="bundle_service_name")
	public String getBundle_service_name() {
		return bundle_service_name;
	}
	public void setBundle_service_name(String bundle_service_name) {
		this.bundle_service_name = bundle_service_name;
	}
	
	@Column(name="isPCS")
	public boolean isPcs() {
		return pcs;
	}
	public void setPcs(boolean pcs) {
		this.pcs = pcs;
	}
	
	@Column(name="isIN")
	public boolean isIn() {
		return in;
	}
	public void setIn(boolean in) {
		this.in = in;
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
		result = prime
				* result
				+ ((bundle_service_name == null) ? 0 : bundle_service_name
						.hashCode());
		result = prime * result + (in ? 1231 : 1237);
		result = prime * result + (pcs ? 1231 : 1237);
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
		BundleService other = (BundleService) obj;
		if (active != other.active)
			return false;
		if (bundle_service_id == null) {
			if (other.bundle_service_id != null)
				return false;
		} else if (!bundle_service_id.equals(other.bundle_service_id))
			return false;
		if (bundle_service_name == null) {
			if (other.bundle_service_name != null)
				return false;
		} else if (!bundle_service_name.equals(other.bundle_service_name))
			return false;
		if (in != other.in)
			return false;
		if (pcs != other.pcs)
			return false;
		return true;
	}

}
