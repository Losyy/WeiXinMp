package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;
import cn.com.losy.didi.pojo.PassengerStatu;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class PassengerStatuDaoImplOrmLite extends BaseDaoImpl<PassengerStatu, String> {

	public PassengerStatuDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, PassengerStatu.class);
	}

}
