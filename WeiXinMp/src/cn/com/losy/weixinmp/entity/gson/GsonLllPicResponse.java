package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

public class GsonLllPicResponse {
	public int showapi_res_code;
	public String showapi_res_error;
	public ShowapiResBody showapi_res_body;
	
	public static class ShowapiResBody {
		public int allNum;
		public int allPages;
		public int currentPage;
		public int maxResult;
		public LinkedList<Content> contentlist;
		
		public static class Content {
			public String ct;
			public String img;
			public String title;
			public int type;
		}
	}
}
