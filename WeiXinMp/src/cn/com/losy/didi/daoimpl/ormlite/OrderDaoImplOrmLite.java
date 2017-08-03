package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;

import cn.com.losy.didi.pojo.Order;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class OrderDaoImplOrmLite extends BaseDaoImpl<Order, String> {

	public OrderDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Order.class);
	}

}
