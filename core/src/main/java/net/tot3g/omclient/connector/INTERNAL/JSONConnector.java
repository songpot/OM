package net.tot3g.omclient.connector.INTERNAL;

import java.io.IOException;

import org.json.JSONObject;

public interface JSONConnector {
	
	public String sendJSONRequest(String url,JSONObject obj) throws IOException ;

}
