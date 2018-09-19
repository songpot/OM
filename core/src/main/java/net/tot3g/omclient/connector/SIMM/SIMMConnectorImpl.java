package net.tot3g.omclient.connector.SIMM;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.hp.foss.webservice.GetMSISDNInfoRequest;
import com.hp.foss.webservice.GetMSISDNInfoRequestData;
import com.hp.foss.webservice.GetMSISDNInfoResponseData;
import com.hp.foss.webservice.GetMSISDNInfoService;
import com.hp.foss.webservice.GetSIMCardInfoRequest;
import com.hp.foss.webservice.GetSIMCardInfoRequestData;
import com.hp.foss.webservice.GetSIMCardInfoResponseData;
import com.hp.foss.webservice.GetSIMCardInfoService;

import net.tot3g.omclient.dao.Config_EndpointDao;
import net.tot3g.omclient.model.Config_Endpoint;

public class SIMMConnectorImpl implements SIMMConnector{
	
	@Autowired
	private Config_EndpointDao config_endpointDao;
	
	private Config_Endpoint _getSimcardInfoEndpoint;
	
	private Config_Endpoint _getMSISDNInfoEndpoint;
	
	public String getSimcardInfoEndpoint()
	{
		if(_getSimcardInfoEndpoint==null)
			_getSimcardInfoEndpoint =  config_endpointDao.getConfigBySourcesystem("getSIMCardInfoService");		
		return _getSimcardInfoEndpoint.getDefaultvalue();
	}
	
	public String getMSISDNInfoEndpoint()
	{
		if(_getMSISDNInfoEndpoint==null)
			_getMSISDNInfoEndpoint =  config_endpointDao.getConfigBySourcesystem("getMSISDNInfoService");		
		return _getMSISDNInfoEndpoint.getDefaultvalue();
	}

	public GetSIMCardInfoResponseData getSimcardInfo(String data) {
		
		com.hp.foss.webservice.HeaderRequestData headerdata = new com.hp.foss.webservice.HeaderRequestData();
		headerdata.setUsername("nsn");
		headerdata.setPassword("5eb6d580e5f68fde65c3778afb8826ff");
		
		GetSIMCardInfoRequest requestdata = new GetSIMCardInfoRequest();
		requestdata.setHeaderData(headerdata);
		
		GetSIMCardInfoRequestData requesteddata = new GetSIMCardInfoRequestData();
		
		if(data!=null&&data.startsWith("52015"))
			requesteddata.setImsi(data);
		else if(data!=null&&data.startsWith("89"))
			requesteddata.setIccid(data);
		
		requestdata.setGetSIMCardInfo(requesteddata);
		
		GetSIMCardInfoResponseData Responsedata = null;
		try {
			
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean(); 
			factory.setServiceClass(GetSIMCardInfoService.class); 
			factory.setAddress(getSimcardInfoEndpoint()); 
			GetSIMCardInfoService client = (GetSIMCardInfoService) factory.create(); 
			Responsedata = client.getSIMCardInfo(requestdata);
						
		} catch (Exception e) {
			//
			return null;
		}
		
		return Responsedata;
	}

	public GetMSISDNInfoResponseData getMSISDNInfo(String msisdn) {
		com.hp.foss.webservice.HeaderRequestData headerdata = new com.hp.foss.webservice.HeaderRequestData();
		headerdata.setUsername("nsn");
		headerdata.setPassword("5eb6d580e5f68fde65c3778afb8826ff");
		
		GetMSISDNInfoRequest requestdata = new GetMSISDNInfoRequest();
		requestdata.setHeaderData(headerdata);
		
		GetMSISDNInfoRequestData requesteddata = new GetMSISDNInfoRequestData();
		
		
		requesteddata.setMsisdn(msisdn);		
		requestdata.setGetMSISDNInfo(requesteddata);
		
		GetMSISDNInfoResponseData Responsedata = null;
		try {
			
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean(); 
			factory.setServiceClass(GetMSISDNInfoService.class); 
			factory.setAddress(getMSISDNInfoEndpoint()); 
			GetMSISDNInfoService client = (GetMSISDNInfoService)factory.create(); 
			Responsedata = client.getMSISDNInfo(requestdata);
						
			//util convert to subscriberdata object
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//
			return null;
		}
		
		return Responsedata;
	}
	
	

}
