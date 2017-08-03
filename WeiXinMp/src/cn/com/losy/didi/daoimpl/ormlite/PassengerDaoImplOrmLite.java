package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;
import cn.com.losy.didi.pojo.Passenger;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class PassengerDaoImplOrmLite extends BaseDaoImpl<Passenger, String> {

	public PassengerDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Passenger.class);
	}

}
