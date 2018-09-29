package net.tot3g.omclient.model;

import java.util.List;

public class PCSAllData {
	
	private String msisdn;
	private String mainpriceplan;
	private String toppingname;	
	private String PCSpriceplan;
	private String startdate;
	private String enddate;
	private String time;
	private String resettype;
	private String totalQuota;
	private String usedQuota;
	private String success;	
	private PCSElementData[] pcselementdata; 
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getSuccess() {
		return success;
	}
	
	public String getUsedQuota() {
		return usedQuota;
	}
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}
	
	public String getMainpriceplan() {
		return mainpriceplan;
	}
	public void setMainpriceplan(String mainpriceplan) {
		this.mainpriceplan = mainpriceplan;
	}
	
	public String getPCSpriceplan() {
		return PCSpriceplan;
	}
	public void setPCSpriceplan(String pCSpriceplan) {
		PCSpriceplan = pCSpriceplan;
	}
	public String getTotalQuota() {
		return totalQuota;
	}
	public void setTotalQuota(String totalQuota) {
		this.totalQuota = totalQuota;
	}	
	public String getResettype() {
		return resettype;
	}
	public void setResettype(String resettype) {
		this.resettype = resettype;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public PCSElementData[] getPcselementdata() {
		return pcselementdata;
	}
	public void setPcselementdata(PCSElementData[] pcselementdata) {
		this.pcselementdata = pcselementdata;
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
