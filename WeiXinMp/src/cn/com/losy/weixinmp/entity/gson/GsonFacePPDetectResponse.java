package cn.com.losy.weixinmp.entity.gson;

import java.util.LinkedList;

/**
 * Face++人脸检测处理返回结果  
 * detect
 * 
 * @author ximin
 *
 */
public class GsonFacePPDetectResponse {
	public String url;
	public String session_id;
	public String img_id;
	public int img_height;
	public int img_width;
	public LinkedList<Face> face;
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("年龄:").append(face.get(0).attribute.age.value).append("\n");
		buffer.append("人种:").append(/*parseRace(*/face.get(0).attribute.race.value/*)*/).append("\n");
		buffer.append("性别:").append(face.get(0).attribute.gender.value.equals("Male") ? "男" : "女").append("\n");
		buffer.append("微笑程度:").append(face.get(0).attribute.smiling.value);
		return buffer.toString();
	}
	
//	public String parseSmiling(float value) {
//		
//	}
	
	public String parseRace(String race) {
		if (race.equals("White")) {
			return "白种人";
		}
		if (race.equals("Asia")) {
			return "黄种人";
		}
		return "黑种人";
	}
	
	public static class Face {
		public String face_id;
		public String tag;
		public Attribute attribute;
		public Position position;
		
		public static class Position {
			public float height;
			public float width;
			public Point center;
			public Point nose;
			public Point eye_left;
			public Point eye_right;
			public Point mouth_left;
			public Point mouth_right;
			
			public static class Point {
				public float x;
				public float y;
			}
		}
		
		public static class Attribute {
			public Age age;
			public ValueAndConfidence gender;
			public ValueAndConfidence glass;
			public Pose pose;
			public ValueAndConfidence race;
			public Pose.Value smiling;
			
			public static class Pose {
				public Value pitch_angle;
				public Value roll_angle;
				public Value yaw_angle;
				
				public static class Value {
					public float value;
				}
			}
			public static class ValueAndConfidence {
				public String value;
				public float confidence;
			}
			public static class Age {
				public int value;
				public int range;
			}
		}
	}
}
