package cn.com.losy.didi.daoimpl.ormlite;

import java.sql.SQLException;
import cn.com.losy.didi.pojo.SmsCode;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class SmsCodeDaoImplOrmLite extends BaseDaoImpl<SmsCode, String> {

	public SmsCodeDaoImplOrmLite(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, SmsCode.class);
	}

}
