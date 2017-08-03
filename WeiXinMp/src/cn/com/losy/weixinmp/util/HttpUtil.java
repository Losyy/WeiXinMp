package cn.com.losy.weixinmp.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

public class HttpUtil {
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @param headerParams
	 *            :头部参数
	 * @return 返回结果
	 */
	public static String httpGet(String httpUrl, HashMap<String, String> params, HashMap<String, String> headerParams) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();

	    try {
	    	// 拼接url
	    	if (params != null && params.size() > 0) {
	    		StringBuffer httpParams = new StringBuffer();
	    		for (String key : params.keySet()) {
	    			httpParams.append("&").append(key).append("=").append(URLEncoder.encode(params.get(key), "UTF-8"));
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
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.out.println("======HttpUtil httpGet end======== result:" + result);
	    return result;
	}
}
