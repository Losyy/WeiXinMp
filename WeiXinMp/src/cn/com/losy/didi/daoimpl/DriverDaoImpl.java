package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;
import cn.com.losy.didi.dao.DriverDao;
import cn.com.losy.didi.daoimpl.ormlite.DriverDaoImplOrmLite;
import cn.com.losy.didi.pojo.Driver;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class DriverDaoImpl implements DriverDao {

	private static DriverDaoImplOrmLite daoImplOrmlite = null;
	
	public DriverDaoImpl() throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new DriverDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}

	@Override
	public int insert(Driver pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public Driver queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<Driver> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(Driver pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}

}
