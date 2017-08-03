package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.baiduapi.BaiduApi;
import cn.com.losy.weixinmp.entity.gson.GsonEwmResponse;
import cn.com.losy.weixinmp.entity.gson.GsonLllPicResponse;
import cn.com.losy.weixinmp.entity.gson.GsonMeiNvPicResponse;

/**
 * 功能实现类
 * 
 * @author ximin
 *
 */
public class FunctionImpl {
	/**
	 * 图灵机器人
	 * 接收到不认识的指令时，交给图灵机器人与用户交互
	 * @param requestMessage
	 * @return
	 */
	public static String turing(String requestMessage) {
		return BaiduApi.turing(requestMessage);
	}
	
	/**
	 * 二维码生成
	 * 
	 * @return
	 */
	public static GsonEwmResponse ewm(String requestMessage) {
	    return BaiduApi.ewm(requestMessage);
	}
	
	/**
	 * 美女图片
	 * 
	 * @return
	 */
	public static GsonMeiNvPicResponse meinvPic(int num) {
	    return BaiduApi.meinvPic(num);
	}
	
	/**
	 * 啦啦啦 (笑话大全-图文笑话)
	 * 
	 * @return
	 */
	public static GsonLllPicResponse lllPic() {
	    return BaiduApi.lllPic();
	}
	
	/**
	 * 啦啦啦 (笑话大全-文本笑话)
	 * 
	 * @return
	 */
	public static String lllTxt() {
	    return BaiduApi.lllTxt();
	}
	
	/**
	 * 彩票查询
	 * 
	 * @return
	 */
	public static String cpcx(String requestMessage) {
	    return BaiduApi.cpcx(requestMessage);
	}
	
	/**
	 * 历史上的今天
	 * 
	 * @return
	 */
	public static String lssdjt() {
	    return BaiduApi.lssdjt();
	}
	
	/**
	 * 翻译
	 * 
	 * @return
	 */
	public static String fy(String requestMessage) {
	    return BaiduApi.fy(requestMessage);
	}
	
	/**
	 * 快递查询
	 * 
	 * @return
	 */
	public static String kdcx(String requestMessage) {
	    return BaiduApi.kdcx(requestMessage);
	}
	
	/**
	 * 天气预报
	 * 
	 * @return
	 */
	public static String tqyb(String requestMessage) {
	    return BaiduApi.tqyb(requestMessage);
	}
	
	/**
	 * 身份证查询
	 * 
	 * @return
	 */
	public static String sfzcx(String requestMessage) {
	    return BaiduApi.sfzcx(requestMessage);
	}
}
