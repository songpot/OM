package net.tot3g.omclient.connector.ALUIN;

import java.text.MessageFormat;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import net.tot3g.omclient.Constants;
import net.tot3g.omclient.connector.CGWINConnector;
import net.tot3g.omclient.connector.common.HTTPConnector;
import net.tot3g.omclient.connector.common.SOAPConnector;
import net.tot3g.omclient.model.ALUInfoSub;
import net.tot3g.omclient.model.Response;

public class CGWINConnectorALUINImpl implements CGWINConnector {
	
	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private SOAPConnector ALUINConnector;
	
	@Autowired
	private SOAPConnector ALUINBucketConnector;
		
	@Autowired
	private HTTPConnector aluin_hds_connection;	
	
	private final String aluinquery = "/order_template/ALU-IN-Query.xml";
	private final String alu_list_specific_sog = "/order_template/alu_list_specific_sog.xml";
	private final String alu_force_remove_sog = "/order_template/alu_force_remove_sog.xml";
	private final String alu_create_sog = "/order_template/alu_create_sog.xml";
	private final String alu_get_bucket = "/order_template/alu_get_bucket.xml";
	private final String alu_get_Info = "/order_template/alu_get_Info.xml";
	private final String aluin_adjust = "/order_template/alu_hds_adjust.xml";
	private final String aluin_adjust_bucket = "/order_template/alu_adjust_bucket.xml";

	
	public boolean checkSubscriberExist(String msisdn,String mvno) {
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluinquery));			
			
			xml = MessageFormat.format(xml, new Object[] {msisdn.substring(2),Constants.IN_SERVICERETAILERNAME});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			return response.contains("ax220:identifierLogin");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}

	public String getTagdata(String tag, String msisdn,String mvno) {
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluinquery));						
			
			xml = MessageFormat.format(xml, new Object[] {msisdn.substring(2),Constants.IN_SERVICERETAILERNAME});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			if("identifier".equals(tag))
			{
				String[] datasplit = response.split("<ax220:subscriberKeys type=\"com.alcatel.in.osp.services.icc.api.web.pojo.KeyElement\">");
				for(int i =1;i<datasplit.length;i++)
				{
					if(datasplit[i].contains("52015"))
					{
						response = datasplit[i];
					}						
				}
				
			} // Edit By Wanatsanan 28/02/2017
			else if("identifierLogin".equals(tag))
			{
				String[] datasplit = response.split("<ax220:subscriberKeys type=\"com.alcatel.in.osp.services.icc.api.web.pojo.KeyElement\">");
				for(int i =1;i<datasplit.length;i++)
				{
					String identifierType = CGWINConnectorALUINRespUtil.createTagResponse(datasplit[i], "identifierType");
					if("1".equals(identifierType))
					{
						response = datasplit[i];
					}						
				}
				
				tag = "identifier";
			}
			
			return CGWINConnectorALUINRespUtil.createTagResponse(response, tag);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "";
		}
	}
	
	public String getData(String msisdn,String mvno) {
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluinquery));
		
			xml = MessageFormat.format(xml, new Object[] {msisdn.substring(2),Constants.IN_SERVICERETAILERNAME});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			return  response;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "";
		}
	}

	public String checkVoiceToppingState(String identifier, String sogRef) {
				
		String state = "";
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_list_specific_sog));
			
			xml = MessageFormat.format(xml, new Object[] {identifier,sogRef,Constants.IN_SERVICERETAILERNAME});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			state = CGWINConnectorALUINRespUtil.extractUtil(response, "ax218:state", 0);
			
			if(state.isEmpty() || "".equals(state) || state == null)
			{
				state = "no";
			}
			else if("1".equals(state))
			{
				state = CGWINConnectorALUINRespUtil.extractUtil(response, "ax218:stopDate", 0); // date Ex. 2015-06-02T08:00:41.000Z
				
			}
			else // exists and expired
			{
				state = "expired";
			}
					
			return  state;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public boolean forceRemoveSog(String identifier, String sogRef, String mvnoId) {
					
		boolean state = false;		
		
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_force_remove_sog));
			
			xml = MessageFormat.format(xml, new Object[] {identifier,sogRef,Constants.IN_SERVICERETAILERNAME});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			String comment = CGWINConnectorALUINRespUtil.extractUtil(response, "ax218:comment", 0);
			state = ("Successful".equals(comment))?true:false;
					
			return  state;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}

	public boolean subscribeVoiceTopping(String identifier, String sogRef, String mvnoId,
			String createDate, String stopDate) {
		
		boolean success = false;
		String state = "";		
		
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_create_sog));
			
			xml = MessageFormat.format(xml, new Object[] {identifier,sogRef,Constants.IN_SERVICERETAILERNAME,createDate,stopDate});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			state = CGWINConnectorALUINRespUtil.extractUtil(response, "ax218:state", 0);
			success = ("1".equals(state))?true:false;
								
			return  success;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		
	}

	public String getSubscriberInfo(String identifier) {
		
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_get_Info));
			
			xml = MessageFormat.format(xml, new Object[] {identifier});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
							
			return  response;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "";
		}
		
	}

	public String getRemainingBundle(String identifier, String bundleName) {
		
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_get_bucket));
			
			xml = MessageFormat.format(xml, new Object[] {identifier,bundleName});
			
			log.debug(xml);
			
			
			ALUINBucketConnector.setSOAPAction("Submit");
			String response = ALUINBucketConnector.sendRequest(xml);
			String remaining = CGWINConnectorALUINRespUtil.extractUtil(response, "ax26:remainingUnits", 0);
					
			return  remaining;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "";
		}
	}
	
	public ALUInfoSub getSubscriberALUInfoSub(String msisdn,String mvno) {
		
		ALUInfoSub aluInfo = new ALUInfoSub();
		try {

			String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluinquery));					
			
			xml = MessageFormat.format(xml, new Object[] {msisdn.substring(2),Constants.IN_SERVICERETAILERNAME});
	
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			if(!"".equals(response) || response != null)
			{
				
				// Get Data Under defaultAccount Tag
				int start = StringUtils.indexOf(response, "<ax220:defaultAccount");
				int end = StringUtils.indexOf(response, "</ax220:defaultAccount>");
				
				if(start >= 0 && end >=0) // not found = -1
				{
					String defaultAccountInfo = StringUtils.substring(response, start, end);
					String midnight = " 23:59:59";
					
					// Set accountProfileRef
					aluInfo.setAccountProfileRef(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:accountProfileRef",0));
					
					// Set cardNumber 
					aluInfo.setCardNumber(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:cardNumber",0));
					
					// Set imsi
					aluInfo.setImsi(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:msid",0));
					
					// Set status
					String statusValue = CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:cycleStatus",0);
					String status= ("".equals(statusValue)?statusValue:("0".equals(statusValue))?"create":("1".equals(statusValue)?"valid":("2".equals(statusValue)?"active":("3".equals(statusValue)?"inactive2":("4".equals(statusValue)?"deactive2":("5".equals(statusValue)?"inactive1":("6".equals(statusValue)?"deactive1":("7".equals(statusValue)?"no credit":("8".equals(statusValue)?"terminate":"")))))))));
					aluInfo.setStatus(status);
					
					// Set balance
					String balance = CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:balance",0);
					aluInfo.setBalance(("".equals(balance) || balance == null)?"":String.format("%.2f", Double.parseDouble(balance)/100));
					
					
					// Set beginValidityDate
					aluInfo.setBeginValidityDate(CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:validityPeriodBegin",0),1));
					
					// Set endValidityDate
					String endValidityDate = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:validityPeriodEnd",0),1);
					aluInfo.setEndValidityDate("".equals(endValidityDate)?endValidityDate:StringUtils.replace(endValidityDate,StringUtils.substringAfter(endValidityDate," "),midnight));
					
					
					if("".equals(statusValue) || "0".equals(statusValue) || "1".equals(statusValue))
					{
						
						String blank = "-";
						
						// Set isSuspend
						aluInfo.setSuspend(false);
						
						// Set isAdminBlocked
						aluInfo.setAdminBlocked(false);
						
						// Set activityDate
						aluInfo.setActivityDate(blank);
						
						// Set inactiveDate1
						aluInfo.setInactiveDate1(blank);
						
						// Set inactiveDate2
						aluInfo.setInactiveDate2(blank);
						
						// Set deactivityEndDate
						aluInfo.setDeactivityEndDate(blank);
						
					}
					else
					{
						
						// Set isSuspend
						aluInfo.setSuspend(("2".equals(CGWINConnectorALUINRespUtil.extractUtil(response,"ax220:status",0)))?true:false);
						
						// Set isAdminBlocked
						aluInfo.setAdminBlocked(("true".equals(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:admStatusBlocked",0)))?true:false);
						
						// Set activityDate
						// Edit by Wanatsanan 10/11/2017
						aluInfo.setActivityDate(CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:activityBeginDate",0),2));
						
						// Set inactiveDate1
						String inactiveDate1 = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:activityEndDate",0),1);
						aluInfo.setInactiveDate1("".equals(inactiveDate1)?inactiveDate1:StringUtils.replace(inactiveDate1,StringUtils.substringAfter(inactiveDate1," "),midnight));
						
						// Set inactiveDate2
						String inactiveDate2 = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:beginInactivity2",0),1);
						aluInfo.setInactiveDate2("".equals(inactiveDate2)?inactiveDate2:StringUtils.replace(inactiveDate2,StringUtils.substringAfter(inactiveDate2," "),midnight));
						
						// Set deactivityEndDate
						String deactivityEndDate = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:deactivityEndDate",0),1);
						aluInfo.setDeactivityEndDate("".equals(deactivityEndDate)?deactivityEndDate:StringUtils.replace(deactivityEndDate,StringUtils.substringAfter(deactivityEndDate," "),midnight));
						
					}// end else
					
				}
				
				return aluInfo;
			}
			else
			{
				return null;
			}
							
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
		
	}

	public ALUInfoSub getSubscriberALUInfoSub(String identifier) {
		
		ALUInfoSub aluInfo = new ALUInfoSub();
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.alu_get_Info));
			
			xml = MessageFormat.format(xml, new Object[] {identifier});
			
			log.debug(xml);
			
			ALUINConnector.setSOAPAction("Submit");
			String response = ALUINConnector.sendRequest(xml);
			
			if(!"".equals(response) || response != null)
			{
				
				// Get Data Under defaultAccount Tag
				int start = StringUtils.indexOf(response, "<ax220:defaultAccount");
				int end = StringUtils.indexOf(response, "</ax220:defaultAccount>");
				
				if(start >= 0 && end >=0) // not found = -1
				{
					String defaultAccountInfo = StringUtils.substring(response, start, end);
					String midnight = " 23:59:59";
					
					// Set accountProfileRef
					aluInfo.setAccountProfileRef(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:accountProfileRef",0));
					
					// Set cardNumber 
					aluInfo.setCardNumber(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:cardNumber",0));
					
					// Set imsi
					aluInfo.setImsi(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:msid",0));
					
					// Set status
					String statusValue = CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:cycleStatus",0);
					String status= ("".equals(statusValue)?statusValue:("0".equals(statusValue))?"create":("1".equals(statusValue)?"valid":("2".equals(statusValue)?"active":("3".equals(statusValue)?"inactive2":("4".equals(statusValue)?"deactive2":("5".equals(statusValue)?"inactive1":("6".equals(statusValue)?"deactive1":("7".equals(statusValue)?"no credit":("8".equals(statusValue)?"terminate":"")))))))));
					aluInfo.setStatus(status);
					
					// Set balance
					String balance = CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:balance",0);
					aluInfo.setBalance(("".equals(balance) || balance == null)?"":String.format("%.2f", Double.parseDouble(balance)/100));
					
					
					// Set beginValidityDate
					aluInfo.setBeginValidityDate(CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:validityPeriodBegin",0),1));
					
					// Set endValidityDate
					String endValidityDate = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:validityPeriodEnd",0),1);
					aluInfo.setEndValidityDate("".equals(endValidityDate)?endValidityDate:StringUtils.replace(endValidityDate,StringUtils.substringAfter(endValidityDate," "),midnight));
					
					
					if("".equals(statusValue) || "0".equals(statusValue) || "1".equals(statusValue))
					{
						
						String blank = "-";
						
						// Set isSuspend
						aluInfo.setSuspend(false);
						
						// Set isAdminBlocked
						aluInfo.setAdminBlocked(false);
						
						// Set activityDate
						aluInfo.setActivityDate(blank);
						
						// Set inactiveDate1
						aluInfo.setInactiveDate1(blank);
						
						// Set inactiveDate2
						aluInfo.setInactiveDate2(blank);
						
						// Set deactivityEndDate
						aluInfo.setDeactivityEndDate(blank);
						
					}
					else
					{
						
						// Set isSuspend
						aluInfo.setSuspend(("2".equals(CGWINConnectorALUINRespUtil.extractUtil(response,"ax220:status",0)))?true:false);
						
						// Set isAdminBlocked
						aluInfo.setAdminBlocked(("true".equals(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:admStatusBlocked",0)))?true:false);
						
						// Set activityDate
						// Edit by Wanatsanan 10/11/2017
						aluInfo.setActivityDate(CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:activityBeginDate",0),2));
						
						// Set inactiveDate1
						String inactiveDate1 = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:activityEndDate",0),1);
						aluInfo.setInactiveDate1("".equals(inactiveDate1)?inactiveDate1:StringUtils.replace(inactiveDate1,StringUtils.substringAfter(inactiveDate1," "),midnight));
						
						// Set inactiveDate2
						String inactiveDate2 = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:beginInactivity2",0),1);
						aluInfo.setInactiveDate2("".equals(inactiveDate2)?inactiveDate2:StringUtils.replace(inactiveDate2,StringUtils.substringAfter(inactiveDate2," "),midnight));
						
						// Set deactivityEndDate
						String deactivityEndDate = CGWINConnectorALUINRespUtil.extractDateTime(CGWINConnectorALUINRespUtil.extractUtil(defaultAccountInfo,"ax220:deactivityEndDate",0),1);
						aluInfo.setDeactivityEndDate("".equals(deactivityEndDate)?deactivityEndDate:StringUtils.replace(deactivityEndDate,StringUtils.substringAfter(deactivityEndDate," "),midnight));
						
					}// end else
					
				}
				
				return aluInfo;
			}
			else
			{
				return null;
			}
							
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
		
	}

	public Response adjustbalance(String msisdn, String amount, String type,
			String username) {
		Response res = new Response();
		try {
			String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluin_adjust));
			xml = MessageFormat.format(xml, new Object[] {msisdn.substring(2)+"_"+type+"_"+amount,type,msisdn.substring(2),amount,username});
			
			log.info("["+msisdn+"] Request : "+xml);
			
			String response = aluin_hds_connection.sendRequest(xml);
			
			log.info("["+msisdn+"] Response : "+response);
			
			if("0".equals(extract(response,"result",0)))
				res.setSuccess(true);
			else
			{
				log.info("["+msisdn+"] fail log : "+extract(response,"rejected_item",0));
				res.setSuccess(false);
                try {
                    res.setDescription(extract(response,"rejected_item",0));
                } catch (Exception ex) {
                }
			}
			
			return res;
									
		} catch (Exception e) {		
			log.info("["+msisdn+"] Trace : "+e.getLocalizedMessage());
			res.setSuccess(false);
            res.setDescription(e.getLocalizedMessage());
            return res;
		}
	}

	public Response adjustbalance(String msisdn, String amount, String type,
			String username, String bucket) {
		Response res = new Response();
        try {
        	
        	String identifier = getTagdata("identifierLogin", msisdn.trim(), Constants.IN_SERVICERETAILERNAME);
        	
            String xml = IOUtils.toString(getClass().getResourceAsStream(this.aluin_adjust_bucket));
            xml = MessageFormat.format(xml, new Object[]{identifier, bucket, amount, username});

            log.info("[" + msisdn + "]"+xml);

            ALUINBucketConnector.setSOAPAction("urn:adjust");
            String response = ALUINBucketConnector.sendRequest(xml);
            
             log.info("[" + msisdn + "]"+response);
            
            if (response.contains("<ns:return>0</ns:return>")) {
                res.setSuccess(true);
            } else {
                res.setSuccess(false);
                try {
                    res.setDescription(response.split("HLAPI")[1].split("</soapenv:Text>")[0]);
                } catch (Exception ex) {
                }
            }

            return res;
        } catch (Exception e) {
            log.info("[" + msisdn + "] cannot adjustBundle in ALUINSubmitter : "+e.getLocalizedMessage());
            res.setSuccess(false);
            res.setDescription(e.getLocalizedMessage());
            return res;
        }
	}
	
	private static String extract(String response, String field, int startPos) {
		int start = StringUtils.indexOf(response, "<" + field + ">", startPos);
		int end = StringUtils.indexOf(response, "</" + field + ">", startPos);
		return StringUtils.substring(response, start + field.length() + 2, end);
	}

}
