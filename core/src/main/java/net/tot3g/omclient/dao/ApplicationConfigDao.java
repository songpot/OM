package net.tot3g.omclient.dao;

import java.util.List;

import net.tot3g.omclient.model.ApplicationConfig;

public interface ApplicationConfigDao {
	
	public ApplicationConfig get(String configname);
	public List<ApplicationConfig> get();

}
