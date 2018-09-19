package net.tot3g.omclient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.tot3g.omclient.dao.ApplicationConfigDao;
import net.tot3g.omclient.model.ApplicationConfig;
import net.tot3g.omclient.service.ApplicationConfigService;

@Service("applicationconfigService")
public class ApplicationConfigServiceImpl implements ApplicationConfigService{
	
	@Autowired
	private ApplicationConfigDao applicationconfigDao;

	public ApplicationConfig get(String configname) {
		return applicationconfigDao.get(configname);
	}

	public List<ApplicationConfig> get() {
		return applicationconfigDao.get();
	}

}
