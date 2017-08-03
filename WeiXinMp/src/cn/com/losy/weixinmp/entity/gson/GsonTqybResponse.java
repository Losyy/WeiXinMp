package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * 天气预报返回结果
 * 
 * @author ximin
 * public String ;
 */
public class GsonTqybResponse {
	@SerializedName("HeWeather data service 3.0")
	public LinkedList<HeWeather> heWeatherList;
	
	public static class HeWeather {
		public String status;
		public Aqi aqi;
		public Basic basic;
		public LinkedList<DailyForecast> daily_forecast;
		public LinkedList<HourlyForecast> hourly_forecast;
		public Now now;
		public Suggestion suggestion;
		
		public static class Suggestion {
			public Entity comf;
			public Entity cw;
			public Entity drsg;
			public Entity flu;
			public Entity sport;
			public Entity trav;
			public Entity uv;
			
			public static class Entity {
				public String brf;
				public String txt;
			}
		}
		
		public static class Now {
			public String fl;
			public String hum;
			public String pcpn;
			public String pres;
			public String tmp;
			public String vis;
			public Cond cond;
			public Wind wind;
			
			public String toString() {
				StringBuffer buffer = new StringBuffer();
				buffer.append("fl:" + fl).append("\n");
				buffer.append("hum:" + hum).append("\n");
				buffer.append("pcpn:" + pcpn).append("\n");
				buffer.append("pres:" + pres).append("\n");
				buffer.append("tmp:" + tmp).append("\n");
				buffer.append("vis:" + vis).append("\n");
				return buffer.toString();
			}
			
			public static class Wind {
				public String deg;
				public String dir;
				public String sc;
				public String spd;
			}
			
			public static class Cond {
				public String code;
				public String txt;
			}
		}
		
		public static class HourlyForecast {
			public String date;
			public String hum;
			public String pop;
			public String pres;
			public String tmp;
			public Wind wind;
			
			public static class Wind {
				public String deg;
				public String dir;
				public String sc;
				public String spd;
			}
		}
		
		public static class DailyForecast {
			public String date;
			public String hum;
			public String pcpn;
			public String pop;
			public String pres;
			public String vis;
			public Astro astro;
			public Cond cond;
			public Tmp tmp;
			public Wind wind;
			
			public String toString() {
				StringBuffer buffer = new StringBuffer();
				buffer.append(cond.txt_d + " 转  " + cond.txt_n).append("\n");
				buffer.append("温度" + tmp.min + "℃  ~ " + tmp.max + "℃").append("\n");
				buffer.append("风向:" + wind.dir + "  风力:" + wind.sc);
				return buffer.toString();
			}
			
			public static class Wind {
				public String deg;
				public String dir;
				public String sc;
				public String spd;
			}
			
			public static class Tmp {
				public String max;
				public String min;
			}
			
			public static class Cond {
				public String code_d;
				public String code_n;
				public String txt_d;
				public String txt_n;
			}
			
			public static class Astro {
				public String sr;
				public String ss;
			}
		}
		
		public static class Basic {
			public String city;
			public String cnty;
			public String id;
			public String lat;
			public String lon;
			public Update update;
			
			public static class Update {
				public String loc;
				public String utc;
			}
		}
		
		public static class Aqi {
			public City city;
			
			public static class City {
				public String aqi;
				public String co;
				public String no2;
				public String o3;
				public String pm10;
				public String pm25;
				public String qlty;
				public String so2;
			}
		}

	}
}
