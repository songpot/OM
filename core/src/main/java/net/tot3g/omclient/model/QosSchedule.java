package net.tot3g.omclient.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


public class QosSchedule {
	
	private String qos_schedule_id;
	private String msisdn;
	private String sourcesystem;
	private String identificationcode;
	private String qos_profile_id;
	private String status;
	private String createdate;
	private String enddate;
	
	public String getQos_schedule_id() {
		return qos_schedule_id;
	}
	public void setQos_schedule_id(String qos_schedule_id) {
		this.qos_schedule_id = qos_schedule_id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getSourcesystem() {
		return sourcesystem;
	}
	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}
	public String getIdentificationcode() {
		return identificationcode;
	}
	public void setIdentificationcode(String identificationcode) {
		this.identificationcode = identificationcode;
	}
	public String getQos_profile_id() {
		return qos_profile_id;
	}
	public void setQos_profile_id(String qos_profile_id) {
		this.qos_profile_id = qos_profile_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


}
