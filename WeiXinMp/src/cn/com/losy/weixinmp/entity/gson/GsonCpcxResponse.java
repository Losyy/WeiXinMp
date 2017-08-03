package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

/**
 * 
 * 彩票查询返回结果
 * 
 * @author ximin
 *
 */
public class GsonCpcxResponse {
	public int errNum;
	public String retMsg;
	public RetData retData;
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (RetData.Data data : retData.data) {
			buffer.append(data.expect).append("期").append("(").append(data.openTime.substring(0, 10)).append(")").append(" 开奖 ").append(data.openCode).append("\n");
		}
		return buffer.toString();
	}
	
	public static class RetData {
		public String recordCnt;
		public String lotteryCode;
		public LinkedList<Data> data;
		
		public static class Data {
			public String expect;
			public String openCode;
			public String openTime;
			public String openTimeStamp;
		}
	}
}
