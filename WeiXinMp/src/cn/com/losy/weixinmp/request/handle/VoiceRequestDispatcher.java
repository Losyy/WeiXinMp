package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.message.response.BaseMessage;

/**
 * 音频消息请求的分发类
 * 
 * @author ximin
 *
 */
public class VoiceRequestDispatcher {
	public static String dispatch(BaseMessage msg, String recognition) {
		// TODO: 待改进，当前为直接调用文本消息处理方法
		System.out.println("VoiceMessageHandler dispatch requestMessage:" + recognition);
		return TextRequestDispatcher.dispatch(msg, recognition.replace("!", "").replace("！", ""));
	}
}
