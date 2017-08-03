package cn.com.losy.didi.support;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;

public class ConnectionSourceGenerator {
	private static String db_url = "jdbc:mysql://sqld.duapp.com:4050/QdyqUfxhHCfDEbjAjbMs";
//	private static String db_driver = "com.mysql.jdbc.Driver";
	private static String db_username = "66a7c3a3b9344174a6218f144765896c";
	private static String db_password = "49ee0eed36aa46a698a4948470855b56";
	
	public static JdbcPooledConnectionSource connectionSource = null;
	public static JdbcPooledConnectionSource get() {
		try {
			if (connectionSource == null) {
				connectionSource = new JdbcPooledConnectionSource (
						db_url, db_username, db_password);
				
				// only keep the connections open for 5 minutes
				connectionSource.setMaxConnectionAgeMillis(5 * 60 * 1000);
				// change the check-every milliseconds from 30 seconds to 60
				connectionSource.setCheckConnectionsEveryMillis(60 * 1000);
				// for extra protection, enable the testing of connections
				// right before they are handed to the user
				connectionSource.setTestBeforeGet(true);
			}
			return connectionSource;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ConnectionSourceGenerator() {
	}
}
