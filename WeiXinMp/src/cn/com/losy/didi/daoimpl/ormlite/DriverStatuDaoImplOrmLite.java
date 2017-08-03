package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;

import cn.com.losy.didi.pojo.DriverStatu;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class DriverStatuDaoImplOrmLite extends BaseDaoImpl<DriverStatu, String> {

	public DriverStatuDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, DriverStatu.class);
	}

}
