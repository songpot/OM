package net.tot3g.omclient.model;

public class QueryAllPCS_OMWebService {
	
	private String msisdn;	
	private String resettype;
	private String startdate;
	private String enddate;
	private String toppingname;
	private String time;
	private String totalQuota;
	private String usedQuota;
	private String pcspriceplan;
	
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getResettype() {
		return resettype;
	}
	public void setResettype(String resettype) {
		this.resettype = resettype;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	public String getPcspriceplan() {
		return pcspriceplan;
	}
	public void setPcspriceplan(String pcspriceplan) {
		this.pcspriceplan = pcspriceplan;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getToppingname() {
		return toppingname;
	}
	public void setToppingname(String toppingname) {
		this.toppingname = toppingname;
	}
	
}
