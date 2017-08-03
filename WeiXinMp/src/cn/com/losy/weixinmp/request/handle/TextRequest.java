package cn.com.losy.weixinmp.request.handle;

public class TextRequest {
	/**
	 * 文字信息请求模式分类-未知
	 */
	public static final int MODE_UNKOWN = 0;
	/**
	 * 文字信息请求模式分类-功能介绍
	 */
	public static final int MODE_INTRODUCE = 1;
	/**
	 * 文字信息请求模式分类-功能实现
	 */
	public static final int MODE_HANDLE = 2;
	/**
	 * 文字信息请求模式分类-图灵机器人模式
	 */
	public static final int MODE_TURING = 3;
	/**
	 * 文字信息请求模式分类-回音壁模式
	 */
	public static final int MODE_ECHO = 4;
	
	/**
	 * 文字信息请求分类-未知请求
	 */
	public static final int TYPE_TEXT_REQUEST_UNKOWN = -1;
	/**
	 * 文字信息请求分类-显示主菜单
	 */
	public static final int TYPE_TEXT_REQUEST_MAIN_MENU = 0;
	/**
	 * 文字信息请求分类-身份证查询
	 */
	public static final int TYPE_TEXT_REQUEST_SFZCX = 1;
	/**
	 * 文字信息请求分类-天气预报
	 */
	public static final int TYPE_TEXT_REQUEST_TQYB = 2;
	/**
	 * 文字信息请求分类-快递查询
	 */
	public static final int TYPE_TEXT_REQUEST_KDCX = 3;
	/**
	 * 文字信息请求分类-翻译
	 */
	public static final int TYPE_TEXT_REQUEST_FY = 4;
	/**
	 * 文字信息请求分类-历史上的今天
	 */
	public static final int TYPE_TEXT_REQUEST_LSSDJT = 5;
	/**
	 * 文字信息请求分类-彩票查询
	 */
	public static final int TYPE_TEXT_REQUEST_CPCX = 6;
	/**
	 * 文字信息请求分类-啦啦啦（文本笑话）
	 */
	public static final int TYPE_TEXT_REQUEST_LLL_TXT = 7;
	/**
	 * 文字信息请求分类-啦啦啦（图文笑话）
	 */
	public static final int TYPE_TEXT_REQUEST_LLL_PIC = 8;
	/**
	 * 文字信息请求分类-二维码
	 */
	public static final int TYPE_TEXT_REQUEST_EWM = 9;
	/**
	 * 文字信息请求分类-美女图片
	 */
	public static final int TYPE_TEXT_REQUEST_MEINV_PIC = 10;
	
	/**
	 * 当前模式
	 * 
	 * 其中，历史上的今天、啦啦啦（文本笑话）、啦啦啦（图文笑话）
	 * 这几个功能没有对应的功能介绍，对应的命令直接转到功能实现
	 */
	public int mode = MODE_UNKOWN;
	/**
	 * 当前请求类型
	 */
	public int type = TYPE_TEXT_REQUEST_UNKOWN;
	/**
	 * 请求参数,去掉请求前缀的参数
	 * 
	 * 其中，历史上的今天、啦啦啦（文本笑话）、啦啦啦（图文笑话）
	 * 这几个功能不需要参数
	 */
	public String requestMessage = null;
	
	public TextRequest(int mode, int type) {
		this.mode = mode;
		this.type = type;
	}
	
	public TextRequest() {
		this.mode = MODE_UNKOWN;
		this.type = MODE_UNKOWN;
	}
	
	public TextRequest(String requestMessage) {
		this.mode = MODE_TURING;
		this.requestMessage = requestMessage;
	}
}























