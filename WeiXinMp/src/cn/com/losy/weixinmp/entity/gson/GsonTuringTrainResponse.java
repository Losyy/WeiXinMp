package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

public class GsonTuringTrainResponse extends GsonTuringBaseResponse {
	public LinkedList<MyList> list;
	
	public static class MyList {
		public String trainnum;
		public String start;
		public String terminal;
		public String starttime;
		public String endtime;
		public String detailurl;
		public String icon;
	}
}
