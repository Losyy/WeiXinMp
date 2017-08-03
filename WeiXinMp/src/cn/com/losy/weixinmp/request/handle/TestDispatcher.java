package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.message.response.TextMessage;
import cn.com.losy.weixinmp.util.MessageUtil;

public class TestDispatcher {
	/**
	 * 原样返回字符串
	 * 
	 * @param msg
	 * @param requestMessage
	 * @return
	 */
	public static String doNothing(BaseMessage msg, String requestMessage) {
		String responeStr = requestMessage;
		TextMessage textMessage = new TextMessage();
		textMessage.setBaseInfo(msg);
		textMessage.setContent(responeStr);
		return MessageUtil.textMessageToXml(textMessage);
	}
}
