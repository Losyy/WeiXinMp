package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

public class GsonTuringNewsResponse extends GsonTuringBaseResponse {
	public LinkedList<MyList> list;
	
	public static class MyList {
		public String article;
		public String source;
		public String detailurl;
		public String icon;
	}
}
