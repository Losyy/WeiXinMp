package cn.com.losy.weixinmp.service;

import static cn.com.losy.weixinmp.util.Printer.println;

import java.util.Date;  
import java.util.Map;  
import javax.servlet.http.HttpServletRequest;  
import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.request.handle.ImageRequestDispatcher;
import cn.com.losy.weixinmp.request.handle.Introducer;
import cn.com.losy.weixinmp.request.handle.TestDispatcher;
import cn.com.losy.weixinmp.request.handle.TextRequestDispatcher;
import cn.com.losy.weixinmp.request.handle.VoiceRequestDispatcher;
import cn.com.losy.weixinmp.util.MessageUtil;
  

public class CoreService {  
    /** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        String requestMessage = null;
        try {  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 基础消息  
            BaseMessage baseMessage = new BaseMessage();  
            baseMessage.setToUserName(fromUserName);  
            baseMessage.setFromUserName(toUserName);  
            baseMessage.setCreateTime(new Date().getTime());  
            baseMessage.setFuncFlag(0);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            	requestMessage = requestMap.get("Content");
            	respMessage = TextRequestDispatcher.dispatch(baseMessage, requestMessage);  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
            	String recognition = requestMap.get("Recognition"); // 语音识别结果
//                String mediaId = requestMap.get("MediaId");
            	respMessage = VoiceRequestDispatcher.dispatch(baseMessage, recognition);
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { 
            	String picUrl = requestMap.get("PicUrl");
                respMessage = ImageRequestDispatcher.dispatch(baseMessage, picUrl);
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respMessage = TestDispatcher.doNothing(baseMessage, "您发送的是地理位置消息！");
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respMessage = TestDispatcher.doNothing(baseMessage, "您发送的是链接消息！");
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respMessage = TestDispatcher.doNothing(baseMessage, Introducer.getMainMenu());
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // TODO 自定义菜单权没有开放，暂不处理该类消息  
                }  
            } 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
}  