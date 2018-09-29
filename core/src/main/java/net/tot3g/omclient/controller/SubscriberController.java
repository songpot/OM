package net.tot3g.omclient.controller;

import net.tot3g.omclient.model.Response;

public interface SubscriberController {
	
	public Response subscribeDATA(String username , String password ,String priceplan,String msisdn);

}
