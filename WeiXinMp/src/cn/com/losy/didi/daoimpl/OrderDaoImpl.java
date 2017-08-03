package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;
import cn.com.losy.didi.dao.OrderDao;
import cn.com.losy.didi.daoimpl.ormlite.OrderDaoImplOrmLite;
import cn.com.losy.didi.pojo.Order;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class OrderDaoImpl implements OrderDao {
	private static OrderDaoImplOrmLite daoImplOrmlite = null;
	
	public OrderDaoImpl() throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new OrderDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}

	@Override
	public int insert(Order pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public Order queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<Order> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(Order pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}
}
