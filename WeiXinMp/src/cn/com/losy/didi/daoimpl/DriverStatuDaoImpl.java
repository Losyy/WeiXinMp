package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;
import cn.com.losy.didi.dao.DriverStatuDao;
import cn.com.losy.didi.daoimpl.ormlite.DriverStatuDaoImplOrmLite;
import cn.com.losy.didi.pojo.DriverStatu;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class DriverStatuDaoImpl implements DriverStatuDao {

	private static DriverStatuDaoImplOrmLite daoImplOrmlite = null;
	
	public DriverStatuDaoImpl() throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new DriverStatuDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}
	
	@Override
	public int insert(DriverStatu pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public DriverStatu queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<DriverStatu> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(DriverStatu pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}

}
