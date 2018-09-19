package net.tot3g.omclient.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "mvno")
@XmlRootElement
public class Mvno extends BaseObject {
	 private  String mvnoCode;
	 private  String mvnoID;
	 private  String mvno;		
	 
	@Id
	@Column(name="mvnoCode", length=15,nullable=false)	
	public String getMvnoCode() {
		return mvnoCode;
	}
	public void setMvnoCode(String mvnoCode) {
		this.mvnoCode = mvnoCode;
	}
	
	@Column(name="mvnoID", length=150,nullable=false)
	public String getMvnoID() {
		return mvnoID;
	}
	public void setMvnoID(String mvnoID) {
		this.mvnoID = mvnoID;
	}
	
	@Column(name="mvno", length=50,nullable=false)
	public String getMvno() {
		return mvno;
	}
	public void setMvno(String mvno) {
		this.mvno = mvno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mvno == null) ? 0 : mvno.hashCode());
		result = prime * result
				+ ((mvnoCode == null) ? 0 : mvnoCode.hashCode());
		result = prime * result + ((mvnoID == null) ? 0 : mvnoID.hashCode());
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
		Mvno other = (Mvno) obj;
		if (mvno == null) {
			if (other.mvno != null)
				return false;
		} else if (!mvno.equals(other.mvno))
			return false;
		if (mvnoCode == null) {
			if (other.mvnoCode != null)
				return false;
		} else if (!mvnoCode.equals(other.mvnoCode))
			return false;
		if (mvnoID == null) {
			if (other.mvnoID != null)
				return false;
		} else if (!mvnoID.equals(other.mvnoID))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "mvno [mvnoCode=" + mvnoCode + ", mvnoID=" + mvnoID + ", mvno="
				+ mvno + "]";
	}
	
	
	
	
}
