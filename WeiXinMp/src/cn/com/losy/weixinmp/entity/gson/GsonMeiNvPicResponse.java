package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

public class GsonMeiNvPicResponse {
	public int code;
	public String msg;
	@SerializedName(value = "0")
	public Beauty beauty; 
	
	public String toString() {
		return beauty.title + " " + beauty.description + " " + beauty.picUrl + " " + beauty.url;
	}
	
	public static class Beauty {
		public String title;
		public String description;
		public String picUrl;
		public String url;
	}
}
