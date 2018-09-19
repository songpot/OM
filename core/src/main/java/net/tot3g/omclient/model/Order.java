package net.tot3g.omclient.model;

import java.util.Date;

public class Order {
		
	private Date CWORDERCREATIONDATE;
	private String CWORDERID;
	private String SOURCESYSTEMID;
	private String MSISDN;
	private String IMSI;
	private String MOBILETYPE;
	private String OPERATIONCODE;
	private String ERRORCODE;
	private String ERRORDESCRIPTION;
	private String SHORTDESCRIPTION;
	private String MVNOID;
	private String REQUEST;
	private String ORDERID;
	private String ERRORTYPE;
	private String ORDERSTATUS;
	private String ORDERUSERID;
	
	public Date getCWORDERCREATIONDATE() {
		return CWORDERCREATIONDATE;
	}
	public void setCWORDERCREATIONDATE(Date cWORDERCREATIONDATE) {
		CWORDERCREATIONDATE = cWORDERCREATIONDATE;
	}
	public String getCWORDERID() {
		return CWORDERID;
	}
	public void setCWORDERID(String cWORDERID) {
		CWORDERID = cWORDERID;
	}
	public String getSOURCESYSTEMID() {
		return SOURCESYSTEMID;
	}
	public void setSOURCESYSTEMID(String sOURCESYSTEMID) {
		SOURCESYSTEMID = sOURCESYSTEMID;
	}
	public String getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}
	public String getIMSI() {
		return IMSI;
	}
	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}
	public String getMOBILETYPE() {
		return MOBILETYPE;
	}
	public void setMOBILETYPE(String mOBILETYPE) {
		MOBILETYPE = mOBILETYPE;
	}
	public String getOPERATIONCODE() {
		return OPERATIONCODE;
	}
	public void setOPERATIONCODE(String oPERATIONCODE) {
		OPERATIONCODE = oPERATIONCODE;
	}
	public String getERRORCODE() {
		return ERRORCODE;
	}
	public void setERRORCODE(String eRRORCODE) {
		ERRORCODE = eRRORCODE;
	}
	public String getERRORDESCRIPTION() {
		return ERRORDESCRIPTION;
	}
	public void setERRORDESCRIPTION(String eRRORDESCRIPTION) {
		ERRORDESCRIPTION = eRRORDESCRIPTION;
	}
	public void setMVNOID(String mVNOID) {
		MVNOID = mVNOID;
	}
	public String getMVNOID() {
		return MVNOID;
	}
	public String getREQUEST() {
		return REQUEST;
	}
	public void setREQUEST(String rEQUEST) {
		REQUEST = rEQUEST;
	}
	public String getORDERID() {
		return ORDERID;
	}
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}
	public String getERRORTYPE() {
		return ERRORTYPE;
	}
	public void setERRORTYPE(String eRRORTYPE) {
		ERRORTYPE = eRRORTYPE;
	}
	public String getORDERSTATUS() {
		return ORDERSTATUS;
	}
	public void setORDERSTATUS(String oRDERSTATUS) {
		ORDERSTATUS = oRDERSTATUS;
	}
	public String getSHORTDESCRIPTION() {
		return SHORTDESCRIPTION;
	}
	public void setSHORTDESCRIPTION(String sHORTDESCRIPTION) {
		SHORTDESCRIPTION = sHORTDESCRIPTION;
	}
	public String getORDERUSERID() {
		return ORDERUSERID;
	}
	public void setORDERUSERID(String oRDERUSERID) {
		ORDERUSERID = oRDERUSERID;
	}
	
}
