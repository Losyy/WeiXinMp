package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;

import cn.com.losy.didi.dao.PassengerDao;
import cn.com.losy.didi.daoimpl.ormlite.PassengerDaoImplOrmLite;
import cn.com.losy.didi.pojo.Passenger;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class PassengerDaoImpl implements PassengerDao {

	private static PassengerDaoImplOrmLite daoImplOrmlite = null;
	
	public PassengerDaoImpl()  throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new PassengerDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}
	
	@Override
	public int insert(Passenger pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public Passenger queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<Passenger> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(Passenger pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}

}
