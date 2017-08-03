package cn.com.losy.didi.pojo;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "dd_driver_statu")
public class DriverStatu {
	@DatabaseField(id = true)
	private String uuid;
	@DatabaseField(canBeNull = false)
	private String driverId;
	
	@DatabaseField(canBeNull = true)
	private double longitude;
	@DatabaseField(canBeNull = true)
	private double latitude;
	@DatabaseField(canBeNull = true)
	private Timestamp positionTime;
	@DatabaseField(canBeNull = true)
	private String statu;
	@DatabaseField(canBeNull = true)
	private Timestamp statuTime;
	
	@Override
	public String toString() {
		return "DriverStatu [uuid=" + uuid + ", driverId=" + driverId
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", positionTime=" + positionTime + ", statu=" + statu
				+ ", statuTime=" + statuTime + "]";
	}
	public DriverStatu() {
		super();
	}
	public DriverStatu(String uuid, String driverId, double longitude,
			double latitude, Timestamp positionTime, String statu,
			Timestamp statuTime) {
		super();
		this.uuid = uuid;
		this.driverId = driverId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.positionTime = positionTime;
		this.statu = statu;
		this.statuTime = statuTime;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
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
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Timestamp getStatuTime() {
		return statuTime;
	}
	public void setStatuTime(Timestamp statuTime) {
		this.statuTime = statuTime;
	}
	
	
}
