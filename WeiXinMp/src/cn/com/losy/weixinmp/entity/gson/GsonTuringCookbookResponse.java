package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

public class GsonTuringCookbookResponse extends GsonTuringBaseResponse {
	public LinkedList<MyList> list;
	
	public static class MyList {
		public String name;
		public String info;
		public String detailurl;
		public String icon;
	}
}
