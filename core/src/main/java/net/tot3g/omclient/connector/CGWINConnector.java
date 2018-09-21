package net.tot3g.omclient.connector;

import net.tot3g.omclient.model.ALUInfoSub;
import net.tot3g.omclient.model.Response;

public interface CGWINConnector  {
	
	public boolean checkSubscriberExist(String msisd,String mvnon);
	
	public String getTagdata(String tag,String msisdn,String mvnon);	
	
	public String getData(String msisdn,String mvno);
	
	public String checkVoiceToppingState(String identifier, String sogRef); // no | date | expired
	
	public boolean forceRemoveSog(String identifier, String sogRef, String mvnoId);
	
	public boolean subscribeVoiceTopping(String identifier, String sogRef, String mvnoId, String createDate, String stopDate);
	
	public String getSubscriberInfo(String identifier); // return xml response
	
	public ALUInfoSub getSubscriberALUInfoSub(String identifier);
	
	public ALUInfoSub getSubscriberALUInfoSub(String msisdn,String mvno);
	
	public String getRemainingBundle(String identifier, String bundleName); // bundleName = da1 | da2 ...da9
	
	public Response adjustbalance(String msisdn,String amount,String type,String username);
	
	public Response adjustbalance(String msisdn,String amount,String type,String username,String bucket);
}
