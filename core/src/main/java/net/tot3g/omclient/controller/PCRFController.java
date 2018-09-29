package net.tot3g.omclient.controller;

import net.tot3g.omclient.model.Response;

public interface PCRFController {
	
	public Response callsubscribePCS(String username , String password ,String priceplan,String msisdn);

}
