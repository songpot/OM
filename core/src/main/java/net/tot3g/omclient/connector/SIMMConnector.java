package net.tot3g.omclient.connector;

import java.util.List;

import com.hp.foss.webservice.GetMSISDNInfoResponseData;
import com.hp.foss.webservice.GetSIMCardInfoResponseData;

import net.tot3g.omclient.model.Response;

public interface SIMMConnector {
		public GetSIMCardInfoResponseData getSimcardInfo(String data);
		public GetMSISDNInfoResponseData getMSISDNInfo(String msisdn);	
}
