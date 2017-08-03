package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

/**
 * 翻译返回结果
 * 
 * @author ximin
 *
 */
public class GsonFyResponse {
	public int errNum;
	public String errMsg;
	public RetData retData;
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(retData.trans_result.get(0).dst);
		return buffer.toString();
	}
	
	public static class RetData {
		public String from;
		public String to;
		public LinkedList<TransResult> trans_result;
		
		public static class TransResult {
			public String src;
			public String dst;
		}
	}
}
