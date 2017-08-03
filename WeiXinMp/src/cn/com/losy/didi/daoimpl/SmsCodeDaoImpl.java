package cn.com.losy.didi.daoimpl;

import java.sql.SQLException;
import java.util.List;

import cn.com.losy.didi.dao.SmsCodeDao;
import cn.com.losy.didi.daoimpl.ormlite.OrderDaoImplOrmLite;
import cn.com.losy.didi.daoimpl.ormlite.SmsCodeDaoImplOrmLite;
import cn.com.losy.didi.pojo.Order;
import cn.com.losy.didi.pojo.SmsCode;
import cn.com.losy.didi.support.ConnectionSourceGenerator;

public class SmsCodeDaoImpl implements SmsCodeDao {
	private static SmsCodeDaoImplOrmLite daoImplOrmlite = null;
	
	public SmsCodeDaoImpl() throws SQLException {
		if (daoImplOrmlite == null) {
			daoImplOrmlite = new SmsCodeDaoImplOrmLite(ConnectionSourceGenerator.get());
		}
	}

	@Override
	public int insert(SmsCode pojo) throws SQLException {
		return daoImplOrmlite.create(pojo);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		return daoImplOrmlite.deleteById(id);
	}

	@Override
	public SmsCode queryById(String id) throws SQLException {
		return daoImplOrmlite.queryForId(id);
	}

	@Override
	public List<SmsCode> queryAll() throws SQLException {
		return daoImplOrmlite.queryForAll();
	}

	@Override
	public int update(SmsCode pojo) throws SQLException {
		return daoImplOrmlite.update(pojo);
	}

	@Override
	public int updateRaw(String sql) throws SQLException {
		return daoImplOrmlite.updateRaw(sql);
	}

}
