package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;
import cn.com.losy.didi.dao.PassengerStatuDao;
import cn.com.losy.didi.daoimpl.ormlite.PassengerStatuDaoImplOrmLite;
import cn.com.losy.didi.pojo.PassengerStatu;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class PassengerStatuDaoImpl implements PassengerStatuDao{
	private static PassengerStatuDaoImplOrmLite daoImplOrmlite = null;
	
	public PassengerStatuDaoImpl()  throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new PassengerStatuDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}
	
	@Override
	public int insert(PassengerStatu pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public PassengerStatu queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<PassengerStatu> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(PassengerStatu pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}
}
