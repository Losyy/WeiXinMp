package cn.com.losy.didi.pojo;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author huangximin
 * 
 * 短信验证码
 *
 */
@DatabaseTable(tableName = "dd_sms_code")
public class SmsCode {
	@DatabaseField(id = true)
	private String uuid;
	@DatabaseField(canBeNull = false)
	private String code;
	@DatabaseField(canBeNull = false)
	private Timestamp createTime;
	
	@Override
	public String toString() {
		return "SmsCode [uuid=" + uuid + ", code=" + code + ", createTime="
				+ createTime + "]";
	}
	public SmsCode() {
		super();
	}
	public SmsCode(String uuid, String code, Timestamp createTime) {
		super();
		this.uuid = uuid;
		this.code = code;
		this.createTime = createTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
