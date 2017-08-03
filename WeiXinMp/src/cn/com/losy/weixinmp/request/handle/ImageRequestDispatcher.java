package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.baiduapi.FacePP;
import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.message.response.TextMessage;
import cn.com.losy.weixinmp.util.MessageUtil;

/**
 * 图片消息请求的分发类
 * 
 * @author ximin
 *
 */
public class ImageRequestDispatcher {
	public static String dispatch(BaseMessage msg, String picUrl) {
		String response = FacePP.detect(picUrl);
		TextMessage textMessage = new TextMessage();
		textMessage.setBaseInfo(msg);
		textMessage.setContent(response);
		return MessageUtil.textMessageToXml(textMessage);
	}
}
