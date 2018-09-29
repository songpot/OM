package net.tot3g.omclient.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.tot3g.omclient.dao.ApplicationConfigDao;
import net.tot3g.omclient.model.ApplicationConfig;

@Repository("applicationconfigDao")
public class ApplicationConfigJdbcDao extends JdbcDaoSupport implements ApplicationConfigDao {

	String SQL ="select * from applicationconfig ";
	
	private static final RowMapper<ApplicationConfig> ROW_MAPPER = new RowMapper<ApplicationConfig>() {
		public ApplicationConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
			ApplicationConfig config = new ApplicationConfig();
			config.setId(rs.getInt("Application_Config_ID"));
			config.setKey(rs.getString("appkey"));
			config.setValue(rs.getString("value"));
						
			return config;
		}
	};	

	public ApplicationConfig get(String configname) {
		List<ApplicationConfig> configdatas = getJdbcTemplate().query(SQL+" where appkey=?",new Object[]{configname},ROW_MAPPER);
		ApplicationConfig configdata = null;
		if(configdatas!=null&&!configdatas.isEmpty())
		{
			configdata=(ApplicationConfig)configdatas.get(0);			
		}
		
		return configdata;		
	}

	public List<ApplicationConfig> get() {
		return getJdbcTemplate().query(SQL,ROW_MAPPER);
	}

}
