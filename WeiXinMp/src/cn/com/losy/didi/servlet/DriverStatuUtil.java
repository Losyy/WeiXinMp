package cn.com.losy.didi.servlet;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import cn.com.losy.didi.dao.DriverStatuDao;
import cn.com.losy.didi.daoimpl.DriverStatuDaoImpl;
import cn.com.losy.didi.pojo.DriverStatu;

public class DriverStatuUtil {
	public static String hanlde(String code, String param) {
		try {
			DriverStatuDao driverStatuDao = new DriverStatuDaoImpl();
			
			if (code.equals("add10")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());// Timestamp.valueOf(nowTime)
				for (int i = 0; i < 10; i ++) {
					DriverStatu driverStatu = new DriverStatu("uuid" + i, "driverId" + i, 0, 0, null, null, Timestamp.valueOf(nowTime));
					driverStatuDao.insert(driverStatu);
				}
				return "DriverStatuUtil DriverStatuUtil add10 Success";
			} else if (code.equals("queryId")) {
				return driverStatuDao.queryById(param).toString();
			} else if (code.equals("queryAll")) {
				StringBuffer sb = new StringBuffer();
				for (DriverStatu driverStatu : driverStatuDao.queryAll()) {
					sb.append(driverStatu.toString()).append("\n");
				}
				return sb.toString();
			} else if (code.equals("deleteId")) {
				return "DriverStatuUtil delete " + driverStatuDao.deleteById(param);
			} 
			else if (code.equals("update")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				return "DriverStatuUtil update  " + driverStatuDao.updateRaw("update dd_driver_statu set statuTime ='" + Timestamp.valueOf(nowTime) + "'" + " where uuid='" + param + "'");
			} else if (code.equals("updateTwo")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				DriverStatu driverStatu = driverStatuDao.queryById(param);
				driverStatu.setStatuTime(Timestamp.valueOf(nowTime));
				return "DriverStatuUtil updateTwo  " + driverStatuDao.update(driverStatu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "DriverStatuUtil Fail";
	}
}
