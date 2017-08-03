package cn.com.losy.weixinmp.message.response;

import cn.com.losy.weixinmp.util.MessageUtil;

public class TextMessage extends BaseMessage {  
    // 回复的消息内容  
    private String Content;  
    
    public TextMessage() {
    	setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    }
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}  