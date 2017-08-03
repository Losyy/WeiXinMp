package cn.com.losy.didi.servlet;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import cn.com.losy.didi.dao.PassengerDao;
import cn.com.losy.didi.daoimpl.PassengerDaoImpl;
import cn.com.losy.didi.pojo.Passenger;

public class PassengerUtil {
	public static void main(String[] args) {
//		hanlde();
	}

	public static String hanlde(String code, String param) {
		try {
			PassengerDao passengerDao = new PassengerDaoImpl();
			
			if (code.equals("add10")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				for (int i = 0; i < 10; i ++) {
					Passenger passenger = new Passenger("uuid_" + i, "phone", Timestamp.valueOf(nowTime));
					passengerDao.insert(passenger);
				}
				return "PassengerUtil add10 Success";
			} else if (code.equals("queryId")) {
				return passengerDao.queryById(param).toString();
			} else if (code.equals("queryAll")) {
				StringBuffer sb = new StringBuffer();
				for (Passenger passenger : passengerDao.queryAll()) {
					sb.append(passenger.toString()).append("\n");
				}
				return sb.toString();
			} else if (code.equals("deleteId")) {
				return "delete " + passengerDao.deleteById(param);
			} 
			else if (code.equals("update")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				return "update  " + passengerDao.updateRaw("update dd_passenger set codeTime ='" + Timestamp.valueOf(nowTime) + "'" + " where uuid='" + param + "'");
			} else if (code.equals("updateTwo")) {
				String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
				Passenger passenger = passengerDao.queryById(param);
				passenger.setCreateTime(Timestamp.valueOf(nowTime));
				return "updateTwo  " + passengerDao.update(passenger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "PassengerUtil Fail";
	}
}
