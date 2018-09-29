package net.tot3g.omclient.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import net.tot3g.omclient.dao.WS_Mvno__Dao;
import net.tot3g.omclient.model.WS_MVNO;


public class WS_Mvno_JdbcDao extends JdbcDaoSupport implements WS_Mvno__Dao {
	
	String sql = "SELECT ws_istotoperation,ws_mvno_operation,ws_sourcesystem,ws_isrequirementsms,ws_mvno_name,ws_webappname,ws_mvno_password,ws_mvno_username,ws_mvno_id FROM ws_mvno ";
	

	private static final RowMapper<WS_MVNO> ROW_MAPPER = new RowMapper<WS_MVNO>() {
		public WS_MVNO mapRow(ResultSet rs, int rowNum) throws SQLException {
			WS_MVNO ws_mvno = new WS_MVNO();
			ws_mvno.setWs_isrequirementsms(("0".equals(rs.getString("ws_isrequirementsms"))?true:false));
			ws_mvno.setWs_mvno_id(rs.getString("ws_mvno_id"));
			ws_mvno.setWs_mvno_name(rs.getString("ws_mvno_name"));
			ws_mvno.setWs_mvno_password(rs.getString("ws_mvno_password"));
			ws_mvno.setWs_mvno_username(rs.getString("ws_mvno_username"));
			ws_mvno.setWs_sourcesystem(rs.getString("ws_sourcesystem"));
			ws_mvno.setWs_webappname(rs.getString("ws_webappname"));	
			ws_mvno.setWs_mvno_operation(rs.getString("ws_mvno_operation"));			
			ws_mvno.setWs_istotoperation(("0".equals(rs.getString("ws_istotoperation"))?true:false));		
			return ws_mvno;
		}
	};
		
	public WS_MVNO getMvno(String username, String password,String operation) {		
		List<WS_MVNO> list = getJdbcTemplate().query(sql+" WHERE ws_mvno_username='"+username+"' and ws_mvno_password='"+password+"'",ROW_MAPPER);
		if(list.size()!=1)
		{
			WS_MVNO mvno = new WS_MVNO();
			mvno.setWs_webappname(null);
			return mvno;
		}
		else
		{
			WS_MVNO mvnodata = list.get(0);
			if(!mvnodata.isWs_istotoperation())
			{
				List<WS_MVNO> list_withoperation = getJdbcTemplate().query(sql+" WHERE ws_mvno_username='"+username+"' and ws_mvno_password='"+password+"' and ws_mvno_operation like'%"+operation+"%'",ROW_MAPPER);
				if(list_withoperation.size()!=1)
				{
					WS_MVNO errorwithservicenotsupport = new WS_MVNO();
					errorwithservicenotsupport.setWs_iscanuseservice(false);
					errorwithservicenotsupport.setWs_webappname(null);
					return errorwithservicenotsupport;
				}
				else
				{
					return list.get(0);
				}	
			}
			else
			{
				return mvnodata;
			}
		}
	}

}
