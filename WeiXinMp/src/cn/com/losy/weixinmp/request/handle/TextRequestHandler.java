package cn.com.losy.weixinmp.request.handle;

import cn.com.losy.weixinmp.entity.gson.GsonEwmResponse;
import cn.com.losy.weixinmp.entity.gson.GsonLllPicResponse;
import cn.com.losy.weixinmp.entity.gson.GsonMeiNvPicResponse;
import cn.com.losy.weixinmp.message.response.Article;
import cn.com.losy.weixinmp.message.response.BaseMessage;
import cn.com.losy.weixinmp.message.response.NewsMessage;
import cn.com.losy.weixinmp.message.response.TextMessage;
import cn.com.losy.weixinmp.util.MessageUtil;

/**
 * 文本消息请求的处理类
 * 
 * @author ximin
 *
 */
public class TextRequestHandler {
	public BaseMessage baseMessage;
	public TextRequest textRequest;
	
	public TextRequestHandler(BaseMessage baseMessage, TextRequest textRequest) {
		this.baseMessage = baseMessage;
		this.textRequest = textRequest;
	}
	
	public String handle() {
		if (textRequest.mode == TextRequest.MODE_ECHO) {
			return handleWithEcho();
		}
		
		if (textRequest.mode == TextRequest.MODE_INTRODUCE) {
			return handleWithIntroduce();
		}
		
		if (textRequest.mode == TextRequest.MODE_HANDLE) {
			return handleWithHandle();
		}
		
//		if (textRequest.mode == TextRequest.MODE_TURING) {
//			return handleWithTuring();
//		}
//		
//		if (textRequest.mode == TextRequest.MODE_UNKOWN) {
//			return handleWithEcho();
//		}
		
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(Introducer.getMainMenu());
		textMessage.setBaseInfo(baseMessage);
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	/**
	 * 返回功能介绍
	 * 
	 * @return
	 */
	private String handleWithIntroduce() {
		String response = null;
		switch (textRequest.type) {
		case TextRequest.TYPE_TEXT_REQUEST_EWM:
			response = Introducer.introduceEwm();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_CPCX:
			response = Introducer.introduceCpcx();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_FY:
			response = Introducer.introduceFy();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_KDCX:
			response = Introducer.introduceKdcx();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_TQYB:
			response = Introducer.introduceTqyb();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_SFZCX:
			response = Introducer.introduceSfzcx();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_MAIN_MENU:
			response = Introducer.getMainMenu();
			break;
		}
		
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(response);
		textMessage.setBaseInfo(baseMessage);
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	/**
	 * 实际功能实现
	 * 
	 * @return
	 */
	private String handleWithHandle() {
		String response = null;
		switch (textRequest.type) {
		case TextRequest.TYPE_TEXT_REQUEST_EWM:
			return ewm();
		case TextRequest.TYPE_TEXT_REQUEST_LLL_PIC:
			return lllPic();
		case TextRequest.TYPE_TEXT_REQUEST_MEINV_PIC:
			return meinvPic();
		case TextRequest.TYPE_TEXT_REQUEST_LLL_TXT:
			response = FunctionImpl.lllTxt();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_CPCX:
			response = FunctionImpl.cpcx(textRequest.requestMessage);
			break;
		case TextRequest.TYPE_TEXT_REQUEST_LSSDJT:
			response = FunctionImpl.lssdjt();
			break;
		case TextRequest.TYPE_TEXT_REQUEST_FY:
			response = FunctionImpl.fy(textRequest.requestMessage);
			break;
		case TextRequest.TYPE_TEXT_REQUEST_KDCX:
			response = FunctionImpl.kdcx(textRequest.requestMessage);
			break;
		case TextRequest.TYPE_TEXT_REQUEST_TQYB:
			response = FunctionImpl.tqyb(textRequest.requestMessage);
			break;
		case TextRequest.TYPE_TEXT_REQUEST_SFZCX:
			response = FunctionImpl.sfzcx(textRequest.requestMessage);
			break;
		}
		
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(response);
		textMessage.setBaseInfo(baseMessage);
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	/**
	 * 图灵机器人交互
	 * 
	 * @return
	 */
	private String handleWithTuring() {
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(FunctionImpl.turing(textRequest.requestMessage));
		textMessage.setBaseInfo(baseMessage);
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	/**
	 * 回音壁模式
	 * 
	 * 用户输入什么，就返回什么
	 * 
	 * @return
	 */
	private String handleWithEcho() {
		TextMessage textMessage = new TextMessage();
		textMessage.setContent(textRequest.requestMessage);
		textMessage.setBaseInfo(baseMessage);
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	private String ewm() {
		NewsMessage newsMessage = new NewsMessage();
		GsonEwmResponse response = FunctionImpl.ewm(textRequest.requestMessage);
			Article article = article(response.title + "[二维码],点击可查看全图", null, response.url, response.url);
			newsMessage.getArticles().add(article);
		newsMessage.setBaseInfo(baseMessage);
		newsMessage.setArticleCount(newsMessage.getArticles().size());
		return MessageUtil.newsMessageToXml(newsMessage);
	}
	
	private String lllPic() {
		NewsMessage newsMessage = new NewsMessage();
		GsonLllPicResponse response = FunctionImpl.lllPic();
		for (int i = 0; i < 5 && i < response.showapi_res_body.contentlist.size() - 1; i ++) {
			GsonLllPicResponse.ShowapiResBody.Content content = response.showapi_res_body.contentlist.get(i);
			Article article = article(content.title, content.title, content.img, content.img);
			newsMessage.getArticles().add(article);
		}
		newsMessage.setBaseInfo(baseMessage);
		newsMessage.setArticleCount(newsMessage.getArticles().size());
		return MessageUtil.newsMessageToXml(newsMessage);
	}
	
	private String meinvPic() {
		NewsMessage newsMessage = new NewsMessage();
		GsonMeiNvPicResponse response = FunctionImpl.meinvPic(2); // 2 表示只要一条数据。 该API问题
			Article article = article(response.beauty.title, response.beauty.description, response.beauty.picUrl, response.beauty.url);
			newsMessage.getArticles().add(article);
		newsMessage.setBaseInfo(baseMessage);
		newsMessage.setArticleCount(newsMessage.getArticles().size());
		return MessageUtil.newsMessageToXml(newsMessage);
	}
	
	private Article article(String title, String description, String picUrl, String url) {
		Article article = new Article();
		if (title != null) article.setTitle(title);
		if (description != null) article.setDescription(description);
		if (picUrl != null) article.setPicUrl(picUrl);
		if (url != null) article.setUrl(url);
		return article;
	}
}
