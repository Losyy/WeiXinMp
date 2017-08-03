package cn.com.losy.didi.pojo;
import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "dd_passenger")
public class Passenger {
	@DatabaseField(id = true)
	private String uuid;
	
	@DatabaseField(canBeNull = false)
	private String phone;
	@DatabaseField(canBeNull = false)
	private Timestamp createTime;
	
	@Override
	public String toString() {
		return "Passenger [uuid=" + uuid + ", phone=" + phone + ", createTime="
				+ createTime + "]";
	}

	public Passenger() {
		super();
	}

	public Passenger(String uuid, String phone, Timestamp createTime) {
		super();
		this.uuid = uuid;
		this.phone = phone;
		this.createTime = createTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
