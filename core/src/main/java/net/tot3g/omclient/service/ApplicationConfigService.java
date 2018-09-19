package net.tot3g.omclient.service;

import java.util.List;

import net.tot3g.omclient.model.ApplicationConfig;

public interface ApplicationConfigService {
	
	public ApplicationConfig get(String configname);
	public List<ApplicationConfig> get();

}
