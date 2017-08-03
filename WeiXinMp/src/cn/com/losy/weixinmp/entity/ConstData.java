package cn.com.losy.weixinmp.entity;

import java.util.HashMap;

public class ConstData {
	public static String TOKEN = "WeiXinMp";
	public static String BAIDU_API_KEY = "e06eea99c5a825351337b84f4ff8bff9";
	/**
	 * 身份证查询URL
	 */
	public static String BAIDU_API_URL_SFZCX = "http://apis.baidu.com/apistore/idservice/id";
	
	/**
	 * 天气预报查询URL
	 */
	public static String BAIDU_API_URL_TQYB = "http://apis.baidu.com/heweather/weather/free";
	
	/**
	 * 快递查询URL
	 */
	public static String BAIDU_API_URL_KDCX = "http://apis.baidu.com/ppsuda/waybillnoquery/waybillnotrace";
	
	/**
	 * 翻译URL
	 */
	public static String BAIDU_API_URL_FY = "http://apis.baidu.com/apistore/tranlateservice/translate";
	
	/**
	 * 历史上的今天URL
	 */
	public static String BAIDU_API_URL_LSSDJT = "http://apis.baidu.com/netpopo/todayhistory/todayhistory";
	
	/**
	 * 历史上的今天 44664.com Appkey
	 */
	public static String BAIDU_API_URL_LSSDJT_44664_APPKEY = "c0efd2e7e46cf1bfdd3552c9672f5c28";
	
	/**
	 * 历史上的今天URL
	 */
	public static String BAIDU_API_URL_CPCX = "http://apis.baidu.com/apistore/lottery/lotteryquery";
	
	/**
	 * 啦啦啦 (笑话大全-文本笑话)URL
	 */
	public static String BAIDU_API_URL_LLL_TXT = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
	
	/**
	 * 啦啦啦 (笑话大全-图文笑话)URL
	 */
	public static String BAIDU_API_URL_LLL_PIC = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";
	
	/**
	 * 二维码生成URL
	 */
	public static String BAIDU_API_URL_EWM = "http://apis.baidu.com/3023/qr/qrcode";
	
	/**
	 * 图灵机器人URL
	 */
	public static String BAIDU_API_URL_TURING = "http://www.tuling123.com/openapi/api";
	
	/**
	 * 图灵机器人URL turing123.com appkey
	 */
	public static String BAIDU_API_URL_TURING_TURING123_APPKEY = "54840aea23327cd7b8b8f915535f1330";
	
	/**
	 * 美女图片URL
	 */
	public static String BAIDU_API_URL_MEINV_PIC = "http://apis.baidu.com/txapi/mvtp/meinv";
	
	/**
	 * 彩票代码
	 */
	public static HashMap<String, String> lotteryCode = new HashMap<String, String>();
	static {
		lotteryCode.put("超级大乐透", "dlt");
		lotteryCode.put("双色球", "ssq");
		lotteryCode.put("福彩3d", "fc3d");
		lotteryCode.put("排列3", "pl3");
		lotteryCode.put("排列5", "pl5");
		lotteryCode.put("七星彩", "qxc");
		lotteryCode.put("七乐彩", "qlc");
		lotteryCode.put("六场半全场", "zcbqc");
		lotteryCode.put("四场进球彩", "zcjqc");
		lotteryCode.put("十四场胜负彩(任9)", "zcsfc");
		
		lotteryCode.put("大乐透", "dlt");
		lotteryCode.put("六场", "zcbqc");
		lotteryCode.put("四场", "zcjqc");
		lotteryCode.put("十四场", "zcsfc");
	}
	
	/**
	 * 快递公司代码
	 */
	public static HashMap<String, String> expressCode = new HashMap<String, String>();
	static {
		expressCode.put("圆通", "YT");
		expressCode.put("申通", "ST");
		expressCode.put("中通", "ZT");
		expressCode.put("邮政EMS", "YZEMS");
		expressCode.put("邮政", "YZEMS");
		expressCode.put("EMS", "YZEMS");
		expressCode.put("天天", "TT");
		expressCode.put("优速", "YS");
		expressCode.put("快捷", "KJ");
		expressCode.put("全峰", "QF");
		expressCode.put("增益", "ZY");
	}
}
