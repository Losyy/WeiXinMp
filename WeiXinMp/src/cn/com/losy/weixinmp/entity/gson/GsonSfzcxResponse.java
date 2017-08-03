package cn.com.losy.weixinmp.entity.gson;

/**
 * 身份证查询返回结果
 * 
 * @author ximin
 *
 */
public class GsonSfzcxResponse {
	public int errNum;
	public String retMsg;
	public SfzcxRetData retData;
	public int getErrNum() {
		return errNum;
	}
	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public SfzcxRetData getRetData() {
		return retData;
	}
	public void setRetData(SfzcxRetData retData) {
		this.retData = retData;
	}
	
	public static class SfzcxRetData {
		public String address;
		public String sex;
		public String birthday;
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("性别:" + convertSex(sex) + "\n");
			sb.append("生日:" + birthday + "\n");
			sb.append("地址:" + address);
			return sb.toString();
		}
		
		private String convertSex(String sex) {
			return sex.equals("M") ? "男" : (sex.equals("F") ? "女" : "未知");
		}
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
	}
	
}
