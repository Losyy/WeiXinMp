package cn.com.losy.didi.pojo;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "dd_passenger_statu")
public class PassengerStatu {
	@DatabaseField(id = true)
	private String uuid;
	@DatabaseField(canBeNull = false)
	private String passengerId;
	
	@DatabaseField(canBeNull = true)
	private double longitude;
	@DatabaseField(canBeNull = true)
	private double latitude;
	@DatabaseField(canBeNull = true)
	private Timestamp positionTime;
	
	@Override
	public String toString() {
		return "PassengerStatu [uuid=" + uuid + ", passengerId=" + passengerId
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", positionTime=" + positionTime + "]";
	}
	public PassengerStatu() {
		super();
	}
	public PassengerStatu(String uuid, String passengerId, double longitude,
			double latitude, Timestamp positionTime) {
		super();
		this.uuid = uuid;
		this.passengerId = passengerId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.positionTime = positionTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Timestamp getPositionTime() {
		return positionTime;
	}
	public void setPositionTime(Timestamp positionTime) {
		this.positionTime = positionTime;
	}
	
	
}
