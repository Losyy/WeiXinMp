package cn.com.losy.weixinmp.baiduapi;

import java.util.HashMap;

import cn.com.losy.weixinmp.entity.gson.GsonFacePPDetectResponse;
import cn.com.losy.weixinmp.util.HttpUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 人脸识别处理类
 * 
 * @author ximin
 *
 * Face++人脸识别官网 http://www.faceplusplus.com.cn/
 */
public class FacePP {
	public static final String FACEPP_KEY = "85dcb34aac3a112ecae0072f3fa57cf6";
	public static final String FACEPP_SCRECT = "_veET2hPv9MtAK-Ho2o2AcG6FMXlUszE";
	public static final String FACEPP_URL_DETECT = "http://apicn.faceplusplus.com/v2/detection/detect";
	
	public static String detect(String picUrl) {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("api_key", FACEPP_KEY);
			params.put("api_secret", FACEPP_SCRECT);
			params.put("url", picUrl);
			params.put("attribute", "gender,age,race,smiling,glass,pose");
			
			System.out.println("picUrl:" + picUrl);
			
			String jsonResult = HttpUtil.httpGet(FACEPP_URL_DETECT, params, null);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			GsonFacePPDetectResponse response = gson.fromJson(jsonResult, GsonFacePPDetectResponse.class);
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "检测不到人脸，请确认发送的确实是个人！ \ue409";
	}
	
	public static void main(String[] args) {
		System.out.println(detect("http://pic3.newssc.org/upload_local/0/2/2009/9/1252313395628.jpg"));
	}
}
