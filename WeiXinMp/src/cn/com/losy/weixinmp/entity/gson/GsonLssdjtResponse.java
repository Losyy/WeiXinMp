package cn.com.losy.weixinmp.entity.gson;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 
 * 历史上的今天返回结果
 * 
 * @author ximin
 *
 */
public class GsonLssdjtResponse {
	public String error;
	public String msg;
	public LinkedList<Data> data;
	
	public String toString() {
		Collections.sort(data, comparator);
		
		StringBuffer buffer = new StringBuffer();
		for (Data d : data) {
			buffer.append(d.year).append("年").append(d.month).append("月").append(d.day).append("日 ");
			buffer.append(d.name).append("\n");
//			buffer.append(d.content).append("\n"); // 详情太长，不要了
		}
		return buffer.toString();
	}
	
	public Comparator<Data> comparator = new Comparator<GsonLssdjtResponse.Data>() {
		
		@Override
		public int compare(Data o1, Data o2) {
			return Integer.valueOf(o2.year) - Integer.valueOf(o1.year);
		}
	};
	
	public static class Data {
		public String id;
		public String name;
		public String year;
		public String month;
		public String day;
		public String content;
	}
}
