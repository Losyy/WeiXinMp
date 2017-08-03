package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

/**
 * 快递查询返回结果
 * 
 * @author ximin
 *
 */
public class GsonKdcxResponse {
	public int result;
	public int type;
	public String error;
	public String url;
	public LinkedList<Data> data;
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (data.get(0).wayBills == null || data.get(0).wayBills.size() == 0) {
			buffer.append("还没有该单号信息，请确认单号正确，或稍候重新查询。");
		} else {
			for (Data.WayBills bill : data.get(0).wayBills) {
				buffer.append(bill.time.substring(0, 19)).append(" ").append(bill.processInfo).append("\n");
			}
		}
		return buffer.toString();
	}
	
	public static class Data {
		public String billcode;
		public String errMsg;
		public String expressCode;
		public String expressName;
		public long lastQueryTime;
		public long lastStatusTime;
		public int queryFrom;
		public String resultString;
		public int status;
		public boolean success;
		public LinkedList<WayBills> wayBills;
		
		public static class WayBills {
			public long datetime;
			public String processInfo;
			public String remark;
			public String time;
		}
	}
}
