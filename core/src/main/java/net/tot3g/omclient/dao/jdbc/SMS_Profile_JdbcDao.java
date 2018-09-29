package net.tot3g.omclient.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.tot3g.omclient.dao.SMS_Profile_Dao;
import net.tot3g.omclient.model.SMS_Profile;

public class SMS_Profile_JdbcDao extends JdbcDaoSupport implements SMS_Profile_Dao {
		
	String SQL ="select *  from sms_profile "; 	
	
	private static final RowMapper<SMS_Profile> ROW_MAPPER = new RowMapper<SMS_Profile>() {
		public SMS_Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
			SMS_Profile profile = new SMS_Profile();
			profile.setSms_profile_id(rs.getInt("sms_profile_id"));
			profile.setSms_profile_messageid(rs.getString("sms_profile_messageid"));
			profile.setSms_profile_messagetxt(rs.getString("sms_profile_messagetxt"));
			
			return profile;
		}
	};
	

	public List<SMS_Profile> getSMSMessage(String messageid) {
		return getJdbcTemplate().query(SQL+" where sms_profile_messageid like ? and active=0 ",new Object[]{messageid},ROW_MAPPER);
	}
}
