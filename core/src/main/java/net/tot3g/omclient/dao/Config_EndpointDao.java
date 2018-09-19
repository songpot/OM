package net.tot3g.omclient.dao;

import net.tot3g.omclient.model.Config_Endpoint;

public interface Config_EndpointDao {
	
	public Config_Endpoint getConfigBySourcesystem(String sourcesystemname);

}
