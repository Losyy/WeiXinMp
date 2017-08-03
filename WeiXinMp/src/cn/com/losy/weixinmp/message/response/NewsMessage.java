package cn.com.losy.weixinmp.message.response;

import java.util.LinkedList;
import java.util.List;

import cn.com.losy.weixinmp.util.MessageUtil;

public class NewsMessage extends BaseMessage {  
    // 图文消息个数，限制为10条以内  
    private int ArticleCount;  
    // 多条图文消息信息，默认第一个item为大图  
    private List<Article> Articles;  
    
    public NewsMessage() {
    	setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
    	Articles = new LinkedList<Article>();
    }
  
    public int getArticleCount() {  
        return ArticleCount;  
    }  
  
    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  
  
    public List<Article> getArticles() {  
        return Articles;  
    }  
  
    public void setArticles(List<Article> articles) {  
        Articles = articles;  
    }  
}  