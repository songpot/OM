package net.tot3g.omclient.dao;

import java.util.List;

import net.tot3g.omclient.model.SMS_Profile;


public interface SMS_Profile_Dao {
	
	public List<SMS_Profile>  getSMSMessage(String messageid);

}
