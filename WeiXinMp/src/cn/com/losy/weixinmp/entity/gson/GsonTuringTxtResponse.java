package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

public class GsonTuringTxtResponse extends GsonTuringBaseResponse {
	public LinkedList<MyList> list;
	
	public static class MyList {
		public String flight;
		public String route;
		public String starttime;
		public String endtime;
		public String state;
		public String detailurl;
		public String icon;
	}
}
