package net.tot3g.omclient.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import net.tot3g.omclient.dao.Config_EndpointDao;
import net.tot3g.omclient.model.Config_Endpoint;

public class Config_EndpointJdbcDao extends JdbcDaoSupport implements Config_EndpointDao {
	
	String SQL ="select * from config_endpoint ";
	
	private static final RowMapper<Config_Endpoint> ROW_MAPPER = new RowMapper<Config_Endpoint>() {
		public Config_Endpoint mapRow(ResultSet rs, int rowNum) throws SQLException {
			Config_Endpoint profile = new Config_Endpoint();
			profile.setTrxID(rs.getLong("trxID"));
			profile.setActive(!rs.getBoolean("active"));
			profile.setCreateTime(rs.getTime("createTime"));
			profile.setCreateuser(rs.getString("createuser"));
			profile.setDefaultvalue(rs.getString("defaultvalue"));
			profile.setSourcesystem(rs.getString("sourcesystem"));
			profile.setUsername(rs.getString("username"));
			profile.setPassword(rs.getString("password"));
			
			return profile;
		}
	};

	public Config_Endpoint getConfigBySourcesystem(String sourcesystemname) {
		List<Config_Endpoint> profiles = getJdbcTemplate().query(SQL+" where active=0 and sourcesystem like ?",new Object[]{sourcesystemname},ROW_MAPPER);
		Config_Endpoint profile = null;
		if(profiles!=null&&!profiles.isEmpty())
		{
			profile=(Config_Endpoint)profiles.get(0);			
		}
		
		return profile;
	}

}
