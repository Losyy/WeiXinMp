package cn.com.losy.didi.servlet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import cn.com.losy.didi.dao.DriverDao;
import cn.com.losy.didi.daoimpl.DriverDaoImpl;
import cn.com.losy.didi.pojo.Driver;

public class DriverUtil {
	public static String hanlde(String code, String param) {
		try {
			DriverDao driverDao = new DriverDaoImpl();
			
			if (code.equals("add10")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				for (int i = 0; i < 10; i ++) {
					Driver driver = new Driver("uuid" + i, "phone" + i, "license" + i, "carNumber" + i,
							"name" + i, "male", new Date(System.currentTimeMillis()), "address" + i, "company" + i, Timestamp.valueOf(nowTime));
					driverDao.insert(driver);
				}
				return "DriverUtil add10 Success";
			} else if (code.equals("queryId")) {
				return driverDao.queryById(param).toString();
			} else if (code.equals("queryAll")) {
				StringBuffer sb = new StringBuffer();
				for (Driver driver : driverDao.queryAll()) {
					sb.append(driver.toString()).append("\n");
				}
				return sb.toString();
			} else if (code.equals("deleteId")) {
				return "delete " + driverDao.deleteById(param);
			} 
			else if (code.equals("update")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				return "update  " + driverDao.updateRaw("update dd_driver set createTime ='" + Timestamp.valueOf(nowTime) + "'" + " where uuid='" + param + "'");
			} else if (code.equals("updateTwo")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				Driver driver = driverDao.queryById(param);
				driver.setCreateTime(Timestamp.valueOf(nowTime));
				return "updateTwo  " + driverDao.update(driver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "DriverUtil Fail";
	}
}
