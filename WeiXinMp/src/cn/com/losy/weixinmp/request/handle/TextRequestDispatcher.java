package cn.com.losy.weixinmp.request.handle;

import javax.xml.soap.Text;

import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.util.EmojiUtil;

/**
 * 文本消息请求的分发类
 * 
 * @author ximin
 *
 */
public class TextRequestDispatcher {
	public static String dispatch(BaseMessage baseMessage, String requestMessage) {
		TextRequest textRequest = preHandle(requestMessage);
		TextRequestHandler textRequestHandler = new TextRequestHandler(baseMessage, textRequest);
		return textRequestHandler.handle();
	}
	
	private static TextRequest preHandle(String requestMessage) {
		TextRequest textRequest = null;
		
		textRequest = preHandleWithQqFace(requestMessage);
		if (textRequest != null) {
			return textRequest;
		}
		
		textRequest = preHandleWithIntroduce(requestMessage);
		if (textRequest != null) {
			return textRequest;
		}
		
		textRequest = preHandleWithHandle(requestMessage);
		if (textRequest != null) {
			return textRequest;
		}
		
		return new TextRequest(requestMessage);
	}
	
	private static TextRequest preHandleWithQqFace(String requestMessage) {
		if (EmojiUtil.isQqFace(requestMessage)) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_ECHO, TextRequest.TYPE_TEXT_REQUEST_UNKOWN);
			textRequest.requestMessage = requestMessage;
			return textRequest;
		}
		return null;
	}
	
	private static TextRequest preHandleWithIntroduce(String requestMessage) {
		// 功能介绍- 二维码生成
		if (requestMessage.equals("9") || requestMessage.equals("二维码")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_EWM);
		}
		// 直接使用- 啦啦啦 (笑话大全-图文笑话)
		if (requestMessage.equals("8") || requestMessage.equals("啦啦啦图")) {
			return new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_LLL_PIC);
		} 
		// 直接使用- 啦啦啦 (笑话大全-文本笑话) 
		if (requestMessage.equals("7") || requestMessage.equals("啦啦啦") || requestMessage.equals("笑话")) {
			return new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_LLL_TXT);
		}
		// 功能介绍- 彩票开奖查询
		if (requestMessage.equals("6") || requestMessage.equals("彩票")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_CPCX);
		}
		// 直接使用- 历史上的今天
		if (requestMessage.equals("5") || requestMessage.equals("历史上的今天") || requestMessage.equals("今天")) {
			return new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_LSSDJT);
		}
		// 功能介绍- 翻译
		if (requestMessage.equals("4") || requestMessage.equals("翻译")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_FY);
		}
		// 功能介绍- 快递查询
		if (requestMessage.equals("3") || requestMessage.equals("快递") || requestMessage.equals("快递查询")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_KDCX);
		}
		// 功能介绍- 天气预报
		if (requestMessage.equals("2") || requestMessage.equals("天气") || requestMessage.equals("天气预报")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_TQYB);
		}
		// 功能介绍- 身份证查询
		if (requestMessage.equals("1") || requestMessage.equals("身份证") || requestMessage.equals("身份证查询")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_SFZCX);
		}
		// 功能介绍- 显示主菜单
		if (requestMessage.equals("?") || requestMessage.equals("？") || requestMessage.equals("help") || requestMessage.equals("帮助")) {
			return new TextRequest(TextRequest.MODE_INTRODUCE, TextRequest.TYPE_TEXT_REQUEST_MAIN_MENU);
		}
		return null;
	}
	
	private static TextRequest preHandleWithHandle(String requestMessage) {
		// 二维码
		if (requestMessage.startsWith("二维码")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_EWM);
			textRequest.requestMessage = requestMessage.replace("二维码", "").trim();
			return textRequest;
		}
		// 彩票查询
		if (requestMessage.startsWith("彩票")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_CPCX);
			textRequest.requestMessage = requestMessage.replace("彩票", "").trim();
			return textRequest;
		}
		// 翻译
		if (requestMessage.startsWith("翻译")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_FY);
			textRequest.requestMessage = requestMessage.replace("翻译", "").trim();
			return textRequest;
		}
		// 快递查询
		if (requestMessage.startsWith("快递")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_KDCX);
			textRequest.requestMessage = requestMessage.replace("快递", "").replace("查询", "").trim();
			return textRequest;
		}
		// 天气预报
		if (requestMessage.startsWith("天气")
				|| requestMessage.startsWith("天气预报")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_TQYB);
			textRequest.requestMessage = requestMessage.replace("天气", "").replace("预报", "").trim();
			return textRequest;
		}
		// 身份证查询
		if (requestMessage.startsWith("身份证")
			|| requestMessage.startsWith("身份证查询")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_SFZCX);
			textRequest.requestMessage = requestMessage.replace("身份证", "").replace("查询", "").trim();
			return textRequest;
		}
		// 美女图片
		if (requestMessage.contains("美女")
			|| requestMessage.contains("照片")
			|| requestMessage.toLowerCase().contains("picture")
			|| requestMessage.toLowerCase().contains("photo")) {
			TextRequest textRequest = new TextRequest(TextRequest.MODE_HANDLE, TextRequest.TYPE_TEXT_REQUEST_MEINV_PIC);
			return textRequest;
		}
		
		return null;
	}
}
