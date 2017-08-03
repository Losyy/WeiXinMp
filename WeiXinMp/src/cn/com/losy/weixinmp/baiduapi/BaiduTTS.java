package cn.com.losy.weixinmp.baiduapi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import cn.com.losy.weixinmp.util.FileUtil;
import cn.com.losy.weixinmp.util.HttpUtil;

/**
 * 百度语音服务处理类
 * 
 * @author ximin
 * 
 * 百度语音官网地址 http://yuyin.baidu.com/
 *
 */
public class BaiduTTS {
	public static final String TTS_URL = "http://tsn.baidu.com/text2audio";
	public static final String TTS_CREDENTIALS_URL = "https://openapi.baidu.com/oauth/2.0/token";
	public static final String TTS_GRANT_TYPE = "client_credentials";
	public static final String TTS_KEY = "KPGciafDLtdFT3CNzrv8YiCF";
	public static final String TTS_SCRECT = "57fd9463b89856854028103e28516cf7";
	
	public static String ttsTest(String url) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("tex", "今天天气好晴朗");
		params.put("lan", "zh");
		params.put("tok", "24.563c5706d2e9671bc1a1bc3ccb6fde9c.2592000.1447037684.282335-7001455");
		params.put("ctp", "1");
		params.put("cuid", "s123123123");
		
		String response = httpGet(url, params, null);
		return response;
	}
	
	public static String credentailsTest(String url, String type, String key, String screct) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("grant_type", type);
		params.put("client_id", key);
		params.put("client_secret", screct);
		
		String response = HttpUtil.httpGet(url, params, null);
		return response;
	}
	
	public static void main(String[] args) {
//		System.out.println(credentailsTest(TTS_CREDENTIALS_URL, TTS_GRANT_TYPE, TTS_KEY, TTS_SCRECT));
		System.out.println(ttsTest(TTS_URL));
	}
	
	public static String httpGet(String httpUrl, HashMap<String, String> params, HashMap<String, String> headerParams) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();

	    try {
	    	// 拼接url
	    	if (params != null && params.size() > 0) {
	    		StringBuffer httpParams = new StringBuffer();
	    		for (String key : params.keySet()) {
	    			httpParams.append("&").append(key).append("=")
	    				.append(URLEncoder.encode(URLEncoder.encode(params.get(key), "UTF-8"), "UTF-8"));
	    		}
	    		httpUrl = httpUrl + "?" + httpParams.toString().substring(1);
	    	}
	    	
	    	System.out.println("======HttpUtil httpGet begin======== httpUrl:" + httpUrl);
	    	
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        
	        // 设置http报文头参数
	        if (headerParams != null && headerParams.size() > 0) {
		        for (String key : headerParams.keySet()) {
		        	connection.setRequestProperty(key, headerParams.get(key));
		        }
	        }
	        
	        connection.connect();
	        
	        InputStream is = connection.getInputStream();
	        
	        FileUtil.save(is, "test.mp3");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("======HttpUtil httpGet end======== result:" + result);
	    return result;
	}
	
}
