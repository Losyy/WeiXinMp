package cn.com.losy.weixinmp.baiduapi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpUtils;

import cn.com.losy.weixinmp.entity.ConstData;
import cn.com.losy.weixinmp.entity.gson.GsonCpcxResponse;
import cn.com.losy.weixinmp.entity.gson.GsonEwmResponse;
import cn.com.losy.weixinmp.entity.gson.GsonFyResponse;
import cn.com.losy.weixinmp.entity.gson.GsonKdcxResponse;
import cn.com.losy.weixinmp.entity.gson.GsonLllPicResponse;
import cn.com.losy.weixinmp.entity.gson.GsonLllTxtResponse;
import cn.com.losy.weixinmp.entity.gson.GsonLssdjtResponse;
import cn.com.losy.weixinmp.entity.gson.GsonMeiNvPicResponse;
import cn.com.losy.weixinmp.entity.gson.GsonSfzcxResponse;
import cn.com.losy.weixinmp.entity.gson.GsonTqybResponse;
import cn.com.losy.weixinmp.entity.gson.GsonTuringBaseResponse;
import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.message.response.TextMessage;
import cn.com.losy.weixinmp.util.HttpUtil;
import cn.com.losy.weixinmp.util.MessageUtil;
import cn.com.losy.weixinmp.util.RandomUitl;
import cn.com.losy.weixinmp.util.TimeUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaiduApi {
	
	// test
	public static void main(String[] args) {
		System.out.println(turing("哈哈"));
//		TextMessage textMessage = new TextMessage();
//		textMessage.setFromUserName("hhhxm");
//		textMessage.setToUserName("bb");
//		textMessage.setFuncFlag(0);
//		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//		textMessage.setContent("content");
//		textMessage.setCreateTime(1212121212);
//		System.out.println(MessageUtil.textMessageToXml(textMessage));
	}
	
	/**
	 * 美女图片
	 * @param content
	 * @return
	 */
	public static GsonMeiNvPicResponse meinvPic(int num) {
		return meinvPic(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_MEINV_PIC, num);
	}
	public static GsonMeiNvPicResponse meinvPic(String apiKey, String url, int num) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("num", num + "");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonMeiNvPicResponse response = gson.fromJson(jsonResult, GsonMeiNvPicResponse.class);
		
		return response;
	}
	
	/**
	 * 图灵机器人
	 * @param content
	 * @return
	 */
	public static String turing(String info) {
		return turing(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_TURING_TURING123_APPKEY, ConstData.BAIDU_API_URL_TURING, info);
	}
	public static String turing(String apiKey, String appkey, String url, String info) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("key", appkey);
		params.put("info", info);
		params.put("userid", "0");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonTuringBaseResponse response = gson.fromJson(jsonResult, GsonTuringBaseResponse.class);
		
		return response.text;
	}
	
	/**
	 * 二维码生成
	 * @param content
	 * @return
	 */
	public static GsonEwmResponse ewm(String content) {
		return ewm(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_EWM, content, 10);
	}
	public static GsonEwmResponse ewm(String apiKey, String url, String content, int size) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("qr", content);
		params.put("size", size + "");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonEwmResponse response = gson.fromJson(jsonResult, GsonEwmResponse.class);
		response.title = content;
		
		return response;
	}
	
	/**
	 *  啦啦啦 (笑话大全-图文笑话)
	 * @param requestMessage
	 * @return
	 */
	public static GsonLllPicResponse lllPic() {
		int page = RandomUitl.getInt(500);
		return lllPic(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_LLL_PIC, page);
	}
	private static GsonLllPicResponse lllPic(String apiKey, String url, int page) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("page", page + "");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
//		if (jsonResult == null && !jsonResult.contains("\"error\": \"0\"") && !jsonResult.contains("\"error\":\"0\"")) {
//			return "当前服务不可用。";
//		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonLllPicResponse response = gson.fromJson(jsonResult, GsonLllPicResponse.class);
		
		return response;
	}
	
	/**
	 *  啦啦啦 (笑话大全-文本笑话)
	 * @param requestMessage
	 * @return
	 */
	public static String lllTxt() {
		int page = RandomUitl.getInt(300);
		int index = RandomUitl.getInt(20);
		return lllTxt(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_LLL_TXT, page, index);
	}
	private static String lllTxt(String apiKey, String url, int page, int index) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("page", page + "");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
//		if (jsonResult == null && !jsonResult.contains("\"error\": \"0\"") && !jsonResult.contains("\"error\":\"0\"")) {
//			return "当前服务不可用。";
//		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonLllTxtResponse response = gson.fromJson(jsonResult, GsonLllTxtResponse.class);
		
		List list = response.showapi_res_body.contentlist;
		if (list == null || list.size() == 0) {
			return "当前服务不可用。";
		}
		if (list.size() < index) {
			return response.showapi_res_body.contentlist.get(list.size() - 1).text;
		}
		return response.showapi_res_body.contentlist.get(index).toString();
	}
	
	/**
	 *  彩票查询
	 * @param requestMessage
	 * @return
	 */
	public static String cpcx(String requestMessage) {
		String lotteryCode = ConstData.lotteryCode.get(requestMessage);
		if (lotteryCode == null) {
			return "输入彩票种类有误 或当前服务不可用。";
		}
		return cpcx(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_CPCX, lotteryCode, "10");
	}
	private static String cpcx(String apiKey, String url, String lotterycode, String recordcnt) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("lotterycode", lotterycode);
		params.put("recordcnt", recordcnt);
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null && !jsonResult.contains("\"error\": \"0\"") && !jsonResult.contains("\"error\":\"0\"")) {
			return "当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonCpcxResponse response = gson.fromJson(jsonResult, GsonCpcxResponse.class);
		
		return response.toString();
	}
	
	/**
	 *  历史上的今天
	 * @return
	 */
	public static String lssdjt() {
		return lssdjt(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_LSSDJT, ConstData.BAIDU_API_URL_LSSDJT_44664_APPKEY);
	}
	private static String lssdjt(String apiKey, String url, String appkey) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("month", TimeUtil.getMonth() + "");
		params.put("day", TimeUtil.getDay() + "");
		params.put("appkey", appkey);
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null && !jsonResult.contains("\"error\": \"0\"") && !jsonResult.contains("\"error\":\"0\"")) {
			return "当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonLssdjtResponse response = gson.fromJson(jsonResult, GsonLssdjtResponse.class);
		
		return response.toString();
	}
	
	/**
	 *  翻译
	 * @param requestMessage
	 * @return
	 */
	public static String fy(String requestMessage) {
		return fy(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_FY, requestMessage);
	}
	private static String fy(String apiKey, String url, String query) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("query", query);
		params.put("from", "auto");
		params.put("to", "auto");
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null || jsonResult.contains("\"result\":0") || jsonResult.contains("\"result\"：0")) {
			return query + " 翻译结果:\n" + "当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonFyResponse response = gson.fromJson(jsonResult, GsonFyResponse.class);
		
		return query + " 翻译结果:\n" + response.toString();
	}
	
	/**
	 *  快递查询
	 * @param requestMessage
	 * @return
	 */
	public static String kdcx(String requestMessage) {
		if (!requestMessage.contains(" ")) {
			return "输入单号或格式有误 或 当前服务不可用。";
		}
		String expresscode = ConstData.expressCode.get(requestMessage.substring(0, requestMessage.indexOf(" ")));
		String billno = requestMessage.substring(requestMessage.indexOf(" "), requestMessage.length()).trim();
		return kdcx(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_KDCX, billno, expresscode);
	}
	private static String kdcx(String apiKey, String url, String billno, String expresscode) {
		if (billno == null || expresscode == null) {
			return "输入单号或格式有误 或 当前服务不可用。";
		}
		
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("billno", billno);
		params.put("expresscode", expresscode);
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null || jsonResult.contains("result:0") || jsonResult.contains("result：0")) {
			return "输入单号或格式有误 或 当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonKdcxResponse response = gson.fromJson(jsonResult, GsonKdcxResponse.class);
		
		return response.toString();
	}
	
	/**
	 *  天气预报
	 * @param city
	 * @return
	 */
	public static String tqyb(String city) {
		return tqyb(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_TQYB, city);
	}
	private static String tqyb(String apiKey, String url, String city) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("city", city);
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null || jsonResult.contains("unknown city")) {
			return city + " 天气:\n" + "输入城市有误 或 当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonTqybResponse response = gson.fromJson(jsonResult, GsonTqybResponse.class);
		
		return city + " 天气:\n" + response.heWeatherList.get(0).daily_forecast.get(0).toString();
	}
	
	/**
	 *  身份证查询
	 * @param id
	 * @return
	 */
	public static String sfzcx(String id) {
		return sfzcx(ConstData.BAIDU_API_KEY, ConstData.BAIDU_API_URL_SFZCX, id);
	}
	private static String sfzcx(String apiKey, String url, String id) {
		String httpUrl = url;
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id",  id);
		
		HashMap<String, String> headerParams = new HashMap<String, String>();
		headerParams.put("apikey",  apiKey);
		
		String jsonResult = HttpUtil.httpGet(httpUrl, params, headerParams);
		
		if (jsonResult == null || !jsonResult.contains("{\"errNum\":0")) {
			return "身份证有误 或 当前服务不可用。";
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		GsonSfzcxResponse response = gson.fromJson(jsonResult, GsonSfzcxResponse.class);
		
		return response.retData.toString();
	}
	
}
