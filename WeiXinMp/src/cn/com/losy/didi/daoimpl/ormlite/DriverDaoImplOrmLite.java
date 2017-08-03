package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;

import cn.com.losy.didi.pojo.Driver;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class DriverDaoImplOrmLite extends BaseDaoImpl<Driver, String> {

	public DriverDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Driver.class);
	}
	
}
