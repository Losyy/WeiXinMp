package cn.com.losy.weixinmp.message.response;

import cn.com.losy.weixinmp.util.MessageUtil;

public class MusicMessage extends BaseMessage {  
    // 音乐  
    private Music Music;  
    
    public MusicMessage() {
    	setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
    }
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }  
}  