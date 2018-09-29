package net.tot3g.omclient.dao.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import net.tot3g.omclient.dao.WS_Transaction_SMS;
import net.tot3g.omclient.model.Transaction_SMS;


public class WS_Transaction_SMSJdbcDao extends JdbcDaoSupport implements WS_Transaction_SMS {
	
	private final Log log = LogFactory.getLog(getClass());

	public void save(Transaction_SMS smstransaction) {
		//log.info("INSERT INTO ws_transaction_sms(msisdn,sender,description,createtime) VALUES ('"+smstransaction.getMsisdn()+"','"+smstransaction.getSender()+"','"+smstransaction.getDescription()+"', Now())");
		getJdbcTemplate().execute("INSERT INTO ws_transaction_sms(msisdn,sender,description,createtime) VALUES ('"+smstransaction.getMsisdn()+"','"+smstransaction.getSender()+"','"+smstransaction.getDescription()+"', Now())");
	}

}
